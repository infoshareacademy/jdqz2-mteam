import ReadFile.ReadJsonFile;
import UserData.User;


import java.util.*;

public class BillingInfoApp {
    public static void main(String[] args) {

    Scanner howManyEntriesScanner = new Scanner(System.in);
    System.out.print("Enter number of users to generate: ");
    int howManyEntries = Integer.parseInt(howManyEntriesScanner.nextLine());
//        int howManyEntries = 2;

        ReadJsonFile entry = new ReadJsonFile();
        HashSet<Integer> randomNumberHashList = entry.randomNumbers(howManyEntries);

        Integer[] randomNumbersArray = new Integer[randomNumberHashList.size()];
        for (int i = 0; i < randomNumberHashList.size(); i++) {
            randomNumbersArray = randomNumberHashList.toArray(new Integer[0]);
        }

        System.out.println("Which data do you want to get?");
        System.out.println(
                " 1 - First name\n" +
                " 2 - Last name\n" +
                " 3 - Billing company\n" +
                " 4 - Street address\n" +
                " 5 - City\n" +
                " 6 - Country\n" +
                " 7 - State/province\n" +
                " 8 - Postal code\n" +
                " 9 - Email\n" +
                " 10 - Phone\n");
        System.out.print("Type numbers separated with coma (eg. 1,4,6): ");
        String[] dataToShow = (howManyEntriesScanner.nextLine().split(","));
        int[] datadata = Arrays.asList(dataToShow).stream().mapToInt(Integer::parseInt).toArray();

        User[] users = entry.userData(howManyEntries, randomNumbersArray);
        for (int i = 0; i < howManyEntries; i++) {
//            System.out.println(randomNumbersArray[i] + ". " + users[i]);

            for (int j = 0; j < datadata.length; j++) {


                switch (datadata[j]) {
                    case 1:
                        System.out.println(users[i].getName().getFirstName());
                        break;
                    case 2:
                        System.out.println(users[i].getName().getLastName());
                        break;
                    case 3:
                        System.out.println(users[i].getCompany());
                        break;
                    case 4:
                        System.out.println(users[i].getAddress().getStreet());
                        break;
                    case 5:
                        System.out.println(users[i].getAddress().getCity());
                        break;
                    case 6:
                        System.out.println(users[i].getAddress().getCountry());
                        break;
                    case 7:
                        System.out.println(users[i].getAddress().getStateProvince());
                        break;
                    case 8:
                        System.out.println(users[i].getAddress().getPostalCode());
                        break;
                    case 9:
                        System.out.println(users[i].getEmail());
                        break;
                    case 10:
                        System.out.println(users[i].getPhone());
                        break;
                }
            }
            System.out.println("------------");
        }
        howManyEntriesScanner.close();

//       1 System.out.println(users[1].getName().getFirstName());
//       2 System.out.println(users[1].getName().getLastName());
//       3 System.out.println(users[1].getAddress().getStreet());
//       4 System.out.println(users[1].getAddress().getCity());
//       5 System.out.println(users[1].getAddress().getCountry());
//       6 System.out.println(users[1].getAddress().getStateProvince());
//       7 System.out.println(users[1].getAddress().getPostalCode());
//       8 System.out.println(users[1].getCompany());
//       9 System.out.println(users[1].getEmail());
//       10 System.out.println(users[1].getPhone());


    }
}
