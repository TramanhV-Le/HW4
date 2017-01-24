import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
/**
 * This is the main class for Yahtzee that also implements Countdown
 * @author tle19
 *
 */

public class Yahtzee extends JFrame {
    public Yahtzee() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JButton btnStart = new JButton("Start");
        getContentPane().add(btnStart, BorderLayout.CENTER);
        JLabel sum = new JLabel("Yahtzee sum: ");
        getContentPane().add(sum, BorderLayout.SOUTH);
        
        /**
         * Button implementing
         * @param uses ActionListener
         */
        btnStart.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if(btnStart.getText().equals("Start"))	{
        			btnStart.setText("Stop");
        			for(int i = 0; i < 5; i++)
        				Thread[i].start();
        		}
        	}
        });

		/**
		 * Uses JLabel to increment the countdown 
		 * This is how many times the dice will be "rolled"
		 */
        Countdown[] cs = new Countdown[5];
        for (int i=0; i<5; i++) {
            JLabel l = new JLabel();
            cs[i] = new Countdown(l);
            this.add(l);
        }

        this.setVisible(true);

        Thread[] ts = new Thread[5];
        for (int i=0; i<5; i++) {
            ts[i] = new Thread(cs[i]);
            ts[i].start();
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException ex) {;}
        }
        /**
         * Assigns the JLabel to the faces of the dice with a try-catch
         */
        JLabel i = new JLabel();
        try{
        	String diceFace1 = "/Resource/die1.jpg";
        	String diceFace2 = "/Resource/die2.jpg";
        	String diceFace3 = "/Resource/die3.jpg";
        	String diceFace4 = "/Resource/die4.jpg";
        	String diceFace5 = "/Resource/die5.jpg";
        	String diceFace6 = "/Resource/die6.jpg";
        	
        	Image die1 = Toolkit.getDefaultToolkit().getImage(diceFace1);
    		Image die2 = Toolkit.getDefaultToolkit().getImage(diceFace2);
    		Image die3 = Toolkit.getDefaultToolkit().getImage(diceFace3);
    		Image die4 = Toolkit.getDefaultToolkit().getImage(diceFace4);
    	    Image die5 = Toolkit.getDefaultToolkit().getImage(diceFace5);
    	    Image die6 = Toolkit.getDefaultToolkit().getImage(diceFace6);
    	    
        }
        catch (Exception ex) {i.setText("invalid roll");}
        this.add(i);
        revalidate();
    }

    public static void main(String[] args) {
        Yahtzee yz = new Yahtzee();
    }

    public static void getinfo(String[] args) {
        System.out.printf("Active count: %d\n", Thread.activeCount());
        System.out.printf("Thread ID: %d\n", Thread.currentThread().getId());
        System.out.printf("Thread Name: %s\n", Thread.currentThread().getName());
        System.out.printf("Thread Priority: %d\n", Thread.currentThread().getPriority());
        System.out.printf("Thread State: %s\n", Thread.currentThread().getState().toString());
        System.out.printf("Thread Alive? %b\n", Thread.currentThread().isAlive());

        try {
            System.out.printf("Is currently rolling. . . ");
            Thread.sleep(1000);
            System.out.printf(" as the result\n");
        }
        catch (InterruptedException ex) {
            System.out.printf(" roll incomplete\n");
        }
    }
}
