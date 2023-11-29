package flapgui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.layout.Priority;
import javafx.scene.text.*;
import javafx.geometry.Insets;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.lang.Process;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;


public class FlapGUI extends Application { 
    private VBox mainPane;
    private Stage primaryStage;
    private String typeGame;
    private String fps;
    private String epoch;
    
    private int currentHighScore;
    private int totalHighScore;
    
    private String averageScore;
    private Process pro;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 410;
    private static final String FPS_DEFAULT = "30";
    private static final String EPOCH_DEFAULT = "2500";
    
    private Label topLabel;
    private Label bottomLabel;

    private Path exeDir;

    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        fps = FPS_DEFAULT;
        epoch = EPOCH_DEFAULT;
        currentHighScore = 0;
        totalHighScore = 0;
        averageScore = "0";

       changeScene(loadingScene(), "Loading...");
       primaryStage.show();
        

        primaryStage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                changeScene(closingScene(), "Closing...");
                deleteDirectory(exeDir.toFile());
                Platform.exit();
                System.exit(0);
            }
        });

        
        new Thread(() -> {
            try{
                File newZipFile = new File(ExeUnpack.unpack("program.zip"));
                exeDir =  Files.createTempDirectory("flapgui");
                UnzipUtility uz = new UnzipUtility();
                uz.unzip(newZipFile.getPath(), exeDir.toString());
                Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            changeScene(mainScene(), "FlappyBird GUI");
                        }
                    });
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }

    private void changeScene(Scene s, String scene_name){
        primaryStage.setTitle(scene_name);
        primaryStage.setScene(s);
    }

    private Scene mainScene(){
        mainPane = new VBox();
        handleTop();
        handleOptions();
        handleDisplayResults();
        return new Scene(mainPane, WINDOW_HEIGHT, WINDOW_HEIGHT);
    }

    private Scene loadingScene(){
        /**
        Text closingText = new Text("Loading Please Wait...");
        closingText.setTextAlignment(TextAlignment.CENTER);
        closingText.setFont(new Font(18));
        closingText.setFill(Color.BLACK);
        StackPane root = new StackPane();
        root.getChildren().add(closingText);
        return new Scene(root, WINDOW_HEIGHT, WINDOW_WIDTH, Color.BLACK);
        */
        Text closingText = new Text("Loading Please Wait...");
        closingText.setTextAlignment(TextAlignment.CENTER);
        closingText.setFont(new Font(18));
        closingText.setFill(Color.BLACK);
        StackPane root = new StackPane();
        root.getChildren().add(closingText);
        return new Scene(root, WINDOW_HEIGHT, WINDOW_WIDTH, new Color(.953125, .953125, .953125, 1));
        
    }

    private Scene closingScene(){
        Text closingText = new Text("Closing... \n\n Don't Close Window");
        closingText.setTextAlignment(TextAlignment.CENTER);
        closingText.setFont(new Font(18));
        closingText.setFill(Color.BLACK);
        StackPane root = new StackPane();
        root.getChildren().add(closingText);
        return new Scene(root, WINDOW_HEIGHT, WINDOW_WIDTH);
    }

    private boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    public static void main(String[] args) {
        launch();
    }
    
    private void handleTop(){
        HBox hPane = new HBox();
        Region filler = new Region();
        HBox.setHgrow(filler, Priority.ALWAYS);
        hPane.setPadding(new Insets(5, 5, 5, 5));
        topLabel = setUpScores();
        hPane.getChildren().addAll(topLabel, filler, setUpStart());
        mainPane.getChildren().add(hPane);
    }
    
    public void updateTop(){
        topLabel.setText(setUpScoresString());
    }
    
    private Node setUpStart(){
        Button sBut = new Button("Start?");
        sBut.setOnAction(e -> runScript());
        return sBut;
    }
    
    public Process getProcess(){
        return pro;
    }
    
    private void runScript(){ 
        ProcessBuilder builder = new ProcessBuilder(exeDir + "/main.exe", 
                                    typeGame,
                                    fps,
                                    epoch
                                    );
    
        builder.redirectErrorStream(true);
        try{
            pro = builder.start();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        Thread ioThread = new IOThread(this);
        
        ioThread.start();
    }
    
    public void updateBottom(){
        bottomLabel.setText(handleTextResults());
    }
    
    /**
     * Saves best and average score to member variables
     * @param str One line from the output
     */
    public void parseOutput(String str){
        if(!str.equals("")){
            if(str.charAt(0) == 'A')
                averageScore = str.substring(3);
            else if(str.charAt(0) == 'R')
                currentHighScore = Integer.parseInt(str.substring(3));
            if(currentHighScore > totalHighScore)
                totalHighScore = currentHighScore;
        }
    }
    
    private String setUpScoresString(){
        return "Total top score: " + totalHighScore;
    }
    
    private Label setUpScores(){
        String info = setUpScoresString();
        Label label = new Label(info);
        label.setFont(Font.font("Times New Roman", 20));
        return label;
    }
    
    private void handleOptions(){
        HBox oPane = new HBox();
        oPane.getChildren().add(handleTypeGame());
        oPane.getChildren().add(handleParameters());
        mainPane.getChildren().add(oPane);
    }
    
    private Node handleTypeGame(){
        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
        
        RadioButton rbPlay = new RadioButton("Play"); 
        RadioButton rbTrain = new RadioButton("Train"); 
        RadioButton rbEvaluate = new RadioButton("Evaluate"); 
        paneForRadioButtons.getChildren().addAll(rbPlay, rbTrain, rbEvaluate); 
        
        // Determine the items in the group to toggle
        ToggleGroup group = new ToggleGroup(); 
        rbPlay.setToggleGroup(group); 
        rbTrain.setToggleGroup(group); 
        rbEvaluate.setToggleGroup(group); 
        
        // Handle the event: change the color of the text accordingly
        rbPlay.setOnAction(e -> { 
            if (rbPlay.isSelected()) { 
                typeGame = "play"; 
            } 
        });
        
        rbTrain.setOnAction(e -> { 
            if (rbTrain.isSelected()) { 
                typeGame = "train";
            } 
        }); 
        
        rbEvaluate.setOnAction(e -> { 
            if (rbEvaluate.isSelected()) { 
                typeGame = "evaluate";
            } 
        });         
        
        return paneForRadioButtons;
    }
    
    private Node handleParameters(){
        GridPane gPane = new GridPane(); // Create GridPane object
        gPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gPane.setHgap(5.5); // Gap between columns
        gPane.setVgap(5.5); // Gap between rows

        NumberTextField fpsInput = new NumberTextField();
        NumberTextField epochInput = new NumberTextField();
        
        
        Button sBut = new Button("Press when entered");
        sBut.setOnAction(e -> {
          fps = fpsInput.getText();
          epoch = epochInput.getText();
        });
        
        gPane.add(new Label("FPS:"), 0, 0); // in column 0, row 0
        gPane.add(fpsInput, 1, 0);          // in column 1, row 0
        gPane.add(new Label("Epcohs:"), 0, 1);         // in column 0, row 1
        gPane.add(epochInput, 1, 1);          // in column 1, row 1
        gPane.add(sBut, 1, 2);

        return gPane;
    }
    
    private void handleDisplayResults(){
        VBox vPane = new VBox();
        Image image = new Image(FlapGUI.class.getResource("flap.png").toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(WINDOW_WIDTH);
        imageView.setFitHeight((int)(WINDOW_WIDTH / 1.9));
        vPane.getChildren().add(imageView);
        
        Region filler = new Region();
        VBox.setVgrow(filler, Priority.ALWAYS);
        vPane.setPadding(new Insets(5, 5, 5, 5));
        vPane.getChildren().add(filler);
        
        bottomLabel = new Label(handleTextResults());
        bottomLabel.setFont(Font.font("Times New Roman", 20));
        vPane.getChildren().add(bottomLabel);
        mainPane.getChildren().add(vPane);
    }
    
    
    private String handleTextResults(){
        return "Current Record: " + currentHighScore + " Current Average: " + averageScore;
    }
    
}
