package com.example.dsm_402_qualite_vone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage PrimaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Extra.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStage.setTitle("Bienvenido");
        PrimaryStage.setScene(scene);
        PrimaryStage.setResizable(false);
        PrimaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}