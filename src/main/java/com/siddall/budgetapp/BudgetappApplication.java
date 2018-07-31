package com.siddall.budgetapp;

import com.siddall.budgetapp.DAOs.JDBC;
import com.siddall.budgetapp.Models.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class BudgetappApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(BudgetappApplication.class, args);
//	}

	public static void main(String[] args) {
		JDBC jdbc = new JDBC();
		String sql = "SELECT * FROM user_login;";
		ArrayList<User> users = jdbc.data("findallusers",  "bubba", null);


		for (User user : users) {
			System.out.print("user id: " + user.getId());
			System.out.print(" username: " + user.getUsername());
			System.out.println(" password: " + user.getPassword());
		}
	}
}
