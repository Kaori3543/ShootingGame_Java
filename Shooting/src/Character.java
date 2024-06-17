
public class Character {
	double x,y,vx,vy;
	public Character(double x,double y,double vx,double vy) {
		//コンストラクタ(6章)
		this.x=x;
		this.y=y;
		this.vx=vx;
		this.vy=vy;
	}
	public void move() {
		//moveメソッド(6章)
		x+=vx;
		y+=vy;		
	}
	public void draw(MyFrame f) {
		//drawメソッド(6章)
		//draw: 標準では単純な四角形が描かれる
		f.setColor(0,128,0);
		f.fillRect(x,y,30,30);
	}

}
