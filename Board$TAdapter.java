/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TAdapter
/*     */   extends KeyAdapter
/*     */ {
/*     */   public void keyPressed(KeyEvent e) {
/* 161 */     int event = e.getKeyCode();
/*     */     
/* 163 */     Board.access$008(Board.this);
/*     */     
/* 165 */     if (event == 80 && Board.access$100(Board.this).isRunning() && Board.access$200(Board.this).isRunning()) {
/* 166 */       Board.this.pause();
/*     */     }
/* 168 */     else if (event == 80 && !Board.access$100(Board.this).isRunning() && !Board.access$200(Board.this).isRunning()) {
/* 169 */       Board.this.resume();
/*     */     }
/* 171 */     else if (Board.access$000(Board.this) > 2) {
/* 172 */       Board.access$400(Board.this).keyPressed(e, Board.access$300(Board.this));
/*     */     } 
/* 174 */     if (event == 82) {
/* 175 */       Board.access$400(Board.this).reload();
/* 176 */       Board.access$302(Board.this, 50);
/*     */     } 
/*     */     
/* 179 */     if (Board.access$000(Board.this) == 2) {
/* 180 */       Board.access$200(Board.this).start();
/*     */     }
/*     */   }
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 185 */     Board.access$400(Board.this).keyReleased(e);
/*     */   }
/*     */ }


/* Location:              C:\Users\james\Desktop\StellarShootout.jar!\Board$TAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */