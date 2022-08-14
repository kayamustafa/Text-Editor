package com.texteditor.command;

import java.io.IOException;

public class OpenFileCommand implements Command{
    FileReceiver receiver;
    public OpenFileCommand(FileReceiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.openFile();
    }
}
