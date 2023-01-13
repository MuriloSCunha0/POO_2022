import java.util.TreeMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class Medico implements IMedico{
    protected String sender;
    protected String classe;
    protected Map<String, IPaciente> pacientes = new TreeMap<>();
    
    // Construtor
    public Medico(String sender, String classe){
        this.sender = sender;
        this.classe = classe;
    }
    // Retorna o identificador do médico
    public String getId(){
        return this.sender;
    }
    // Adiciona um paciente ao médico
    public void addPaciente(IPaciente paciente){
        this.pacientes.put(paciente.getId(), paciente);
    }
    // Remove um paciente do médico
    public void removerPaciente(String idPaciente){
        this.pacientes.remove(idPaciente);
    }
    // Retorna a lista de pacientes do médico
    public Collection<IPaciente> getPacientes(){
        ArrayList<IPaciente> list = new ArrayList<IPaciente>();
        for(String id : this.pacientes.keySet()){
            list.add(this.pacientes.get(id));
        }
        
        return list;
    }
    // Retorna a classe do médico
    public String getClasse(){
        return this.classe;
    }
    // Retorna uma string com a representação do médico
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        String pc = "";
        Iterator<Map.Entry<String, IPaciente>> it = pacientes.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, IPaciente> entry = it.next(); 
            pc += entry.getValue().getId();
            
            if(it.hasNext()){
                pc += ", ";
            }
        }
        
        String name = this.sender + ":" + this.classe;
        sb.append(String.format("Med: %-16s Pacs: [%s]\n", name, pc));

        return sb.toString();
    }
}