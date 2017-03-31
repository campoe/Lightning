package view;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Coen on 30-3-2017.
 */
public class Renderer {

    private LinkedList<AbstractGameObject> objects;
    private LinkedList<Image> images;
    private LinkedList<Text> texts;

    public Renderer() {
        objects = new LinkedList<>();
        images = new LinkedList<>();
        texts = new LinkedList<>();
    }

    public void tick() {
        for (AbstractGameObject object : objects) {
            object.tick();
        }
        for (Text text : texts) {
            text.tick();
        }
        for (Image image : images) {
            image.tick();
        }
    }

    public void render(Graphics g) {
        for (AbstractGameObject object : objects) {
            object.render(g);
        }
        for (Text text : texts) {
            text.render(g);
        }
        for (Image image : images) {
            image.render(g);
        }
    }

    public boolean addObject(AbstractGameObject object) {
        return objects.add(object);
    }

    public boolean removeObject(AbstractGameObject object) {
        return objects.remove(object);
    }

    public boolean addImage(Image image) {
        return images.add(image);
    }

    public boolean removeImage(Image image) {
        return images.remove(image);
    }

    public boolean addText(Text text) {
        return texts.add(text);
    }

    public boolean removeText(Text text) {
        return texts.remove(text);
    }

}
