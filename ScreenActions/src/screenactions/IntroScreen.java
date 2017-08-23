/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenactions;

//import java.awt.Insets;
import codecheckereventsbegin.NewCodeCheck;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author nathangrant
 */
public class IntroScreen extends Application{

    public Stage primary2;
    public String text;
    public boolean newCodeTest;
    public String loadName;
    public boolean newcodetester;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
       newCodeTest=false;
        primaryStage= new Stage();
        primary2= primaryStage;
        BorderPane content= new BorderPane();
        //content.setPadding(new Insets(10, 20, 10, 20));
        
        VBox loadlocation= new VBox(10);
        loadlocation.setStyle("-fx-background-color:#FFC0CB; -fx-text-fill: black;-fx-border-style: solid inside;");
        loadlocation.setPadding(new Insets(60,60,60,60));
        
        Label recentWork= new Label("Recent Work");
        recentWork.setStyle("-fx-font-size:15;-fx-text-fill: black;");
        loadlocation.getChildren().add(recentWork);
        
        addLoadFiles(loadlocation);
        
        
        VBox titlelocation= new VBox();
        titlelocation.setStyle("-fx-background-color:#DB7093; -fx-text-fill: black;-fx-border-style: solid inside;");
        titlelocation.setPadding(new Insets(30,30,30,30));
        Label title= new Label("Welcome to Code Check");
        title.setStyle("-fx-font-size:30;-fx-text-fill: black;");
        titlelocation.getChildren().add(title);
        
        
        
        VBox titleScreen= new VBox(30);
       // titleScreen.s
        VBox titleMiddle=new VBox();
        titleMiddle.setStyle("-fx-background-color:#C71585; -fx-text-fill: white;-fx-border-style: solid inside;");
        Label titleMiddle2= new Label("Code Check");
        titleMiddle2.setStyle("-fx-font-size:110;-fx-text-fill: white;");
        
        titleMiddle.getChildren().add(titleMiddle2);
        
        HBox buttoncontainer= new HBox();
        Button createNewButton= new Button("Create New Code Check");
        
        createNewButton.setOnAction(e->{
           
        /*
            NewCodeCheck newCode= new NewCodeCheck();
            newCode.startCode(text);
            */
            newCode();
            
            if(newcodetester==true){
            Stage primage2= new Stage();
            BeginningScreen firstScreen= new BeginningScreen();
            newCodeTest=false;
            primary2.close();
            try {
                firstScreen.start(primage2,text);
                //primaryStage.close();
                // primary2.close();
            } catch (MalformedURLException ex) {
                Logger.getLogger(IntroScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        });
        
        buttoncontainer.setPadding(new Insets(0,0,0,200));
        buttoncontainer.getChildren().add(createNewButton);
        titleScreen.setPadding(new Insets (150,15,0,30));
        
        titleScreen.getChildren().add(titleMiddle);
        titleScreen.getChildren().add(buttoncontainer);
        
        Label aboutText= new Label("Welcome to Code Check\n"+
                "Code Check will be a desktop application\n"+"that will make it easier for Teaching Assistants to extract\n"
                +"student submissions into a proper format to setup grading as well as setting up checks for code\n" +
                "plagiarism. To Start place the necessary files into the");
        
        //aboutText.setStyle
        aboutText.setStyle("-fx-font-size:15;");
        
        titleScreen.getChildren().add(aboutText);
        
        
        
         Image studentImage = loadImage("images/download.png");
        ImageView studentImageView= new ImageView();
       // studentImageView.setX(10);
        //studentImageView.setY(10);
        studentImageView.setFitHeight(30);
        studentImageView.setFitWidth(30);
        studentImageView.setImage(studentImage);
               
        
        studentImageView.setOnMouseClicked(e->{
              Stage primage2= new Stage();
              
            NewCodeCheck newCode= new NewCodeCheck();
            newCode.startCode("Empty");
            BeginningScreen firstScreen= new BeginningScreen();
            primary2.close();
            try {
                firstScreen.start(primage2,"Empty");
                //primaryStage.close();
                // primary2.close();
            } catch (MalformedURLException ex) {
                Logger.getLogger(IntroScreen.class.getName()).log(Level.SEVERE, null, ex);
            }           
            
        });
        
        HBox exitContainer= new HBox();
        exitContainer.setPadding(new Insets(0,0,0,970));
        exitContainer.getChildren().add(studentImageView);
        
        
       content.setTop(exitContainer);
       content.setLeft(loadlocation);
       //content.setTop(titlelocation);
       content.setCenter(titleScreen); 
        
        
        Scene primaryScene= new Scene(content,1000,700);
        
        
        primary2.setScene(primaryScene);
        primary2.showAndWait();
                
    }
    
      public Image loadImage(String imagePath) throws MalformedURLException {
	File file = new File(imagePath);
	URL fileURL = file.toURI().toURL();
	Image image = new Image(fileURL.toExternalForm());
	return image;
    }
      
      public void newCode(){
          Stage questionStage= new Stage();
        VBox question= new VBox();
        
        Label questionLabel= new Label("Enter the new of the new code check");
        TextField fieldResponse= new TextField();
        Button submit= new Button("Click here");
        
        //String f= fieldResponse.ge
       
        
        submit.setOnAction(event->{   
            text= fieldResponse.getText();  
            questionStage.close();           
            NewCodeCheck newCode= new NewCodeCheck();
            newcodetester=newCode.startCode(text);
            
            //newCodetest(true);
            
        });
        
        question.getChildren().add(questionLabel);
        question.getChildren().add(fieldResponse);
        question.getChildren().add(submit);
        
        Scene scene1= new Scene(question,250,100);
        questionStage.setScene(scene1);
        questionStage.showAndWait();
          
        /*
         NewCodeCheck newCode= new NewCodeCheck();
         newCode.startCode(text
                */          
      }
      
      public void newCodetest(boolean test){
          newCodeTest=test;
      }
      
      
      public void addLoadFiles(VBox container){
        String file1="BigD";
        //String file1="BigD";
        File file= new File(file1);
        
        File []list=file.listFiles();
        
        if(list.length>0){
           for(int i=1;i<list.length;i++){
               
               Button node= new Button(list[i].getName());
               container.getChildren().add(node);
               
               node.setOnAction(e->{
                   
                   //CHANGE ON THE SECOND STAGE OF APPLICATION
                   Stage primage2= new Stage();
                    BeginningScreen firstScreen= new BeginningScreen();
                    newCodeTest=false;
                    primary2.close();
                    loadName=node.getText();
                    
                   try {
                       firstScreen.start(primage2,loadName);
                       
                   } catch (MalformedURLException ex) {
                       Logger.getLogger(IntroScreen.class.getName()).log(Level.SEVERE, null, ex);
                   }

               }); 
           }   
        }   
      }
      
      public boolean getnewCodetest(){
          return newCodeTest;
      }
      
      public void closeQuestion(Stage closeStage){
          
          Stage newStage= new Stage();
          Label exitQuestion=new Label("Are you sure you want to close?");
          
          VBox layout= new VBox();
          HBox yesOrno= new HBox();
          
          Button yes= new Button("Yes");
          
          yes.setOnAction(e->{
              closeStage.close();
               newStage.close();
               
              
          });
          Button no= new Button("No");
          
           no.setOnAction(e->{
               newStage.close();
               
               
           });    
          
          yesOrno.getChildren().add(yes);
          yesOrno.getChildren().add(no);
          
          layout.getChildren().add(exitQuestion);
          layout.getChildren().add(yesOrno);
          
          Scene scen1= new Scene(layout,200,100);
          
          newStage.setScene(scen1);
          newStage.showAndWait();
                      
      }
}
