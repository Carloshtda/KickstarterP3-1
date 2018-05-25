package user;

import java.nio.charset.MalformedInputException;
import java.util.*;

import menu.Main;
import systemF.Message;
import systemF.Project;

public class Person extends Entity{
    private Account account;
    private Profile profile;
    private ArrayList<systemF.Message> messages = new ArrayList<>();
    private ArrayList<systemF.Project> myProjects = new ArrayList<>();
    private ArrayList<systemF.Project> backedProjects = new ArrayList<>();
    private ArrayList<systemF.Project> savedProjects = new ArrayList<>();
    private ArrayList<Person> following = new ArrayList<>();

    static Scanner input = new Scanner(System.in);
    
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

    public static Entity getPerson(String name, ArrayList<Person> users){
        for(Person current : users){
            if(current.getProfile().getName().equals(name)){
                return current;
            }
        }
        return new NullPerson();
    }

    public static void supportProject(Project project, Person logged){

        System.out.println("Want to support this project ?\n    Yes / No");
        String choice = input.nextLine().toLowerCase();

        if(choice.equals("yes")){
            System.out.println("Choice a reward");

            for(systemF.Reward current : project.getRewards()){
                System.out.println(current.getTitle() + "Pledge $" + current.getPledgeAmount());
            }
            choice = input.nextLine();

            try{
                systemF.Reward reward = systemF.Reward.selectReward(choice, project.getRewards());
                reward.setNumberBackers(reward.getNumberBackers() + 1);
                project.setBackers(project.getBackers()+1);
                project.setReached(project.getReached() + reward.getPledgeAmount());
                logged.getBackedProjects().add(project);

                System.out.println("Project supported!");
            } catch (NullPointerException e){
                System.out.println("Reward not found");
            }
        }
    }

    public static void rememberProject(Project project, Person logged){
        System.out.println("Want to mark this project ?\n    Yes / No");
        String choice = input.nextLine().toLowerCase();
        if(choice.equals("yes")){
            logged.getSavedProjects().add(project);
            System.out.println("Project marked!");
        }
    }

	@Override
	public void acessLoggedMenu(Entity logged, ArrayList<Person> users, ArrayList<Project> projects) {
			Main.menuLogged((Person)logged, users, projects);
		
	}

	@Override
	public void warning() {
		System.out.println("Person found");
		
	}
}