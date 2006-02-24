package de.gridlogged.remoteworks.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Communicator
{
    protected BufferedReader in;
    protected PrintWriter    out;
    
    
    public Function receive() throws IOException
    {
        int l_fCode;
        
        l_fCode = in.read();
        
        if (l_fCode == -1)
        {
            return null;
        }
        
        String l_parm = in.readLine();
        
        Function f = new Function(l_fCode, l_parm);

        return f;
    }

    public void send(Function p_message) throws IOException
    {
        out.write(p_message.getFunctionCode());
        out.print(p_message.getParamters());
        out.write('\n');
        
        out.flush();
    }
    
/*    public String waitFor(byte p_functionCode) throws Exception
    {
        String l_line;
        
        while ((l_line = in.readLine()) != null)
        {
            Function f = new Function(l_line);
            if (f.getFunctionCode() == p_functionCode)
            {
                return f.getParamters();
            }
        }
        return null;
    }*/
}
