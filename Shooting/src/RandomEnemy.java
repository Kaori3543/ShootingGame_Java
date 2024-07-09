
public class RandomEnemy extends Enemy{
	public RandomEnemy(double x,double y,double vx,double vy) {
		super(x,y,vx,vy);

		life=+GameWorld.stage;
	}
	public void move() {
		super.move();
		vx=(Math.random()-0.5) * GameWorld.stage;

	}
	public void draw(MyFrame f) {
		f.setColor(0,128,0);
		f.fillRect(x,y,10,20);
		f.setColor(0,128,0);
		f.fillRect(x+20,y,10,20);
		f.setColor(0,128,0);
		f.fillRect(x+10,y+20,10,10);
	}
	

}
