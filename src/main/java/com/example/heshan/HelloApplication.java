package com.example.heshan;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class HelloApplication extends Application {
    public static List<List<Object>> supplies = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MENU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("Supplies.txt"));
            String line = null;
            int lineNum = 0;
            while ((line = in.readLine()) != null) { //reading the text file line by line
                lineNum++;
                line = line.replace("[", "");
                line = line.replace("]", "");
                line = line.replace(" ", "");
                String[] arrOfStr = line.split(",", 8);
                if (arrOfStr.length == 5) {
                    List<Object> item = new ArrayList<>();
                    item.add(arrOfStr[0]);
                    item.add(arrOfStr[1]);
                    item.add(arrOfStr[2]);
                    item.add(arrOfStr[3]);
                    item.add(arrOfStr[4]);
                    supplies.add(item);
                } else {
                    System.out.println("Error in text file! Line number: " + lineNum);
                }
            }
            for (List<Object> i: supplies){ //converting the data in the main list to their required data type
                i.set(1, Integer.valueOf((String) i.get(1)));
                i.set(2, Integer.valueOf((String) i.get(2)));
                i.set(3, Double.valueOf((String) i.get(3)));
            }
            System.out.println(supplies);
        }catch (IOException e){
            e.printStackTrace();
        }
        launch();
    }
}