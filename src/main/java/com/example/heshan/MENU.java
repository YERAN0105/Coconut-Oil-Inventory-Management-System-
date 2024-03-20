package com.example.heshan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MENU {
    public AnchorPane menuPage;

    public void onAddButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AID.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) menuPage.getScene().getWindow();
        previousStage.close();
    }

    public void onDelButtonClick() throws IOException {

    }

    public void onSaveButtonClick() throws  IOException {
        List<List<Object>> supplies = HelloApplication.supplies;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Supplies.txt"));

            for(List<Object> i : supplies){
                writer.write(i.toString()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onUpdateButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateName.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 487.0,  296.0);
        stage.setTitle("Update/Delete items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) menuPage.getScene().getWindow();
        previousStage.close();
    }

    public void onViewButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewOptions.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) menuPage.getScene().getWindow();
        previousStage.close();
    }

    public void onBillViewButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BillDetails.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) menuPage.getScene().getWindow();
        previousStage.close();
    }
}
