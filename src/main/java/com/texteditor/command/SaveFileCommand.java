package com.texteditor.command;

public class SaveFileCommand implements Command{
    FileReceiver receiver;
    public SaveFileCommand(FileReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.saveFile();
    }
}
