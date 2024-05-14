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
    private AnchorPane loginAnchorPane;
    @FXML
    private Label lbl_paneLeft;
    @FXML
    private VBox vbox1test;
    static Account me;
    @FXML
    private ScrollPane myScrollPane;
    @FXML
    private VBox vboxContainer;
    @FXML
    private Button btn_openEvent;




    @FXML
    void onLoginBtnClicked(ActionEvent event) throws Exception {
        boolean flag = true;
        users.add(new User("a","a@gmail.com","123",true));
        admins.add(new Admin("a","a@gmail.com","1234",true));

        String id = tf_id.getText();
        String password = tf_password.getText();
        if(tf_id.getText().equals("Admin")&& tf_password.getText().equals("1234")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminAfterLogin.fxml"));
                Parent root = loader.load();

                // Get the controller of the new scene
                Controller newController = loader.getController();
                if (me != null) {
                    newController.lbl_paneLeft.setText("Welcome Admin " + me.getId());
                }
                Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Admin-After-Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfterLogin.fxml"));
            Parent root = loader.load();

            // Get the controller of the new scene
            Controller newController = loader.getController();
            if (me != null) {
                newController.lbl_paneLeft.setText("Welcome " + me.getId());
            }
            Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("After-Login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewReservation.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("View-Reservation");
            Controller newController = loader.getController();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void onBackBtnClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfterLogin.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginAnchorPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("After-Login");
            Controller newController = loader.getController();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
    void onDeleteReservationbtnClicked(ActionEvent event) {
        System.out.println("hi");
    }
    @FXML
    void onViewReBtnClickedAdmin(ActionEvent event) {
        System.out.println("hi");
    }

    @FXML
    void onModifyBtnClicked(ActionEvent event) {
        System.out.println("hi");
        vbox1test.setVisible(true);

    }
    public void initialize() {
        rooms.add(new Room("101", "Facility", "building 22", "Male"));
        rooms.add(new Room("102", "Facility", "building 22", "Female"));
        rooms.add(new Room("103", "Classroom", "building 22", "Unisex"));
        rooms.add(new Room("104", "Lab", "building 22", "Male"));
        rooms.add(new Room("105", "Classroom", "building 22", "Female"));
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
    @FXML
    void onOpenEventClicked(ActionEvent event) {
        // on open event clicked in page view reservation
    }
    @FXML
    void onCancelBtnUSERClicked(ActionEvent event) {
        // on cancel event clicked in page view reservation this is for user interface

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

        // Update time slots when a new date is picked or initially
        datePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            updateAvailableTimeSlots(timeChoiceBox, room, newDate);
        });

        // Update initially for today or another default date
        updateAvailableTimeSlots(timeChoiceBox, room, LocalDate.now());

        Button reserveButton = new Button("Reserve");
        reserveButton.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue();
            String selectedTime = timeChoiceBox.getValue();
            if (selectedDate != null && selectedTime != null) {
                boolean val = createReservation(room, selectedDate, selectedTime);
                datePicker.setValue(null);

                // Clear the ChoiceBox selection
                timeChoiceBox.getSelectionModel().clearSelection();
                if (val){
                    // Show an alert dialog to confirm the reservation
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Reservation Successful");
                    alert.setHeaderText(null);
                    alert.setContentText("You have successfully reserved Room " + room.getRoomNumber() + ".");
                    alert.showAndWait();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Reservation Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("You are not allowed to reserve this room " + room.getRoomNumber() + ".");
                    alert.showAndWait();
                }
            } else {
                showWarning("Please select both a date and a time slot.");
            }
        });

        secondRow.getChildren().addAll( datePicker, timeChoiceBox, reserveButton);

        // Add both rows to the main container
        roomBox.getChildren().addAll(topRow, secondRow);
        vboxContainer.getChildren().add(roomBox);
    }
    private boolean createReservation(Room room,LocalDate date, String time) {
        if (me == null) {
            System.out.println("No user is logged in.");
            return false;
        }
        else {
            if (room.getRoomType().equals("Classroom") || room.getRoomType().equals("Lab") ){
                if (me instanceof AdvancedUser){
                    if ((room.getGender().equals("Male") && me.isGender()) || (room.getGender().equals("Female") && (!me.isGender()))){
                        // reservation creation logic
                        Reservation newReservation = new Reservation(me,room,date,"Confirmed",time);
                        reservations.add(newReservation);
                        return true;
                    } else if (room.getGender().equals("UniSex")) {
                        Reservation newReservation = new Reservation(me,room,date,"Confirmed",time);
                        reservations.add(newReservation);
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                if ((room.getGender().equals("Male") && me.isGender()) || (room.getGender().equals("Female") && (!me.isGender()))){
                    // reservation creation logic
                    Reservation newReservation = new Reservation(me,room,date,"Confirmed",time);
                    reservations.add(newReservation);

                    return true;
                } else if (room.getGender().equals("UniSex")) {
                    Reservation newReservation = new Reservation(me,room,date,"Confirmed",time);
                    reservations.add(newReservation);
                    return true;
                }
                else{
                    return false;
                }
            }
        }
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
        List<String> allTimeSlots = new ArrayList<>(Arrays.asList(
                "08:00AM-09:00AM", "09:00AM-10:00AM", "10:00AM-11:00AM",
                "11:00AM-12:00PM", "12:00PM-01:00PM", "01:00PM-02:00PM",
                "02:00PM-03:00PM", "03:00PM-04:00PM", "04:00PM-05:00PM",
                "05:00PM-06:00PM", "06:00PM-07:00PM", "07:00PM-08:00PM",
                "08:00PM-09:00PM", "09:00PM-10:00PM"
        ));

        // Filter out time slots that have been reserved for this room and date
        reservations.stream()
                .filter(reservation -> {
                    boolean matches = reservation.getRoom().equals(room) && reservation.getDate().equals(date);
                    if (matches) {
                        System.out.println("Removing slot: " + reservation.getTime() + " for room " + room.getRoomNumber());
                    }
                    return matches;
                })
                .forEach(reserved -> allTimeSlots.remove(reserved.getTime()));

        return allTimeSlots;
    }
    private void updateAvailableTimeSlots(ChoiceBox<String> timeChoiceBox, Room room, LocalDate date) {
        List<String> availableSlots = getAvailableTimeSlots(room, date);
        timeChoiceBox.getItems().setAll(availableSlots);
        if (!availableSlots.isEmpty()) {
            timeChoiceBox.getSelectionModel().selectFirst();
        }
    }




}