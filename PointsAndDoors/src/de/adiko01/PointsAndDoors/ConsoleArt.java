package de.adiko01.PointsAndDoors;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * Klasse zum erstellen eines Schriftzuges in der Konsole als ASCII Art
 * @author adiko01
 */
public class ConsoleArt {

	/**
	 * Methode zum erstellen eines Schriftzuges in der Konsole als ASCII Art
	 * @param TEXT Text der als ASCII Art auf der Konsole erscheinen soll.
	 */
    public static void main(String TEXT) {

        int width = 151;
        int height = 30;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 18));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString(TEXT, 1, 30);

        //save this image
        //ImageIO.write(image, "png", new File("/users/mkyong/ascii-art.png"));

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {
            	sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }

    }

}