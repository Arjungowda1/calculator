package com.math.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloController{

    @FXML private Pane titlePanel;
    @FXML private ImageView btnMinimize, btnClose;
    @FXML private Label result;

    private double x,y;
    private double num1 = 0;
    private String operator = "+";

    public void init(Stage stage){
        titlePanel.setOnMousePressed(clickEvent ->{
            x = clickEvent.getSceneX();
            y = clickEvent.getSceneY();
        });
        titlePanel.setOnMouseDragged(dragEvent ->{
            stage.setX(dragEvent.getScreenX()-x);
            stage.setY(dragEvent.getScreenY()-y);
        });
        btnClose.setOnMouseClicked(click->stage.close());
        btnMinimize.setOnMouseClicked(click->stage.setIconified(true));
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("btn",""));
        result.setText(Double.parseDouble(result.getText()) == 0 ? String.valueOf((double) value) : String.valueOf(Double.parseDouble(result.getText())*10 + value));
    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        if(symbol.equals("Equals")) {
            double num2 = Double.parseDouble(result.getText());
            switch (operator) {
                case "+" : result.setText((num1 + num2) + "");break;
                case "-" : result.setText((num1-num2) + ""); break;
                case "*" : result.setText((num1*num2) + ""); break;
                case "/" : result.setText((num1/num2) + ""); break;
            }
            operator = ".";
        }
        else if(symbol.equals("Clear")) {
            result.setText(String.valueOf(0.0));
            operator = ".";
        }
        else {
            switch (symbol) {
                case "Add" : operator = "+";break;
                case "Subtract" : operator = "-";break;
                case "Multiply" : operator = "*";break;
                case "Divide" : operator = "/";break;
            }
            num1 = Double.parseDouble(result.getText());
            result.setText(String.valueOf(0.0));
        }
    }
}