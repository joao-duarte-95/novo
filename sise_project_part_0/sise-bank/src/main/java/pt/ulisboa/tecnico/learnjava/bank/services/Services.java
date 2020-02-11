package pt.ulisboa.tecnico.learnjava.bank.services;

import pt.ulisboa.tecnico.learnjava.bank.domain.Account;
import pt.ulisboa.tecnico.learnjava.bank.domain.Bank;
import pt.ulisboa.tecnico.learnjava.bank.exceptions.AccountException;

public class Services {
	public void deposit(String iban, int amount) throws AccountException {
		Account account = getAccountByIban(iban);

		account.deposit(amount);
	}

	public void withdraw(String iban, int amount) throws AccountException {
		Account account = getAccountByIban(iban);

		account.withdraw(amount);
	}

	public Account getAccountByIban(String iban) {
		String code = iban.substring(0, 3);
		String accountId = iban.substring(3);

		Bank bank = Bank.getBankByCode(code);
		Account account = bank.getAccountByAccountId(accountId);

		return account;
	}
	
	public  boolean accountValidation(String sourceIban, String targetIban){
		if (getAccountByIban(sourceIban) == null || getAccountByIban(targetIban) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public  boolean equalBankValidation(String sourceIban, String targetIban){
		if(! sourceIban.substring(0, 3).equals(targetIban.substring(0, 3))) {
			return false;
		} else {
			return true;
		}
	}
	public  boolean verifyPhoneNumber(String iban, String phoneNumber){
		if(!getAccountByIban(iban).getClient().getPhoneNumber().equals(phoneNumber)) {
			return false;
		} else {
			return true;
		}
	}
	
	
}
