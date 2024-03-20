package com.example.heshan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BillView implements Initializable {
    @FXML
    private TableView<Supply> billView;

    @FXML
    private TableColumn<Supply, String> dateBill;

    @FXML
    private TableColumn<Supply, Integer> litres;

    @FXML
    private TableColumn<Supply, Integer> meter;
    @FXML
    private TableColumn<Supply, Double> weight;
    public AnchorPane billViewAnchor;
    public Label name;
    public Label totalkg;
    public Label unitPrice;
    public Label totalRs;
    public Label advance;
    public Label payable;
    List<List<Object>> billSupplies = BillDetails.billSupplies;
    List<Integer> intInputs = BillDetails.intInputs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText((String) billSupplies.get(0).get(0));
        dateBill.setCellValueFactory(new PropertyValueFactory<Supply,String>("date"));
        litres.setCellValueFactory(new PropertyValueFactory<Supply,Integer>("litres"));
        meter.setCellValueFactory(new PropertyValueFactory<Supply,Integer>("meter"));
        weight.setCellValueFactory(new PropertyValueFactory<Supply,Double>("weight"));
        ObservableList<Supply> selSupplies = FXCollections.observableArrayList();
        for (List<Object> i : billSupplies) {
            Supply newSupply = new Supply(
                    (String) i.get(4),
                    (Integer) i.get(1),
                    (Integer) i.get(2),
                    (Double) i.get(3)
            );
            selSupplies.add(newSupply);
        }
        billView.setItems(selSupplies);

        Double kgTotal =0.0;
        for (List<Object> i : billSupplies){
            kgTotal = Double.sum(kgTotal, (Double) i.get(3));
        }
        String formattedKGTotal = String.format("%.2f", kgTotal);
        totalkg.setText(formattedKGTotal);

        unitPrice.setText(String.valueOf(intInputs.get(0)));

        Double rsTotal = kgTotal*intInputs.get(0);
        String formattedTotal = String.format("%.2f", rsTotal);
        totalRs.setText(formattedTotal);

        advance.setText("("+String.valueOf(intInputs.get(1))+")");

        rsTotal = rsTotal-intInputs.get(1);
        String formattedTotal1 = String.format("%.2f", rsTotal);
        payable.setText(formattedTotal1);
    }
}
