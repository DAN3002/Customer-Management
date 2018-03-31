package Main;

import IO.Check_Duplicate;
import IO.File_Factory;
import IO.Index;
import IO.Input;
import Model.Khach_Hang;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Quan_Ly_Khach_Hang 
{    
    public static ArrayList<Khach_Hang> arr = new ArrayList<>();
    
    public static void Start() throws IOException, FileNotFoundException, ClassNotFoundException
    {         
        System.out.println("1 : View customer list.");
        System.out.println("2 : Add new customer.");
        System.out.println("3 : Delete customer.");
        System.out.println("4 : Change customer.");
        System.out.println("5 : Find customer.");
        System.out.println("6 : Save customer list to File.");
        System.out.println("7 : Exit.");
        System.out.print("What do you want to do: ");
        int a = Input.Active(7);
        switch(a)
        {
            case 1 : {Show_All(); break;} 
            case 2 : {Add(); break;} 
            case 3 : {Delete(); break;}
            case 4 : {Change_Infomatino(); break;}
            case 5 : {Find(); break;}
            case 6 : {Output_File(); break;}
        }     
    }

    public static void Show_All() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("-------------------------------------------------");
        if(arr.isEmpty())
        {
            System.out.println("Customer list is null!");
        }
        else
        {
            for(int i = 0; i < arr.size(); i++)
            {           
                Print_Inf(arr.get(i));                
            }
        }
        System.out.println("-------------------------------------------------");        
        Start();
    }
    
    public static void Add() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("-------------------------------------------------");
// Input      
        System.out.print("-) Enter Customer Id to add: ");
        String id = Input.Id();
        if(!Check_Duplicate.Id(id))
        {
            System.out.print("The Id you entered is identical, please enter it again: ");
            id = Input.Id();
        }
        System.out.print("-) Enter Customer Name to add: ");
        String name = Input.Name();
        System.out.print("-) Enter Customer Phone number to add: ");
        String phone = Input.Phone();   
        if(!Check_Duplicate.Phone(phone))
        {
            System.out.print("The Phone number you entered is identical, please enter it again: ");
            phone = Input.Phone();  
        }     
// Creat new Khach_Hang by input information        
        Khach_Hang kh = new Khach_Hang(id, name, phone);
// Add to list        
        arr.add(kh);
// Save        
        System.out.println("[Successfully added to the list!]");
        Save();
        System.out.println("-------------------------------------------------");        
        Start();
    }
            
    public static void Save() throws IOException
    {
        File_Factory.Output(); 
        System.out.println("[Successfully saved the list!]");
        
    }
    
    public static void Print_Inf(Khach_Hang kh)
    {
        System.out.println("ID: " + kh.getId());
        System.out.println("Name: " + kh.getName());
        System.out.println("Phone number: " + kh.getPhone());
        System.out.println();
    }
    
    public static void Delete() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("-------------------------------------------------");
// Input        
        System.out.print("Enter Customer Id to delete: ");
        String id = Input.Id();
        while(Check_Duplicate.Id(id))
        {
            System.out.print("The Id you entered is identical, please enter it again: ");
            id = Input.Id();
        }
// Delete        
        for(int i = 0; i < arr.size(); i++)
        {
            if(id.equals(arr.get(i).getId()))
            {
                arr.remove(i);
                break;
            }
        }
// Save        
        System.out.println("[Successfully delete the Customer!]");
        Save();
        System.out.println("-------------------------------------------------");            
        Start();
    }
    
    public static void Change_Infomatino() throws IOException, FileNotFoundException, ClassNotFoundException
    {
// Input         
        System.out.println("-------------------------------------------------");
        System.out.print("Enter Customer Id to change: ");
        String id = Input.Id();
        while(Check_Duplicate.Id(id))
        {
            System.out.print("The id you entered is not available, please enter it again: ");
            id = Input.Id();
        }   
        int location = Index.by_Id(id);
        System.out.println("1: Name: " + arr.get(location).getName());
        System.out.println("2: Phone number: " + arr.get(location).getPhone());
        System.out.print("What do you want to change: ");        
// Change
        switch(Input.Active(2))
        {
            case 1 :
            {
                System.out.print("Enter new Name to change:");
                arr.get(location).setName(Input.Name());
                break;
            }
            case 2 :
            {
                System.out.print("Enter new Phone number to change: ");
                arr.get(location).setPhone(Input.Phone());
                break;
            }                        
        }
// Save        
        Save();
        System.out.println("-------------------------------------------------");        
        Start();
    }
    
    public static void Find() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        
//  Var
        int location;
// Input and Find
        System.out.println("-------------------------------------------------");        
        System.out.println("1: Id");
        System.out.println("2: Name");
        System.out.println("3: Phone number");        
        System.out.print("What you want to search: ");        
        switch(Input.Active(3))
        {
            case 1: 
            {
                System.out.print("Enter Customer Id to find: ");                
                location = Index.by_Id(Input.Id());
                if(location != -1)
                {
                    System.out.println("");
                    Print_Inf(arr.get(location));                    
                }
                else
                {
                    System.out.println("[No Result!]");
                }
                break;
            }
            case 2: 
            {
                System.out.print("Enter Customer Name to delete:");
                location = Index.by_Name(Input.Name());
                if(location != -1)
                {
                    System.out.println("");                    
                    Print_Inf(arr.get(location));                    
                }
                else
                {
                    System.out.println("[No Result!]");
                }
                break;
            }
            case 3: 
            {
                System.out.print("Enter Customer Phone number to delete:");
                location = Index.by_Phone(Input.Phone());
                if(location != -1)
                {
                    System.out.println("");                    
                    Print_Inf(arr.get(location));                    
                }
                else
                {
                    System.out.println("[No Result!]");
                }
                break;
            }            
        }
        System.out.println("-------------------------------------------------");        
        Start();
    }
    
    public static void Output_File() throws IOException, FileNotFoundException, ClassNotFoundException
    {
        System.out.println("-------------------------------------------------");         
        File_Factory.Output_Text();
        System.out.println("[Successfully saved File!]");
        System.out.println("[File was saved in D:]");
        System.out.println("-------------------------------------------------");    
        Start();
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException 
    {
        File_Factory.Input();         
        Start();
    }
    
}
