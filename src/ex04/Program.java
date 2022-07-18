package ex04;

public class Program {

    public static void main(String[] args) {
        TransactionsService service = new TransactionsService();

        User misha = new User("Misha", 575);
        User katya = new User("Katya", 89);
        User les = new User("Les", 453);

        service.addUser(misha);
        service.addUser(katya);
        service.addUser(les);

        try {
            service.getBalance(90);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(misha.getName() + " balance: " + service.getBalance(misha.getIdentifier()));
        System.out.println(katya.getName() + " balance: " + service.getBalance(katya.getIdentifier()));

        service.sendMoney(misha.getIdentifier(), katya.getIdentifier(), 43);

        System.out.println();
        System.out.println(misha.getName() + " balance: " + service.getBalance(misha.getIdentifier()));
        System.out.println(katya.getName() + " balance: " + service.getBalance(katya.getIdentifier()));
        System.out.println("-----------------");

        Transaction[] arr = service.getTransactions(misha.getIdentifier());
        Transaction[] arr2 = service.getTransactions(katya.getIdentifier());

        for (Transaction tr : arr) {
            tr.displayInfo();
        }

        System.out.println();

        for (Transaction tr : arr2) {
            tr.displayInfo();
        }

        System.out.println("--------------");

        service.sendMoney(les.getIdentifier(), katya.getIdentifier(), 56);
        service.sendMoney(misha.getIdentifier(), katya.getIdentifier(), 7);
        service.sendMoney(misha.getIdentifier(), les.getIdentifier(), 34);

        Transaction[] transactions = misha.getTransactions().toArray();

        service.removeTransaction(misha.getIdentifier(), transactions[0].getIdentifier());

        Transaction[] unpaired = service.checkTransactions();

        System.out.println("Unpaired transactions:\n\n");
        for (Transaction t : unpaired) {
            t.displayInfo();
        }

    }
}
