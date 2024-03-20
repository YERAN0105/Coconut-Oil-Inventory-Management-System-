package com.example.heshan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateFields implements Initializable {
    public AnchorPane updateFieldsAnchor;
    public TextField name;
    public TextField litres;
    public TextField meter;
    public TextField date;
    public Label invalLtr;
    public Label invalMtr;
    public Label FillAllFields;
    public AnchorPane repeatUpAnchor;
    List<Object> supply = UpdateTable.chosenSupply;
    List<List<Object>> supplies = HelloApplication.supplies;
    List<List<Object>> upSupplies = Update.upSupplies;
    public static List<Object> upSupply = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(String.valueOf(supply.get(0)));
        litres.setText(String.valueOf(supply.get(1)));
        meter.setText(String.valueOf(supply.get(2)));
        date.setText(String.valueOf(supply.get(4)));
    }

    public void onDeleteButttonClick() throws IOException {
        for (List<Object> i : upSupplies){
            if (i.equals(supply)){
                upSupplies.remove(supply);
                break;
            }
        }
        for (List<Object> i : supplies){
            if (i.equals(supply)){
                supplies.remove(supply);
                break;
            }
        }
        if (upSupplies.size()==0){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateName.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 487.0,  296.0);
            stage.setTitle("Update/Delete items");
            stage.setScene(scene);
            stage.show();

            Stage previousStage = (Stage) updateFieldsAnchor.getScene().getWindow();
            previousStage.close();
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateTable.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Results");
        stage.setScene(scene);
        stage.show();
        Stage previousStage = (Stage) updateFieldsAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onUpdateButttonClick() throws IOException {
        Supply details = new Supply();
        outerloop:
        while (true){
            int countNotFill = 0;
            int countInt = 0;
            details.setName(String.valueOf(name.getText()));
            if (details.getName().equals("")){
                countNotFill++;
            }
            try {
                details.setLitres(Integer.parseInt(litres.getText()));
                invalLtr.setText("");
            } catch (NumberFormatException e) {
                countInt++;
                invalLtr.setText("Invalid input");
            }
            try {
                details.setMeter(Integer.parseInt(meter.getText()));
                invalMtr.setText("");
            } catch (NumberFormatException e) {
                countInt++;
                invalMtr.setText("Invalid input");
            }
            details.setDate(String.valueOf(date.getText()));
            if (details.getName().equals("")){
                countNotFill++;
            }
            if (countNotFill>0){
                FillAllFields.setText("All fields must be filled!");
                break;
            } else {
                FillAllFields.setText("");
            }
            if (countInt>0)
                break;
            int cons=0;
            double litre =details.getLitres();
            switch (details.getMeter()){
                case 150:
                    cons=40;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 140:
                    cons=38;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 130:
                    cons=36;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 120:
                    cons=34;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 110:
                    cons=32;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 100:
                    cons=30;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 90:
                    cons=28;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 80:
                    cons=26;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 70:
                    cons=24;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 60:
                    cons=22;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                case 50:
                    cons=20;
                    details.setWeight(litre*cons/100);
                    System.out.println(details.getWeight());
                    break;
                default:
                    invalMtr.setText("Invalid meter!");
                    break outerloop;
            }
            upSupply.clear();
            upSupply.add(details.getName());
            upSupply.add(details.getLitres());
            upSupply.add(details.getMeter());
            upSupply.add(details.getWeight());
            upSupply.add(details.getDate());
            for (List<Object> i : upSupplies){
                if (i.equals(supply)){
                    upSupplies.remove(supply);
                    break;
                }
            }
            for (List<Object> i : supplies){
                if (i.equals(supply)){
                    supplies.remove(supply);
                    break;
                }
            }
            supplies.add(upSupply);
            upSupplies.add(upSupply);
            System.out.println(supplies);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateTable.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
            stage.setTitle("Results");
            stage.setScene(scene);
            stage.show();
            Stage previousStage = (Stage) updateFieldsAnchor.getScene().getWindow();
            previousStage.close();
            break;
        }
    }

    public void onBackButttonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateTable.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("Results");
        stage.setScene(scene);
        stage.show();
        Stage previousStage = (Stage) updateFieldsAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onMenuButttonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MENU.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600,  400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        Stage previousStage = (Stage) updateFieldsAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onYesButtonClick() {
        for (List<Object> i : upSupplies){
            if (i.equals(supply)){
                upSupplies.remove(supply);
                break;
            }
        }
        for (List<Object> i : supplies){
            if (i.equals(supply)){
                supplies.remove(supply);
                break;
            }
        }
        supplies.add(upSupply);
        upSupplies.add(upSupply);
        System.out.println(supplies);
        Stage previousStage = (Stage) repeatUpAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onNoButtonClick() {
        Stage previousStage = (Stage) repeatUpAnchor.getScene().getWindow();
        previousStage.close();
    }
}
