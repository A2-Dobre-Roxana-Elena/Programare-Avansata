
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    private boolean[][] selectedEdges;
    private boolean Red; // true when it is the red player's turn, false when it is the blue player's turn

    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel((Integer) frame.configPanel.dotsSpinner.getValue(), (Double) frame.configPanel.linesCombo.getSelectedItem());
        Red=true;
    }
    public void initPanel(int dots, double lineProb) {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        selectedEdges = new boolean[dots][dots];
        for (int i = 0; i < dots; i++) {
            Arrays.fill(selectedEdges[i], false);
        }
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int ax = e.getX();
                int ay = e.getY();
                for (int i = 0; i < numVertices; i++) {
                    for (int j = i + 1; j < numVertices; j++) {
                        if (Math.abs((y[i] - y[j]) * ax - (x[i] - x[j]) * ay + x[i] * y[j] - y[i] * x[j]) / Math.sqrt(Math.pow(y[i] - y[j], 2) + Math.pow(x[i] - x[j], 2)) <= 10) {
                                if (Red) {
                                    graphics.setColor(Color.RED);
                                } else {
                                    graphics.setColor(Color.BLUE);
                                }
                                graphics.drawLine(x[i], y[i], x[j], y[j]);
                                Red = !Red;
                                drawSelectedEdges();
                                repaint();
                        }
                    }
                }
            }
        });
        createBoard(dots, lineProb);
    }

    private void drawSelectedEdges() {
        graphics.setColor(Color.RED);
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (selectedEdges[i][j]) {
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }
    final void createBoard(int dots, double prob) {
        numVertices = dots;
        edgeProbability = prob;
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }
    private void createVertices() {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
    }
    private void drawVertices() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 10 / 2, y[i] - 10 / 2, 10, 10);
        }
    }
    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}