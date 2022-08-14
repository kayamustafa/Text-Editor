package com.texteditor.main;

import com.texteditor.abstractfactorydefault.DefaultTextEditorFactory;
import com.texteditor.abstractfactoryhacker.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        TextEditorFactory factory;
        String[] themes = {"Default", "Hacker"};
        ChoiceDialog dialog = new ChoiceDialog(themes[0], themes);
        dialog.setHeaderText("Theme Selection");

        dialog.showAndWait();

        if(dialog.getSelectedItem().equals("Hacker"))
            factory = new HackerTextEditorFactory();
        else
            factory = new DefaultTextEditorFactory();


        Scene scene = TextEditor.createTextEditor(factory, stage);
        File f = new File("src/main/resources/style.css");
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        stage.setScene(scene);
        stage.setTitle("Text Editor");
        stage.show();
    }
}
