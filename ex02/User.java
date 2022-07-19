package ex02;

public class User {
    private final Integer id;
    private String name;
    private int balance;

    public User(String name, int balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = (balance > 0) ? balance : 0;
    }

    public int getBalance() {
        return balance;
    }

    public Integer getIdentifier() {
        return id;
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
