package de.gridlogged.remoteworks.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Communicator implements Runnable
{
    private Socket clientSocket;
    private Thread thread;
    
    
    public ClientHandler(Socket p_incoming) throws Exception
    {
        System.out.println("New client connected from " + p_incoming.getInetAddress());
        
        clientSocket = p_incoming;
        in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream());
        
        thread = new Thread(this);
        thread.start();
    }
    
    public void run()
    {
        Function l_function;
        
        try
        {
            while ((l_function = receive()) != null)
            {
                if (l_function.getFunctionCode() == Function.FUNCTION_CHAT)
                {
                    System.out.println(clientSocket.getInetAddress() + ": " + l_function.getParamters());
                }
            }
            System.out.println("Client disconnected");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
