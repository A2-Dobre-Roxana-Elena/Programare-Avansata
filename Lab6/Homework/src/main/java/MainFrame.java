

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        //create the components
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        configPanel.createBtn.addActionListener(this::draw);
        //invoke the layout manager
        pack();
    }
    private void draw(ActionEvent e){
        canvas.initPanel((Integer) configPanel.dotsSpinner.getValue(), (Double) configPanel.linesCombo.getSelectedItem());
        SwingUtilities.updateComponentTreeUI(this);
    }
}
