package com.example.heshan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateTable implements Initializable {

    public Label invalidInput;
    public AnchorPane updateTableAnchor;
    public TextField num;
    @FXML
    private Label upDate;

    @FXML
    private TableColumn<Supply, Integer> upLitres;

    @FXML
    private TableColumn<Supply, Integer> upMeter;

    @FXML
    private Label upName;

    @FXML
    private TableColumn<Supply, Integer> upNumber;
    @FXML
    private TableColumn<Supply, String> Date;

    @FXML
    private TableColumn<Supply, Double> upWeight;

    @FXML
    private TableView<Supply> updateTableView;
    public int count =1;
    public static List<Object> chosenSupply = new ArrayList<>();
    List<List<Object>> upSupplies = Update.upSupplies;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        upNumber.setCellValueFactory(new PropertyValueFactory<Supply,Integer>("upNumber"));
        upLitres.setCellValueFactory(new PropertyValueFactory<Supply,Integer>("litres"));
        upMeter.setCellValueFactory(new PropertyValueFactory<Supply,Integer>("meter"));
        upWeight.setCellValueFactory(new PropertyValueFactory<Supply,Double>("weight"));
        Date.setCellValueFactory(new PropertyValueFactory<Supply,String>("date"));
        upName.setText(upSupplies.get(0).get(0).toString());
        upDate.setText(upSupplies.get(0).get(4).toString().substring(0,7));
        ObservableList<Supply> selSupplies = FXCollections.observableArrayList();
        for (List<Object> i : upSupplies){
            Supply newSupply = new Supply(
                    count,
                    (Integer) i.get(1),
                    (Integer) i.get(2),
                    (Double) i.get(3),
                    (String) i.get(4)
            );
            selSupplies.add(newSupply);
            count++;
        }
        updateTableView.setItems(selSupplies);
    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateName.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 487.0,  296.0);
        stage.setTitle("Add items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) updateTableAnchor.getScene().getWindow();
        previousStage.close();
    }

    public void onNextButtonClick()throws IOException {
        Supply instance = new Supply();
        try {
            instance.setUpNumber(Integer.parseInt(num.getText()));

        } catch (NumberFormatException e) {
            invalidInput.setText("Invalid Input");
            return;
        }

        if (instance.getUpNumber()==0 || instance.getUpNumber()>=count){
            invalidInput.setText("Invalid Input");
        } else {
            invalidInput.setText(" ");
            chosenSupply = upSupplies.get(instance.getUpNumber()-1);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UpdateFields.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
            stage.setTitle("Add items");
            stage.setScene(scene);
            stage.show();

            Stage previousStage = (Stage) updateTableAnchor.getScene().getWindow();
            previousStage.close();
        }
    }
}
