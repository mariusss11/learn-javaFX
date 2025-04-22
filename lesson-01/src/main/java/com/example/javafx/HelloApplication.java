package com.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {


    private BorderPane panou;
    private HBox panouComponente;
    private AnchorPane panouDesenare;

    private Button btnDeseneaza;
    private Button btnDeseneazaLinie;

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

        Scene scene = new Scene(panou, 350, 250);

        primaryStage.setTitle("Aplicatie JAVA FX");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setActions() {
        btnDeseneazaLinie.setOnAction(event -> {
            linieDeseneazaSetOnAction();
        });
    }

    public void denseneazaLinie(AnchorPane panou, int x1, int y1, int x2, int y2, int grosimea, Color color) {
        Line line = new Line(x1, y1, x2, y2);
        line.setStrokeWidth(grosimea);
        line.setStroke(color);
        panou.getChildren().add(line);


    }

    private void linieDeseneazaSetOnAction() {
        denseneazaLinie(panouDesenare, 20, 30, 320, 200, 3, Color.RED);

    }

    private void creazaPanouComponente() {
        panouComponente = new HBox();
        panouComponente.setSpacing(7);
        panouComponente.setPadding(new Insets(5));

        btnDeseneazaLinie = creeazaButon("Deseneaza linie");

        btnDeseneaza = creeazaButon("Apasa aici");
        panouComponente.getChildren().addAll(btnDeseneazaLinie, btnDeseneaza);

    }

    private Button creeazaButon(String apasaAici) {
        Button btn = new Button();
        btn.setText(apasaAici);
        return btn;
    }


    public static void main(String[] args) {
        launch();
    }

}