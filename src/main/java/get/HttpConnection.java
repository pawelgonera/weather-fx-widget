package get;

import exception.WrongServerStatusException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
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

        }catch (IOException e)
        {
            throw new WrongServerStatusException(e);
        }
    }

    public String connect()
    {
        serverResponseValidate();
        String response;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())))
        {
            response = reader.readLine();

        }catch (IOException e)
        {
            throw new WrongServerStatusException(e);
        }

        return response;
    }

    private void serverResponseValidate() {
        try
        {
            int responseCode =  connection.getResponseCode();
            if(responseCode != 200)
            {
                String statusMessage = connection.getResponseMessage();
                throw new WrongServerStatusException("Server have a problem :( code: " + responseCode + " - " + statusMessage);
            }

        } catch (IOException e)
        {
            throw new WrongServerStatusException(e);
        }
    }
}

