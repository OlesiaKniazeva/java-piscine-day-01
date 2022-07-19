package ex02;

public class Program {

    public static void main(String[] args) {
        try {
            User returnUser;

            UsersList list = new UsersArrayList();

            int amount = 6000;

            User[] user = new User[amount];

            System.out.println("\nAmount of users in array: " + list.numberOfUsers());
            System.out.println();

            for (int i = 0; i < amount; ++i) {
                user[i] = new User("user" + i, i * 10 + i);
                list.add(user[i]);
            }

            User nikolay = new User("Nikolay Sergeev", 67);
            User petr = new User("Petr Okunev", 600);
            User masha = new User("Maria Kazantseva", 59);

            list.add(nikolay);
            list.add(petr);
            list.add(masha);

            returnUser = list.getUserByIndex(6001);
            returnUser.displayInformationAboutUser();

            returnUser = list.getUserByID(45);
            returnUser.displayInformationAboutUser();

            returnUser = list.getUserByID(6003);
            returnUser.displayInformationAboutUser();

            System.out.println("\nAmount of users in array: " + list.numberOfUsers());

//            returnUser = list.getUserByID(6007);

            System.out.println();

        } catch (Exception e) {
            System.out.println("\033[31m" + e.getMessage() + "\033[0m");
        }


    }
}
