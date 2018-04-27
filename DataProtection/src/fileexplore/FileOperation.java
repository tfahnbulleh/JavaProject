/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


This class is use to open and read from a file
The class has three constructors
 */
package fileexplore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author tfahn
 */
public class FileOperation 
{
    //instance varaible
   // private final String path;
    private StringBuilder builder;
    private File mFile;
    private Scanner scanner;
    private boolean isFileExist;
    
    //constructor
    //use this constructor to read file
    public FileOperation(File file) 
    {
        //   this.path=file.getAbsolutePath();
           builder=new StringBuilder();
           mFile=file;    
    }
    
   
    //methoed is use to read text  file
    public void ReadFile() throws FileNotFoundException  
    {
            scanner=new Scanner(mFile); //new scanner object
           
            while(scanner.hasNext()) //while there are lines to read
            {
                 String currentLine=scanner.nextLine(); //read the nextline in the file and store the result in currentLine
                 builder.append(currentLine+"\n"); //append current line to builder
            }
            scanner.close(); 
    }
    
    //method to write to a file
    public void WriteToFile(boolean overWriteExisting,String dataToWrite) throws IOException
    {
        this.builder=new StringBuilder(dataToWrite);
       
        if (overWriteExisting) 
        {
             byte[] data=this.builder.toString().getBytes(); //get the bytes from builder and assigned it ti data 
            Files.write(Paths.get(this.mFile.getAbsolutePath()+"Encrypt"),data); //write the value of data to file
        }
        else
        {
        
         if (this.isFileExist==false) 
          {
             byte[] data=this.builder.toString().getBytes(); //get the bytes from builder and assigned it to data 
             Files.write(Paths.get(this.mFile.getAbsolutePath()),data); //write the value of data to file
          }
        }   
    }
    
    
    //method to save file using the save file dialog
    //the data to save as text file as pass as argument to the method during method call
    //method also throws Io exception 
    public void SaveFIleUsingSaveFileDialog(String data) throws IOException, Exception
    {
        JFileChooser mFileChooser=new JFileChooser(); //new JFileChooser object
        FileWriter writer=null; //FileWrite object assign null
        Scanner writeScanner=null; //Scanner object
        
        int showSaveDialog = mFileChooser.showSaveDialog(null); //show the saveFile Dialog
       
        if (showSaveDialog==JFileChooser.APPROVE_OPTION) //the user selected the ok button or save button
        {
            File newFile=mFileChooser.getSelectedFile(); //get the file the user selected
         
            //if the file already exist
            if (newFile.exists()) 
            {
                
            }
            
            //file does not exist
            else
            {
                
                try 
                {
                    writer=new FileWriter(newFile);
                    writeScanner=new Scanner(data);
                    while(writeScanner.hasNextLine())
                    {
                        writer.write(writeScanner.nextLine()+System.getProperty("line.separator"));
                    }
                } 
                
                finally
                {
                   writer.close();
                   writeScanner.close();
                }
                
            }
        }
        
        //the user press the cancel button
        else
        {
           JOptionPane.showMessageDialog(null,"Operation Cancel");
        }
    
    }
    

    //return the value of builder
    public StringBuilder getBuilder() 
    {
        return builder;
    }

    //return the value of path
    public String getPath() 
    {
        return mFile.getAbsolutePath();
    }
 
}
