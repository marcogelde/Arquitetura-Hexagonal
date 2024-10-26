package com.senai.escola.application.port;

import com.senai.escola.application.port.input.estudante.EstudanteUseCase;
import com.senai.escola.application.port.output.estudante.EstudanteOutPut;
import com.senai.escola.domain.Estudante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService implements EstudanteUseCase {
    private final EstudanteOutPut estudanteOutPut;

    public EstudanteService(EstudanteOutPut estudanteOutPut) {
        this.estudanteOutPut = estudanteOutPut;
    }

    @Override
    public Estudante criarEstudante(Estudante estudante) {
        return estudanteOutPut.salvar(estudante);
    }

    @Override
    public List<Estudante> buscarTodosEstudantes() {
        return estudanteOutPut.buscarTodos();
    }

    @Override
    public Estudante buscarEstudantePorId(Long id) {
        return estudanteOutPut.buscarPorId(id).orElseThrow(() -> new
                RuntimeException("Estudante não encontrado!"));
    }

    @Override
    public void deletarEstudante(Long id) {
        estudanteOutPut.deletar(id);
    }
}
