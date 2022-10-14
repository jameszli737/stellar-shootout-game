/*    */ import java.awt.Image;
/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class userBullet
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int w;
/*    */   private int h;
/*    */   private Image image;
/*    */   private Rectangle hitBox;
/* 13 */   private int move = 4;
/*    */   
/*    */   public userBullet(int x, int y) {
/* 16 */     this.x = x + 35;
/* 17 */     this.y = y - 3;
/*    */     
/* 19 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/userBullet.png"));
/* 20 */     this.image = ii.getImage();
/*    */     
/* 22 */     this.w = this.image.getWidth(null);
/* 23 */     this.h = this.image.getHeight(null);
/*    */     
/* 25 */     this.hitBox = new Rectangle(this.x, this.y, this.w, this.h);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getX() {
/* 31 */     return this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getY() {
/* 36 */     return this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 41 */     return this.image;
/*    */   }
/*    */ 
/*    */   
/*    */   public void move() {
/* 46 */     this.y -= this.move;
/* 47 */     this.hitBox.setLocation(this.x, this.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public Rectangle getHitBox() {
/* 52 */     return this.hitBox;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar\\userBullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */