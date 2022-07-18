package ex03;

import java.util.UUID;

class TransactionsLinkedList implements TransactionsList {
    private Node head;
    private Node last;
    private int size;

    private static class Node {
        private Transaction value;
        private Node next;
        private Node prev;

        Node(Node prev, Transaction value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(Transaction transaction) {
        Node temp;
        Node newNode;

        temp = this.last;
        newNode = new Node(temp, transaction, null);
        this.last = newNode;
        if (head == null) {
            head = newNode;
        } else {
            temp.next = newNode;
        }
        this.size++;
    }

    public void removeById(UUID id) throws TransactionNotFoundException {
        Node t;
        Node prev;
        Node next;

        t = findNodeById(id);
        if (t == null) {
            throw new TransactionNotFoundException("No user found");
        }
        prev = t.prev;
        next = t.next;
        if (prev == null) {
            this.head = next;
        } else {
            prev.next = next;
            t.prev = null;
        }
        if (next == null) {
            this.last = prev;
        } else {
            next.prev = prev;
            t.next = null;
        }
        this.size--;
    }

    private Node findNodeById(UUID id) {
        Node h;

        for (h = head; h != null; h = h.next) {
            if (h.value.getIdentifier().equals(id)) {
                return h;
            }
        }
        return null;
    }

    public Transaction[] toArray() {
        Transaction[] arr;
        Node p;
        int i;

        i = 0;

        arr = new Transaction[size()];

        for (p = head; p != null; p = p.next) {
            arr[i] = p.value;
            ++i;
        }
        return arr;
    }

    private int size() {
        return size;
    }

}
