pragma solidity ^0.4.25;

contract Account{
    
    address admin;
    
    constructor (){
        admin = msg.sender;
    }
    
    modifier onlyAdmin(address _sender){
        require(_sender == admin, "not admin!");
        _;
    }
    
    mapping(address => uint) balance;
    mapping(address => string) name;

    function transfer(address to, uint money) public {
        require(to != 0x0, "please provide reciever address!");
        _transfer(admin, msg.sender, to, money);
    }
    
    function _transfer(address _sender, address _from, address _to, uint _money) public onlyAdmin(_sender) {
	    require(balance[_from] >= _money, "Not enough money!");
        balance[_from] = balance[_from] - _money;
        balance[_to] = balance[_to] + _money;
    }

    function balanceOf(address _address) public view returns (uint) {
        return balance[_address];
    }

    function bonus(address _address, uint _money) public onlyAdmin(msg.sender) {
        balance[_address] = balance[_address] + _money;
    }
    
    function getAddress() public view returns (address) {
        return msg.sender;
    }
    
    function genAccount() public onlyAdmin(msg.sender) returns(address){
        //to do: 
        //address memory _address = ...
        //accountContract.bonus(msg.sender, _address, 10000);
        //return _address;
        return msg.sender;
    }
}