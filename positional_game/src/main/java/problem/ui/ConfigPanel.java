package problem.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton; 
    JLabel playerRound;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        playerRound = new JLabel("Player#1");
        dotsLabel = new JLabel("Number of dots: ");
        linesLabel = new JLabel("Line probability: ");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesCombo = new JComboBox(new Double[]{0.1, 0.5, (double) 1});
        createButton = new JButton("Create new game");

        add(playerRound);
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }

    public JSpinner getDotsSpinner() {
        return dotsSpinner;
    }
    
    public JComboBox getLinesCombo() {
        return linesCombo;
    }

    public void setPlayerRound(String player) {
        playerRound.setText(player);
    }
}

