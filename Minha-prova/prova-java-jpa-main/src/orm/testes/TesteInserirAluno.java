package orm.testes;

import orm.actions.AlunoCrud;
import orm.modelo.Aluno;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteInserirAluno {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Aluno aluno = new Aluno();

        System.out.print("Nome do Aluno: ");
        aluno.setNome(leitura.nextLine());
        System.out.print("Email do Aluno: ");
        aluno.setEmail(leitura.nextLine());
        System.out.print("CPF do Aluno: ");
        aluno.setCpf(leitura.nextLine());
        System.out.print("Data de nascimento do Aluno: ");
        aluno.setDataNascimento(leitura.nextLine());
        System.out.print("Naturalidade do Aluno: ");
        aluno.setNaturalidade(leitura.nextLine());
        System.out.print("Endereço do Aluno: ");
        aluno.setEndereco(leitura.nextLine());

        AlunoCrud alunoCrud = new AlunoCrud();
        alunoCrud.inserirAluno(aluno);

        alunoCrud.fecharConexao();
        leitura.close();
		}

    }

