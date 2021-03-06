package user;

import java.util.*;

public class Profile {
	private String name;
	private String biography;
	private ArrayList<String> websites = new ArrayList<>();
	private String location;
	
	public Profile(String name) {
		this.name = name;
		this.biography = "not defined yet";
		this.location = "not defined";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public ArrayList<String> getWebsites() {
		return websites;
	}

	public void setWebsites(ArrayList<String> websites) {
		this.websites = websites;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public static void editProfile(Person logged){
		int choice;
		boolean condition = true;
		Scanner input = new Scanner(System.in);

		do{
			systemF.View.showEditProfileOptions();
			choice = input.nextInt();
			input.nextLine();

			switch (choice){
				case 1:
                    System.out.println("Enter with new name:");
                    String name = input.nextLine();
					logged.getProfile().setName(name);
					break;
				case 2:
                    System.out.println("Recuro em desenvolvimento");
					break;
				case 3:
                    System.out.println("Enter with new biography:");
                    String biography = input.nextLine();
                    logged.getProfile().setBiography(biography);
					break;
				case 4:
                    System.out.println("What's your country?:");
                    String location = input.nextLine();
                    logged.getProfile().setLocation(location);
					break;
				case 5:
                    System.out.println("Enter with your website:");
                    String website = input.nextLine();
                    logged.getProfile().getWebsites().add(website);
					break;
				case 0:
				    condition = false;
                    break;
			}
		}while(condition);
	}

    public static void printWebsites(ArrayList<String> websites){
        for(String current : websites){
            System.out.println(current);
        }
    }
	
}
