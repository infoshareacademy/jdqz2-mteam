import ReadFile.ReadFileClass;
import UserData.User;
import java.util.HashSet;
import java.util.Scanner;

public class DataGeneratorApp {
    public static void main(String[] args) {

        Scanner howManyEntriesScanner = new Scanner(System.in);
        System.out.print("Enter number of users to generate: ");
        int howManyEntries = howManyEntriesScanner.nextInt();
//        int howManyEntries = 100;

        ReadFileClass entry = new ReadFileClass();
        HashSet<Integer> randomNumberHashList = entry.randomNumbers(howManyEntries);

        Integer[] randomNumbersArray = new Integer[randomNumberHashList.size()];
        for (int i = 0; i < randomNumberHashList.size(); i++) {
            randomNumbersArray = randomNumberHashList.toArray(new Integer[0]);
        }

        User[] users = entry.userData(howManyEntries, randomNumbersArray);
        for (int i = 0; i < howManyEntries; i++) {
            System.out.println(randomNumbersArray[i] + ". " + users[i]);
        }

//         System.out.println(users[1].getName().getFirstName());
//         System.out.println(users[1].getName().getLastName());
//         System.out.println(users[1].getAddress().getCountry());
//         System.out.println(users[1].getAddress().getStateProvince());
//         System.out.println(users[1].getEmail());
//         System.out.println(users[1].getPassword());

    }
}
