/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ public class SpaceShip
/*     */ {
/*   9 */   private int x = 262;
/*  10 */   private int y = 725;
/*     */   private int moveX;
/*     */   private int moveY;
/*     */   private int w;
/*     */   private int h;
/*     */   private Image image;
/*     */   private int ammo;
/*     */   private double health;
/*     */   private Rectangle hitBox;
/*  19 */   private ArrayList<userBullet> userBullets = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public SpaceShip() {
/*  23 */     loadImage();
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadImage() {
/*  28 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/userShip.png"));
/*  29 */     this.image = ii.getImage();
/*     */     
/*  31 */     this.w = this.image.getWidth(null);
/*  32 */     this.h = this.image.getHeight(null);
/*     */     
/*  34 */     this.ammo = 10;
/*     */     
/*  36 */     this.hitBox = new Rectangle(this.x, this.y, this.w, this.h);
/*     */     
/*  38 */     this.health = 1000.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void move() {
/*  43 */     if (this.moveX < 0 && this.x >= 2) {
/*  44 */       this.x += this.moveX;
/*     */     }
/*  46 */     if (this.moveX > 0 && this.x <= 523) {
/*  47 */       this.x += this.moveX;
/*     */     }
/*  49 */     if (this.moveY > 0 && this.y <= 723) {
/*  50 */       this.y += this.moveY;
/*     */     }
/*  52 */     if (this.moveY < 0 && this.y >= 500) {
/*  53 */       this.y += this.moveY;
/*     */     }
/*  55 */     this.hitBox.setLocation(this.x, this.y);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/*  60 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/*  65 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  70 */     return this.w;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  75 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public Image getImage() {
/*  80 */     return this.image;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle getHitBox() {
/*  85 */     return this.hitBox;
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyPressed(KeyEvent e, int reloading) {
/*  90 */     int key = e.getKeyCode();
/*     */     
/*  92 */     if (key == 32 && reloading <= 0) {
/*  93 */       fire();
/*     */     }
/*     */     
/*  96 */     if (key == 37) {
/*  97 */       this.moveX = -2;
/*     */     }
/*     */     
/* 100 */     if (key == 39) {
/* 101 */       this.moveX = 2;
/*     */     }
/*     */     
/* 104 */     if (key == 40) {
/* 105 */       this.moveY = 2;
/*     */     }
/*     */     
/* 108 */     if (key == 38) {
/* 109 */       this.moveY = -2;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 115 */     int key = e.getKeyCode();
/*     */     
/* 117 */     if (key == 37) {
/* 118 */       this.moveX = 0;
/*     */     }
/*     */     
/* 121 */     if (key == 39) {
/* 122 */       this.moveX = 0;
/*     */     }
/*     */     
/* 125 */     if (key == 40) {
/* 126 */       this.moveY = 0;
/*     */     }
/*     */     
/* 129 */     if (key == 38) {
/* 130 */       this.moveY = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public void fire() {
/* 135 */     if (this.ammo > 0) {
/* 136 */       this.userBullets.add(new userBullet(this.x, this.y));
/* 137 */       this.ammo--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<userBullet> getUserBullets() {
/* 143 */     return this.userBullets;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reload() {
/* 148 */     this.ammo = 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getHealth() {
/* 153 */     return this.health;
/*     */   }
/*     */ 
/*     */   
/*     */   public void takeDamagei() {
/* 158 */     this.health -= 100.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void takeDamageii() {
/* 163 */     this.health -= 50.0D;
/*     */   }
/*     */   
/*     */   public void regen() {
/* 167 */     if (this.health < 1000.0D) {
/* 168 */       this.health += 0.1D;
/*     */     }
/*     */   }
/*     */   
/*     */   public int getAmmo() {
/* 173 */     return this.ammo;
/*     */   }
/*     */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\SpaceShip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */