package SystemF;

public class View {
    public static void showProjectCategory(){
        System.out.println("Pick a project category to connect with a specific community. You can always update this later.");
        showCategories();
    }

    public static void showProjectDescription(){
        System.out.println("Describe what you’ll be creating.\n     And don’t worry, you can edit this later, too.");
    }

    public static void showProjectCountry(){
        System.out.println("Finally, let’s confirm your eligibility.\n  " +
                "Tell us where you’re based and confirm a few other details before we proceed.\n" +
                "Enter your country: ");
    }

    public static void showProjectConditions(){
        System.out.println("I confirm that:\n   I am least 18 years old.\n" +
                "   I can verify a bank account and government-issued ID.\n   I have a debit and/or credit card.\n Yes \\  No");
    }

    public static void showProjectOptions(){
        System.out.println("Campaign\n    Basics(Add an image, set your funding goal, and more.)\n    " +
                "Rewards(Set your rewards and shipping costs.)\n    Story(Add a video and detailed the project description).");
    }

    public static void showEditProfileOptions(){
        System.out.println("1. Edit name\n2. Add/Edit picture\n3. Add/Edit biography\n" +
                "4. Add/Edit location\n5. Add websites\n0. Back");
    }

    public static void showSignInOptions(){
        System.out.println("1. Log me in\n2. New to Kickstarter? Sign Up!\n0. Back");
    }

    public static void showMenuLogged(){
        System.out.println("1. Explore\n2. Search\n3. Start a project\n" +
                "4. My stuff\n5. Settings\n0. Log out");
    }

    public static void showMyStuff(){
        System.out.println("1. Follow creators\n2. Messages\n3. Profile\n" +
                "4. Backed projects\n5. Saved Projects\n6. Edit project\n0. Back");
    }

    public static void showProjectInfo(){
        System.out.println("1. Campaign\n2. FAQ\n3. Updates\n4. Comments" +
                "\n5. Community\n6. Back this project\n7. Remind me\n8. Comment\n0. Back");
    }

    public static void showCategories(){
        System.out.println("Art\nComics\nCrafts\nDance\nDesign\nFashion\n" +
                "Film & Video\nFood\nGames\nJournalism\nMusic\nPhotography" +
                "Technology\nTheater");
    }

    public static void showEditBasics(){
        System.out.println("1. Project image\n2. Project title\n3. Short blurb\n    Give people a sense of what you’re doing." +
                " Skip “Help me” and focus on what you’re making.\n4. Category" +
                "5. Project location\n6. Funding duration\n7. Funding goal\n8. Project collaborators" +
                "9. Project description\n   Use your project description to share more about " +
                "what you’re raising funds to do and how you plan to pull it off." +
                " \n0. Back");
    }

    public static void showEditReward(){
        System.out.println("1. Reward title\n2. Pledge amount\n3. Description " +
                "(Talk about the reward, estimated delivery, additional items)" +
                "\n4. Shipping details\n0. Back");
    }

    public static void printMessage(Message message){
        System.out.println("---------------------------------------------");
        System.out.println("Title: " + message.getTitle() + "\n"
                + "From: " + message.getSender() + "\n"
                + "Content: \n  " + message.getContent());
        System.out.println("---------------------------------------------");
    }
}
