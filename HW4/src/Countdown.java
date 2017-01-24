import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Uses the 'Countdown' class with runnable to display the faces and the number of rolls.
 * @author tle19
 * 
 */
class Countdown implements Runnable {
    private JLabel _label;
    public Countdown(JLabel label) {
        _label = label;
    }
    /**
     * Allows for a random Face to be displayed
     * Allows for a random number of Rolls to run
     */
	public void run() {
		Random randFace = new Random();
		Random randRoll = new Random();
		
		int roll = randRoll.nextInt(30)+10;
        for (int i = roll; i > 1; i--) {
            int pickFace = randFace.nextInt(6)+1;
           /**
            * Pick a face randomly with the imported images, set to size.
            * Display the image as an icon
            */
            if (pickFace == 1) {
            	Toolkit toolkit = Toolkit.getDefaultToolkit();
            	URL iu = getClass().getResource("/Resource/die1.jpg");
            	Image face1 = toolkit.getImage(iu);
            	face1 = face1.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
            	ImageIcon icon = new ImageIcon(face1);
            	_label.setIcon(icon);
            }
            else if (pickFace == 2) {
            	Toolkit toolkit = Toolkit.getDefaultToolkit();
            	URL iu = getClass().getResource("/Resource/die2.jpg");
            	Image face2 = toolkit.getImage(iu);
            	face2 = face2.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
            	ImageIcon icon = new ImageIcon(face2);
            	_label.setIcon(icon);
            }
            else if (pickFace == 3) {
            	Toolkit toolkit = Toolkit.getDefaultToolkit();
            	URL iu = getClass().getResource("/Resource/die3.jpg");
            	Image face3 = toolkit.getImage(iu);
            	face3 = face3.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
            	ImageIcon icon = new ImageIcon(face3);
            	_label.setIcon(icon);
            }
            else if (pickFace == 4) {
            	Toolkit toolkit = Toolkit.getDefaultToolkit();
            	URL iu = getClass().getResource("/Resource/die4.jpg");
            	Image face4 = toolkit.getImage(iu);
            	face4 = face4.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
            	ImageIcon icon = new ImageIcon(face4);
            	_label.setIcon(icon);
            }
            else if (pickFace == 5) {
            	Toolkit toolkit = Toolkit.getDefaultToolkit();
            	URL iu = getClass().getResource("/Resource/die5.jpg");
            	Image face5 = toolkit.getImage(iu);
            	face5 = face5.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
            	ImageIcon icon = new ImageIcon(face5);
            	_label.setIcon(icon);
            }
            else if (pickFace == 6) {
            	Toolkit toolkit = Toolkit.getDefaultToolkit();
            	URL iu = getClass().getResource("/Resource/die6.jpg");
            	Image face6 = toolkit.getImage(iu);
            	face6 = face6.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
            	ImageIcon icon = new ImageIcon(face6);
            	_label.setIcon(icon);
            }
            /**
             * Have a delay between the output faces.
             */
            try { Thread.sleep(300); }
            catch (InterruptedException ex) {;}
        }
        // _label.setText("Your dice roll");
    }
}
