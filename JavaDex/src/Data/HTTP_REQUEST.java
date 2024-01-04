package Data;


import java.io.IOException;
import java.net.*;

import static java.lang.System.out;

public class HTTP_REQUEST
{

    private final String POKEAPI_SPRITE_URL = "https://raw.githubusercontent" +
            ".com/PokeAPI/sprites/master/sprites/pokemon/";
    private final String sprite_type = ".png";
    private URL poke_query;
    private HttpURLConnection connection;
    private int pkmn_number;

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

}
