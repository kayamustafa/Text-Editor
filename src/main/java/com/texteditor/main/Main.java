package com.texteditor.main;

import com.texteditor.abstractfactorydefault.DefaultTextEditorFactory;
import com.texteditor.abstractfactoryhacker.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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


        Scene scene = TextEditor.createTextEditor(factory);

        stage.setScene(scene);
        stage.show();
    }
}
