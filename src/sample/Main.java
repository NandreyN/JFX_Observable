package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.naming.Binding;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main extends Application {

    private static int WIDTH = 600;
    private static int HEIGHT = 400;

    private ObservableList<String> logList = FXCollections.observableArrayList();
    private SimpleStringProperty currentLetter = new SimpleStringProperty("");

    private Calendar calendar = new GregorianCalendar();

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox();
        ListView<String> listView = new ListView<>();
        configureListView(listView);

        TextField textField = new TextField();
        configureTextBox(textField);

        hBox.getChildren().addAll(textField, listView);

        Scene scene = new Scene(hBox, WIDTH, HEIGHT);
        setupWindowKeyListener(scene);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void configureListView(ListView<String> listView) {
        listView.setItems(logList);
        listView.setPrefHeight(HEIGHT / 5);
        listView.setPrefWidth(WIDTH);
    }

    private void configureTextBox(TextField textField) {
        textField.setPrefHeight(HEIGHT);
        textField.setPrefWidth(WIDTH);
        textField.textProperty().bind(currentLetter);
        textField.setEditable(false);
        textField.setFont(new Font(100));
        textField.setAlignment(Pos.CENTER);
    }

    private void setupWindowKeyListener(Scene scene) {
        scene.setOnKeyReleased((event) -> {
            currentLetter.setValue(event.getText());
            logList.add(LocalDateTime.now() + " , value : " + event.getText());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
