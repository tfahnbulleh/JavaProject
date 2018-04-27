/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataprotection;

import fileexplore.Decrypt;
import fileexplore.Encrypt;
import fileexplore.FileExplorerOperation;
import fileexplore.FileOperation;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class DataProtection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         JOptionPane.showMessageDialog(null,"Data Protection Software:\n"
                + "This program uses dual encryption\nprocedure to ecrypt your data.");
             
             String userInput;
             FileExplorerOperation operation;//
             FileOperation fileOperation;
             
             while(true)
             {
                 
                  userInput=JOptionPane.showInputDialog(null,ProgramMenu().toString()); //display program menu
             
             //the user press the cancel button of the inout dialog
             if (userInput==null) 
             {
                 JOptionPane.showMessageDialog(null,"Program will exist."); //show message dialog
                 System.exit(0);//exit program
             }
             
             //the ok button is press of the input dialog
             switch(userInput)
             {
                 case "1":
                     try
                     {
                     operation=new FileExplorerOperation("txt","Text File"); //new FileExplorerOperation object
                     
                     operation.OpenFileExplorerToSelecFile(); //method call to open file explorer for the user to select a text file
                     
                     fileOperation=new FileOperation(operation.getmFile()); //new object of FileOperation class
                     
                     fileOperation.ReadFile(); //method call to read the file selected by the user
                     
                     Encrypt encrypt=new Encrypt(fileOperation.getBuilder().toString()); //new object of Encrypt class the data to be encrypted is pass as argument to the constructor
                     
                     encrypt.EncryptData(); //method call to encrypt the data
                     
                     JOptionPane.showMessageDialog(null,"Select the path you wish to save the encrypted data."); //show message dialog
                     
                     fileOperation.SaveFIleUsingSaveFileDialog(encrypt.getEncryptedData());//method call to open the save file dialog to save the encrypted file
                     
                     JOptionPane.showMessageDialog(null,"File successfully encrypted and save."); //show message dialog
                     }
                     
                     //program encounter error this far
                     //catch FileNotFoundExcetion
                     catch(FileNotFoundException ex)
                     {
                         JOptionPane.showMessageDialog(null,"File not found error occur");//show message dialog
                     }
                     
                      //catch IOExcetion
                     catch(IOException ex)
                     {
                         JOptionPane.showMessageDialog(null,"An input output error has occur");//show message dialog
                     }
                     
                      //catch all Excetionnot catch above
                     catch(Exception ex)
                     {
                          JOptionPane.showMessageDialog(null,"An unknown error has occur. This error is either because the operation was cancel");
                     }
                      break; //break out of the switch statement
                 case "2":
                     try
                     { 
                        operation=new FileExplorerOperation("txt","Text File"); //new FileExplorerOperation object
                     
                        operation.OpenFileExplorerToSelecFile(); //method call to open file explorer for the user to select a text file
                     
                        fileOperation=new FileOperation(operation.getmFile()); //new object of FileOperation class
                     
                        fileOperation.ReadFile(); //method call to read the file selected by the user
                     
                        Decrypt decrypt=new Decrypt(fileOperation.getBuilder().toString()); //new object of Decrypt class. The data to encrypt is pass as argument to the constructor
                        
                        decrypt.UnprotectData(); //method call to decrypt the data
                        
                        JOptionPane.showMessageDialog(null,"Select the path you wish to save the decrypted data."); //show message dialog
                        
                        fileOperation.SaveFIleUsingSaveFileDialog(decrypt.getDeCryptedData()); ////method call to open the save file dialog to save the decrypted file
                        
                        JOptionPane.showMessageDialog(null,"File successfully decrypted and save."); //show message dialog
                        
                        
                     }
                     
                     catch(FileNotFoundException ex)
                     {
                         JOptionPane.showMessageDialog(null,"File not found error occur");
                     }
                     catch(IOException ex)
                     {
                         JOptionPane.showMessageDialog(null,"An input output error has occur");
                     }
                     catch(Exception ex)
                     {
                         JOptionPane.showMessageDialog(null,"An unknown error has occur. This error is either because the operation was cancel");
                     }
                      break;
                 case "3":
                     JOptionPane.showMessageDialog(null,"Program will exist.");
                     System.exit(0);
                     
                 default:
                      JOptionPane.showMessageDialog(null,"Program will exist.");
                      System.exit(0);
             }
             }   
    }
    
    
    
    //program menu
     public static StringBuilder ProgramMenu()
    {
        StringBuilder builder=new StringBuilder();
        builder.append("Press 1 to encrypt a text file"+"\n");
        builder.append("Press 2 to decrypt an encrypted text file"+"\n");
        builder.append("Press 3 to Quit");
       return builder;
    }
}
