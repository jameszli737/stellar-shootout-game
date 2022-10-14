/*    */ import java.awt.Image;
/*    */ import java.awt.Rectangle;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public class alienBullet
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   private int w;
/*    */   private int h;
/*    */   private Image image;
/*    */   private Rectangle hitBox;
/* 13 */   private int move = 3;
/*    */   
/*    */   public alienBullet(int x, int y) {
/* 16 */     this.x = x + 50;
/* 17 */     this.y = y + 3;
/* 18 */     loadImage();
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadImage() {
/* 23 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/alienbullet.png"));
/* 24 */     this.image = ii.getImage();
/*    */     
/* 26 */     this.w = this.image.getWidth(null);
/* 27 */     this.h = this.image.getHeight(null);
/*    */     
/* 29 */     this.hitBox = new Rectangle(this.x, this.y, this.w, this.h);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getX() {
/* 34 */     return this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getY() {
/* 39 */     return this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 44 */     return this.image;
/*    */   }
/*    */ 
/*    */   
/*    */   public void move() {
/* 49 */     this.y += this.move;
/* 50 */     this.hitBox.setLocation(this.x, this.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public Rectangle getHitBox() {
/* 55 */     return this.hitBox;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\alienBullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */