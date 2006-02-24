package de.gridlogged.remoteworks.net;

public class Function
{
    public static final int FUNCTION_HELLO   = 00;
    public static final int FUNCTION_IDENT   = 01;
    public static final int FUNCTION_VERSION = 02;
    
//  public static final int FUNCTION_ = 03;
//  public static final int FUNCTION_ = 04;
    
    public static final int FUNCTION_OK  = 05;
    public static final int FUNCTION_ERR = 06;

//  public static final int FUNCTION_ = 07;

    public static final int FUNCTION_CHAT = 10;

    
    private int functionCode;
    private String parameters;
    
    public Function(String p_string)
    {
        functionCode = p_string.getBytes()[0];
        
        if (p_string.length() > 1)
        {
            parameters = p_string.substring(1);
        }
        else
        {
            parameters = "";
        }
    }
    
    public Function(int p_fCode, String p_parameters)
    {
        functionCode = p_fCode;
        parameters = p_parameters;
    }

    public Function(int p_fCode)
    {
        new Function(p_fCode, "");
    }
    
    
    
    public int getFunctionCode()
    {
        return functionCode;
    }

    public String getParamters()
    {
        return parameters;
    }
}
