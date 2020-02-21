import data.Data;
import data.UserType;
import request.Request;
import service.*;

import java.util.HashMap;
import java.util.Map;

public class EmulateSystem {

    private Service service;

    public EmulateSystem() {
    }

    public void createSystem(int users) {
        Data.populateUsers(users);

        Service clientService = new ClientService();
        Service partnerService = new PartnerService();
        Service courierService = new CourierService();

        Map<UserType, Service> map = new HashMap<>();
        map.put(UserType.CLIENT, clientService);
        map.put(UserType.PARTNER, partnerService);
        map.put(UserType.COURIER, courierService);

        Service dispatcherService = new DispatcherService(map);

        Service checkUserService = new CheckUserService(dispatcherService);
        Service loginExpiredService = new LoginExpiredService(checkUserService);
        Service loginService = new LoginService(loginExpiredService);
        service = new SecurityService(loginService);

    }

    public void serve(Request request) {
        service.serve(request);
    }


}
