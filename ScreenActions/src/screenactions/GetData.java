/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenactions;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author nathangrant
 */
public class GetData {
    
    private SimpleStringProperty Data;
    private SimpleStringProperty Data2;
    public final static ArrayList array1= new ArrayList();
    public final static ArrayList array2= new ArrayList(); 
    public static boolean decider=false;
    
    public GetData(String getData){
        
        this.Data= new SimpleStringProperty(getData);
        array1.add(getData);
    }
    
    public GetData(){
        
    }
    
    public String getData(){
        return Data.get();
    }   
    
    public void add(String getData2){
        this.Data2= new SimpleStringProperty(getData2);
        array2.add(getData2);
    }
    
    public String getData2(){
        return Data2.get();
    } 
    
    public void setName(String name){
        
    }
    
    
}