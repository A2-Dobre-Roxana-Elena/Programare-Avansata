import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitButton = new JButton("Exit");
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");

    //create all buttons (Load, Exit, etc.)
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);

        exitButton.addActionListener(this::exitGame);
        saveButton.addActionListener(this::saveGame);
        loadButton.addActionListener(this::loadGame);


    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void saveGame(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        int option = fileChooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(fileToSave.getAbsolutePath()));
                System.out.println("Imaginea a fost salvata.");
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        } else if (option == JFileChooser.CANCEL_OPTION) {
            System.out.println("Ati anulat salvarea imaginii.");
        } else {
            System.out.println("S-a format o eroare in timpul salvarii.");
        }
    }

    public void loadGame(ActionEvent event) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:/Users/utilizator/Documents/facultate/sem2/java/save1"));
        } catch (IOException e) {
            System.out.println("S-au intampinat erori in incarcarea jocului");
        }
        ImageIcon imageIcon = new ImageIcon(img);
        frame.configPanel.dotsLabel.setIcon(imageIcon);
        System.out.println(img);
    }
}
