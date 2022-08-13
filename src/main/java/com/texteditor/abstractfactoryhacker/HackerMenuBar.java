package com.texteditor.abstractfactoryhacker;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class HackerMenuBar extends MenuBar {
    public HackerMenuBar(){
        this.setBackground(Background.fill(Color.web("0x20C20E", 1.0 )));
    }
}
