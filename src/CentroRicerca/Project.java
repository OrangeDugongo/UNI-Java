import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Project {

	public Project(String name, String description, double budget, Date start, Date end) {
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.start = start;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public static Project read(Scanner sc) {
		String name, description;
		double budget;
		Date start;
		Date end;

		SimpleDateFormat df = Constants.S_DATE_FORMAT;

		if (!sc.hasNextLine()) {
			return null;
		}
		name = sc.nextLine();

		if (!sc.hasNextLine()) {
			return null;
		}
		description = sc.nextLine();

		if (!sc.hasNextLine()) {
			return null;
		}
		try {
			budget = Double.parseDouble(sc.nextLine());
		} catch (NumberFormatException e) {
			System.err.println("An exception occurred while parsing budget, project " + name);
			System.err.println("Budget will be assigned default value...");
			budget = 0;
		}

		try {
			start = df.parse(sc.nextLine());
		} catch (ParseException e) {
			System.err.println("An exception occurred while parsing start date, project " + name);
			System.err.println("Start date will be assigned default system date...");
			start = new Date();
		}

		try {
			end = df.parse(sc.nextLine());
			if (end.before(start)) {
				throw new IllegalDateException("End date is before start date!");
			}
		} catch (ParseException e) {
			System.err.println("An exception occurred while parsing end date, project " + name);
			System.err.println("End date will be assigned default system date...");
			end = new Date();
		} catch (IllegalDateException e) {
			System.err.println("An exception occurred while parsing end date, project " + name);
			System.err.println(e.getMessage());
			System.err.println("End date will be assigned default system date...");
			end = new Date();
		}

		return new Project(name, description, budget, start, end);
	}

	public void print(PrintStream ps) {
		SimpleDateFormat df = Constants.S_DATE_FORMAT;

		ps.println(name);
		ps.println(description);
		ps.println(budget);
		ps.println(df.format(start));
		ps.println(df.format(end));
	}

	private String name;
	private String description;
	private double budget;
	private Date start;
	private Date end;

}
