package com.texteditor.command;

import javafx.scene.control.TextArea;
import com.texteditor.main.TextEditor;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReceiver {
    TextArea textArea = TextEditor.getTextArea();


    public void newFile(){
        textArea.setText("");
    }

    public void openFile(){
        String content = "";
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(TextEditor.getOpenedFile().toPath());
        }catch (IOException e) {
            System.out.println("Error: " + e);
        }
        for(String line : lines){
            content += line + "\n";
        }
        textArea.setText(content);
    }

    public void saveFile(){
        try {
            FileWriter myWriter = new FileWriter(TextEditor.getSavedFile());
            myWriter.write(textArea.getText());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }catch (NullPointerException e){
            System.out.println("Null pointer exception");
        }
    }

}
