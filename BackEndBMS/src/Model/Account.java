package Model;

public class Account {

	String owner;
	char account;
	double balance;
	
	Account(String owner, char account, double balance){
		
		this.owner = owner;
		this.account = account; 
		this.balance = balance; 
		
	}
	
	Account(String owner, char account){
		
		this.owner = owner;
		this.account = account; 
		this.balance = 0.0; 
		
	}
	
	double getBalance () {
		
		return balance;
		
	}
	
	String getDescription () {
		String description = ""; 
		
		if (account == 'i') {
			description = "International account with owner " + owner + " has current balance $" + balance; 
		}
		else if(account == 'd') {
			description = "Domestic account with owner " + owner + " has current balance $" + balance; 
		}
		
		return description;
	}
	
	void setBalance (double newBalance) {
		
		this.balance = newBalance;
		
	}
	
	double deposit (double amount) {
		
		if(account == 'i') {
			this.balance = this.balance + amount*0.90;
		}
		else {
			this.balance = this.balance + amount;
		}
		
		return balance;
	}
	
	double withdraw (double amount) {
		
		if(account == 'i') {
			this.balance = this.balance - amount * 1.10;
		}
		else {
			this.balance = this.balance - amount;
		}
		
		return balance;
	}
	
	void transferTo (Account other, double amountTransferred) {
		if(this.account == 'i' && other.account == 'd') {
			this.balance = this.balance - amountTransferred*1.10;
			other.balance = other.balance + amountTransferred;	
		}
		else if(this.account == 'i' && other.account == 'i') {
			
			this.balance = this.balance - amountTransferred*1.10;
			other.balance = other.balance + amountTransferred*0.90;	
			
		}
		else if(this.account == 'd' && other.account == 'i') {
			
			this.balance = this.balance - amountTransferred;
			other.balance = other.balance + amountTransferred*0.90;
			
		}
		else if(this.account == 'd' && other.account == 'd') {
			
			this.balance = this.balance - amountTransferred;
			other.balance = other.balance + amountTransferred;
			
		}
		
		
	}
	
}
