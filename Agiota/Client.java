public class Client {
    private int balance;
  
    private String nextT;
  
    private int limit;
  
    public Client(String nextT, int limit) {
      this.nextT = nextT;
      this.limit = limit;
      this.balance = 0;
    }
  
    public int getBalance() {
      return balance;
    }
  
    public void setBalance(int balance) {
      this.balance = balance;
    }
  
    public String getCodename() {
      return nextT;
    }
  
    public void setCodename(String nextT) {
      this.nextT = nextT;
    }
  
    public int getLimite() {
      return limit;
    }
  
    @Override
    public String toString() {
      return "- " + nextT + ":" + balance + "/" + limit;
    }
  
  }