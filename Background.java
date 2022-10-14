/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ 
/*    */ public class Background
/*    */ {
/*    */   private Image image;
/*    */   
/*    */   public Background() {
/* 10 */     loadBackground();
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadBackground() {
/* 15 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/background.png"));
/* 16 */     this.image = ii.getImage();
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 21 */     return this.image;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\Background.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */