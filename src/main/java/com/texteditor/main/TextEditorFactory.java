package com.texteditor.main;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public interface TextEditorFactory {
    MenuBar makeMenuBar();
    Menu makeMenu(String name);
    MenuItem makeMenuItem(String name);
    Scene makeScene(Parent p, int w, int h);
    TextArea makeTextArea();
}
