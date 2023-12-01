package orm.testes;

import orm.actions.AlunoCrud;
import orm.modelo.Aluno;

import java.util.Scanner;

public class TesteRemoverAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Remoção de Aluno");
        
        System.out.print("Informe o ID do aluno a ser removido: ");
        Long idAluno = Long.parseLong(scanner.nextLine());

        AlunoCrud alunoCrud = new AlunoCrud();
        Aluno alunoParaRemover = alunoCrud.buscarAluno(idAluno);

        if (alunoParaRemover == null) {
            System.out.println("Não encontrado.");
        } else {
            alunoCrud.removerAluno(idAluno);

            System.out.println("Aluno removido com sucesso!");
        }

        alunoCrud.fecharConexao();
        scanner.close();
    }
}
