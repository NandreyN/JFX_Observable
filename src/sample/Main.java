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
import javafx.scene.input.KeyCode;
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
    private ObserverTextField obsTextField;
    private CustomObservableString obsString = new CustomObservableString();
    private CustomObservableListView obsListView = new CustomObservableListView();

    @Override
    public void start(Stage primaryStage) throws Exception {
        obsString.setContent("");

        HBox hBox = new HBox();
        obsListView = new CustomObservableListView();
        configureListView();

        obsTextField = new ObserverTextField();
        configureTextBox();

        hBox.getChildren().addAll(obsTextField, obsListView);

        Scene scene = new Scene(hBox, WIDTH, HEIGHT);
        setupWindowKeyListener(scene);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void configureListView() {
        obsListView.setPrefHeight(HEIGHT / 5);
        obsListView.setPrefWidth(WIDTH);
        obsString.addObserver(obsListView);
    }

    private void configureTextBox() {
        obsTextField.setPrefHeight(HEIGHT);
        obsTextField.setPrefWidth(WIDTH);

        obsString.addObserver(obsTextField);

        obsTextField.setEditable(false);
        obsTextField.setFont(new Font(100));
        obsTextField.setAlignment(Pos.CENTER);
    }

    private void setupWindowKeyListener(Scene scene) {
        scene.setOnKeyReleased((event) -> {
            KeyCode keycode = event.getCode();
            if (keycode.isLetterKey() || keycode.isDigitKey()) {
                String msg = (event.isShiftDown()) ? event.getText().toUpperCase() : event.getText().toLowerCase();

                obsString.setContent(msg);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
