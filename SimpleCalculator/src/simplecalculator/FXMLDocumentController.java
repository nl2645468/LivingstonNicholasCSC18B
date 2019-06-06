/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author freez
 */
public class FXMLDocumentController implements Initializable {
    
    //FXML Items
    @FXML
    private Button clearBttn;
    @FXML
    private Button signBttn;
    @FXML
    private Button percentBttn;
    @FXML
    private Button divBttn;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button multBttn;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button subBttn;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button addBttn;
    @FXML
    private Button zero;
    @FXML
    private Button decimalPnt;
    @FXML
    private Button equalBttn;
    @FXML
    private MenuItem aboutPress;
    @FXML
    private TextField display;
    @FXML
    private AnchorPane anchor; 
    
    //class variables
    double temp, result; 
    String currentNum = "",
            formula;
    Operation currentOp;
    boolean opPressed; 
    @FXML
    private MenuItem binaryMI;
    @FXML
    private MenuItem hexMI;
    @FXML
    private MenuItem formulaMI;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        anchor.setOnKeyPressed((KeyEvent ev) -> {   //listerner for all relevant keys
            switch(ev.getCode()){
                case DIGIT0:
                    zero.fire();
                    break; 
                case DIGIT1:
                    one.fire();
                    break;
                case DIGIT2:
                    two.fire();
                    break;
                case DIGIT3:
                    three.fire();
                    break;
                case DIGIT4:
                    four.fire();
                    break;
                case DIGIT5:
                    five.fire();
                    break;
                case DIGIT6:
                    six.fire();
                    break;
                case DIGIT7:
                    seven.fire(); 
                    break;
                case DIGIT8:
                    eight.fire();
                    break;
                case DIGIT9:
                    nine.fire();
                    break;
                case EQUALS:
                case ENTER:
                    equalBttn.fire();
                    break;
                case MINUS:
                    subBttn.fire();
                    break;
                case PLUS:
                    addBttn.fire();
                    break;
                case SLASH:
                    divBttn.fire();
                    break;
                case ASTERISK:
                    multBttn.fire();
                    break;
                case PERIOD:
                    decimalPnt.fire();
                    break;
            }
        });
    }

    //NUMBER BUTTONS
    @FXML
    private void press7(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '7';
        updateDisplay(currentNum);
    }

    @FXML
    private void press8(ActionEvent event){
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '8';
        updateDisplay(currentNum);
    }

    @FXML
    private void press9(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '9';
        updateDisplay(currentNum);
    }


    @FXML
    private void press4(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '4';
        updateDisplay(currentNum);
    }

    @FXML
    private void press5(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '5';
        updateDisplay(currentNum);
    }

    @FXML
    private void press6(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '6';
        updateDisplay(currentNum);
    }

   
    @FXML
    private void press1(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '1';
        updateDisplay(currentNum);
    }

    @FXML
    private void press2(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '2';
        updateDisplay(currentNum);
    }

    @FXML
    private void press3(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '3';
        updateDisplay(currentNum);
    }

    

    @FXML
    private void press0(ActionEvent event) {
        if(opPressed){
            currentNum = "";
            opPressed = false;
        }
        currentNum += '0';
        updateDisplay(currentNum);
    }
    
    
    //OPERATIONAL BUTTONS
    
    //Clear calculator
    @FXML
    private void clearPress(ActionEvent event) {
        currentNum = "";
        updateDisplay(currentNum);
        temp = 0; 
        result = 0; 
    }

    
    
    //alternate sign button
    @FXML
    private void signPress(ActionEvent event) {
        if(getNum() == 0)
            return; 
        try{
        currentNum = Double.toString(getNum() * -1);
        updateDisplay(currentNum);
        }catch(NumberFormatException e){
            numberError();
        }
    }

    //create percent out of number
    @FXML
    private void percentPress(ActionEvent event) {
        try{
            currentNum = Double.toString(getNum() * .01);
            updateDisplay(currentNum);
        }catch(NumberFormatException e){
            numberError();
        }
    }

    
    //period button
    @FXML
    private void decPress(ActionEvent event) {
        if(display.getText().trim().isEmpty()){
            currentNum = "0.";
            updateDisplay(currentNum);
        }
        else{
            currentNum += ".";
            updateDisplay(currentNum);
        }
    }
    
    
    //MATH BUTTONS
    
    
    //MULTIPLY
    @FXML
    private void multPress(ActionEvent event) {
        currentOp = Operation.MUL;
        opCheck();
    }
    
    //DIVIDE
    @FXML
    private void divPress(ActionEvent event) {
        currentOp = Operation.DIV;
        opCheck();
    }
    
    //SUBTRACT
    @FXML
    private void subPress(ActionEvent event) {
        currentOp = Operation.SUB;
        opCheck(); 
    }
    
    //ADD
    @FXML
    private void addPress(ActionEvent event) {
        currentOp = Operation.ADD;
        opCheck();
    }
    
    //EQUALS
    @FXML
    private void equalPress(ActionEvent event) {
        try{
            result = currentOp.math(temp, getNum());
            currentNum = "";
            temp = 0;
            updateDisplay(result);
        }
        catch(NumberFormatException e){
            numberError();
        }
    }
    
    
    //INTERNAL FUNCTIONS
    
    //checks if it's currently in an operation state
    private void opCheck(){
        if(!opPressed){
            opPressed = true;
            temp = getNum();
        }
        else{
            opPressed = false; 
            equalBttn.fire();
        }
    }
    
    //complete a math operations
    private void completeOp(Operation _op){
        try{
            result = currentOp.math(result, getNum());
            currentNum = "";
            temp = 0;
            updateDisplay(result);
        }catch(NumberFormatException e){
            numberError();
        }
    }
    
    //get the current number from the display
    private double getNum(){
        return Double.parseDouble(display.getText());
    }

    //OVERLOADED update display using string
    public void updateDisplay(String _num){
        display.setText(_num);
    }
    
    //OVERLOADED UPDATE DISPLAY USING DOUBLE
    private void updateDisplay(Double _num){
        updateDisplay(Double.toString(_num));
    }
    
    //function to call if a number occurs, resets the calculator and present an error
    private void numberError(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Error parsing number input, calculator has been reset.");
        alert.showAndWait();
        currentNum = "";
        updateDisplay(currentNum);
        temp = 0; 
        result = 0;
    }

    @FXML
    private void binPressed(ActionEvent event) {
        if(display.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nothing to convert.");
            alert.showAndWait();
            return; 
        }
        currentNum = "";
        temp = 0; 
        result = 0; 
        opPressed = true;
        int bin = (int)getNum();
        TextField text = new TextField(Integer.toBinaryString(bin));
        Stage stage = new Stage();
        stage.setTitle("Binary Value");
        stage.setScene(new Scene(text, 250, 25));
        text.setEditable(false);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void hexPressed(ActionEvent event) {
        if(display.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nothing to convert.");
            alert.showAndWait();
            return; 
        }
        currentNum = "";
        temp = 0; 
        result = 0; 
        opPressed = true;
        TextField text = new TextField(Double.toHexString(getNum()));
        Stage stage = new Stage();
        stage.setTitle("Hexedecimal Value");
        stage.setScene(new Scene(text, 250, 25));
        text.setEditable(false);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void formulaPressed(ActionEvent event) {
        
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/simplecalculator/FormulaInputFXML.fxml"));
            Stage formStage = new Stage(); 
            Parent root1 = (Parent) fxmlLoader.load();
            formStage.setTitle("Formula Input");
            formStage.setScene(new Scene(root1));
            formStage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void returnFormula(String _formula) {
       this.formula = _formula;
        updateDisplay(this.formula);
    }
}
