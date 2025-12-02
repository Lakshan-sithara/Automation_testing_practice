package utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkUtils {

    public static boolean checkLink(String linkUrl){
        boolean result = false;

        try{
            URL url = new URL(linkUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.connect();

            if (conn.getResponseCode() == 200){
                result = true;
            }
        }catch (Exception e){

        }

        return result;
    }

}
