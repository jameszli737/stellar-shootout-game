/*    */ import java.awt.Image;
/*    */ import java.util.ArrayList;
/*    */ import javax.swing.ImageIcon;
/*    */ 
/*    */ public final class AmmoHud
/*    */ {
/*    */   private ArrayList<Image> images;
/*    */   private ArrayList<ImageIcon> ii;
/*  9 */   private final int X = -20;
/* 10 */   private final int Y = 801;
/*    */ 
/*    */   
/*    */   public AmmoHud() {
/* 14 */     this.images = new ArrayList<>();
/* 15 */     this.ii = new ArrayList<>();
/*    */     
/* 17 */     loadHud();
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadHud() {
/* 22 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo0.png")));
/* 23 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo1.png")));
/* 24 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo2.png")));
/* 25 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo3.png")));
/* 26 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo4.png")));
/* 27 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo5.png")));
/* 28 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo6.png")));
/* 29 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo7.png")));
/* 30 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo8.png")));
/* 31 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo9.png")));
/* 32 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammo10.png")));
/* 33 */     this.ii.add(new ImageIcon(getClass().getResource("images/ammor.png")));
/*    */     
/* 35 */     for (ImageIcon icon : this.ii) {
/* 36 */       Image temp = icon.getImage();
/* 37 */       this.images.add(temp);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ArrayList<Image> getImages() {
/* 44 */     return this.images;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getX() {
/* 49 */     return -20;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getY() {
/* 54 */     return 801;
/*    */   }
/*    */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\AmmoHud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */