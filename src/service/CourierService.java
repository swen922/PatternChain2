package service;

import data.Data;
import data.User;
import data.UserType;
import request.Request;
import request.RequestType;

public class CourierService implements Service {

    @Override
    public void serve(Request request) {
        User user = Data.getUserByToken(request.getToken());
        if (user != null && user.getUserType() == UserType.COURIER) {
            RequestType requestType = request.getRequestType();
            switch (requestType) {
                case GET_COURIER_BALANCE :
                    request.doServerAnswer(user.getName() + ", " + Data.COURIER_FINANCE_ANSWER);
                    break;
                case GET_COURIER_PAY :
                    request.doServerAnswer(user.getName() + ", " + Data.COURIER_FINANCE_ANSWER);
                    break;
                case GET_COURIER_TASK :
                    request.doServerAnswer(user.getName() + ", " + Data.COURIER_LOGISTIC_ANSWER);
                    break;
                default :
                    request.doServerAnswer(Data.ERROR);

            }
        }
        else {
            request.doServerAnswer(Data.ERROR);

        }
    }
}
