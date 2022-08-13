package com.texteditor.abstractfactorydefault;

import com.texteditor.abstractfactoryhacker.HackerTextArea;
import javafx.scene.control.TextArea;

public class DefaultTextArea extends TextArea {

    private static DefaultTextArea textArea = null;

    private DefaultTextArea(){
    }

    public static DefaultTextArea getInstance()
    {
        if (textArea == null)
            textArea = new DefaultTextArea();

        return textArea;
    }

}
