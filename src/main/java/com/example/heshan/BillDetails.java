package com.example.heshan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillDetails {
    public AnchorPane billDetailsAnchor;
    public TextField name;
    public TextField date;
    public TextField advance;
    public TextField unitPrice;
    public Label errormsg;
    public Label invalAdvance;
    public Label invalUnitPrice;
    int advance1 =0;
    public static List<Integer> intInputs = new ArrayList<>();
    int unitPrice1 =0; //variables to store data
    public static List<List<Object>> billSupplies = new ArrayList<>();
    List<List<Object>> supplies = HelloApplication.supplies;

    public void onBillDetailsBackButtonClick()throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MENU.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600,  400);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();
        Stage previousStage = (Stage) billDetailsAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onBillDetailsNextButtonClick()throws IOException {
        intInputs.clear();
        Supply instance = new Supply();
        instance.setName(name.getText());
        int countErrors =0;
        if (instance.getName().equals("")) {
            countErrors++;
        }
        instance.setDate(date.getText());
        if (instance.getDate().equals("")){
            countErrors++;
        }
        int countIntErrors = 0;
        try {
            unitPrice1= Integer.parseInt(unitPrice.getText());
            invalUnitPrice.setText("");
            intInputs.add(unitPrice1);
        } catch (NumberFormatException e) {
            countIntErrors++;
            if (unitPrice.getText().equals("")){
                  countErrors++;
            } else {
                invalUnitPrice.setText("Invalid input");
            }
        }
        try {
            advance1=Integer.parseInt(advance.getText());
            invalAdvance.setText("");
            intInputs.add(advance1);
        } catch (NumberFormatException e) {
            countIntErrors++;
            if (advance.getText().equals("")){
                countErrors++;
            } else {
                invalAdvance.setText("Invalid input");
            }
        }

        if (countErrors>0){
            errormsg.setText("Please fill out all fields");
            return;
        }

        if (countIntErrors>0)
            return;

        int count =0;
        billSupplies.clear();
        for (List<Object> i : supplies){
            String datePart = i.get(4).toString();
            datePart = datePart.substring(0,7);
            if (String.valueOf(i.get(0)).equalsIgnoreCase(instance.getName()) && datePart.equals(instance.getDate())){
                billSupplies.add(i);
                count++;
            }
        }
        if (count==0){
            errormsg.setText("No items for the given inputs!");
        } else {
            System.out.println("There are items");
            errormsg.setText("");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BillView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 440.0,  670.0);
            stage.setTitle("Add items");
            stage.setScene(scene);
            stage.show();
        }
    }
}
