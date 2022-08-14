package com.texteditor.command;

public class FindAndReplaceCommand implements Command{
    ExtrasReceiver receiver;
    public FindAndReplaceCommand(ExtrasReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.findAndReplace();
    }
}
