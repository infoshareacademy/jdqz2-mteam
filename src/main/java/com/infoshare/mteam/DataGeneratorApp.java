package com.infoshare.mteam;

import com.infoshare.mteam.UserData.User;
import com.infoshare.mteam.readFile.RegisterUser;

import java.util.HashSet;


public class DataGeneratorApp {
    public static void main(String[] args) {
        int howManyEntries;
        HashSet<Integer> randomNumbers;
        RegisterUser entry = new RegisterUser();

        howManyEntries = entry.numberBetweenOneAndOneHundred();
        randomNumbers = entry.generateRandomNumbers(howManyEntries);

        User[] users = entry.generateRandomUsers(howManyEntries, randomNumbers);
        entry.showSelectedData(users, howManyEntries);
    }
}
