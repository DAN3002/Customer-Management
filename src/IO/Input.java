package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input 
{
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));   
    
    public static int Active(int max) throws IOException
    {
        int a;
        try 
        {
            a = Integer.parseInt(Input.in.readLine());
            if(a > max || a <= 0)
            {
                System.out.print("You entered incorrectly! Please re-enter: ");
                a = Active(7);                
            }
            
        } catch (Exception e) 
        {
            System.out.print("You entered incorrectly! Please re-enter: ");
            a = Active(7);
        }
        return a;
    }    
    
    public static String Id() throws IOException
    {
        return in.readLine();
    }    
    
    public static String Name() throws IOException
    {
        return in.readLine();
    }     
    
    public static String Phone() throws IOException
    {        
        String str = in.readLine();
        if(str.length() < 10 || str.length() > 11)
        {
            System.out.print("The Phone number you entered is wrong, please enter it again:");
            str = Phone();
        }
        else
        {
            for(int i = 0; i < str.length(); i++)
            {
                if(!"0123456789".contains(str.charAt(i) + ""))
                {
                    System.out.print("The Phone number you entered is wrong, please enter it again:");
                    str = Phone();
                    break;
                }
            }
        }
        return str;
    }     
    
}
