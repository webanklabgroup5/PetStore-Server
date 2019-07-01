# PetStore 智能合约1.1

[Account.sol](Account.sol)——账户合约

账户管理合约：

|方法/数据结构|解释|
|:------|:------|
|新增|......|
|isAdmin|是否管理员|
|set, get Name|设置和查看用户名|
|删除|......|
|genAccount|暂时未写|

[PetMarket.sol](PetMarket.sol)——宠物市场合约

宠物(市场)合约：

|方法/数据(结构)|解释|
|:------|:------|
|修改|......|
|Pet数据结构|宠物品类由string改成uint16,价格由uint改成uint32|
|viewMyPets, viewAllPetsForSale|方法名改成getMyPets, getPetsForSale|
|新增|......|
|offSale|宠物下架|
 
[Transaction.sol](Transaction.sol)——交易合约

交易、冲正合约：

|方法/数据(结构)|解释|
|:------|:------|
|Record -- status|0-正常交易，1-仲裁中，20-仲裁失败，21-冲正成功|
|新增|......|
|arbitCount|仲裁交易数量|
|getAllArbitrations|查看所有仲裁交易|
|修改|......|
|set|setPetAndAccntContAddr|


