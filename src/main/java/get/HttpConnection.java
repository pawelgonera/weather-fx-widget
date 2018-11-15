package get;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpConnection
{
    private HttpsURLConnection connection;

    public HttpConnection(String url)
    {
        try
        {
            connection = (HttpsURLConnection) new URL(url).openConnection();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String connect()
    {
        String response = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())))
        {
            response = reader.readLine();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return response;
    }
}

