package com.example.sweproject12;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    @FXML
    private Label welcomeText;
    @FXML
    private Pane paneLeft;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_userName;

    @FXML
    private Button loginBtn;
    @FXML
    private Pane LoginPane;

    @FXML
    void onLoginBtnClicked(ActionEvent event) throws Exception {
        String name = tf_userName.getText();
        String password = tf_password.getText();
        ArrayList<String> data = new ArrayList<>();
        data.add("ABCPassword");
        if (name.equals("") || password.equals("")) {
            System.out.println("enter name or password");
        }
        else{
            // for those working in back end: this is similar idea we need to check first the user is in the database
            // its is preferable to use key value to access the user quickly, delete this message after u r done.
            Account ob1= new Account(tf_userName.getText(),"a",data.get(0),true,"a");
            if (ob1.verifyPassword(tf_password.getText())){
                System.out.println("password verified");
                try {
                    changeScene(event,"AfterLogin.fxml","AfterLogin",tf_userName.getText(),tf_password.getText());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.println("wrong password");
            }



        }


        }
    void changeScene(ActionEvent event, String fxmlFile,String title,String name, String password){
        Parent pane = null;
        if(name!= null && password != null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
                Parent root = loader.load();

                Stage stage = (Stage) LoginPane.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle(title);


            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}



