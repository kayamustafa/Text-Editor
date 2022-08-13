package com.texteditor.abstractfactoryhacker;

import com.texteditor.main.TextEditorFactory;
import javafx.scene.Parent;

public class HackerTextEditorFactory implements TextEditorFactory {
    public HackerMenuBar makeMenuBar() {
        return new HackerMenuBar();
    }


    public HackerMenu makeMenu(String name) {
        return new HackerMenu(name);
    }


    public HackerMenuItem makeMenuItem(String name) {
        return new HackerMenuItem(name);
    }


    public HackerScene makeScene(Parent parent, int w, int h) {
        return HackerScene.getInstance(parent, w, h);
    }


    public HackerTextArea makeTextArea() {
        return HackerTextArea.getInstance();
    }

}
