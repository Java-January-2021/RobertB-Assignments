import java.util.*;
public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingBalance;
	private static int numberOfAccounts = 0;
	private static double amountOfMoneyStored = 0;
	private double userCheckingBalance = 0;
	private double userSavingBalance = 0;
	
	public double totalAccountBalance() {
		double total = this.checkingBalance + this.savingBalance;
		return total;
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public String setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
		return "";
	}
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public double getSavingBalance() {
		return this.savingBalance;
	}
	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}
	public String createAccountNum() {
		String randNum = "";
		Random rand = new Random();
		System.out.println(randNum);
		for(int i = 0; i < 10; i++) {
			randNum += rand.nextInt(10);
		}
		return randNum;
	}
	public BankAccount(){
		this.accountNumber = createAccountNum();
		this.checkingBalance = userCheckingBalance;
		this.savingBalance = userSavingBalance;
		numberOfAccounts++;
	}
	public void deposit(double amount, String type){
		if(type.equals("checking")) {
			this.checkingBalance += amount;
			amountOfMoneyStored += amount;
			System.out.println("You have deposited " + amount + " into your " + type + " into account number " + getAccountNumber() + " Your new total is " + this.checkingBalance + " total amount stored in account is " + totalAccountBalance());
		}
		else if(type.equals("savings")) {
			this.savingBalance += amount;
			amountOfMoneyStored += amount;
			System.out.println("You have deposited " + amount + " into your " + type + " into account number " + getAccountNumber() + " Your new total is " + this.savingBalance + " total amount stored in account is " + totalAccountBalance());
		}
	}
	public void withdrawl(double amount, String type) {
		if(type.equals("checking")) {
			if(this.checkingBalance >= amount ) {
			this.checkingBalance += amount;
			amountOfMoneyStored += amount;
			System.out.println("You have deposited " + amount + " into your " + type + " into account number " + getAccountNumber() + " Your new total is " + this.checkingBalance + " total amount stored in account is " + totalAccountBalance());
			}
			else {
				System.out.println("You have insufficent funds. Can not pull out " + amount + " from " + type + ". You only have " + this.checkingBalance + ".");
			}
		}
		else if(type.equals("savings")) {
			if(this.savingBalance >= amount ) {
				this.savingBalance += amount;
				amountOfMoneyStored += amount;
				System.out.println("You have deposited " + amount + " into your " + type + " into account number " + getAccountNumber() + " Your new total is " + this.checkingBalance + " total amount stored in account is " + totalAccountBalance());
				}
				else {
					System.out.println("You have insufficent funds. Can not pull out " + amount + " from " + type + ". You only have " + this.savingBalance + ".");
					
				}
		}
	}
	public void accountBalance(String type) {
		if(type.equals("checking")) {
			System.out.println("Your current balance in your " + type + " is " + this.checkingBalance);
		}
		else if(type.equals("savings")) {
			System.out.println("Your current balance in your " + type + " is " + this.savingBalance);
		}
	}
}
	
