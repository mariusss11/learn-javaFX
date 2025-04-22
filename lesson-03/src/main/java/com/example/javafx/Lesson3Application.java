package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Lesson3Application extends Application {
    private AnchorPane drawPanel;

    @Override
    public void start(Stage stage) throws Exception {
        createGUI(stage);
    }

    private void createGUI(Stage primaryStage) {
        createDrawingPanel();

        Scene scene = new Scene(drawPanel, 1100, 600);

        primaryStage.setTitle("Aplicatie JAVA FX 03");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void createDrawingPanel() {
        // Creating the drawing 'space'
        drawPanel = new AnchorPane();
        drawPanel.setStyle("-fx-background-color: #ffffff");

        // Creating some basic text with a build function
        Text text1 = createText("Java FX is very interesting", 40, 200, 80, Color.CORNFLOWERBLUE);
        Text text2 = createText("Let's learn more together ;)", 300, 290, 40, Color.CADETBLUE);

        // Creating some texts with some effects
        Text text3 = createText("Welcome!", 430, 50, 45, Color.TURQUOISE);
        text3.setEffect(new Reflection());

        Text text4 = createText("Goodbye!", 430, 550, 55, Color.BLUEVIOLET);
        text4.setEffect(new InnerShadow());

        Text personalizeText = createText("You declare the speed!", 250, 450, 50, Color.DARKORANGE);
        personalizeText.setEffect(new DropShadow());

        // Adding all the texts to the panel
        drawPanel.getChildren().addAll(text1, text2, text3, text4, personalizeText);
    }

    /**
     * Using this method, we can create a text on the drawPanel
     * @param title the proper text
     * @param x the x coordinate of the text
     * @param y the y coordinate of the text
     * @param size the size of the text
     * @param color the color of the text
     * @return the created text with these params
     */
    private Text createText(String title, int x, int y, int size, Color color) {
        Text text = new Text();
        text.setText(title);
        text.setX(x);
        text.setY(y);
        text.setFill(color);
        text.setFont(Font.font(size));
        return text;
    }

    public static void main(String[] args) {
        launch();
    }

}