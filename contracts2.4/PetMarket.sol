pragma solidity ^0.4.25;

import "./ParallelContract.sol";

contract Transaction is ParallelContract{
    function makePurchase(address _sender, address _buyer, address _seller, uint32 _price, uint _petId, string _time) external;
}

contract PetMarket is ParallelContract{
    
    struct Pet{
        bool selling;
        uint16 species;
        uint32 price;
        string name;
        string bday;
        string disc;
        string picUrl;
        string time;
        string remark;
    }
    
    Pet[] pets;
    
    mapping(uint => address) petToOwner;
    
    address admin;
    constructor(){
        admin = msg.sender;
    }
    
    function petOwner(address _sender, uint _petId) public view returns (address){
        require(_sender == admin, "require admin permission!");
        return petToOwner[_petId];
    }

	function petCount() public view returns(uint) {
		require(msg.sender == admin, "require admin permission");
		return pets.length;
	}

	
    
    function newPet(string _name, uint16 _species, string _bday, 
                    string _disc, string _picUrl) public {
        uint _id = pets.push(Pet(false, _species, 0, _name, _bday, _disc, _picUrl, "", "")) - 1;
        petToOwner[_id] = msg.sender;
    }
    
    function sellPet(uint _petId, uint32 _price, string _time, string _remark) public  {
        require(petToOwner[_petId] == msg.sender, "require pet owner permission!");
        require(!pets[_petId].selling, "pet is for sale! please put off sale first.");
        pets[_petId].price = _price;
        pets[_petId].selling = true;
        pets[_petId].time = _time;
        pets[_petId].remark = _remark;
    }
    
    function offSale(uint _petId) public {
        require(petToOwner[_petId] == msg.sender || msg.sender == admin, "require pet owner or admin permission!");
        require(pets[_petId].selling, "pet not for sale now!");
        pets[_petId].selling = false;
        pets[_petId].remark = "";
        //salingPetCount--;
    }
    
    function ownerPetCount(address _owner) public view returns (uint) {
        uint count = 0;
        for(uint i = 0; i < pets.length; i++){
            if(petToOwner[i] == _owner){
                count++;
            }
        }
        return count;
    }
    
    function getMyPets() public view returns (uint[]) {
        uint[] memory myPets = new uint[](ownerPetCount(msg.sender));
        uint count = 0;
        for(uint i = 0; i < pets.length; i++){
            if(petToOwner[i] == msg.sender){
                myPets[count] = i;
                count++;
            }
        }
        return myPets;
    }
    
    function sellingPetCount() public view returns (uint) {
        uint count = 0;
        for(uint i = 0; i < pets.length; i++){
            if(pets[i].selling){
                count++;
            }
        }
        return count;
    }
    
    function getPetsForSale() public view returns (uint[]){
        uint[] memory petsForSale = new uint[](sellingPetCount());
        uint count = 0;
        for(uint i = 0; i < pets.length; i++){
            if(pets[i].selling){
                petsForSale[count] = i;
                count++;
            }
        }
        return petsForSale;
    }
    
    function getAddress() public view returns (address) {
        return msg.sender;
    }

    Transaction transactionContract;
    
    function setTranContAddr(address _transactionContract) public {
        require(msg.sender == admin, "require admin permission!");
        transactionContract = Transaction(_transactionContract);
    }
    
    function buyPet(uint _petId, string _time) public {
        address _buyer = msg.sender;
        address _seller = petToOwner[_petId];
        
        //write a transaction record
        transactionContract.makePurchase(admin, _buyer, _seller, pets[_petId].price, _petId, _time);
        
        petToOwner[_petId] = _buyer;
        pets[_petId].selling = false;
    }
    
    function changeOwnership(uint _petId,address _sender, address _newOwner) public {
        //other contract call, not msg.sender
        //msg.sender is not transitive
        require(_sender == admin, "require admin permission!");
        petToOwner[_petId] = _newOwner;
    }

    function getPetById1(uint _petId) external view returns (
                bool selling,//status
                uint16 species,
                uint price,
                string name,
                string bday
                ){
        require(pets[_petId].selling || msg.sender == petToOwner[_petId] || msg.sender == admin, "no owner or admin permission!");
        return (pets[_petId].selling,
                pets[_petId].species,
                pets[_petId].price,
                pets[_petId].name,
                pets[_petId].bday);
    }
    
    function getPetById2(uint _petId) external view returns (
                string disc,
                string picUrl,
                string time,
                string remark
                ){
        require(pets[_petId].selling || msg.sender == petToOwner[_petId] || msg.sender == admin, "no owner or admin permission!");
        return (pets[_petId].disc,
                pets[_petId].picUrl,
                pets[_petId].time,
                pets[_petId].remark);
    }
   
    function enableParallel() public
	{
		//Enable some Function to be parallel
		registerParallelFunction("sellPet(uint256,uint256,string,string)",1);
		registerParallelFunction("offSale(uint256)",1);
		registerParallelFunction("changeOwnership(uint256,address,address)",2);
	}

	function disableParallel() public
	{
		//Disable above mentioned functions not to be parallel
		unregisterParallelFunction("sellPet(uint256,uint256,string,string)");
		unregisterParallelFunction("offSale(uint256)");
		unregisterParallelFunction("changeOwnership(uint256,address,address)");
	}
    
}
