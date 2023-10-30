import javax.swing.*;
import java.awt.*;

class GhostPanel extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private int remove;
    public GhostPanel(int x,int y,int width,int height,int remove) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.remove = remove;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw ghost body
        g2.setColor(Color.white);
        g2.fillOval(x, y, width, height);

        // Draw ghost eyes
        g2.setColor(Color.black);
        g2.fillOval((int)(x * 1.4)-remove, (int)(1.6 * y)-remove, (int)(0.2 * width), (int)(0.2 * height));
        g2.fillOval((int)(x * 2.2)-remove, (int)(1.6 * y)-remove, (int)(0.2 * width), (int)(0.2 * height));

        // Draw ghost mouth
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(2));
        // g2.drawArc(75, 100, 50, 50, 200, 140);
        // g2.drawArc(75, 100, 50, 50, 200, 140);
        g.fillOval((int)(x * 1.8)-remove, (int)(y * 2.2)-remove,  (int)(0.2 * width),  (int)(0.4 * height));

        // Draw speech bubble
        int[] bubbleX = {160, 190, 230, 190, 160};
        int[] bubbleY = {20, 0, 50, 50, 20};

        g2.setColor(Color.white);
        g2.fillPolygon(bubbleX, bubbleY, 5);
        g2.setColor(Color.black);
        g2.drawPolygon(bubbleX, bubbleY, 5);

        // Text in speech bubble
        g2.setColor(Color.black);
        g2.drawString("Boo!", 170, 30);
    }
}


class Scare {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        GhostPanel ghostPanel = new GhostPanel(150,150,200, 240, 38);
        frame.add(ghostPanel);

        frame.setVisible(true);
    }
}