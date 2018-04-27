package System;

import java.util.*;

public class Settings {
	
	public enum choiceSettings{
		PROFILE(1), ACCOUNT(2), PAYMENT (3), EXIT(0);

		public int choice;

		private choiceSettings(int choice) {
			this.choice = choice;
		}
		
		public int getChoice(){
			return choice;
		}
	}
	
	public void view(){
		Scanner input = new Scanner(System.in);
		int choice = 1;
		
		System.out.println("1. Edit profile\n2. Edit account\n3. Edit payment method\n0. Back");
		choice = input.nextInt();
		
		while(choice != 0){
			/*switch(choice){
				case choiceSettings.PROFILE.getChoice():
					//editProfile();
					break;
				case choiceSettings.ACCOUNT.getChoice():
					//editAccount();
					break;
				case choiceSettings.PAYMENT.getChoice():
					//editPayment();
					break;
				default:
					break;
			}*/
		}
	}
}
