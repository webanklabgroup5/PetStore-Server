pragma solidity ^0.4.25;

import "./ParallelContract.sol";

contract Account is ParallelContract{
    
    address admin;
    
    address[] account;
    
    constructor (){
        admin = msg.sender;
    }
    
    modifier onlyAdmin(address _sender){
        require(_sender == admin, "require admin permission!");
        _;
    }

    mapping(address => uint) balance;

    function transfer(address to, uint money) public {
        require(to != 0x0, "please provide reciever address!");
        _transfer(admin, msg.sender, to, money);
    }
    
    function _transfer(address _sender, address _from, address _to, uint _money) public onlyAdmin(_sender) {
        require(balance[_from] >= _money, "not enough money!");
        balance[_from] = balance[_from] - _money;
        balance[_to] = balance[_to] + _money;
    }
    
    function newAccount(address _address, uint256 _money) public onlyAdmin(msg.sender){
        balance[_address] = _money;
    }

    function balanceOf(address _address) public view returns (uint) {
        return balance[_address];
    }

    function bonus(address _address, uint _money) public onlyAdmin(msg.sender) {
        balance[_address] = balance[_address] + _money;
    }
    
    function isAdmin() public returns (bool) {
        return (admin == msg.sender);
    }
    
    function myBalance() public view returns(uint) {
        return balance[msg.sender];
    }
    
    function myAddress() public view returns(address) {
        return msg.sender;
    }
    
    function enableParallel() public
	{
		//Enable functions
		registerParallelFunction("_transfer(address,address,address,uint256)", 3);
		registerParallelFunction("bonus(address,uint256)",1);
		registerParallelFunction("newAccount(address, uint256)",1);
		
	}

	function disableParallel() public
	{
		//Disable Functions
		unregisterParallelFunction("_transfer(address,address,address,uint256)");
        unregisterParallelFunction("bonus(address,uint256)");
        unregisterParallelFunction("newAccount(address, uint256)");
        
	}
}
