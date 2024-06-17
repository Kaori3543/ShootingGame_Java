import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Player extends Character implements KeyListener{
	public Player(double x,double y,double vx,double vy) {
		super(x,y,vx,vy);
	}
	public void move() {
		super.move();
		if(x<0) x=0;
		if(x>370) x=370;
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			vx=-5;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			vx=5;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			GameWorld.playerBullets.add(
					new PlayerBullet(x,y,0,-10));
		}
	}
	public void keylessed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			vx=0;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			vx=0;
		}
	}
	public void keyTyped(KeyEvent e) {
		
	}


}
