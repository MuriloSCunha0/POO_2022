import java.util.Collection;

interface IPaciente {
    // Retorna o identificador do paciente
    public String getId();
    // Adiciona um médico ao paciente
    public void addMedico(IMedico medico);
    // Remove um médico do paciente
    public void removerMedico(String idMedico);
    // Retorna a lista de médicos do paciente
    public Collection<IMedico> getMedicos();
    // Retorna uma string com a representação do paciente
    public String getDiagnostico();
    // Retorna o diagnostico do paciente
}