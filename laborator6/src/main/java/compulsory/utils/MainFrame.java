package compulsory.utils;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
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
}
