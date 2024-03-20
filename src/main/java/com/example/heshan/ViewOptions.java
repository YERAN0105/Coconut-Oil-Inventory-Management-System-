package com.example.heshan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewOptions {
    public AnchorPane viewOptionsAnchor;
    public AnchorPane enterNameAnchor;
    public TextField name;
    public Label errormsg;
    public AnchorPane enterMonthAnchor;
    public TextField month;
    public Label MonthErrormsg;
    List<List<Object>> supplies = HelloApplication.supplies;
    public static List<List<Object>> supplyView = new ArrayList<>();

    public void onViewAllButtonClick() throws IOException {
        supplyView.clear();
        for (List<Object> i : supplies){
            supplyView.add(i);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewItems.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) viewOptionsAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onViewSupplierButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EnterName.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 508.0,  257.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) viewOptionsAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onViewMonthButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("EnterMonth.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 508.0,  257.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) viewOptionsAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onEnterNameBackButtonClick()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewOptions.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) enterNameAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onEnterNameNextButtonClick() throws IOException{
        supplyView.clear();
        Supply instance = new Supply();
        instance.setName(name.getText());
        if (instance.getName().equals("")) {
            errormsg.setText("Please enter a Supplier name");
            return;
        }
        for (List<Object> i : supplies){
            if (String.valueOf(i.get(0)).equalsIgnoreCase(instance.getName())){
                supplyView.add(i);
            }
        }
        if (supplyView.size()==0){
            errormsg.setText("No entries for the given Dealer!");
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewItems.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) enterNameAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onBackButonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MENU.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600,  400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        Stage previousStage = (Stage) viewOptionsAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onEnterMonthBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewOptions.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) enterMonthAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onEnterMonthNextButtonClick() throws IOException {
        supplyView.clear();
        Supply instance = new Supply();
        instance.setDate(month.getText());
        if (instance.getDate().equals("")) {
            MonthErrormsg.setText("Please enter a Month");
            return;
        }
        for (List<Object> i : supplies){
            String datePart = i.get(4).toString();
            datePart = datePart.substring(0,7);
            if (datePart.equals(instance.getDate())){
                supplyView.add(i);
            }
        }
        if (supplyView.size()==0){
            MonthErrormsg.setText("No entries for the given Month!");
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewItems.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) enterMonthAnchor.getScene().getWindow();
        previousStage.close();

    }
}
