package proxy;

import org.example.proxy.BD;
import org.example.proxy.Paciente;
import org.example.proxy.PacienteProxy;
import org.example.proxy.ProfissionalSaude;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PacienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.addPaciente(new Paciente(1, "Carlos", "Unimed", "Hipertensão", "Losartana 50mg"));
        BD.addPaciente(new Paciente(2, "Beatriz", "SUS", "Diabetes tipo 2", "Metformina 850mg"));
    }

    @Test
    void deveRetornarDadosPessoaisPaciente() {
        PacienteProxy paciente = new PacienteProxy(1);

        assertEquals(Arrays.asList("Carlos", "Unimed"), paciente.obterDadosPessoais());
    }

    @Test
    void deveRetornarProntuarioPaciente() {
        ProfissionalSaude medico = new ProfissionalSaude("Dr. Paulo", true);
        PacienteProxy paciente = new PacienteProxy(2);

        assertEquals(Arrays.asList("Diabetes tipo 2", "Metformina 850mg"), paciente.obterProntuario(medico));
    }

    @Test
    void deveRetornarExcecaoProfissionalNaoAutorizadoConsultarProntuario() {
        try {
            ProfissionalSaude recepcionista = new ProfissionalSaude("Joana", false);
            PacienteProxy paciente = new PacienteProxy(2);

            paciente.obterProntuario(recepcionista);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Profissional não autorizado a acessar o prontuário", e.getMessage());
        }
    }
}
