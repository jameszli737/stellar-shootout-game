/*    */ import java.awt.Image;
/*    */ import java.util.ArrayList;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public final class HealthHud
/*    */ {
/*    */   private ArrayList<Image> images;
/*    */   private ArrayList<ImageIcon> ii;
/*  9 */   private final int X = 340;
/* 10 */   private final int Y = 801;
/*    */ 
/*    */   
/*    */   public HealthHud() {
/* 14 */     this.images = new ArrayList<>();
/* 15 */     this.ii = new ArrayList<>();
/*    */     
/* 17 */     loadHud();
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadHud() {
/* 22 */     this.ii.add(new ImageIcon(getClass().getResource("images/health0.png")));
/* 23 */     this.ii.add(new ImageIcon(getClass().getResource("images/health1.png")));
/* 24 */     this.ii.add(new ImageIcon(getClass().getResource("images/health2.png")));
/* 25 */     this.ii.add(new ImageIcon(getClass().getResource("images/health3.png")));
/* 26 */     this.ii.add(new ImageIcon(getClass().getResource("images/health4.png")));
/* 27 */     this.ii.add(new ImageIcon(getClass().getResource("images/health5.png")));
/* 28 */     this.ii.add(new ImageIcon(getClass().getResource("images/health6.png")));
/* 29 */     this.ii.add(new ImageIcon(getClass().getResource("images/health7.png")));
/* 30 */     this.ii.add(new ImageIcon(getClass().getResource("images/health8.png")));
/* 31 */     this.ii.add(new ImageIcon(getClass().getResource("images/health9.png")));
/* 32 */     this.ii.add(new ImageIcon(getClass().getResource("images/health10.png")));
/*    */     
/* 34 */     for (ImageIcon icon : this.ii) {
/* 35 */       Image temp = icon.getImage();
/* 36 */       this.images.add(temp);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ArrayList<Image> getImages() {
/* 43 */     return this.images;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getX() {
/* 48 */     return 340;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getY() {
/* 53 */     return 801;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\HealthHud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */