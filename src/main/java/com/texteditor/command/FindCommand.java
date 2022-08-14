package com.texteditor.command;

public class FindCommand implements Command{
    ExtrasReceiver receiver;
    public FindCommand(ExtrasReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.find();
    }
}
