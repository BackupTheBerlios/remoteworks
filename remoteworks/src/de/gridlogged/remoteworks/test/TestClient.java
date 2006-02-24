package de.gridlogged.remoteworks.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import de.gridlogged.remoteworks.net.Client;
import de.gridlogged.remoteworks.net.Function;

public class TestClient
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Client c = new Client();
        try
        {
            c.connect("localhost", 4711);
            
            c.send(new Function(Function.FUNCTION_HELLO));
            
            BufferedReader l_console = new BufferedReader(new InputStreamReader(System.in));
            
            String l_line;
            while ((l_line = l_console.readLine()) != null)
            {
                c.send(new Function(Function.FUNCTION_CHAT, l_line));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
