package menu;
import java.util.*;

import exceptions.InputTreatment;
import systemF.Project;
import systemF.Settings;
import systemF.View;
import user.Entity;
import user.NullPerson;
import user.Person;
import user.Stuff;
public class Main {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<user.Person> users = new ArrayList<>();
	    ArrayList<systemF.Project> projects = new ArrayList<>();
	    menu(users, projects);
	    input.close();
	}

	public static void menu(ArrayList<user.Person> users, ArrayList<systemF.Project> projects){
        
        int choice = 1;

        do {
            System.out.println("1. Sign in\n2. Search\n3. Explore\n0. Exit");
            choice = InputTreatment.inputLimitedInteger(0, 3);

            if (choice == 1) {
                signIn(users, projects);
            } else if (choice == 2) {
                Project.search(null, projects);
            } else if (choice == 3) {
                Project.explore(null, projects);
            }
        }while(choice != 0);
    }

    public static void signIn(ArrayList<user.Person> users, ArrayList<systemF.Project> projects){
       
	    Entity logged;
	    int choice = 1;
	    do {
	    	systemF.View.showSignInOptions();
	    	choice = InputTreatment.inputLimitedInteger(0, 2);
	    	switch (choice) {
			case 1:
				logged = login(users);
				logged.acessLoggedMenu(logged, users, projects);
				break;
			case 2:
				logged = Person.createAccount(users);
				logged.acessLoggedMenu(logged, users, projects);
				break;
			default:
				break;
			}
	    	
		} while (choice != 0);
    }
    public static Entity login(ArrayList<user.Person> users){
        System.out.println("Email:");
        String email = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();
        int i;
        for(i = 0; i < users.size(); i++){ 
            if(users.get(i).getAccount().getEmail().equals(email)){
            	if(users.get(i).getAccount().getPassword().equals(password)){
            		System.out.println("Welcome " + users.get(i).getProfile().getName());
            		return users.get(i);
	            } 
            } 
        }
        return new NullPerson();
    }

    public static void menuLogged(Person logged, ArrayList<user.Person> users, ArrayList<systemF.Project> projects){
        int choice;

        do{
            View.showMenuLogged();
            choice = InputTreatment.inputLimitedInteger(0, 5);;

            switch (choice){
                case 1:
                    Project.explore(logged, projects);
                    break;
                case 2:
                    Project.search(logged, projects);
                    break;
                case 3:
                    Project.starterProject(logged, projects, users);
                    break;
                case 4:
                    Stuff.myStuff(logged, users);
                    break;
                case 5:
                    Settings.editSettings(logged);
                    break;
                default:
                    break;
            }
        }while(choice != 0);
    }
}
