import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.awt.TextRenderer;
import java.awt.Font;

public class MainSquares extends GLCanvas implements GLEventListener, KeyListener {
  private ArrayList<GraphicalObject> objects3D;
  private ArrayList<GraphicalObject> enemis;
  private ArrayList<Projectile> projectiles = new ArrayList<>();
  private Square square1;
  private static final float LEFT_BOUNDARY = -40.0f;
  private static final float RIGHT_BOUNDARY = 40.0f;

  private float alienSpeed = 0.005f; // Speed of alien movement
  private boolean movingRight = true; // Direction of movement
  private boolean isGameOver = false;
  // Distance between projectile and alien to be considered a collision
  private static final float collisionThreshold = 3.0f;
  // private TextRenderer renderer;

  public static void main(String[] args) {
    GLCanvas canvas = new MainSquares();
    canvas.setPreferredSize(new Dimension(1000, 800));
    final JFrame frame = new JFrame();
    frame.getContentPane().add(canvas);
    frame.setTitle("Space Invaders");
    frame.pack();
    frame.setVisible(true);
    Animator animator = new Animator(canvas);
    animator.start();
  }

  public MainSquares() {
    this.addGLEventListener(this);
    this.addKeyListener(this);
    this.setFocusable(true);
    this.objects3D = new ArrayList<GraphicalObject>();
    this.enemis = new ArrayList<GraphicalObject>();
    // Initialize the text renderer
    // renderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 36));
  }

  // Method to move the square left
  private void moveLeft() {
    float currentX = square1.getPosX();
    if (currentX > LEFT_BOUNDARY) {
      square1.setPosX(currentX - 2.0f); // Adjust the value for movement speed
      this.repaint();
    }
  }

  // Method to move the square right
  private void moveRight() {
    float currentX = square1.getPosX();
    if (currentX < RIGHT_BOUNDARY) {
      square1.setPosX(currentX + 2.0f); // Adjust the value for movement speed
      this.repaint();
    }
  }

  @Override
  public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity();
    this.square1.display(gl);
    for (GraphicalObject obj : this.objects3D) {
      obj.display(gl);
    }

    for (GraphicalObject obj : this.enemis) {
      obj.display(gl);
    }

    // update positions of enemies before drawing
    updateEnemyPositions();

    // Update and display projectiles
    List<Projectile> projectilesToRemove = new ArrayList<>();
    for (Projectile projectile : projectiles) {
      projectile.move();
      projectile.display(gl);

      // Check for collision with any alien
      if (checkCollisionWithAliens(projectile)) {
        projectilesToRemove.add(projectile);
      }
    }
    projectiles.removeAll(projectilesToRemove);

    if (!isGameOver) {
      // Check for win condition
      if (checkWinCondition()) {
        isGameOver = true;
        displayWinMessage(gl);
      }
    } else {
      // Display the win message
      displayWinMessage(gl);
    }
  }

  private boolean checkCollisionWithAliens(Projectile projectile) {
    boolean collisionDetected = false;
    Iterator<GraphicalObject> it = enemis.iterator();
    while (it.hasNext()) {
      Square alien = (Square) it.next();

      if (Math.abs(alien.getPosX() - projectile.getPosX()) < collisionThreshold &&
          Math.abs(alien.getPosY() - projectile.getPosY()) < collisionThreshold) {
        it.remove(); // Remove the alien
        collisionDetected = true;
        break; // Assuming one projectile can only hit one alien
      }
    }
    return collisionDetected;
  }

  private void updateEnemyPositions() {
    float maxX = -Float.MAX_VALUE;
    float minX = Float.MAX_VALUE;

    for (GraphicalObject obj : enemis) {
      Square square = (Square) obj;
      float newX = square.getPosX() + (movingRight ? alienSpeed : -alienSpeed);
      square.setPosX(newX);

      maxX = Math.max(maxX, newX);
      minX = Math.min(minX, newX);
    }

    // Check boundaries and move down if needed
    if (maxX > RIGHT_BOUNDARY || minX < LEFT_BOUNDARY) {
      movingRight = !movingRight; // change direction
      for (GraphicalObject obj : enemis) {
        Square square = (Square) obj;
        square.setPosY(square.getPosY() - 1.0f); // Move down
      }
    }
  }

  private boolean checkWinCondition() {
    return enemis.isEmpty();
  }

  private void displayWinMessage(GL2 gl) {
    // Display a win message on the screen
    // renderer.beginRendering(this.getWidth(), this.getHeight());
    // renderer.setColor(1.0f, 1.0f, 1.0f, 1.0f); // Set the color to white

    // Center the text
    // String message = "You Win! Press R to Restart";
    // int width = renderer.getFont().getWidth(message);
    // int height = renderer.getFont().getHeight();
    // renderer.draw(message, (this.getWidth() - width) / 2, (this.getHeight() -
    // height) / 2);

    // renderer.endRendering();
  }

  private void restartGame() {
    // Reset the game state
    enemis = initializeAliens(); // You'll need to implement this method
    projectiles.clear();
    isGameOver = false;
    // Other necessary resets (like resetting the player position)
  }

  @Override
  public void dispose(GLAutoDrawable arg0) {
  }

  // KeyListener methods
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {
      moveLeft(); // Method to move the square left
    } else if (key == KeyEvent.VK_RIGHT) {
      moveRight(); // Method to move the square right
    }

    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      // Create a projectile
      Projectile newProjectile = new Projectile(square1.getPosX(), square1.getPosY(), -40f, 1.0f, 0.5f, 0.5f, 0.5f,
          0.1f);
      projectiles.add(newProjectile);
    }

    if (isGameOver && e.getKeyCode() == KeyEvent.VK_R) {
      restartGame();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  private ArrayList<GraphicalObject> initializeAliens() {
    ArrayList<GraphicalObject> aliens = new ArrayList<GraphicalObject>();
    float x = -16f; // To define the default position of the squares on x axis
    float y = 4f; // To define the default position of the squares on y axis
    for (int i = 31; i >= 0; i--) {
      // Create a green square
      Square greenSquare = new Square(x, y, -80f, 4f, 0.0f, 1.0f, 0.0f);
      // Add it to the list of objects
      aliens.add(greenSquare);
      x += 10f; // Increment the x position

      if (i % 4 == 0) {
        x = -16f; // Reset the x position
        y += 6f; // Increment the y position
      }
    }
    return aliens;
  }

  @Override
  public void init(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2(); // Init the background
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Black Background
    gl.glClearDepth(1.0f); // Depth Buffer Setup
    gl.glEnable(GL2.GL_DEPTH_TEST); // Enables Depth Testing
    gl.glDepthFunc(GL2.GL_LEQUAL); // The Type Of Depth Testing To Do
    gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // Really Nice Perspective Calculations
    // Intialise all graphical objects
    this.square1 = new Square(0f, -12f, -40f, 4f, 1.0f, 1.0f, 1.0f);

    this.enemis = initializeAliens();
  }

  @Override
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    GL2 gl = drawable.getGL().getGL2();
    // Set the view area
    gl.glViewport(0, 0, width, height);
    // Setup perspective projection
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    GLU glu = new GLU();
    glu.gluPerspective(45.0, (float) width / height,
        0.1, 100.0);
    // Enable the model view
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
  }

}