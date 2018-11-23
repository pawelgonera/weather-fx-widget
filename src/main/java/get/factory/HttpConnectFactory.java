package get.factory;

import get.HttpConnection;

public class HttpConnectFactory
{
    public static HttpConnection getConnection(String url)
    {
        return new HttpConnection(url);
    }
}
