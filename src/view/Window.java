/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by Coen on 17-3-2017.
 */
public class Window {

    private final JFrame frame;
    private final BufferedImage image;
    private final Canvas canvas;
    private final Graphics2D graphics;
    private final BufferStrategy bufferStrategy;
    private final WindowHandler windowHandler;

    public Window(int width, int height, float scale, String title, Container container) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension dimension = new Dimension((int) (width * scale), (int) (height * scale));
        canvas.setPreferredSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setMaximumSize(dimension);
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        canvas.createBufferStrategy(3);
        bufferStrategy = canvas.getBufferStrategy();
        graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
        graphics.setComposite(AlphaComposite.Src);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        windowHandler = new WindowHandler(this);
    }

    public void render(Renderer renderer) {
        graphics.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        renderer.render(getGraphics());
        bufferStrategy.show();
    }

    public final BufferedImage getImage() {
        return image;
    }

    public final Canvas getCanvas() {
        return canvas;
    }

    public final JFrame getFrame() {
        return frame;
    }

    public final Graphics getGraphics() {
        return graphics;
    }

}
