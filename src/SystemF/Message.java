package SystemF;

import java.util.*;

public class Message {
	private String sender;
	private String title;
	private String content;
	private boolean read = false;

    public Message(String sender, String title, String content) {
        this.sender = sender;
        this.title = title;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public static void sendMessage(ArrayList<User.Person> users, User.Person logged){
        Scanner input = new Scanner(System.in);

        System.out.println("Title:");
        String title = input.nextLine();

        System.out.println("Content:");
        String content = input.nextLine();

        Message newMessage = new Message(logged.getProfile().getName(), title, content);
        //addMessage(newMessage);
    }

    public static void showMessage(String title, ArrayList<Message> messages){
        for(Message current : messages){
            if(current.getTitle().equals(title)){
                View.printMessage(current);
                current.setRead(true);
            }
        }
    }

    public static void showUnreadMessages(User.Person logged){
        boolean itHas = false;
        Scanner input = new Scanner(System.in);

        for(Message current : logged.getMessages()){
            if(!current.isRead()){
                System.out.println(current.getTitle());
                itHas = true;
            }
        }
        if(itHas){
            System.out.println("Choice a message");
            String title = input.nextLine();
            showMessage(title, logged.getMessages());
        } else {
            System.out.println("There are no messages");
        }
    }

    public static void showAllMessages(User.Person logged){
        boolean itHas = false;
        Scanner input = new Scanner(System.in);

        for(Message current : logged.getMessages()){
            System.out.println(current.getTitle());
            itHas = true;
        }
        if(itHas){
            System.out.println("Choice a message");
            String title = input.nextLine();
            showMessage(title, logged.getMessages());
        } else {
            System.out.println("There are no messages");
        }
    }

}
