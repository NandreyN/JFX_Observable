package sample;

import java.util.Observable;

public class CustomObservableString extends Observable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();
        this.notifyObservers(content);
        //this.notifyObservers();
    }
}
