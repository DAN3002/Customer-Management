package IO;

import static Main.Quan_Ly_Khach_Hang.arr;
import Model.Khach_Hang;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Factory 
{
    public static void Input()throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fi = new FileInputStream("Data\\DB.txt");
        ObjectInputStream input = new ObjectInputStream(fi);
        arr = (ArrayList<Khach_Hang>) input.readObject();   
        input.close();
        fi.close();
    }
    public static void Output() throws FileNotFoundException, IOException
    {
        FileOutputStream fo = new FileOutputStream("Data\\DB.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fo);
        oos.writeObject(arr);
        oos.close();
        fo.close();
    }
    
    public static void Output_Text() throws FileNotFoundException
    {
        FileOutputStream fo = new FileOutputStream("D:\\Khach_hang.txt", false);
        PrintWriter pr = new PrintWriter(fo);
        for(int i = 0; i < arr.size(); i++)
        {
            pr.append(arr.get(i) + "\r\n");
        }
        pr.close();
    }
}