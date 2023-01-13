import java.util.TreeMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class Paciente implements IPaciente {
    protected String sender;
    protected String diagnostico;
    protected TreeMap<String, IMedico> medicos = new TreeMap<>();

    // Construtor
    public Paciente(String sender, String diagnostico){
        this.sender = sender;
        this.diagnostico = diagnostico;
    }
    // Retorna o identificador do paciente
    public String getId(){
        return this.sender;
    }
    // Adiciona um médico ao paciente
    public void addMedico(IMedico medico){
        this.medicos.put(medico.getId(), medico);
    }
    // Remove um médico do paciente
    public void removerMedico(String idMedico){
        this.medicos.remove(idMedico);
    }
    // Retorna a lista de médicos do paciente
    public Collection<IMedico> getMedicos(){
        ArrayList<IMedico> list = new ArrayList<IMedico>();
        for(String id : this.medicos.keySet()){
            list.add(this.medicos.get(id));
        }
        
        return list;
    }
    // Retorna uma string com a representação do paciente
    public String getDiagnostico(){
        return this.diagnostico;
    }
    // Retorna o diagnostico do paciente
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        String med = "";
        Iterator<Map.Entry<String, IMedico>> it = medicos.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, IMedico> entry = it.next(); 
            med += entry.getValue().getId();
            
            if(it.hasNext()){
                med += ", ";
            }
        }
        
        String name = this.sender + ":" + this.diagnostico;
        sb.append(String.format("Pac: %-16s Meds: [%s]\n", name, med));

        return sb.toString();
    }
}