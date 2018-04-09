package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Main Laba _ 1 variant _ 6
 * @author Sokolovskiy Alexander 650502
 * @version 1.0
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER_LEFT);
        TextField textField= new TextField();
        Button lowButton = new Button("Генерировать меньше");
        Button higButton = new Button("Генерировать больше");

        Label labelForLowNum = new Label();
        Label labelForHigNum = new Label();
        labelForHigNum.setPrefWidth(50);
        labelForLowNum.setPrefWidth(50);

        primaryStage.setTitle("LR_1 variant_6");

        root.add(textField,1,0);
        root.add(lowButton,1,2);
        root.add(higButton,1,1);
        root.add(labelForHigNum,2,1);
        root.add(labelForLowNum,2,2);

        root.setVgap(10);
        root.setHgap(10);

        lowButton.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String stringWithNumber = textField.getText();
                try{
                if(!stringWithNumber.isEmpty()) {
                    int number = Integer.parseInt(stringWithNumber);
                    int lowNumber = number - (int) (Math.random() * Math.abs(number));
                    if (number == lowNumber) {
                        lowNumber--;
                    }
                    labelForLowNum.setText(Integer.toString(lowNumber));
                }}catch (Exception e){
                    System.out.println(e);}
            }
        });
        higButton.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String stringWithNumber = textField.getText();
                try{
                if(!stringWithNumber.isEmpty()) {
                    int number = Integer.parseInt(stringWithNumber);
                    int higNumber = number + (int) (Math.random() * Math.abs(number));
                    if (number == higNumber) {
                        higNumber++;
                    }
                    labelForHigNum.setText(Integer.toString(higNumber));
                }}catch (Exception e){
                    System.out.println(e);}
            }
        });

        primaryStage.setScene(new Scene(root, 200, 120));
        primaryStage.show();

        primaryStage.setWidth(lowButton.getWidth()+labelForLowNum.getPrefWidth()+root.getHgap()*4);
        primaryStage.setMinHeight(lowButton.getHeight()*2+root.getHgap()*3+textField.getHeight());
        root.getColumnConstraints().addAll(
                new ColumnConstraints(root.getHgap()),
                new ColumnConstraints(lowButton.getWidth()),
                new ColumnConstraints(labelForLowNum.getWidth()));
        primaryStage.setResizable(false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
