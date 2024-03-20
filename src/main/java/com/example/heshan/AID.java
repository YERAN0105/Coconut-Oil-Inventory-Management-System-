package com.example.heshan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AID {
    public TextField name;
    public TextField litres;
    public TextField meter;
    public DatePicker date;
    public Label invalLtr;
    public Label invalMtr;
    public Label FillAllFields;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public AnchorPane aidAnchor;
    public AnchorPane repeatAnchor;
    List<List<Object>> supplies = HelloApplication.supplies;
    public static List<Integer> repeat = new ArrayList<>();

    public void onAddSupplyButtonClick() throws IOException {

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
            details.setDate(String.valueOf(date.getValue()));
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
            List<Object> supply = new ArrayList<>();
            supply.add(details.getName());
            supply.add(details.getLitres());
            supply.add(details.getMeter());
            supply.add(details.getWeight());
            supply.add(details.getDate());
//            for (List<Object> i : supplies){
//                if (i.equals(supply)){
//                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Repeat.fxml"));
//                    Stage stage = new Stage();
//                    Scene scene = new Scene(fxmlLoader.load(), 490.0,  273.0);
//                    stage.setTitle("Confirm!");
//                    stage.setScene(scene);
//                    stage.show();
//                    return;
//                }
//            }
            supplies.add(supply);
            FillAllFields.setText("Item added Successfully!");
            break;
        }
    }
    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MENU.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600,  400);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();
        Stage previousStage = (Stage) aidAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onYesButtonClick() throws IOException{
//        supplies.add(supply);
        FillAllFields.setText("Item added Successfully!");
        Stage previousStage = (Stage) repeatAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onNoButtonClick() {
        Stage previousStage = (Stage) repeatAnchor.getScene().getWindow();
        previousStage.close();
    }
}
