package com.infoshare.mteam;

import com.infoshare.mteam.readFile.BillingInfo;
import userData.User;
import java.util.*;

public class BillingInfoApp {
    public static void main(String[] args) {
        int howManyEntries;
        int[] specifiedDataToShow;
        HashSet<Integer> randomNumbers;
        BillingInfo entry = new BillingInfo();

        howManyEntries = entry.numberBetweenOneAndOneHundred();
        randomNumbers = entry.generateRandomNumbers(howManyEntries);
        specifiedDataToShow = entry.specifiedDataToShow();
        User[] users = entry.generateRandomUsers(howManyEntries, randomNumbers);
        BillingInfo.showSelectedData(users, specifiedDataToShow, howManyEntries);
    }
}
