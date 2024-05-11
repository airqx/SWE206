package com.example.sweproject12;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    private PasswordField tf_password;
    @FXML
    private TextField tf_userName;
    @FXML
    private Button loginBtn;
    @FXML
    private Pane LoginPane;
    @FXML
    private Label warnLabel;
    @FXML
    private Label aa;
    @FXML
    private Button btn1;
    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private Label lbl_paneLeft;
    @FXML
    private Button btn_joinEvent;

    @FXML
    private ImageView iconJoin;

    @FXML
    private ImageView iconOpen;

    @FXML
    private ImageView iconReserve;
    @FXML
    void onLoginBtnClicked(ActionEvent event) throws Exception {
        String name = tf_userName.getText();
        String password = tf_password.getText();
        ArrayList<String> data = new ArrayList<>();
        data.add("A");

        if (name.isEmpty() || password.isEmpty()) {
            warnLabel.setVisible(true);
            warnLabel.setText("Name or Password is Empty");
        } else {
            // Verification logic here
            Account ob1 = new Account(tf_userName.getText(), "a", data.get(0), true, "a");
            if (ob1.verifyPassword(tf_password.getText())) {
                System.out.println("password verified");
                try {
                    changeScene(event, "AfterLogin.fxml", "AfterLogin", tf_userName.getText(), tf_password.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                warnLabel.setVisible(true);
                warnLabel.setText("Wrong Password!");
            }
        }
    }

    void changeScene(ActionEvent event, String fxmlFile, String title, String name, String password) {
        if (name != null && password != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
                Parent root = loader.load();

                // Get the controller of the new scene
                Controller newController = loader.getController();

                newController.lbl_paneLeft.setText("Welcome " + name);
                Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle(title);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void onJoinEventClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfterLogin.fxml"));
            Parent root = loader.load();

            // Get the controller of the new scene
            Controller newController = loader.getController();
            lbl_paneLeft.setText("Welcome working now ");



    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}