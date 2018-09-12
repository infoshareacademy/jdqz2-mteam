import readFile.ReadFileClassDataGen;
import userData.User;
import java.util.HashSet;
import java.util.Iterator;


public class DataGeneratorApp {
    public static void main(String[] args) {
        int howManyEntries;
        HashSet<Integer> randomNumbers;
        ReadFileClassDataGen entry = new ReadFileClassDataGen();

        howManyEntries = entry.numberBetweenOneAndOneHundred();
        randomNumbers = entry.generateRandomNumbers(howManyEntries);

        User[] users = entry.generateRandomUsers(howManyEntries, randomNumbers);
        System.out.println(users[0].getName());
        entry.showSelectedData(users, howManyEntries);
    }
}
