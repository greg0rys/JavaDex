import Data.HTTP_BASIC_INFO_REQUEST;
import Data.HTTP_SPRITE_REQUEST;
import Helpers.App_Driver;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;

import static java.lang.System.out;

public class Main
{
    public static void main( String[] args ) throws IOException
    {
        String output = "ditto.jpg";
        App_Driver ad = new App_Driver();
        StringBuffer two = ad.test_run();

        HTTP_SPRITE_REQUEST t = new HTTP_SPRITE_REQUEST(180);
        HTTP_BASIC_INFO_REQUEST b = new HTTP_BASIC_INFO_REQUEST();
        out.println(t.get_URL());
        StringBuffer res = t.read_res();
        out.println(res);
        JSONObject jo = new JSONObject(b.get_name(180));
        out.println(jo.get("id") + " " + jo.get("name"));
        save_image(t, output);

    }

    /**
     * Save the image from the sprite API request
     * @param rq
     * @param dest
     * @throws IOException
     */
    public static void save_image( HTTP_SPRITE_REQUEST rq, String dest) throws IOException
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