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
	private int backers;
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
        choice = choice.toUpperCase();
		if(choice.equals("YES")){
		    Project newProject = new Project(category, blurb, country);
            projects.add(newProject);

		    System.out.println("Want to complete your project now? Yes / No");
            choice = input.nextLine();
            choice = choice.toUpperCase();

            if(choice.equals("YES")){
                SystemF.View.showProjectOptions();

            }
		}
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

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
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

    }

    public static void viewProject(Project project){
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            SystemF.View.showProjectInfo();
            choice = input.nextInt();

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
                    System.out.println("mostrar quantidade de apoiadores");
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
}
