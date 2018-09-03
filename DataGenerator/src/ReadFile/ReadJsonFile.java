package ReadFile;

import UserData.Address;
import UserData.Name;
import UserData.User;

import javax.json.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReadJsonFile {

    public int[] randomNumbers(int howManyEntries) {
        int[] randomEntry = new int[howManyEntries];
        for (int i = 0; i < howManyEntries; i++) {
            randomEntry[i] = (int) Math.round(Math.random()*100);
            //System.out.print(randomEntry[i] + " ");
        }
        return randomEntry;
    }

    public User[] userData(int howManyEntries, int[] randomEntry) {
        User[] user = new User[howManyEntries];
            try {
                InputStream is = new FileInputStream("registration-data-file.json");
                JsonReader jsonReader = Json.createReader(is);
                JsonObject jsonObject = jsonReader.readObject();
                JsonArray results = jsonObject.getJsonArray("data");


            //0 - firstname, 1 - lastname, 2 - country, 3 - stateProvince, 4 - email  5 - pass

                int i = 0;
                while(i < howManyEntries) {
                    String singleUser = results.get(randomEntry[i]).toString();
                    String singleUserPureData = singleUser.replaceAll("[\\[\\]{}()\"]", "");
                    String[] userData = singleUserPureData.split(",");

                    user[i] = new User(
                            new Name(userData[0], userData[1]),
                            new Address(userData[2], userData[3]),
                            userData[4],
                            userData[5]);
                    i++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (JsonException w) {
                System.out.println(w.getMessage());
            }

        return user;
    }

}