package User;

public class Person {
	private Account account;
	private Profile profile;
	
	public Person(Account account, Profile profile) {
		this.account = account;
		this.profile = profile;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
}
