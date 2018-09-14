package com.infoshare.mteam.readFile;

import com.infoshare.mteam.UserData.User;


public class RegisterUser extends CommonMethods{

    public void showSelectedData(User[] users, int howManyEntries) {
        for (int i = 0; i < howManyEntries; i++) {

            System.out.println("First name: " + users[i].getName().getFirstName());
            System.out.println("Last name: " + users[i].getName().getLastName());
            System.out.println("Country: " + users[i].getAddress().getCountry());
            System.out.println("State/province: " + users[i].getAddress().getStateProvince());
            System.out.println("Email: " + users[i].getEmail());
            System.out.println("Password: " + users[i].getPassword());
            System.out.println("------------");
        }
    }
}
