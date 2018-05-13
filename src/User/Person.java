package User;

import SystemF.Message;
import SystemF.Project;

import java.util.*;

public class Person {
    private Account account;
    private Profile profile;
    private ArrayList<SystemF.Message> messages = new ArrayList<>();
    private ArrayList<SystemF.Project> myProjects = new ArrayList<>();
    private ArrayList<SystemF.Project> backedProjects = new ArrayList<>();
    private ArrayList<SystemF.Project> savedProjects = new ArrayList<>();
    private ArrayList<Person> following = new ArrayList<>();

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

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<Project> getMyProjects() {
        return myProjects;
    }

    public void setMyProjects(ArrayList<Project> myProjects) {
        this.myProjects = myProjects;
    }

    public ArrayList<Project> getBackedProjects() {
        return backedProjects;
    }

    public void setBackedProjects(ArrayList<Project> backedProjects) {
        this.backedProjects = backedProjects;
    }

    public ArrayList<Project> getSavedProjects() {
        return savedProjects;
    }

    public void setSavedProjects(ArrayList<Project> savedProjects) {
        this.savedProjects = savedProjects;
    }

    public ArrayList<Person> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<Person> following) {
        this.following = following;
    }

    public static Person createAccount(ArrayList<Person> users) {
        Scanner input = new Scanner(System.in);

        System.out.println("Name:");
        String name = input.nextLine();

        System.out.println("Email:");
        String email = input.nextLine();

        System.out.println("Password:");
        String password = input.nextLine();

        Profile newProfile = new Profile(name);
        Account newAccount = new Account(email, password);
        Person newPerson = new Person(newAccount, newProfile);
        users.add(newPerson);
        return newPerson;
    }

    public static void printUsers(ArrayList<Person> users){
        for(Person current : users){
            System.out.println(current.getProfile().getName());
        }
    }

    public static Person getPerson(String name, ArrayList<Person> users){
        for(Person current : users){
            if(current.getProfile().getName().equals(name)){
                return current;
            }
        }
        return null;
    }

    public static void supportProject(Project project, Person logged){
        Scanner input = new Scanner(System.in);

        System.out.println("Want to support this project ?\n    Yes / No");
        String choice = input.nextLine().toLowerCase();

        if(choice.equals("yes")){
            project.setBackers(project.getBackers()+1);
            logged.getBackedProjects().add(project);
            System.out.println("Project supported!");
        }
    }

    public static void rememberProject(Project project, Person logged){
        Scanner input = new Scanner(System.in);

        System.out.println("Want to mark this project ?\n    Yes / No");
        String choice = input.nextLine().toLowerCase();

        if(choice.equals("yes")){
            logged.getSavedProjects().add(project);
            System.out.println("Project marked!");
        }
    }
}