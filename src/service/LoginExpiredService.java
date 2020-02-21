package service;

import data.Data;
import request.Request;

public class LoginExpiredService implements Service {

    private Service nextService;

    public LoginExpiredService(Service nextService) {
        this.nextService = nextService;
    }

    @Override
    public void serve(Request request) {
        if (Data.isPassActive(request.getLogin())) {
            nextService.serve(request);
        }
        else {
            request.doServerAnswer(Data.LOGIN_EXPIRED);
        }
    }
}
