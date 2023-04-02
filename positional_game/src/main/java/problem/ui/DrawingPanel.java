package problem.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import problem.game.objects.Edge;
import problem.game.objects.Node;

public class DrawingPanel extends JPanel {
    final MainFrame frame;

    final static int W = 800, H = 600;
    private int numVertices;
    private Vertex node1 = null, node2 = null;
    private String edge;

    List <Node> nodes;
    List <Edge> edges;

    private List<Vertex> vertices = new ArrayList<>();
    private Boolean playerTurn;
    private Boolean newGameStarted = false;

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
                newGameStarted = true;
                node1 = null;
                node2 = null;
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
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        selectNodes();
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
            vertices.add(new Vertex(nodes.get(i), x[i], y[i]));
        }

    }

    private void drawLines() {
        for (Edge e : edges) {
            graphics.setColor(Color.BLACK);
            Node n1 = e.getNode1();
            Node n2 = e.getNode2();

            Vertex v1 = null, v2 = null;
            for (Vertex v : vertices) {
                if (v.getNode().equals(n1)) {
                    v1 = v;
                }
                if (v.getNode().equals(n2)) {
                    v2 = v;
                }
            }
            graphics.drawLine(v1.getX(), v1.getY(), v2.getX(), v2.getY());
        }
    }

    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i] - 10, y[i] - 10, 20, 20);
            graphics.setColor(Color.WHITE);
            graphics.fillOval(x[i] - 6, y[i] - 6, 12, 12);
        }
    }

    @Override
    public void update(Graphics g) {
    }

    public void selectNodes() {
        frame.canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                for (Vertex v : vertices) {
                    if (v.contains(x, y)) {
                        if (node1 == null) {
                            node1 = v;
                            graphics.setColor(Color.GREEN);
                            graphics.fillOval(v.getX() - 6, v.getY() - 6, 12, 12);
                            repaint();
                        } else if (node2 == null) {
                            node2 = v;
                            graphics.setColor(Color.GREEN);
                            graphics.fillOval(v.getX() - 6, v.getY() - 6, 12, 12);

                            String color = playerTurn ? "#0000ff" : "#ff0000";

                            graphics.setColor(Color.decode(color));
                            graphics.drawLine(node1.getX(), node1.getY(), node2.getX(), node2.getY());
                            repaint();

                            edge = node1.getNode().getName() + " " + node2.getNode().getName();

                        } else {

                            if(!playerTurn)
                                frame.configPanel.setPlayerRound("Player#1");
                            else
                                frame.configPanel.setPlayerRound("Player#2");

                            graphics.setColor(Color.WHITE);
                            graphics.fillOval(node1.getX() - 6, node1.getY() - 6, 12, 12);
                            graphics.fillOval(node2.getX() - 6, node2.getY() - 6, 12, 12);
                            repaint();
                            node1 = null;
                            node2 = null;
                            return;
                        }
                        break;
                    }
                }
            }
        });
    }

    public Boolean getNewGameStarted() {
        return newGameStarted;
    }

    public void setNewGameStarted(Boolean newGameStarted) {
        this.newGameStarted = newGameStarted;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void savePNG() {
        try {
            ImageIO.write(image, "PNG",
                    new File("E:/Java/Teme/JAVA/positional_game/src/main/java/problem/results/canvas_image.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void loadPNG() {
        try {
            image = ImageIO
                    .read(new File("E:/Java/Teme/JAVA/laborator6/src/main/java/compulsory/game/canvas_image.png"));
            repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void reset() {
        createOffscreenImage();
        repaint();
    }

    public void setPlayerTurn(Boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    public String getEdge() {
        return edge;
    }

    public void setEdge(String edge) {
        this.edge = edge;
    }

    public void winPlayer(){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
        if(!playerTurn)
            graphics.setColor(Color.BLUE);
        else
            graphics.setColor(Color.RED);

        if(!playerTurn)
            frame.configPanel.setPlayerRound("Player#1");
        else
            frame.configPanel.setPlayerRound("Player#2");

        graphics.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        graphics.drawString("Player " + (playerTurn ? "2" : "1") + " won!", 200, 300);
        repaint();
    }
}