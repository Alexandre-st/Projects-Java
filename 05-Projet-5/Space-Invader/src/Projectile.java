import com.jogamp.opengl.GL2;

public class Projectile extends GraphicalObject {
  private float speed;

  public Projectile(float pX, float pY, float pZ, float scale, float r, float g, float b, float speed) {
    super(pX, pY, pZ, scale, 1.0f, 1.0f, 1.0f);
    this.speed = speed;
  }

  public void display_normalized(GL2 gl) {
    gl.glBegin(GL2.GL_QUADS);
    gl.glVertex2f(-0.5f, -0.5f); // Bottom left corner
    gl.glVertex2f(0.5f, -0.5f); // Bottom right corner
    gl.glVertex2f(0.5f, 0.5f); // Top right corner
    gl.glVertex2f(-0.5f, 0.5f); // Top left corner
    gl.glEnd();
  }

  public void move() {
    this.setPosY(this.getPosY() + this.speed);
  }
}
