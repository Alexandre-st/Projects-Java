import com.jogamp.opengl.GL2;

public class Square extends GraphicalObject {

  public Square(float pX, float pY, float pZ, float scale, float r, float g) {
    super(pX, pY, pZ, scale, r, g);
  }

  public void display_normalized(GL2 gl) {
    gl.glBegin(GL2.GL_QUADS);
    gl.glVertex2f(-0.5f, -0.5f); // Bottom left corner
    gl.glVertex2f(0.5f, -0.5f); // Bottom right corner
    gl.glVertex2f(0.5f, 0.5f); // Top right corner
    gl.glVertex2f(-0.5f, 0.5f); // Top left corner
    gl.glEnd();
  }
}
