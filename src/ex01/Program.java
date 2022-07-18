package ex01;

public class Program {

    public static void main(String[] args) {
        int amount;
        User[] user;

        amount = 6000;
        user = new User[amount];

        for (int i = 0; i < amount; ++i) {
            user[i] = new User("user" + i, i * 10 + i);
        }

        user[450].displayInformationAboutUser();
        user[10].displayInformationAboutUser();
        user[112].displayInformationAboutUser();
        user[5666].displayInformationAboutUser();

        System.out.println();

        checkAllUsers(user, amount);
    }

    private static void checkAllUsers(User[] users, int amount) {
        for (int i = 0; i < amount - 1; ++i) {
            for (int g = i + 1; g < amount; ++g) {
                if (users[i].getIdentifier().equals(users[g].getIdentifier())) {
                    System.out.println("Find equals identifiers");
                }
            }
        }
        System.out.println("No equals identifiers there found");
    }
}
