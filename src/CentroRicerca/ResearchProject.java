package com.gmail.zurlo.michelef.classi;

import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

public class ResearchProject extends Project {

	public ResearchProject(String name, String description, double budget, Date start, Date end, String fundingBody,
			String fundingLaw) {
		super(name, description, budget, start, end);
		this.fundingBody = fundingBody;
		this.fundingLaw = fundingLaw;
	}

	public String getFundingBody() {
		return fundingBody;
	}

	public void setFundingBody(String fundingBody) {
		this.fundingBody = fundingBody;
	}

	public String getFundingLaw() {
		return fundingLaw;
	}

	public void setFundingLaw(String fundingLaw) {
		this.fundingLaw = fundingLaw;
	}

	public static ResearchProject read(Scanner sc) {
		String fundingBody, fundingLaw;

		Project p = Project.read(sc);

		if (!sc.hasNextLine()) {
			return null;
		}
		fundingBody = sc.nextLine();

		if (!sc.hasNextLine()) {
			return null;
		}
		fundingLaw = sc.nextLine();

		return new ResearchProject(p.getName(), p.getDescription(), p.getBudget(), p.getStart(), p.getEnd(),
				fundingBody, fundingLaw);
	}

	public void print(PrintStream ps) {
		super.print(ps);
		ps.println(fundingBody);
		ps.println(fundingLaw);
	}

	private String fundingBody;
	private String fundingLaw;

}
