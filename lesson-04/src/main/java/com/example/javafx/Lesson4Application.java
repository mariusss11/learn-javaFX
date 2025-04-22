package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import static com.example.javafx.Constants.SCENE_HEIGHT;
import static com.example.javafx.Constants.SCENE_WIDTH;

public class Lesson4Application extends Application {

    private BorderPane principalPanel;
    private BorderPane centralPanel;
    private AnchorPane drawingPanel;
    private AnchorPane textPanel;

    // Visual components for textPanel
    private Button drawButton;
    private Text text;
    private TextArea textArea;


    @Override
    public void start(Stage stage) throws Exception {
        createGUI(stage);
        setActions();
    }


    private void createGUI(Stage primaryStage) {
        principalPanel = new BorderPane();

        centralPanel = new BorderPane();
        principalPanel.setCenter(centralPanel);

        createDrawingPanel();
        centralPanel.setCenter(drawingPanel);

        createTextPanel();
        centralPanel.setTop(textPanel);

        Scene scene = new Scene(principalPanel, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setTitle("Aplicatie JAVA FX 04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setActions() {
        drawButton.setOnAction(event -> {
            changeText();
        });
    }

    private void changeText() {
        text.setText(textArea.getText());
    }

    private void createDrawingPanel() {
        drawingPanel = new AnchorPane();
        drawingPanel.setStyle("-fx-background-color: #ffffff;");

        text = createText("Java is super", 100, 100, 50, Color.CORAL);

        drawingPanel.getChildren().add(text);

    }

    private void createTextPanel() {
        textPanel = new AnchorPane();

        textArea = createTextArea(30, 70, 550, 70);
        drawButton = createButton("Draw the text", 600, 80);

        textPanel.getChildren().addAll(textArea, drawButton);
    }

    private Text createText(String title, int x, int y, int size, Color color) {
        Text createdText = new Text(x, y, title);
        createdText.setFont(Font.font(size));
        createdText.setFill(color);
        return  createdText;
    }

    private TextArea createTextArea(int x, int y, int width, int height) {
        TextArea textArea = new TextArea();
        textArea.setLayoutX(x);
        textArea.setLayoutY(y);
        textArea.setMinWidth(width);
        textArea.setMaxWidth(width);
        textArea.setMinHeight(height);
        textArea.setMaxHeight(height);
        return textArea;
    }

    private Button createButton(String title, int x, int y) {
        Button button = new Button();
        button.setText(title);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setMinHeight(30);
        button.setTextAlignment(TextAlignment.CENTER);
        return button;
    }

}
