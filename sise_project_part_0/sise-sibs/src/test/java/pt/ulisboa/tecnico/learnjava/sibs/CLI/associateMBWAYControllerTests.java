package pt.ulisboa.tecnico.learnjava.sibs.CLI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.domain.Bank;
import pt.ulisboa.tecnico.learnjava.bank.domain.Client;
import pt.ulisboa.tecnico.learnjava.bank.domain.Bank.AccountType;
import pt.ulisboa.tecnico.learnjava.bank.exceptions.AccountException;
import pt.ulisboa.tecnico.learnjava.bank.exceptions.BankException;
import pt.ulisboa.tecnico.learnjava.bank.exceptions.ClientException;
import pt.ulisboa.tecnico.learnjava.bank.services.Services;
import pt.ulisboa.tecnico.learnjava.sibs.cli.associateMBWAYController;
import pt.ulisboa.tecnico.learnjava.sibs.domain.Sibs;

public class associateMBWAYControllerTests {
	private static final String ADDRESS = "Ave.";
	private static final String PHONE_NUMBER = "987654321";
	private static final String NIF = "123456789";
	private static final String LAST_NAME = "Silva";
	private static final String FIRST_NAME = "António";

	private Bank bank;
	private Client client;
	private Services services;
	private associateMBWAYController ac;
	
	@Before
	public void setUp() throws BankException, AccountException, ClientException {
		this.ac = new associateMBWAYController();
		this.services = new Services();
		this.bank = new Bank("CGD");
		this.client = new Client(this.bank, FIRST_NAME, LAST_NAME, NIF, PHONE_NUMBER, ADDRESS, 33);
		
	}
	
	@Test
	public void successAssociateMBWAY() throws BankException, AccountException, ClientException {
		this.bank.createAccount(AccountType.CHECKING, client, 1000, 0);
		assertTrue(services.verifyPhoneNumber("CGDCK1", PHONE_NUMBER));
		this.ac.associateMBWAY("CGDCK1", PHONE_NUMBER, this.services);
		assertEquals(this.ac.getCode(), client.getMbayCode());
	}

}
