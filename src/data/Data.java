package data;

import java.util.*;

public class Data {

    public static Map<Integer, User> users = new HashMap<>();
    public static Map<Integer, String> tokens = new HashMap<>();

    private static String symbols = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static final String LOGIN_FAILED = "Failed to login into system!\n";
    public static final String LOGIN_EXPIRED = "Your Password is expired. Please update!\n";
    public static final String USER_BLOCKED = "This user is blocked. Please refer to Your manager!\n";
    public static final String SECURITY_RESTRICT = "Server is under attack. Please wait!\n";

    public static final String CLIENT_FINANCE_ANSWER = "You have got Client Finance Service!\n";
    public static final String CLIENT_LOGISTIC_ANSWER = "You have got Client Logistic Service!\n";
    public static final String PARTNER_FINANCE_ANSWER = "You have got Partner Finance Service!\n";
    public static final String PARTNER_LOGISTIC_ANSWER = "You have got Partner Logistic Service!\n";
    public static final String COURIER_FINANCE_ANSWER = "You have got Courier Finance Service!\n";
    public static final String COURIER_LOGISTIC_ANSWER = "You have got Courier Logistic Service!\n";

    public static final String ERROR = "Can not serve. Error into system!\n";


    // Emulate users list
    public static void populateUsers(int quantity) {
        for (int i = 0; i < quantity; i++) {
            User user = new User(i, "User-"+i, "Pass-"+i, "Name-" + i, generateUserType());
            users.put(i, user);
        }
    }


    // основной логин метод
    public static String loginPassToken(String login, String pass) {
        User user = getUserByLogin(login);
        if (user != null && user.getPass().equals(pass)) {
            return getToken(user.getIdNumber());
        }
        return null;
    }


    public static boolean isPassActive(String login) {
        int coin = (int) (Math.random() * 10);
        return (coin == 0 ? false : true);
    }

    public static boolean isUserActive(String login) {
        int coin = (int) (Math.random() * 20);
        return (coin == 0 ? false : true);
    }

    public static boolean isUserPermitted(String login) {
        int coin = (int) (Math.random() * 20);
        return (coin == 0 ? false : true);
    }

    public static boolean isServiceOK() {
        int coin = (int) (Math.random() * 10);
        return (coin == 0 ? false : true);
    }


    public static User getRandomUser() {
        int pos = (int) (Math.random() * users.size());
        List<User> userList = new ArrayList<>();
        userList.addAll(users.values());
        return userList.get(pos);
    }

    private static User getUserByLogin(String login) {
        User result = null;
        for (User user : users.values()) {
            if (user.getLogin().equals(login)) {
                result = user;
                break;
            }
        }
        return result;
    }


    public static User getUserByToken(String token) {
        Iterator<Map.Entry<Integer, String>> iter = tokens.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, String> entry = iter.next();
            if (token.equals(entry.getValue())) {
                return users.get(entry.getKey());
            }
        }
        return null;
    }


    private static String getToken(int idUser) {
        if (tokens.containsKey(idUser)) {
            return tokens.get(idUser);
        }
        String token = generateToken(idUser);
        tokens.put(idUser, token);
        return token;
    }

    private static String generateToken(int idUser) {
        char[] chars = symbols.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(idUser)).append("_");
        for (int i = 0; i < 10; i++) {
            int pos = (int) (Math.random() * chars.length);
            sb.append(chars[pos]);
        }
        return sb.toString();
    }

    private static UserType generateUserType() {
        int pos = (int) (Math.random() * UserType.values().length);
        return UserType.values()[pos];
    }


}
