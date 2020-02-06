package pt.ulisboa.tecnico.learnjava.bank.domain;

public class IDCard {
	
	private final String firstName;
	private final String lastName;
	private final String nif;
	private int age;

	public IDCard(String firstName, String lastName, String nif, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nif = nif;
		this.age = age;
	}

}
