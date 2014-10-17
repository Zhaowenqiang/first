package jianzhu.daxue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FishDemo {
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame() ;
		MyPanel p = new MyPanel() ;
		frame.add(p) ;
		frame.setSize(800, 500) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		frame.setVisible(true) ;
		frame.setResizable(false) ;
		frame.setLocationRelativeTo(null) ;
		p.action() ;
		//frame.setLocation(300,200) ;
	}
}
class MyPanel extends JPanel{
	BufferedImage bg ;
	Fish[] fish = new Fish[11];
	int score ;
	public MyPanel() throws IOException{
		bg = ImageIO.read(new File("pic/bg.jpg")) ;
		for(int i=0;i<11;i++){
			fish[i] = new Fish((i+1<10)?"fish0"+(i+1):"fish"+(i+1)) ;
		}
	}
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null) ;
		g.setColor(Color.RED) ;
		g.setFont(new Font("¿¬Ìå",Font.BOLD,20)) ;
		g.drawString("×Ü·Ö£º", 40, 60) ;
		for(int i=0;i<fish.length;i++){
			g.drawImage(fish[i].fishPic, fish[i].x, fish[i].y, null) ;
		}
	}
	public void action(){
		while(true){
			for(int i=0;i<fish.length;i++){
				fish[i].fishMove() ;
			}
			repaint() ;
			try {
				Thread.sleep(20) ;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Fish{
	BufferedImage fishPic ;
	BufferedImage[] fishPics ;
	int x, y, width, height , index, step;
	Random rand = new Random() ;
	public Fish(String name) throws IOException{
		fishPics = new BufferedImage[10] ;
		for(int i=0;i<10;i++){
			fishPics[i] = ImageIO.read(new File("pic/"+name+"_"+(i+1)+".png")) ;
		}
		fishPic = fishPics[0] ;
		width = fishPic.getWidth() ;
		height = fishPic.getHeight() ;
		x = rand.nextInt(800) - width ;
		y = rand.nextInt(500) - height ;
		step = rand.nextInt(10) + 4 ;
	}
	public void fishMove(){
		fishPic = fishPics[index++%fishPics.length] ;
		x-=step ;
		if(x <= -width){
			getout() ;
		}else{}
	}
	public void getout(){
		x = 800 ;
		y = rand.nextInt(500) - height ;
	}
}
class Net{
	public Net(){
		
	}
	public void netMove(){
		
	}
	public boolean catchFish(Fish f){
		return true ;
	}
}