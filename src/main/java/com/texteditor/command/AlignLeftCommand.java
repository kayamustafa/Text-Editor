package com.texteditor.command;

public class AlignLeftCommand implements Command{
    AlignReceiver align;
    public AlignLeftCommand(AlignReceiver align){
        this.align = align;
    }

    @Override
    public void execute() {
        align.alignLeft();
    }
}
