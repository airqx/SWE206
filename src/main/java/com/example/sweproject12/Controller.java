package com.example.sweproject12;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    private ChoiceBox<String> ChoiceBox;
    @FXML
    private TableColumn<String,String> ID ;
    @FXML
    private TableColumn<String,String> Room;

    @FXML
    private TableView<String> TapbeView;
    @FXML
    private String[] choice= {"a", "b"};
    @FXML
    private VBox vbox1test;





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
                    changeScene(event, "AfterLogin.fxml", "AfterLogin", "a", "a");

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("JoinAnOpenEvent.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Join Event");
            Controller newController = loader.getController();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void onReserveFacilityClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("openReservation.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Reserve facility");
            Controller newController = loader.getController();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void onViewReBtnClicked(ActionEvent event) {
        changeScene(event, "ViewReservation.fxml", "View Reservation","a","a");

    }

    @FXML
    void onBackBtnClicked(ActionEvent event) {
        changeScene(event, "AfterLogin.fxml", "After Login","a","a");

    }

    @FXML
    void onLogOutBtnClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("LoginPage");
        Controller newController = loader.getController();
        newController.warnLabel.setVisible(true);
        newController.warnLabel.setText("LogOut successful");



    }

    @FXML
    void onModifyBtnClicked(ActionEvent event) {
        System.out.println("hi");
        vbox1test.setVisible(true);

    }




}