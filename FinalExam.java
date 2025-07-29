package keypad;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FinalExam extends Application{
    Button btnCompute = new Button();
    TextField txtNum1 = new TextField();
    TextField txtNum2 = new TextField();
    TextField txtResult = new TextField();

    btnCompute.setOnAction(event -> {
        
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());

            double product = num1 * num2;

            txtResult.setText(product);
    });
}