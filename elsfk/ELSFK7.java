import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;
import javax.swing.SwingConstants ;
import java.util.* ;
import java.io.* ;
import java.lang.Integer ;
class Key1{
	static Object key = new Object();
}
class Canvas1 extends Canvas implements Runnable{
	Paint p1 ;
	private int[] x,y,upDatex,upDatey;
	static Thread th;
	private int time = 300 ;
	private	int tempTime = 10 ;
	private boolean pt = true;
	boolean[][] bool ;
	private Boolean1 boo ;
	private Object key = new Object();
	private int score = 0 ;
	int[] rndLast ;
	int temp;
	Dialog dia = null ;
	JTextArea text ;
	JButton but1 ;
	JButton but2 ;
	String s ;
	int i ;
	static boolean b = true ;
 	int time1[] = {300,250,200,150,130,127,125} ;
	int t = 0;
	public int[] getRnd(){
		Random random = new Random() ;
	    int rnd[] = {random.nextInt(7),random.nextInt(4)} ; 
		rndLast = rnd ;
		return rnd ;
	}
	String name[] = {"无","无","无","赵文强","张赛","无","无","张赛","张赛"};
	int maxScore[] = {0,0,0,13200,7000,0,0,45900,17700} ;
	public void setName(String n,int i){
	    this.name[i] = n ;
	}
	public void setMaxScore(int s,int i){
	    this.maxScore[i] = s ;
	}
	public String getName(int i){
	    return this.name[i] ;
	}
	public int getMaxScore(int i){
	    return this.maxScore[i] ;
	}
	public void setScore(int score){
	    this.score = score ;
	}
	public int getScore(){
	    return this.score ;
	}
	public void setPt(boolean pt){
	    this.pt = pt ;
	}
	public boolean getPt(){
	    return this.pt ;
	}
	public Object getKey(){
	    return this.key ;
	}
	public Thread getTh(){
	    return this.th ;
	}
	public void setTh(Thread th){
	    this.th = th ;
	}
	public Canvas1(Boolean1 boo){
	    this.boo = boo ;
		this.bool = boo.getBool() ;
		p1 = new GradientPaint(10,10,Color.blue,10,10,Color.blue) ;
	}
	public void setTime(int time){
		if(pt){
			this.time = time ;
		}else{
		    this.tempTime = time ;
		}
	}
	public int getTime(){
		if(pt){
			return this.time ;
		}else{
		    return this.tempTime ;
		}
	}
	public void setx(int[] x){
	    this.x = x ;
	}
	public void sety(int[] y){
	    this.y = y ;
	}
	public int[] getx(){
	    return this.x ;
	}
	public int[] gety(){
	    return this.y ;
	}
	public void setUpDatex(int[] x){
	    this.upDatex = x ;
	}
	public void setUpDatey(int[] y){
	    this.upDatey = y ;
	}
	public int[] getUpDatex(){
	    return this.upDatex ;
	}
	public int[] getUpDatey(){
	    return this.upDatey ;
	}
	public boolean stop(int[] x1 ,int[] y1){
		for(int i=0;i<4;i++){
			if(y1[i]>0){
			if(bool[(x1[i]-10)/20][(y1[i]-10)/20]){
				return bool[(x1[i]-10)/20][(y1[i]-10)/20] ;
			}
			}
		}
		return false ;
	}
	public void change(int[] x1,int[] y1){
	    for(int i=0;i<4;i++){
			if(y1[i]>0){
				boo.setBool((x1[i]-10)/20,(y1[i]-10)/20,true) ;
			}
		}
	}
	public void delete(){
		boolean[] b = boo.getB() ;
	    for(int j=0;j<24;j++){
			int t = 0 ;
		    for(int i=0;i<15;i++){
			    if(bool[i][j]){
					t++ ;
				}
				if(t==15){
				    b[j] = true ;
				}
			}
		}
		int count = 0 ;
		for(int i=0;i<b.length;i++){
		    if(b[i]){
				boolean[][] bo0 = new boolean[15][24] ;
			    for(int l=1;l<24;l++){
				    for(int r=0;r<15;r++){
			            if(l<=i){
			 			    bo0[r][l] = bool[r][l-1] ;
						}else{
							bo0[r][l] = bool[r][l] ;
						}
					}
				}
				count++ ;
				boo.setBool(bo0) ;
				bool = boo.getBool() ;
			}
		}
		switch(count){
		    case 1 : setScore(getScore() + 100*Integer.valueOf(ELSFK.lab3.getText()).intValue()) ; break ;
			case 2 : setScore(getScore() + 300*Integer.valueOf(ELSFK.lab3.getText()).intValue()) ; break ;
			case 3 : setScore(getScore() + 600*Integer.valueOf(ELSFK.lab3.getText()).intValue()) ; break ;
			case 4 : setScore(getScore() + 1000*Integer.valueOf(ELSFK.lab3.getText()).intValue()) ; break ;
			case 0 : setScore(getScore() + 0*Integer.valueOf(ELSFK.lab3.getText()).intValue()) ; break ;
		}
		String s = String.valueOf(getScore()) ;
		ELSFK.lab5.setText(s) ;
	}
	public void moveUp(int[] gx,int[] gy){
		setUpDatex(gx) ;
		setUpDatey(gy) ;
		double cx = gx[2] ;
		double cy = gy[2] ;
		int[] x = new int[4] ;
		int[] y = new int[4] ;
		
	    for(int i = 0;i<4;i++){
			if(gx[i] - cx == -20 && gy[i] - cy == -20){
			    x[i] = gx[i] ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == -20){
			    x[i] = gx[i] - 20 ;
				y[i] = gy[i] + 20 ;
			}else if(gx[i] - cx == -20 && gy[i] - cy == 0){
			    x[i] = gx[i] + 20 ;
				y[i] = gy[i] + 20 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == 20){
			    x[i] = gx[i] + 20 ;
				y[i] = gy[i] - 20 ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == 0){
			    x[i] = gx[i] - 20 ;
				y[i] = gy[i] - 20 ;
			}else if(gx[i] - cx == -20 && gy[i] - cy == 20){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == 20){
			    x[i] = gx[i] ;
				y[i] = gy[i] - 40 ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == -20){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == 40){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] - 40 ;
			}else if(gx[i] - cx == -40 && gy[i] - cy == 0){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == -40){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 40 && gy[i] - cy == 0){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] - 40 ;
			}else if (gx[i] - cx == 0 && gy[i] - cy == 0){
			    x[i] = gx[i] ;
				y[i] = gy[i] ;
			}else{
			    System.out.println("出错了" + gx[i] + ";" + cx + "," + gy[i] + "," + cy) ;
			}
			
			if(x[i]-10 < 0 || y[i] + 10 > 475 || x[i] + 10 > 300){
			    return ;
			}
		}
		setx(x) ;
		sety(y) ;
		repaint() ;
	}
	public void gameOver(){
		i = 7 ;
		if(!ELSFK.model1){
		    s = "训练模式" + ELSFK.lab3.getText() ;
		}else if(ELSFK.model2){
		    s = "模式一" ;
		}else{
		    s = "模式二" ;
		}
		if(s.equals("训练模式" + ELSFK.lab3.getText())){
		    i = Integer.valueOf(ELSFK.lab3.getText()).intValue() - 1;
		}else if(s.equals("模式一")){
		    i = 7 ;
		}else{
		    i = 8 ;
		}
	    JLabel lab0 = new JLabel(s + "游戏结束") ;
        JLabel lab1 = new JLabel("本次得分") ;
	    JLabel lab2 = new JLabel(String.valueOf(getScore())) ;
	    JLabel lab3 = new JLabel("最高分") ;
		JLabel lab4 = new JLabel(getName(i)) ;
		JLabel lab5 = new JLabel(String.valueOf(getMaxScore(i))) ;
		JLabel lab6 = new JLabel("恭喜你打破记录") ;
		JLabel lab7 = new JLabel("请输入你的姓名") ;
		text = new JTextArea() ;
		dia = Dialog1.getDia() ;
		dia.setTitle("游戏结束") ;
		dia.setLayout(null) ;
		lab0.setBounds(40,40,80,20) ;
		lab1.setBounds(40,60,80,20) ;
		lab2.setBounds(40,80,80,20) ;
		lab3.setBounds(40,100,80,20) ;
		lab4.setBounds(40,120,80,20) ;
		lab5.setBounds(40,140,80,20) ;
		but1 = new JButton("确认") ;
		but2 = new JButton("取消") ;
		dia.add(lab0) ;
		dia.add(lab1) ;
		dia.add(lab2) ;
		dia.add(lab3) ;
		dia.add(lab4) ;
		dia.add(lab5) ;
		if(getScore()>getMaxScore(i)){
		    lab6.setBounds(40,160,80,20) ;
			lab7.setBounds(40,180,80,20) ;
			text.setBounds(40,200,80,20) ;
			text.setRows(1) ;
			but1.setBounds(20,220,60,20) ;
			but2.setBounds(90,220,60,20) ;
			dia.add(lab6) ;
			dia.add(lab7) ;
			dia.add(text) ;
			dia.add(but1) ;
			dia.add(but2) ;
			but1.addActionListener(new ActionListener(){
			     public void actionPerformed(ActionEvent e){
					 if(e.getSource() == but1){
					     setName(text.getText()) ;
						 setMaxScore(getScore(),i) ;
						 ELSFK.lab6.setText("最高分："+String.valueOf(getScore())) ;
						 dia.dispose() ;
					 }
				 }
			}) ;
			but2.addActionListener(new ActionListener(){
				 public void actionPerformed(ActionEvent e){
				     if(e.getSource() == but2){
					     dia.dispose() ;
					 }
		     	 }
	    	}) ;
		}
		dia.setBackground(Color.lightGray) ;
		dia.setVisible(true) ;
		dia.setBounds(300,200,150,250) ;
	    dia.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
	            dia.dispose() ;
			}
	    });
	}
	public void start(){
        int[][] x = {{130,150,150,170},{110,130,150,170},{130,150,150,130},{150,150,130,130},{130,130,150,150},{130,130,130,150},{150,150,150,130}} ;
		int[][] y = {{-10,-10,-30,-10},{-10,-10,-10,-10},{-30,-30,-10,-10},{-10,-30,-30,-50},{-10,-30,-30,-50},{-10,-30,-50,-50},{-10,-30,-50,-50}} ; 
        int[][] upDatex = {{130,150,150,170},{110,130,150,170},{130,150,150,130},{150,150,130,130},{130,130,150,150},{130,130,130,150},{150,150,150,130}} ;
		int[][] upDatey = {{-10,-10,-30,-10},{-10,-10,-10,-10},{-30,-30,-10,-10},{-10,-30,-30,-50},{-10,-30,-30,-50},{-10,-30,-50,-50},{-10,-30,-50,-50}} ;
		this.setx(x[rndLast[0]]) ;
		this.sety(y[rndLast[0]]) ;
		this.setUpDatex(upDatex[rndLast[0]]) ;
		this.setUpDatey(upDatey[rndLast[0]]) ;
		if(ELSFK.model1){
		if(ELSFK.model2){
		if(t == 100){
		    t = 0 ;
			if(getTime()<=250 && getTime()>200){
			    ELSFK.lab3.setText("2") ;
		    }else if(getTime()<=200 && getTime()>150){
     			ELSFK.lab3.setText("3") ;
	    	}else if(getTime()<=150 && getTime()>130){
    			ELSFK.lab3.setText("4") ;
    		}else if(getTime()<=130 && getTime()>127){
     			ELSFK.lab3.setText("5") ;
    		}else if(getTime()<=127 && getTime()>125){
    			ELSFK.lab3.setText("6") ;
    		}else if(getTime()<=125){
    			ELSFK.lab3.setText("7") ;
	    	}
		}
		}else{
		if(getScore()>=1000 && getScore()<3000 && Integer.valueOf(ELSFK.lab3.getText()).intValue() <= 1){
			pt = true ;
		    setTime(time1[1]) ;
			ELSFK.lab3.setText("2") ;
		}else if(getScore()>=3000 && getScore()<6000 && Integer.valueOf(ELSFK.lab3.getText()).intValue()<=2){
		    pt = true ;
			setTime(time1[2]) ;
			ELSFK.lab3.setText("3") ;
		}else if(getScore()>=6000 && getScore()<10000 && Integer.valueOf(ELSFK.lab3.getText()).intValue()<=3){
		    pt = true ;
			setTime(time1[3]) ;
			ELSFK.lab3.setText("4") ;
		}else if(getScore()>=10000 && getScore()<20000 && Integer.valueOf(ELSFK.lab3.getText()).intValue()<=4){
		    pt = true ;
			setTime(time1[4]) ;
			ELSFK.lab3.setText("5") ;
		}else if(getScore()>=20000 && getScore()<40000 && Integer.valueOf(ELSFK.lab3.getText()).intValue()<=5){
		    pt = true ;
			setTime(time1[5]) ;
			ELSFK.lab3.setText("6") ;
		}else if(getScore()>=40000 && +Integer.valueOf(ELSFK.lab3.getText()).intValue()<=6){
		    pt = true ;
			setTime(time1[6]) ;
			ELSFK.lab3.setText("7") ;
		}
		}
	    }
		for(int i=0;i<rndLast[1];i++){
		    moveUp(this.getx(),this.gety()) ;
		}
		if(th == null){
		    int[] y1 = new int[4] ;
			th = new Thread(this) ;
			for(int i = 0;i<4;i++){
				y1[i] = this.gety()[i] + 20 ;
			}
			if(stop(this.getx(),y1) ){
				gameOver() ;
				return ;
			}
		    th.start() ;
		}
	}
	public void run(){
		synchronized(Key1.key){
	    while(true){
			if(b){
			int a = 0 ;
		    int[] y1 = new int[4] ;
			setUpDatex(this.getx()) ;
			setUpDatey(this.gety()) ;
			for(int i = 0;i<4;i++){
				y1[i] = this.gety()[i] + 20 ;
			}
			for(int i = 0;i<4;i++){
			    if(y1[i] + 10 >= 500){
					try{
						th.interrupt() ;
					}catch(Exception e){} ;
					change(this.getx(),this.gety()) ;
					th = null ;
					a = 1 ;
					break ;
				}
			}
			if(a == 1){break ;}
			if(stop(this.getx(),y1)){
				try{
					th.interrupt() ;
				}catch(Exception e){} ;
				change(this.getx(),this.gety()) ;
				th = null ;
				break ;
			}
			this.sety(y1) ;
			delete() ;
			Key1.key.notify() ;
			try{
			    Thread.sleep(this.getTime()) ;
				repaint() ;
			}catch(Exception e){} ;
		}else{
		    return ;
		}
		}
		t++ ;
		}
	}
	public void update(Graphics g){
		if(th != null){
		/*g.fillRect(this.getUpDatex()[1]-10,this.getUpDatey()[1]-10,20,20) ;
		g.fillRect(this.getUpDatex()[2]-10,this.getUpDatey()[2]-10,20,20) ;
		g.fillRect(this.getUpDatex()[3]-10,this.getUpDatey()[3]-10,20,20) ;
		g.fillRect(this.getUpDatex()[0]-10,this.getUpDatey()[0]-10,20,20) ;*/
	    paint(g) ;
		}
	}
	public void paint(Graphics g2){
		Image buffer = createImage(300,480) ;
		Graphics g = buffer.getGraphics() ;		
		for(int i=0;i<bool.length;i++){
		    for(int j=0;j<bool[i].length;j++){
				g.setColor(ELSFK.color02[0]) ;
				g.fill3DRect(20*i,20*j,20,20,true) ;
			    if(bool[i][j]){
					g.setColor(ELSFK.color02[5]) ;
				    g.fillRoundRect(20*i,20*j,20,20,10,10) ;
				}
			}
		}
		if(th != null){
		g.setColor(ELSFK.color02[1]) ;
		g.fillRoundRect(x[1]-10,y[1]-10,20,20,10,10) ;
		g.setColor(ELSFK.color02[2]) ;
		g.fillRoundRect(x[2]-10,y[2]-10,20,20,10,10) ;
		g.setColor(ELSFK.color02[3]) ;
		g.fillRoundRect(x[3]-10,y[3]-10,20,20,10,10) ;
		g.setColor(ELSFK.color02[4]) ;
		g.fillRoundRect(x[0]-10,y[0]-10,20,20,10,10) ;
		}
		g2.drawImage(buffer,0,0,this) ;
	}
}
class Canvas2 extends Canvas{
	static int[][] x = {{30,50,50,70},{10,30,50,70},{30,50,50,30},{50,50,30,30},{30,30,50,50},{30,30,30,50},{50,50,50,30}} ;
	static int[][] y = {{70,70,50,70},{50,50,50,50},{50,50,70,70},{90,70,70,50},{90,70,70,50},{90,70,50,50},{90,70,50,50}} ; 
    static int[][] upDatex = {{30,50,50,70},{10,30,50,70},{30,50,50,30},{50,50,30,30},{30,30,50,50},{30,30,30,50},{50,50,50,30}} ;
    static int[][] upDatey = {{70,70,50,70},{50,50,50,50},{50,50,70,70},{90,70,70,50},{90,70,70,50},{90,70,50,50},{90,70,50,50}} ; 
	private static int[] x1 ;
	private static int[] y1 ;
	private static int[] upDatex1 ;
	private static int[] upDatey1 ;
	public static void setx1(int[] rnd){
	    x1 = rnd ;
	}
	public static void sety1(int[] rnd){
	    y1 = rnd ;
	}
	public int[] getx1(){
	    return x1 ;
	}
	public int[] gety1(){
	    return y1 ;
	}
	public static void setUpDatex1(int[] rnd){
	    upDatex1 = rnd ;
	}
	public static void setUpDatey1(int[] rnd){
	    upDatey1 = rnd ;
	}
	public int[] getUpDatex1(){
	    return upDatex1 ;
	}
	public int[] getUpDatey1(){
	    return upDatey1 ;
	}
	public void paint(Graphics g2){
    Image buffer = createImage(100,100) ;
    Graphics g = buffer.getGraphics() ;
	g.setColor(ELSFK.color02[0]) ;
	for(int i=0;i<5;i++){
	    for(int j=0;j<5;j++){
			g.fill3DRect(20*i,20*j,20,20,true) ;
		}
	}
	g.setColor(ELSFK.color02[1]) ;
	g.fill3DRect(getx1()[1]-10,gety1()[1]-10,20,20,true) ;
	g.setColor(ELSFK.color02[2]) ;
	g.fill3DRect(getx1()[2]-10,gety1()[2]-10,20,20,true) ;
	g.setColor(ELSFK.color02[3]) ;
	g.fill3DRect(getx1()[3]-10,gety1()[3]-10,20,20,true) ;
	g.setColor(ELSFK.color02[4]) ;
	g.fill3DRect(getx1()[0]-10,gety1()[0]-10,20,20,true) ;
	g2.drawImage(buffer,0,0,this) ;
	}
	public void update(Graphics g){
		g.fillRect(getUpDatex1()[1]-10,getUpDatey1()[1]-10,20,20) ;
		g.fillRect(getUpDatex1()[2]-10,getUpDatey1()[2]-10,20,20) ;
		g.fillRect(getUpDatex1()[3]-10,getUpDatey1()[3]-10,20,20) ;
		g.fillRect(getUpDatex1()[0]-10,getUpDatey1()[0]-10,20,20) ;
	    paint(g) ;
	}
}
class Boolean1{
	private static boolean[][] bool = new boolean[15][24] ;
	public boolean[] getB(){
	    boolean[] b = new boolean[24] ;
		for(int i=0;i<b.length;i++){
		    b[i] = false ;
		}
		return b ;
	}
	public void setBool(boolean[][] bool){
	    for(int i=0;i<bool.length;i++){
		    for(int j=0;j<bool[i].length;j++){
			    this.bool[i][j] = bool[i][j] ;
			}
		}
	}
	public boolean[][] getBool(){
	    return this.bool ;
	}
	public void setBool(int i,int j, boolean bool){
	    this.bool[i][j] = bool ;
	}
	public boolean getBool(int i,int j){
	    return this.bool[i][j] ;
	}
}
class Dialog1{
	static JFrame frame = new JFrame() ;
	static Dialog dia = new Dialog(frame,false) ;
	public static Dialog getDia(){
		dia.dispose() ;
		dia.removeAll() ;
	    return dia ;
	}
}
class ELSFK extends JFrame implements Runnable,SwingConstants{
	private MenuBar j1 = null;
	private Menu jcb1 = null ;
	private Menu jcb2 = null ;
	private Menu jcb3 = null ;
	private Menu jcb4 = null ;
	private Menu gameControl = null ;
	private Menu gameModel = null ;
	private Container cont = getContentPane() ;
	private Canvas1 can1 ;
	static Thread thread ;
	boolean b = true ;
	private boolean[][] bool ;
    private Boolean1 boo = new Boolean1() ;
	JPanel pan1 ;
	JPanel pan2 ;
	JLabel lab1 ;
	Canvas2 can2 ;
	JLabel lab2 ;
	static JLabel lab3 ;
	JLabel lab4 ;
	static JLabel lab5 ;
	static JLabel lab6 ;
	static JLabel lab7 ;
	static boolean model1 = true ;
	static boolean model2 = true ;
	JButton but1 ;
	JButton but2 ;
	JButton but3 ;
	JButton but4 ;
	JButton but5 ;
	private MenuItem modelMenu1 = null ;
	private MenuItem modelMenu2 = null ;
	private MenuItem modelMenu3 = null ;
	private MenuItem newGame = null ;
	private MenuItem maxScore = null ;
	private MenuItem start = null ;
	private MenuItem stop = null ;
	private MenuItem gameOver = null ;
	private MenuItem addHard = null ;
	private MenuItem close = null ;
	private MenuItem reduceHard = null ;
	private MenuItem revovle = null ;
	private MenuItem left = null ;
	private MenuItem right = null ;
	private MenuItem down = null ;
	private MenuItem background = null ;
	private MenuItem color1 = null ;
	private MenuItem color2 = null ;
	private MenuItem color3 = null ;
	private MenuItem color4 = null ;
	private MenuItem acolor = null ;
	private MenuItem allControl = null ;
	private MenuItem allColor = null ;
	private MenuItem aboutGame = null ;
	private MenuItem rule = null ;
	static String control[] = {"Z","X","C","A","S","Up","Left","Right","Down","Q"} ;
	static Color color01[] = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,Color.lightGray,Color.magenta,Color.orange,Color.pink,Color.red,Color.white,Color.yellow} ;
	static Color color02[] = {Color.darkGray,Color.blue,Color.blue,Color.blue,Color.blue,Color.blue } ;
	Color[] color03 = new Color[6] ;
	String color[] = {"黑色","蓝色","青色","深灰色","灰色","绿色","浅灰色","洋红色","桔黄色","粉红色","红色","白色","黄色"} ;
	Dialog dia ;
	JTextArea text ;
	JList list  ;
	String s ;
	String s1 ;
	String[] sc = new String[10] ;
	JButton button1 = null ;
	JButton button2 = null ;
	JTextArea[] text1 = new JTextArea[10] ;
	JTextArea[] text2 = new JTextArea[6] ;
	String[] sc2 = new String[6] ;
	int time[] = {300,250,200,150,130,127,125} ;
	public void actionPerformed1(){
		Canvas1.b = true ; 
		b = true ;
		if(can1.getTh() == null){
			can1.setScore(0) ;
			lab5.setText("0") ;
			start() ;
		}else{
		    can1.getTh().interrupt() ;
			can1.setTh(null) ;
			thread = null ;
			init() ;
			if(model1){
			   can1.setTime(time[0]) ;
			   lab3.setText("1") ;
			}
			can1.repaint() ;
			can1.setScore(0) ;
			lab5.setText("0") ;
			can1.start() ;
			start() ;
			}
		but1.setText("重新开始") ;
	}
    public void actionPerformed2(){
		if(can1.getTh() != null){
			but1.setText("继续游戏") ;
		    can1.getTh().interrupt() ;
			Canvas1.b = false ; 
		    can1.setTh(null) ;
			thread = null ;
			b = false ;
		}
	};
    public void actionPerformed3(){
		if(can1.getTh() != null){
			can1.getTh().interrupt() ;
		    can1.setTh(null) ;
			thread = null ;
			Canvas1.b = false ; 
			b = false ;
		}
		can1.gameOver() ;
		init() ;
		if(model1){
			can1.setTime(time[0]) ;
			lab3.setText("1") ;
		}
		but1.setText("开始") ;
    };
	public void actionPerformed4(){
		if(model1||can1.getTh()==null){
		    String s = lab3.getText() ;
		    int d =-1 ;
		    try{
			    d = Integer.valueOf(s).intValue() ;
		    }catch(Exception e){} ;
		    d++ ;
		    if(d > 0 && d < 8){
		        can1.setTime(time[d - 1]) ;
			    lab3.setText(String.valueOf(d)) ;
		    }
		}
		if(!model1){
		   lab7.setText("训练模式" + ELSFK.lab3.getText()) ;
		   lab6.setText("最高分:"+String.valueOf(can1.getMaxScore(Integer.valueOf(ELSFK.lab3.getText()).intValue() - 1))) ;
		}
	};
	public void actionPerformed5(){
		if(model1||can1.getTh()==null){
			if(!model1||can1.getTh()==null){
		        String s = lab3.getText() ;
		        int d =-1 ;
		        try{
			        d = Integer.valueOf(s).intValue() ;
		        }catch(Exception e){} ;
		        d-- ;
		        if(d > 0 && d < 8){
		            can1.setTime(time[d - 1]) ;
			        lab3.setText(String.valueOf(d)) ;
		        }
			}
		}
		if(!model1){
		   lab7.setText("训练模式" + ELSFK.lab3.getText()) ;
		   lab6.setText("最高分:"+String.valueOf(can1.getMaxScore(Integer.valueOf(ELSFK.lab3.getText()).intValue() - 1))) ;
		}
    };
	public void init(){
	    for(int i=0;i<bool.length;i++){
		    for(int j=0;j<bool[i].length;j++){
			    bool[i][j] = false ;
			}
		}
	}
	public void run(){
		synchronized(Key1.key){
			while(true){
				if(b){
			        if(can1.getTh() != null){
				       try{
					   int[] rnd = can1.getRnd() ;
		               Canvas2.setx1(Canvas2.x[rnd[0]]) ;
		               Canvas2.sety1(Canvas2.y[rnd[0]]) ;
		               Canvas2.setUpDatex1(Canvas2.upDatex[rnd[0]]) ;
		               Canvas2.setUpDatey1(Canvas2.upDatey[rnd[0]]) ;
		               for(int i=0;i<rnd[1];i++){
		                   moveUp(can2.getx1() ,can2.gety1()) ;
		               }
	                   can2.repaint() ;
				       Key1.key.wait() ;
				       }catch(Exception e){}
			           }else{
				       can1.setPt(true) ;
				       can1.start() ;
			        }
			     }else{
				     return ;
				 }
			}
		}
	}
	public void start(){
	    if(thread == null){
			thread = new Thread(this) ;
			thread.start() ;
		}
	}
	public void setLab(String s){
	    lab5.setText(s) ;
	}
	public ELSFK(){
		super.setTitle("俄罗斯方块") ;
		bool = boo.getBool() ;
		init() ;
		can1 = new Canvas1(boo) ;
		jcb1 = new Menu("游戏") ;
		jcb2 = new Menu("控制") ;
		jcb3 = new Menu("游戏风格") ;
		jcb4 = new Menu("信息") ;
		gameControl = new Menu("游戏控制") ;
		gameModel = new Menu("游戏模式") ;
	    newGame = new MenuItem("新游戏") ;
	    maxScore = new MenuItem("最高分") ;
	    start = new MenuItem("开始") ;
        stop = new MenuItem("暂停") ;
	    gameOver = new MenuItem("终止游戏") ;
	    addHard = new MenuItem("增加难度") ;
	    reduceHard = new MenuItem("降低难度") ;
	    close = new MenuItem("关闭对话框") ;
	    revovle = new MenuItem("旋转") ;
	    left = new MenuItem("向左") ;
	    right = new MenuItem("向右") ;
	    down = new MenuItem("向下") ;
	    background = new MenuItem("背景颜色") ;
	    color1 = new MenuItem("方块1颜色") ;
	    color2 = new MenuItem("方块2颜色") ;
	    color3 = new MenuItem("方块3颜色") ;
	    color4 = new MenuItem("方块4颜色") ;
	    acolor = new MenuItem("方块固定后颜色") ;
	    allControl = new MenuItem("所有控制") ;
	    allColor = new MenuItem("所有颜色") ;
        aboutGame = new MenuItem("关于游戏") ;
        modelMenu1 = new MenuItem("训练模式") ;
        modelMenu2 = new MenuItem("模式一") ;
        modelMenu3 = new MenuItem("模式二") ;
	    rule = new MenuItem("游戏积分方式") ;
		modelMenu1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			    model1 = false ;
				model2 = true ;
				lab7.setText("训练模式" + ELSFK.lab3.getText()) ;
				lab6.setText("最高分:"+String.valueOf(can1.getMaxScore(Integer.valueOf(ELSFK.lab3.getText()).intValue() - 1))) ;
			}
		}) ;
		modelMenu2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			    model1 = true ;
				model2 = true ;
				lab7.setText("模式一") ;
			    lab6.setText("最高分:"+String.valueOf(can1.getMaxScore(7))) ;
		    }
		}) ;
		modelMenu3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			    model1 = true ;
				model2 = false ;
				lab7.setText("模式二") ;
				lab6.setText("最高分:"+String.valueOf(can1.getMaxScore(8))) ;
			}
		}) ;
		maxScore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int i = 7 ;
		        if(!ELSFK.model1){
		            s = "训练模式" + ELSFK.lab3.getText() ;
		        }else if(ELSFK.model2){
		            s = "模式一" ;
		        }else{
		            s = "模式二" ;
		        }if(s.equals("训练模式" + ELSFK.lab3.getText())){
		            i = Integer.valueOf(ELSFK.lab3.getText()).intValue() - 1;
		        }else if(s.equals("模式一")){
		            i = 7 ;
		        }else{
		            i = 8 ;
		        }
				JLabel lab1 = new JLabel(can1.getName(i)) ;
				JLabel lab2 = new JLabel(s + "最高分") ;
				JLabel lab3 = new JLabel(String.valueOf(can1.getMaxScore(i))) ;
				dia = Dialog1.getDia() ;
				dia.setTitle("最高分") ;
				dia.setLayout(null) ;
				lab1.setBounds(40,50,80,20) ;
				lab2.setBounds(40,75,80,20) ;
				lab3.setBounds(40,100,80,20) ;
				dia.add(lab1) ;
				dia.add(lab2) ;
				dia.add(lab3) ;
				dia.setBackground(Color.lightGray) ;
				dia.setVisible(true) ;
				dia.setBounds(300,200,100,200) ;
			    dia.addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e){
			            dia.dispose() ;
			        }
		        });
			}
		}) ;
		ActionListener action1 = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == start){
				    s = "开始" ;
				}else if(e.getSource() == stop){
				    s = "暂停";
				}else if(e.getSource() == gameOver){
				    s = "终止游戏";
				}else if(e.getSource() == addHard){
				    s = "增加难度";
				}else if(e.getSource() == reduceHard){
				    s = "降低难度";
				}else if(e.getSource() == revovle){
				    s = "旋转";
				}else if(e.getSource() == right){
				    s = "向左";
				}else if(e.getSource() == left){
				    s = "向右";
				}else if(e.getSource() == down){
				    s = "向下";
				}else if(e.getSource() == close){
				    s = "关闭对话框";
				}else{
				    return ;
				}
				JLabel lab = new JLabel("设置"+s+"控键为") ;
				text = new JTextArea() ;
				button1 = new JButton("确认") ;
				button2 = new JButton("取消") ;
				text.addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text.setText(null) ;
				        text.append("选择的控键是：" + KeyEvent.getKeyText(e.getKeyCode()) + "\n") ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						button1.addActionListener(new ActionListener(){
						    public void actionPerformed(ActionEvent ea1){
							    if(ea1.getSource() == button1){
								    if(s.equals("开始")){
				                        control[0] = s1 ;
				                    }else if(s.equals("暂停")){
				                        control[1] = s1;
				                    }else if(s.equals("终止游戏")){
				                        control[2] = s1;
				                    }else if(s.equals("增加难度")){
				                        control[3] = s1;
				                    }else if(s.equals("降低难度")){
				                        control[4] = s1;
				                    }else if(s.equals("旋转")){
				                        control[5] = s1;
				                    }else if(s.equals("向左")){
				                        control[6] = s1;
				                    }else if(s.equals("向右")){
				                        control[7] = s1;
				                    }else if(s.equals("向下")){
				                        control[8] = s1;
				                    }else if(s.equals("关闭对话框")){
				                        control[9] = s1;
				                    } ;
									dia.dispose() ;
								}
							}
						}) ;
					} 
		        }) ;
				button2.addActionListener(new ActionListener(){
				    public void actionPerformed(ActionEvent e){
					    dia.dispose() ;
					}
				}) ;
				dia = Dialog1.getDia() ;
				dia.setTitle("设置"+s+"控键") ;
				dia.setLayout(null) ;
				lab.setBounds(10,30,80,20) ;
				text.setBounds(10,50,120,20) ;
				button1.setBounds(10,80,60,20) ;
				button2.setBounds(80,80,60,20) ;
				text.setRows(1) ;
				dia.add(lab) ;
				dia.add(text) ;
				dia.add(button1) ;
				dia.add(button2) ;
				dia.setBackground(Color.lightGray) ;
				dia.setVisible(true) ;
				dia.setBounds(300,200,100,200) ;
			    dia.addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e){
			            dia.dispose() ;
			        }
		        });
			}
		} ;
		start.addActionListener(action1) ;
		stop.addActionListener(action1) ;
		gameOver.addActionListener(action1) ;
		addHard.addActionListener(action1) ;
		reduceHard.addActionListener(action1) ;
		close.addActionListener(action1) ;
		revovle.addActionListener(action1) ;
		left.addActionListener(action1) ;
		right.addActionListener(action1) ;
		down.addActionListener(action1) ;
		allColor.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
				JLabel lab1 = new JLabel("背景颜色") ;
				JLabel lab2 = new JLabel("方块1颜色") ;
				JLabel lab3 = new JLabel("方块2颜色") ;
				JLabel lab4 = new JLabel("方块3颜色") ;
				JLabel lab5 = new JLabel("方块4颜色") ;
				JLabel lab6 = new JLabel("方块固定后颜色") ;
				text2[0] = new JTextArea() ;
				text2[1] = new JTextArea() ;
				text2[2] = new JTextArea() ;
				text2[3] = new JTextArea() ;
				text2[4] = new JTextArea() ;
				text2[5] = new JTextArea() ;
				dia = Dialog1.getDia() ;
				dia.setTitle("设置所有颜色") ;
				dia.setLayout(null) ;
				list = new JList(color) ;
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION) ;
				list.setBorder(BorderFactory.createTitledBorder("选择的颜色")) ;
			    JFrame frame = Dialog1.frame ;
			    Container cont = frame.getContentPane() ;
				button1 = new JButton("确认") ;
				button2 = new JButton("取消") ;
				JScrollPane span = new JScrollPane(list) ;
				span.setBounds(140,30,120,180) ;
				lab1.setBounds(10,30,60,20) ;
				lab2.setBounds(10,60,60,20) ;
				lab3.setBounds(10,90,60,20) ;
				lab4.setBounds(10,120,60,20) ;
				lab5.setBounds(10,150,60,20) ;
				lab6.setBounds(10,180,70,20) ;
				text2[0].setBounds(80,30,50,20) ;
				text2[1].setBounds(80,60,50,20) ;
				text2[2].setBounds(80,90,50,20) ;
				text2[3].setBounds(80,120,50,20) ;
				text2[4].setBounds(80,150,50,20) ;
				text2[5].setBounds(80,180,50,20) ;
				button1.setBounds(30,210,100,30) ;
				button2.setBounds(140,210,100,30) ;
				dia.add(span) ; 
				dia.add(lab1) ; 
				dia.add(lab2) ; 
				dia.add(lab3) ; 
				dia.add(lab4) ; 
				dia.add(lab5) ; 
				dia.add(lab6) ; 
				dia.add(text2[0]) ; 
				dia.add(text2[1]) ; 
				dia.add(text2[2]) ; 
				dia.add(text2[3]) ; 
				dia.add(text2[4]) ; 
				dia.add(text2[5]) ; 
				dia.add(button1) ; 
				dia.add(button2) ; 
			    dia.setBackground(Color.lightGray) ;
				dia.add(cont) ;
				dia.setVisible(true) ;
				dia.setBounds(300,200,270,250) ;
			    dia.addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e){
			            dia.dispose() ;
			        }
		        });
				for(int i=0;i<6;i++){
					text2[i].setRows(1) ;
				    for(int j=0;j<13;j++){
					    if(color02[i]==color01[j]){
						    text2[i].append(color[j] + "\n") ;
						}
					}
				}
				s = "背景颜色" ; 
				text2[0].addCaretListener(new CaretListener(){
				     public void caretUpdate(CaretEvent e){
					     s = "背景颜色" ;
					 }
				}) ;
				text2[1].addCaretListener(new CaretListener(){
				     public void caretUpdate(CaretEvent e){
					     s = "方块1颜色" ;
					 }
				}) ;
				text2[2].addCaretListener(new CaretListener(){
				     public void caretUpdate(CaretEvent e){
					     s = "方块2颜色" ;
					 }
				}) ;
				text2[3].addCaretListener(new CaretListener(){
				     public void caretUpdate(CaretEvent e){
					     s = "方块3颜色" ;
					 }
				}) ;
				text2[4].addCaretListener(new CaretListener(){
				     public void caretUpdate(CaretEvent e){
					     s = "方块4颜色" ;
					 }
				}) ;
				text2[5].addCaretListener(new CaretListener(){
				     public void caretUpdate(CaretEvent e){
					     s = "方块固定后颜色" ;
					 }
				}) ;
				button1.addActionListener(new ActionListener(){
				     public void actionPerformed(ActionEvent e){
					     for(int i=0;i<6;i++){
							 String s = text2[i].getText();
							 System.out.println(s.trim()) ;
						     for(int j=0;j<13;j++){
							     if(s.trim().equals(color[j])){
								     color02[i] = color01[j] ;
								 }
							 }
						 }
						 dia.dispose() ;
					 }
				}) ;
				button2.addActionListener(new ActionListener(){
				     public void actionPerformed(ActionEvent e){
					     dia.dispose() ;
					 }
				}) ;
			    list.addListSelectionListener(new ListSelectionListener(){
				    public void valueChanged(ListSelectionEvent e){
					    if(e.getSource() == list){
								if(s.equals("背景颜色")){
									text2[0].setText(null) ;
									text2[0].append(color[list.getSelectedIndex()]+"\n" ) ;
						            color03[0] = color01[list.getSelectedIndex()] ;
							    }else if(s.equals("方块1颜色")){
									text2[1].setText(null) ;
									text2[1].append(color[list.getSelectedIndex()]+"\n" ) ;
						            color03[1] = color01[list.getSelectedIndex()] ;
							    }else if(s.equals("方块2颜色")){
									text2[2].setText(null) ;
									text2[2].append(color[list.getSelectedIndex()]+"\n" ) ;
							        color03[2] = color01[list.getSelectedIndex()] ;
							    }else if(s.equals("方块3颜色")){
									text2[3].setText(null) ;
									text2[3].append(color[list.getSelectedIndex()]+"\n" ) ;
								    color03[3] = color01[list.getSelectedIndex()] ;
							    }else if(s.equals("方块4颜色")){
									text2[4].setText(null) ;
									text2[4].append(color[list.getSelectedIndex()]+"\n" ) ;
						            color03[4] = color01[list.getSelectedIndex()] ;
					            }else if(s.equals("方块固定后颜色")){
									text2[5].setText(null) ;
									text2[5].append(color[list.getSelectedIndex()]+"\n" ) ;
				     		        color03[5] = color01[list.getSelectedIndex()] ;
							    }
					    }
				    }
			   }) ;
			}
		}) ;
		ActionListener action2 = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == background){
				    s = "背景颜色" ;
				}else if(e.getSource() == color1){
				    s = "方块1颜色";
				}else if(e.getSource() == color2){
				    s = "方块2颜色";
				}else if(e.getSource() == color3){
				    s = "方块3颜色";
				}else if(e.getSource() == color4){
				    s = "方块4颜色";
				}else if(e.getSource() == acolor){
				    s = "方块固定后颜色";
				}else{
				    return ;
				}
				String color[] = {"黑色","蓝色","青色","深灰色","灰色","绿色","浅灰色","洋红色","桔黄色","粉红色","红色","白色","黄色"} ;
				list = new JList(color) ;	
			    JFrame frame = Dialog1.frame ;
				dia = Dialog1.getDia() ;
				dia.setTitle("设置"+s+"颜色") ;
			    Container cont = frame.getContentPane() ;
				button1 = new JButton("确认") ;
				button2 = new JButton("取消") ;
				JScrollPane span = new JScrollPane(list) ;
				span.setBounds(10,40,130,120) ;
				dia.add(span) ; 
				button1.setBounds(10,160,60,20) ;
				button2.setBounds(80,160,60,20) ;
				dia.add(button1) ;
				dia.add(button2) ;
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION) ;
				list.setBorder(BorderFactory.createTitledBorder("选择"+s+"的颜色")) ;
				list.addListSelectionListener(new ListSelectionListener(){
				     public void valueChanged(ListSelectionEvent e){
					     if(e.getSource() == list){
							 button1.addActionListener(new ActionListener(){
							     public void actionPerformed(ActionEvent e){
								     if(s.equals("背景颜色")){
								         color02[0] = color01[list.getSelectedIndex()] ;
							         }else if(s.equals("方块1颜色")){
								         color02[1] = color01[list.getSelectedIndex()] ;
							         }else if(s.equals("方块2颜色")){
								         color02[2] = color01[list.getSelectedIndex()] ;
							         }else if(s.equals("方块3颜色")){
								         color02[3] = color01[list.getSelectedIndex()] ;
							         }else if(s.equals("方块4颜色")){
								         color02[4] = color01[list.getSelectedIndex()] ;
							         }else if(s.equals("方块固定后颜色")){
								         color02[5] = color01[list.getSelectedIndex()] ;
							         }
									 dia.dispose() ;
								 }
							 }) ; 
						 }	 
					 }
				}) ;
				button2.addActionListener(new ActionListener(){
				    public void actionPerformed(ActionEvent e){
					    dia.dispose() ;
					}
				}) ;
				dia.setBackground(Color.lightGray) ;
				dia.add(cont) ;
				dia.setVisible(true) ;
				dia.setBounds(300,200,150,200) ;
			    dia.addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e){
			            dia.dispose() ;
			        }
		        });
			}
		} ;
		background.addActionListener(action2) ;
		color1.addActionListener(action2) ;
		color2.addActionListener(action2) ;
		color3.addActionListener(action2) ;
		color4.addActionListener(action2) ;
		acolor.addActionListener(action2) ;
		aboutGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text = new JTextArea() ;
				dia = Dialog1.getDia() ;
				dia.setTitle("游戏信息") ;
				text.setBounds(10,30,140,300) ;
				dia.add(text) ;
				text.append("本游戏由"+"\n"+"西建大12级"+"\n"+"电科赵文强"+"\n"+"免费提供" + "\n") ;
				dia.setBackground(Color.lightGray) ;
				dia.setVisible(true) ;
				dia.setBounds(300,200,100,200) ;
			    dia.addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e){
			            dia.dispose() ;
			        }
		        });
			}
		}) ;
		rule.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text = new JTextArea() ;
				dia = Dialog1.getDia() ;
				dia.setTitle("游戏积分方式") ;
				text.setBounds(10,30,140,300) ;
				dia.add(text) ;
				text.append("本游戏积分方式为：" + "\n") ;
				text.append("一次性满一行加100，"+ "\n") ;
				text.append("满两行加300，"+ "\n") ;
				text.append("满三行加600，"+ "\n") ;
				text.append("满四行加1000，"+ "\n") ;
				text.append("再乘以难度系数"+ "\n") ;
				dia.setBackground(Color.lightGray) ;
				dia.setVisible(true) ;
				dia.setBounds(300,200,100,200) ;
			    dia.addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e){
			            dia.dispose() ;
			        }
		        });
			}
		}) ;
		allControl.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			    text1[1] = new JTextArea() ;
				text1[2] = new JTextArea() ;
				text1[3] = new JTextArea() ;
				text1[4] = new JTextArea() ;
				text1[5] = new JTextArea() ;
				text1[6] = new JTextArea() ;
				text1[7] = new JTextArea() ;
				text1[8] = new JTextArea() ;
				text1[9] = new JTextArea() ;
				text1[0] = new JTextArea() ;
				JLabel lab1 = new JLabel("开始控键") ;
				JLabel lab2 = new JLabel("暂停控键") ;
				JLabel lab3 = new JLabel("终止游戏") ;
				JLabel lab4 = new JLabel("增加难度") ;
				JLabel lab5 = new JLabel("降低难度") ;
				JLabel lab6 = new JLabel("关闭对话框") ;
				JLabel lab7 = new JLabel("旋转控键") ;
				JLabel lab8 = new JLabel("向左控键") ;
				JLabel lab9 = new JLabel("向右控键") ;
				JLabel lab10 = new JLabel("向下控键") ;
				button1 = new JButton("确定") ;
				button2 = new JButton("取消") ;
				for(int i=0;i<10;i++){
				    sc[i] = control[i] ;
					text1[i].append(sc[i] + "\n") ;
				}
				text1[0].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[0].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[2])&&!s1.equals(sc[3])&&!s1.equals(sc[4])&&!s1.equals(sc[5])&&!s1.equals(sc[6])&&!s1.equals(sc[7])&&!s1.equals(sc[8])&&!s1.equals(sc[9])){
					        sc[0] = s1 ;
							text1[0].append(s1+"\n") ;
					    }else{
						    text1[0].setText(null) ;
						    text1[0].append(sc[0] + "\n") ;
						}
				    }
		        }) ;
				text1[1].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[1].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[0])&&!s1.equals(sc[2])&&!s1.equals(sc[3])&&!s1.equals(sc[4])&&!s1.equals(sc[5])&&!s1.equals(sc[6])&&!s1.equals(sc[7])&&!s1.equals(sc[8])&&!s1.equals(sc[9])){
					        sc[1] = s1 ;
							text1[1].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[1].append(sc[1]+"\n") ;
						}
				    }
		        }) ;
				text1[2].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[2].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[0])&&!s1.equals(sc[3])&&!s1.equals(sc[4])&&!s1.equals(sc[5])&&!s1.equals(sc[6])&&!s1.equals(sc[7])&&!s1.equals(sc[8])&&!s1.equals(sc[9])){
					        sc[2] = s1 ;
							text1[2].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[2].append(sc[2]+"\n") ;
						}
				    }
		        }) ;
				text1[3].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[3].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[2])&&!s1.equals(sc[0])&&!s1.equals(sc[4])&&!s1.equals(sc[5])&&!s1.equals(sc[6])&&!s1.equals(sc[7])&&!s1.equals(sc[8])&&!s1.equals(sc[9])){
					        sc[3] = s1 ;
							text1[3].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[3].append(sc[3]+"\n") ;
						}
				    }
		        }) ;
				text1[4].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[4].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[2])&&!s1.equals(sc[3])&&!s1.equals(sc[0])&&!s1.equals(sc[5])&&!s1.equals(sc[6])&&!s1.equals(sc[7])&&!s1.equals(sc[8])&&!s1.equals(sc[9])){
					        sc[4] = s1 ;
							text1[4].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[4].append(sc[4]+"\n") ;
						}
				    }
		        }) ;
				text1[5].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[5].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[2])&&!s1.equals(sc[3])&&!s1.equals(sc[4])&&!s1.equals(sc[0])&&!s1.equals(sc[6])&&!s1.equals(sc[7])&&!s1.equals(sc[8])&&!s1.equals(sc[9])){
					        sc[5] = s1 ;
							text1[5].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[5].append(sc[5]+"\n") ;
						}
				    }
		        }) ;
				text1[6].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[6].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[2])&&!s1.equals(sc[3])&&!s1.equals(sc[4])&&!s1.equals(sc[5])&&!s1.equals(sc[0])&&!s1.equals(sc[7])&&!s1.equals(sc[8])&&!s1.equals(sc[9])){
					        sc[6] = s1 ;
							text1[6].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[6].append(sc[6]+"\n") ;
						}
				    }
		        }) ;
				text1[7].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[7].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[2])&&!s1.equals(sc[3])&&!s1.equals(sc[4])&&!s1.equals(sc[5])&&!s1.equals(sc[6])&&!s1.equals(sc[0])&&!s1.equals(sc[8])&&!s1.equals(sc[9])){
					        sc[7] = s1 ;
							text1[7].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[7].append(sc[7]+"\n") ;
						}
				    }
		        }) ;
				text1[8].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[8].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[2])&&!s1.equals(sc[3])&&!s1.equals(sc[4])&&!s1.equals(sc[5])&&!s1.equals(sc[6])&&!s1.equals(sc[7])&&!s1.equals(sc[0])&&!s1.equals(sc[9])){
					        sc[8] = s1 ;
							text1[8].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[8].append(sc[8]+"\n") ;
						}
				    }
		        }) ;
				text1[9].addKeyListener(new KeyAdapter(){
			        public void keyPressed(KeyEvent e){
						text1[9].setText(null) ;
						s1 = KeyEvent.getKeyText(e.getKeyCode()) ;
						if(!s1.equals(sc[1])&&!s1.equals(sc[2])&&!s1.equals(sc[3])&&!s1.equals(sc[4])&&!s1.equals(sc[5])&&!s1.equals(sc[6])&&!s1.equals(sc[7])&&!s1.equals(sc[8])&&!s1.equals(sc[0])){
					        sc[9] = s1 ;
							text1[9].append(KeyEvent.getKeyText(e.getKeyCode())+"\n") ;
					    }else{
						    text1[9].append(sc[9]+"\n") ;
						}
				    }
		        }) ;
				button1.addActionListener(new ActionListener(){
				    public void actionPerformed(ActionEvent e){
					    if(e.getSource() == button1){
						     for(int i=0;i<10;i++){
				                 control[i] = sc[i] ;
				             }
							 dia.dispose() ;
						}
					}
				}) ;
				button2.addActionListener(new ActionListener(){
				    public void actionPerformed(ActionEvent e){
					    dia.dispose() ;
					}
				}) ;
				dia = Dialog1.getDia() ;
				dia.setTitle("设置所有控键") ;
				dia.setLayout(new GridLayout(11,2,5,10)) ;
				dia.add(lab1) ;
				dia.add(text1[0]) ;
				dia.add(lab2) ;
				dia.add(text1[1]) ;
				dia.add(lab3) ;
				dia.add(text1[2]) ;
				dia.add(lab4) ;
				dia.add(text1[3]) ;
				dia.add(lab5) ;
				dia.add(text1[4]) ;
				dia.add(lab6) ;
				dia.add(text1[9]) ;
				dia.add(lab7) ;
				dia.add(text1[5]) ;
				dia.add(lab8) ;
				dia.add(text1[6]) ;
				dia.add(lab9) ;
				dia.add(text1[7]) ;
				dia.add(lab10) ;
				dia.add(text1[8]) ;
				for(int i=0;i<10;i++){
				    text1[i].setRows(1) ;
				}
				dia.add(button1) ;
				dia.add(button2) ;
				dia.setBackground(Color.lightGray) ;
				dia.setVisible(true) ;
				dia.setBounds(300,200,160,300) ;
			    dia.addWindowListener(new WindowAdapter(){
		            public void windowClosing(WindowEvent e){
			            dia.dispose() ;
			        }
		        });
			}
		}) ;
		jcb2.add(gameControl) ;
		jcb1.add(newGame) ;
		jcb1.add(maxScore) ;
		jcb1.add(gameModel) ;
		jcb2.add(start) ;
		jcb2.add(stop) ;
		jcb2.add(gameOver) ;
		jcb2.add(addHard) ;
		jcb2.add(reduceHard) ;
		jcb2.add(close) ;
		jcb2.add(allControl) ;
		gameControl.add(revovle) ;
		gameControl.add(left) ;
		gameControl.add(right) ;
		gameControl.add(down) ;
		gameModel.add(modelMenu1) ;
		gameModel.add(modelMenu2) ;
		gameModel.add(modelMenu3) ;
		jcb3.add(background) ;
		jcb3.add(color1) ;
		jcb3.add(color2) ;
		jcb3.add(color3);
		jcb3.add(color4);
		jcb3.add(acolor) ;
		jcb3.add(allColor) ;
		jcb4.add(rule) ;
		jcb4.add(aboutGame) ;
	    addWindowListener(new WindowAdapter(){
		    public void windowClosing(WindowEvent e){
			    System.exit(1) ;
			}
		});
		j1 = new MenuBar() ;
		setMenuBar(j1) ;
		pan1 = new JPanel() ;
		pan1.setBounds(5,5,300,480) ;
		can1.setBounds(10,10,300,480) ;
		//pan1.add(can1) ;
		add(can1) ;
		j1.add(jcb1) ;
		j1.add(jcb2) ;
		j1.add(jcb3) ;
		j1.add(jcb4) ;
	    //can1.start() ;
		//start() ;
		lab1 = new JLabel("下一个方块") ;
		can2 = new Canvas2() ;
		lab2 = new JLabel("难度系数") ;
		lab3 = new JLabel("1") ;
		lab4 = new JLabel("得分") ;
		lab5 = new JLabel("0") ;
		if(!model1){
		   lab7 = new JLabel("训练模式" + ELSFK.lab3.getText()) ;
		   lab6 = new JLabel("最高分:"+String.valueOf(can1.getMaxScore(Integer.valueOf(ELSFK.lab3.getText()).intValue() - 1))) ;
		}else if(model2){
			lab7 = new JLabel("模式一") ;
		    lab6 = new JLabel("最高分:"+String.valueOf(can1.getMaxScore(7))) ;
		}else{
			lab7 = new JLabel("模式二") ;
		    lab6 = new JLabel("最高分:"+String.valueOf(can1.getMaxScore(8))) ;
		}
		//setLab("1000") ;
		but1 = new JButton("开始") ;
		but2 = new JButton("暂停") ;
		but3 = new JButton("终止游戏") ;
		but4 = new JButton("增加难度") ;
		but5 = new JButton("降低难度") ;
		ActionListener b1A = new ActionListener(){
		    public void actionPerformed(ActionEvent ae1){
				actionPerformed1() ;
			}
		};
		ActionListener b2A = new ActionListener(){
		    public void actionPerformed(ActionEvent ae2){
			    if(ae2.getSource() == but2){
					actionPerformed2() ;
				}
			}
		};
		ActionListener b3A = new ActionListener(){
		    public void actionPerformed(ActionEvent ae3){
			    if(ae3.getSource() == but3){
					actionPerformed3() ;
				}
			}
		};
		ActionListener b4A = new ActionListener(){
		    public void actionPerformed(ActionEvent ae4){
			    if(ae4.getSource() == but4){
					actionPerformed4() ;
				}
			}
		};
		ActionListener b5A = new ActionListener(){
		    public void actionPerformed(ActionEvent ae5){
			    if(ae5.getSource() == but5){
					actionPerformed5();
				}
			}
		};
		newGame.addActionListener(b1A) ;
		but1.addActionListener(b1A) ;
		but2.addActionListener(b2A) ;
		but3.addActionListener(b3A) ;
		but4.addActionListener(b4A) ;
		but5.addActionListener(b5A) ;
		pan2 = new JPanel() ;
		pan2.setBounds(305,5,100,480) ;
		KeyHandle k = new KeyHandle(can1,but1,but4,but5,boo) ;
		int[] rnd = can1.getRnd() ;
		Canvas2.setx1(Canvas2.x[rnd[0]]) ;
		Canvas2.sety1(Canvas2.y[rnd[0]]) ;
		Canvas2.setUpDatex1(Canvas2.upDatex[rnd[0]]) ;
		Canvas2.setUpDatey1(Canvas2.upDatey[rnd[0]]) ;
		for(int i=0;i<rnd[1];i++){
			moveUp(can2.getx1() ,can2.gety1()) ;
	    }
	    can2.repaint() ;
		lab1.setBounds(320,5,100,30) ;
		can2.setBounds(320,35,100,100) ;
		lab2.setBounds(320,135,100,30) ;
		lab3.setBounds(320,165,100,30) ;
		lab4.setBounds(320,195,100,30) ;
		lab5.setBounds(320,220,100,30) ;
		lab7.setBounds(320,250,100,30) ;
		lab6.setBounds(320,280,100,30) ;
		but1.setBounds(320,320,100,30) ;
		but2.setBounds(320,355,100,30) ;
		but3.setBounds(320,390,100,30) ;
		but4.setBounds(320,425,100,30) ;
		but5.setBounds(320,460,100,30) ;
		add(lab1) ;
		add(can2) ;
		add(lab2) ;
		add(lab3) ;
		add(lab4) ;
		add(lab5) ;
		add(lab6) ;
		add(lab7) ;
		add(but1) ;
		add(but2) ;
		add(but3) ;
		add(but4) ;
		add(but5) ;
		add(pan1) ;
		add(pan2) ;
	}
class KeyHandle extends KeyAdapter{
	private Canvas1 can ;
	private JButton but ;
	private boolean[][] bool ;
	private Boolean1 boo = new Boolean1() ;
	int a = 1 ;
	public KeyHandle(Canvas1 can1,JButton but1,JButton but4,JButton but5,Boolean1 boo){
		can = can1 ;
		can.addKeyListener(this) ;
		but1.addKeyListener(this) ;
		but4.addKeyListener(this) ;
		but5.addKeyListener(this) ;
		dia = Dialog1.getDia() ;
		dia.addKeyListener(this) ;
		this.boo = boo ;
		bool = boo.getBool() ;
	}
	public void keyPressed(KeyEvent e){
		String direction = e.getKeyText(e.getKeyCode()) ;
		if(direction.equals(control[0])){
			actionPerformed1() ;
		}else if(direction.equals(control[3])){
		    actionPerformed4() ;  
		}else if(direction.equals(control[4])){
            actionPerformed5() ;
		}else if(direction.equals(control[9])){
		    dia.dispose() ;
		}else if(direction.equals(control[2])){
	        actionPerformed3() ;
		}
		if(Canvas1.th != null){
		    if(direction.equals(control[1])){
			    actionPerformed2() ;
		    }else if(direction.equals(control[5])){
				a = 1 ;
		        moveUp(can.getx(),can.gety()) ;
		    }else if(direction.equals(control[6])){
		        moveLeft(can.getx()) ;
		    }else if(direction.equals(control[7])){
		        moveRight(can.getx()) ;
		    }else if(direction.equals(control[8])){
		        moveDown() ;
		    }
		}
	}
	public boolean stop(int[] x1 ,int[] y1){
		for(int i=0;i<4;i++){
			if(y1[i]>0){
			if(bool[(x1[i]-10)/20][(y1[i]-10)/20]){
				return bool[(x1[i]-10)/20][(y1[i]-10)/20] ;
			}
			}
		}
		return false ;
	}
	public void change(int[] x1,int[] y1){
	    for(int i=0;i<4;i++){
			if(y1[i]>0){
		    boo.setBool((x1[i]-15)/20,(y1[i]-15)/20,true) ;
		    }
		}
	}
	public void moveUp(int[] gx,int[] gy){
		if(a>=4){
		    return ;
		}
		a++ ;
		can.setUpDatex(gx) ;
		can.setUpDatey(gy) ;
		double cx = gx[2] ;
		double cy = gy[2] ;
		int[] x = new int[4] ;
		int[] y = new int[4] ;
	    for(int i = 0;i<4;i++){
			if(gx[i] - cx == -20 && gy[i] - cy == -20){
			    x[i] = gx[i] ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == -20){
			    x[i] = gx[i] - 20 ;
				y[i] = gy[i] + 20 ;
			}else if(gx[i] - cx == -20 && gy[i] - cy == 0){
			    x[i] = gx[i] + 20 ;
				y[i] = gy[i] + 20 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == 20){
			    x[i] = gx[i] + 20 ;
				y[i] = gy[i] - 20 ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == 0){
			    x[i] = gx[i] - 20 ;
				y[i] = gy[i] - 20 ;
			}else if(gx[i] - cx == -20 && gy[i] - cy == 20){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == 20){
			    x[i] = gx[i] ;
				y[i] = gy[i] - 40 ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == -20){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == 40){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] - 40 ;
			}else if(gx[i] - cx == -40 && gy[i] - cy == 0){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == -40){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 40 && gy[i] - cy == 0){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] - 40 ;
			}else if (gx[i] - cx == 0 && gy[i] - cy == 0){
			    x[i] = gx[i] ;
				y[i] = gy[i] ;
			}else{
			    System.out.println("出错了" + gx[i] + ";" + cx + "," + gy[i] + "," + cy) ;
			}
			if(y[i] + 10 > 480){
			    return ;
			}else if(x[i]-10<0){
				for(int j=0;j<a;j++){
				    moveRight(can.getx()) ;
				}
				moveUp(can.getx(),can.gety()) ;
				return ;
			}else if(x[i]+10>300){
				for(int j=0;j<a;j++){
				    moveLeft(can.getx()) ;
				}
				moveUp(can.getx(),can.gety()) ;
				return ;
			}
		}
		if(stop(x,y)){
			return ;
		}
		can.setx(x) ;
		can.sety(y) ;
		can.repaint() ;
	}
	public void moveDown(){
		can.setPt(false) ;
	    can.setTime(10) ;
	}
	public void moveLeft(int[] gx){
		can.setUpDatex(can.getx()) ;
		can.setUpDatey(can.gety()) ;
		int[] x = new int[4] ;
	    for(int i = 0;i<4;i++){
		    x[i] = gx[i] - 20 ;
			if(x[i]-10 < 0 ){
			    return ;
			}
		}
		if(stop(x,can.gety())){
			return ;
		}
		can.setx(x) ;
		can.repaint() ;
	}

	public void moveRight(int[] gx){
		can.setUpDatex(can.getx()) ;
		can.setUpDatey(can.gety()) ;
		int[] x = new int[4] ;
	    for(int i = 0;i<4;i++){
		    x[i] = gx[i] + 20 ;
			if(x[i] + 10 > 300){
			    return ;
			}
		}
		if(stop(x,can.gety())){
			return ;
		}
		can.setx(x) ;
		can.repaint() ;
	}
}
	public void moveUp(int[] gx,int[] gy){
		can2.setUpDatex1(gx) ;
		can2.setUpDatey1(gy) ;
		double cx = gx[2] ;
		double cy = gy[2] ;
		int[] x = new int[4] ;
		int[] y = new int[4] ;
	    for(int i = 0;i<4;i++){
			if(gx[i] - cx == -20 && gy[i] - cy == -20){
			    x[i] = gx[i] ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == -20){
			    x[i] = gx[i] - 20 ;
				y[i] = gy[i] + 20 ;
			}else if(gx[i] - cx == -20 && gy[i] - cy == 0){
			    x[i] = gx[i] + 20 ;
				y[i] = gy[i] + 20 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == 20){
			    x[i] = gx[i] + 20 ;
				y[i] = gy[i] - 20 ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == 0){
			    x[i] = gx[i] - 20 ;
				y[i] = gy[i] - 20 ;
			}else if(gx[i] - cx == -20 && gy[i] - cy == 20){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == 20){
			    x[i] = gx[i] ;
				y[i] = gy[i] - 40 ;
			}else if(gx[i] - cx == 20 && gy[i] - cy == -20){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == 40){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] - 40 ;
			}else if(gx[i] - cx == -40 && gy[i] - cy == 0){
			    x[i] = gx[i] + 40 ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 0 && gy[i] - cy == -40){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] + 40 ;
			}else if(gx[i] - cx == 40 && gy[i] - cy == 0){
			    x[i] = gx[i] - 40 ;
				y[i] = gy[i] - 40 ;
			}else if (gx[i] - cx == 0 && gy[i] - cy == 0){
			    x[i] = gx[i] ;
				y[i] = gy[i] ;
			}else{
			    System.out.println("出错了" + gx[i] + ";" + cx + "," + gy[i] + "," + cy) ;
			}
			if(x[i]-10 < 0 || y[i] + 10 > 475 || x[i] + 10 > 300 ){
			    return ;
			}
		}
		if(stop(x,y)){
			return ;
		}
		can2.setx1(x) ;
		can2.sety1(y) ;
		can2.repaint() ;
	}
	public boolean stop(int[] x1 ,int[] y1){
		for(int i=0;i<4;i++){
			if(y1[i]>0){
			if(bool[(x1[i]-10)/20][(y1[i]-10)/20]){
				return bool[(x1[i]-10)/20][(y1[i]-10)/20] ;
			}
			}
		}
		return false ;
	}

}
public class ELSFK7{
	public static void main(String args[]){
	    ELSFK els = new ELSFK() ;
		els.setSize(450,560) ;
		els.setVisible(true) ;
	}
}