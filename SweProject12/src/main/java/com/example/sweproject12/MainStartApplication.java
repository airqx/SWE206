package com.example.sweproject12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStartApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        setupScene(primaryStage, "LoginPage.fxml", "Main Page");
    }
    public void setupScene(Stage stage, String fxmlFile, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}