package IO;

import static Main.Quan_Ly_Khach_Hang.arr;

public class Index 
{
    public static Integer by_Id(String id)
    {
        int output = -1;
        for(int i = 0 ;i < arr.size(); i++)
        {
            if(arr.get(i).getId().equals(id))
            {
                output = i;
                break;                
            }
        }
        return output;
    }
    
    public static Integer by_Name(String name)
    {
        int output = -1;
        for(int i = 0 ;i < arr.size(); i++)
        {
            if(arr.get(i).getName().equals(name))
            {
                output = i;
                break;                
            }
        }
        return output;
    }
        
    public static Integer by_Phone(String phone)
    {
        int output = -1;
        for(int i = 0 ;i < arr.size(); i++)
        {
            if(arr.get(i).getPhone().equals(phone))
            {
                output = i;
                break;                
            }
        }
        return output;
    }        
}
