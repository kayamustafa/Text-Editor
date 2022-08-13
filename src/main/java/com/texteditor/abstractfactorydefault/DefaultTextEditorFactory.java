package com.texteditor.abstractfactorydefault;

import com.texteditor.main.TextEditorFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class DefaultTextEditorFactory implements TextEditorFactory {
    public MenuBar makeMenuBar() {
        return new DefaultMenuBar();
    }


    public Menu makeMenu(String name) {
        return new DefaultMenu(name);
    }


    public MenuItem makeMenuItem(String name) {
        return new DefaultMenuItem(name);
    }


    public Scene makeScene(Parent parent, int h, int w) {
        return DefaultScene.getInstance(parent, h, w);
    }


    public TextArea makeTextArea() {
        return DefaultTextArea.getInstance();
    }
}
