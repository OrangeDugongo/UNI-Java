package com.gmail.zurlo.michelef.classi;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.gmail.zurlo.michelef.util.IncorrectLabelException;

public class ResearchCenter {

	public ResearchCenter(Scanner sc) {
		projects = new ArrayList<Project>();

		Project p = readProject(sc);
		while (p != null) {
			projects.add(p);
			p = readProject(sc);
		}
	}

	private ResearchCenter(ArrayList<Project> projects) {
		this.projects = projects;
	}

	private Project readProject(Scanner sc) {
		Project project = null;

		if (!sc.hasNextLine()) {
			return null;
		}
		String type = sc.nextLine();

		while (type != null) {
			try {
				if (!type.equals("Ricerca") && !type.equals("Industria")) {
					throw new IncorrectLabelException("Label is not \"Industria\" or \"Ricerca\"!");
				}

				if (type.equals("Ricerca")) {
					project = ResearchProject.read(sc);
				} else if (type.equals("Industria")) {
					project = IndustrialProject.read(sc);
				}

				return project;

			} catch (IncorrectLabelException e) {
				System.err.println("An exception occurred while reading project label \"" + type + "\"");
				System.err.println(e.getMessage());
				System.err.println("All next line different from Industria or Ricerca will be skipped...");

				while (!type.equals("Ricerca") && !type.equals("Industria") && sc.hasNextLine()) {
					type = sc.nextLine();
				}
				if (!sc.hasNextLine()) {
					type = null;
				}
			}
		}

		return null;
	}

	public ResearchCenter filterByPreviousDate(Date date) {
		ArrayList<Project> projectsFilter = new ArrayList<Project>();

		for (Project p : projects) {
			if (p.getEnd().before(date)) {
				projectsFilter.add(p);
			}
		}

		return new ResearchCenter(projectsFilter);
	}

	public ResearchCenter filterByNextDate(Date date) {
		ArrayList<Project> projectsFilter = new ArrayList<Project>();

		for (Project p : projects) {
			if (p.getStart().after(date)) {
				projectsFilter.add(p);
			}
		}

		return new ResearchCenter(projectsFilter);
	}

	public void sortByName() {
		int i, j = 0;
		boolean done = false;

		while (!done && j < projects.size() - 1) {
			done = true;

			for (i = 0; i < projects.size() - j - 1; i++) {
				if (projects.get(i).getName().compareTo(projects.get(i + 1).getName()) > 0) {
					swap(i, i + 1);
					done = false;
				}
			}

			j++;
		}
	}

	private void swap(int i, int j) {
		Project temp = projects.get(i);
		projects.set(i, projects.get(j));
		projects.set(j, temp);
	}

	public void print(PrintStream ps) {
		for (Project p : projects) {
			if (p instanceof ResearchProject) {
				ps.println("Ricerca");
			} else {
				ps.println("Industria");
			}

			p.print(ps);
		}
	}

	private ArrayList<Project> projects;

}
