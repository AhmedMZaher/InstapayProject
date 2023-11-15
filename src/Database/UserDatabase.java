package Database;

import MainClasses.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UserDatabase implements Database {

    private static UserDatabase instance;
    private List<User> usersList;

    private UserDatabase() {
        usersList = new ArrayList<>();
    }

    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    @Override
    public void read() {

    }

    @Override
    public void write() {

    }


    public List<User> getUsersList() {
        return usersList;
    }

    public void addUser(User user) {
        usersList.add(user);
    }
}
