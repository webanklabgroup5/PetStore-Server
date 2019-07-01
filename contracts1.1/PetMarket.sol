pragma solidity ^0.4.25;

contract Transaction{
    function makePurchase(address _sender, address _buyer, address _seller, uint _price, uint _petId) external;
}

contract PetMarket{
    
    struct Pet{
        bool saling;//status
        //uint ID;
        uint16 species;
        uint32 price;
        string name;
        string bday;
        string disc;
        string picUrl;
    }
    
    Pet[] pets;
    
    mapping(uint => address) petToOwner;
    mapping(address => uint) ownerPetCount;
    uint salingPetCount = 0;

    modifier petOwner(address _address, uint _petId){
        require(petToOwner[_petId] == _address, "you can not sell others pet!");
        _;
    }
    
    function newPet(string _name, uint16 _species, string _bday, 
                    string _disc, string _picUrl) public {
        uint _id = pets.push(Pet(false, _species, 0, _name, _bday, _disc, _picUrl)) - 1;
        petToOwner[_id] = msg.sender;
        ownerPetCount[msg.sender]++;
    }
    
    function sellPet(uint _petId, uint32 _price) public petOwner(msg.sender, _petId) {
        //require(petToOwner[_petId] == _address);
        require(!pets[_petId].saling, "pet is for sale! please put off sale first.");
        pets[_petId].price = _price;
        pets[_petId].saling = true;
        salingPetCount++;
    }
    
    function offSale(uint _petId) public petOwner(msg.sender, _petId){
        require(pets[_petId].saling, "pet not for sale!");
        pets[_petId].saling = false;
    }
    
    function getMyPets() public view returns (uint[]){
        uint[] memory myPets = new uint[](ownerPetCount[msg.sender]);
        uint count = 0;
        for(uint i = 0; i < pets.length; i++){
            if(petToOwner[i] == msg.sender){
                myPets[count] = i;
                count++;
            }
        }
        return myPets;
    }
    
    function getPetsForSale() public view returns (uint[]){
        uint[] memory petsForSale = new uint[](salingPetCount);
        uint count = 0;
        for(uint i = 0; i < pets.length; i++){
            if(pets[i].saling){
                petsForSale[count] = i;
                count++;
            }
        }
        return petsForSale;
    }
    
    function getSalingPetCounts() public view returns (uint){
        require(msg.sender == admin);
        return salingPetCount;
    }

    function getAddress() public view returns (address) {
        return msg.sender;
    }

    Transaction transactionContract;
    address admin;
    
    constructor (){
        admin = msg.sender;
    }
    
    function setTranContAddr(address _transactionContract) public {
        require(msg.sender == admin);
        transactionContract = Transaction(_transactionContract);
    }
    
    function buyPet(uint _petId) public {
        address _buyer = msg.sender;
        address _seller = petToOwner[_petId];
        
        //write a transaction record
        transactionContract.makePurchase(admin, _buyer, _seller, pets[_petId].price, _petId);
        
        petToOwner[_petId] = _buyer;
        ownerPetCount[_buyer]++;
        ownerPetCount[_seller]--;
        pets[_petId].saling = false;
        salingPetCount--;
    }
    
    function changeOwnership(address _sender, uint _petId, address _newOwner) public {
        //other contract call, not msg.sender
        //msg.sender is not transitive
        require(_sender == admin);
        ownerPetCount[petToOwner[_petId]]--;
        ownerPetCount[_newOwner]++;
        petToOwner[_petId] = _newOwner;
    }

    function getPetById(uint _petId) external view returns (
                bool saling,//status
                //uint ID;
                uint16 species,
                uint32 price,
                string name,
                string bday,
                string disc,
                string picUrl){
        return (pets[_petId].saling,
                pets[_petId].species,
                pets[_petId].price,
                pets[_petId].name,
                pets[_petId].bday,
                pets[_petId].disc,
                pets[_petId].picUrl);
    }
    
}