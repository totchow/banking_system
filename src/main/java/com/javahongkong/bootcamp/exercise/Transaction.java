package com.javahongkong.bootcamp.exercise;

public class Transaction implements TransactionInterface{
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *                      The bank where the account is housed.
	 * @param accountNumber
	 *                      The customer's account number.
	 * @param attemptedPin
	 *                      The PIN entered by the customer.
	 * @throws Exception
	 *                   Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		// complete the function
			if (bank.authenticateUser(accountNumber, attemptedPin) == false)
			throw new Exception();
		
			this.bank = bank;
			this.accountNumber = accountNumber;
	}

	public double getBalance() {
		// complete the function
		return this.bank.getBalance(accountNumber);
	}

	public void credit(double amount) {
		Account account = this.bank.getAccount(accountNumber);
		account.creditAccount(amount);
		// complete the function
	}

	public boolean debit(double amount) {
		// complete the function
		Account account = this.bank.getAccount(accountNumber);
		if (account.debitAccount(amount))
			return true;
		else 
			return false;
	}
}
