/*    */ import java.awt.Image;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ 
/*    */ public class Instructions
/*    */ {
/*    */   private Image image;
/*    */   
/*    */   public Instructions() {
/* 10 */     loadInstructions();
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadInstructions() {
/* 15 */     ImageIcon ii = new ImageIcon(getClass().getResource("images/instructions.png"));
/* 16 */     this.image = ii.getImage();
/*    */   }
/*    */ 
/*    */   
/*    */   public Image getImage() {
/* 21 */     return this.image;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\Instructions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */