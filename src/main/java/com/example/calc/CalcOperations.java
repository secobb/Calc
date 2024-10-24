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
            CalcOperations.rezOperation(label,button);
        } else if (label.getText() != null && !label.getText().equals("0")) {
            String txt = label.getText();
            label.setText(txt+button.getText());
        }
        else if(!button.getText().equals("+") || !button.getText().equals("-") || !button.getText().equals("*") || !button.getText().equals("/"))
            label.setText(button.getText());
    }

    public static void rezOperation (Label label, Button button){
        int rez = 0;
        if (label.getText().contains("+")) {
            String str1 = label.getText().substring(0, label.getText().indexOf("+"));
            String str2 = label.getText().substring(label.getText().indexOf("+") + 1);
            if (!str2.isEmpty()) {
                int num1 = Integer.parseInt(str1);
                int num2 = Integer.parseInt(str2);
                rez = num1 + num2;
            }
            else return;
            if (button.getText().equals("+")){
                label.setText(rez+"+");
            }
            else label.setText(Integer.toString(rez));
        } else if (label.getText().contains("-")) {
            String str1 = label.getText().substring(0, label.getText().indexOf("-"));
            String str2 = label.getText().substring(label.getText().indexOf("-") + 1);
            if (!str2.isEmpty()) {
                int num1 = Integer.parseInt(str1);
                int num2 = Integer.parseInt(str2);
                rez = num1 - num2;
            }
            else return;
            if (button.getText().equals("-")){
                label.setText(rez+"-");
            }
            else label.setText(Integer.toString(rez));
        } else if (label.getText().contains("*")) {
            String str1 = label.getText().substring(0, label.getText().indexOf("*"));
            String str2 = label.getText().substring(label.getText().indexOf("*") + 1);
            if (!str2.isEmpty()) {
                int num1 = Integer.parseInt(str1);
                int num2 = Integer.parseInt(str2);
                rez = num1 * num2;
            }
            else return;
            if (button.getText().equals("*")){
                label.setText(rez+"*");
            } else label.setText(Integer.toString(rez));
        } else if (label.getText().contains("/")) {
            String str1 = label.getText().substring(0, label.getText().indexOf("/"));
            String str2 = label.getText().substring(label.getText().indexOf("/") + 1);
            if (!str2.isEmpty()) {
                int num1 = Integer.parseInt(str1);
                int num2 = Integer.parseInt(str2);
                if (num2 == 0) {
                    clear(label);
                    return;
                }
                rez = num1 / num2;
            }
            else return;
            if (button.getText().equals("/")){
                label.setText(rez+"/");
            } else label.setText(Integer.toString(rez));
        }
    }

    public static void clear (Label label){
        label.setText("0");
    }
}
