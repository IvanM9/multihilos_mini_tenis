import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;

public class Raqueta {
  int x = 0;
  int xa = 0;
  private Juego juego;

  public Raqueta(Juego juego) {
    this.juego = juego;
  }

  public void move() {
    if (x + xa > 0 && x + xa < juego.getWidth() - 60)
      x = x + xa;
  }

  public void paint(Graphics2D g) {
    g.fillRect(x, 330, 60, 10);
  }

  public void keyReleased(KeyEvent e) {
    xa = 0;
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
      xa = -juego.speed;
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      xa = juego.speed;
  }

  public Rectangle getBounds() {
    return new Rectangle(x, 330, 60, 10);
  }

  public int getTopY() {
    return 330;
  }
}
