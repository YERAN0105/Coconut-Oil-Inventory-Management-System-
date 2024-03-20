package com.example.heshan;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Update {
    public TextField name;
    public TextField date;
    public AnchorPane updateNameAnchor;
    public static List<List<Object>> upSupplies = new ArrayList<>();
    public Label errorName;

    public void onUpdateNameNextButtonClick() throws IOException {
        upSupplies.clear();
        Supply instance = new Supply();
        instance.setName(name.getText());
        instance.setDate(date.getText());
        List<List<Object>> supplies = HelloApplication.supplies;
        int count =0;
        for (List<Object> i : supplies){
            String datePart = i.get(4).toString();
            datePart = datePart.substring(0,7);
            if (String.valueOf(i.get(0)).equalsIgnoreCase(instance.getName()) && datePart.equals(instance.getDate())){
                upSupplies.add(i);
                count++;
            }
        }
        if (count==0){
            errorName.setText("No entries for the given inputs");
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateTable.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
            stage.setTitle("Results");
            stage.setScene(scene);
            stage.show();
            Stage previousStage = (Stage) updateNameAnchor.getScene().getWindow();
            previousStage.close();
        }
    }

    public void onUpdateNameBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MENU.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600,  400);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();
        Stage previousStage = (Stage) updateNameAnchor.getScene().getWindow();
        previousStage.close();
    }
}
