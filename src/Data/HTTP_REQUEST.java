package Data;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import static java.lang.System.out;

public class HTTP_REQUEST
{

    private final String POKEAPI_SPRITE_URL = "https://raw.githubusercontent" +
            ".com/PokeAPI/sprites/master/sprites/pokemon/";
    private final String sprite_type = ".png"; // image file type to concat to url
    private URL poke_query; // the URL object that represents a full query
    private HttpURLConnection connection; // the http connection
    private int pkmn_number; // pokemons number in dex

    public HTTP_REQUEST(){}
    public HTTP_REQUEST(int num) throws IOException
    {
        pkmn_number = num;
        poke_query = create_sprite_URL(pkmn_number);
        connection = get_sprite_connection(poke_query);
    }

    /* methods */
    public URL create_sprite_URL( int number) throws MalformedURLException
    {
        try{
            return new URL(POKEAPI_SPRITE_URL + number + sprite_type);

        } catch(MalformedURLException mf)
        {
            out.println("BAD URL: RETURNING NULL");
            return new URL(" ");
        }
    }

    public HttpURLConnection get_sprite_connection(URL p_query) throws IOException
    {
        return (HttpURLConnection) p_query.openConnection();
    }


    public String get_URL()
    {
        return POKEAPI_SPRITE_URL + pkmn_number + sprite_type;
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
