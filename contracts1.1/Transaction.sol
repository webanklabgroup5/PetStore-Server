pragma solidity ^0.4.25;

contract Account{
    function _transfer(address _sender, address _from, address _to, uint _money) external;
}

contract PetMarket{
    function getPetById(uint _petId) external view returns(
        bool saling,//status
        //uint ID;
        uint16 species,
        uint32 price,
        string name,
        string bday,
        string disc,
        string picUrl
    );
    function changeOwnership(address _sender, uint _petId, address _newOwner) external;
}

contract Transaction{

    struct Record{
        address buyer;
        address seller;
        uint petId;
        uint price;
        uint status; //0 for normal, 1 for arbitrating, 20 for arbitrated fail, 21 for arbitrated success
    }
    
    Record[] records;
    mapping(address => uint) myRecordCount;
    
    address admin;
    uint arbitCount;
    
    constructor (){
        admin = msg.sender;
    }
    
    modifier onlyAdmin(address _sender){
        require(_sender == admin);
        _;
    }
    
    PetMarket petContract;
    Account accountContract;
    
    function setPetAndAccntContAddr(address _petContract, address _accountContract) public onlyAdmin(msg.sender) {
        petContract = PetMarket(_petContract);
        accountContract = Account(_accountContract);
    }
    
    function getRecordCount() public view returns(uint){
        require(msg.sender == admin);
        return records.length;
    } 
    
    function makePurchase(address _sender, address _buyer, address _seller,
                            uint32 _price, uint _petId) external onlyAdmin(_sender) {
        require(_sender == admin, "not admin!");
        //uint _price;
        //(, , _price, , , , ) = petContract.getPetById(_petId);
        accountContract._transfer(_sender, _buyer, _seller, _price);
        records.push(Record(_buyer, _seller, _petId, _price, 0));
        myRecordCount[_buyer]++;
        myRecordCount[_seller]++;
    }
    
    function getMyRecords() public view returns (uint[]){
        uint[] memory myRecord = new uint[](myRecordCount[msg.sender]);
        uint count = 0;
        for(uint i = 0; i < records.length; i++){
            if(records[i].buyer == msg.sender||records[i].seller == msg.sender){
                myRecord[count] = i;
                count++;
            }
        }
        return myRecord;
    }

    function getRecordById(uint _recordId) public view returns (
                address buyer, 
                address seller,
                uint petId,
                uint price,
                uint status){
        return (records[_recordId].buyer,
		        records[_recordId].seller,
		        records[_recordId].petId,
		        records[_recordId].price,
		        records[_recordId].status);
    }
    
    function requestArbitration(uint _recordId) public {
        require(msg.sender == records[_recordId].buyer);
        require(records[_recordId].status == 0);
        records[_recordId].status = 1;
        arbitCount++;
    }
    
    function getAllArbitrations() public view onlyAdmin(msg.sender) returns (uint[]) {
        uint[] memory allArbit = new uint[](arbitCount);
        uint count = 0;
        for(uint i = 0; i < records.length; i++){
            if(records[i].status > 0){
                allArbit[count] = i;
                count++;
            }
        }
        return allArbit;
    }
    
    function approveArbitration(uint _recordId) public onlyAdmin(msg.sender) {
        address _buyer = records[_recordId].buyer;
        address _seller = records[_recordId].seller;
        uint _price = records[_recordId].price;
        uint _petId = records[_recordId].petId;
        accountContract._transfer(admin, _seller, _buyer, _price);
        petContract.changeOwnership(admin, _petId, _seller);
        records[_recordId].status = 21;
        arbitCount--;
    }
    
    function denyArbitration(uint _recordId) public onlyAdmin(msg.sender) {
        records[_recordId].status = 20;
        arbitCount--;
    }
}