public class Transaction {
    private String codename;
  
    private int identifcacao;
  
    private int valor;
  
    public Transaction(String codename, int identifcacao, int valor) {
      this.codename = codename;
      this.identifcacao = identifcacao;
      this.valor = valor;
    }
  
    public String getCodename() {
      return codename;
    }
  
    public int getId() {
      return identifcacao;
    }
  
    public void setId(int identifcacao) {
      this.identifcacao = identifcacao;
    }
  
    public int getValue() {
      return valor;
    }
  
    public void setValue(int valor) {
      this.valor = valor;
    }
  
    @Override
    public String toString() {
      return "- " + identifcacao + ":" + codename + ":" + valor;
    }
  
  }