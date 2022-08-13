package com.texteditor.abstractfactoryhacker;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HackerMenu extends Menu {
    public HackerMenu(String text){
        Label l = new Label(text);
        Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 12);
        l.setFont(font);
        l.setStyle("-fx-text-fill: firebrick;");
        this.setGraphic(l);
    }
}
