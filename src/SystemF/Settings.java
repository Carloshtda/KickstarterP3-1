package SystemF;

import java.util.*;

public class Settings {
	
	public enum choiceSettings{
		PROFILE(1), ACCOUNT(2), PAYMENT (3), EXIT(0);

		public final int choice;

		private choiceSettings(int choice) {
			this.choice = choice;
		}
		
		public int getChoice(){
			return choice;
		}
	}
	
	public static void editSettings(User.Person logged){
		Scanner input = new Scanner(System.in);
		int choice;
		boolean condition = true;
		
		while(condition){
            System.out.println("1. Edit profile\n2. Edit account\n3. Edit payment method\n0. Back");
            choice = input.nextInt();

			switch(choice){
				case 1:
					User.Profile.editProfile(logged);
					break;
				case 2:
					User.Account.editAccount(logged);
					break;
				case 3:
					User.Account.paymentMethods(logged);
					break;
                case 0:
                    condition = false;
                    break;
			}
		}
	}
}
