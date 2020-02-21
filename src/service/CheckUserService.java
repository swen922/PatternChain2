package service;

import data.Data;
import request.Request;

public class CheckUserService implements Service {

    private Service nextService;

    public CheckUserService(Service nextService) {
        this.nextService = nextService;
    }

    @Override
    public void serve(Request request) {
        if (Data.isUserActive(request.getLogin()) && Data.isUserPermitted(request.getLogin())) {
            nextService.serve(request);
        }
        else {
            request.doServerAnswer(Data.USER_BLOCKED);
        }
    }
}
