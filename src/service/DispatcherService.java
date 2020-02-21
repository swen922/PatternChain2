package service;

import com.sun.istack.internal.NotNull;
import data.Data;
import data.User;
import data.UserType;
import request.Request;
import request.RequestType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherService implements Service {

    private Map<UserType, Service> services = new HashMap<>();

    public DispatcherService(@NotNull Map<UserType, Service> services) {
        this.services = services;
    }

    @Override
    public void serve(Request request) {
        User user = Data.getUserByToken(request.getToken());
        if (user == null ) {
            request.doServerAnswer(Data.ERROR);
            return;
        }

        Service service = services.get(user.getUserType());

        if (service != null) {
            service.serve(request);
        }
        else {
            request.doServerAnswer(Data.ERROR);

        }

    }
}
