import java.util.Collection;

interface IMedico {
    // Retorna o identificador do médico
    public String getId();
    // Adiciona um paciente ao médico
    public void addPaciente(IPaciente paciente);
    // Remove um paciente do médico
    public void removerPaciente(String idPaciente);
    // Retorna a lista de pacientes do médico
    public Collection<IPaciente> getPacientes();
    // Retorna a classe do médico
    public String getClasse();
    // Retorna uma string com a representação do médico
}