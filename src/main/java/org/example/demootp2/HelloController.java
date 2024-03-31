package org.example.demootp2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button btnEN;
    @FXML
    private  Button btnFA;
    @FXML
    private  Button btnJP;

    private ResourceBundle bundle;
    private Locale locale;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onbtnFAClick() {
       loadLanguage("fa", "IR");

    }
    @FXML
    protected void onbtnJPClick() {
        loadLanguage("ja", "JP");
    }

    @FXML

    protected void onbtnENClick() {
        loadLanguage("en", "UK");
    }



    public void loadLanguage(String language, String country){
        locale = new Locale(language, country);
        bundle = ResourceBundle.getBundle("messages", locale);
        //welcomeText.setText(bundle.getString("greeting"));

        String greeting = bundle.getString("greeting");
        String name = bundle.getString("name");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        String formattedDate = localDateTime.format(dateFormatter);
        String formattedTime = localDateTime.format(formatter);

        String fullgreeting = String.format(greeting, name, formattedDate, formattedTime);

        welcomeText.setText(fullgreeting);



    }

    public void onbtnENClick(ActionEvent actionEvent) {
        loadLanguage("en", "UK");
    }

    public void onbtnFAClick(ActionEvent actionEvent) {
        loadLanguage("fa", "IR");
    }

    public void onbtnJPClick(ActionEvent actionEvent) {
        loadLanguage("ja", "JP");
    }
}