package service;

import data.Data;
import data.User;
import data.UserType;
import request.Request;
import request.RequestType;

public class ClientService implements Service {

    @Override
    public void serve(Request request) {
        User user = Data.getUserByToken(request.getToken());
        if (user != null && user.getUserType() == UserType.CLIENT) {
            RequestType requestType = request.getRequestType();
            switch (requestType) {
                case GET_CLIENT_BALANCE :
                    request.doServerAnswer(user.getName() + ", " + Data.CLIENT_FINANCE_ANSWER);
                    break;
                case GET_CLIENT_PAY :
                    request.doServerAnswer(user.getName() + ", " + Data.CLIENT_FINANCE_ANSWER);
                    break;
                case GET_CLIENT_DELIVERY :
                    request.doServerAnswer(user.getName() + ", " + Data.CLIENT_LOGISTIC_ANSWER);
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
