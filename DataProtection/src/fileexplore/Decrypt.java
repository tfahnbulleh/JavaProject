/*
 * Decrypt a text file that has been encrypted by this program
 */
package fileexplore;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class Decrypt extends ROT13Encryption
{
    //constructor
    public Decrypt(String data)
    {    super(data);
    }
    
    //return getEncryptedData() of the super calss
    public String getDeCryptedData()
    {
        return super.getEncryptedData();
    }
    
    //retrun the mDataToEncrypt
    public String getDataToEncrypt()
    {
        return super.mDataToEncrypt;
    }
    
    //decrypt the data
public void UnprotectData() 
{
    Scanner scanner=new Scanner(super.mDataToEncrypt); //new scanner object
   
    super.mDataToEncrypt=""; //set the value of super class member variable
    
    try
    {
        //while the are more lines to read in scanner
        while(scanner.hasNextLine())
         {
             String currentLine=scanner.nextLine(); //get the next line of text from scanner
             currentLine=currentLine.replaceAll("100P@A90C=0",""); //replace all occurance
             currentLine=currentLine.replaceAll("5643Data000DATATAATAGUESSBEHINDME","");//replace all occurance
             StringBuilder builder=new StringBuilder(currentLine).reverse(); //string builder object
             super.mDataToEncrypt+=builder+System.getProperty("line.separator"); //append the value of builder to super class member variable mDataToEncrypt 
             super.Encrypt();//super class method call
         }
    }
    catch (Exception ex)     
    {
       
    }
    finally
    {
        scanner.close();
    }
   
    
    
   
   
   
}
}
