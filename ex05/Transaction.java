package ex05;

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
        this.transferAmount = transferAmount;
        this.transferCategory = TransferCategory.CREDITS;

        makeTransaction();
        sender.getTransactions().add(new Transaction(identifier, sender, recipient, transferAmount, TransferCategory.CREDITS, this.transferResult));
        recipient.getTransactions().add(new Transaction(identifier, sender, recipient, transferAmount, TransferCategory.DEBITS, this.transferResult));
    }

    private Transaction(UUID id, User sender, User recipient, int transferAmount, TransferCategory transferCategory, TransferResult transferResult) {
        this.identifier = id;
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        this.transferResult = transferResult;
        this.transferAmount = transferAmount;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public TransferCategory getTransferCategory() {
        return transferCategory;
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

    public void showShortData() {
        if (transferCategory == transferCategory.CREDITS) {
            System.out.println("To " + recipient.getName() + "(id=" + recipient.getIdentifier() + ") " + -transferAmount + " with id = " + identifier);
        } else {
            System.out.println("From " + sender.getName() + "(id=" + sender.getIdentifier() + ") " + transferAmount + " with id = " + identifier);
        }
    }

    private void makeTransaction() {
            transferResult = TransferResult.FAILURE;
        if (sender.getBalance() > transferAmount) {
            transferResult = TransferResult.SUCCESS;
            sender.setBalance(sender.getBalance() - transferAmount);
            recipient.setBalance(recipient.getBalance() + transferAmount);
        }
    }

}

