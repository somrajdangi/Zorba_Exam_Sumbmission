package org.example;

import java.io.*;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            //Read the database URL, username, and password from a properties file.
            Properties properties = new Properties();
            String filepath = "/home/som/Desktop/JDBC/src/main/resources/application.properties";
            File file = new File(filepath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            String url = (String) properties.get("url");
            String username = (String) properties.get("username");
            String password = (String) properties.get("password");

            Scanner scanner = new Scanner(System.in);

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating connection to Mysql Database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful....");

            //Create the RailwayReservationtable in the database.
            String RailwayReservationTable = "create table railway_reservation( passenger_name varchar(255),passenger_age int, choosen_seat varchar(255),reservation_type varchar(20), is_senior_citizen boolean,amount_paid double)";
            Statement statement = connection.createStatement();
            statement.execute(RailwayReservationTable);

            //Take input from the user and validate it.

            System.out.println("plese enter passenger name");
            String passengerName = scanner.nextLine();
            System.out.println("plese enter passenger age");
            int age = scanner.nextInt();
            System.out.println("plese enter passenger seat");
            String choosenseat = scanner.nextLine();
            System.out.println("plese enter passenger seat type ac/no ac");
            String typeofReservation = scanner.nextLine();
            System.out.println("plese enter amount paid");

            float amount = scanner.nextFloat();
            boolean isSeniorCitizen = age > 60;
            double amountpaid = calculateAmount(typeofReservation);

            //insert records into database

            String insertsql =" insert into RailwayReserationTable (passengerName, age,choosenseat,typeofReservation,isSeniorCitizen,amountpaid) values (?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement((insertsql));
            preparedStatement.setString(1,passengerName);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,choosenseat);
            preparedStatement.setString(4,typeofReservation);
            preparedStatement.setBoolean(5,isSeniorCitizen);
            preparedStatement.setDouble(6,amountpaid);

            //close the connection

            connection.close();
            scanner.close();
            System.out.println("record inserted....");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static double calculateAmount(String typeOfReservation) {
        if (typeOfReservation.equalsIgnoreCase("AC")) {
            return 100.0;
        } else {
            return 60.0;
        }
    }

    private static int readValidAge(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a valid integer.");
            }
        }


    }
}
