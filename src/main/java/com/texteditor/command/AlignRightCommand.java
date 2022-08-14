package com.texteditor.command;

public class AlignRightCommand implements Command{
    AlignReceiver align;
    public AlignRightCommand(AlignReceiver align){
        this.align = align;
    }

    @Override
    public void execute() {
        align.alignRight();
    }
}
