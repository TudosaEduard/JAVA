package problem.ui;

import java.io.Serializable;
import java.util.List;

import javax.swing.JFrame;

import problem.game.objects.Node;

public class MainFrame extends JFrame implements Serializable{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    List <Node> nodes;

    public MainFrame() {
        super("Positional Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        add(configPanel, java.awt.BorderLayout.NORTH);
        add(canvas, java.awt.BorderLayout.CENTER);
        add(controlPanel, java.awt.BorderLayout.SOUTH);


        pack();
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }
    
}
