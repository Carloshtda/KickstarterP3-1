package systemF;

import java.util.*;

import exceptions.InputTreatment;
import user.Entity;
import user.Person;


public class Project {
    private Person creator;
	private String projectTitle;
	private String category;
	private String blurb;
	private String location;
	private double reached;
	private int fundingDuration;
	private double fundingGoal;
	private int backers;
	private String fullDescription;
	private ArrayList<user.Person> collaborators;
	private ArrayList<Reward> rewards;
	private ArrayList<Message> comments = new ArrayList<>();

	static Scanner input = new Scanner(System.in);
	
	public Project(String projectTitle, Person logged, String category, String blurb,
			String location) {
	    this.projectTitle = projectTitle;
	    this.creator = logged;
		this.category = category;
		this.blurb = blurb;
		this.location = location;
	}

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getReached() {
        return reached;
    }

    public void setReached(double reached) {
        this.reached = reached;
    }

    public int getFundingDuration() {
        return fundingDuration;
    }

    public void setFundingDuration(int fundingDuration) {
        this.fundingDuration = fundingDuration;
    }

    public double getFundingGoal() {
        return fundingGoal;
    }

    public void setFundingGoal(double fundingGoal) {
        this.fundingGoal = fundingGoal;
    }

    public ArrayList<Person> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(ArrayList<Person> collaborators) {
        this.collaborators = collaborators;
    }

    public ArrayList<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(ArrayList<Reward> rewards) {
        this.rewards = rewards;
    }

    public int getBackers() {
        return backers;
    }

    public void setBackers(int backers) {
        this.backers = backers;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public ArrayList<Message> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Message> comments) {
        this.comments = comments;
    }

    public static void starterProject(user.Person logged, ArrayList<Project> projects, ArrayList<user.Person> users){
  
        System.out.println("Project title:");
        String projectTitle = input.nextLine();

        systemF.View.showProjectCategory();
        String category = input.nextLine();

        systemF.View.showProjectDescription();
        String blurb = input.nextLine();

        systemF.View.showProjectCountry();
        String country = input.nextLine();

        systemF.View.showProjectConditions();
        String choice = input.nextLine().toLowerCase();

        if(choice.equals("yes")){
            Project newProject = new Project(projectTitle ,logged, category, blurb, country);
            projects.add(newProject);
            logged.getMyProjects().add(newProject);

            System.out.println("Want to complete your project now? Yes / No");
            choice = input.nextLine().toLowerCase();

            if(choice.equals("yes")){
                editProject(newProject, users);
            }
        }
    }

    public static void search(Person logged, ArrayList<Project> projects){

        System.out.println("Search for projects:");
        String project = input.nextLine();

        for(Project current : projects){
            if(current.getProjectTitle().equals(project)){
                viewProject(logged, current);
                return;
            }
        }
        System.out.println("Oops! We could not find any results. Did you mean " + project +
                ".\n    Why not change some things around or broaden your search?");
    }

    public static void explore(Person logged, ArrayList<Project> projects){
 
        System.out.println("    Choose a category");
        View.showCategories();
        String category = input.nextLine();

        for(systemF.Project current : projects){
            if(current.getCategory().equals(category)){
                System.out.println(current.getProjectTitle());
            }
        }
        System.out.println("0. Back");

        System.out.println("Select a project or enter '0' to back");
        String choice = input.nextLine();

        if(!choice.equals("0"))
            try {
                viewProject(logged ,getProject(choice, projects));
            } catch (NullPointerException e){
                System.out.println("Project no found");
            }

    }

    public static void viewProject(Person logged, Project project){
        int choice = 1;
        do {
            systemF.View.showProjectInfo();
            choice = InputTreatment.inputLimitedInteger(0, 6);
            System.out.println(project.getProjectTitle());

            switch (choice){
                case 1:
                    showCampaign(project);
                    break;
                case 2:
                    showComments(project);
                    break;
                case 3:
                    System.out.println(project.getBackers() + " people are supporting " + project.getCreator().getProfile().getName());
                    break;
                case 4:
                    Person.supportProject(project, logged);
                    break;
                case 5:
                    Person.rememberProject(project, logged);
                    break;
                case 6:
                    Message.sendComment(project, logged);
                    break;
                case 0:
                    break;
            }
        }while (choice != 0);
    }

    public static void showCampaign(Project project){
        System.out.println("--------------------------------------------------");
        System.out.println("Campaign");
	    System.out.println(project.getProjectTitle());
        System.out.println(project.getCreator().getProfile().getName());
        System.out.println(project.getCategory());
        System.out.println(project.getBlurb());
        if(project.getFullDescription() != null) System.out.println(project.getFullDescription());
        System.out.println("Weeks to go: " + project.getFundingDuration());
        System.out.println("Pledged of $" + project.getFundingGoal() + " goal");
        System.out.println("Reached US$ " + project.getReached());
        System.out.println("Backers: " + project.getBackers());
        System.out.println("--------------------------------------------------");
        System.out.println("Rewards");
        try {
            Reward.printRewards(project.getRewards());
        } catch (NullPointerException e){
            System.out.println("No registered rewards");
        }
        if(project.getCollaborators() != null){
            System.out.println("--------------------------------------------------");
            System.out.println("Collaborators");
            for(Person current : project.getCollaborators()){
                System.out.println(current.getProfile().getName());
            }
        }
        System.out.println("--------------------------------------------------");
    }

    public static void showComments(Project project){
	    for(Message current : project.getComments()){
            System.out.println(current.getContent());
            System.out.println("            " + current.getSender());
        }
    }

    public static Project getProject(String name, ArrayList<Project> projects){
        for(systemF.Project current : projects){
            if(current.getProjectTitle().equals(name)){
                return current;
            }
        }
        return null;
    }

    public static void editProject(Project project, ArrayList<user.Person> users){
	    Scanner input = new Scanner(System.in);

        System.out.println("Edit/Add basics or rewards ?");
        String choice = input.nextLine();

        if(choice.equals("basics")){
            editBasics(project, users);
        } else if(choice.equals("rewards")){
            System.out.println("Edit or add ?");
            choice = input.nextLine().toLowerCase();

            if(choice.equals("add")){
                project.getRewards().add(Reward.addReward());
            } else if(choice.equals("edit")){
                for(Reward current : project.getRewards()){
                    System.out.println(current.getTitle());
                }
                System.out.println("Choice a reward to edit");
                choice = input.nextLine();
                Reward.editReward(Reward.selectReward(choice, project.getRewards()));
            }
        }
    }

    public static void editBasics(Project project, ArrayList<user.Person> users){
	    int choice;
	    boolean condition = true;
	    while(condition){
            View.showEditBasics();
            choice = InputTreatment.inputLimitedInteger(0, 9);
            input.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Recurso em desenvolvimento.\n");
                    break;
                case 2:
                    System.out.println("New project title:");
                    String title = input.nextLine();
                    project.setProjectTitle(title);
                    break;
                case 3:
                    System.out.println("New short blurb:");
                    String blurb = input.nextLine();
                    project.setBlurb(blurb);
                    break;
                case 4:
                    System.out.println("New category:");
                    String category = input.nextLine();
                    project.setCategory(category);
                    break;
                case 5:
                    System.out.println("New project location:");
                    String country = input.nextLine();
                    project.setLocation(country);
                    break;
                case 6:
                    System.out.println("Funding duration: (weeks)");
                    int weeks = input.nextInt();
                    project.setFundingDuration(weeks);
                    break;
                case 7:
                    System.out.println("Funding goal:");
                    double goal = input.nextDouble();
                    project.setFundingGoal(goal);
                    break;
                case 8:
                    System.out.println("Name of new collaborator:");
                    String name = input.nextLine();
                    project.getCollaborators().add((Person) Person.getPerson(name, users));
                    break;
                case 9:
                    System.out.println("New description");
                    String description = input.nextLine();
                    project.setFullDescription(description);
                    break;
                case 0:
                    condition = false;
                    break;
            }
        }
    }

    public static int countBackedProjects(ArrayList<Project> backedProjects){
	    int count = 0;
	    for(Project current : backedProjects){
	        count++;
        }
        return count;
    }

    public static void printProjects(ArrayList<Project> backedProjects){
	    for(Project current : backedProjects){
            System.out.println(current.getProjectTitle());
        }
    }
}
