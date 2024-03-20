package com.example.heshan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewItems implements Initializable {
    public AnchorPane viewItemsAnchor;
    @FXML
    private TableView<Supply> tableview;
    @FXML
    private TableColumn<Supply, String> date;

    @FXML
    private TableColumn<Supply, Integer> litre;

    @FXML
    private TableColumn<Supply, Integer> meter;

    @FXML
    private TableColumn<Supply, String> name;

    @FXML
    private TableColumn<Supply, Double> weight;
    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewOptions.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600.0,  400.0);
        stage.setTitle("View items");
        stage.setScene(scene);
        stage.show();

        Stage previousStage = (Stage) viewItemsAnchor.getScene().getWindow();
        previousStage.close();

    }

    public void onMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MENU.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 600,  400);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();
        Stage previousStage = (Stage) viewItemsAnchor.getScene().getWindow();
        previousStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Supply,String>("name"));
        litre.setCellValueFactory(new PropertyValueFactory<Supply,Integer>("litres"));
        meter.setCellValueFactory(new PropertyValueFactory<Supply,Integer>("meter"));
        weight.setCellValueFactory(new PropertyValueFactory<Supply,Double>("weight"));
        date.setCellValueFactory(new PropertyValueFactory<Supply,String>("date"));
        ObservableList<Supply> selSupplies = FXCollections.observableArrayList();
        List<List<Object>> supplyView = ViewOptions.supplyView;
        for (List<Object> i : supplyView) {
            Supply newSupply = new Supply(
                    (String) i.get(0),
                    (Integer) i.get(1),
                    (Integer) i.get(2),
                    (Double) i.get(3),
                    (String) i.get(4)
            );
            selSupplies.add(newSupply);
        }
        tableview.setItems(selSupplies);
    }
}
