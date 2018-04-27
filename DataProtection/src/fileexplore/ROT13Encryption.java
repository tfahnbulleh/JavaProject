/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileexplore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class ROT13Encryption 
{
    protected String mEncryptedData;
    protected String mDataToEncrypt;
    private final List<Character> mUPPERALPHATBETS;
    private final List<Character> mLOWERALPHATBETS;
    private char[] mCharArray;
    public ROT13Encryption(String dataToEncrypt)
    {
        this.mDataToEncrypt=dataToEncrypt;
        this.mUPPERALPHATBETS = new ArrayList(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
        this.mLOWERALPHATBETS = new ArrayList(Arrays.asList('a','b','C','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));  
    }
    
    protected String getEncryptedData()
    {
        return this.mEncryptedData;
    }
    
    private void ToArray()
   {
       this.mCharArray=this.mDataToEncrypt.toCharArray();
   }
    
    private void ToString()
   {
       String s=new String(this.mCharArray);
       this.mEncryptedData=s;
   }
    
    private boolean IsUpperCase(char ch )
   {
       return Character.isUpperCase(ch);
   }
    
     private int FindCharacterPosition(char ch)
   {
         boolean isUpper=IsUpperCase(ch);
         int postion=-1;
          if (isUpper) 
             {
                 postion=mUPPERALPHATBETS.indexOf(ch);
             }
             else
             {
              postion=mLOWERALPHATBETS.indexOf(ch);
             }
          return postion; //return the position of the character
   }
     
     private char FindCharacter(int position,char ch)
   {
       boolean isUpper=IsUpperCase(ch); //determine if the charater is upper case or lower case
         char c;
          if (isUpper) //isUpper is true
             {
                c=mUPPERALPHATBETS.get(position); //get the character from the specify position in the UPPERALPHATBETS array
          }
          
          else //isUpper is false
             {
              c=mLOWERALPHATBETS.get(position);//get the character from the specify position in the LOWERALPHATBETS array
          }
          return c; //return the character
   }
    
    protected void Encrypt()
   {
        ToArray();
        int length;
        length=this.mDataToEncrypt.length();
        int pos;
       for(int i=0;i<length;i++)
         {

          char c= mCharArray[i];      
          int postion=-1;
          postion=FindCharacterPosition(c);
             
           switch (postion)
           {
               case -1:
                   break;
               default:
                   
                if (postion<=12)
                {
                    pos=postion+13;
                }
                else
                {
                     pos=postion-13;
                }
               // char cha=FindCharacter(pos,c);
                mCharArray[i]=FindCharacter(pos,c);
                
             break;
           }   
         }
       ToString();
      //ReverseWord();
   }
}
