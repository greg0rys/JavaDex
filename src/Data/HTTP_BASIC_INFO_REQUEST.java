package Data;

import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTP_BASIC_INFO_REQUEST
{
    private URL poke_query; // the URL object that represents a full query
    private HttpURLConnection connection; // the http connection
    public HTTP_BASIC_INFO_REQUEST(){}

    public String get_name(int number) throws IOException
    {
        poke_query = new URL("https://pokeapi.co/api/v2/pokemon/" + number);
        connection = (HttpURLConnection) poke_query.openConnection();
        return read_res().toString();
    }

    public StringBuffer read_res() throws IOException
    {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer res = new StringBuffer();

        while((inputLine = in.readLine()) != null)
            res.append(inputLine);
        in.close();

        return res;
    }

}
