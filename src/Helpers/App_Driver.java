package Helpers;

import Data.HTTP_SPRITE_REQUEST;

import java.io.IOException;

public class App_Driver
{
    private StringBuffer sprite_buffer;

    public App_Driver() throws IOException
    {

    }

    public StringBuffer test_run() throws IOException
    {
        HTTP_SPRITE_REQUEST sprite_request = new HTTP_SPRITE_REQUEST(296);
        return sprite_buffer = new StringBuffer(sprite_request.read_res());

    }
}
