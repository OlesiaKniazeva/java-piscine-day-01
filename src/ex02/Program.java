package ex02;

public class Program {

    public static void main(String[] args) {
        UsersList list;
        User[] user;
        int amount;
        User nikolay;
        User petr;
        User masha;
        User returnUser;

        try {

            list = new UsersArrayList();
            amount = 6000;
            user = new User[amount];

            System.out.println("\nAmount of users in array: " + list.numberOfUsers());
            System.out.println();

            for (int i = 0; i < amount; ++i) {
                user[i] = new User("user" + i, i * 10 + i);
                list.add(user[i]);
            }

            nikolay = new User("Nikolay Sergeev", 67);
            petr = new User("Petr Okunev", 600);
            masha = new User("Maria Kazantseva", 59);

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
//            returnUser.displayInformationAboutUser();

            System.out.println();

        } catch (Exception e) {
            System.out.println("\033[31m" + e.getMessage() + "\033[0m");
        }


    }
}
