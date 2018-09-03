import ReadFile.ReadJsonFile;
import UserData.User;

import java.util.Scanner;

public class DataGeneratorApp {
    public static void main(String[] args){


        Scanner howManyEntriesScanner = new Scanner(System.in);
        System.out.print("Enter number of users to generate: ");
        int howManyEntries = howManyEntriesScanner.nextInt();

        //int howManyEntries = 2;
        ReadJsonFile entry = new ReadJsonFile();
        int[] randomNumbers = entry.randomNumbers(howManyEntries);
        User[] users = entry.userData(howManyEntries, randomNumbers);
        for (int i = 0; i < howManyEntries ; i++) {
            System.out.println(randomNumbers[i] + " " + users[i]);
        }

//        System.out.println(users[1].getName().getFirstName());
//        System.out.println(users[1].getName().getLastName());
//        System.out.println(users[1].getAddress().getCountry());
//        System.out.println(users[1].getAddress().getStateProvince());
//        System.out.println(users[1].getEmail());
//        System.out.println(users[1].getPassword());

    }
}