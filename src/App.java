import data.Data;
import data.User;
import request.Request;
import request.RequestType;

public class App {

    public static void main(String[] args) {
        EmulateSystem emulateSystem = new EmulateSystem();
        emulateSystem.createSystem(10);
        for (int i = 0; i < 20; i++) {
            emulateSystem.serve(generateRequest());
        }
    }

    private static Request generateRequest() {
        User user = Data.getRandomUser();
        RequestType requestType = null;
        switch (user.getUserType()) {
            case CLIENT:
                requestType = randomRequestType(0, 3);
                break;
            case PARTNER :
                requestType = randomRequestType(3, 6);
                break;
            case COURIER:
                requestType = randomRequestType(6, 9);
        }

        return new Request(requestType, user.getLogin(), user.getPass());
    }

    private static RequestType randomRequestType(int min, int max) {
        int pos = -1;
        while (pos < min) {
            pos = (int) (Math.random() * max);
        }
        return RequestType.values()[pos];

    }
}
