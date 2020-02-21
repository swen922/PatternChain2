package service;

import data.Data;
import request.Request;

public class SecurityService implements Service {

    private Service nextService;

    public SecurityService(Service nextService) {
        this.nextService = nextService;
    }

    @Override
    public void serve(Request request) {
        if (Data.isServiceOK()) {
            nextService.serve(request);
        }
        else {
            request.doServerAnswer(Data.SECURITY_RESTRICT);
        }
    }
}
