package ReadFile;

import UserData.Address;
import UserData.Name;
import UserData.User;
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
import java.util.Random;


public class ReadFileClassBillingInfo {

    public HashSet<Integer> randomNumbers(int howManyEntries) {

        HashSet<Integer> randomEntry = new HashSet<Integer>();
        while (randomEntry.size() < howManyEntries) {
            randomEntry.add(new Random().nextInt(100));
        }
        return randomEntry;
    }

    public User[] userData(int howManyEntries, Integer[] randomEntry) {
        User[] user = new User[howManyEntries];
        try {
            File fileToRead = new File( this.getClass().getResource("/billingInfo-data.json").toURI());

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
                    resultsXML[i] = nodeList.item(i).getTextContent().replaceAll("^\\s+|\\s+$|", "").replaceAll("\\s{2,}", ",");
                }

                int i = 0;
                while (i < howManyEntries) {
                    String singleUser = resultsXML[randomEntry[i]];
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
                while (i < howManyEntries) {
                    String singleUser = resultsJSON.get(randomEntry[i]).toString();
                    String singleUserPureData = singleUser.replaceAll("[\\[\\]{}()\"]", "");
                    String[] userData = singleUserPureData.split(",");

                    user[i] = createUser(userData);
                    i++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return user;
    }


    private User createUser(String[] userData) {

        User userToReturn = new User(
                new Name(userData[0], userData[1]),
                new Address(userData[3], userData[4], userData[5], userData[6], userData[7]),
                userData[2],
                userData[8],
                userData[9]);

        return userToReturn;
    }



    public static void showSelectedData(User[] users, int[] specifiedDataToShow, int howManyEntries) {
        for (int i = 0; i < howManyEntries; i++) {

            for (int j = 0; j < specifiedDataToShow.length; j++) {

                switch (specifiedDataToShow[j]) {
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
    }


}
