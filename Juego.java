import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Juego extends JPanel {
  Pelota ball = new Pelota(this);
  Raqueta raqueta = new Raqueta(this);
  int speed = 1;

  private int getScore() {
    return speed - 1;
  }

  public Juego() {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyReleased(KeyEvent e) {
        raqueta.keyReleased(e);
      }

      @Override
      public void keyPressed(KeyEvent e) {
        raqueta.keyPressed(e);
      }
    });
    setFocusable(true);
  }

  private void move() {
    ball.move();
    raqueta.move();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    ball.paint(g2d);
    raqueta.paint(g2d);

    g2d.drawString("Puntaje: " + getScore(), 10, 30);
  }

  public void gameOver() {
    JOptionPane.showMessageDialog(this, "Tu puntuación es: " + getScore(),
        "Juego terminado", JOptionPane.YES_NO_OPTION);
    System.exit(ABORT);
  }

  public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("Mini Tennis");
    Juego game = new Juego();
    frame.add(game);
    frame.setSize(300, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    while (true) {
      game.move();
      game.repaint();
      Thread.sleep(10);
    }
  }
}
