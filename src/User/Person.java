package User;

import SystemF.Message;

import java.util.*;

public class Person {
    private Account account;
    private Profile profile;
    private ArrayList<SystemF.Message> messages;

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
}