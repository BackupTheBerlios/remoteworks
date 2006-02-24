package de.gridlogged.remoteworks.net;

import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private ServerSocket socket;
    
    public Server(int p_port) throws Exception
    {
        socket = new ServerSocket(p_port);
        
        while (true)
        {
            Socket l_incoming = socket.accept();
            ClientHandler l_handler = new ClientHandler(l_incoming);
        }
    }
}
