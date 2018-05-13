package SystemF;

import java.util.*;
public class Reward {
    private String title;
    private double pledgeAmount;
    private String description;
    private String shippingDetails;

    public Reward(String title, double pledgeAmount, String description, String shippingDetails) {
        this.title = title;
        this.pledgeAmount = pledgeAmount;
        this.description = description;
        this.shippingDetails = shippingDetails;
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

    public static Reward addReward(){
        Scanner input = new Scanner(System.in);
        Reward newReward;

        System.out.println("Reward title:");
        String title = input.nextLine();

        System.out.println("Pledge amount:");
        double pledge = input.nextDouble();

        System.out.println("Description: (Talk about the reward, estimated delivery, additional items)");
        String description = input.nextLine();

        System.out.println("Shipping details:");
        String shipping = input.nextLine();

        return newReward = new Reward(title, pledge, description, shipping);
    }

    public static void editReward(Reward reward){
        Scanner input = new Scanner(System.in);
        int choice = 1;

        while(choice != 0){
            View.showEditReward();
            choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.println("New reward title:");
                    String title = input.nextLine();
                    reward.setTitle(title);
                    break;
                case 2:
                    System.out.println("New pledge amount:");
                    double pledge = input.nextDouble();
                    reward.setPledgeAmount(pledge);
                    break;
                case 3:
                    System.out.println("New description:");
                    String description = input.nextLine();
                    reward.setDescription(description);
                    break;
                case 4:
                    System.out.println("New shippping details:");
                    String shipping = input.nextLine();
                    reward.setShippingDetails(shipping);
                    break;
                case 0:
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
        }
    }
}
