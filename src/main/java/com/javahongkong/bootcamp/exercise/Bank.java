package com.javahongkong.bootcamp.exercise;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Bank {
	private LinkedHashMap<Long, Account> accounts; // object reference

	private static Long accnum = 0l;

	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		accnum++;
		accounts.put(accnum, new CommercialAccount(company, accnum, pin, startingDeposit));
		return accnum;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		accnum++;
		accounts.put(accnum, new ConsumerAccount(person, accnum, pin, startingDeposit));
		return accnum;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		Account account = this.getAccount(accountNumber);

		if (pin == account.getPin())
		return true;
		else 
		return false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		Account account = this.getAccount(accountNumber);
		return account.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account account = this.getAccount(accountNumber);
		account.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		Account account = this.getAccount(accountNumber);
		if (account.debitAccount(amount))
			return true;
		else
			return false;
	}
}
