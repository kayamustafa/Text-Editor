package com.texteditor.abstractfactorydefault;

import com.texteditor.abstractfactoryhacker.HackerScene;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DefaultScene extends Scene {

    private static DefaultScene scene = null;

    public DefaultScene(Parent parent, int v, double v1) {
        super(parent, v, v1);
    }

    public static DefaultScene getInstance(Parent p, int v, int v1){
        if(scene == null){
            scene = new DefaultScene(p,v,v1);
        }
        return scene;
    }

}
