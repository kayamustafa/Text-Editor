package com.texteditor.main;

import com.texteditor.command.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class TextEditor {

    private static File savedFile;
    private static File openedFile;

    public static File getOpenedFile() {
        return openedFile;
    }

    public static File getSavedFile() {
        return savedFile;
    }
    private static TextArea textArea;
    public static Scene createTextEditor(TextEditorFactory factory, Stage stage){

        BorderPane layout = new BorderPane();

        MenuBar menubar = factory.makeMenuBar();
        VBox vbox = new VBox(menubar);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        Menu fileMenu = factory.makeMenu("File");
        Menu alignMenu = factory.makeMenu("Align");
        Menu extrasMenu = factory.makeMenu("Extras");

        MenuItem fileItemNew = factory.makeMenuItem("New");
        MenuItem fileItemOpen = factory.makeMenuItem("Open");
        MenuItem fileItemSave = factory.makeMenuItem("Save");
        fileItemNew.setOnAction(e -> actionPerformed(fileItemNew.getText()));
        fileItemOpen.setOnAction(e -> {
            openedFile = fileChooser.showOpenDialog(stage);
            actionPerformed(fileItemOpen.getText());
        });
        fileItemSave.setOnAction(e -> {
            savedFile = fileChooser.showSaveDialog(stage);
            actionPerformed(fileItemSave.getText());
        });



        MenuItem alignItemLeft = factory.makeMenuItem("Left");
        MenuItem alignItemCenter = factory.makeMenuItem("Center");
        MenuItem alignItemRight = factory.makeMenuItem("Right");
        alignItemLeft.setOnAction(e -> actionPerformed(alignItemLeft.getText()));
        alignItemCenter.setOnAction(e -> actionPerformed(alignItemCenter.getText()));
        alignItemRight.setOnAction(e -> actionPerformed(alignItemRight.getText()));


        MenuItem extrasFind = factory.makeMenuItem("Find");
        MenuItem extrasFindAndReplace = factory.makeMenuItem("Find & Replace");
        extrasFind.setOnAction(e -> {
            actionPerformed(extrasFind.getText());
        });
        extrasFindAndReplace.setOnAction(e -> {
            actionPerformed(extrasFindAndReplace.getText());
        });

        fileMenu.getItems().addAll(fileItemNew, fileItemOpen, fileItemSave);
        alignMenu.getItems().addAll(alignItemLeft, alignItemCenter, alignItemRight);
        extrasMenu.getItems().addAll(extrasFind, extrasFindAndReplace);

        menubar.getMenus().addAll(fileMenu, alignMenu, extrasMenu);

        textArea = factory.makeTextArea();
        layout.setTop(vbox);
        layout.setCenter(textArea);


        Scene scene = factory.makeScene(layout, 600, 500);

        return scene;
    }
    public static TextArea getTextArea(){
        return textArea;
    }

    public static void actionPerformed(String command){
        ProcessControl control = new ProcessControl();
        FileReceiver file = new FileReceiver();
        ExtrasReceiver extras = new ExtrasReceiver();
        AlignReceiver align = new AlignReceiver();
        switch (command){
            case "New":
                NewFileCommand newFile = new NewFileCommand(file);
                control.setCommand(newFile);
                control.fileProcess();
                break;
            case "Open":
                OpenFileCommand openFile = new OpenFileCommand(file);
                control.setCommand(openFile);
                control.fileProcess();
                break;
            case "Save":
                SaveFileCommand saveFile = new SaveFileCommand(file);
                control.setCommand(saveFile);
                control.fileProcess();
                break;
            case "Left":
                AlignLeftCommand alignLeft = new AlignLeftCommand(align);
                control.setCommand(alignLeft);
                control.fileProcess();
                break;
            case "Center":
                AlignCenterCommand alignCenter = new AlignCenterCommand(align);
                control.setCommand(alignCenter);
                control.fileProcess();
                break;
            case "Right":
                AlignRightCommand alignRight = new AlignRightCommand(align);
                control.setCommand(alignRight);
                control.fileProcess();
                break;
            case "Find":
                FindCommand find = new FindCommand(extras);
                control.setCommand(find);
                control.fileProcess();
                break;
            case "Find & Replace":
                FindAndReplaceCommand findAndReplace = new FindAndReplaceCommand(extras);
                control.setCommand(findAndReplace);
                control.fileProcess();
                break;
        }
    }

}
