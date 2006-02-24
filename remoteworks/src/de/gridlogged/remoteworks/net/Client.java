package de.gridlogged.remoteworks.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Communicator
{
    private Socket socket;
    
    
    public void connect(String p_host, int p_port) throws Exception
    {
        socket = new Socket(p_host, p_port);
        
        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
    }
}
