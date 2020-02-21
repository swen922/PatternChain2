package data;

public class User {

    private int idNumber;
    private String login;
    private String pass;
    private String name;
    private UserType userType;

    public User(int idNumber, String login, String pass, String name, UserType userType) {
        this.idNumber = idNumber;
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.userType = userType;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }
}
