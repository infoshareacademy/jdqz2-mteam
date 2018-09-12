package readFile;

import userData.Address;
import userData.Name;
import userData.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.json.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class ReadFileClassDataGen {

    public HashSet<Integer> generateRandomNumbers(int howManyEntries) {
        HashSet<Integer> randomEntry = new HashSet<>();

        while (randomEntry.size() < howManyEntries) {
            randomEntry.add(new Random().nextInt(100));
        }
        return randomEntry;
    }


    public int numberBetweenOneAndOneHundred() {
        int howManyEntries;
        int counter = 0;
        do {
            if (counter >= 1) {
                System.out.println("\nEntered number is out of range!");
            }
            System.out.print("Please enter the number of users to generate (from range 1-100): ");
            howManyEntries = Integer.parseInt(inputScanner());
            counter++;
        } while (howManyEntries > 100 || howManyEntries < 1);
        return howManyEntries;
    }


    private String inputScanner() {
        Scanner enteredDataScanner = new Scanner(System.in);
        return enteredDataScanner.nextLine();
    }


    public User[] generateRandomUsers(int howManyEntries, HashSet<Integer> randomEntry) {

        User[] user = new User[howManyEntries];
        try {
            File fileToRead = new File(this.getClass().getResource("/registration-data-file.xml").toURI());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(fileToRead));

            String extensionTemp = fileToRead.toString();
            int lastDotBeforeFileExtension = extensionTemp.lastIndexOf(".");
            String extension = extensionTemp.substring(lastDotBeforeFileExtension + 1);


            if (extension.equals("xml")) {
                //Rozwiązanie dla XML

                DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(inputStream);
                Element ele = doc.getDocumentElement();
                NodeList nodeList = ele.getChildNodes();

                int recordsQuantity = (nodeList.getLength() - 1) / 2;
                String[] resultsXML = new String[recordsQuantity];

                for (int i = 0; i < recordsQuantity; i++) {
                    Node node = nodeList.item(i);
                    node.getParentNode().removeChild(node);
                    resultsXML[i] = nodeList.item(i).getTextContent().trim().replaceAll("\\s{2,}", ",");
                }

                int i = 0;

                for (Integer aRandomEntry : randomEntry) {
                    String singleUser = resultsXML[aRandomEntry];
                    String[] userData = singleUser.split(",");
                    user[i] = createUser(userData);
                    i++;
                }

            } else if (extension.equals("json")) {

                //Rozwiązanie dla JSON
                JsonReader jsonReader = Json.createReader(inputStream);
                JsonObject jsonObject = jsonReader.readObject();
                JsonArray resultsJSON = jsonObject.getJsonArray("data");

                int i = 0;

                for (Integer aRandomEntry : randomEntry) {
                    String singleUser = resultsJSON.get(aRandomEntry).toString();
                    String singleUserPureData = singleUser.replaceAll("[\\[\\]{}()\"]", "");
                    String[] userData = singleUserPureData.split(",");

                    user[i] = createUser(userData);
                    i++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException | ParserConfigurationException | SAXException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    //0 - firstname, 1 - lastname, 2 - country, 3 - stateProvince, 4 - email  5 - pass
    private User createUser(String[] userData) {
        return new User(
                new Name(userData[0], userData[1]),
                new Address(userData[2], userData[3]),
                userData[4],
                userData[5]);
    }


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
