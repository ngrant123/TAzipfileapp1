/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheckereventsbegin;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.io.File;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author nathangrant
 */
public class NewCodeCheck {
    
    //public static File fileTracker;
    public String questionName;
    
    public boolean startCode(String questionName){
        
        String file1=questionName;
        this.questionName=questionName;
        File file= new File(file1);
        boolean tracker2=true;
        
        String file2="BigD";
        File file3= new File(file2);
        
        File []list=file3.listFiles();
        int tracker=0;
        
        for(int i=0;i<list.length;i++){
        
            if(list[i].getName().compareTo(questionName)==0){
                tracker2=false;
            }
        }
        
        
        if(tracker2==true){
            file.mkdir();
        
        
            String fileSubDir="BigD/"+questionName+"/submissions";
            File file4= new File(fileSubDir);
            file4.mkdirs();
        
            String fileProjDir="BigD/"+questionName+"/projects";
            File file5= new File(fileProjDir);
            file5.mkdirs();
        
            String fileCodeDir="BigD/"+questionName+"/code";
            File file6= new File(fileCodeDir);
            file6.mkdirs();
            
            
            //IntroScreen newCodetest= new IntroScreen();
            //newCodetest(true);
            return true;
              
               
        }   
        else{
            
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("About");
            alert2.setHeaderText("Information ");
            String s ="The name that you have entered has already been created";
            alert2.setContentText(s);
            alert2.showAndWait();
            return false;
        }
    }
    
    public static void rename(String newN,String old){
        
        String file1="BigD";
        File file= new File(file1);
        
        File []list=file.listFiles();
        int tracker=0;
        
        for(int i=0;i<list.length;i++){
            
            if(list[i].getName().compareTo(old)==0){
                tracker=i;
               // String file2=newN;
               // File oldFile= (File)list[tracker];
                File oldFile= new File("BigD/"+old);
                File fileTracker= new File("BigD/"+newN); 
                if(oldFile.renameTo(fileTracker)){
                    System.out.println("Succes");
                }
                else{
                    System.out.println("Fail");
                }
                //trackerF.renameTo(fileTracker);
              //  File trackerF= (File)list[tracker];
                
               // trackerF.renameTo(fileTracker);
                //list[tracker].renameTo(fileTracker);
                break;
            }  
                
            
        }       
    }
    
    public String getName(){
        return questionName;
    }
            
}
