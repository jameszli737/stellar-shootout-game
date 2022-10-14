/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ public class Main
/*    */   extends JFrame {
/*    */   public Main() {
/*  8 */     openUI();
/*    */   }
/*    */ 
/*    */   
/*    */   public void openUI() {
/* 13 */     add(new Board());
/*    */     
/* 15 */     setTitle("Stellar Shootout");
/* 16 */     setSize(607, 880);
/*    */     
/* 18 */     setLocationRelativeTo((Component)null);
/* 19 */     setResizable(false);
/* 20 */     setDefaultCloseOperation(3);
/* 21 */     setBackground(Color.BLACK);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 26 */     Main m = new Main();
/* 27 */     m.setVisible(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */