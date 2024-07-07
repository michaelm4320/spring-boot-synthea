package com.example.spring_boot_synthea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

@SpringBootApplication
public class SpringBootSyntheaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSyntheaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

			// Call the method to connect to the database
			connectToDatabase();
		};
	}

	private void connectToDatabase() {
		try {
			String password = System.getenv("DB_PASSWORD");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/synthea",
					"root",
					password
			);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM NAMES");

			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
