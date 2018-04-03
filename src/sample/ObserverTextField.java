package sample;

import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ObserverTextField extends TextField implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null)
            this.setText(arg.toString());
    }
}
