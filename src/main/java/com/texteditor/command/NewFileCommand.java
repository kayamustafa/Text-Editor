package com.texteditor.command;

public class NewFileCommand implements Command{
    FileReceiver receiver;

    public NewFileCommand(FileReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.newFile();
    }
}
