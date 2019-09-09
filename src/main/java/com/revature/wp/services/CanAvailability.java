package com.revature.wp.services;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.revature.wp.dao.UserDAOImpl;

public class CanAvailability {
	static Scanner scan = new Scanner(System.in);
	static int can;
	static int order;

	public static void admin() throws SQLException {
		int stock = 0;
		HomePage hp=null;
		CanAvailability ca=null;
		
		try {
			System.out.println("Welcome To GS Water Treatment Plant");

			System.out.println("Welcome Admin!!! Please Enter Your Name For Verification:");
			String name = scan.nextLine();
			System.out.println("Admin!!! Please Enter Your password For Verification:");
			String password = scan.nextLine();
			if (name.equals("admin") && password.equals("admin@2255")) {
				System.out.println("Admin Loggined SuccessFully");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				System.out.println("Select View Stock-1/Cancel-2");
				stock = scan.nextInt();
				if (stock == 1) {

					int st = 1000;
					System.out.println("Available Cans in Our Waterplant (in  units):" + st);
					System.out.println("Set the availability quantity of cans in units:");
					can = scan.nextInt();
					System.out.println("Available Number of cans : " + can + "units");
					UserDAOImpl us = new UserDAOImpl();
					us.setavailablecans(can);
					hp.homepage();

				} else if (stock == 2) {
					admin();
				}

				else {
					System.out.println("****Please Enter Valid Details****");
					System.out.println("Redirecting To Admin Homepage");
					ca.admin();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void order() throws SQLException {
		HomePage hp=null;
		try {
			System.out.println("Availability quantity of cans in units:" + " " + can);
			if (can == 0) {
				switch (can) {
				case 0:
					System.out.println("****Water Cans Are Unavailable At The Moment...Kindly Come Back Later****");
					break;
				}
			}
			System.out.println("****Redirecting To Homepage..****");
			hp.homepage();
			System.out.println("Set your order in units: ");
			order = scan.nextInt();

			if ((order > 0) && (order <= 100)) {

				System.out.println("****Your Order Has Been Confirmed****");
				can = can - order;
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				System.out.println("Available Number Of Cans in units:" + can);
				UserDAOImpl obj = new UserDAOImpl();
				obj.orderedcans(order);
				UserDAOImpl obj1 = new UserDAOImpl();
				obj1.availablecansafterordered(can);
			}

			else {
				System.out.println("****Kindly Enter The Number Of Cans Less Than 101****");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}