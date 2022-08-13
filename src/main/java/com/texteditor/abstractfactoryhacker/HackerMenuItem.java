package com.texteditor.abstractfactoryhacker;

import javafx.scene.control.MenuItem;

public class HackerMenuItem extends MenuItem {
    public HackerMenuItem(String text){
        super(text);
        this.setStyle("-fx-text-fill: red;");
    }
}
