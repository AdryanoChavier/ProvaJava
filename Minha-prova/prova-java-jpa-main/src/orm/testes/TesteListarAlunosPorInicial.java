package orm.testes;

import orm.actions.AlunoCrud;
import orm.modelo.Aluno;

import java.util.List;
import java.util.Scanner;

public class TesteListarAlunosPorInicial {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Alunos por Letra Inicial");

        System.out.print("Qual letra inicial pra filtar: ");
        String inicial = leitura.nextLine();

        AlunoCrud alunoCrud = new AlunoCrud();
        List<Aluno> alunosFiltrados = alunoCrud.listarAlunosPorInicial(inicial);

        if (alunosFiltrados.isEmpty()) {
            System.out.println("Não a alunos com esse letra");
        } else {
            System.out.println("Lista de Alunos com a Letra Inicial '" + inicial + "':");
            for (Aluno aluno : alunosFiltrados) {
                System.out.println("ID: " + aluno.getId());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("E-mail: " + aluno.getEmail());
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
                System.out.println("Naturalidade: " + aluno.getNaturalidade());
                System.out.println("Endereço: " + aluno.getEndereco());
            }
        }

        alunoCrud.fecharConexao();
        leitura.close();
    }
}
