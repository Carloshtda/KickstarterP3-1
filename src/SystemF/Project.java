package SystemF;
import java.util.*;

import User.Person;

public class Project {
	private String projectTitle;
	private String category;
	private String blurb;
	private String location;
	private int fundingDuration;
	private double fundingGoal;
	private ArrayList<User.Person> collaborators;
	private ArrayList<Reward> rewards;
	private Story story;
	
	
	
	public Project(String category, String blurb,
			String location) {
		this.category = category;
		this.blurb = blurb;
		this.location = location;
	}

	public static void starterProject(ArrayList<Project> projects){
		String projectTitle;
		int fundingDuration;
		double fundingGoal;
		ArrayList<User.Person> collaborators;


		Scanner input = new Scanner(System.in);

		SystemF.View.showProjectCategory();
		String category = input.nextLine();

		SystemF.View.showProjectDescription();
		String blurb = input.nextLine();

		SystemF.View.showProjectCountry();
		String country = input.nextLine();

		SystemF.View.showProjectConditions();
		String choice = input.nextLine();

		if(choice.equals("Yes")){
		    Project newProject = new Project(category, blurb, country);
            projects.add(newProject);

		    System.out.println("Want to complete your project now? Yes / No");
            choice = input.nextLine();

            if(choice.equals("Yes")){
                SystemF.View.showProjectOptions();

            }
		}
}
	
}
