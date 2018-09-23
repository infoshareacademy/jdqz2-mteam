package com.infoshare.mteam.unit;

import com.infoshare.mteam.userData.User;
import com.infoshare.mteam.userGenerator.UserGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class DataGeneratorAppTest extends UserGenerator {
    private int howManyEntries;
    private Set<Integer> randomNumbers;
    UserGenerator newUser;


    @Before
    public void setUp() {
        newUser = new UserGenerator();
        randomNumbers = new HashSet<>();
        howManyEntries = 5;
    }

    @Test
    public void checkingQuantityOfRandomNumbers() {
        randomNumbers = newUser.generateRandomNumbers(howManyEntries);
        assertEquals(5, randomNumbers.size());
    }

    @Test
    public void checkingQuantityOfUsers() {
        randomNumbers = newUser.generateRandomNumbers(howManyEntries);
        User[] users = newUser.generateRandomUsers(howManyEntries, randomNumbers);
        assertEquals(5, users.length);
    }

    @Test
    public void checkingAccessToUserData() {
        randomNumbers.add(22);
        howManyEntries = 1;
        User[] users = newUser.generateRandomUsers(howManyEntries, randomNumbers);
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
