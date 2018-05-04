package SystemF;

import java.util.*;

public class Message {
	private String sender;
	private String title;
	private String content;
	private boolean readed = false;

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

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
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
}
