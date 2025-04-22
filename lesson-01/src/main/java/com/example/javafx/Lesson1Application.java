package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Lesson1Application extends Application {


    private BorderPane panou;
    private HBox panouComponente;
    private AnchorPane panouDesenare;

    private Button btnDeseneazaLinie;
    private Button btnDeseneazaDreptunghi;
    private Button polygonDrawingBtn;
    private Button deleteEverythingBtn;

    @Override
    public void start(Stage stage) throws Exception {
        createGUI(stage);
        setActions();
    }

    private void createGUI(Stage primaryStage) {
        panou = new BorderPane();
        creazaPanouComponente();
        panou.setTop(panouComponente);

        panouDesenare = new AnchorPane();
        panouDesenare.setStyle("-fx-background-color: #ffffff");
        panou.setCenter(panouDesenare);

        Scene scene = new Scene(panou, 530, 250);

        primaryStage.setTitle("Aplicatie JAVA FX 01");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setActions() {
        btnDeseneazaLinie.setOnAction(event -> {
            linieDeseneazaSetOnAction();
        });
        btnDeseneazaDreptunghi.setOnAction(event -> {
            dreptunghiDeseneazaSetOnAction();
        });
        polygonDrawingBtn.setOnAction(event -> {
            drawPolygonSetOnAction();
        });
        deleteEverythingBtn.setOnAction(event -> {
            deleteEverything();
        });
    }

    private void deleteEverything() {
        panouDesenare.getChildren().clear();
    }

    private void drawPolygonSetOnAction() {
        // Create the polygon object
        Polygon polygon = new Polygon();

        // Setting its coordinates
        polygon.getPoints().addAll(new Double[]{
                10.0, 200.0,
                90.0, 150.0,
                150.0, 200.0,
        });

        // Playing with its colors
        polygon.setFill(Color.CRIMSON);
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeWidth(2.0);

        // Adding it to the AnchorPane
        panouDesenare.getChildren().add(polygon);
    }


    private void linieDeseneazaSetOnAction() {
        drawLine(panouDesenare, 20, 30, 320, 200, 3, Color.RED);
    }

    public void drawLine(AnchorPane panou, int x1, int y1, int x2, int y2, int grosimea, Color color) {
        Line line = new Line(x1, y1, x2, y2);
        line.setStrokeWidth(grosimea);
        line.setStroke(color);
        panou.getChildren().add(line);
    }

    private void dreptunghiDeseneazaSetOnAction() {
        drawRectangle(panouDesenare, 330, 40, 150, 50, Color.AQUAMARINE);
    }

    private void drawRectangle(AnchorPane panouDesenare, int x, int y, int width, int height, Color color) {
        // Creating the rectangle
        Rectangle rectangle = new Rectangle(x, y, width, height);

        // Setting the color
        rectangle.setFill(color);

        // Setting the color of the stroke
        rectangle.setStroke(Color.BLACK);

        // Making the rounded corners
        rectangle.setArcHeight(10.0d);
        rectangle.setArcWidth(10.0d);

        // Adding the rectangle to the main page
        panouDesenare.getChildren().add(rectangle);
    }

    private void creazaPanouComponente() {
        panouComponente = new HBox();
        panouComponente.setSpacing(7);
        panouComponente.setPadding(new Insets(5));

        btnDeseneazaLinie = createButton("Make a line");
        btnDeseneazaDreptunghi = createButton("Make a rectangle");
        polygonDrawingBtn = createButton("Make a polygon");
        deleteEverythingBtn = createButton("Delete everything");

        panouComponente.getChildren().addAll(btnDeseneazaLinie, btnDeseneazaDreptunghi, polygonDrawingBtn, deleteEverythingBtn);
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