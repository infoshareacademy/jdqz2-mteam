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
import java.util.Random;


public class ReadFileClassDataGen {

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
            File fileToRead = new File(this.getClass().getResource("/registration-data-file.json").toURI());
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
                    resultsXML[i] = nodeList.item(i).getTextContent().trim().replaceAll("\\s+", ",");
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
        } catch (IOException | ParserConfigurationException | SAXException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

//            0 - firstname, 1 - lastname, 2 - country, 3 - stateProvince, 4 - email  5 - pass
    private User createUser(String[] userData) {

        User userToReturn = new User(
                new Name(userData[0], userData[1]),
                new Address(userData[2], userData[3]),
                userData[4],
                userData[5]);

        return userToReturn;
    }

}
