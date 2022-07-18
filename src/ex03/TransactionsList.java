package ex03;

import java.util.UUID;

public interface TransactionsList {
    public void add(Transaction transaction);
    public void removeById(String id) throws TransactionNotFoundException;
    public Transaction[] toArray();
}