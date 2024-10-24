package com.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalcController {

    public Button oneBtn;
    public Button twoBtn;
    public Button threeBtn;
    public Button fourBtn;
    public Button fiveBtn;
    public Button sixBtn;
    public Button sevenBtn;
    public Button eightBtn;
    public Button nineBtn;
    public Button plusBtn;
    public Button minusBtn;
    public Button divBtn;
    public Button zeroBtn;
    public Button rezBtn;
    public Button multiBtn;
    public Label calcWin;
    public Button clrBtn;

    @FXML

    public void onButtonClick(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        if (calcWin.getText() != null && !calcWin.getText().equals("0")) {
            String txt = calcWin.getText();
            calcWin.setText(txt+btn.getText());
        }
        else
            calcWin.setText(btn.getText());
    }

    public void onOperationClick(ActionEvent actionEvent){
        Button btn = (Button) actionEvent.getSource();
        CalcOperations.matchOperation(calcWin, btn);
    }

    public void onRezButtonClick(ActionEvent actionEvent){
        Button btn = (Button) actionEvent.getSource();
        CalcOperations.rezOperation (calcWin,btn);
    }

    public void onClrButtonClick(ActionEvent actionEvent){
        CalcOperations.clear(calcWin);
    }

}