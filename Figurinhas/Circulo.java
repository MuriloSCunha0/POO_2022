public class Circulo extends Shape {
    private double r;
    private Ponto2D center;
  
    public Circulo(Ponto2D center, double r) {
      this.center = center;
      this.r = r;
    }
  
    public double getRaio() {
      return r;
    }
  
    public Ponto2D getCentro() {
      return center;
    }
  
    @Override
    double area() {
      return Math.PI * Math.pow(r, 2);
    }
  
    @Override
    double perimeter() {
      return 2 * Math.PI * r;
    }
  
    @Override
    boolean inside(Ponto2D p) {
      double d;
      d = Math.sqrt(Math.pow((p.getX() - center.getX()), 2) + Math.pow((p.getY() - center.getY()), 2));
      return d <= getRaio();
    }
  
    @Override
    public String toString() {
      return String.format("Círculo com center em (%.1f,%.1f) e r %.1f", center.getX(), center.getY(), r);
    }
  }