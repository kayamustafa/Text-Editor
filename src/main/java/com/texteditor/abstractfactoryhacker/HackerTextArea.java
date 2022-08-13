package com.texteditor.abstractfactoryhacker;

import javafx.scene.control.TextArea;

public class HackerTextArea extends TextArea {
    private static HackerTextArea textArea = null;

    private HackerTextArea(){
        this.setStyle("-fx-text-fill: yellowgreen; -fx-control-inner-background:#000000;");
    }

    public static HackerTextArea getInstance()
    {
        if (textArea == null)
            textArea = new HackerTextArea();

        return textArea;
    }
}
