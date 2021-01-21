
public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount user1 = new BankAccount();
		user1.deposit(250, "checking");
		user1.deposit(350, "savings");
		user1.withdrawl(500, "savings");
		user1.accountBalance("checking");
	}

}
