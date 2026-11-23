package org.example.proxy;

import java.util.Arrays;
import java.util.List;

public class Paciente implements IPaciente {

    private Integer prontuario;
    private String nome;
    private String convenio;
    private String diagnostico;
    private String prescricao;

    public Paciente(int prontuario) {
        this.prontuario = prontuario;
        Paciente objeto = BD.getPaciente(prontuario);
        this.nome = objeto.nome;
        this.convenio = objeto.convenio;
        this.diagnostico = objeto.diagnostico;
        this.prescricao = objeto.prescricao;
    }

    public Paciente(Integer prontuario, String nome, String convenio, String diagnostico, String prescricao) {
        this.prontuario = prontuario;
        this.nome = nome;
        this.convenio = convenio;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }

    public Integer getProntuario() {
        return prontuario;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.convenio);
    }

    @Override
    public List<String> obterProntuario(ProfissionalSaude profissional) {
        return Arrays.asList(this.diagnostico, this.prescricao);
    }
}
