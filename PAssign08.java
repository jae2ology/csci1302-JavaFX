package keypad;


import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


// github assignment https://github.com/jae2ology/hello-world

public class PAssign08 extends Application {
    @Override // start method
    public void start(Stage primaryStage){
        // label for the numbers
        Label numberLabel = new Label("Call: ");

        // keypad for phone
        KeyPadPanePlus keypad = new KeyPadPanePlus();
        keypad.setStyle("-fx-alignment: center; fx-padding: 10;");
        
        

        // rectangle for the phone
        Rectangle rect = new Rectangle(100.0d, 100.0d, 120.0d, 150.0d);
        rect.setFill(Color.PINK);
        rect.setArcHeight(10.0d); // rounded corners with arc
        rect.setArcWidth(10.0d);

        // add a rectangle shadow for a cool 3d effect
        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(5);
        shadow.setOffsetY(5);
        shadow.setRadius(10);
        shadow.setColor(Color.rgb(0,0,0,0.3));
        rect.setEffect(shadow);

        // put the keypad on the rectangle
        StackPane phone = new StackPane(rect, keypad);
        phone.setAlignment(javafx.geometry.Pos.CENTER); // center alignment

        // make the call button
        Button callButton = new Button("Call!");


        // make call button actions
        callButton.setOnAction(e -> {
            String number = keypad.getTypedNumber();

            if (!number.isEmpty()){
                numberLabel.setText("Dialing " + number + ".........."); // dialing after pressed

                // pausing for 2 seconds to dial
                PauseTransition pause = new PauseTransition(Duration.seconds(2));
                pause.setOnFinished(event -> {
                    numberLabel.setText(number + " didn't pick up... Leave a message!");
                    keypad.clearTypedNumber();
                });
                pause.play();
            }

            else {
                numberLabel.setText("No number entered yet! Call someone!"); // if empty, says this
            }

            keypad.clearTypedNumber(); // clear after button has been pressed
        });

        // VBox for everything
        VBox root = new VBox(10, phone, numberLabel, callButton);
        root.setAlignment(javafx.geometry.Pos.CENTER);

        // set the scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Call someone!");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

