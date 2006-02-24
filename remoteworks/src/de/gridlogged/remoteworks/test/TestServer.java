package de.gridlogged.remoteworks.test;

import de.gridlogged.remoteworks.net.Server;

public class TestServer
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            new Server(4711);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
