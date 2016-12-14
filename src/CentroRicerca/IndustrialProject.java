package com.gmail.zurlo.michelef.classi;

import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

import com.gmail.zurlo.michelef.util.IllegalPercentageException;

public class IndustrialProject extends Project {

	public IndustrialProject(String name, String description, double budget, Date start, Date end, String company,
			double fundedPercentage) {
		super(name, description, budget, start, end);
		this.company = company;
		this.fundedPercentage = fundedPercentage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getFundedPercentage() {
		return fundedPercentage;
	}

	public void setFundedPercentage(double fundedPercentage) {
		this.fundedPercentage = fundedPercentage;
	}

	public static IndustrialProject read(Scanner sc) {
		String company;
		double fundingPercentage;

		Project p = Project.read(sc);

		if (!sc.hasNextLine()) {
			return null;
		}
		company = sc.nextLine();

		if (!sc.hasNextLine()) {
			return null;
		}
		try {
			fundingPercentage = Double.parseDouble(sc.nextLine());
			if (fundingPercentage < 0 || fundingPercentage > 100) {
				throw new IllegalPercentageException("Percentage value is out of bounds!");
			}
		} catch (NumberFormatException e) {
			System.err.println("An exception occurred while parsing funding percentage, project " + p.getName());
			System.err.println("Funding percentage will be assigned default value..");
			fundingPercentage = 0;
		} catch (IllegalPercentageException e) {
			System.err.println("An exception occurred while parsing funding percentage, project " + p.getName());
			System.err.println(e.getMessage());
			System.err.println("Funding percentage will be assigned default value..");
			fundingPercentage = 0;
		}

		return new IndustrialProject(p.getName(), p.getDescription(), p.getBudget(), p.getStart(), p.getEnd(), company,
				fundingPercentage);
	}

	public void print(PrintStream ps) {
		super.print(ps);
		ps.println(company);
		ps.println(fundedPercentage);
	}

	private String company;
	private double fundedPercentage;

}
