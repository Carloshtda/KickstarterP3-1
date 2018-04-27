package System;
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
	
	
	
	public Project(String projectTitle, String category, String blurb,
			String location, int fundingDuration, double fundingGoal,
			ArrayList<Person> collaborators, ArrayList<Reward> rewards,
			Story story) { 
		this.projectTitle = projectTitle;
		this.category = category;
		this.blurb = blurb;
		this.location = location;
		this.fundingDuration = fundingDuration;
		this.fundingGoal = fundingGoal;
		this.collaborators = collaborators;
		this.rewards = rewards;
		this.story = story;
	}

	public void starterProject(){
		String projectTitle;
		String category;
		String blurb;
		String location;
		int fundingDuration;
		double fundingGoal;
		ArrayList<User.Person> collaborators;
		ArrayList<Reward> rewards;		
		Story story;
		
		//Project newProject = new Project(projectTitle, category, blurb, location, fundingDuration, fundingGoal, collaborators, rewards, story);
	}
	
}
