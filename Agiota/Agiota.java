import java.util.ArrayList;
  import java.util.Iterator;
  import java.util.List;
  import java.util.Map;
  import java.util.TreeMap;
import java.util.Map.Entry;

  public class Agiota {
    private int balanco;
    private int nextT;
    Map<String, Client> repCli;
    Map<Integer, Transaction> repTr;

    Agiota(int balanco) {
      this.balanco = balanco;
      this.nextT = 0;
      repCli = new TreeMap<>();
      repTr = new TreeMap<>();
    }
    
    public int getBalance() {
      return balanco;
    }
    

    public void addClient(String codename, int limite) {
      Iterator<Map.Entry<String, Client>> it = repCli.entrySet().iterator();
      if (!it.hasNext()) {
        Client c = new Client(codename, limite);
        repCli.put(codename, new Client(codename, limite));
      }
      while (it.hasNext()) {
        if (it.next().getKey().equals(codename)) {
          System.out.println("fail: cliente ja existe");
          return;
        }
      }
      repCli.put(codename, new Client(codename, limite));
    }

    public Client getClient(String nome) {
      Iterator<Map.Entry<String, Client>> it = repCli.entrySet().iterator();
      if (!it.hasNext()) {
        System.out.println("fail: cliente nao existe");
        return null;
      }
      for (Entry<String, Client> cliente : repCli.entrySet()) {
        if(cliente.getValue().getCodename().equals(nome))
          return cliente.getValue();
      }

      System.out.println("fail: cliente nao existe");
      return null;
    }

    public void kill(String codename) {
      List<Integer> killed = new ArrayList<>();
      for(Map.Entry<Integer,Transaction> par : repTr.entrySet()){
        if(par.getValue().getCodename().equals(codename))
          killed.add(par.getKey());
      }
      for (Integer integer : killed) {
        repTr.remove(integer);
      }
      repCli.remove(codename);

    }

    public void lends(String codenome, int value) {
      Client client = getClient(codenome);
      if (client == null) {
        return;
      }
      if (balanco < value) {
        System.out.println("fail: fundos insuficientes");
        return;
      }
      if (client.getLimite() < value + client.getBalance()) {
        System.out.println("fail: limite excedido");
        return;
      }
      repTr.put(nextT, new Transaction(codenome, nextT, value));
      client.setBalance(value + client.getBalance());
      balanco -= value;
      nextT++;
    }

    public void receive (String codename, int value){
      Client client = getClient(codename);
      if(client == null){
        return;
      }
      if(value > client.getBalance()){
        System.out.println("fail: valor maior que a divida");
        return;
      }
      client.setBalance(client.getBalance() - value);
      balanco += value;
      repTr.put(nextT, new Transaction(codename, nextT, value * -1));
      nextT++;

    }
    @Override
    public String toString() {
      StringBuilder imprime = new StringBuilder();
      Iterator<Map.Entry<String, Client>> itClient = repCli.entrySet().iterator();
      imprime.append("clients:\n");
      while (itClient.hasNext()) {
        imprime.append(itClient.next().getValue().toString() + "\n");
      }
      Iterator<Map.Entry<Integer, Transaction>> itTr = repTr.entrySet().iterator();
      imprime.append("transactions:\n");
      while (itTr.hasNext()) {
        imprime.append(itTr.next().getValue().toString()+ "\n");
      }
      imprime.append("balanco: " + balanco);

      return imprime.toString();
    }
  }
