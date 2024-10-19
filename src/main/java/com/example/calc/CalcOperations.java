package com.example.calc;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcOperations {

    public static void matchOperation(Label label, Button button){
        String regex = "[/*+\\-]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(label.getText());
        boolean matchFound = matcher.find();
        if(matchFound) {
            CalcOperations.rezOperation(label);
        } else if (label.getText() != null && !label.getText().equals("0")) {
            String txt = label.getText();
            label.setText(txt+button.getText());
        }
        else
            label.setText(button.getText());
    }

    public static void rezOperation (Label label){
        if (label.getText().contains("+")) {
            int num1 = Integer.parseInt(label.getText().substring(0, label.getText().indexOf("+")));
            int num2 = Integer.parseInt(label.getText().substring(label.getText().indexOf("+") + 1));
            int rez = num1 + num2;
            label.setText(Integer.toString(rez));
        } else if (label.getText().contains("-")) {
            int num1 = Integer.parseInt(label.getText().substring(0, label.getText().indexOf("-")));
            int num2 = Integer.parseInt(label.getText().substring(label.getText().indexOf("-") + 1));
            int rez = num1 - num2;
            label.setText(Integer.toString(rez));
        } else if (label.getText().contains("*")) {
            int num1 = Integer.parseInt(label.getText().substring(0, label.getText().indexOf("*")));
            int num2 = Integer.parseInt(label.getText().substring(label.getText().indexOf("*") + 1));
            int rez = num1 * num2;
            label.setText(Integer.toString(rez));
        } else if (label.getText().contains("/")) {
            int num1 = Integer.parseInt(label.getText().substring(0, label.getText().indexOf("/")));
            int num2 = Integer.parseInt(label.getText().substring(label.getText().indexOf("/") + 1));
            if (num2 == 0) {
                clear(label);
                return;
            }
            int rez = num1 / num2;
            label.setText(Integer.toString(rez));
        }
    }

    public static void clear (Label label){
        label.setText("0");
    }
}
