package ex00;

import java.util.UUID;

public class Transaction {
    private final UUID identifier;
    private final User recipient;
    private final User sender;
    private final TransferCategory transferCategory;
    private TransferResult transferResult;
    private final int transferAmount;

    private enum TransferCategory {
        DEBITS,
        CREDITS
    }

    private enum TransferResult {
        FAILURE,
        SUCCESS
    }

    public Transaction(User sender, User recipient, int transferAmount) {
        this.identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.transferAmount = transferAmount > 0 ? transferAmount : -transferAmount;
        this.transferCategory = transferAmount > 0 ? TransferCategory.DEBITS : TransferCategory.CREDITS;

        makeTransaction();
    }

    public String getIdentifier() {
        return identifier.toString();
    }

    public void displayInfo() {
        System.out.println("Transaction ID:" + getIdentifier());
        System.out.println("Sender: " + sender.getName());
        System.out.println("Recipient: " + recipient.getName());
        System.out.println("Transfer amount: " + transferAmount + "$, Type: " + transferCategory);
        if (transferResult == TransferResult.SUCCESS) {
            System.out.println("Result: \033[32m" + transferResult + "\033[0m");
        } else {
            System.out.println("Result: \033[31m" + transferResult + "\033[0m");
        }
    }

    private void makeTransaction() {
        if (sender.getBalance() < transferAmount) {
            transferResult = TransferResult.FAILURE;
        } else {
            transferResult = TransferResult.SUCCESS;
            sender.setBalance(sender.getBalance() - transferAmount);
            recipient.setBalance(recipient.getBalance() + transferAmount);
        }

    }





}
