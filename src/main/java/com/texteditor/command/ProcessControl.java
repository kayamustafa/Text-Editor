package com.texteditor.command;

public class ProcessControl {
    Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void fileProcess(){
        command.execute();
    }
}
