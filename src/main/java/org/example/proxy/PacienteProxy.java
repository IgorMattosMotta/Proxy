package org.example.proxy;

import java.util.List;

public class PacienteProxy implements IPaciente {

    private Paciente paciente;

    private Integer prontuario;

    public PacienteProxy(Integer prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.paciente == null) {
            this.paciente = new Paciente(this.prontuario);
        }
        return this.paciente.obterDadosPessoais();
    }

    @Override
    public List<String> obterProntuario(ProfissionalSaude profissional) {
        if (!profissional.isMedico()) {
            throw new IllegalArgumentException("Profissional não autorizado a acessar o prontuário");
        }
        if (this.paciente == null) {
            this.paciente = new Paciente(this.prontuario);
        }
        return this.paciente.obterProntuario(profissional);
    }
}
