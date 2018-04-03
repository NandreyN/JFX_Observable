package sample;

import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Observable;
import java.util.Observer;

public class CustomObservableListView extends ListView<String> implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        this.getItems().add(LocalDateTime.now() + " , val = " + arg.toString());
    }
}
