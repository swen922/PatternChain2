package request;

public class Request {

    // Эти поля даются запросу при создании
    private RequestType requestType;
    private String login;
    private String pass;

    // А это поле присваивает сервер, если логин успешный
    private String token;

    public Request(RequestType requestType, String login, String pass) {
        this.requestType = requestType;
        this.login = login;
        this.pass = pass;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void grantLogin(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void doServerAnswer(String answer) {
        System.out.println(answer);
    }

}
