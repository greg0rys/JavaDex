import Data.HTTP_REQUEST;

import java.io.*;
import java.net.URL;

import static java.lang.System.out;

public class Main
{
    public static void main( String[] args ) throws IOException
    {
        String output = "ditto.jpg";

        HTTP_REQUEST t = new HTTP_REQUEST(350);
        out.println(t.get_URL());
        StringBuffer res = t.read_res();
        out.println(res);
        save_image(t, output);
    }

    /**
     * Save the image from the sprite API request
     * @param rq
     * @param dest
     * @throws IOException
     */
    public static void save_image(HTTP_REQUEST rq, String dest) throws IOException
    {
        URL url = new URL(rq.get_URL());
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(dest);

        byte[] b = new byte[2048];
        int length = 0;

        while ((length = is.read(b)) != -1)
            os.write(b,0,length);

        is.close();
        os.close();
    }
}