package User;

import java.util.*;

public class Account {
	private String email;
	private String password;
	private int[] cardNumber = new int[16];
	private String cardHolderName;
	private String expiration; // Mudar para string pedir entrada tipo mes / ano abril 2018, ou deixar assim msm
	private int[] securityCode = new int[3];
	
	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int[] getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int[] cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public int[] getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int[] securityCode) {
		this.securityCode = securityCode;
	}
	
	public static void editAccount(Person logged){
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Edit email\n2. Edit password\n0. Back");
            choice = input.nextInt();

            switch (choice){
                case 1:
                    //Edit email
                    break;
                case 2:
                    //Edit password
                    break;
                default:
                    break;
            }
        }while(choice != 0);
	}

	public static void paymentMethods(Person logged){
	    Scanner input = new Scanner(System.in);
	    int[] cardNumber = new int[16];

        System.out.println("Card number:");
        for(int i = 0; i < 16; i++){
            cardNumber[i] = input.nextInt();
            //Colocar tratamento de exception caso leia um caracter ou ultrapasse tamanho
        }
        logged.getAccount().setCardNumber(cardNumber);

        System.out.println("Cardholder name:");
        String name = input.nextLine();
        logged.getAccount().setCardHolderName(name);

        System.out.println("Expiration: (MM/YY)");
        String expiration = input.nextLine();
        logged.getAccount().setExpiration(expiration);

        System.out.println("Security code:");
        int[] securityCode = new int[3];
        for(int i = 0; i < 3; i++){
            securityCode[i] = input.nextInt();
        }
        logged.getAccount().setSecurityCode(securityCode);
    }

}
