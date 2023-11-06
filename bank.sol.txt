// SPDX-License-Identifier: MIT
pragma solidity ^0.8.18;

contract Bank{
    int balance;
    constructor() public {
        balance=0;
    }

    function withdraw(int amount) public{
        if (balance>amount)
        {
            balance = balance - amount;
        }
       
        
    }
    function bal()  public view returns(int) {
        return balance;
    }
    function deposit(int amount) public{
        balance = balance+amount;
    }

}
