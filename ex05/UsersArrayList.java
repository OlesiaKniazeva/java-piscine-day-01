package ex05;

class UsersArrayList implements UsersList {

        private User[] users;
        private int size;
        private int max_size;

        private static final int DEFAULT_CAPACITY = 10;


         UsersArrayList() {
            users = new User[DEFAULT_CAPACITY];
            size = 0;
            max_size = DEFAULT_CAPACITY;

        }

        public void add(User user) {
            if (size > max_size - 1) {
                User[] new_users;

                max_size = (int)(max_size * 1.5) + 1;
                new_users = new User[max_size];
                for (int i = 0; i < size; ++i) {
                    new_users[i] = users[i];
                }
                users = new_users;
            }
            users[size] = user;
            size++;
        }

        public User getUserByID(Integer id) throws UserNotFoundException {
            for (int i = 0; i < size; ++i) {
                if (users[i].getIdentifier().equals(id)) {
                    return users[i];
                }
            }
            throw new UserNotFoundException("No user found");
        }

        public User getUserByIndex(int index) {
            return users[index];
        }

        public int numberOfUsers() {
            return size;
        }

    }
