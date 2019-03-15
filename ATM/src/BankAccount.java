import java.util.ArrayList;

public class BankAccount {
	private String name;
	private long cardNumber;
	private double balance = 0;
	ArrayList<String> history = new ArrayList<String>(5);
	int i= -1;
	
	BankAccount(String myName, long myCardNumber){
		balance = 0;
	}
	BankAccount(String myName, long myCardNumber, double myBalance){
		name = myName;
		cardNumber = myCardNumber;
		balance = myBalance;
	}
	
	public void setName(String myName) {
		name = myName;
	}
	public void setCardNumber(int myCardNumber) {
		cardNumber = myCardNumber;
	}
	
	public String getName() {
		return name;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double balanceInquiry() {
		history.add("Balance Inquiry: " + balance);
		return balance;
	}
	
	public void deposit (double deposited) {
		balance+= deposited;
		history.add("Deposite: " + deposited);
	}
	public void withdraw(double withdrawn) {
		if (balance > withdrawn) {
			balance-= withdrawn;
			history.add("Withdraw: " + withdrawn);
		}

	}
	
	public ArrayList<String> getTransactionHistory() {
		while (history.size() > 5)
			history.remove(0);
		return history;
	}

	public String nextHistory() {
		if (i >= 4)
			i=4;
		else 
			i++;
		if (i > getTransactionHistory().size() - 1)
			i = getTransactionHistory().size()-1;
		return getTransactionHistory().get(i);
		
	}
	
	public String previousHistory() {
		if (i <= 0)
			i=0;
			
		else 
			i-- ;
		return getTransactionHistory().get(i);
		
			
		
	}
	public boolean validate(String testUsername, String testCardNumber) {
		boolean result = false;
		if ( (testUsername.equals(name)) && (testCardNumber.equals(Long.toString(cardNumber))) )
			result = true;
		return result;
	}
}
