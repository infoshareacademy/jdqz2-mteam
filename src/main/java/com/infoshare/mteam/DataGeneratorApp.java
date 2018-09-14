package com.infoshare.mteam;

import com.infoshare.mteam.UserData.User;
import com.infoshare.mteam.userGenerator.userGenerator;

import java.util.Scanner;
import java.util.Set;

public class DataGeneratorApp {
    public static void main(String[] args) {
        int howManyEntries;
        Set<Integer> randomNumbers;
        userGenerator entry = new userGenerator();

        howManyEntries = entry.numberBetweenOneAndOneHundred();
        randomNumbers = entry.generateRandomNumbers(howManyEntries);

        User[] users = entry.generateRandomUsers(howManyEntries, randomNumbers);

        System.out.print("register data (0) or billging data (1): ");
        Scanner inputScanner = new Scanner(System.in);
        int selectedData = inputScanner.nextInt();
        entry.showSelectedData(users, selectedData);

    }
}
