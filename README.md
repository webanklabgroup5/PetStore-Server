# PetStore合约API
## 账户合约

账户管理合约：

|方法/功能|参数列表|用途/返回值|
|:------|:------|:------|
|balanceOf|address _address|uint _balance|
|myBalance|-|查看自己的余额uint balance|
|transfer|address _address, uint _money|转账|
|myAddress|-|查看自己的地址address _address|
|需管理员权限|
|newAccount|address _address, uint _money|创建新用户|
|bonus|address _address, uint _money|给用户发放初始余额|
|_transfer|address _sender, address _from, address _to, uint _money|转账|
|isAdmin|-|判断调用者是否管理员bool|

## 宠物市场合约

宠物(市场)合约：

|方法/功能|参数列表|用途/返回值|
|:------|:------|:------|
|newPet|string _name, uint16 _species, string _bday, string _disc, string _picUrl|新建宠物|
|getMyPets||查看自己的的宠物/uint[] index|
|getPetsForSale||查看所有在售宠物/uint[] index|
|buyPet|uint _petId, string _time|买家购买宠物|
|getMyAddress||查看自己的地址address _address|
|ownerPetCount|address _owner|查看账户宠物数uint count|
|sellingPetCount||查看在售宠物数uint count|
|需宠物主人权限||
|sellPet|uint _petId, uint32 _price, string time|卖家出售(自己的)宠物|
|offSale|uint _petId|卖家下架宠物|
|getPetById1|uint _petId|查看宠物详情(bool selling, uint16 species, uint32 price, string name, string bday)|
|getPetById2|uint _petId|查看宠物详情(string disc, string picUrl, string time, string remark)|
|需管理员权限||
|petOwner|uint _petId|查询宠物主人address _owner|
|setTranContAddr|address _tranContAddr|设置交易合约地址|
|changeOwnership|address _sender, uint _petId, address _newOwner|更改宠物主人|
 
## 交易合约

交易、冲正合约：

|方法/功能|参数列表|用途/返回值|
|:------|:------|:------|
|getMyRecords||查看自己的交易记录 uint[] index|
|需买家权限||
|requestArbitration|uint _recordId, string _reason|申请冲正仲裁|
|getRecordById|uint _recordId|查看交易详情(address buyer, address seller, uint petId, uint price, uint status, string time, string reason)|
|需管理员权限||
|setPetAndAccntContAddr|address _petContAddr, address _AccntContAddr|设置宠物(市场)，账户合约地址|
|getRecordCount||获取所有交易记录uint lenght|
|makePurchase|address _sender, address _buyer, address _seller, uint32 _price, uint _petId, string _time|记录交易|
|getAllArbitrations||查看所有仲裁/冲正的交易uint[] index|
|approveArbitration|uint _recordId|冲正交易|
|denyArbitration|uint _recordId, string _reason|否决冲正|
