package pt.ulisboa.tecnico.learnjava.sibs.cli;

import java.util.Random;
import pt.ulisboa.tecnico.learnjava.bank.services.Services;

public class associateMBWAYController {
	private int code;

	public void associateMBWAY (String iban, String phoneNumber, Services service) {
		this.code = generateCode();
		if(service.verifyPhoneNumber(iban, phoneNumber) == true) {
			service.getAccountByIban(iban).getClient().setMbayCode(this.code);
			MBWAY.datebase.put(phoneNumber, iban);
			System.out.println("Code: " + this.code + " (don�t share it with anyone)");
		} else {
			System.out.println("Wrong phone number!");
		}
	}
	
	public int generateCode() {
		Random rand = new Random();
		int code = 100000 + rand.nextInt(899999); 
		return code;
	}
	
	public int getCode() {
		return this.code;
	}
	
}
