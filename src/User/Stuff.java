package User;

import java.util.*;

public class Stuff {
    public void myStuff(){
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            SystemF.View.showMyStuff();
            choice = input.nextInt();

            switch (choice){
                case 1:
                    //rasd
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //sda
                    break;
                case 4:
                    //
                    break;
                case 5:
                    //
                    break;
                default:
                    break;
            }
        }while(choice != 0);

    }
}
