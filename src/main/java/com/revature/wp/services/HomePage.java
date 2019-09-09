package com.revature.wp.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.wp.dao.UserDAOImpl;
import com.revature.wp.exception.InputMismatchException;

public class HomePage {

	public static void homepage() throws SQLException {

		UserDAOImpl us = null;

		try {
			System.out.println("****Welcome To GS Water Treatment Plant****");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Select Register For Registration(For New User)");
			System.out.println("\n" + "Select Login For Login(For Exisisting User)");
			System.out.println("Enter Your Choice:");
			String choice = scan.nextLine();
			String selection = choice.toLowerCase();

			if (selection.equals("register")) {
				System.out.println("Registering Your Details...");
				System.out.println("Enter your name :");
				String name = scan.next();
				System.out.println("Enter your MobileNumber:");
				long mobilenumber = scan.nextLong();
				System.out.println("Enter Password :");
				String password = scan.next();
				System.out.println("Email_id:");
				String Emailid = scan.next();
				us.register(name, mobilenumber, password, Emailid);

			} else if (selection.equals("login")) {
				System.out.println("Loging You In...");
				System.out.println("Enter your name :");
				String name = scan.next();
				System.out.println("Enter Password:");
				String password = scan.next();

				us.login(name, password);
			} else {
				System.out.println("Please Enter Valid Details");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int QualityCheck() throws InputMismatchException, SQLException {
		boolean test = false;
		int choice = 0;
		while (test != true) {
			try {
				Scanner scan = new Scanner(System.in);
				String str = scan.next();
				choice = Integer.parseInt(str);
				test = true;
				break;
			} catch (Exception e) {
				System.out.println("Enter Valid Input");
				HomePage hp = new HomePage();
				hp.WelcomePage();

			}
		}
		return choice;
	}

	public void WelcomePage() throws SQLException, InputMismatchException {
		System.out.println("****Welcome To GS WaterPlant****\n      ");
		System.out.println("Select Your Choice Of Login \n");
		System.out.println("Select 1 For Admin Login\n");
		System.out.println("Select 2 For User Login/Register \n");
		Scanner scan = new Scanner(System.in);

		int choice = QualityCheck();
		if (choice == 1) {
			CanAvailability.admin();
		}
		if (choice == 2) {
			HomePage.homepage();
		} else {
			System.out.println("****Kindly Press Valid Input**** \n");

			System.out.println("Redirecting To WelcomePage \n");
			WelcomePage();

		}

	}

	public static void main(String[] args) throws SQLException, InputMismatchException {
		HomePage hp = new HomePage();
		hp.WelcomePage();

	}

}