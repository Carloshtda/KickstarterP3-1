package User;

import java.util.*;

public class Stuff {
    public static void myStuff(){
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            SystemF.View.showMyStuff();
            choice = input.nextInt();

            switch (choice){
                case 1:
                    //seguir criadores
                    break;
                case 2:
                    //ver mensagens
                    break;
                case 3:
                    //ver perfil
                    break;
                case 4:
                    //projetos apoiados
                    break;
                case 5:
                    //projetos salvos
                    break;
                default:
                    break;
            }
        }while(choice != 0);

    }
}
