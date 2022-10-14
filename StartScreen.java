/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ 
/*    */ public class StartScreen
/*    */ {
/*    */   private Image image;
/*    */   
/*    */   public StartScreen() {
/* 10 */     loadStartScreen();
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadStartScreen() {
/* 15 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/start.png"));
/* 16 */     this.image = ii.getImage();
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 21 */     return this.image;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\StartScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */