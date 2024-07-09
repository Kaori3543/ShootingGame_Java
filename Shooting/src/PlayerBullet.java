
public class PlayerBullet extends Character{
	public PlayerBullet(double x,double y,double vx,double vy) {
		super(x,y,vx,vy);
	}
	
	public void draw(MyFrame f) {
		f.setColor(128,128,120);
		f.fillOval(x+10,y,10,30);
	}
	

}
