package get.factory;

import get.HttpConnection;

public class HttpConnectFactory
{
    public HttpConnection getConnection(String url)
    {
        return new HttpConnection(url);
    }
}
