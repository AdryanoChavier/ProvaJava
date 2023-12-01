package orm.testes;

import orm.actions.AlunoCrud;
import orm.modelo.Aluno;

import java.util.Scanner;

public class TesteAtualizarAluno {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Atualização de Dados do Aluno");

        System.out.print("ID do aluno a ser atualizado: ");
        Long idAluno = Long.parseLong(leitura.nextLine());

        AlunoCrud alunoCrud = new AlunoCrud();
        Aluno alunoParaAtualizar = alunoCrud.buscarAluno(idAluno);

        if (alunoParaAtualizar == null) {
            System.out.println("Aluno não encontrado com o ID informado.");
        } else {
            System.out.println("Informe os novos dados do aluno:");

            System.out.print("Nome: ");
            alunoParaAtualizar.setNome(leitura.nextLine());

            System.out.print("E-mail: ");
            alunoParaAtualizar.setEmail(leitura.nextLine());

            System.out.print("Novo CPF: ");
            alunoParaAtualizar.setCpf(leitura.nextLine());

            System.out.print("Nova data de nascimento: ");
            alunoParaAtualizar.setDataNascimento(leitura.nextLine());

            System.out.print("Nova naturalidade: ");
            alunoParaAtualizar.setNaturalidade(leitura.nextLine());

            System.out.print("Novo endereço: ");
            alunoParaAtualizar.setEndereco(leitura.nextLine());

            alunoCrud.atualizarAluno(alunoParaAtualizar);

            System.out.println("Aluno atualizado com sucesso!");

        }

        alunoCrud.fecharConexao();
        leitura.close();
    }
}
