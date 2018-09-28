package com.infoshare.mteam.generator;

import com.infoshare.mteam.generator.userData.User;
import com.infoshare.mteam.generator.userGenerator.UserGenerator;

import java.util.Scanner;
import java.util.Set;

public class DataGeneratorApp {
    public static void main(String[] args) {
        int howManyUsers;
        int selectedData;
        Set<Integer> randomNumbers;
        UserGenerator newUsers = new UserGenerator();
        Scanner inputScanner = new Scanner(System.in);


        System.out.print("Please enter the number of users to generate (from range 1-100): ");
        howManyUsers = Integer.parseInt(inputScanner.nextLine());

        randomNumbers = newUsers.generateRandomNumbers(howManyUsers);
        User[] users = newUsers.generateRandomUsers(howManyUsers, randomNumbers);

        System.out.print("Which data do you want to show - register data (0) or billing data (1): ");
        selectedData = inputScanner.nextInt();

        newUsers.showSelectedData(users, selectedData);
    }
}
