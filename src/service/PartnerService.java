package service;

import data.Data;
import data.User;
import data.UserType;
import request.Request;
import request.RequestType;

public class PartnerService implements Service {

    @Override
    public void serve(Request request) {
        User user = Data.getUserByToken(request.getToken());
        if (user != null && user.getUserType() == UserType.PARTNER) {
            RequestType requestType = request.getRequestType();
            switch (requestType) {
                case GET_PARTNER_BALANCE :
                    request.doServerAnswer(user.getName() + ", " + Data.PARTNER_FINANCE_ANSWER);
                    break;
                case GET_PARTNER_PAY :
                    request.doServerAnswer(user.getName() + ", " + Data.PARTNER_FINANCE_ANSWER);
                    break;
                case GET_PARTNER_TASK :
                    request.doServerAnswer(user.getName() + ", " + Data.PARTNER_LOGISTIC_ANSWER);
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
