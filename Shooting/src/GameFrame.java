import java.util.Vector;

public class GameFrame extends MyFrame{
	public void run() {
		GameWorld.player=new Player(100,300,0,0);
		addKeyListener(GameWorld.player);
		GameWorld.playerBullets=new Vector<PlayerBullet>();
		GameWorld.enemies=new Vector<Enemy>();
		GameWorld.enemies.add(new EnemyBase(100,50,1,0));
	while(true) {
		clear();
		GameWorld.player.draw(this);
		GameWorld.player.move();
		
		movePlayerBullets();
		mioveEnemies();
		checkPlayerAndEnemies();
		checkPlayerBulletsAndEnemies();
		if(GameWorld.enemies.size()==0) {
			setColor(0,0,0);
			drawString("クリア!",100,200,40);
		} else if (GameWorld.player.y<0) {
			setColor(0,0,0);
			drawString("ゲームオーバー!",50,200,40);
		}
		sleep(0.03);
		for(int i=0; i<GameWorld.enemies.size(); i++) {
			Enemy e=GameWorld.enemies.get(i);
			if(e.x==GameWorld.player.x &&
					e.y==GameWorld.player.y) {
				System.out.println("やられた!");
			}
		}
		sleep(0.03);
	}
}
	private void checkPlayerAndEnemies() {
		for(int i=0; i<GameWorld.enemies.size(); i++) {
			Enemy e=GameWorld.enemies.get(i);
			if(checkHit(GameWorld.player,e)) {
				System.out.println("やられた!");
				GameWorld.player.y=-1000;
			}
		}
		
	}
	public void checkPlayerBulletsAndEnemies() {
		int i=0;
		while(i<GameWorld.playerBullets.size()) {
			PlayerBullet b=GameWorld.playerBullets.get(i);
			int j=0;
			int hits=0;
			while(j<GameWorld.enemies.size()) {
				Enemy e=GameWorld.enemies.get(j);
				if(checkHit(e,b)) {
					System.out.println("あたり");
					hits++;
					e.life--;
				}
				if(e.life<=0) {
					GameWorld.enemies.remove(j);
				}else {
					j++;
				}
			}
			if(hits>0) {
				GameWorld.playerBullets.remove(i);
			}else {
				i++;
			}
		}
	}
	public boolean checkHit(Character a,Character b) {
		if(Math.abs(a.x-b.x)<=10 && Math.abs(a.y-b.y)<=10) {
			return true;
		}else {
			return false;
		}
		
	}
public void mioveEnemies() {
	for(int i=0; i<GameWorld.enemies.size(); i++) {
		Enemy e=GameWorld.enemies.get(i);
		e.draw(this);
		e.move();
	}
	int i=0;
	while (i<GameWorld.enemies.size()) {
		Enemy e=GameWorld.enemies.get(i);
		if(e.y>400) {
			GameWorld.enemies.remove(i);
		} else {
			i++;
		}
	}
}

public void movePlayerBullets() {
	int i=0;
	while(i<GameWorld.playerBullets.size()) {
		PlayerBullet b=GameWorld.playerBullets.get(i);
		b.draw(this);
		b.move();
		if(b.y<0) {
			GameWorld.playerBullets.remove(i);
		} else {
			i++;
		}
	}
}
}
