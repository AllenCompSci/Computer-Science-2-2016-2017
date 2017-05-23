import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

class graphics implements Runnable, KeyListener, WindowListener {
	public final String TITLE = "Banana Quest Two: The Pointless Sequel!";
	public final Dimension SIZE = new Dimension(1920, 1040);
	public JFrame frame;
	private boolean isRunning, isDone;
	private Image imgBuffer;
	private boolean change;
	@SuppressWarnings("unused")
	private boolean AITurn = false;
	private boolean UserTurn = true;
	String direction = "Down";
	int W = 1;
	
	//User Stats:
	private int UserHp = 5000;
	private int UserMp = 100;
	private String HP = Integer.toString(UserHp);
	private String MP = Integer.toString(UserMp);
	private String playerMove = "";
	private String effectiveness = "";
	
	//Enemy Variables:
	private int EnemyHp = 10000;
	private String EHP = Integer.toString(EnemyHp);
	private boolean fire = false;
	private boolean ice = false;
	private boolean thunder = false;
	private boolean attack = false;


	//Images:
	private BufferedImage banana1;
	private BufferedImage banana2;
	private BufferedImage worldMap;
	private BufferedImage PCUp;
	private BufferedImage PCUpW1;
	private BufferedImage PCUpW2;
	private BufferedImage PCDown;
	private BufferedImage PCDownW1;
	private BufferedImage PCDownW2;
	private BufferedImage PCLeft;
	private BufferedImage PCLeftW;
	private BufferedImage PCRight;
	private BufferedImage PCRightW;
	private BufferedImage House;
	private BufferedImage Plantano;
	private BufferedImage fourthwall;
	private BufferedImage K226;
	private BufferedImage UpArrow;
	private BufferedImage DownArrow;
	private BufferedImage LeftArrow;
	private BufferedImage RightArrow;
	private BufferedImage Fire;
	private BufferedImage Ice;
	private BufferedImage Thunder;
	private BufferedImage EvilDragonKingMrHudson;
	private BufferedImage FadeOut1;
	private BufferedImage FadeOut2;
	private BufferedImage FadeOut3;
	private BufferedImage winner;
	
	//Location Booleans:
	private boolean titleScreen, levelOne, WorldMap, Home, BCity, GameOver, win,
	K226A, K226A1, K226A2, K226A3, K226A4, K226A5, K226A6, K226A7, K226A8, f1, f2, f3, f4, K226B,
	Dialogue1, Dialogue2, Dialogue3, Dialogue4, Dialogue5,
	pointlessPacket, uselessNoPhoneSign;
	
	//Coordinate Integers:
	int wmx = 0;
	int wmy = 0;
	int hx = 800;
	int hy = -120;
	int bcx = -220;
	int bcy = -190;
	int ka1x = 830;
	int ka1y = 460;

	public void setChange(boolean change) {
		this.change = change;
	}

	private void loadImages() {
		try
		{
			banana1 = ImageIO.read(this.getClass().getResource("Banana1.png"));
			banana2 = ImageIO.read(this.getClass().getResource("Banana2.png"));
			worldMap = ImageIO.read(this.getClass().getResource("worldMap.png"));
			PCUp = ImageIO.read(this.getClass().getResource("PC Up.png"));
			PCUpW1 = ImageIO.read(this.getClass().getResource("PC UpW1.png"));
			PCUpW2 = ImageIO.read(this.getClass().getResource("PC UpW2.png"));
			PCDown = ImageIO.read(this.getClass().getResource("PC Down.png"));
			PCDownW1 = ImageIO.read(this.getClass().getResource("PC DownW1.png"));
			PCDownW2 = ImageIO.read(this.getClass().getResource("PC DownW2.png"));
			PCLeft = ImageIO.read(this.getClass().getResource("PC Left.png"));
			PCLeftW = ImageIO.read(this.getClass().getResource("PC LeftW.png"));
			PCRight = ImageIO.read(this.getClass().getResource("PC Right.png"));
			PCRightW = ImageIO.read(this.getClass().getResource("PC RightW.png"));
			House = ImageIO.read(this.getClass().getResource("House.png"));
			Plantano = ImageIO.read(this.getClass().getResource("Plantano.png"));
			fourthwall = ImageIO.read(this.getClass().getResource("4thwall.jpg"));
			K226 = ImageIO.read(this.getClass().getResource("K226.png"));
			UpArrow = ImageIO.read(this.getClass().getResourceAsStream("Up arrow.png"));
			DownArrow = ImageIO.read(this.getClass().getResourceAsStream("Down arrow.png"));
			LeftArrow = ImageIO.read(this.getClass().getResourceAsStream("Left arrow.png"));
			RightArrow = ImageIO.read(this.getClass().getResourceAsStream("Right arrow.png"));
			Fire = ImageIO.read(this.getClass().getResourceAsStream("Fire.png"));
			Ice = ImageIO.read(this.getClass().getResourceAsStream("Ice.png"));
			Thunder = ImageIO.read(this.getClass().getResourceAsStream("Thunder.png"));
			EvilDragonKingMrHudson = ImageIO.read(this.getClass().getResourceAsStream("Evil Dragon King Mr. Hudson.png"));
			FadeOut1 = ImageIO.read(this.getClass().getResourceAsStream("fo1.png"));
			FadeOut2 = ImageIO.read(this.getClass().getResourceAsStream("fo2.png"));
			FadeOut3 = ImageIO.read(this.getClass().getResourceAsStream("fo3.png"));
			winner = ImageIO.read(this.getClass().getResourceAsStream("winnerisyou.png"));
			}catch(Exception e){}
		}

	public graphics()
	{
		titleScreen = true;
		levelOne = false;
		WorldMap = false;
		Home = false;
		BCity = false;
		K226A = false;
		K226A1 = false;
		K226A2 = false;
		K226A3 = false;
		K226A4 = false;
		K226A5 = false;
		K226A6 = false;
		K226A7 = false;
		K226A8 = false;
		K226B = false;
		Dialogue1 = false;
		Dialogue2 = false;
		Dialogue3 = false;
		Dialogue4 = false;
		Dialogue5 = false;
		GameOver = false;
		win = false;
		pointlessPacket = false;
		uselessNoPhoneSign = false;
		f1 = false;
		f2 = false;
		f3 = false;
		f4 = false;
		loadImages();
		frame = new JFrame();
		frame.addKeyListener(this);
		frame.addWindowListener(this);
		frame.setSize(SIZE);
		frame.setTitle(TITLE);
		isRunning = true;
		isDone = false;
		frame.setVisible(true);
		frame.setLayout(null);
		imgBuffer = frame.createImage(SIZE.width, SIZE.height);
	}

	@Override
	public void keyTyped(KeyEvent e){}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		int Key;
		Key = e.getKeyCode();
		
		
		
		if(Key == KeyEvent.VK_SPACE)
		{
			if(titleScreen == true)
			{
				titleScreen = false;
				levelOne = true;
			}
			else if(levelOne == true){
					titleScreen = false;
					levelOne = false;
					WorldMap = true;
			}
			
		}
		
		if(WorldMap == true && Key == KeyEvent.VK_RIGHT && wmx >= -800)
		{
			wmx -= 10;
			WorldMap = false;
			WorldMap = true;
			
			if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
			{
				Home = true;
				WorldMap = false;
			}
			else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
			{
				direction = "Down";
				W = 1;
				K226A = true;
				K226A1 = true;
				WorldMap = false;
			}
			else if(wmy >= 40 && wmx >= 550)
			{
				BCity = true;
				WorldMap = false;
			}
			else
			{
				System.out.print(wmx);
				System.out.print(", ");
				System.out.print(wmy);
				System.out.println();
				direction = "Right";
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
			}
		}
		
		if(WorldMap == true && Key == KeyEvent.VK_LEFT && wmx <= 930)
		{
			wmx += 10;
			WorldMap = false;
			WorldMap = true;
			
			if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
			{
				Home = true;
				WorldMap = false;
			}
			else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
			{
				direction = "Down";
				W = 1;
				K226A = true;
				K226A1 = true;
				WorldMap = false;
			}
			else if(wmy >= 40 && wmx >= 550)
			{
				bcx = -850;
				bcy = 170;
				
				BCity = true;
				WorldMap = false;
			}
			else
			{
				System.out.print(wmx);
				System.out.print(", ");
				System.out.print(wmy);
				System.out.println();
				direction = "Left";
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
			}
		}
		
		if(WorldMap == true && Key == KeyEvent.VK_UP  && wmy <= 460)
		{
			wmy += 10;
			WorldMap = false;
			WorldMap = true;

			if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
			{
				Home = true;
				WorldMap = false;
			}
			else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
			{
				direction = "Down";
				W = 1;
				K226A = true;
				K226A1 = true;
				WorldMap = false;
			}
			else if(wmy >= 40 && wmx >= 550)
			{
				bcx = -220;
				bcy = -210;
				
				BCity = true;
				WorldMap = false;
			}
			else
			{
				System.out.print(wmx);
				System.out.print(", ");
				System.out.print(wmy);
				System.out.println();
				direction = "Up";
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
			}
		}
		
		if(WorldMap == true && Key == KeyEvent.VK_DOWN && wmy >= -190)
		{
			wmy -= 10;
			WorldMap = false;
			WorldMap = true;

			if(wmy >= -100 && wmy <= 470 && wmx <= -170 && wmx >= -540)
			{
				Home = true;
				WorldMap = false;
			}
			else if(wmy >= 380 && wmy <= 470 && wmx >= 50 && wmx <= 380)
			{
				direction = "Down";
				W = 1;
				K226A = true;
				K226A1 = true;
				WorldMap = false;
			}
			else if(wmy >= 40 && wmx >= 550)
			{
				BCity = true;
				WorldMap = false;
			}
			else
			{
				System.out.print(wmx);
				System.out.print(", ");
				System.out.print(wmy);
				System.out.println();
				direction = "Down";
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
			}
		}
		
		if(Home == true && Key == KeyEvent.VK_RIGHT && hx > 330)
		{
			hx -= 10;
			Home = false;
			Home = true;
			
			System.out.print(hx);
			System.out.print(", ");
			System.out.print(hy);
			System.out.println();
			direction = "Right";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Home == true && Key == KeyEvent.VK_LEFT  && hx < 640 && hy > 160 ||Home == true && Key == KeyEvent.VK_LEFT  && hx < 860 && hy < 160)
		{
			hx += 10;
			Home = false;
			Home = true;
			
			System.out.print(hx);
			System.out.print(", ");
			System.out.print(hy);
			System.out.println();
			direction = "Left";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Home == true && Key == KeyEvent.VK_DOWN && hy > -120)
		{
			hy -= 10;
			Home = false;
			Home = true;
			
			System.out.print(hx);
			System.out.print(", ");
			System.out.print(hy);
			System.out.println();
			direction = "Down";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Home == true && Key == KeyEvent.VK_DOWN && hy <= -120)
		{
			Home = false;
			WorldMap = true;
			
			wmx = -360;
			wmy = -110;
		}
		
		if(Home == true && Key == KeyEvent.VK_UP && hx < 640 && hy < 310 || Home == true && Key == KeyEvent.VK_UP && hx > 640 && hy < 160)
		{
			hy += 10;
			Home = false;
			Home = true;
			
			System.out.print(hx);
			System.out.print(", ");
			System.out.print(hy);
			System.out.println();
			direction = "Up";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Home == true && Key == KeyEvent.VK_UP && hy > -60 && hx > 400 && hx < 540)
		{
			hy -= 20;
			
			Dialogue1 = true;
			Home = false;
			direction = "Up";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Home == true && Key == KeyEvent.VK_DOWN && hy > -60 && hx > 400 && hx < 540)
		{
			hy += 20;
			
			Dialogue1 = true;
			Home = false;
			direction = "Down";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Home == true && Key == KeyEvent.VK_RIGHT && hy > -60 && hx > 400 && hx < 540)
		{
			hx += 20;
			
			Dialogue1 = true;
			Home = false;
			direction = "Right";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Home == true && Key == KeyEvent.VK_LEFT && hy > -60 && hx > 400 && hx < 540)
		{
			hx -= 20;
			
			Dialogue1 = true;
			Home = false;
			direction = "Left";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Key == KeyEvent.VK_SPACE && Dialogue1 == true)
		{
			Dialogue1 = false;
			Home = true;
		}
		
		if(BCity == true && Key == KeyEvent.VK_UP && bcy < 470)
		{
			bcy += 10;
			BCity = false;
			BCity = true;
			
			System.out.print(bcx);
			System.out.print(", ");
			System.out.print(bcy);
			System.out.println();
			direction = "Up";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(BCity == true && Key == KeyEvent.VK_DOWN)
		{
			bcy -= 10;
			BCity = false;
			BCity = true;
			
			System.out.print(bcx);
			System.out.print(", ");
			System.out.print(bcy);
			System.out.println();
			direction = "Down";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(BCity == true && Key == KeyEvent.VK_DOWN && bcy <= -210)
		{
			wmx = 710;
			wmy = 30;
			BCity = false;
			WorldMap = true;
		}
		
		if(BCity == true && Key == KeyEvent.VK_RIGHT)
		{
			bcx -= 10;
			BCity = false;
			BCity = true;
			
			System.out.print(bcx);
			System.out.print(", ");
			System.out.print(bcy);
			System.out.println();
			direction = "Right";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(BCity == true && Key == KeyEvent.VK_RIGHT && bcx <= -850)
		{
			wmx = 540;
			wmy = 180;
			BCity = false;
			WorldMap = true;
		}
		
		if(BCity == true && Key == KeyEvent.VK_LEFT && bcx < 940)
		{
			bcx += 10;
			BCity = false;
			BCity = true;
			
			System.out.print(bcx);
			System.out.print(", ");
			System.out.print(bcy);
			System.out.println();
			direction = "Left";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(BCity == true && Key == KeyEvent.VK_DOWN && bcy < 40 && bcx < -430 && bcx > -620)
		{
			bcy += 20;
			
			Dialogue2 = true;
			BCity = false;
			direction = "Down";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(BCity == true && Key == KeyEvent.VK_RIGHT && bcy < 40 && bcx < -430 && bcx > -620)
		{
			bcx += 20;
			
			Dialogue2 = true;
			BCity = false;
			direction = "Right";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(BCity == true && Key == KeyEvent.VK_LEFT && bcy < 40 && bcx < -430 && bcx > -620)
		{
			bcx -= 20;
			
			Dialogue2 = true;
			BCity = false;
			direction = "Left";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Key == KeyEvent.VK_SPACE && Dialogue2 == true)
		{
			Dialogue2 = false;
			BCity = true;
		}
		
		if(BCity == true && Key == KeyEvent.VK_DOWN && bcy < 130 && bcx < 540 && bcx > 430)
		{
			bcy += 20;
			
			Dialogue3 = true;
			BCity = false;
			direction = "Down";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(BCity == true && Key == KeyEvent.VK_RIGHT && bcy < 130 && bcx < 540 && bcx > 430)
		{
			bcx += 20;
			
			Dialogue3 = true;
			BCity = false;
			direction = "Right";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(BCity == true && Key == KeyEvent.VK_LEFT && bcy < 130 && bcx < 540 && bcx > 430)
		{
			bcx -= 20;
			
			Dialogue3 = true;
			BCity = false;
			direction = "Left";
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
		}
		
		if(Key == KeyEvent.VK_SPACE && Dialogue3 == true)
		{
			Dialogue3 = false;
			Dialogue4 = true;
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
		}
		
		if(Key == KeyEvent.VK_SPACE && Dialogue4 == true)
		{
			Dialogue4 = false;
			BCity = true;
		}
		
		if(BCity == true && Key == KeyEvent.VK_LEFT && bcy > 280 && bcx < 680 && bcx > 560)
		{
			bcx -= 20;
			
			Dialogue5 = true;
			BCity = false;
			direction = "Left";
			W += 1;
		}
		
		if(BCity == true && Key == KeyEvent.VK_RIGHT && bcy > 280 && bcx < 680 && bcx > 560)
		{
			bcx += 20;
			
			Dialogue5 = true;
			BCity = false;
			direction = "Right";
			W += 1;
		}
		
		if(BCity == true && Key == KeyEvent.VK_UP && bcy > 280 && bcx < 680 && bcx > 560)
		{
			bcy -= 20;
			
			Dialogue5 = true;
			BCity = false;
			direction = "Up";
			W += 1;
		}
		
		if(Key == KeyEvent.VK_SPACE && Dialogue5 == true)
		{
			Dialogue5 = false;
			BCity = true;
		}
		
		if(K226A == true && K226A1 == true)
		{
			K226A = false;
			K226A1 = true;
			System.out.println("K226A1");
		}
		
		//If going from K226A1 to K226A2:
		if(K226A1 == true && Key == KeyEvent.VK_RIGHT)
		{
			K226A1 = false;
			K226A = false;
			ka1x -= 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = true;
			direction = "Right";
			try {
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			for(int i=1; i < 58; i++)
			{
				ka1x -= 10;
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
				K226A = false;
				K226A = true;
				try {
					Thread.sleep(38);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			direction = "Down";
			
			for(int i=1; i < 50; i++)
			{
				ka1y -= 10;
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
				K226A = false;
				K226A = true;
				try {
					Thread.sleep(38);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			direction = "Right";
			
			for(int i=1; i < 85; i++)
			{
				ka1x -= 10;
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
				K226A = false;
				K226A = true;
				try {
					Thread.sleep(38);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			direction = "Down";
			
			for(int i=1; i < 96; i++)
			{
				ka1y -= 10;
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
				K226A = false;
				K226A = true;
				try {
					Thread.sleep(38);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			Key = KeyEvent.VK_DOWN;
			K226A2 = true;
			K226A1 = false;
			System.out.println("K226A2");
		}
		
		//If going from K226A1 to K226A3:
		if(K226A1 == true && Key == KeyEvent.VK_DOWN)
		{
			K226A1 = false;
			K226A = false;
				ka1y -= 10;
				W += 1;
			if (W > 20)
			{
				W = 1;
			}
				K226A = true;
				direction = "Down";
				try 
				{
						Thread.sleep(38);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
			
				for(int i=1; i < 90; i++)
				{
					ka1y -= 10;
					W += 1;
				if (W > 20)
				{
					W = 1;
				}
					K226A = false;
					K226A = true;
					try 
					{
						Thread.sleep(38);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			K226A3 = true;
			K226A1 = false;
			Key = KeyEvent.VK_LEFT;
			System.out.println("K226A3");
		}
		
		//If leaving K226:
		if(K226A1 == true && Key == KeyEvent.VK_LEFT)
		{
				K226A = false;
	  	K226A1 = false;
	  	wmx = 220;
	  	wmy = 250;
	  	WorldMap = true;
		}
		
		if(K226A == true && K226A2 == true)
		{
			K226A = false;
			K226A2 = true;
		}
		
		//If going from K226A2 to K226A1:
		if(K226A2 == true && Key == KeyEvent.VK_UP)
		{
			K226A2 = false;
			K226A = false;
			
			direction = "Up";
			
			for(int i=1; i < 96; i++)
		{
			ka1y += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try {
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
			
			direction = "Left";
			
			for(int i=1; i < 85; i++)
		{
			ka1x += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try {
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
			
			direction = "Up";
			
			for(int i=1; i < 50; i++)
		{
			ka1y += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try {
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
			
			direction = "Left";
			
			ka1x += 20;
			W += 1;
		if (W > 20)
		{
			W = 1;
		}
			K226A = true;
			try {
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			for(int i=1; i < 58; i++)
			{
				ka1x += 10;
				W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try {
					Thread.sleep(38);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			direction = "Down";
			
			K226A2 = false;
			K226A = false;
			K226A1 = true;
			System.out.println("K226A1");
		}
		
		if(K226A == true && K226A3 == true)
		{
			K226A = false;
			K226A3 = true;
		}
		
		//If going from K226A3 to K226A1:
		if(K226A3 == true && Key == KeyEvent.VK_UP)
		{
			direction = "Up";
			K226A3 = false;
					K226A = false;
	  		ka1y += 10;
	  		W += 1;
			if (W > 20)
			{
				W = 1;
			}
	  		K226A = true;
	  		try 
	  		{
	  				Thread.sleep(38);
	  			} catch (InterruptedException e1) {
	  				e1.printStackTrace();
	  			}
	  	
	  		for(int i=1; i < 90; i++)
	  		{
	  			ka1y += 10;
	  			W += 1;
				if (W > 20)
				{
					W = 1;
				}
	  			K226A = false;
	  			K226A = true;
	  			try 
	  			{
	  				Thread.sleep(38);
	  			} catch (InterruptedException e1) {
	  				e1.printStackTrace();
	  			}
	  		}
	  	K226A3 = false;
	  	K226A = false;
	  	K226A1 = true;
	  	System.out.println("K226A1");
	  	Key = 0;
		}
		
		//If going from K226A3 to K226A4
		if(K226A3 == true && Key == KeyEvent.VK_DOWN)
		{
				K226A3 = false;
				K226A = false;
	  	
	  		for(int i=1; i < 76; i++)
	  		{
	  			direction = "Down";
	  			ka1y -= 10;
	  			W += 1;
				if (W > 20)
				{
					W = 1;
				}
	  			K226A = false;
	  			K226A = true;
	  			try 
	  			{
	  				Thread.sleep(38);
	  			} catch (InterruptedException e1) {
	  				e1.printStackTrace();
	  			}
	  		}
	  	K226A = true;
	  	K226A4 = true;
		}
		
		if(K226A == true && K226A4 == true)
		{
			K226A = false;
			K226A4 = true;
		}
		
		//Going from K226A3 to K226A4:
		if(K226A3 == true && Key == KeyEvent.VK_RIGHT)
		{
				K226A3 = false;
				K226A = false;
	  	
		 for(int i=1; i < 82; i++)
		{
			 	direction = "Right";
			 	ka1x -= 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try 
			{
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}	
				
				for(int i=1; i < 76; i++)
	  	{
					direction = "Down";
						ka1y -= 10;
	  			W += 1;
				if (W > 20)
				{
					W = 1;
				}
	  			K226A = false;
	  			K226A = true;
	  			try 
	  			{
	  				Thread.sleep(38);
	  			} catch (InterruptedException e1) {
	  				e1.printStackTrace();
	  			}
	  		}
				
		 for(int i=1; i < 82; i++)
		{
			 	direction = "Left";
			 	ka1x += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try 
			{
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		 	Key = KeyEvent.VK_LEFT;
		 	K226A = false;
	  	K226A4 = true;
		}
		
		//If going from K226A4 to K226A3:
		if(K226A4 == true && Key == KeyEvent.VK_UP)
		{
				K226A4 = false;
				K226A = false;
	  	
	  		for(int i=1; i < 76; i++)
	  		{
	  			direction = "Up";
	  			ka1y += 10;
	  			W += 1;
				if (W > 20)
				{
					W = 1;
				}
	  			K226A = false;
	  			K226A = true;
	  			try 
	  			{
	  				Thread.sleep(38);
	  			} catch (InterruptedException e1) {
	  				e1.printStackTrace();
	  			}
	  		}
	  	K226A = false;
	  	K226A3 = true;
		}
		
		//If going from K226A4 to K226A3:
		if(K226A4 == true && Key == KeyEvent.VK_RIGHT)
		{
				K226A4 = false;
				K226A = false;
	  	
				direction = "Right";
		 for(int i=1; i < 82; i++)
		{
			ka1x -= 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try 
			{
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		 
		direction = "Up";
		for(int i=1; i < 76; i++)
		{
			ka1y += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try 
			{
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
				
		direction = "Left";
		 	for(int i=1; i < 82; i++)
		{
			ka1x += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try 
			{
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}	
				
		 	direction = "Down";
	  	K226A = false;
	  	K226A3 = true;
		}
		
		//If going from K226A2 to K226A5:
		if(K226A2 == true && Key == KeyEvent.VK_RIGHT)
		{
			K226A2 = false;
			K226A = false;
			direction = "Right";
			
			for(int i=1; i < 50; i++)
		{
			ka1x -= 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try
			{
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
			
			Key = KeyEvent.VK_DOWN;
			K226A2 = false;
			K226A = false;
			K226A5 = true;
			System.out.println("K226A5");
		}
		
		//If going from K226A5 to K226A2:
		if(K226A5 == true && Key == KeyEvent.VK_LEFT)
		{
			K226A5 = false;
			K226A = false;
			direction = "Left";
			
			for(int i=1; i < 50; i++)
		{
			ka1x += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try
			{
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
			
			Key = KeyEvent.VK_DOWN;
			K226A5 = false;
			K226A = false;
			K226A2 = true;
			System.out.println("K226A2");
		}
		
		if(K226A5 == true && Key == KeyEvent.VK_UP && pointlessPacket == false)
		{
			K226A5 = false;
			K226A = false;
			direction = "Up";
			
			for(int i=1; i < 85; i++)
		{
			ka1y += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try
			{
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
			direction = "Right";
			
			for(int i=1; i < 58; i++)
		{
			ka1x -= 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try
			{
				Thread.sleep(38);
			} catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
		}
			
			Key = KeyEvent.VK_DOWN;
			direction = "Up";
			K226A5 = false;
			K226A = false;
			K226A7 = true;
			System.out.println("K226A7");
		}
		
		if(K226A5 == true && Key == KeyEvent.VK_RIGHT)
		{
			K226A5 = false;
			K226A = false;
			direction = "Right";
			
			for(int i=1; i < 40; i++)
				{
					ka1x -= 10;
					W += 1;
					if (W > 20)
					{
						W = 1;
					}
					K226A = false;
					K226A = true;
					try {
						Thread.sleep(38);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			direction = "Down";
			
			
			for(int i=1; i < 98; i++)
	  		{
	  			ka1y -= 10;
	  			W += 1;
	  			if (W > 20)
	  			{
	  				W = 1;
	  			}
	  			K226A = false;
	  			K226A = true;
	  			try {
	  				Thread.sleep(38);
	  			} catch (InterruptedException e1) {
	  				// TODO Auto-generated catch block
	  				e1.printStackTrace();
	  			}
	  		}
			direction = "Left";
			
			
			for(int i=1; i < 130; i++)
	 		{
	 			ka1x += 10;
	 			W += 1;
	 			if (W > 20)
	 			{
	 				W = 1;
	 			}
	 			K226A = false;
	 			K226A = true;
	 			try {
	 				Thread.sleep(38);
	 			} catch (InterruptedException e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
	 		}
			direction = "Down";
			
			
			for(int i=1; i < 45; i++)
			{
				ka1y -= 10;
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
				K226A = false;
				K226A = true;
				try {
					Thread.sleep(38);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			Key = KeyEvent.VK_DOWN;
			K226A = false;
			K226A6 = true;
		}
		
		if(K226A7 == true && Key == KeyEvent.VK_1 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			attack = true;
			AITurn = true;
			K226A7 = false;
			K226A7 = true;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 200;
			EnemyHp -= 500;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			attack = false;
			K226A7 = false;
			AITurn = false;
			UserTurn = true;
 			K226A7 = true;
		}
		
		if(K226A7 == true && Key == KeyEvent.VK_2 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Fire";
			effectiveness = "It's super effective!";
			fire = true;
			AITurn = true;
			K226A7 = false;
			K226A7 = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			fire = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 200;
			EnemyHp -= 2000;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226A7 = false;
			AITurn = false;
			UserTurn = true;
 			K226A7 = true;
		}
		
		if(K226A7 == true && Key == KeyEvent.VK_3 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Ice";
			effectiveness = "It's not very effective!";
			ice = true;
			AITurn = true;
			K226A7 = false;
			K226A7 = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ice = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 200;
			EnemyHp -= 250;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226A7 = false;
			AITurn = false;
			UserTurn = true;
 			K226A7 = true;
		}
		
		if(K226A7 == true && Key == KeyEvent.VK_4 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Thunder";
			thunder = true;
			AITurn = true;
			K226A7 = false;
			K226A7 = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			thunder = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 200;
			EnemyHp -= 1000;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226A7 = false;
			AITurn = false;
			UserTurn = true;
 			K226A7 = true;
		}
		
		if(K226A7 == true && EnemyHp <= 0)
		{
		UserHp = 5000;
		UserMp = 100;
		HP = Integer.toString(UserHp);
		MP = Integer.toString(UserMp);
		playerMove = "";
		effectiveness = "";
		EnemyHp = 10000;
			EHP = Integer.toString(EnemyHp);
			fire = false;
			ice = false;
		thunder = false;
		attack = false;
		pointlessPacket = true;
			K226A7 = false;
			K226A = false;
			direction = "Left";
			
			for(int i=1; i < 58; i++)
		{
			ka1x += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try {
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			direction = "Down";
			
			for(int i=1; i < 85; i++)
		{
			ka1y -= 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try {
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
			Key = KeyEvent.VK_DOWN;
			direction = "Down";
			K226A7 = false;
			K226A = false;
			K226A5 = true;
			System.out.println("K226A5");
		}
		
		if(K226A6 == true && Key == KeyEvent.VK_UP)
		{
			K226A6 = false;
			K226A = false;
			direction = "Up";
			
			for(int i=1; i < 45; i++)
			{
				ka1y += 10;
				W += 1;
				if (W > 20)
				{
					W = 1;
				}
				K226A = false;
				K226A = true;
				try {
					Thread.sleep(38);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			direction = "Right";
			
			for(int i=1; i < 130; i++)
	 		{
	 			ka1x -= 10;
	 			W += 1;
	 			if (W > 20)
	 			{
	 				W = 1;
	 			}
	 			K226A = false;
	 			K226A = true;
	 			try {
	 				Thread.sleep(38);
	 			} catch (InterruptedException e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
	 		}
			direction = "Up";
			
			for(int i=1; i < 98; i++)
	  		{
	  			ka1y += 10;
	  			W += 1;
	  			if (W > 20)
	  			{
	  				W = 1;
	  			}
	  			K226A = false;
	  			K226A = true;
	  			try {
	  				Thread.sleep(38);
	  			} catch (InterruptedException e1) {
	  				// TODO Auto-generated catch block
	  				e1.printStackTrace();
	  			}
	  		}
			direction = "Left";
			
			for(int i=1; i < 40; i++)
				{
					ka1x += 10;
					W += 1;
					if (W > 20)
					{
						W = 1;
					}
					K226A = false;
					K226A = true;
					try {
						Thread.sleep(38);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			K226A = false;
			K226A5 = true;
		}
		
		if(K226A6 == true && Key == KeyEvent.VK_RIGHT && uselessNoPhoneSign == false)
		{
			K226A6 = false;
			direction = "Right";
			
			for(int i=1; i < 42; i++)
				{
					ka1x -= 10;
					W += 1;
					if (W > 20)
					{
						W = 1;
					}
					K226A = false;
					K226A = true;
					try {
						Thread.sleep(38);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			K226A = false;
			K226A8 = true;
		}
		
		if(K226A8 == true && Key == KeyEvent.VK_1 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			attack = true;
			AITurn = true;
			K226A8 = false;
			K226A8 = true;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 500;
			EnemyHp -= 500;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			attack = false;
			K226A8 = false;
			AITurn = false;
			UserTurn = true;
 			K226A8 = true;
		}
		
		if(K226A8 == true && Key == KeyEvent.VK_2 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Fire";
			fire = true;
			AITurn = true;
			K226A8 = false;
			K226A8 = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			fire = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 500;
			EnemyHp -= 1000;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226A8 = false;
			AITurn = false;
			UserTurn = true;
 			K226A8 = true;
		}
		
		if(K226A8 == true && Key == KeyEvent.VK_3 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Ice";
			effectiveness = "It's not very effective.";
			ice = true;
			AITurn = true;
			K226A8 = false;
			K226A8 = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ice = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 500;
			EnemyHp -= 250;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226A8 = false;
			AITurn = false;
			UserTurn = true;
 			K226A8 = true;
		}
		
		if(K226A8 == true && Key == KeyEvent.VK_4 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Thunder";
			effectiveness = "It's super effective!";
			thunder = true;
			AITurn = true;
			K226A8 = false;
			K226A8 = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			thunder = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 500;
			EnemyHp -= 2000;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226A8 = false;
			AITurn = false;
			UserTurn = true;
 			K226A8 = true;
		}
		
		if(K226A8 == true && EnemyHp <= 0)
		{
		UserHp = 5000;
		UserMp = 100;
		HP = Integer.toString(UserHp);
		MP = Integer.toString(UserMp);
		playerMove = "";
		effectiveness = "";
		EnemyHp = 10000;
		EHP = Integer.toString(EnemyHp);
		fire = false;
		ice = false;
		thunder = false;
		attack = false;
		uselessNoPhoneSign = true;
		K226A8 = false;
		K226A = false;
		direction = "Left";
			
		for(int i=1; i < 42; i++)
		{
			ka1x += 10;
			W += 1;
			if (W > 20)
			{
				W = 1;
			}
			K226A = false;
			K226A = true;
			try {
				Thread.sleep(38);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
			Key = KeyEvent.VK_DOWN;
			K226A8 = false;
			K226A = false;
			K226A6 = true;
			System.out.println("K226A6");
		}
		
		if(K226A6 == true && Key == KeyEvent.VK_LEFT)
		{
			K226A6 = false;
			K226A = false;
			direction = "Left";
			
			for(int i=1; i < 101; i++)
				{
					ka1x += 10;
					W += 1;
					if (W > 20)
					{
						W = 1;
					}
					K226A = false;
					K226A = true;
					try {
						Thread.sleep(38);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			direction = "Up";
			
			for(int i=1; i < 40; i++)
				{
					ka1y += 10;
					W += 1;
					if (W > 20)
					{
						W = 1;
					}
					K226A = false;
					K226A = true;
					try {
						Thread.sleep(38);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			try {
				Thread.sleep(16000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			K226A = false;
			f1 = true;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f1 = false;
			f2 = true;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f2 = false;
			f3 = true;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f3 = false;
			f4 = true;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			f4 = false;
			K226B = true;
		}
		
		if(K226B == true && Key == KeyEvent.VK_1 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			attack = true;
			AITurn = true;
			K226B = false;
			K226B = true;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 500;
			EnemyHp -= 500;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			attack = false;
			K226B = false;
			AITurn = false;
			UserTurn = true;
			K226B = true;
		}
		
		if(K226B == true && Key == KeyEvent.VK_2 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Fire";
			fire = true;
			AITurn = true;
			K226B = false;
			K226B = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			fire = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 500;
			EnemyHp -= 1000;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226B = false;
			AITurn = false;
			UserTurn = true;
 			K226B = true;
		}
		
		if(K226B == true && Key == KeyEvent.VK_3 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Ice";
			effectiveness = "It's super effective!";
			ice = true;
			AITurn = true;
			K226B = false;
			K226B = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ice = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 500;
			EnemyHp -= 2000;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226B = false;
			AITurn = false;
			UserTurn = true;
 			K226B = true;
		}
		
		if(K226B == true && Key == KeyEvent.VK_4 && UserMp > 0 && UserHp > 0 && EnemyHp > 0)
		{
			UserTurn = false;
			playerMove = "Thunder";
			effectiveness = "It's not very effective.";
			thunder = true;
			AITurn = true;
			K226B = false;
			K226B = true;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			thunder = false;
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserHp -= 500;
			EnemyHp -= 250;
			UserMp -= 20;
			HP = Integer.toString(UserHp);
			MP = Integer.toString(UserMp);
			EHP = Integer.toString(EnemyHp);
			playerMove = "";
			effectiveness = "";
			K226B = false;
			AITurn = false;
			UserTurn = true;
 			K226B = true;
		}
		
		if(K226B == true && EnemyHp <= 0)
		{
			titleScreen = false;
			levelOne = false;
			WorldMap = false;
			Home = false;
			BCity = false;
			K226A = false;
			K226A1 = false;
			K226A2 = false;
			K226A3 = false;
			K226A4 = false;
			K226A5 = false;
			K226A6 = false;
			K226A7 = false;
			K226A8 = false;
			K226B = false;
			Dialogue1 = false;
			Dialogue2 = false;
			Dialogue3 = false;
			Dialogue4 = false;
			Dialogue5 = false;
			win = true;
		}
		
		if(UserHp <= 0)
		{
			titleScreen = false;
			levelOne = false;
			WorldMap = false;
			Home = false;
			BCity = false;
			K226A = false;
			K226A1 = false;
			K226A2 = false;
			K226A3 = false;
			K226A4 = false;
			K226A5 = false;
			K226A6 = false;
			K226A7 = false;
			K226A8 = false;
			K226B = false;
			Dialogue1 = false;
			Dialogue2 = false;
			Dialogue3 = false;
			Dialogue4 = false;
			Dialogue5 = false;
			GameOver = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		frame.setVisible(false);
		frame.dispose();
		isRunning = false;
	}

	@Override
	public void windowClosed(WindowEvent e) {
		while(true){

			if(isDone){
				System.exit(0);
			}
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void run() {
		while(isRunning){

			draw();

			if(change){
				setChange(false);

			}
			try{Thread.sleep(32);}
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		isDone = true;
	}

	private void title(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.setColor(Color.YELLOW);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 10F));
		g2d.drawString("Banana Quest Two", 450, 400);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * .5F));
		g2d.drawString("The Pointless Sequel!", 650, 500);
		g2d.drawImage(banana1, 1300, 250, null);
		g2d.drawImage(banana2, 250, 250, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * .1F));
		g2d.drawString("Press Space to begin.", 850, 800);
	}
	
	private void levelOne(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(banana1, 1300, 250, null);
		g2d.drawImage(banana2, 250, 250, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Even after the events of the first Banana Quest...", 450, 300);
		g2d.drawString("The Evil Dragon King, Mr. Hudson, continued his reign of terror on the world.", 450, 325);
		g2d.drawString("He even did the unthinkable:", 450, 350);
		g2d.drawString("He outlawed text-based adventures!", 450, 375);
		g2d.drawString("Now you, the player, will have to save the world and bring back text-based adventeurs!", 450, 400);
		wmx = 70;
		wmy = 150;
	}
	
	private void WorldMap(Graphics2D g2d)
	{
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(worldMap, wmx, wmy, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCUp, 900, 450, null);
		}
		if (direction == "Up" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCUpW1, 900, 450, null);
		}
		if (direction == "Up" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCUpW2, 900, 450, null);
		}
		if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCDown, 900, 450, null);
		}
		if (direction == "Down" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
		if (direction == "Down" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCDownW2, 900, 450, null);
		}
		if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCLeft, 900, 450, null);
		}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCLeftW, 900, 450, null);
		}
		if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
		{
			g2d.drawImage(PCRight, 900, 450, null);
		}
		if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCRightW, 900, 450, null);
		}
	}
	
	private void Home(Graphics2D g2d)
	{
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(House, hx, hy, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCUp, 900, 450, null);
		}
		if (direction == "Up" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCUpW1, 900, 450, null);
		}
		if (direction == "Up" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCUpW2, 900, 450, null);
		}
		if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCDown, 900, 450, null);
		}
		if (direction == "Down" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
		if (direction == "Down" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCDownW2, 900, 450, null);
		}
		if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCLeft, 900, 450, null);
		}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCLeftW, 900, 450, null);
		}
		if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
		{
			g2d.drawImage(PCRight, 900, 450, null);
		}
		if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCRightW, 900, 450, null);
		}
	}
	
	private void Dialogue1(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(350, 700, 1200, 250);
		g2d.drawImage(banana1, 1300, 600, null);
		g2d.drawImage(banana2, 250, 600, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Your mom:", 450, 750);
		g2d.drawString("\"All young children need to go on dangerous adventeurs to save the world!", 450, 775);
		g2d.drawString("It said so on TV!", 450, 800);
		g2d.drawString("Well then, off you go now!\"", 450, 825);
	}
	
	private void Plantano(Graphics2D g2d)
	{
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(Plantano, bcx, bcy, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCUp, 900, 450, null);
		}
		if (direction == "Up" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCUpW1, 900, 450, null);
		}
		if (direction == "Up" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCUpW2, 900, 450, null);
		}
		if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCDown, 900, 450, null);
		}
		if (direction == "Down" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
		if (direction == "Down" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCDownW2, 900, 450, null);
		}
		if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCLeft, 900, 450, null);
		}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCLeftW, 900, 450, null);
		}
		if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
		{
			g2d.drawImage(PCRight, 900, 450, null);
		}
		if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCRightW, 900, 450, null);
		}
	}
	
	private void Dialogue2(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(350, 700, 1200, 250);
		g2d.drawImage(banana1, 1300, 600, null);
		g2d.drawImage(banana2, 250, 600, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Fat Guy:", 450, 750);
		g2d.drawString("\"Technology is incredible!\"", 450, 775);
	}
	
	private void Dialogue3(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(350, 700, 1200, 250);
		g2d.drawImage(banana1, 1300, 600, null);
		g2d.drawImage(banana2, 250, 600, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Beard Guy:", 450, 750);
		g2d.drawString("\"Gee! This guy'd better hope bad dialogue doesn't count against his grade!", 450, 775);
		g2d.drawString("Otherwise, I'm pretty sure this project's earned a zero!", 450, 800);
		g2d.drawString("LOL!\"", 450, 825);
	}
	
	private void Dialogue4(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(350, 700, 1200, 250);
		g2d.drawImage(fourthwall, 600, 200, null);
		g2d.drawImage(banana1, 1300, 600, null);
		g2d.drawImage(banana2, 250, 600, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Brett:", 450, 750);
		g2d.drawString("\"Aaaand... there goes the fourth wall.", 450, 775);
		g2d.drawString("Thanks a lot!\"", 450, 800);
	}
		
	private void Dialogue5(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(350, 700, 1200, 250);
		g2d.drawImage(banana1, 1300, 600, null);
		g2d.drawImage(banana2, 250, 600, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Lady:", 450, 750);
		g2d.drawString("\"Why are there only, like, 8 people in this world?\"", 450, 775);
	}
	
	private void K226A(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(K226, ka1x, ka1y, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCUp, 900, 450, null);
		}
		if (direction == "Up" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCUpW1, 900, 450, null);
		}
		if (direction == "Up" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCUpW2, 900, 450, null);
		}
		if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCDown, 900, 450, null);
		}
		if (direction == "Down" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
		if (direction == "Down" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCDownW2, 900, 450, null);
		}
		if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCLeft, 900, 450, null);
		}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCLeftW, 900, 450, null);
		}
		if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
		{
			g2d.drawImage(PCRight, 900, 450, null);
		}
		if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCRightW, 900, 450, null);
		}
}	
	
	private void K226A1(Graphics2D g2d){
			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, SIZE.width, SIZE.height);
			g2d.drawImage(K226, ka1x, ka1y, null);
			if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
			{
				g2d.drawImage(PCUp, 900, 450, null);
			}
			if (direction == "Up" && W >= 6 && W <= 10)
			{
				g2d.drawImage(PCUpW1, 900, 450, null);
			}
			if (direction == "Up" && W >= 16 && W <= 20)
			{
				g2d.drawImage(PCUpW2, 900, 450, null);
			}
			if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
			{
				g2d.drawImage(PCDown, 900, 450, null);
			}
			if (direction == "Down" && W >= 6 && W <= 10)
			{
				g2d.drawImage(PCDownW1, 900, 450, null);
			}
			if (direction == "Down" && W >= 16 && W <= 20)
			{
				g2d.drawImage(PCDownW2, 900, 450, null);
			}
			if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
			{
				g2d.drawImage(PCLeft, 900, 450, null);
			}
			if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
			{
				g2d.drawImage(PCLeftW, 900, 450, null);
			}
			if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
			{
				g2d.drawImage(PCRight, 900, 450, null);
			}
			if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
			{
				g2d.drawImage(PCRightW, 900, 450, null);
			}
			g2d.drawImage(LeftArrow, 855, 520, null);
			g2d.drawImage(RightArrow, 1025, 520, null);
			g2d.drawImage(DownArrow, 955, 635, null);
			g2d.fillRect(350, 100, 1200, 250);
			g2d.drawImage(banana1, 1300, 0, null);
			g2d.drawImage(banana2, 250, 0, null);
			g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
			g2d.setColor(Color.YELLOW);
			g2d.drawString("Which way will you go?", 450, 150);
			g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * .5F));
			g2d.setColor(Color.BLACK);
			g2d.drawString("Exit", 880, 547);
	}
	
	private void K226A2(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(K226, ka1x, ka1y, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCUp, 900, 450, null);
		}
		if (direction == "Up" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCUpW1, 900, 450, null);
		}
		if (direction == "Up" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCUpW2, 900, 450, null);
		}
		if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCDown, 900, 450, null);
		}
		if (direction == "Down" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
		if (direction == "Down" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCDownW2, 900, 450, null);
		}
		if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCLeft, 900, 450, null);
		}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCLeftW, 900, 450, null);
		}
		if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
		{
			g2d.drawImage(PCRight, 900, 450, null);
		}
		if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCRightW, 900, 450, null);
		}
		g2d.drawImage(RightArrow, 1025, 520, null);
		g2d.drawImage(UpArrow, 945, 375, null);
		g2d.fillRect(350, 100, 1200, 250);
		g2d.drawImage(banana1, 1300, 0, null);
		g2d.drawImage(banana2, 250, 0, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Which way will you go?", 450, 150);
}
	private void K226A3(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(K226, ka1x, ka1y, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCUp, 900, 450, null);
		}
		if (direction == "Up" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCUpW1, 900, 450, null);
		}
		if (direction == "Up" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCUpW2, 900, 450, null);
		}
		if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCDown, 900, 450, null);
		}
		if (direction == "Down" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
		if (direction == "Down" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCDownW2, 900, 450, null);
		}
		if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCLeft, 900, 450, null);
		}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCLeftW, 900, 450, null);
		}
		if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
		{
			g2d.drawImage(PCRight, 900, 450, null);
		}
		if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCRightW, 900, 450, null);
		}
		g2d.drawImage(RightArrow, 1025, 520, null);
		g2d.drawImage(DownArrow, 945, 635, null);
		g2d.drawImage(UpArrow, 945, 375, null);
		g2d.fillRect(350, 100, 1200, 250);
		g2d.drawImage(banana1, 1300, 0, null);
		g2d.drawImage(banana2, 250, 0, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Which way will you go?", 450, 150);
}
	private void K226A4(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(K226, ka1x, ka1y, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCUp, 900, 450, null);
		}
		if (direction == "Up" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCUpW1, 900, 450, null);
		}
		if (direction == "Up" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCUpW2, 900, 450, null);
		}
		if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCDown, 900, 450, null);
		}
		if (direction == "Down" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
		if (direction == "Down" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCDownW2, 900, 450, null);
		}
		if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCLeft, 900, 450, null);
		}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCLeftW, 900, 450, null);
		}
		if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
		{
			g2d.drawImage(PCRight, 900, 450, null);
		}
		if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCRightW, 900, 450, null);
		}
		g2d.drawImage(RightArrow, 1025, 520, null);
		g2d.drawImage(UpArrow, 945, 375, null);
		g2d.fillRect(350, 100, 1200, 250);
		g2d.drawImage(banana1, 1300, 0, null);
		g2d.drawImage(banana2, 250, 0, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Which way will you go?", 450, 150);
}
	
	private void K226A5(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(K226, ka1x, ka1y, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
			{
				g2d.drawImage(PCUp, 900, 450, null);
			}
			if (direction == "Up" && W >= 6 && W <= 10)
			{
				g2d.drawImage(PCUpW1, 900, 450, null);
			}
			if (direction == "Up" && W >= 16 && W <= 20)
		{
				g2d.drawImage(PCUpW2, 900, 450, null);
			}
			if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
			{
				g2d.drawImage(PCDown, 900, 450, null);
			}
			if (direction == "Down" && W >= 6 && W <= 10)
			{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
			if (direction == "Down" && W >= 16 && W <= 20)
			{
				g2d.drawImage(PCDownW2, 900, 450, null);
			}
			if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
			{
				g2d.drawImage(PCLeft, 900, 450, null);
			}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
			{
				g2d.drawImage(PCLeftW, 900, 450, null);
			}
			if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
			{
				g2d.drawImage(PCRight, 900, 450, null);
			}
			if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
				g2d.drawImage(PCRightW, 900, 450, null);
			}
		g2d.drawImage(RightArrow, 1025, 520, null);
		if (pointlessPacket == false)
		{
			g2d.drawImage(UpArrow, 945, 375, null);
		}
		g2d.drawImage(LeftArrow, 855, 520, null);
		g2d.fillRect(350, 100, 1200, 250);
		g2d.drawImage(banana1, 1300, 0, null);
		g2d.drawImage(banana2, 250, 0, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Which way will you go?", 450, 150);
}
	
	private void K226A6(Graphics2D g2d)
	{
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(K226, ka1x, ka1y, null);
		if (direction == "Up" && W <= 5 || direction == "Up" && W >= 11 && W <= 15)
			{
				g2d.drawImage(PCUp, 900, 450, null);
			}
		if (direction == "Up" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCUpW1, 900, 450, null);
		}
		if (direction == "Up" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCUpW2, 900, 450, null);
		}
		if (direction == "Down" && W <= 5 || direction == "Down" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCDown, 900, 450, null);
		}
		if (direction == "Down" && W >= 6 && W <= 10)
		{
			g2d.drawImage(PCDownW1, 900, 450, null);
		}
		if (direction == "Down" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCDownW2, 900, 450, null);
		}
		if (direction == "Left" && W <= 5 || direction == "Left" && W >= 11 && W <= 15)
		{
			g2d.drawImage(PCLeft, 900, 450, null);
		}
		if (direction == "Left" && W >= 6 && W <= 10 || direction == "Left" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCLeftW, 900, 450, null);
		}
		if (direction == "Right" && W <= 5 || direction == "Right" && W >= 11 && W<= 15)
		{
		g2d.drawImage(PCRight, 900, 450, null);
		}
		if (direction == "Right" && W >= 6 && W <= 10 || direction == "Right" && W >= 16 && W <= 20)
		{
			g2d.drawImage(PCRightW, 900, 450, null);
		}
		if (uselessNoPhoneSign == false)
		{
			g2d.drawImage(RightArrow, 1025, 520, null);
		}
		g2d.drawImage(UpArrow, 945, 375, null);
		g2d.drawImage(LeftArrow, 855, 520, null);
		g2d.fillRect(350, 100, 1200, 250);
		g2d.drawImage(banana1, 1300, 0, null);
		g2d.drawImage(banana2, 250, 0, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		g2d.drawString("Which way will you go?", 450, 150);
}
	
	private void K226A7(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(K226, ka1x, ka1y, null);
		g2d.drawImage(PCUp, 900, 450, null);
		g2d.fillRect(350, 700, 1200, 250);
		g2d.drawImage(banana1, 1300, 600, null);
		g2d.drawImage(banana2, 250, 600, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		if (UserTurn == true)
		{
			g2d.drawString("Wild POINTLESS PACKET appeared!                                 HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("Press 1 to attack.", 450, 780);
			g2d.drawString("Press 2 to use Fire.", 450, 830);
			g2d.drawString("Press 3 to use Ice.", 450, 880);
			g2d.drawString("Press 4 to use Thunder.", 450, 930);
		}
		if (AITurn == true && attack == false)
		{
			g2d.drawString("Wild POINTLESS PACKET appeared!                                 HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("You use " + playerMove + "!" + " " + effectiveness, 450, 780);
			g2d.drawString("POINTLESS PACKET attacks for 200 damage!", 450, 830);
		}
		if (AITurn == true && attack == true)
		{
			g2d.drawString("Wild POINTLESS PACKET appeared!                                 HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("You attack!", 450, 780);
			g2d.drawString("POINTLESS PACKET attacks for 200 damage!", 450, 830);
		}
		if (fire == true)
		{
			g2d.drawImage(Fire, 900, 250, null);
		}
		if (ice == true)
		{
			g2d.drawImage(Ice, 870, 200, null);
		}
		if (thunder == true)
		{
			g2d.drawImage(Thunder, 910, 170, null);
		}
}
	
	private void K226A8(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(K226, ka1x, ka1y, null);
		g2d.drawImage(PCUp, 900, 450, null);
		g2d.fillRect(350, 700, 1200, 250);
		g2d.drawImage(banana1, 1300, 600, null);
		g2d.drawImage(banana2, 250, 600, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		if (UserTurn == true)
		{
			g2d.drawString("Wild USELESS 'NO PHONE' SIGN appeared!                     HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("Press 1 to attack.", 450, 780);
			g2d.drawString("Press 2 to use Fire.", 450, 830);
			g2d.drawString("Press 3 to use Ice.", 450, 880);
			g2d.drawString("Press 4 to use Thunder.", 450, 930);
		}
		if (AITurn == true && attack == false)
		{
			g2d.drawString("Wild USELESS 'NO PHONE' SIGN appeared!                     HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("You use " + playerMove + "!" + " " + effectiveness, 450, 780);
			g2d.drawString("EVIL DRAGON KING MR. HUDSON attacks for 200 damage!", 450, 830);
		}
		if (AITurn == true && attack == true)
		{
			g2d.drawString("Wild USELESS 'NO PHONE' SIGN appeared!                     HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("You attack!", 450, 780);
			g2d.drawString("EVIL DRAGON KING MR. HUDSON attacks for 200 damage!", 450, 830);
		}
		if (fire == true)
		{
			g2d.drawImage(Fire, 900, 250, null);
		}
		if (ice == true)
		{
			g2d.drawImage(Ice, 870, 200, null);
		}
		if (thunder == true)
		{
			g2d.drawImage(Thunder, 910, 170, null);
		}
}
	
	private void f1(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(FadeOut1, 9, 30, null);
}
	
	private void f2(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(FadeOut2, 9, 30, null);
}
	
	private void f3(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(FadeOut3, 9, 30, null);
}
	
	private void f4(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
}
	
	private void K226B(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(EvilDragonKingMrHudson, 0, -300, null);
		g2d.drawImage(PCUp, 900, 450, null);
		g2d.fillRect(350, 700, 1200, 250);
		g2d.drawImage(banana1, 1300, 600, null);
		g2d.drawImage(banana2, 250, 600, null);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 2F));
		g2d.setColor(Color.YELLOW);
		if (UserTurn == true)
		{
			g2d.drawString("EVIL DRAGON KING MR. HUDSON appeared!                     HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("Press 1 to attack.", 450, 780);
			g2d.drawString("Press 2 to use Fire.", 450, 830);
			g2d.drawString("Press 3 to use Ice.", 450, 880);
			g2d.drawString("Press 4 to use Thunder.", 450, 930);
		}
		if (AITurn == true && attack == false)
		{
			g2d.drawString("EVIL DRAGON KING MR. HUDSON appeared!                     HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("You use " + playerMove + "!" + " " + effectiveness, 450, 780);
			g2d.drawString("EVIL DRAGON KING MR. HUDSON attacks for 200 damage!", 450, 830);
		}
		if (AITurn == true && attack == true)
		{
			g2d.drawString("EVIL DRAGON KING MR. HUDSON appeared!                     HP: " + HP + " MP: " + MP + " Enemy HP: " + EHP, 450, 730);
			g2d.drawString("You attack!", 450, 780);
			g2d.drawString("EVIL DRAGON KING MR. HUDSON attacks for 200 damage!", 450, 830);
		}
		if (fire == true)
		{
			g2d.drawImage(Fire, 900, 250, null);
		}
		if (ice == true)
		{
			g2d.drawImage(Ice, 870, 200, null);
		}
		if (thunder == true)
		{
			g2d.drawImage(Thunder, 910, 170, null);
		}
}
	
	private void GameOver(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.setColor(Color.YELLOW);
		g2d.setFont(g2d.getFont().deriveFont(g2d.getFont().getSize() * 15F));
		g2d.drawString("Game Over", 500, 450);
		g2d.drawImage(banana1, 1300, 250, null);
		g2d.drawImage(banana2, 250, 250, null);
	}
	
	private void win(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, SIZE.width, SIZE.height);
		g2d.drawImage(winner, 15, 20, null);
}
	
		//Here you go Mr. Hudson, a comment.
	private void draw() {

		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) imgBuffer.getGraphics();
		
		if (titleScreen)
		{
			title(g2d);
		}
		else if(levelOne)
		{
			levelOne(g2d);
		}
		else if(WorldMap)
		{
			WorldMap(g2d);
		}
		else if (Home)
		{
			Home(g2d);
		}
		else if (Dialogue1)
		{
			Dialogue1(g2d);
		}
		else if (BCity)
		{
			Plantano(g2d);
		}
		else if (Dialogue2)
		{
			Dialogue2(g2d);
		}
		else if (Dialogue3)
		{
			Dialogue3(g2d);
		}
		else if (Dialogue4)
		{
			Dialogue4(g2d);
		}
		else if (Dialogue5)
		{
			Dialogue5(g2d);
		}
		else if (K226A)
		{
			K226A(g2d);
		}
		else if (K226A1)
		{
			K226A1(g2d);
		}
		else if (K226A2)
		{
			K226A2(g2d);
		}
		else if (K226A3)
		{
			K226A3(g2d);
		}
		else if (K226A4)
		{
			K226A4(g2d);
		}
		else if (K226A5)
		{
			K226A5(g2d);
		}
		else if (K226A6)
		{
			K226A6(g2d);
		}
		else if (K226A7)
		{
			K226A7(g2d);
		}
		else if (K226A8)
		{
			K226A8(g2d);
		}
		else if (f1)
		{
			f1(g2d);
		}
		else if (f2)
		{
			f2(g2d);
		}
		else if (f3)
		{
			f3(g2d);
		}
		else if (f4)
		{
			f4(g2d);
		}
		else if (K226B)
		{
			K226B(g2d);
		}
		else if (GameOver)
		{
			GameOver(g2d);
		}
		else if (win)
		{
			win(g2d);
		}
		
		if(isRunning)
			g2d = (Graphics2D) frame.getGraphics();
		g2d.drawImage(imgBuffer, 0,  0, SIZE.width, SIZE.height, 0, 0, SIZE.width, SIZE.height, null);
		g2d.dispose();
	}
}