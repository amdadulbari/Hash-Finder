package apis;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import connections.HttpConnection;
import constants.SettingsConstant;

import java.io.IOException;

public class Leakz {
    public boolean doCrack(String hash) {
        HttpConnection httpConnection = new HttpConnection();
        try {
            String response = httpConnection.run("https://lea.kz/api/hash/" + hash);
            if (response != null) {
                JsonObject responseObject = Json.parse(response).asObject();
                String password = responseObject.getString("password", "");
                if (!password.isEmpty()) {
                    System.out.println(SettingsConstant.decryptMSG + password);
                    return true;
                }
            }

        } catch (IOException e) {

        }
        return false;
    }
}
