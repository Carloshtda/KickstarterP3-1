package SystemF;

import java.util.*;
import User.Person;


public class Project {
    private Person creator;
	private String projectTitle;
	private String category;
	private String blurb;
	private String location;
	private int fundingDuration;
	private double fundingGoal;
	private int backers;
	private String fullDescription;
	private ArrayList<User.Person> collaborators;
	private ArrayList<Reward> rewards;

	public Project(User.Person logged, String category, String blurb,
			String location) {
	    this.creator = logged;
		this.category = category;
		this.blurb = blurb;
		this.location = location;
	}
    //arrumar a edição de dados
	public static void starterProject(User.Person logged, ArrayList<Project> projects){
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
        choice = choice.toUpperCase();

        if(choice.equals("YES")){
		    Project newProject = new Project(logged, category, blurb, country);
            projects.add(newProject);

		    System.out.println("Want to complete your project now? Yes / No");
            choice = input.nextLine();
            choice = choice.toUpperCase();

            if(choice.equals("YES")){
                SystemF.View.showProjectOptions();


            }
		}
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

    public static void search(ArrayList<Project> projects){
	    Scanner input = new Scanner(System.in);

        System.out.println("Search for projects:");
        String project = input.nextLine();

        for(Project current : projects){
            if(current.getProjectTitle().equals(project)){
                viewProject(current);
                return;
            }
        }
        System.out.println("Oops! We couldn’t find any results. Did you mean" + project +
                "\n    Why not change some things around or broaden your search?");
    }

    public static void explore(ArrayList<Project> projects){
        Scanner input = new Scanner(System.in);

        System.out.println("    Choice a category");
        SystemF.View.showCategories();
        String category = input.nextLine();

        for(SystemF.Project current : projects){
            if(current.getCategory().equals(category)){
                System.out.println(current.getProjectTitle());
            }
        }
        System.out.println("0. Back");

        System.out.println("Select a project or enter '0' to back");
        String choice = input.nextLine();

        if(!choice.equals("0"))
            viewProject(getProject(choice, projects));

    }

    public static void viewProject(Project project){
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            SystemF.View.showProjectInfo();
            choice = input.nextInt();
            System.out.println(project.getProjectTitle());

            switch (choice){
                case 1:
                    System.out.println("Mostrar informaçoes do projeto");
                    break;
                case 2:
                    System.out.println("mostrar faq");
                    break;
                case 3:
                    System.out.println("mostrar os updates");
                    break;
                case 4:
                    System.out.println("mostrar comments");
                    break;
                case 5:
                    System.out.println(project.getBackers() + " people are supporting " + project.getCreator().getProfile().getName());
                    break;
                case 6:
                    //Apoiar o projeto
                    break;
                case 7:
                    //Lembrar o projeto
                    break;
                case 8:
                    //comentar
                    break;
                default:
                    break;
            }
        }while (choice != 0);
    }

    public static Project getProject(String name, ArrayList<Project> projects){
        for(SystemF.Project current : projects){
            if(current.getProjectTitle().equals(name)){
                return current;
            }
        }
        return null;
    }

    public static void editProject(Project project){
	    Scanner input = new Scanner(System.in);

        System.out.println("Edit/Add basics or rewards ?");
        String choice = input.nextLine();

        if(choice.equals("basics")){
            editBasics(project);
        } else if(choice.equals("rewards")){
            System.out.println("Edit or add ?");
            choice = input.nextLine();
            choice = choice.toLowerCase();

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

    public static void editBasics(Project project){
	    int choice = 1;
	    Scanner input = new Scanner(System.in);

	    while(choice != 0){
            View.showEditBasics();
            choice = input.nextInt();
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
                case 8://arrumar dps
                    System.out.println("Name of new collaborator:");
                    String name = input.nextLine();
                    project.getCollaborators();
                    break;
                case 9:
                    System.out.println("New description");
                    String description = input.nextLine();
                    project.setFullDescription(description);
                    break;
                case 0:
                    break;
            }
        }
    }
}
