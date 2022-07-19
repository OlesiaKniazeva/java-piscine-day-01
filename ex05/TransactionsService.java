package ex05;

import java.util.UUID;

public class TransactionsService {
    private final UsersList data;
    private final TransactionsList transactions;

    TransactionsService() {
        data = new UsersArrayList();
        transactions = new TransactionsLinkedList();
    }

    public User addUser(User client) {
        data.add(client);
        return client;
    }

    public User addUser(String name, int balance) {
        User newUser = new User(name, balance);

        data.add(newUser);
        return newUser;
    }

    public int  getBalance(Integer clientId) throws UserNotFoundException {
        return data.getUserByID(clientId).getBalance();
    }

    public User getUser(Integer userId)  throws UserNotFoundException {
        return data.getUserByID(userId);
    }

    public void sendMoney(Integer senderId, Integer recipientId, int moneySum) throws UserNotFoundException, IllegalTransactionException {
        User sender = data.getUserByID(senderId);
        User recipient = data.getUserByID(recipientId);


        if (moneySum < 0 || sender.getBalance() < moneySum) {
            throw new IllegalTransactionException("Not enough money");
        }

        transactions.add(new Transaction(sender, recipient, moneySum));
    }

    public Transaction[] getTransactions(Integer clientId) throws UserNotFoundException {
       return data.getUserByID(clientId).getTransactions().toArray();
    }

    public void removeTransaction(Integer clientId, UUID transactionId) throws UserNotFoundException, TransactionNotFoundException {
        data.getUserByID(clientId).getTransactions().removeById(transactionId);
    }

    public Transaction[] checkTransactions() {
        TransactionsList unpaired = new TransactionsLinkedList();
        Transaction[] tr = transactions.toArray();

        for (Transaction t : tr) {
            if (t.getSender().getTransactions().getById(t.getIdentifier()) == null ||
                t.getRecipient().getTransactions().getById(t.getIdentifier()) == null) {
                unpaired.add(t);
            }
        }
        return unpaired.toArray();
    }

    public boolean isEmpty() {
        return data.numberOfUsers() == 0;
    }

}
