package apis;

import connections.HttpConnection;
import constants.SettingsConstant;

import java.io.IOException;

public class NitrxGen {
    public boolean doCrack(String hash){

        HttpConnection httpConnection = new HttpConnection();
        try {
            String password = httpConnection.run("http://www.nitrxgen.net/md5db/"+hash);
            System.out.println(password);
            if(!password.trim().isEmpty()){
                System.out.println(SettingsConstant.decryptMSG+password);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
