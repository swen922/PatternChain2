package service;

import data.Data;
import request.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LoginService implements Service {

    private Service nextService;

    public LoginService(Service nextService) {
        this.nextService = nextService;
    }

    @Override
    public void serve(Request request) {
        String token = Data.loginPassToken(request.getLogin(), request.getPass());
        if (token != null && !token.isEmpty()) {
            request.grantLogin(token);
            nextService.serve(request);
        }
        else {
            request.doServerAnswer(Data.LOGIN_FAILED);
        }
    }

}
