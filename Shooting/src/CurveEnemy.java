
public class CurveEnemy extends Enemy{
	public CurveEnemy(double x,double y,double vx,double vy) {
		super(x,y,vx,vy);
		life+=GameWorld.stage;
	}
	public void move() {
		super.move();
		if(x<GameWorld.player.x) {
			//自分がプレイヤーより左にいたら
			x+=GameWorld.stage; //右に移動する
		}
		if(x>GameWorld.player.x) {
			//自分がプレイヤーより右にいたら
			x-=GameWorld.stage;  //左に移動する
		}
	}
	public void draw(MyFrame f) {
		f.setColor(0,0,0);
		f.fillOval(x,y,30,30);
		f.setColor(255,255,255);
		f.fillOval(x+5,y,20,30);
	}
	

}
