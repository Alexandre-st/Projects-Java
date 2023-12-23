import com.jogamp.opengl.GL2;

public abstract class GraphicalObject {
  private float posX, posY, posZ;
  private float r, g, b;
  private float scale;

  public GraphicalObject(float pX, float pY, float pZ, float scale, float r, float g, float b) {
    this.posX = pX;
    this.posY = pY;
    this.posZ = pZ;
    this.scale = scale;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  // Add getters and setters for posX
  public float getPosX() {
    return posX;
  }

  public void setPosX(float posX) {
    this.posX = posX;
  }

  public abstract void display_normalized(GL2 gl);

  public void display(GL2 gl) {
    gl.glPushMatrix();
    gl.glTranslatef(this.posX, this.posY, this.posZ);
    gl.glScalef(this.scale, this.scale, this.scale);
    gl.glColor3f(this.r, this.g, this.b);
    this.display_normalized(gl);
    gl.glPopMatrix();
  }
}