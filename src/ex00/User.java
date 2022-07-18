package ex00;

public class User {
    private final Integer identifier;
    private String name;
    private int balance;

    public User(int identifier, String name, int balance) {
        this.identifier = identifier;
        this.name = name;
        this.balance = (balance > 0) ? balance : 0;
    }

    public int getBalance() {
        return balance;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = (balance > 0) ? balance : 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInformationAboutUser() {
        System.out.println(this.getName() + ", Balance: " + this.getBalance() + ", ID: " + this.getIdentifier());
    }
}
