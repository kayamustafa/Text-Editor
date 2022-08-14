package com.texteditor.command;

public class AlignCenterCommand implements Command{
    AlignReceiver align;
    public AlignCenterCommand(AlignReceiver align){
        this.align = align;
    }

    @Override
    public void execute() {
        align.alignCenter();
    }
}
