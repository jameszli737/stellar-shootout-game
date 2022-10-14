/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ public class Alien
/*     */ {
/*     */   private int x;
/*     */   private int y;
/*     */   private int w;
/*     */   private int h;
/*     */   private Image image;
/*     */   private int health;
/*     */   private Rectangle hitBox;
/*  15 */   private ArrayList<alienBullet> alienBullets = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public Alien(int x) {
/*  19 */     this.x = x;
/*  20 */     this.y = 0;
/*     */     
/*  22 */     loadImage();
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadImage() {
/*  27 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/alienShip.png"));
/*  28 */     this.image = ii.getImage();
/*     */     
/*  30 */     this.w = this.image.getWidth(null);
/*  31 */     this.h = this.image.getHeight(null);
/*     */     
/*  33 */     this.hitBox = new Rectangle(this.x, this.y, this.w, this.h);
/*     */     
/*  35 */     this.health = 200;
/*     */   }
/*     */   
/*     */   public void move(int i) {
/*  39 */     if (i == 1 && this.x >= 2) {
/*  40 */       this.x -= 2;
/*  41 */       this.hitBox.setLocation(this.x, this.y);
/*     */     } 
/*     */     
/*  44 */     if (i == 2 && this.x <= 548) {
/*  45 */       this.x += 2;
/*  46 */       this.hitBox.setLocation(this.x, this.y);
/*     */     } 
/*     */     
/*  49 */     if (i == 3 && this.y <= 800) {
/*  50 */       this.y += 2;
/*  51 */       this.hitBox.setLocation(this.x, this.y);
/*     */     } 
/*     */     
/*  54 */     if (i == 4) {
/*  55 */       this.y += 0;
/*  56 */       this.hitBox.setLocation(this.x, this.y);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getX() {
/*  62 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getY() {
/*  67 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  72 */     return this.w;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  77 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public Image getImage() {
/*  82 */     return this.image;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rectangle getHitBox() {
/*  87 */     return this.hitBox;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHealth() {
/*  92 */     return this.health;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<alienBullet> getAlienBullets() {
/*  97 */     return this.alienBullets;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fire() {
/* 102 */     this.alienBullets.add(new alienBullet(this.x, this.y));
/*     */   }
/*     */ 
/*     */   
/*     */   public void takeDamage() {
/* 107 */     this.health -= 100;
/*     */   }
/*     */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\Alien.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */