package ex01;

public class UserIdsGenerator {

    private static UserIdsGenerator instance;

    private Integer lastId;

    private UserIdsGenerator() {
        this.lastId = 1;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    };

    public Integer generateId() {
         return lastId++;
    }

}
