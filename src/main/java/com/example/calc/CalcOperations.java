package com.example.calc;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CalcOperations {

    public static void matchOperation(Label label, Button button){
        String regex = "[/*+\\-]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(label.getText());
        boolean matchFound = matcher.find();
        if(matchFound) {
            rezOperation(label,button);
        } else if (label.getText() != null && !label.getText().equals("0")) {
            String txt = label.getText();
            label.setText(txt+button.getText());
        }
        else if(!button.getText().equals("+") || !button.getText().equals("-") || !button.getText().equals("*") || !button.getText().equals("/"))
            label.setText(button.getText());
    }

    public static void rezOperation (Label label, Button button){
        double rez;
        if (label.getText().contains("+")) {
            String str1 = label.getText().substring(0, label.getText().indexOf("+"));
            String str2 = label.getText().substring(label.getText().indexOf("+") + 1);
            if (!str2.isEmpty()) {
                double num1 = Double.parseDouble(str1);
                double num2 = Double.parseDouble(str2);
                rez = num1 + num2;
            }
            else return;
            addSymbol(button, label, rez);
        } else if (label.getText().contains("-")) {
            String str1 = label.getText().substring(0, label.getText().indexOf("-"));
            String str2 = label.getText().substring(label.getText().indexOf("-") + 1);
            if (!str2.isEmpty()) {
                double num1 = Double.parseDouble(str1);
                double num2 = Double.parseDouble(str2);
                rez = num1 - num2;
            }
            else return;
            addSymbol(button, label, rez);
        } else if (label.getText().contains("*")) {
            String str1 = label.getText().substring(0, label.getText().indexOf("*"));
            String str2 = label.getText().substring(label.getText().indexOf("*") + 1);
            if (!str2.isEmpty()) {
                double num1 = Double.parseDouble(str1);
                double num2 = Double.parseDouble(str2);
                rez = num1 * num2;
            }
            else return;
            addSymbol(button, label, rez);
        } else if (label.getText().contains("/")) {
            String str1 = label.getText().substring(0, label.getText().indexOf("/"));
            String str2 = label.getText().substring(label.getText().indexOf("/") + 1);
            if (!str2.isEmpty()) {
                double num1 = Double.parseDouble(str1);
                double num2 = Double.parseDouble(str2);
                if (num2 == 0) {
                    clear(label);
                    return;
                }
                rez = num1 / num2;
            }
            else return;
            addSymbol(button, label, rez);
        }
    }

    public static void clear (Label label){
        label.setText("0");
    }

    protected static void addSymbol (Button button, Label label, double rezult){
        if (button.getText().equals("+") || button.getText().equals("-") || button.getText().equals("*") || button.getText().equals("/")){
            String txt = button.getText();
            label.setText(rezult+txt);
        }
        else label.setText(Double.toString(rezult));
    }
}
