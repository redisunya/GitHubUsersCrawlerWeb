package service;

import model.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    static Map<String, UserProfile> users = new HashMap<>();

    public static boolean addUser(String login, String email, String password) {
        if (users.containsKey(login)) {
            return false;
        } else {
            users.put(login, new UserProfile(login, email, password));
            return true;
        }
    }

}
