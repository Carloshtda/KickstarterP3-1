import java.util.*;
public class Main {

	public static void main(String[] args) {
		ArrayList<User.Person> users = new ArrayList<>();
	    ArrayList<SystemF.Project> projects = new ArrayList<>();
	    menu(users, projects);
	}

	public static void menu(ArrayList<User.Person> users, ArrayList<SystemF.Project> projects){
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Sign in\n2. Search\n3. Explore\n0. Exit");
            choice = input.nextInt();

            if (choice == 1) {
                signIn(users, projects);
            } else if (choice == 2) {
                //Search
            } else if (choice == 3) {
                //Explore
            }
        }while(choice != 0);
    }

    public static void signIn(ArrayList<User.Person> users, ArrayList<SystemF.Project> projects){
        Scanner input = new Scanner(System.in);
	    User.Person logged;

	    SystemF.View.showSignInOptions();
	    int choice = input.nextInt();

        if(choice == 1){
            logged = login(users);
        } else {
            logged = User.Person.createAccount(users);
        }
        logged = menuLogged(logged, users, projects);
    }

    public static User.Person login(ArrayList<User.Person> users){
        Scanner input = new Scanner(System.in);
        System.out.println("Email:");
        String email = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();

        for(User.Person current : users){
            if(current.getAccount().getEmail().equals(email)){
                if(current.getAccount().getPassword().equals(password)){
                    return current;
                } else {
                    System.out.println("The email address and password you entered do not match.");
                    break;
                }

            } else {
                System.out.println("The email address and password you entered do not match.");
                break;
            }
        }
        return null;
    }

    public static User.Person menuLogged(User.Person logged, ArrayList<User.Person> users, ArrayList<SystemF.Project> projects){
        Scanner input = new Scanner(System.in);
        int choice;

        do{
            SystemF.View.showMenuLogged();
            choice = input.nextInt();

            switch (choice){
                case 1:
                    //explore
                    break;
                case 2:
                    //search
                    break;
                case 3:
                    SystemF.Project.starterProject(projects);
                    break;
                case 4:
                    //checkStuff();
                    break;
                case 5:
                    //settings
                    break;
                default:
                    break;
            }
        }while(choice != 0);
        return null;
    }
}
