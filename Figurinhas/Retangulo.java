public class Retangulo extends Shape
{
  private Ponto2D infoesq;
  private Ponto2D subdireito;

  public Retangulo(Ponto2D infoesq, Ponto2D subdireito) {
    this.infoesq = infoesq;
    this.subdireito = subdireito;
  }

  public Ponto2D getInfEsq() {
    return infoesq;
  }

  public Ponto2D getSubDir() {
    return subdireito;
  }
  private double getWidt(){
    double l;
    l = subdireito.getX() - infoesq.getX();
//    l = infoesq.getX() - subdireito.getX();
//    l = Math.sqrt(Math.pow((subdireito.getX() - infoesq.getX()),2) + Math.pow((subdireito.getY() - infoesq.getY()),2));
    if(l < 0)
      l = l * -1;
    return l;
  }
  private double getHeight(){
    double i;
    i = subdireito.getY() - infoesq.getY();
//    i = infoesq.getY() - subdireito.getY();
    if(i < 0)
      i = i * -1;
    return i;
  }
  @Override
  double area() {
//    double l = Math.sqrt(Math.pow((subdireito.getX() - infoesq.getX()),2) + Math.pow((subdireito.getY() - infoesq.getY()),2));
    return getWidt() * getHeight();
  }

  @Override
  double perimeter() {
//    double l = Math.sqrt(Math.pow((subdireito.getX() - infoesq.getX()),2) + Math.pow((subdireito.getY() - infoesq.getY()),2));
    return 2 * (getHeight() + getWidt());
  }

  @Override
  public boolean inside(Ponto2D p) {
    boolean inside = false;
    if(p.getY() <= subdireito.getY() && p.getY() >= infoesq.getY())
      inside = true;
    if(p.getX() <= subdireito.getX() && p.getX() >= infoesq.getX() )
      inside = true;
    return inside;
  }

  @Override
  public String toString() {
    return String.format("Retângulo com cantos (%.1f,%.1f) e (%.1f,%.1f)", infoesq.getX(), infoesq.getY(), subdireito.getX(), subdireito.getY());
  }
}
