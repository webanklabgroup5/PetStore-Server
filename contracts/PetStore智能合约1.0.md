# PetStore 智能合约1.0

[Account.sol](Account.sol)——账户合约

账户管理合约，包括：

|方法/数据结构|解释|
|:------|:------|
|mapping|用户地址到名字，余额的映射|
|transfer , _transfer|转账|
|balanceOf|查询余额|
|genAccount|暂时未写|
|bonus|津贴，用于管理员给用户分配初始余额|

[PetMarket.sol](PetMarket.sol)——宠物市场合约

宠物(市场)合约，包括：

|方法/数据结构|解释|
|:------|:------|
|Pet[] pets|所有用户上传的宠物，这里用Pet中的bool saling区分是否上架|
|mapping(uint => address) petToOwner|这里使用mapping来记录宠物的持有者，而不是直接把宠物放到账户下，因为数据默认放在storage，频繁买卖修改storage(删除某账户下的某只宠物，放到另一个账户下)开销大|
|viewMyPets, viewAllPetsForSale + getPetById|前两个需配合第三个使用，因为solidity不支持返回结构数组（这点有些蛋疼）。查看自己的宠物，查看所有在售的宠物。mapping(address => uint) ownerPetCount辅助这几个功能的完成|
|setTranContAddr|设置交易合约地址，在购买宠物时需进入交易合约|
|buyPet|购买宠物|
|changeOwnership|修改宠物持有者，后面冲正会用到|
 
[Transaction.sol](Transaction.sol)——交易合约

交易、冲正合约，包括：

|方法/数据结构|解释|
|:------|:------|
|Record[] records|交易记录，可供用户查看，为后面仲裁、冲正提供服务，mapping(address => uint) buyerRecordCount 辅助|
|set|设置宠物市场合约，账户合约地址|
|makePurchase|其实改成recordTransaction记录交易更好，在宠物市场合约进入，调用账户合约完成交易，返回宠物市场修改宠物持有者和持有者的宠物数量(这里也可以选择调用宠物市场合约的接口，但是鉴于麻烦没有选择该方法)|
|getMyRecord + getRecordById|完成查看交易记录(getMyRecord只写了购买者，所以暂时只有购买者能看到交易记录。后面添加出售者能看到records[i].seller == msg.sender, 管理员能看到所有的：再写一个方法好了)|
|request Arbitration|申请冲裁，只有购买者可以暂时|
|approve/deny Arbitration|冲正交易/否决冲正，只有管理员有该权限|


