package user;

import java.util.ArrayList;

import systemF.Project;

public abstract class Entity {
	public abstract void acessLoggedMenu(Entity logged, ArrayList<Person> users, ArrayList<Project> projects);
	public abstract void warning();
}
