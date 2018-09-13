import org.junit.Before;
import org.junit.Test;

import readFile.CommonMethods;
import readFile.RegisterUser;
import userData.User;

import java.io.ByteArrayInputStream;
import java.util.HashSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class DataGeneratorAppTest extends CommonMethods {
    private int howManyEntries;
    private HashSet<Integer> randomNumbers;
    RegisterUser entry;


    @Before
    public void setUp() throws Exception {
        entry = new RegisterUser();
        randomNumbers = new HashSet<>();
    }

    @Test
    public void enteringNumberBetweenOneAndOneHundred() {
        String data = "5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        howManyEntries = entry.numberBetweenOneAndOneHundred();
        assertEquals(5, howManyEntries);
    }

    //po drugiej pętli input scannera jest pusty i wychodzi błąd
    //Jak to przetestowac?
//    @Test
//    public void checkingMessageWhenEnteringNumberOutsideOneAndOneHundred() {
//        RegisterUser entry = new RegisterUser();
//        String data = "101";
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        howManyEntries = entry.numberBetweenOneAndOneHundred();
//        assertEquals("\nEntered number is out of range!", System.out);
//    }

    @Test
    public void checkingQuantityOfRandomNumbers() {
        howManyEntries = 5;
        randomNumbers = entry.generateRandomNumbers(howManyEntries);
        assertEquals(5, randomNumbers.size());
    }

    @Test
    public void checkingQuantityOfUsers() {
        howManyEntries = 5;
        randomNumbers = entry.generateRandomNumbers(howManyEntries);
        User[] users = entry.generateRandomUsers(howManyEntries, randomNumbers);
        assertEquals(5, users.length);
    }

    @Test
    public void checkingAccessToUserData() {
        randomNumbers.add(22);
        howManyEntries = 1;
        User[] users = entry.generateRandomUsers(howManyEntries, randomNumbers);
        assertEquals( "Grady", users[0].getName().getFirstName());
        assertEquals( "Nielsen", users[0].getName().getLastName());
        assertEquals( "Aliquam Erat LLC", users[0].getCompany());
        assertEquals("Kazakhstan", users[0].getAddress().getCountry());
        assertEquals("Metropolitana de Santiago", users[0].getAddress().getStateProvince());
        assertEquals("La Florida", users[0].getAddress().getCity());
        assertEquals("94819-881", users[0].getAddress().getPostalCode());
        assertEquals("Ap #610-1759 Faucibus Street", users[0].getAddress().getStreet());
        assertEquals( "nec.mollis@sit.edu", users[0].getEmail());
        assertEquals( "YUG77EXC9ZE", users[0].getPassword());
        assertEquals("106-558-007", users[0].getPhone());
    }


}
