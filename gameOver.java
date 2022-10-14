/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ 
/*    */ public class gameOver
/*    */ {
/*    */   private Image image;
/*    */   
/*    */   public gameOver() {
/* 10 */     loadGameOver();
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadGameOver() {
/* 15 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/gameOver.png"));
/* 16 */     this.image = ii.getImage();
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 21 */     return this.image;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\gameOver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */