package com.infoshare.mteam.generator.userGenerator;

import com.infoshare.mteam.generator.userData.Address;
import com.infoshare.mteam.generator.userData.Name;
import com.infoshare.mteam.generator.userData.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UserGenerator {

    public Set<Integer> generateRandomNumbers(int howManyEntries) {
        Set<Integer> randomEntry = new HashSet<>();

        while (randomEntry.size() < howManyEntries) {
            randomEntry.add(new Random().nextInt(100));
        }
        return randomEntry;
    }


    public User[] generateRandomUsers(int howManyEntries, Set<Integer> randomEntry) {
        User[] user = new User[howManyEntries];
        try {
            String[] resource = {"/dataFile.json", "/dataFile.xml"};
            File fileToRead = new File(this.getClass().getResource(resource[0]).toURI());
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


    private User createUser(String[] userData) {
    //      0 - firstname, 1 - lastname, 2 - company, 3 - street, 4 -city, 5 - country,
    //      6 - state/province, 7 - Postal Code, 8 - email  9 - phone, 10 - password
        return new User(
                    new Name(userData[0], userData[1]),
                    new Address(userData[3], userData[4], userData[5], userData[6], userData[7]),
                    userData[2],
                    userData[8],
                    userData[9],
                    userData[10]);

    }


    public void showSelectedData(User[] users, int typeOfData) {

        if (typeOfData == 0) {
            for (User user : users) {

                System.out.println("First name: " + user.getName().getFirstName());
                System.out.println("Last name: " + user.getName().getLastName());
                System.out.println("Country: " + user.getAddress().getCountry());
                System.out.println("State/province: " + user.getAddress().getStateProvince());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Password: " + user.getPassword());
                System.out.println("------------");
            }
        } else {
            for (User user : users) {

                System.out.println("First name: " + user.getName().getFirstName());
                System.out.println("Last name: " + user.getName().getLastName());
                System.out.println("Company: " + user.getCompany());
                System.out.println("Street: " + user.getAddress().getStreet());
                System.out.println("City: " + user.getAddress().getCity());
                System.out.println("Country: " + user.getAddress().getCountry());
                System.out.println("State/province: " + user.getAddress().getStateProvince());
                System.out.println("Postal code: " + user.getAddress().getPostalCode());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone: " + user.getPhone());
                System.out.println("------------");
            }
        }
    }

}
