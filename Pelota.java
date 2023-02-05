import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota {
  private static final int DIAMETER = 30;
  int x = 0;
  int y = 0;
  int xa = 1;
  int ya = 1;
  private Juego juego;

  public Pelota(Juego juego) {
    this.juego = juego;
  }

  void move() {
    if (x + xa < 0)
      xa = juego.speed;
    if (x + xa > juego.getWidth() - DIAMETER)
      xa = -juego.speed;
    if (y + ya < 0)
      ya = juego.speed;
    if (y + ya > juego.getHeight() - DIAMETER)
      juego.gameOver();
    if (collision()){
      ya = -juego.speed;
      y = juego.raqueta.getTopY() - DIAMETER;
      juego.speed++;
    }
    x = x + xa;
    y = y + ya;
  }

  private boolean collision() {
    return juego.raqueta.getBounds().intersects(getBounds());
  }

  public void paint(Graphics2D g) {
    g.fillOval(x, y, DIAMETER, DIAMETER);
  }

  public Rectangle getBounds() {
    return new Rectangle(x, y, DIAMETER, DIAMETER);
  }
}
