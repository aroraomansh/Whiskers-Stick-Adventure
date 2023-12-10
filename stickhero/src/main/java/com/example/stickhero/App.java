

package com.example.stickhero;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.*;
import java.util.Random;

import static java.lang.Math.abs;

public class App extends Application {

    private Stage primaryStage;
    private Line stick;
    private Line newStick;
    int Score = 0;
    private Timeline rotateTimeline;
    private Rectangle latestRectangle;
    private Rectangle mainRectangle;

    private Rectangle moreLatestRectangle;

    private double towerDistance;
    private Timeline carrotCountTimeline;

    private Timeline towerCountTimeline;

    private double latestStickLength;

    boolean isFlipped = false;

    private ImageView fallHero;
    private ImageView carrot;

    private Label scoreLabelGlobal;
    private Label carrotLabelGlobal;

    private int carrotScore = 0;


    private Scale scaleHero;

    private ImageView Hero;
    private ImageView FlippedHero;

    private Rectangle currRectangle;

    Group Layout = new Group();

    @Override
    public void start(Stage stage) {
        String musicFile = "src\\main\\resources\\com\\example\\stickhero\\menu_music.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Repeat the music indefinitely
        mediaPlayer.play();

        primaryStage = stage;
        primaryStage.setTitle("Stick Hero");

        Scene menuScene = createMenuScene();
        primaryStage.setScene(menuScene);

        primaryStage.show();
    }

    private Scene createMenuScene() {

        Label TitleLabel = new Label("Whisker's Stick Adventure");
        TitleLabel.setStyle("-fx-font-size: 32px; -fx-text-fill: blue; -fx-font-weight: bold");
        //set position of game over label
        TitleLabel.setLayoutX(400);
        TitleLabel.setLayoutY(270);

        Button newButton = new Button("NEW");
        Button loadButton = new Button("LOAD");
        Button exitButton = new Button("EXIT");

        newButton.setOnAction(event -> handleNewButtonClick());
        loadButton.setOnAction(event -> handleLoadButtonClick());
        exitButton.setOnAction(event -> handleExitButtonClick());

        VBox menuLayout = new VBox(20);
        menuLayout.getChildren().addAll(TitleLabel, newButton, loadButton, exitButton);
        menuLayout.setStyle("-fx-background-color: lightblue;");

        Image backgroundImage = null;
        try {
            backgroundImage = new Image(new FileInputStream("src/main/resources/com/example/stickhero/menu_background.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        menuLayout.setBackground(new Background(background));

        menuLayout.setAlignment(Pos.CENTER);
//        mediaPlayer.stop();

        return new Scene(menuLayout, 540, 540);
    }

    private Scene createGameOverScene() {
        Button newButton = new Button("RETRY");
        Button reviveButton = new Button("REVIVE");
        Button menuButton = new Button("MENU");

        // add new label game over in red
        Label gameOverLabel = new Label("GAME OVER");
        gameOverLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: red; -fx-font-weight: bold");
        //set position of game over label
        gameOverLabel.setLayoutX(200);
        gameOverLabel.setLayoutY(200);

        //add to layout


        newButton.setOnAction(event -> handleNewButtonClick());
        reviveButton.setOnAction(event -> handleReviveButtonClick());
        menuButton.setOnAction(event -> handleMenuClick());

        VBox menuLayout = new VBox(20);
        menuLayout.getChildren().addAll(newButton, reviveButton, menuButton, gameOverLabel);
        menuLayout.setStyle("-fx-background-color: black;");
        menuLayout.setAlignment(Pos.CENTER);

        return new Scene(menuLayout, 540, 540);
    }

    private Scene createPauseScene() {
        Button newButton = new Button("RESUME");
        Button saveButton = new Button("SAVE");
        Button exitButton = new Button("EXIT");

        newButton.setOnAction(event -> handleNewButtonClick());
        saveButton.setOnAction(event -> handleSaveButtonClick());
        exitButton.setOnAction(event -> handleExitButtonClick());

        VBox menuLayout = new VBox(20);
        menuLayout.getChildren().addAll(newButton, saveButton, exitButton);
        menuLayout.setStyle("-fx-background-color: black;");
        menuLayout.setAlignment(Pos.CENTER);


        return new Scene(menuLayout, 540, 540);
    }

    private void growStick() {
        double stickGrowAmount = 5.0; // Adjust the growth amount as needed

        // Increase the length of the stick in the Y direction
        stick.setEndY(stick.getEndY() - stickGrowAmount);
        double stickLength = abs(stick.getEndY() - stick.getStartY());

        // Update the latest stick length
        latestStickLength = stickLength;

//        System.out.println("Stick length: " + stickLength);
        // You may also want to add logic to limit the maximum length of the stick

        newStick = stick;
    }


    private void handleNewButtonClick() {
        System.out.println("NEW button clicked!");
        // Add your code to handle the "NEW" functionality

        Scene newScene = createNewScene();
        newScene.setOnKeyPressed(event -> {


            boolean flipped = false;

            if (event.getCode() == KeyCode.Z) {
                growStick();
                restartRotateTimeline(); // Restart the rotate timeline on key press
            }
            if (event.getCode() == KeyCode.P) {
                // switch to the Pause scene
                primaryStage.setScene(createPauseScene());
            }
            if (event.getCode() == KeyCode.X) {
                Hero.setY(340);
                Hero.rotateProperty().set(180);
                Hero.setRotationAxis(Rotate.X_AXIS);
                isFlipped = true;
            }
            if (event.getCode() == KeyCode.C) {
                Hero.setY(286);
                Hero.rotateProperty().set(360);
                Hero.setRotationAxis(Rotate.X_AXIS);
                isFlipped = false;
            }
//            else if (event.getCode() == KeyCode.X ) {
//
//                if (flipped == false) {
//                    // Flip heroImageView horizontally
//                    Hero.setY(340);
//                    Hero.rotateProperty().set(180);
//                    Hero.setRotationAxis(Rotate.X_AXIS);
//                    flipped = true;
//                } else if (event.getCode() == KeyCode.X && flipped) {
//                    Hero.setY(340);
//                    Hero.rotateProperty().set(180);
//                    Hero.setRotationAxis(Rotate.X_AXIS);
//                    flipped = false;
//                }
//            }
        });
        primaryStage.setScene(newScene);
    }

    private void makeStick() {// Initialize the stick
        stick = new Line();
        stick.setStyle("-fx-fill: red;");
        stick.setStartX(100);  // Adjust the X-coordinate as needed
        stick.setStartY(340); // Adjust the Y-coordinate as needed
        stick.setEndX(100);    // Initially, stick has no length
        stick.setEndY(340);
        stick.setStrokeWidth(3);
    }

    private void carrot() {
        Random random = new Random();

        Image carrotImage = null;
        try {
            carrotImage = new Image(new FileInputStream("src\\main\\resources\\com\\example\\stickhero\\carrot.gif"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ImageView carrotImageView = new ImageView(carrotImage);
        carrotImageView.setFitWidth(25);
        carrotImageView.setPreserveRatio(true);

        double minX = 100; // Minimum X coordinate for carrot spawn
        double maxX = latestRectangle.getX() - 20; // Maximum X coordinate for carrot spawn
        double carrotX = random.nextDouble() * (maxX - minX) + minX;

        double carrotY = stick.getStartY() + 10 - carrotImageView.getFitHeight(); // Adjust the Y-coordinate as needed

        carrotImageView.setX(carrotX);
        carrotImageView.setY(carrotY);

        Layout.getChildren().add(carrotImageView);

        carrot = carrotImageView;
        carrotCountTimeline = new Timeline(new KeyFrame(Duration.millis(100), event -> checkcarrotInterception()));
        towerCountTimeline = new Timeline(new KeyFrame(Duration.millis(100), event -> checkTowerInterception()));

        carrot.setDisable(false);
        carrotCountTimeline.setCycleCount(Timeline.INDEFINITE);
        towerCountTimeline.setCycleCount(Timeline.INDEFINITE);

        carrotCountTimeline.play();
        towerCountTimeline.play();
    }

    private void checkTowerInterception() {
        Bounds heroBounds = Hero.getBoundsInParent();
        Bounds LrBounds = latestRectangle.getBoundsInParent();
        if ((heroBounds.intersects(LrBounds) && isFlipped)) {
            System.out.println("check tower interception");
            TranslateTransition translate5 = new TranslateTransition(Duration.seconds(1), fallHero);
            translate5.setByY(300);
            translate5.play();
            isFlipped = false;

            translate5.setOnFinished(event1 -> {
                Scene gameOverScene = createGameOverScene();
                primaryStage.setScene(gameOverScene);
            });

        }
    }

    private void checkcarrotInterception() {
        Bounds heroBounds = Hero.getBoundsInParent();
        Bounds carrotBounds = carrot.getBoundsInParent();


        if (heroBounds.intersects(carrotBounds)) {
            // carrot intercepted
//            System.out.println("carrot intercepted");

            carrotCountTimeline.stop(); // Stop the timeline once carrot is intercepted
            carrotScore++; // Increment the score
            carrot.setDisable(true); // Disable the carrot so that it cannot be intercepted again
            carrotLabelGlobal.setText("Carrot: " + carrotScore);
            Layout.getChildren().remove(carrot); // Remove the carrot from the layout
            // Add logic here for what should happen when the carrot is intercepted
            carrotScore++;
        }
    }

    private void saveScore(int score) {
        try {
            FileWriter writer = new FileWriter("carrot_score.txt");
            writer.write(String.valueOf(score));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int loadScore() {
        try {
            FileReader reader = new FileReader("carrot_score.txt");
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            if (line != null) {
                carrotScore = Integer.parseInt(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carrotScore;
    }

    private Scene createNewScene() {

//        String musicFile = "F:\\AP_Endsem\\stickhero\\src\\main\\resources\\com\\example\\stickhero\\game_music.mp3";
//        Media sound = new Media(new File(musicFile).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Repeat the music indefinitely
//        mediaPlayer.play();

        Score = 0;
        Button backButton = new Button("PAUSE");
        backButton.setOnAction(event -> handleBackToMenuClick());

        Label scoreLabel = new Label("Score: " + Score);
        scoreLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold");

        scoreLabelGlobal = scoreLabel;

        // Position the score label
        scoreLabel.setLayoutX(450); // Adjust the X-coordinate as needed
        scoreLabel.setLayoutY(70); // Adjust the Y-coordinate as needed

        Label carrotLabel = new Label("Carrot : " + carrotScore);
        carrotLabelGlobal = carrotLabel;

        carrotLabel.setLayoutX(450);
        carrotLabel.setLayoutY(100);
        carrotLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: black; -fx-font-weight: bold");

        Rectangle tower = new Rectangle(0, 0, 100, 200);
        tower.setX(0);
        tower.setY(340);
        tower.setStyle("-fx-fill: black;");

        mainRectangle = tower;

        // Load hero sprite using FileInputStream
        try {
            FileInputStream heroInputStream = new FileInputStream("src\\main\\resources\\com\\example\\stickhero\\hero_sprite.png ");
            Image heroImage = new Image(heroInputStream);
            ImageView heroImageView = new ImageView(heroImage);

            Hero = heroImageView;

//            FileInputStream flippedHeroInputStream = new FileInputStream("src\\main\\resources\\com\\example\\stickhero\\carrot.png");
//            Image flippedHeroImage = new Image(flippedHeroInputStream);
//            ImageView flippedHeroImageView = new ImageView(heroImage);
//
//            FlippedHero = flippedHeroImageView;


            heroImageView.setFitWidth(35); // Adjust the width as needed
            heroImageView.setPreserveRatio(true);

            fallHero = heroImageView;

//            Scale heroScale = new Scale(1, 1, 0, 0); // Initial scale, no flip
//            heroImageView.getTransforms().add(heroScale);

//            scaleHero = heroScale;

            // Set the hero's initial position
            heroImageView.setX(60); // Adjust the X-coordinate as needed
            heroImageView.setY(286); // Adjust the Y-coordinate as needed

            makeStick();

            Group newLayout = new Group();
            Layout = newLayout;

            newLayout.getChildren().addAll(tower, heroImageView, backButton, stick);
            // Add the score label to the layout
            newLayout.getChildren().add(scoreLabel);
            newLayout.getChildren().add(carrotLabel);
            // Create more rectangles
            for (int i = 0; i < 1; i++) {
                Rectangle rectangle = createRandomRectangle();
                newLayout.getChildren().add(rectangle);
            }

            newLayout.setStyle("-fx-background-color: lightgreen;");
            Image BackgroundImage = new Image(new FileInputStream("src\\main\\resources\\com\\example\\stickhero\\background.png"));
            ImageView BackgroundImageView = new ImageView(BackgroundImage);
            BackgroundImageView.setFitWidth(540);
            BackgroundImageView.setPreserveRatio(true);
            BackgroundImageView.setX(0);
            BackgroundImageView.setY(0);
            newLayout.getChildren().add(BackgroundImageView);
            BackgroundImageView.toBack();

            carrot();
//            mediaPlayer.stop();

            return new Scene(newLayout, 540, 540);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message) appropriately
            return null;
        }
    }


    private Rectangle createRandomRectangle() {
        Random random = new Random();
        double width = random.nextDouble() * 100 + 50; // Random width between 50 and 150
        double height = 200; // Fixed height
        double x = random.nextDouble() * 240 + 150; // Random X position between 0 and 340

        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setX(x);
        rectangle.setY(340);
        rectangle.setStyle("-fx-fill: black;");
//        System.out.println("created new rectangle: " + rectangle.getX());
        currRectangle = latestRectangle;
        latestRectangle = rectangle;
//        System.out.println("updated as latest rectangle");
        return rectangle;
    }

    private void restartRotateTimeline() {
        // Stop the existing rotate timeline if it's running
        if (rotateTimeline != null && rotateTimeline.getStatus() == Timeline.Status.RUNNING) {
            rotateTimeline.stop();
        }

        // Create a new rotate timeline
        rotateTimeline = new Timeline(new KeyFrame(Duration.millis(1000), e -> rotateStick()));
        rotateTimeline.setCycleCount(1); // Run once
        rotateTimeline.play();
    }

    private void rotateStick() {

        Rotate rotate = new Rotate(90, stick.getStartX(), stick.getStartY());
        stick.getTransforms().add(rotate);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(10), new KeyValue(rotate.angleProperty(), 90)
                )
        );
        timeline.play();
//        stick = new Line();

        Calculate(mainRectangle.getX(), latestRectangle.getX(), mainRectangle.getWidth(), latestRectangle.getWidth(), latestStickLength);

    }

    public void Calculate(double x1, double x2, double w1, double w2, double stickLength) {
//        double temp = (x1+(w1/2)) + (x2+(w2/2));
        double distance = (x2 - 100);
        towerDistance = distance;

//        System.out.println("temp: "+distance);
//        System.out.println("x1 : "+x1);
//        System.out.println("x2: "+x2);
//        System.out.println("width 1:"+w1);
        if ((stickLength >= distance) & (stickLength < distance + w2)) {
            System.out.println("Player will walk");
            moveTranslation();
            Score++;
            scoreLabelGlobal.setText("Score: " + Score);
        } else {
            System.out.println("Player will fall");
            expiryTranslation();
        }
    }

    private void moveTranslation() {
        TranslateTransition translate1 = new TranslateTransition(Duration.seconds(2), mainRectangle);
        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(2), latestRectangle);
        TranslateTransition translate3 = new TranslateTransition(Duration.seconds(2), newStick);
        TranslateTransition translate4 = new TranslateTransition(Duration.seconds(2), carrot);
        TranslateTransition translate7 = new TranslateTransition(Duration.seconds(2), currRectangle);


        translate1.setByX(-towerDistance - latestRectangle.getWidth());
        translate2.setByX(-towerDistance - latestRectangle.getWidth());
        translate3.setByX(-towerDistance - latestRectangle.getWidth());
        translate4.setByX(-towerDistance - latestRectangle.getWidth());
        translate7.setByX(-towerDistance - latestRectangle.getWidth());


        translate1.play();
        translate2.play();
        translate3.play();
        translate4.play();
        translate7.play();


        translate1.setOnFinished(event -> {
            Rectangle newRectangle = createRandomRectangle();
            moreLatestRectangle = newRectangle;
            Layout.getChildren().add(newRectangle);

            Random rand = new Random();
            int randomnum = rand.nextInt(2);
            if (randomnum == 1) {
                carrot();
            }

            stick = new Line();
            stick.setStartX(100);
            stick.setStartY(340);
            stick.setEndX(100);
            stick.setEndY(340);
            stick.setStrokeWidth(3);
            Layout.getChildren().add(stick);
//            stick.setStartX(100);
//            stick.setEndX(100);
//            stick.setStartY(75);
//            stick.setEndY(75);
//            stick.setRotate(90);
        });

//        TranslateTransition translate6 = new TranslateTransition( Duration.seconds(2), moreLatestRectangle);
//        translate6.setByX(-latestStickLength -fallHero.getFitWidth());
//        translate6.play();
    }

    private void expiryTranslation() {
        TranslateTransition translate1 = new TranslateTransition(Duration.seconds(2), mainRectangle);
        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(2), latestRectangle);
        TranslateTransition translate3 = new TranslateTransition(Duration.seconds(2), newStick);
        TranslateTransition translate4 = new TranslateTransition(Duration.seconds(2), carrot);
        TranslateTransition translate6 = new TranslateTransition(Duration.seconds(2), currRectangle);


        translate1.setByX(-latestStickLength - fallHero.getFitWidth());
        translate2.setByX(-latestStickLength - fallHero.getFitWidth());
        translate3.setByX(-latestStickLength - fallHero.getFitWidth());
        translate4.setByX(-latestStickLength - fallHero.getFitWidth());
        translate6.setByX(-latestStickLength - fallHero.getFitWidth());


        translate1.play();
        translate2.play();
        translate3.play();
        translate4.play();
        translate6.play();


        translate1.setOnFinished(event -> {
            TranslateTransition translate5 = new TranslateTransition(Duration.seconds(1), fallHero);
            translate5.setByY(300);
            // make score scene
            translate5.play();

            translate5.setOnFinished(event1 -> {
                Scene gameOverScene = createGameOverScene();
                primaryStage.setScene(gameOverScene);
            });
            //call game over scene


        });


    }

    private void handleLoadButtonClick() {
        System.out.println("LOADED DATA!");
        loadScore();
        // Add your code to handle the "LOAD" functionality
    }

    private void handleExitButtonClick() {
        System.out.println("EXIT button clicked!");
        primaryStage.close();
    }

    private void handleBackToMenuClick() {
        Scene pauseScene = createPauseScene();
        primaryStage.setScene(pauseScene);
    }

    private void handleSaveButtonClick() {
        System.out.println("SAVE button clicked!");
        // Add your code to handle the "SAVE" functionality
        saveScore(carrotScore);

    }

    private void handleReviveButtonClick() {
        System.out.println("REVIVE button clicked!");

        if (carrotScore >= 20) {
            carrotScore = carrotScore - 20;
            Scene newScene = createNewScene();
            primaryStage.setScene(newScene);
        } else {
            System.out.println("Not enough carrots");
        }
    }

        // Add your code to handle the "REVIVE" functionality

        private void handleMenuClick () {
            Scene menuScene = createMenuScene();
            primaryStage.setScene(menuScene);

        }




    public static void main(String[] args) {
        launch();
    }
}
