package pl.koisuru.tududu;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by uczen on 2017-10-07.
 */

public class Internet {

    public static String odpowiedz(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean has = scanner.hasNext();
            if (has){
                return scanner.next();
            }else { return null;}

        }finally {
            urlConnection.disconnect();
        }
    }




}
