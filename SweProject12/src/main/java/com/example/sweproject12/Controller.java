package com.example.sweproject12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    ArrayList<AdvancedUser> advancedUsers = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    ArrayList<Event> events = new ArrayList<>();
    @FXML
    private PasswordField tf_password;
    @FXML
    private TextField tf_id;
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

    private Account me;
    @FXML
    private ScrollPane myScrollPane;

    @FXML
    private VBox vboxContainer;

    @FXML
    private Button addButton; // Assume you have a button in FXML to trigger adding content





    @FXML
    void onLoginBtnClicked(ActionEvent event) throws Exception {
        users.add(new User("a","a@gmail.com","123",true));
        String id = tf_id.getText();
        String password = tf_password.getText();
        boolean flag = true;
        for (User user : users) {
            if (user.getId().equals(id) && user.verifyPassword(password)) {
                me = user;
                flag = false;
                break;
            }
        }
        if (me == null) { // Check if me is still null
            warnLabel.setVisible(true);
            warnLabel.setText("Wrong ID or Password");
            return; // Stop further execution if login is not successful
        }
        try {
            changeScene(event, "AfterLogin.fxml", "AfterLogin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void changeScene(ActionEvent event, String fxmlFile, String title) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
                Parent root = loader.load();

                // Get the controller of the new scene
                Controller newController = loader.getController();
                if (me != null) {
                    newController.lbl_paneLeft.setText("Welcome " + me.getId());
                }
                Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle(title);
            } catch (Exception e) {
                e.printStackTrace();
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

    }
    @FXML
    void onOpenReservationClicked(ActionEvent event) {
            changeScene(event, "openReservation.fxml", "openReservation");
    }

    public void initialize() {
        rooms.add(new Room("101", "Facility", "building 22", "Male"));
        rooms.add(new Room("102", "Facility", "building 22", "Female"));
        rooms.add(new Room("103", "Class Room", "building 22", "Unisex"));
        rooms.add(new Room("104", "Lab", "building 22", "Male"));
        rooms.add(new Room("105", "Class Room", "building 22", "Female"));
        if (myScrollPane == null) {
            System.out.println("Error: myScrollPane is not initialized!");
        } else {
            vboxContainer = new VBox(10); // Adjust spacing as needed
            myScrollPane.setContent(vboxContainer);
            for (Room room:rooms) {
                addContent(room);
            }
        }
    }


    private void addContent(Room room) {
        VBox roomBox = new VBox(10); // Provides vertical spacing between elements

        // Top row containing the room number, location, and type
        HBox topRow = new HBox(10); // Spacing between elements in HBox
        topRow.setStyle("-fx-background-color: lightblue; -fx-padding: 5;");

        VBox roomNumberBox = new VBox(2);
        roomNumberBox.getChildren().addAll(new Label("Room Number"), new Label(room.getRoomNumber()));

        VBox locationBox = new VBox(2);
        locationBox.getChildren().addAll(new Label("Location"), new Label(room.getLocation()));

        VBox typeBox = new VBox(2);
        typeBox.getChildren().addAll(new Label("Type"), new Label(room.getRoomType()));

        VBox genderBox = new VBox(2);
        genderBox.getChildren().addAll(new Label("Gender who can reserve"), new Label(room.getGender()));

        topRow.getChildren().addAll(roomNumberBox, locationBox, typeBox,genderBox); // Add to top row

        // Second row for gender, date picker, time choice, and reserve button
        HBox secondRow = new HBox(10); // Spacing and layout management
        secondRow.setStyle("-fx-padding: 5;");

        DatePicker datePicker = new DatePicker();

        ChoiceBox<String> timeChoiceBox = new ChoiceBox<>();
        timeChoiceBox.getItems().addAll("09:00-10:00", "10:00-11:00", "11:00-12:00"); // Example time slots

        Button reserveButton = new Button("Reserve");
        reserveButton.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue();
            String selectedTime = timeChoiceBox.getValue();
            if (selectedDate != null && selectedTime != null) {
                createReservation(room, selectedDate, selectedTime);
            } else {
                showWarning("Please select both a date and a time slot.");
            }
        });

        secondRow.getChildren().addAll( datePicker, timeChoiceBox, reserveButton);

        // Add both rows to the main container
        roomBox.getChildren().addAll(topRow, secondRow);
        vboxContainer.getChildren().add(roomBox);
    }
    private void createReservation(Room room,LocalDate date, String time) {
        // reservation creation logic
        Reservation newReservation = new Reservation(me,room,date,"Confirmed",time);
        reservations.add(newReservation);

        // Show an alert dialog to confirm the reservation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reservation Successful");
        alert.setHeaderText(null);
        alert.setContentText("You have successfully reserved Room " + room.getRoomNumber() + ".");
        alert.showAndWait();
    }
    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Incomplete Selection");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private List<String> getAvailableTimeSlots(Room room, LocalDate date) {
        // List of all possible time slots
        List<String> allTimeSlots = new ArrayList<>(Arrays.asList("09:00-10:00", "10:00-11:00", "11:00-12:00"));

        // Filter out time slots that have been reserved for this room and date
        reservations.stream()
                .filter(reservation -> reservation.getRoom().equals(room) && reservation.getDate().equals(date))
                .forEach(reserved -> allTimeSlots.remove(reserved.getTime()));

        return allTimeSlots;
    }
}

