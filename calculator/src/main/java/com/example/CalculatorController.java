package com.example;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Group Name: GUI-yomi
 * Group Members: 
 *      BARCE, John Bernard
 *      CORPUZ, Ralph Christian
 *      DELA CRUZ, Sofia Cloie
 *      MORALES, Rayleen Claire
 *      NASE, Louiese Gabrielle
 *      RESPECIO, Luis Arnold
 *      VINUYA, Cyril Troy
 *      
 * Course/Section: CSS124L - BM1
 */

public class CalculatorController {

    @FXML Label calcDisplay;
    @FXML Button calcPad1;
    @FXML Button calcPad2;
    @FXML Button calcPad3;
    @FXML Button calcPad4;
    @FXML Button calcPad5;
    @FXML Button calcPad6;
    @FXML Button calcPad7;
    @FXML Button calcPad8;
    @FXML Button calcPad9;
    @FXML Button calcPad0;
    @FXML Button calcPadAdd;
    @FXML Button calcPadMinus;
    @FXML Button calcPadMultiply;
    @FXML Button calcPadDivide;
    @FXML Button calcPadDot;
    @FXML Button calcPadEquals;
    @FXML Button calcPadClear;
    @FXML Button calcPadNegative;
    @FXML Button calcPadDelete;
    @FXML Button calcPadCE;

    //Declarables
    private double previousValue = 0;
    private String operator = "";
    int count = 0;
    private boolean isNewInput = true;

    //Number Handlers
    @FXML private void handleCalcPad1() {handleNumInput("1");}
    @FXML private void handleCalcPad2() {handleNumInput("2");}
    @FXML private void handleCalcPad3() {handleNumInput("3");}
    @FXML private void handleCalcPad4() {handleNumInput("4");}
    @FXML private void handleCalcPad5() {handleNumInput("5");}
    @FXML private void handleCalcPad6() {handleNumInput("6");}
    @FXML private void handleCalcPad7() {handleNumInput("7");}
    @FXML private void handleCalcPad8() {handleNumInput("8");}
    @FXML private void handleCalcPad9() {handleNumInput("9");}
    @FXML private void handleCalcPad0() {handleNumInput("0");}

    //Handles number inputs
    private void handleNumInput (String number) {
        if(isNewInput) {
            calcDisplay.setText(number);
            isNewInput = false;
        } else {
            calcDisplay.setText(calcDisplay.getText() + number);
        }
    }

    //Arithmetic operation handlers
    @FXML private void handleCalcPadAdd() {processOp("+");}
    @FXML private void handleCalcPadMinus() {processOp("-");}
    @FXML private void handleCalcPadMultiply() {processOp("*");}
    @FXML private void handleCalcPadDivide() {processOp("/");}

    //Handles arithmetic operations
    private void processOp(String newOp) {
        count++;

        if (count > 1) {
            double currentValue = Double.parseDouble(calcDisplay.getText());
            performPendingOp(currentValue);

        }

        operator = newOp;
        previousValue = Double.parseDouble(calcDisplay.getText());
        isNewInput = true;
    }

    //Handles continuous arithmetic operations
    private void performPendingOp(double currentValue) {
        switch(operator) {
            case "+":
                previousValue += currentValue;
                break;
            case "-":
                previousValue -= currentValue;
                break;
            case "*":
                previousValue *= currentValue;
                break;
            case "/":
                if(currentValue != 0) {
                    previousValue /= currentValue;
                } else {
                    calcDisplay.setText("Error");
                    return;
                }
                break;            
        }

        calcDisplay.setText(String.valueOf(previousValue));
    }

    @FXML
    private void handleCalcPadDot() {
        calcDisplay.setText("handleCalcPadDot");
    }

    @FXML
    private void handleCalcPadEquals() {
        if (!isNewInput) {
            double currentValue = Double.parseDouble(calcDisplay.getText());
            performPendingOp(currentValue);
            operator = "";
            isNewInput = true;
            count = 0;
        }
    }

    @FXML
    private void handleCalcPadClear() {
        calcDisplay.setText("handleCalcPadClear");
        count = 0;
    }

    @FXML
    private void handleCalcPadNegative() {
        calcDisplay.setText("handleCalcPadNegative");
    }

    @FXML
    private void handleCalcPadDelete() {
        calcDisplay.setText("handleCalcPadDelete");
    }

    @FXML
    private void handleCalcPadCE() {
        calcDisplay.setText("handleCalcPadCE");
    }
}