package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Lesson2Application extends Application {


    private BorderPane panel;
    private HBox components;
    private AnchorPane drawPanel;

    private TextField textFieldX1;
    private TextField textFieldY1;
    private TextField textFieldX2;
    private TextField textFieldY2;
    private TextField lineWidth;

    private Button btnDeseneazaLinie;
    private Button deleteEverythingBtn;


    @Override
    public void start(Stage stage) throws Exception {
        createGUI(stage);
        setActions();
    }

    private void createGUI(Stage primaryStage) {
        panel = new BorderPane();
        createComponentsPanel();
        panel.setTop(components);

        drawPanel = new AnchorPane();
        drawPanel.setStyle("-fx-background-color: #ffffff");
        panel.setCenter(drawPanel);

        Scene scene = new Scene(panel, 900, 550);

        primaryStage.setTitle("Aplicatie JAVA FX 02");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setActions() {
        btnDeseneazaLinie.setOnAction(event -> {
            linieDeseneazaSetOnAction();
        });
        deleteEverythingBtn.setOnAction(event -> {
            deleteEverything();
        });
    }

    private void deleteEverything() {
        drawPanel.getChildren().clear();
    }


    private void linieDeseneazaSetOnAction() {
        int x1 = Integer.parseInt(textFieldX1.getText());
        int y1 = Integer.parseInt(textFieldY1.getText());
        int x2 = Integer.parseInt(textFieldX2.getText());
        int y2 = Integer.parseInt(textFieldY2.getText());
        int width = Integer.parseInt(lineWidth.getText());

        drawLine(drawPanel, x1, y1, x2, y2, width, Color.BURLYWOOD);
    }

    public void drawLine(AnchorPane panou, int x1, int y1, int x2, int y2, int grosimea, Color color) {
        Line line = new Line(x1, y1, x2, y2);
        line.setStrokeWidth(grosimea);
        line.setStroke(color);
        panou.getChildren().add(line);
    }

    private void createComponentsPanel() {
        components = new HBox();
        components.setSpacing(7);
        components.setPadding(new Insets(5));

        // Creating text fields and labels for line coordinates
        Label labelX1 = new Label("Linie (X1)");
        textFieldX1 = createTextField();
        components.getChildren().addAll(labelX1, textFieldX1);

        Label labelY1 = new Label("Linie (Y1)");
        textFieldY1 = createTextField();
        components.getChildren().addAll(labelY1, textFieldY1);

        Label labelX2 = new Label("Linie (X2)");
        textFieldX2 = createTextField();
        components.getChildren().addAll(labelX2, textFieldX2);

        Label labelY2 = new Label("Linie (Y2)");
        textFieldY2 = createTextField();
        components.getChildren().addAll(labelY2, textFieldY2);

        // Create "Deseneaza linie" button
        btnDeseneazaLinie = createButton("Draw line");

        Label widthLabel = new Label("Width: ");
        lineWidth = createTextField();
        components.getChildren().addAll(widthLabel, lineWidth);

        // Create "Delete Everything" button
        deleteEverythingBtn = createButton("Delete Everything");

        // Add buttons to the component layout
        components.getChildren().addAll(btnDeseneazaLinie, deleteEverythingBtn);
    }


    public TextField createTextField() {
        TextField textField = new TextField();
        textField.setMaxWidth(50);
        return textField;
    }

    private Button createButton(String title) {
        Button btn = new Button();
        btn.setText(title);
        return btn;
    }

    public static void main(String[] args) {
        launch();
    }

}