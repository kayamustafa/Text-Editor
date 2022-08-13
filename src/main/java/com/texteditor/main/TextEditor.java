package com.texteditor.main;

import com.texteditor.abstractfactoryhacker.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TextEditor {

    public static Scene createTextEditor(TextEditorFactory factory){

        BorderPane layout = new BorderPane();

        MenuBar menubar = factory.makeMenuBar();
        VBox vbox = new VBox(menubar);

        Menu fileMenu = factory.makeMenu("File");
        Menu alignMenu = factory.makeMenu("Align");
        Menu extrasMenu = factory.makeMenu("Extras");

        MenuItem fileItemNew = factory.makeMenuItem("New");
        MenuItem fileItemOpen = factory.makeMenuItem("Open");
        MenuItem fileItemSave = factory.makeMenuItem("Save");

        MenuItem alignItemLeft = factory.makeMenuItem("Left");
        MenuItem alignItemCenter = factory.makeMenuItem("Center");
        MenuItem alignItemRight = factory.makeMenuItem("Right");

        MenuItem extrasFind = factory.makeMenuItem("Find");
        MenuItem extrasFindAndReplace = factory.makeMenuItem("Find & Replace");

        fileMenu.getItems().addAll(fileItemNew, fileItemOpen, fileItemSave);
        alignMenu.getItems().addAll(alignItemLeft, alignItemCenter, alignItemRight);
        extrasMenu.getItems().addAll(extrasFind, extrasFindAndReplace);

        menubar.getMenus().addAll(fileMenu, alignMenu, extrasMenu);

        TextArea textArea = factory.makeTextArea();
        layout.setTop(vbox);
        layout.setCenter(textArea);


        Scene scene = factory.makeScene(layout, 600, 500);

        return scene;
    }

}
