package ex05;

import java.util.UUID;

public interface TransactionsList {
    void add(Transaction transaction);
    void removeById(UUID id) throws TransactionNotFoundException;
    Transaction[] toArray();
    Transaction getById(UUID id);
}