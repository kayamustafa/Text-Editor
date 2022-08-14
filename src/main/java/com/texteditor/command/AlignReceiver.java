package com.texteditor.command;

import com.texteditor.main.TextEditor;
import javafx.scene.control.TextArea;

public class AlignReceiver {
    TextArea textArea = TextEditor.getTextArea();
    public void alignLeft(){
        textArea.setId("left-area");
    }
    public void alignCenter(){
        textArea.setId("center-area");

    }
    public void alignRight(){
        textArea.setId("right-area");

    }
}
