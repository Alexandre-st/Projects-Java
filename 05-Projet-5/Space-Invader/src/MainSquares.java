import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;

public class MainSquares extends GLCanvas implements GLEventListener {
  private ArrayList<GraphicalObject> objects3D;
  private Square square1;

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
    this.objects3D = new ArrayList<GraphicalObject>();
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
  }

  @Override
  public void dispose(GLAutoDrawable arg0) {
  }

  @Override
  public void init(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2(); // Init the background
    // gl.glShadeModel(GL2.GL_SMOOTH);
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Black Background
    gl.glClearDepth(1.0f); // Depth Buffer Setup
    gl.glEnable(GL2.GL_DEPTH_TEST); // Enables Depth Testing
    gl.glDepthFunc(GL2.GL_LEQUAL); // The Type Of Depth Testing To Do
    gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // Really Nice Perspective Calculations
    // Intialise all graphical objects
    this.square1 = new Square(0f, 0f, -40f, 4f, 1.0f, 0.0f);
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