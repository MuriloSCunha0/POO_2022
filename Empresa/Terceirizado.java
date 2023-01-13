package Empresa;

public class Terceirizado extends Empregado{
    private Double despesaAdicional;

    
    public Terceirizado(String nome, Integer horas, 
        Double valorPorHora, Double despesaAdicional) 
    {
        
    }

    public Double getDespesaAdicional() {
        return despesaAdicional;
    }

    public void setDespesaAdicional(Double despesaAdicional) {
        this.despesaAdicional = despesaAdicional;
    }

    @Override
    public Double pagamento() {
        return despesaAdicional;
        
    }

    @Override
    public String toString() {
        return super.toString() + ", Despesa adicional: " + despesaAdicional;
    }
}
