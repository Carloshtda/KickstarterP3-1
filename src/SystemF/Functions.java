package SystemF;

import java.util.*;

public class Functions {
	public static void starterProject(){

	}

    public void addBasics(Project newP){
        String choice;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Project image\nProject image\nShort blurb\nProject location\n" +
                    "Funding duration\nFunding goal\nProject collaborators\nExit editor");
            choice = input.nextLine();

        }while(!choice.equals("Exit editor"));
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

}
