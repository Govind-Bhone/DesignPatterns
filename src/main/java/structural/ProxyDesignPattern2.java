package structural;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by govind.bhone on 6/18/2017.
 */
interface Image {
    public void displayImage();
}

class RealImage implements Image {
    String file;

    public RealImage(String file) {
        //load up the image
        this.file = file;
    }

    public void displayImage() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame editorFrame = new JFrame("Image Demo");
                editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                ImageIcon imageIcon = new ImageIcon(loadImage(file));
                JLabel jLabel = new JLabel();
                jLabel.setIcon(imageIcon);
                editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

                editorFrame.pack();
                editorFrame.setLocationRelativeTo(null);
                editorFrame.setVisible(true);
            }
        });
    }

    //a method that only the real image has
    private BufferedImage loadImage(String file) {
        //do resource intensive operation to load image
        BufferedImage img=null;
        try {
             img = ImageIO.read(new File(file));
        } catch (IOException e) {
        }
        return img;
    }
}

class ProxyImage implements Image {
    private String file;

    public ProxyImage(String file) {
        this.file = file;
    }

    //this method delegates to the real image

    public void displayImage() {
        RealImage real = new RealImage(file);
        real.displayImage();
    }
}

public class ProxyDesignPattern2 {
    public static void main(String args[]) {
        Image im = new ProxyImage("C:\\Users\\govind.bhone\\Desktop\\img1492349105364.jpg");
        im.displayImage();

    }
}
