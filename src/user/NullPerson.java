package user;

import java.util.ArrayList;

import systemF.Project;

public class NullPerson extends Entity{
	public NullPerson() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void acessLoggedMenu(Entity logged, ArrayList<Person> users, ArrayList<Project> projects) {
		// TODO Auto-generated method stub
		System.out.println("Failed to Log in. Please try again");
	}

	@Override
	public void warning() {
		System.out.println("Person not found");
		
	}

}
