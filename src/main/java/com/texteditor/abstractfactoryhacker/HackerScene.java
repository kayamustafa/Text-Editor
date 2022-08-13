package com.texteditor.abstractfactoryhacker;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class HackerScene extends Scene {

    private static HackerScene scene = null;

    public HackerScene(Parent parent, int w, int h) {
        super(parent, w, h);
    }

    public static HackerScene getInstance(Parent p, int w, int h){
        if(scene == null){
            scene = new HackerScene(p,w,h);
        }
        return scene;
    }
}
