package user;

import java.util.*;

import systemF.Message;

public class Stuff {
    public static void myStuff(Person logged, ArrayList<user.Person> users){
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        int choice;

        while(condition){
            systemF.View.showMyStuff();
            choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    follow(logged, users);
                    break;
                case 2:
                    messages(logged, users);
                    break;
                case 3:
                    profile(logged, users);
                    break;
                case 4:
                    projects(logged.getBackedProjects(), logged);
                    break;
                case 5:
                    projects(logged.getSavedProjects(), logged);
                    break;
                case 6:
                    System.out.println("Project title:");
                    String title = input.nextLine();
                    systemF.Project.editProject(systemF.Project.getProject(title, logged.getMyProjects()), users);
                    break;
                case 0:
                    condition = false;
                    break;
            }
        }

    }

    public static void profile(Person logged, ArrayList<user.Person> users){
        Scanner input = new Scanner(System.in);

        System.out.println(logged.getProfile().getName());
        System.out.println(systemF.Project.countBackedProjects(logged.getBackedProjects()));
        System.out.println(logged.getProfile().getBiography());
        Profile.printWebsites(logged.getProfile().getWebsites());
        systemF.Project.printProjects(logged.getBackedProjects());
        System.out.println("My projects:");
        try {
            systemF.Project.printProjects(logged.getMyProjects());
            System.out.println("Want to edit any project? If yes enter with his title, or no.");

            String title = input.nextLine();
            if(!title.equals("no")){
                systemF.Project.editProject(systemF.Project.getProject(title, logged.getMyProjects()), users);
            }
        } catch (NullPointerException e){
            System.out.println("No projects started");
        }
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
                    logged.getFollowing().add((Person)Person.getPerson(choice, users));
                }
            }
        }
    }

    public static void messages(Person logged, ArrayList<Person> users){
        Scanner input = new Scanner(System.in);
        String choice;

        System.out.println("Send or view messages?");
        choice = input.nextLine().toLowerCase();

        if(choice.equals("send")){
            Message.sendMessage(users, logged);
        } else if(choice.equals("view")){
            System.out.println("Show all messages or only unread messages ?");
            choice = input.nextLine().toLowerCase();

            if(choice.equals("all")){
                systemF.Message.showAllMessages(logged);
            } else if(choice.equals("unread")){
                systemF.Message.showUnreadMessages(logged);
            }
        }
    }

    public static void projects(ArrayList<systemF.Project> projects, Person logged){
        Scanner input = new Scanner(System.in);

        for(systemF.Project current : projects){
            System.out.println(current.getProjectTitle());
        }
        System.out.println("Do you want to see any project ?\n      Yes or no");
        String choice = input.nextLine().toLowerCase();

        if(choice.equals("yes")){
            System.out.println("Which ?");
            choice = input.nextLine();
            systemF.Project.viewProject(logged, systemF.Project.getProject(choice, projects));
        }
    }
}
