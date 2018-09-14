package com.infoshare.mteam.readFile;

import com.infoshare.mteam.UserData.User;

import java.util.*;

public class BillingInfo extends CommonMethods{

    public int[] specifiedDataToShow() {
        System.out.println(
                "\nWhich data do you want to get?\n" +
                " 1 - First name\n" +
                " 2 - Last name\n" +
                " 3 - Billing company\n" +
                " 4 - Street address\n" +
                " 5 - City\n" +
                " 6 - Country\n" +
                " 7 - State/province\n" +
                " 8 - Postal code\n" +
                " 9 - Email\n" +
                " 10 - Phone\n" +
                "Type numbers separated with coma (eg. 1,4,6): ");

        String[] stringArrayData = inputScanner().split(",");

        return Arrays.stream(stringArrayData).mapToInt(Integer::parseInt).toArray();
    }


    public static void showSelectedData(User[] users, int[] specifiedDataToShow, int howManyEntries) {
        for (int i = 0; i < howManyEntries; i++) {

            for (int aSpecifiedDataToShow : specifiedDataToShow) {

                switch (aSpecifiedDataToShow) {
                    case 1:
                        System.out.println("First name: " + users[i].getName().getFirstName());
                        break;
                    case 2:
                        System.out.println("Last name: " + users[i].getName().getLastName());
                        break;
                    case 3:
                        System.out.println("Company: " + users[i].getCompany());
                        break;
                    case 4:
                        System.out.println("Street: " + users[i].getAddress().getStreet());
                        break;
                    case 5:
                        System.out.println("City: " + users[i].getAddress().getCity());
                        break;
                    case 6:
                        System.out.println("Country: " + users[i].getAddress().getCountry());
                        break;
                    case 7:
                        System.out.println("State/province: " + users[i].getAddress().getStateProvince());
                        break;
                    case 8:
                        System.out.println("Postal code: " + users[i].getAddress().getPostalCode());
                        break;
                    case 9:
                        System.out.println("Email: " + users[i].getEmail());
                        break;
                    case 10:
                        System.out.println("Phone number: " + users[i].getPhone());
                        break;
                }
            }
            System.out.println("------------");
        }
    }

}
