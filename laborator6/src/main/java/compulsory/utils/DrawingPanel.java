package compulsory.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    final MainFrame frame;

    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    
    private int[] x, y;
    BufferedImage image;
    Graphics2D graphics;


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        frame.configPanel.createButton.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                createBoard();
                repaint();
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2;
        int radius = H / 2 - 10;
        double alpha = 2 * Math.PI / numVertices;
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    graphics.setColor(Color.BLACK);
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
       }

    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i] - 5, y[i] - 5, 10, 10);
            graphics.setColor(Color.WHITE);
            graphics.fillOval(x[i] - 3, y[i] - 3, 6, 6);
        }
       }

    @Override
    public void update(Graphics g) {
    } 

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    public void savePNG() {
        try {
            ImageIO.write(image, "PNG", new File("E:/Java/Teme/JAVA/laborator6/src/main/java/compulsory/game/canvas_image.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    public void loadPNG() {
        try {
            image = ImageIO.read(new File("E:/Java/Teme/JAVA/laborator6/src/main/java/compulsory/game/canvas_image.png"));
            repaint();
        } catch (IOException ex) { System.err.println(ex); }
    }

    public void saveJSON() {
        try {
            ImageIO.write(image, "JSON", new File("E:/Java/Teme/JAVA/laborator6/src/main/java/compulsory/game/canvas_image.json"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    public void reset() {
        createOffscreenImage();
        repaint();
    }

}
