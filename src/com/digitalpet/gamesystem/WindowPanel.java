package com.digitalpet.gamesystem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class WindowPanel extends JPanel {
    private Image backgroundImage;

    public WindowPanel() {
        try {
            backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("background.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
