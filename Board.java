/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ public class Board
/*     */   extends JPanel
/*     */   implements ActionListener {
/*     */   private Timer timer;
/*     */   private Timer alienSpawner;
/*  21 */   private final int DELAY = 10;
/*  22 */   private int spawnDelay = 10000;
/*     */   private SpaceShip ss;
/*     */   private Background back;
/*     */   private Instructions instructions;
/*     */   private StartScreen start;
/*     */   private HealthHud healthHud;
/*     */   private AmmoHud ammoHud;
/*  29 */   private int numKeyPress = 0;
/*  30 */   private int numActions = 0;
/*     */   private ArrayList<Alien> aliens;
/*  32 */   private Random r = new Random();
/*  33 */   private int round = 0;
/*  34 */   private int score = 0;
/*  35 */   private int kills = 0;
/*     */   private double hudNum;
/*     */   private Paused paused;
/*     */   private gameOver gameOver;
/*  39 */   private int reloading = 0;
/*     */   
/*     */   private boolean lost;
/*     */   private JButton restart;
/*     */   private Font f;
/*     */   
/*     */   public Board() {
/*  46 */     openBoard();
/*     */   }
/*     */ 
/*     */   
/*     */   public void openBoard() {
/*  51 */     addKeyListener(new TAdapter());
/*  52 */     setFocusable(true);
/*  53 */     setBackground(Color.GRAY);
/*  54 */     setDoubleBuffered(true);
/*     */     
/*  56 */     this.ss = new SpaceShip();
/*  57 */     this.back = new Background();
/*  58 */     this.instructions = new Instructions();
/*  59 */     this.start = new StartScreen();
/*  60 */     this.aliens = new ArrayList<>();
/*  61 */     this.healthHud = new HealthHud();
/*  62 */     this.ammoHud = new AmmoHud();
/*  63 */     this.paused = null;
/*  64 */     this.gameOver = null;
/*     */     
/*  66 */     this.timer = new Timer(10, this);
/*  67 */     this.timer.start();
/*     */     
/*  69 */     this.alienSpawner = new Timer(this.spawnDelay, this);
/*     */     
/*  71 */     this.lost = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintComponent(Graphics g) {
/*  77 */     Graphics2D g2d = (Graphics2D)g;
/*     */ 
/*     */     
/*  80 */     g2d.clearRect(0, 0, 601, 900);
/*     */     
/*  82 */     if (!this.lost) {
/*     */       
/*  84 */       g2d.drawImage(this.back.getImage(), 0, 0, this);
/*  85 */       g2d.drawImage(this.ss.getImage(), this.ss.getX(), this.ss.getY(), this);
/*     */       
/*  87 */       for (userBullet b : this.ss.getUserBullets())
/*     */       {
/*  89 */         g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
/*     */       }
/*     */       
/*  92 */       for (Alien a : this.aliens) {
/*     */         
/*  94 */         g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
/*     */         
/*  96 */         if (a.getAlienBullets().size() > 0)
/*  97 */           for (alienBullet ab : a.getAlienBullets()) {
/*  98 */             g2d.drawImage(ab.getImage(), ab.getX(), ab.getY(), this);
/*     */           } 
/*     */       } 
/* 101 */       g2d.setColor(Color.WHITE);
/* 102 */       this.f = new Font("helvetica", 1, 20);
/* 103 */       g2d.setFont(this.f);
/* 104 */       g2d.drawString("Score: " + this.score, 5, 25);
/* 105 */       g2d.drawString("Round: " + this.round, 5, 50);
/*     */       
/* 107 */       g2d.clearRect(0, 800, 600, 81);
/*     */       
/* 109 */       this.hudNum = this.ss.getHealth() / 100.0D;
/*     */       
/* 111 */       if (this.hudNum >= 0.0D) {
/* 112 */         g2d.drawImage(this.healthHud.getImages().get((int)this.hudNum), this.healthHud.getX(), this.healthHud.getY(), this);
/*     */       } else {
/*     */         
/* 115 */         g2d.drawImage(this.healthHud.getImages().get(0), this.healthHud.getX(), this.healthHud.getY(), this);
/*     */       } 
/* 117 */       if (this.reloading < 0) {
/* 118 */         g2d.drawImage(this.ammoHud.getImages().get(this.ss.getAmmo()), this.ammoHud.getX(), this.ammoHud.getY(), this);
/*     */       }
/* 120 */       else if (this.reloading > 0) {
/* 121 */         g2d.drawImage(this.ammoHud.getImages().get(11), this.ammoHud.getX(), this.ammoHud.getY(), this);
/*     */       } 
/* 123 */       if (this.paused != null) {
/* 124 */         g2d.drawImage(this.paused.getImage(), 136, 364, this);
/*     */       }
/* 126 */       if (this.numKeyPress < 2) {
/* 127 */         g2d.drawImage(this.instructions.getImage(), 0, 0, this);
/* 128 */         g2d.setColor(Color.BLACK);
/* 129 */         g2d.fillRect(0, 800, 600, 81);
/*     */       } 
/*     */       
/* 132 */       if (this.numKeyPress < 1) {
/* 133 */         g2d.drawImage(this.start.getImage(), 0, 0, this);
/*     */       }
/*     */     } 
/* 136 */     if (this.lost == true) {
/*     */       
/* 138 */       g2d.setColor(Color.BLACK);
/* 139 */       g2d.fillRect(0, 0, 600, 900);
/*     */       
/* 141 */       g2d.drawImage(this.gameOver.getImage(), 50, 200, this);
/*     */       
/* 143 */       g2d.setColor(Color.WHITE);
/* 144 */       this.f = new Font("helvetica", 1, 50);
/* 145 */       g2d.setFont(this.f);
/*     */       
/* 147 */       String scr = String.format("Score: %06d", new Object[] { Integer.valueOf(this.score) });
/* 148 */       String rnd = String.format("Round: %02d", new Object[] { Integer.valueOf(this.round) });
/*     */       
/* 150 */       g2d.drawString(scr, 125, 400);
/* 151 */       g2d.drawString(rnd, 175, 525);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class TAdapter
/*     */     extends KeyAdapter
/*     */   {
/*     */     public void keyPressed(KeyEvent e) {
/* 161 */       int event = e.getKeyCode();
/*     */       
/* 163 */       Board.this.numKeyPress++;
/*     */       
/* 165 */       if (event == 80 && Board.this.timer.isRunning() && Board.this.alienSpawner.isRunning()) {
/* 166 */         Board.this.pause();
/*     */       }
/* 168 */       else if (event == 80 && !Board.this.timer.isRunning() && !Board.this.alienSpawner.isRunning()) {
/* 169 */         Board.this.resume();
/*     */       }
/* 171 */       else if (Board.this.numKeyPress > 2) {
/* 172 */         Board.this.ss.keyPressed(e, Board.this.reloading);
/*     */       } 
/* 174 */       if (event == 82) {
/* 175 */         Board.this.ss.reload();
/* 176 */         Board.this.reloading = 50;
/*     */       } 
/*     */       
/* 179 */       if (Board.this.numKeyPress == 2) {
/* 180 */         Board.this.alienSpawner.start();
/*     */       }
/*     */     }
/*     */     
/*     */     public void keyReleased(KeyEvent e) {
/* 185 */       Board.this.ss.keyReleased(e);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 192 */     if (e.getSource() == this.alienSpawner) {
/* 193 */       spawnAliens();
/*     */     }
/* 195 */     else if (e.getSource() == this.restart) {
/*     */       
/* 197 */       this.restart.setVisible(false);
/* 198 */       this.lost = false;
/* 199 */       this.ss = new SpaceShip();
/* 200 */       this.numKeyPress = 0;
/* 201 */       this.numActions = 0;
/* 202 */       this.kills = 0;
/* 203 */       this.round = 0;
/* 204 */       this.spawnDelay = 15000;
/* 205 */       this.aliens.clear();
/* 206 */       this.timer.start();
/*     */     }
/*     */     else {
/*     */       
/* 210 */       checkForCollision();
/* 211 */       updateUserShip();
/* 212 */       updateUserBullets();
/* 213 */       updateAlienShip();
/* 214 */       updateAlienBullets();
/* 215 */       updateRound();
/*     */       
/* 217 */       this.numActions++;
/*     */     } 
/*     */     
/* 220 */     if (this.numActions % 10 == 0 && this.numKeyPress > 2) {
/* 221 */       updateScore();
/*     */     }
/* 223 */     repaint();
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnAliens() {
/* 228 */     for (int x = 0; x < 600; x += 100)
/*     */     {
/* 230 */       this.aliens.add(new Alien(x));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkForCollision() {
/* 236 */     for (Alien a : this.aliens) {
/*     */       
/* 238 */       for (int aB = 0; aB < a.getAlienBullets().size(); aB++) {
/*     */         
/* 240 */         if (((alienBullet)a.getAlienBullets().get(aB)).getHitBox().intersects(this.ss.getHitBox())) {
/*     */           
/* 242 */           this.ss.takeDamagei();
/* 243 */           a.getAlienBullets().remove(aB);
/* 244 */           aB--;
/*     */         } 
/*     */         
/* 247 */         if (aB == -1) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/* 252 */     for (int uB = 0; uB < this.ss.getUserBullets().size(); uB++) {
/*     */       
/* 254 */       for (Alien a : this.aliens) {
/*     */         
/* 256 */         if (((userBullet)this.ss.getUserBullets().get(uB)).getHitBox().intersects(a.getHitBox())) {
/*     */           
/* 258 */           a.takeDamage();
/* 259 */           this.ss.getUserBullets().remove(uB);
/* 260 */           uB--;
/*     */         } 
/*     */         
/* 263 */         if (uB == -1) {
/*     */           break;
/*     */         }
/*     */       } 
/* 267 */       if (uB == -1) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateUserShip() {
/* 274 */     this.ss.move();
/* 275 */     this.ss.regen();
/*     */     
/* 277 */     if (this.ss.getHealth() <= 0.0D) {
/* 278 */       gameOverSequence();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateUserBullets() {
/* 284 */     ArrayList<userBullet> uB = this.ss.getUserBullets();
/*     */     
/* 286 */     for (int i = 0; i < uB.size(); i++) {
/*     */       
/* 288 */       if (((userBullet)uB.get(i)).getY() < 0) {
/*     */         
/* 290 */         uB.remove(i);
/* 291 */         i--;
/*     */       }
/*     */       else {
/*     */         
/* 295 */         ((userBullet)uB.get(i)).move();
/*     */       } 
/*     */     } 
/*     */     
/* 299 */     this.reloading--;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAlienShip() {
/* 304 */     int i = this.r.nextInt(4) + 1;
/*     */     
/* 306 */     if (this.numActions % 2 == 0)
/*     */     {
/* 308 */       for (Alien alien : this.aliens)
/*     */       {
/* 310 */         alien.move(i);
/*     */       }
/*     */     }
/*     */     
/* 314 */     for (int z = 0; z < this.aliens.size(); z++) {
/*     */       
/* 316 */       if (((Alien)this.aliens.get(z)).getHealth() == 0) {
/*     */         
/* 318 */         this.aliens.remove(z);
/* 319 */         this.kills++;
/* 320 */         z--;
/*     */       } 
/*     */     } 
/*     */     
/* 324 */     if (this.numActions % 50 == 0)
/*     */     {
/* 326 */       for (Alien alien : this.aliens) {
/*     */         
/* 328 */         int fire = this.r.nextInt(7) + 1;
/*     */         
/* 330 */         if (fire == 7) {
/* 331 */           alien.fire();
/*     */         }
/*     */       } 
/*     */     }
/* 335 */     for (int a = 0; a < this.aliens.size(); a++) {
/*     */       
/* 337 */       if (((Alien)this.aliens.get(a)).getY() > 790) {
/*     */         
/* 339 */         this.aliens.remove(a);
/* 340 */         this.ss.takeDamageii();
/* 341 */         a--;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAlienBullets() {
/* 348 */     for (Alien a : this.aliens) {
/*     */       
/* 350 */       ArrayList<alienBullet> aB = a.getAlienBullets();
/*     */       
/* 352 */       for (int i = 0; i < aB.size(); i++) {
/*     */         
/* 354 */         if (((alienBullet)aB.get(i)).getY() > 800) {
/*     */           
/* 356 */           aB.remove(i);
/* 357 */           i--;
/*     */         }
/*     */         else {
/*     */           
/* 361 */           ((alienBullet)aB.get(i)).move();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRound() {
/* 369 */     if (this.aliens.isEmpty() && this.alienSpawner.isRunning()) {
/*     */       
/* 371 */       this.round++;
/* 372 */       this.spawnDelay -= 500;
/* 373 */       this.alienSpawner.setDelay(this.spawnDelay);
/* 374 */       this.alienSpawner.restart();
/* 375 */       spawnAliens();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScore() {
/* 381 */     this.score = this.round * 1000 + this.numActions / 10 + this.kills * 200;
/*     */   }
/*     */ 
/*     */   
/*     */   public void gameOverSequence() {
/* 386 */     this.alienSpawner.stop();
/* 387 */     this.timer.stop();
/* 388 */     this.gameOver = new gameOver();
/* 389 */     this.lost = true;
/* 390 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/restart.png"));
/* 391 */     this.restart = new JButton("Click to restart", ii);
/* 392 */     this.restart.setBackground(Color.BLACK);
/* 393 */     this.restart.setLocation(175, 600);
/* 394 */     this.restart.setSize(250, 53);
/* 395 */     this.restart.addActionListener(this);
/* 396 */     this.restart.setVisible(true);
/* 397 */     add(this.restart);
/* 398 */     repaint();
/*     */   }
/*     */ 
/*     */   
/*     */   public void pause() {
/* 403 */     this.paused = new Paused();
/* 404 */     this.timer.stop();
/* 405 */     this.alienSpawner.stop();
/* 406 */     repaint();
/*     */   }
/*     */ 
/*     */   
/*     */   public void resume() {
/* 411 */     this.paused = null;
/* 412 */     this.timer.start();
/* 413 */     this.alienSpawner.start();
/*     */   }
/*     */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\Board.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */