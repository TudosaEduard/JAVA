package problem.ui;
import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    private Boolean isSaved = false;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
    }

    private void loadGame(ActionEvent evt) {
        frame.canvas.loadPNG();
    }

    private void saveGame(ActionEvent evt) {
        frame.canvas.savePNG();
        isSaved = true;
    }

    private void resetGame(ActionEvent evt) {
        frame.configPanel.dotsSpinner.setValue(6);
        frame.configPanel.linesCombo.setSelectedIndex(0);
        frame.canvas.reset();
    }

    private void exitGame(ActionEvent evt) {
        frame.dispose();
    }

    public Boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(Boolean isSaved) {
        this.isSaved = isSaved;
    }
}

