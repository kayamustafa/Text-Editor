package com.texteditor.command;

import com.texteditor.main.TextEditor;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;

public class ExtrasReceiver {
    public void find(){
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setContentText("Find");
        textInputDialog.showAndWait();
        String wordToFind = textInputDialog.getResult();
        int startIndex = TextEditor.getTextArea().getText().indexOf(wordToFind);
        int endIndex = startIndex + wordToFind.length();
        TextEditor.getTextArea().selectRange(startIndex, endIndex);
    }
    public void findAndReplace(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Find & Replace");

        ButtonType replaceButtonType = new ButtonType("Replace", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(replaceButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 10, 10));

        TextField find = new TextField();
        find.setPromptText("Find");
        TextField replace = new TextField();
        replace.setPromptText("Replace");

        grid.add(new Label("Find:"), 0, 0);
        grid.add(find, 1, 0);
        grid.add(new Label("Replace:"), 2, 0);
        grid.add(replace, 3, 0);

        Node replaceButton = dialog.getDialogPane().lookupButton(replaceButtonType);
        replaceButton.setDisable(true);

        find.textProperty().addListener((observable, oldValue, newValue) -> {
            replaceButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> find.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == replaceButtonType) {
                return new Pair<>(find.getText(), replace.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            int startIndex = TextEditor.getTextArea().getText().indexOf(pair.getKey());
            int endIndex = startIndex + pair.getKey().length();
            TextEditor.getTextArea().replaceText(startIndex, endIndex, pair.getValue());
            TextEditor.getTextArea().selectRange(startIndex, pair.getValue().length());
        });
    }
}
