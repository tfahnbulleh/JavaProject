/*
 * Perform File explorer operation
Open file explorer to select a text file
open save file dialog to save a text file

 */
package fileexplore;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class FileExplorerOperation
{
   private final JFileChooser mFileChooser;
    private final String mFilter;
    private String mFilterText;
    private File mFile;
    private boolean noFilter;
    private boolean isFileName=false;

   
    
    //constructor
    public FileExplorerOperation()
    {
        this.mFilter="";
        mFileChooser=new JFileChooser();
    }
    
    //constructor 
    public FileExplorerOperation(String filter,String filterText)
    {       mFilter=filter;
            mFilterText=filterText;
            mFileChooser=new JFileChooser();
    }
    
    public File getmFile() 
    {
        return mFile;
    }
    //open file explorer to select a file
     public void OpenFileExplorerToSelecFile()
    {
      //the value of mFiler is null or the length less than 2
        if (mFilter == null||mFilter.length()<2) 
        {
             mFileChooser.setAcceptAllFileFilterUsed(true); //accept all file filter extension
        }
        
        //not null
        else
        {
              mFileChooser.setAcceptAllFileFilterUsed(false); ////all file filter extension is not allow
              FileFilter fileFilter=new FileNameExtensionFilter(mFilterText,mFilter); //new file filter object
              mFileChooser.setFileFilter(fileFilter);//set the filter extension
        
        }
      
        int showOpenDialog = mFileChooser.showOpenDialog(null); //show the open file dialog
        
        if (showOpenDialog==JFileChooser.CANCEL_OPTION) //the user cancel the open file operation
        {
            
            this.mFile=null;
        }
        
        //the user click the ok button
        else
        {
             mFile=mFileChooser.getSelectedFile(); //get the path of the selected file and assign it to  mFilePath
        }
    }
     
    //open save file dialog to save a file
    public void OpenSaveFileDialog(String dataToSave)
    {
        int showSaveDialog = mFileChooser.showSaveDialog(null);
        if (showSaveDialog==JFileChooser.APPROVE_OPTION)
        {
            File newFile=mFileChooser.getSelectedFile();
            
          //this.mFilePath=mFileChooser.getSelectedFile().toString();
            this.isFileName=true;
        }
        
        else
        {
            this.isFileName=false;
        }
    } 
}
