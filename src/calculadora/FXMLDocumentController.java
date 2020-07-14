/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.runtime.ParserException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class FXMLDocumentController {

    @FXML
    private Button buttonOperationsResult;
    @FXML
    private Button buttonOperationsAddition;
    @FXML
    private Button buttonOperationsANS;
    @FXML
    private Button buttonOperationsProduct;
    @FXML
    private Button buttonOperationsPoint;
    @FXML
    private Button buttonOperationsClean;
    @FXML
    private Button buttonOperationsSubstraction;
    @FXML
    private Button buttonOperations4;
    @FXML
    private Button buttonOperations5;
    @FXML
    private Button buttonOperations2;
    @FXML
    private Button buttonOperations3;
    @FXML
    private Button buttonOperations0;
    @FXML
    private Button buttonOperations1;
    @FXML
    private Button buttonOperationsDivide;
    @FXML
    private Button buttonOperationsPercentage;
    @FXML
    private Button buttonOperationsDelete;
    @FXML
    private Button buttonOperations8;
    @FXML
    private Button buttonOperations9;
    @FXML
    private Button buttonOperations6;
    @FXML
    private TextField textfieldResult;
    @FXML
    private Button buttonOperations7;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Pane panelBackgroud;
    @FXML
    private Pane paneOperations;
    @FXML
    private Tab tabOperations;
    @FXML
    private TextArea textareaHistory;

    private Boolean operationOn = true;
    private double lastOperation = 0;

    public void cleanScreen() {
        textfieldResult.setText("");
        operationOn = true;
    }

    public void deleteValue() {
        if (!(textfieldResult.getText().length() == 0)) {
            textfieldResult.setText(textfieldResult.getText().substring(0, textfieldResult.getText().length() - 1));
        }
    }

    public void getLastResult() {
        if (!(lastOperation == 0)) {
            textfieldResult.setText(textfieldResult.getText() + lastOperation);
        }
    }

    public void addValue(javafx.event.ActionEvent actionEvent) {
        textfieldResult.setText(textfieldResult.getText() + ((Button) actionEvent.getSource()).getText());
        operationOn = true;
    }

    public void addOperation(javafx.event.ActionEvent actionEvent) {
        if (operationOn) {
            textfieldResult.setText(textfieldResult.getText() + ((Button) actionEvent.getSource()).getText());
            operationOn = false;
        }
    }

    public void makeOperation() {
        String operationS = textfieldResult.getText();

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            Object operation = engine.eval(textfieldResult.getText().replaceAll("x", "*"));
            textfieldResult.setText("" + operation);
            textareaHistory.setText(operationS + " = " + textfieldResult.getText() + "\n" + textareaHistory.getText());
            lastOperation = Double.parseDouble(textfieldResult.getText());
        } catch (ScriptException | ParserException e) {
            textfieldResult.setText("");
        }
    }

    @FXML
    private void changeColor(ActionEvent event) {
        String n = colorPicker.getValue().toString().substring(2, colorPicker.getValue().toString().length() - 2);
        paneOperations.setStyle("-fx-background-color: #" + n);
        panelBackgroud.setStyle("-fx-background-color: #" + n);
        tabOperations.setStyle("-fx-background-color: #" + n);
    }

    @FXML
    private void IG_javier_eyeless() {

    }
}