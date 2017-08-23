/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screenactions;

import codecheckereventsbegin.NewCodeCheck;
import java.io.File;
import java.lang.Thread.State;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.text.TableView.TableRow;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author nathangrant
 */
public class FinalScreen {
    
     
    public TableView <GetData>table= new TableView<>();
    public TableView successTable= new TableView<>();
    public TableView errorTable= new TableView<>();
    public Stage primary4;
    public String text2;
    public boolean renameT;
    public Stage actualStage;
    public HBox titleContainer;
    private ArrayList dataList;
    private GetData newD;
    private boolean clickTable;
    public boolean viewResults;
    public GetData objectRow;
    private ArrayList foldercontainer;
    private Button extractButton;
    private Button resultsButton;
    private Stage stage;
    public ArrayList<GetData> check;
    
    
    
    public void start(Stage primary,String text) throws MalformedURLException{
        
        
        
        stage=new Stage();
        viewResults=false;
        primary= new Stage();
        renameT=false;
        check= new ArrayList();
        
        
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
            ExtractCodeScreen fourthScreen= new ExtractCodeScreen();
            primary4.close();
                 try {
                     fourthScreen.start(primage2,text2);
                 } catch (MalformedURLException ex) {
                     Logger.getLogger(FinalScreen.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else{
                 Stage primage2= new Stage();
            ExtractCodeScreen fourthScreen= new ExtractCodeScreen();
            primary4.close();
                 try {
                     fourthScreen.start(primage2,text);
                 } catch (MalformedURLException ex) {
                     Logger.getLogger(FinalScreen.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
             }
            
        });
        
        
        
        Button nextButton= new Button("Next");
        nextButton.setDisable(true);
        
        nextButton.setOnAction(e->{
            
            if(renameT==true){
            Stage primage2= new Stage();
            ExtractCodeScreen lastScreen= new ExtractCodeScreen();
            primary4.close();
                try {
                    lastScreen.start(primage2,text2);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(FinalScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                 Stage primage2= new Stage();
            ExtractCodeScreen lastScreen= new ExtractCodeScreen();
            primary4.close();
                try {
                    lastScreen.start(primage2,text);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(FinalScreen.class.getName()).log(Level.SEVERE, null, ex);
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
        
        leftContents.setPadding(new Insets(0,60,0,30));
        Label step1= new Label("Step 5:Code Check");
        step1.setStyle("-fx-font-size:20;");
 
        Label explanation=new Label("Select students and click Code Check ");
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
          
          String position=selectedItem.getData();
          String file2="BigD/"+text+"/code/"+position;
          File file1= new File(file2);
          
          
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
      
        //String file1="BigD/"+text+"code/";
             String actualposition="BigD/"+text+"/code/";
        File file= new File(actualposition);
        
        File []list=file.listFiles();
        
        foldercontainer= new ArrayList();
        for(int i=0;i<list.length;i++){
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
         String actualposition="BigD/"+text+"/code/"+position;
          
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
        
        
         dataList=new ArrayList();
        //String file1="BigD/"+text+"code/";
        String file1="BigD/"+text+"/code";
        //ile []list=file.listFiles();
        
        File file= new File(file1);
        
        File []list=file.listFiles();
        
        foldercontainer= new ArrayList();
        for(int i=0;i<list.length;i++){
             String choice1= list[i].getName();
            newD= new GetData(choice1);
            foldercontainer.add(newD);
        }
        
        
        ObservableList<GetData> data= FXCollections.observableArrayList(foldercontainer);
        table.setItems(data);
        table.setEditable(true);
        
         table.setRowFactory(e->{
            javafx.scene.control.TableRow<GetData> row = new javafx.scene.control.TableRow<>(); 
            
            row.setOnMouseClicked(event -> {
                clickTable=true;  
                objectRow=row.getItem();
                GetData selectedItem = table.getSelectionModel().getSelectedItem();
                selectedItem.decider=false;
                    for(int i=0;i<check.size();i++){
                
                    if(check.get(i)==selectedItem){
                    selectedItem.decider=true;
                    break;
                    }
                }
                
                if(selectedItem.decider==true){
                    resultsButton.setDisable(false);
                }
                else{
                     resultsButton.setDisable(true);
                }
                        
                
                
            });
                  
            return row;
        });
        
      
        TableColumn blackboardSub= new TableColumn("Student Work");
       // blackboardSub.setMinWidth(value);
        blackboardSub.setCellValueFactory(
                    new PropertyValueFactory<>("Data"));
        
        table.getColumns().add(blackboardSub);
        HBox tableContainer= new HBox();
       // tableContainer.setPadding(new Insets(10,0,0,0));
        tableContainer.getChildren().add(table);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setMinWidth(450);
        
        leftContents.getChildren().add(step1);
        leftContents.getChildren().add(explanation);
        leftContents.getChildren().add(table);
        leftContents.getChildren().add(bottomLeftButtonC);
        
        
        VBox rightContents= new VBox(20);
        rightContents.setPadding(new Insets(30,200,0,0));
        
        HBox extractionB= new HBox();
        
        Label extractL= new Label("Check Progress");
        extractL.setStyle("-fx-font-size:15");
        ProgressBar pb = new ProgressBar();
        pb.setProgress(1);
        
        extractionB.getChildren().add(extractL);
        extractionB.getChildren().add(pb);
        
        HBox resultExtractContainer= new HBox();
        extractButton= new Button("Code Check");
        resultsButton= new Button("View Results");
        
        extractButton.setOnAction(e->{
        
            ArrayList <GetData>string= new ArrayList();
            //string.add("Student Plagiarism Check results can be found at http://www.exampleresults.edu");
            
            GetData new1=new GetData("Student Plagiarism Check results can be found at http://www.exampleresults.edu");
            string.add(new1);
            
            
            GetData selectedItem = table.getSelectionModel().getSelectedItem();
            selectedItem.decider=true;
            check.add(selectedItem);
            
            
            
            
            
            
            ObservableList<GetData> data2= FXCollections.observableArrayList(string);
            successTable.setItems(data2);
            successTable.setEditable(true);
            viewResults=true;
           
        });
        
        resultsButton.setOnAction(e->{
        
            GetData selectedItem = table.getSelectionModel().getSelectedItem();
            
            
            if (selectedItem.decider == true) {

		// Create the WebView
		WebView webView = new WebView();
		
		// Disable the context menu
		webView.setContextMenuEnabled(false);
		
		// Increase the text font size by 20%
		webView.setFontScale(1.20);
		
		// Set the Zoom 20%
		webView.setZoom(1.20);
		
		// Set font smoothing type to GRAY
		//webView.setFontSmoothingType(FontSmoothingType.GRAY);
		
		// Create the WebEngine
		final WebEngine webEngine = webView.getEngine();
		// Load the StartPage
		webEngine.load("http://www.google.com");
		
		// Update the stage title when a new web page title is available		
		webEngine.titleProperty().addListener(new ChangeListener<String>()
		{
		    public void changed(ObservableValue<? extends String> ov,
		            final String oldvalue, final String newvalue) 
		    {
		    	stage.setTitle(newvalue);
		    }
		});
		
		// Create the VBox
		VBox root = new VBox();
		// Add the Children to the VBox
		root.getChildren().add(webView);

		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add  the Scene to the Stage
		stage.setScene(scene);
		// Display the Stage
		stage.show();
               
            
            }
            
            
            
            
        
        });
        
        
        resultExtractContainer.getChildren().add(extractButton);
        resultExtractContainer.getChildren().add(resultsButton);
        
        rightContents.getChildren().add(extractionB);
        rightContents.getChildren().add(resultExtractContainer);
        
        
        
        TableColumn successColumn= new TableColumn("Code Check");
        
        successColumn.setCellValueFactory(
                new PropertyValueFactory<>("Data"));
        
        
        
        successTable.getColumns().add(successColumn);
        //successTable.getColumns().add(succesTurnColumn);
        successTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        successTable.setMinWidth(500);
        
        /*
        TableColumn errorColumn= new TableColumn("Unzip Errors");
        
        errorColumn.setCellFactory(
                new PropertyValueFactory<>("unzipEname"));
        
       errorTable.getColumns().add(errorColumn);
       errorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        errorTable.setMinWidth(500);
       */
       VBox tableContainer2= new VBox();
       tableContainer2.setPadding(new Insets(0,0,20,10));
       
       tableContainer2.getChildren().add(successTable);
       //tableContainer2.getChildren().add(errorTable);
       
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
