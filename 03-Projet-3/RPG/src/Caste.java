public class Caste {
  String casteChoose;
  int lifeBonus;
  int attackBonus;

  public Caste(String casteChoose, int lifeBonus, int attackBonus) {
    this.casteChoose = casteChoose;
    this.lifeBonus = lifeBonus;
    this.attackBonus = attackBonus;
  }

  public String getCaste() {
    return this.casteChoose;
  }
}
