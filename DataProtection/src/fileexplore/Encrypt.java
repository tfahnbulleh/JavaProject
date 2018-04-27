/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexplore;

import java.util.Scanner;


/**
 *
 * @author tfahn
 */
public class Encrypt extends ROT13Encryption
{
    
    public Encrypt(String dataToEncrypt)
    {
        super(dataToEncrypt);
    }
    
    public void EncryptData()
    {
        super.Encrypt();
        this.TransfromData();
    }
    
    @Override
    public String getEncryptedData()
    {
        return super.getEncryptedData();
    }

    
   private void TransfromData()
   {
       
        Scanner scanner=new Scanner(super.getEncryptedData()); 
        super.mEncryptedData="";
        while(scanner.hasNextLine())
        {
            StringBuilder builder=new StringBuilder(scanner.nextLine());
            builder=builder.reverse();
            builder.append("100P@A90C=0");
            builder.insert(0,"5643Data000DATATAATAGUESSBEHINDME");
            super.mEncryptedData+=builder.toString()+System.getProperty("line.separator");
        }
        scanner.close();
      
   }
   
}
