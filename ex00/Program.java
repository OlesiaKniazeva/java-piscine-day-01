package ex00;

public class Program {
    public static void main(String[] args) {
        User nikolay = new User(1, "Nikolay Sergeev", 67);
        User petr = new User(2, "Petr Okunev", 600);
        User masha = new User(3,"Maria Kazantseva", 59);

        nikolay.displayInformationAboutUser();
        masha.displayInformationAboutUser();
        petr.displayInformationAboutUser();

        System.out.println();

        nikolay.setBalance(60);
        nikolay.displayInformationAboutUser();

        System.out.println();

        Transaction transaction = new Transaction(nikolay, petr, 56);

        System.out.println();

        transaction.displayInfo();

        System.out.println();

        nikolay.displayInformationAboutUser();
        petr.displayInformationAboutUser();

        System.out.println();


        Transaction transaction1 = new Transaction(masha, nikolay, -70);

        System.out.println();

        transaction1.displayInfo();

        System.out.println();

        masha.displayInformationAboutUser();
        nikolay.displayInformationAboutUser();
    }
}
