package src.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
    
    private static List<String> createdImagesNames = new ArrayList<>();
	private static List<ImageIcon> createdIcons = new ArrayList<>();

    private static Image image;

    public BackgroundPanel(String imagePath){
        image = createImage(imagePath);
    }

    private Image createImage(String imagePath){
        return createBackgroundImage(imagePath).getImage();
    }
    
    private ImageIcon createBackgroundImage(String imagePath){
        int imageIndex = createdImagesNames.indexOf(imagePath);
		if(imageIndex >= 0) {
			return createdIcons.get(imageIndex);
		} else {
	    	ImageIcon imageIcon = new ImageIcon(imagePath);
	        createdImagesNames.add(imagePath);
	        createdIcons.add(imageIcon);
	        return imageIcon;
		}
    }
    
    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        g.drawImage(getImage(), getX(), getY(), null);
    }

    public static Image getImage() {
        return image;
    }
}