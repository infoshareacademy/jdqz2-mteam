public class DataGeneratorApp {
    public static void main(String[] args) {
        User user1 = new User(
                new Name("Jakub", "Marchwicki"),
                new Address("Poland", "Pomorskie"),
                "kuba@gmail.com",
                "kuba123"
        );

        /*
        {
         "user": {
           "name": {
             "firstname": "",
             "lastname": ""
           },
           "address": {
           }.
         }
        }
         */



        System.out.println(user1);
    }
}
