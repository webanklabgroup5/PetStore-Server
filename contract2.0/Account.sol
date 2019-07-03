pragma solidity ^0.4.25;

import "./ParallelContract.sol";

contract Account is ParallelContract {
    
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

    function transfer(address to, uint256 money) public {
        require(to != 0x0, "please provide reciever address!");
        _transfer(msg.sender, to,admin, money);
    }
    
    function _transfer(address _from, address _to,address _sender, uint256 _money) public onlyAdmin(_sender) {
        require(balance[_from] >= _money, "Not enough money!");
        balance[_from] = balance[_from] - _money;
        balance[_to] = balance[_to] + _money;
    }

    function balanceOf(address _address) public view returns (uint) {
        return balance[_address];
    }

    function bonus(address _address, uint256 _money) public onlyAdmin(msg.sender) {
        balance[_address] = balance[_address] + _money;
    }
    
    function isAdmin() public returns (bool) {
        return (admin == msg.sender);
    }
    
    function setName(address _address, string _name) public onlyAdmin(msg.sender){
        name[_address] = _name;
    }
    
    function getName(address _address) public view returns(string) {
        return name[_address];
    }
    
    function myName() public view returns(string) {
        return name[msg.sender];
    }
    
    function myBalance() public view returns(uint) {
        return balance[msg.sender];
    }
    
    function myAddress() public view returns(address) {
        return msg.sender;
    }
    
    function setMyName(string _name) public {
        name[msg.sender] = _name;
    } 
    
    function getMyName() public view returns(string) {
        return name[msg.sender];
    }

	function enableParallel() public
	{
		//Enable functions
		registerParallelFunction("_transfer(address,address,address,uint256)", 3);
		registerParallelFunction("bonus(address,uint256)",1);
		registerParallelFunction("setName(address,string)",1);
		registerParallelFunction("setMyName(address,string)",1);
	}

	function disableParallel() public
	{
		//Disable Functions
		unregisterParallelFunction("_transfer(address,address,address,uint256)");
                unregisterParallelFunction("bonus(address,uint256)");
                unregisterParallelFunction("setName(address,string)");
                unregisterParallelFunction("setMyName(address,string)");
	}

}
