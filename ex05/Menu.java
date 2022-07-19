package ex05;

import java.util.Scanner;

public class Menu {
    private final TransactionsService service;
    private final String profile;

    private final String  menuProduction =
            "1. Add a user\n" +
            "2. View user balances\n" +
            "3. Perform a transfer\n" +
            "4. View all transactions for a specific user\n" +
            "5. Finish execution";

    private final String  menuDeveloper =
            "1. Add a user\n" +
            "2. View user balances\n" +
            "3. Perform a transfer\n" +
            "4. View all transactions for a specific user\n" +
            "5. DEV – remove a transfer by ID\n" +
            "6. DEV – check transfer validity\n" +
            "7. Finish execution";

    private final Scanner sc = new Scanner(System.in);

    Menu(String profile) {
        this.profile = profile;
        service = new TransactionsService();
    }

    public void start() {
        if (!(profile.equals("--profile=dev") || profile.equals("--profile=production"))) {
            System.out.println("Wrong profile data");
            return;
        }

        while (true) {

            if (profile.equals("dev")) {
                System.out.println(menuDeveloper);
            } else {
                System.out.println(menuProduction);
            }

            String codeNum = sc.nextLine();

            switch (codeNum) {
                case ("1"):
                    addUser();
                    break;
                case ("2"):
                    viewBalance();
                    break;
                case("3"):
                    performTransfer();
                    break;
                case ("4"):
                    viewTransactions();
                    break;
                default:
                    System.out.println("End");
            }
            System.out.println("---------------------------------------------------------");

        }
    }

    private void viewTransactions() {
        while (true) {
            System.out.println("Enter a user ID");
            String line = sc.nextLine();
            try {
                int id = Integer.parseInt(line);
                Transaction[] arr = service.getTransactions(id);

                if (arr.length == 0) {
                    System.out.println("No transactions were made");
                } else {
                    for (Transaction t : arr) {
                        t.showShortData();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong data");
                continue;
            } catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
    }

    private void printNoUsersError() {
        System.out.println("No users added! \n You can add users, by choosing \"1\" in menu");
    }
    private void performTransfer() {
        int amount;

        if (service.isEmpty()) {
            printNoUsersError();
            return;
        }

        while (true) {
            System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            if (arr.length != 3) {
                System.out.println("Wrong data");
                continue;
            }
            try {
                int id1 = Integer.parseInt(arr[0]);
                int id2 = Integer.parseInt(arr[1]);

                amount = Integer.parseInt(arr[2]);

                service.sendMoney(id1, id2, amount);
                System.out.println("The transfer is completed");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong data");
            } catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
                return;
            } catch (IllegalTransactionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void addUser() {
        String[] data;
        int sum;

        while (true) {
            System.out.println("Enter a user name and a balance");

            String line = sc.nextLine();
            data = line.split(" ");
            if (data.length < 2) {
                System.out.println("Wrong data");
                continue;
            }
            try {
                sum = Integer.parseInt(data[data.length - 1]);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong data");
                continue;
            }
        }
        String name = "";

        for (int i = 0; i < data.length - 1; ++i) {
            if (i != 0) {
                name += " ";
            }
            name += data[i];
        }
        System.out.println("User with id = " + service.addUser(name, sum).getIdentifier() + " is added");
    }

    private void viewBalance() {
        int id;
        User user = null;

        if (service.isEmpty()) {
            printNoUsersError();
            return;
        }

        while (true) {
            System.out.println("Enter a user ID");

            String identifier = sc.nextLine();

            try {
                id = Integer.parseInt(identifier);
                user = service.getUser(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong data");
                continue;
            } catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println(user.getName() + " - " + user.getBalance());
    }

}