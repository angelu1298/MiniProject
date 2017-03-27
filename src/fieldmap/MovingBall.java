package fieldmap;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Database.Ball;

public class MovingBall extends Thread{
	int x=250;
	JLabel ballimg;
	public JLabel returnBall(){
		ballimg = new JLabel(new ImageIcon("image/땅볼.png"));
		ballimg.setSize(new Dimension(80,80));
		return ballimg;
	}
	public void run(){
		for(int i = 0 ;i<270;i++){
			x+=i;
			if(x>520)
				x=520;
			ballimg.setLocation(x, (int)(Math.pow(x-400, 2)/450)+180);
			ballimg.repaint();
			
			try{
				Thread.sleep(50);
			}catch(Exception e){
				
			}
			
		}
		
	}

}
