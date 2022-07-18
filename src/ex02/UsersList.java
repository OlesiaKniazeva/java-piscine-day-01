package ex02;

public interface UsersList {

    void add(User user);
    User getUserByID(Integer id) throws UserNotFoundException;
    User getUserByIndex(int index);
    int numberOfUsers();

}
