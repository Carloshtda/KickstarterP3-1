package SystemF;

import java.util.*;
public class Reward {
    private String title;
    private double pledgeAmount;
    private String description;
    private String shippingDetails;
    private int numberBackers;

    public Reward(String title, double pledgeAmount, String description, String shippingDetails) {
        this.title = title;
        this.pledgeAmount = pledgeAmount;
        this.description = description;
        this.shippingDetails = shippingDetails;
        this.numberBackers = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPledgeAmount() {
        return pledgeAmount;
    }

    public void setPledgeAmount(double pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(String shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public int getNumberBackers() {
        return numberBackers;
    }

    public void setNumberBackers(int numberBackers) {
        this.numberBackers = numberBackers;
    }

    public static Reward addReward(){
        Scanner input = new Scanner(System.in);
        Reward newReward;

        System.out.println("Reward title:");
        String title = input.nextLine();

        double pledge;
        try {
            System.out.println("Pledge amount:");
            pledge = input.nextDouble();

        } catch (InputMismatchException e){
            System.out.println("It's no allowed to enter letters, only numbers");
            pledge = input.nextDouble();
        }

        System.out.println("Description: (Talk about the reward, estimated delivery, additional items)");
        String description = input.nextLine();

        System.out.println("Shipping details:");
        String shipping = input.nextLine();

        newReward = new Reward(title, pledge, description, shipping);
        return newReward;
    }

    public static void editReward(Reward reward){
        Scanner input = new Scanner(System.in);
        boolean condition = true;

        while(condition){
            View.showEditReward();
            int choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.println("New reward title:");
                    String title = input.nextLine();
                    reward.setTitle(title);
                    break;
                case 2:
                    double pledge;
                    try {
                        System.out.println("New pledge amount:");;
                        pledge = input.nextDouble();

                    } catch (InputMismatchException e){
                        System.out.println("It's no allowed to enter letters, only numbers");
                        pledge = input.nextDouble();
                    }
                    reward.setPledgeAmount(pledge);
                    break;
                case 3:
                    System.out.println("New description:");
                    String description = input.nextLine();
                    reward.setDescription(description);
                    break;
                case 4:
                    System.out.println("New shipping details:");
                    String shipping = input.nextLine();
                    reward.setShippingDetails(shipping);
                    break;
                case 0:
                    condition = false;
                    break;
            }
        }

    }

    public static Reward selectReward(String name, ArrayList<Reward> rewards){
        for(Reward current : rewards){
            if(current.getTitle().equals(name)){
                return current;
            }
        }
        return null;
    }

    public static void printRewards(ArrayList<Reward> rewards){
        for(Reward current : rewards){
            System.out.println(current.getTitle());
            System.out.println("Pledge $" + current.getPledgeAmount());
            System.out.println(current.getDescription());
            System.out.println(current.getShippingDetails());
            System.out.println("Backers: " + current.getNumberBackers());
        }
    }
}
