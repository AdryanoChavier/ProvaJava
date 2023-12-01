package orm.testes;

import orm.actions.AlunoCrud;
import orm.modelo.Aluno;

import java.util.List;

public class TesteListarAlunos {
    public static void main(String[] args) {
        AlunoCrud alunoCrud = new AlunoCrud();

        List<Aluno> alunos = alunoCrud.listarAlunos();

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno encontrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (Aluno aluno : alunos) {
                System.out.println("ID: " + aluno.getId());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("E-mail: " + aluno.getEmail());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
                System.out.println("Naturalidade: " + aluno.getNaturalidade());
                System.out.println("Endereço: " + aluno.getEndereco());
              
            }
        }
    }
}
