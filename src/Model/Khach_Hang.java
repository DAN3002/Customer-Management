package Model;

import java.io.Serializable;

public class Khach_Hang implements Serializable
{
    private String id;    
    private String name;
    private String type;
    private String phone;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;                
    }

    public Khach_Hang() 
    {
        
    }

    public Khach_Hang(String id, String name, String phone) 
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() 
    {                                                               
        return this.id + "_" + this.name + "_" + this.phone;
    }            
}
