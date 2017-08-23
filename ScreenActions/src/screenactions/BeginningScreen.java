/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screenactions;

import codecheckereventsbegin.LoadCodeCheck;
import codecheckereventsbegin.NewCodeCheck;
import codecheckereventsdata.HandleZip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JProgressBar;
//import static screenactions.IntroScreen.primary2;

/**
 *
 * @author nathangrant
 */
public class BeginningScreen {
    
    public TableView<GetData> table= new TableView<>();
    public TableView successTable= new TableView<>();
    public TableView errorTable= new TableView<>();
    public Stage primary2;
    public Stage actualStage;
    public BorderPane content;
    public String text2;
    public HBox titleContainer;
    public boolean renameT;
    public GetData newD;
    public boolean clickTable;
    public GetData objectRow;
    public ArrayList <GetData>dataList;
    public ArrayList rejectedFolder;
    private ArrayList foldercontainer;
    public ArrayList strings;
    public String name;
    
    
    public void start(Stage primary,String text) throws MalformedURLException{
        
        
        name=text;
        primary= new Stage();
        primary2= primary;
        actualStage=primary;
        content= new BorderPane();
        renameT=false;
        newD= new GetData();
        clickTable=false;
        
        VBox topContainer= new VBox();
        
        titleContainer= new HBox();
        Label titleLabel= new Label("Code Check-Stony Brook University:"+text);
        titleLabel.setStyle("-fx-font-size:40;");
        
        titleContainer.setStyle("-fx-background-color:#C71585; -fx-text-fill: white;-fx-border-style: solid inside;");
        titleContainer.getChildren().add(titleLabel);
        
        Button newButton= new Button("New");
        newButton.setOnAction(e->{
            
            
            IntroScreen test= new IntroScreen();
            
            //if(test.getnewCodetest()==true){
            test.newCode();
            Stage primage2= new Stage();
            if(test.getnewCodetest()==true){
            test.newCodetest(false);
            BeginningScreen firstScreen= new BeginningScreen();
            primary2.close();
            try {
                firstScreen.start(primage2,test.text);
                //primaryStage.close();
                // primary2.close();
            } catch (MalformedURLException ex) {
                Logger.getLogger(IntroScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        });
        
        
        Button loadButton= new Button("Load");       
        loadButton.setOnAction(e->{            
            load();
                     
        });
        
        
        Button renameButton= new Button("Rename");
        renameButton.setOnAction(e->{           
            //NewCodeCheck renameCheck= new NewCodeCheck();
            //renameCheck.rename(text2,text);
            
            rename();
            Label textarea= (Label)titleContainer.getChildren().get(0);
            textarea.setText("Code Check-Stony Brook University:"+text2);
             renameT=true;
            titleContainer.getChildren().remove(0);
            titleContainer.getChildren().add(textarea);
            NewCodeCheck renameCheck= new NewCodeCheck();
            renameCheck.rename(text2,text);
             
        });
        
        
        Button aboutButton= new Button("About");
        
        
        aboutButton.setOnAction(e->{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Information");
            String s ="Welcome to Code Check\n"+
                "Code Check will be a desktop application\n"+"that will make it easier for Teaching Assistants to extract\n"
                +"student submissions into a proper format to setup grading as well as setting up checks for code\n" +
                "plagiarism";
            alert.setContentText(s);
            alert.showAndWait();

            
            
        });
       
        
        Button homeButton= new Button("Home");
        homeButton.setDisable(true);
        
        
        Button previousButton= new Button("Previous");
        previousButton.setDisable(true);
        
        
        Button nextButton= new Button("Next");
        
        nextButton.setOnAction(e->{
            
            if(renameT==true){
                 HandleZip extract= new HandleZip();
                try {
                    extract.rename5(strings,text);
                } catch (IOException ex) {
                    Logger.getLogger(BeginningScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    extract.rename4(strings, name);
                } catch (IOException ex) {
                    Logger.getLogger(BeginningScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                 
                
            Stage primage2= new Stage();
            RenameScreen secondScreen= new RenameScreen();
            primary2.close();
                try {
                    secondScreen.start(primage2,text2);
                    //primaryStage.close();
                    // primary2.close();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(BeginningScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
            //  HandleZip extract= new HandleZip();
                
                Stage primage2= new Stage();
            RenameScreen secondScreen= new RenameScreen();
            primary2.close();
                try {
                    secondScreen.start(primage2,text);
                    //primaryStage.close();
                    // primary2.close();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(BeginningScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            
            
        });
        
        
        
        HBox handlecontainers= new HBox(400);
        handlecontainers.setPadding(new Insets(10,0,10,0));
        handlecontainers.setStyle("-fx-background-color:#FFB6C1; -fx-text-fill: white;");
        
        HBox nAButtons = new HBox(5);
        //nAButtons.setStyle("-fx-border-style: solid inside;");
        
        nAButtons.setPadding(new Insets(0,0,0,50));
        nAButtons.getChildren().add(newButton);
        nAButtons.getChildren().add(loadButton);
        nAButtons.getChildren().add(renameButton);
        nAButtons.getChildren().add(aboutButton);
        
        
        
        
        
        HBox HnButtons= new HBox(5);
       // HnButtons.setStyle("-fx-border-style: solid inside;");
        
        HnButtons.setPadding(new Insets(0,30,0,0));
        HnButtons.getChildren().add(homeButton);
        HnButtons.getChildren().add(previousButton);
        HnButtons.getChildren().add(nextButton);
        
        
        Image studentImage = loadImage("images/download.png");
        ImageView studentImageView= new ImageView();
       // studentImageView.setX(10);
        //studentImageView.setY(10);
        studentImageView.setFitHeight(30);
        studentImageView.setFitWidth(30);
        studentImageView.setImage(studentImage);
               
        
        studentImageView.setOnMouseClicked(e->{
            close();
            
            
                    
            
        });
        HnButtons.getChildren().add(studentImageView);
        
        handlecontainers.getChildren().add(nAButtons);
        handlecontainers.getChildren().add(HnButtons);
       // handlecontainers.getChildren().add(studentImageView);
        
        
        topContainer.getChildren().add(titleContainer);
        topContainer.getChildren().add(handlecontainers);
        
        
        
        VBox leftContents= new VBox(20);
        leftContents.setStyle("-fx-background-color:#FFB6C1;");
        
        leftContents.setPadding(new Insets(0,60,0,30));
        Label step1= new Label("Step 1:Extract Submission");
        step1.setStyle("-fx-font-size:20;");
 
        Label explanation=new Label("Select the submissions below from which to extract student work");
        explanation.setStyle("-fx-font-size:15;");
        
        
        
        
        
        
           VBox rightContents= new VBox(20);
        rightContents.setPadding(new Insets(30,200,0,40));
        
        HBox extractionB= new HBox();
        
        Label extractL= new Label("Extraction Progress");
        extractL.setStyle("-fx-font-size:15");
        ProgressBar pb = new ProgressBar();
        pb.setProgress(.2f);
        
        JProgressBar pb2= new JProgressBar(0,100);
        
        extractionB.getChildren().add(extractL);
        extractionB.getChildren().add(pb);
        
        Button extractButton= new Button("Extract");
        
        extractButton.setOnAction(e->{
            if(clickTable==true){
                
                if(clickTable==true){
            String object= objectRow.getData();
            File file2= new File("BlackboardSub/"+object);
             File []list2=file2.listFiles();
             
            for(int j=0;j<list2.length;j++){
                String choice1= list2[j].getName();
                String newWord= choice1.substring(choice1.length()-3);
                if(newWord.compareTo("zip")==0 || newWord.compareTo("txt")==0){
                    newD= new GetData(choice1);
                    dataList.add(newD);
                }  
              else{
                    
                    newD= new GetData();
                    newD.add(choice1);
                    rejectedFolder.add(newD);
                    
                   }
                }
            }
            ObservableList<GetData> data2= FXCollections.observableArrayList(dataList);
            successTable.setItems(data2);
            successTable.setEditable(true);
            
            ObservableList<GetData> data3= FXCollections.observableArrayList(rejectedFolder);
            errorTable.setItems(data3);
            errorTable.setEditable(true); 
            
            //Add extract method in other classes
            HandleZip extract= new HandleZip();
            strings= new ArrayList();
            
            for(int i=0;i<dataList.size();i++){
                strings.add(dataList.get(i).getData());
            }
            
            extract.extract(strings,objectRow.getData(),text);
            }
            clickTable=false;
        });   
        
        
        rightContents.getChildren().add(extractionB);
        rightContents.getChildren().add(extractButton);
        
        
        
        
        
        
        
        
        HBox bottomLeftButtonC= new HBox(10);
        
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e->{
           // objectRow
          Stage primQuestion= new Stage();
          HBox question= new HBox();
          VBox container= new VBox();
          Button Yes= new Button("Yes");
          Button No= new Button("No");
          
          Label prompt= new Label("Are you sure you want to remove data from the table");
          
          Yes.setOnAction(event->{
            
          GetData selectedItem = table.getSelectionModel().getSelectedItem();
          table.getItems().remove(selectedItem);
          
          String position=selectedItem.getData();
          String actualposition="BlackboardSub/"+position;
          File file1= new File(actualposition);
          
          
          deleteDir(file1);
          primQuestion.close();
          
          });
          
          No.setOnAction(event->{
              primQuestion.close();
              
          });
          
          question.getChildren().add(Yes);
          
          question.getChildren().add(No);
          
          container.getChildren().add(prompt);
          container.getChildren().add(question);
          
          Scene new1= new Scene(container,370,100);
          primQuestion.setScene(new1);
          primQuestion.showAndWait();
          
          
          
        });
       
        
        
       
        
        
        
        Button refreshButton= new Button("Refresh");
        
        refreshButton.setOnAction(e->{
       // table.setItems(null); 
       // table.layout(); 
        String file1="BlackboardSub";
        File file= new File(file1);
        
        File []list=file.listFiles();
        
        foldercontainer= new ArrayList();
        for(int i=1;i<list.length;i++){
             String choice1= list[i].getName();
            newD= new GetData(choice1);
            foldercontainer.add(newD);
        }
        table.getItems().clear();
        //table.setItems((ObservableList<GetData>) foldercontainer); 
         ObservableList<GetData> data2= FXCollections.observableArrayList(foldercontainer);
        table.setItems(data2);
        
        
        });
        
        
        
        Button viewButton= new Button("View");
        viewButton.setOnAction(e->{
            
               // objectRow
          GetData selectedItem = table.getSelectionModel().getSelectedItem();
          //table.getItems().remove(selectedItem);
           String position=selectedItem.getData();
          String actualposition="BlackboardSub/"+position;
          File file1= new File(actualposition);
           File []list=file1.listFiles();
          
          Stage newS= new Stage();
          VBox newVBox=new VBox();
          
          for(int i=0;i<list.length;i++){
              Label text2= new Label(list[i].toString());
              newVBox.getChildren().add(text2);
             
          }
          
          Scene scene1= new Scene(newVBox,300,300);
          newS.setScene(scene1);
          newS.showAndWait();     
            
        });
        
        bottomLeftButtonC.getChildren().add(removeButton);
        bottomLeftButtonC.getChildren().add(refreshButton);
        bottomLeftButtonC.getChildren().add(viewButton);
        
        dataList=new ArrayList();
        String file1="BlackboardSub";
        File file= new File(file1);
        
        File []list=file.listFiles();
        
        foldercontainer= new ArrayList();
        for(int i=1;i<list.length;i++){
             String choice1= list[i].getName();
            newD= new GetData(choice1);
            foldercontainer.add(newD);
        }
        
        rejectedFolder= new ArrayList();
        
       
            /*
            if(clickTable==true){
            String object= objectRow.getData();
            File file2= new File("BlackboardSub/"+object);
             File []list2=file2.listFiles();
             
            for(int j=0;j<list2.length;j++){
                String choice1= list2[j].getName();
                String newWord= choice1.substring(choice1.length()-3);
                if(newWord.compareTo("zip")==0){
                    newD= new GetData(choice1);
                    dataList.add(newD);
                }  
                else{
                    
                    newD= new GetData();
                    newD.add(choice1);
                    rejectedFolder.add(newD);
                    
                    }
                }
            }
        */
       
        
        ObservableList<GetData> data= FXCollections.observableArrayList(foldercontainer);
        table.setItems(data);
        table.setEditable(true);
        
        table.setRowFactory(e->{
            TableRow<GetData> row = new TableRow<>(); 
            
            row.setOnMouseClicked(event -> {
                clickTable=true;  
                objectRow=row.getItem();
                
                
                
            });
                  
            return row;
        });
        
      
        
        
        
        
       
        
        
        TableColumn blackboardSub= new TableColumn("Blackboard Submissions");
       // blackboardSub.setMinWidth(value);
        
        
        blackboardSub.setCellValueFactory(
                    new PropertyValueFactory<>("Data"));
        
        
      
        
        table.getColumns().add(blackboardSub);
        HBox tableContainer= new HBox();
       // tableContainer.setPadding(new Insets(10,0,0,0));
        tableContainer.getChildren().add(table);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        leftContents.getChildren().add(step1);
        leftContents.getChildren().add(explanation);
        leftContents.getChildren().add(table);
        leftContents.getChildren().add(bottomLeftButtonC);
        
        
     
        
        
        
       //ObservableList<GetData> data2= FXCollections.observableArrayList(dataList);
       // successTable.setItems(data2);
       // successTable.setEditable(true); 
        
        
        
        
        TableColumn successColumn= new TableColumn("Successfully renamed Submissions");
        
        successColumn.setCellValueFactory(
                new PropertyValueFactory<>("Data"));
        
        successTable.getColumns().add(successColumn);
        successTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        //ObservableList<GetData> data3= FXCollections.observableArrayList(rejectedFolder);
        //errorTable.setItems(data3);
        //errorTable.setEditable(true); 
        
        
        
        TableColumn errorColumn= new TableColumn("Error Submissions");
        
        errorColumn.setCellValueFactory(
                new PropertyValueFactory<>("Data2"));
        
       errorTable.getColumns().add(errorColumn);
       errorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       errorTable.setMinWidth(350);
       
       VBox tableContainer2= new VBox();
       tableContainer2.setPadding(new Insets(0,0,20,10));
       
       tableContainer2.getChildren().add(successTable);
       tableContainer2.getChildren().add(errorTable);
       
       rightContents.getChildren().add(tableContainer2);      
       
       
       /*
        Image studentImage = loadImage("images/downloads.png");
        ImageView studentImageView= new ImageView();
        studentImageView.setImage(studentImage);
        
        HBox exitContainer= new HBox();
        exitContainer.getChildren().add(studentImageView);
        
        
        content.setTop(exitContainer);
               */
        content.setLeft(leftContents);
        content.setRight(rightContents);
        content.setTop(topContainer);
        
        Scene primaryScene= new Scene(content,1000,700);
        actualStage.setScene(primaryScene);
        
        actualStage.show();
        actualStage.setHeight(primary.getHeight()+1);
       
        
        
    }  
    
     public Image loadImage(String imagePath) throws MalformedURLException {
	File file = new File(imagePath);
	URL fileURL = file.toURI().toURL();
	Image image = new Image(fileURL.toExternalForm());
	return image;
    }
     
     public void load(){
         
         BorderPane loadcontent=content;
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Code Check File");
         fileChooser.showOpenDialog(null);
         
         LoadCodeCheck loadCodeChecker= new LoadCodeCheck();
         loadCodeChecker.load(loadcontent);
         
        
     }
     
     
     public void rename(){
            Stage questionStage= new Stage();
        VBox question= new VBox();
        
        Label questionLabel= new Label("Enter the name of the new code check");
        TextField fieldResponse= new TextField();
        Button submit= new Button("Click here");
        
        //String f= fieldResponse.ge
       
        
        submit.setOnAction(event->{   
            text2= fieldResponse.getText();  
            questionStage.close();           
            //NewCodeCheck newCode= new NewCodeCheck();
            //newCode.startCode(text2);
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
     
     public String getText2(){
         return text2;
     }
     
     public void close(){
         IntroScreen removeScreenQ= new IntroScreen();
         removeScreenQ.closeQuestion(actualStage);
     }
     
    public void deleteDir(File file) {
    File[] contents = file.listFiles();
    if (contents != null) {
        for (File f : contents) {
            deleteDir(f);
        }
    }
    file.delete();
}
    
}

