package User;

public class Account {
	private String email;
	private String password;
	private int[] cardNumber = new int[16];
	private String cardHolderName;
	private int[] expiration = new int[4]; // Mudar para string pedir entrada tipo mes / ano abril 2018, ou deixar assim msm
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

	public int[] getExpiration() {
		return expiration;
	}

	public void setExpiration(int[] expiration) {
		this.expiration = expiration;
	}

	public int[] getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int[] securityCode) {
		this.securityCode = securityCode;
	}
	
	

}
