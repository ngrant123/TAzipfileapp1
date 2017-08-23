/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenactions;

//mport java.scene.control.Checkbox;
import codecheckereventsbegin.LoadCodeCheck;
import codecheckereventsbegin.NewCodeCheck;
import codecheckereventsdata.HandleZip;
import static codecheckereventsdata.HandleZip.globalnamepart2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author nathangrant
 */
public class ExtractCodeScreen {
    
     
    public TableView <GetData>table= new TableView<>();
    public TableView successTable= new TableView<>();
    public TableView errorTable= new TableView<>();
    public Stage primary4;
    public BorderPane content;
    public Stage actualStage;
    public String text2;
    public boolean renameT;
    public HBox titleContainer;
    public ArrayList <GetData>dataList;
    public ArrayList rejectedFolder;
    public GetData newD;
    public boolean clickTable;
    public GetData objectRow;
    public ArrayList<GetData> globalarr1;
    public ArrayList<GetData> globaljs;
    public ArrayList<GetData> globalc;
    public ArrayList<GetData> globalj;
    public ArrayList<GetData> globalt;
    public ArrayList<GetData> globalcs;
   
    public ArrayList foldercontainer;
    public String globaltext;
    private boolean javatest;
    private boolean jstest;
    private boolean ctest;
    private boolean cstest;
    private boolean fieldtest;
    public static int internationalCount;
    
    public void start(Stage primary,String text) throws MalformedURLException{
        globaltext=text;
        internationalCount=0;
        
        primary= new Stage();
        renameT=false;
        
        
        primary4= primary;
        actualStage=primary;
        BorderPane content= new BorderPane();
        
        VBox topContainer= new VBox();
        
        titleContainer= new HBox();
        Label titleLabel= new Label("Code Check-Stony Brook University:"+text);
        titleLabel.setStyle("-fx-font-size:40;");
        
        titleContainer.setStyle("-fx-background-color:#C71585; -fx-text-fill: white;-fx-border-style: solid inside;");
        titleContainer.getChildren().add(titleLabel);
        
        Button newButton= new Button("New");
        newButton.setOnAction(e->{
            
            IntroScreen test= new IntroScreen();
            
            test.newCode();
            Stage primage2= new Stage();
            if(test.getnewCodetest()==true){
            test.newCodetest(false);
            BeginningScreen firstScreen= new BeginningScreen();
            primary4.close();
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
            BeginningScreen load= new BeginningScreen();         
            load.load();
                     
        });
        
        Button renameButton= new Button("Rename");
        
         renameButton.setOnAction(e->{
            
             BeginningScreen renameCall= new BeginningScreen();
             renameCall.rename();
             
             
            renameT=true;
             
            text2=renameCall.text2;
            Label textarea= (Label)titleContainer.getChildren().get(0);
            textarea.setText("Code Check-Stony Brook University:"+text2);
            
            titleContainer.getChildren().remove(0);
            titleContainer.getChildren().add(textarea);
            NewCodeCheck renameCheck= new NewCodeCheck();
            renameCheck.rename(text2,text);
            
            
            
        });
        
        
        Button aboutButton= new Button("About");
         aboutButton.setOnAction(e->{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
        homeButton.setOnAction(e->{
            
            if(renameT==true){
            Stage primage2= new Stage();
            BeginningScreen firstScreen= new BeginningScreen();
            primary4.close();
            try {
                firstScreen.start(primage2,text2);
                //primaryStage.close();
                // primary2.close();
            } catch (MalformedURLException ex) {
                Logger.getLogger(UnzipScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else{
                Stage primage2= new Stage();
            BeginningScreen firstScreen= new BeginningScreen();
            primary4.close();
            try {
                firstScreen.start(primage2,text);
                //primaryStage.close();
                // primary2.close();
            } catch (MalformedURLException ex) {
                Logger.getLogger(UnzipScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
            }
            
            
        });
        
        
        Button previousButton= new Button("Previous");
        previousButton.setOnAction(e->{
            
            
            if(renameT==true){
            Stage primage2= new Stage();
            UnzipScreen thirdScreen= new UnzipScreen();
            primary4.close();
                try {
                    thirdScreen.start(primage2,text2);
                    //primaryStage.close();
                    // primary2.close();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                 Stage primage2= new Stage();
            UnzipScreen thirdScreen= new UnzipScreen();
            primary4.close();
                try {
                    thirdScreen.start(primage2,text);
                    //primaryStage.close();
                    // primary2.close();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            
        });
        
        
        Button nextButton= new Button("Next");
        
        nextButton.setOnAction(e->{
            
            if(renameT==true){
            Stage primage2= new Stage();
            FinalScreen fifthScreen= new FinalScreen();
            primary4.close();
                try {
                    fifthScreen.start(primage2,text2);
                    //primaryStage.close();
                    // primary2.close();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                Stage primage2= new Stage();
            FinalScreen fifthScreen= new FinalScreen();
            primary4.close();
                try {
                    fifthScreen.start(primage2,text);
                    //primaryStage.close();
                    // primary2.close();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        topContainer.getChildren().add(titleContainer);
        topContainer.getChildren().add(handlecontainers);
        
        
        
        VBox leftContents= new VBox(20);
        leftContents.setStyle("-fx-background-color:#FFB6C1;");
        
        leftContents.setPadding(new Insets(0,60,10,30));
        Label step1= new Label("Step 4: Extract Source Code");
        step1.setStyle("-fx-font-size:20;");
 
        Label explanation=new Label("Select students and click Extract Code");
        explanation.setStyle("-fx-font-size:15;");
        
        
        
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
          
          String position=selectedItem.getData()+".zip";
          String actualposition="BigD/"+text+"/projects/"+position;
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
        String file1="BigD/"+text+"/projects/";
        File file= new File(file1);
        
        File []list=file.listFiles();
        
        foldercontainer= new ArrayList();
         for(int i=0;i<list.length;i++){
            String choice1= list[i].getName();
            int counter=0;
            while(choice1.charAt(counter)!='.' && counter<choice1.length()-1){
                counter++;
            }
            
            String newchoice= choice1.substring(0, counter);
            newD= new GetData(newchoice);
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
         //String actualposition="BigD/"+text+"/projects/"+position;
           String actualposition="BigD/"+text+"/projects/"+position;
          File file1= new File(actualposition);
           File []list=file1.listFiles();
          
          Stage newS= new Stage();
          VBox newVBox=new VBox();
          if(list!=null){
          for(int i=0;i<list.length;i++){
              Label text2= new Label(list[i].toString());
              newVBox.getChildren().add(text2);
             
            }
          }
          else{
              Label text2= new Label(file1.toString());
              newVBox.getChildren().add(text2);
          }
          
          Scene scene1= new Scene(newVBox,370,100);
          newS.setScene(scene1);
          newS.showAndWait();     
            
        });
        
        bottomLeftButtonC.getChildren().add(removeButton);
        bottomLeftButtonC.getChildren().add(refreshButton);
        bottomLeftButtonC.getChildren().add(viewButton);
        
        
        
        
        
        
        VBox sourceF= new VBox(15);
        
        Label sourceFiles= new Label("Source Files");
        
        GridPane checkBox= new GridPane();
        checkBox.setHgap(10);
        checkBox.setVgap(10);
        
        CheckBox java= new CheckBox(".java");
        CheckBox javascript= new CheckBox(".js");
        CheckBox cHCPP= new CheckBox(".c, .h, .cpp ");
        CheckBox cs= new CheckBox(".cs");
        
       // Node java2= (Node)java;
        //javascript=(Node)javascript;
        
       
        checkBox.add(java, 0,0);      
        checkBox.add(javascript,0,1);
        checkBox.add(cHCPP,1,0);
        checkBox.add(cs,1,1);
        
        HBox textF= new HBox();
        
        CheckBox selectF= new CheckBox();
        TextField selectText = new TextField();
        
        textF.getChildren().add(selectF);
        textF.getChildren().add(selectText);
        
        sourceF.getChildren().add(sourceFiles);
        sourceF.getChildren().add(checkBox);
        sourceF.getChildren().add(textF);
        
        
        
        
        
        
        VBox rightContents= new VBox(20);
        rightContents.setPadding(new Insets(30,200,0,0));
        
        HBox extractionB= new HBox();
        
        Label extractL= new Label("Code Progress");
        extractL.setStyle("-fx-font-size:15");
        ProgressBar pb = new ProgressBar();
        pb.setProgress(.8f);
        
        extractionB.getChildren().add(extractL);
        extractionB.getChildren().add(pb);
        
        Button extractButton= new Button("Extract Code");
        
        rightContents.getChildren().add(extractionB);
        rightContents.getChildren().add(extractButton);
        
        extractButton.setOnAction(e->{
            globalarr1=new ArrayList();
            globaljs= new ArrayList();
            globalc= new ArrayList();
            globalj= new ArrayList();
            globalt= new ArrayList();
            globalcs= new ArrayList();
            
            
            
            javatest=java.isSelected();
            jstest=javascript.isSelected();
            ctest=cHCPP.isSelected();
            cstest=cs.isSelected();
            fieldtest=selectText.getText().trim().isEmpty();
        
            if(javatest==true){
                try {
                    search1(foldercontainer);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(jstest==true){
                try {
                    search1(foldercontainer);
                } catch (IOException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(ctest==true){
                try {
                    search1(foldercontainer);
                } catch (IOException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(cstest==true){
                try {
                    search1(foldercontainer);
                } catch (IOException ex) {
                    Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(fieldtest!=true){
                String select= selectText.getText();
                search2(foldercontainer,select);
            }
            int counter=0;
               //globalarr1.addAll(globaljs);
               //globalarr1.addAll(globalc);
               //globalarr1.addAll(globalj);
               //globalarr1.addAll(globalt);
            for(int i=0;i<foldercontainer.size();i++){
               GetData new1= (GetData)foldercontainer.get(i);
               //globalarr1.add(counter, new1);
               
               //globalarr1.addAll(globaljs);
              // globalarr1.addAll(globalc);
               //globalarr1.addAll(globalj);
               //globalarr1.addAll(globalt);
               
                for(int j=0;j<globalarr1.size();j++){
                    counter++;
                }
            }
            
            ObservableList<GetData> data2= FXCollections.observableArrayList(globalarr1);
            successTable.setItems(data2);
            successTable.setEditable(true);
            
            ObservableList<GetData> data3= FXCollections.observableArrayList(rejectedFolder);
            errorTable.setItems(data3);
            errorTable.setEditable(true); 
            
             HandleZip extract= new HandleZip();
                     ArrayList strings= new ArrayList();
                     
                     for(int i=0;i<globalarr1.size();i++){
                         strings.add(globalarr1.get(i).getData());
                     }
                     
            try {
                // extract.unzip(strings,text);
                extract.rename4(strings, text);
            } catch (IOException ex) {
                Logger.getLogger(ExtractCodeScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        });
        
        
        
        
         dataList=new ArrayList();
        //String file1="BigD/"+text+"/projects";
         String file1="BigD/"+text+"/projects";

        File file= new File(file1);
        
        File []list=file.listFiles();
        
        foldercontainer= new ArrayList();
        for(int i=0;i<list.length;i++){
            String choice1= list[i].getName();
            int counter=0;
            while(choice1.charAt(counter)!='.'){
                counter++;
            }
            
            String newchoice= choice1.substring(0, counter);
            newD= new GetData(newchoice);
            foldercontainer.add(newD);
        }
        
        rejectedFolder= new ArrayList();
        
        
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
        
     
        
        TableColumn blackboardSub= new TableColumn("Student Work Directories");
       // blackboardSub.setMinWidth(value);
        blackboardSub.setCellValueFactory(
                    new PropertyValueFactory<>("Data"));
        
        table.getColumns().add(blackboardSub);
        HBox tableContainer= new HBox();
       // tableContainer.setPadding(new Insets(10,0,0,0));
        tableContainer.getChildren().add(table);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setMinWidth(400);
        
        leftContents.getChildren().add(step1);
        leftContents.getChildren().add(explanation);
        leftContents.getChildren().add(table);
        leftContents.getChildren().add(bottomLeftButtonC);
        leftContents.getChildren().add(sourceF);
        
        
        
        
        TableColumn successColumn= new TableColumn("Successful code extraction");
        
        successColumn.setCellValueFactory(
                new PropertyValueFactory<>("Data"));
        
        
        
        successTable.getColumns().add(successColumn);
        //successTable.getColumns().add(succesTurnColumn);
        successTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        TableColumn errorColumn= new TableColumn("Code Extraction Errors");
        
        errorColumn.setCellValueFactory(
                new PropertyValueFactory<>("Data2"));
        
       errorTable.getColumns().add(errorColumn);
       errorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        errorTable.setMinWidth(450);
       
       VBox tableContainer2= new VBox();
       tableContainer2.setPadding(new Insets(0,0,20,10));
       
       tableContainer2.getChildren().add(successTable);
       tableContainer2.getChildren().add(errorTable);
       
       rightContents.getChildren().add(tableContainer2);      
       
        
        
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
     public void close(){
         IntroScreen removeScreenQ= new IntroScreen();
         removeScreenQ.closeQuestion(actualStage);
     }
     
     public ArrayList search1(ArrayList foldercontainer) throws FileNotFoundException, IOException{
         
         for(int i=0;i<foldercontainer.size();i++){
             //GetData new1= (GetData)foldercontainer.get(i);
         //String file= foldercontainer.get(i).toString();
         GetData new1=(GetData)foldercontainer.get(i);
         globalarr1.add(internationalCount++, new1);
         
         String file= new1.getData()+".zip";
         
         
         if(file.compareTo("HW 99_janedoe_attempt_2017-07-13-20-41-16_HW1.zip")==0){
         System.out.println("ypup");
         }
         
         String file1="BigD/"+globaltext+"/projects/"+file+"/"+file;
         File testF= new File(file1);
         if(testF.exists()){
             System.out.println("true");
         }
         String dest="Unzip";
         UnzipUtility unzipper= new UnzipUtility();
         unzipper.unzip(file1,dest);
         
         File file2= new File(dest);
         File []list=file2.listFiles();
         
         for(int j=0;j<list.length;j++){
             
             if(list[j].isDirectory()){
                 deeper(list[j]);
             }
             else{
                  GetData new2=new GetData(list[i].getName());
                  String test= new2.getData();
                  int counter=0;
                  boolean filetest=false;
                  StringBuilder formattedS= new StringBuilder();
                  
                  for(int k=0;k<test.length();k++){
                      if(test.charAt(k)=='.'){
                          filetest=true;
                          continue;
                      }
                      if(filetest==true){
                          formattedS.append(test.charAt(k));
                          
                      } 
                      
                  }
                  String newWord= formattedS.toString();
                  
                  if(newWord.compareTo("java")==0 &&javatest==true){
                    globalarr1.add(new1);
                    internationalCount++;
                  }
                  else if(newWord.compareTo("js")==0 &&jstest==true){
                      globaljs.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo("c")==0 ||newWord.compareTo("h")==0||newWord.compareTo("cpp")==0 && ctest==true){
                      globalc.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo("t")==0 && fieldtest==true){
                      globalt.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo("cs")==0 && cstest==true){
                      globalcs.add(new1);
                      internationalCount++;
                  }
                  
               globalarr1.addAll(globaljs);
               globalarr1.addAll(globalc);
               globalarr1.addAll(globalj);
               globalarr1.addAll(globalt);
             }
             
             
             
         } 
         String dest2="Unzip";
         File desfile= new File(dest2);
         deleteDir(desfile);
         }
         
         
         return globalarr1;
     }
     public ArrayList search2(boolean test,ArrayList foldercontainer){
         
         return globalarr1;
     }
     public ArrayList search3(boolean test,ArrayList foldercontainer){
         
       return globalarr1;  
     }
     public ArrayList search4(boolean test,ArrayList foldercontainer){
         
       return globalarr1;
     }
     public ArrayList search5(String test,ArrayList foldercontainer){
         
       return globalarr1;  
     }
     
     public void deeper(File file){
         
          File []list=file.listFiles();
         for(int i=0;i<list.length;i++){
             
             File source=new File("src");
             if(list[i].getName().compareTo(source.getName())==0){
                 deeper2(list[i]); 
             }
         }    
     }
     
     public void deeper2(File file){
          File []list=file.listFiles();
          
          for(int i=0;i<list.length;i++){
              if(list[i].isDirectory()){
                  deeper2(list[i]);
              }
              else{
                  
                  GetData new1=new GetData(list[i].getName());
                  String test= new1.getData();
                  int counter=0;
                  boolean filetest=false;
                  StringBuilder formattedS= new StringBuilder();
                  
                  for(int j=0;j<test.length();j++){
                      if(test.charAt(j)=='.'){
                          filetest=true;
                          continue;
                      }
                      if(filetest==true){
                          formattedS.append(test.charAt(j));
                          
                      } 
                      
                  }
                  String newWord= formattedS.toString().toLowerCase();
                  //newWord.toLowerCase();
                 
                  
                  if(newWord.compareTo("java")==0 &&javatest==true){
                    globalarr1.add(new1);
                    internationalCount++;
                  }
                  else if(newWord.compareTo("js")==0 &&jstest==true){
                      globaljs.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo("c")==0 ||newWord.compareTo("h")==0||newWord.compareTo("cpp")==0 && ctest==true){
                      globalc.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo("t")==0 && fieldtest==true){
                      globalt.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo("cs")==0 && cstest==true){
                      globalcs.add(new1);
                      internationalCount++;
                  }
                  
               globalarr1.addAll(globaljs);
               globalarr1.addAll(globalc);
               globalarr1.addAll(globalj);
               globalarr1.addAll(globalt);
                  
              }
          }
     }

    private ArrayList<GetData> search2(ArrayList foldercontainer, String select) {
          
         for(int i=0;i<foldercontainer.size();i++){
         //String file= foldercontainer.get(i).toString();
         GetData new1=(GetData)foldercontainer.get(i);
         String file= new1.getData()+".zip";
         
         
         if(file.compareTo("HW 99_janedoe_attempt_2017-07-13-20-41-16_HW1.zip")==0){
         System.out.println("ypup");
         }
         
         String file1="BigD/"+globaltext+"/submissions/"+file;
         File testF= new File(file1);
         if(testF.exists()){
             System.out.println("true");
         }
         String dest="Unzip";
        // UnzipUtility unzipper= new UnzipUtility();
        // unzipper.unzip(file1,dest);
         
         File file2= new File(dest);
         File []list=file2.listFiles();
         
         for(int j=2;j<list.length;j++){
             if(list[j].isDirectory()){
                 deeper(list[j]);
             }
             else{
                  GetData new2=new GetData(list[i].getName());
                  String test= new2.getData();
                  int counter=0;
                  boolean filetest=false;
                  StringBuilder formattedS= new StringBuilder();
                  
                  for(int k=0;k<test.length();k++){
                      if(test.charAt(k)=='.'){
                          filetest=true;
                          continue;
                      }
                      if(filetest==true){
                          formattedS.append(test.charAt(k));
                          
                      } 
                      
                  }
                  String newWord= formattedS.toString();
                  
                  if(newWord.compareTo("java")==0 &&javatest==true){
                    globalarr1.add(new1);
                    internationalCount++;
                  }
                  
                  else if(newWord.compareTo("js")==0 &&jstest==true){
                      globaljs.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo("c")==0 ||newWord.compareTo("h")==0||newWord.compareTo("cpp")==0 && ctest==true){
                      globalc.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo(select)==0 && fieldtest==true){
                      globalt.add(new1);
                      internationalCount++;
                  }
                  else if(newWord.compareTo("cs")==0 && cstest==true){
                      globalcs.add(new1);
                      internationalCount++;
                  }
             }
             
             
             
         } 
         }
         
         
         return globalarr1;
         //To change body of generated methods, choose Tools | Templates.
    }
    
     public void deleteDir(File file) {
    File[] contents = file.listFiles();
    if (contents != null) {
        for (File f : contents) {
            deleteDir(f);
        }
    }
            file.delete();
            String fileSubDir="Unzip";
             File newF= new File(fileSubDir);
             newF.mkdir();
}
     
     
    
    
  
}