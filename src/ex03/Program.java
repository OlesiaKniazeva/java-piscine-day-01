package ex03;

public class Program {

    public static void main(String[] args) {
        try {
            TransactionsList transactions;
            User nikolay;
            User petr;
            User masha;
            Transaction[] arr;
            Transaction tr1;
            Transaction tr2;

            transactions = new TransactionsLinkedList();
            nikolay = new User("Nikolay Sergeev", 67);
            petr = new User("Petr Okunev", 600);
            masha = new User("Maria Kazantseva", 59);

            tr1 = new Transaction(nikolay, petr, 50);
            transactions.add(tr1);
            tr2 = new Transaction(masha, petr, 54);
            transactions.add(new Transaction(petr, masha, 20));
            transactions.add(tr2);

            arr = transactions.toArray();

            for (Transaction tr : arr) {
                tr.displayInfo();
                System.out.println();
            }

            transactions.removeById(tr1.getIdentifier());

            System.out.println("-------------");

            arr = transactions.toArray();

            for (Transaction tr : arr) {
                tr.displayInfo();
                System.out.println();
            }

            System.out.println("-------------");

            transactions.add(tr1);
            transactions.removeById(tr2.getIdentifier());

            arr = transactions.toArray();

            for (Transaction tr : arr) {
                tr.displayInfo();
                System.out.println();
            }


        } catch (Exception e) {
            System.out.println("\033[31m" + e.getMessage() + "\033[0m");
        }

//
    }

}
