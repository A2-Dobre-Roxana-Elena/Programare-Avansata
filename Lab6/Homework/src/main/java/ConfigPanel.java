

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createBtn;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        linesLabel = new JLabel("Line probability:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        Double[] lineOptions = {2.0,3.0,4.0, 5.0, 6.0};
        linesCombo = new JComboBox(lineOptions);
        createBtn = new JButton("Create new game");

        //create spinners for rows and cols, and the button
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createBtn);

    }

}
