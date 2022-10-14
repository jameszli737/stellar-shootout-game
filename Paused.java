/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ 
/*    */ public class Paused
/*    */ {
/*    */   private Image image;
/*    */   
/*    */   public Paused() {
/* 10 */     loadPaused();
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadPaused() {
/* 15 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/paused.png"));
/* 16 */     this.image = ii.getImage();
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 21 */     return this.image;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\Paused.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */