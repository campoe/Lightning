/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package view;

import java.awt.*;

/**
 * Created by Coen on 17-3-2017.
 */
public class Container implements Runnable {

    private boolean running = false;

    private int width, height;
    private float scale;
    private String title;
    private Window window;
    private Canvas canvas;
    private Renderer renderer;
    private InputHandler inputHandler;

    public static void main(String[] args) {
        new Container();
    }

    public Container() {
        width = 320;
        height = 240;
        scale = 3f;
        title = "Lightning";
        start();
    }

    public void start() {
        window = new Window(width, height, scale, title, this);
        canvas = window.getCanvas();
        inputHandler = new InputHandler(this);
        renderer = new Renderer();
        addRenderables();
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void stop() {

    }

    public void addRenderables() {
        if (renderer == null) {
            renderer = new Renderer();
        }
        Image image = new Image("background.png");
        renderer.addImage(image);
    }

    public void run() {
        double time;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passed;
        double delta = 0;
        double rate = 0;
        int frames = 0;
        int fps = 0;
        while (running) {
            boolean render = false;
            time = System.nanoTime() / 1000000000.0;
            passed = time - lastTime;
            lastTime = time;
            delta += passed;
            rate += passed;
            double tickSpeed = 1.0 / 60.0;
            while (delta >= tickSpeed) {
                delta -= tickSpeed;
                render = true;
                //ticks / updates
                if (rate >= 1.0) {
                    rate = 0;
                    fps = frames;
                    frames = 0;
                }
            }
            if (render) {
                //render
                window.render(renderer);
                frames++;
                System.out.println("FPS: " + fps);
            } else {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }

    private void dispose() {

    }

    public final void setWidth(int width) {
        this.width = width;
    }

    public final void setHeight(int height) {
        this.height = height;
    }

    public final void setScale(float scale) {
        this.scale = scale;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public final float getScale() {
        return scale;
    }

    public final String getTitle() {
        return title;
    }

    public final int getHeight() {
        return height;
    }

    public final int getWidth() {
        return width;
    }

    public final Window getWindow() {
        return window;
    }

    public final Canvas getCanvas() {
        return canvas;
    }

}
