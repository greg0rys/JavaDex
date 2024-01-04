import Data.HTTP_REQUEST;

import java.io.IOException;

import static java.lang.System.out;

public class Main
{
    public static void main( String[] args ) throws IOException
    {

        HTTP_REQUEST t = new HTTP_REQUEST(132);
        out.println(t.get_URL());
    }
}