package ex04;

public interface UsersList {

    public void add(User user);
    public User getUserByID(Integer id) throws UserNotFoundException;
    public User getUserByIndex(int index);
    public int numberOfUsers();

}
