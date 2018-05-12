package User;

import java.util.*;

public class Stuff {
    public static void myStuff(Person logged, ArrayList<User.Person> users){
        Scanner input = new Scanner(System.in);
        int choice = 1;
        while(choice != 0){
            SystemF.View.showMyStuff();
            choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    follow(logged, users);
                    break;
                case 2:
                    messages(logged);
                    break;
                case 3:
                    profile(logged);
                    break;
                case 4:
                    projects(logged.getBackedProjects());
                    break;
                case 5:
                    projects(logged.getSavedProjects());
                    break;
                case 6:
                    System.out.println("Project title:");
                    String title = input.nextLine();
                    SystemF.Project.editProject(SystemF.Project.getProject(title, logged.getMyProjects()));
                    break;
            }
        }

    }

    public static void profile(Person logged){
        System.out.println(logged.getProfile().getName());
        System.out.println(SystemF.Project.countBackedProjects(logged.getBackedProjects()));
        System.out.println(logged.getProfile().getBiography());
        Profile.printWebsites(logged.getProfile().getWebsites());
        SystemF.Project.printBackedProjects(logged.getBackedProjects());
    }

    public static void follow(Person logged, ArrayList<Person> users){
        Scanner input = new Scanner(System.in);
        boolean itHas = false;

        for(Person current : logged.getFollowing()){
            System.out.println(current.getProfile().getName());
            itHas = true;
        }

        if(!itHas){
            System.out.println("Do you want to see all registered creators?\n       Yes or no");
            String choice = input.nextLine().toLowerCase();
            if(choice.equals("yes")){
                Person.printUsers(users);
                System.out.println("Want to follow any creator?\n   If yes enter with his name, or enter no");
                choice = input.nextLine();

                if(!choice.equals("no")){
                    logged.getFollowing().add(Person.getPerson(choice, users));
                }
            }
        }
    }

    public static void messages(Person logged){
        Scanner input = new Scanner(System.in);

        System.out.println("Show all messages or only unread messages ?");
        String choice = input.nextLine().toLowerCase();

        if(choice.equals("all")){
            SystemF.Message.showAllMessages(logged);
        } else if(choice.equals("unread")){
            SystemF.Message.showUnreadMessages(logged);
        }
    }

    public static void projects(ArrayList<SystemF.Project> projects){
        Scanner input = new Scanner(System.in);

        for(SystemF.Project current : projects){
            System.out.println(current.getProjectTitle());
        }
        System.out.println("Do you want to see any project ?\n      Yes or no");
        String choice = input.nextLine().toLowerCase();

        if(choice.equals("yes")){
            System.out.println("Which ?");
            choice = input.nextLine();
            SystemF.Project.viewProject(SystemF.Project.getProject(choice, projects));
        }
    }
}
