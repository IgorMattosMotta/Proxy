package org.example.proxy;

import java.util.List;

public interface IPaciente {
    List<String> obterDadosPessoais();
    List<String> obterProntuario(ProfissionalSaude profissional);
}
