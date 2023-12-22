import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;

import javax.swing.*;
import java.awt.*;

public class MainGL extends GLCanvas implements GLEventListener {

  public static void main(String[] args) {

    GLCanvas canvas = new MainGL();
    canvas.setPreferredSize(new Dimension(800, 600));
    final JFrame frame = new JFrame();
    frame.getContentPane().add(canvas);
    frame.setTitle("OPENGL #1");
    frame.pack();
    frame.setVisible(true);
    // Animator permet de créer une boucle infinie qui lancera toutes les fonctions
    // d'affichage.
    Animator animator = new Animator(canvas);
    animator.start();
  }

  public MainGL() {
    this.addGLEventListener(this);
  }

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
    GL2 gl = glAutoDrawable.getGL().getGL2();
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
  }

  @Override
  public void dispose(GLAutoDrawable glAutoDrawable) {
  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {

    GL2 gl = glAutoDrawable.getGL().getGL2();
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    gl.glTranslatef(0.0f, 0.0f, -0.02f);
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {
    GL2 gl = glAutoDrawable.getGL().getGL2();
    // setup perspective projection
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    GLU glu = new GLU();
    glu.gluPerspective(45.0, (float) i2 / i3, 0.1, 100.0);
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
  }
}