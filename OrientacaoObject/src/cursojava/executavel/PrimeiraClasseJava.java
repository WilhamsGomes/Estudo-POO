package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classes.Secretario;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.interfaces.PermitirAcesso;

public class PrimeiraClasseJava {

	public static void main(String[] args) {
		
		String login = JOptionPane.showInputDialog("Informe o login");
		String senha = JOptionPane.showInputDialog("Informe a senha");
		
		if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) { /*Vou travar o contrato para autorizar somente quem realmente tem o contrato 100% legítimo*/
		
			List<Aluno> alunos = new ArrayList<Aluno>();
			
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
			
			for (int qtd = 1; qtd <= 5; qtd++) {
			
				/*new Aluno() é uma instancia (criação de obj)*/
				/* aluno1 é uma referência para o objeto Aluno*/
				
				String nome = JOptionPane.showInputDialog("Qual o nome do aluno "+qtd+"?");
				System.out.println("TESTE");
				System.out.println("Passei daquiaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				/*String idade = JOptionPane.showInputDialog("Qual a idade do aluno?");
				String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno?");
				String registroGeral = JOptionPane.showInputDialog("Qual o RG do aluno?");
				String cpf = JOptionPane.showInputDialog("Qual o CPF do aluno?");
				String nomeMae = JOptionPane.showInputDialog("Qual o nome da mãe do aluno?");
				String nomePai = JOptionPane.showInputDialog("Qual o nome do pai do aluno?");
				String dataMatricula = JOptionPane.showInputDialog("Qual a data de matrícula do aluno?");
				String serieAluno = JOptionPane.showInputDialog("Qual a série do aluno?");
				String nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola?"); */
				
				Aluno aluno1 = new Aluno();
				
				aluno1.setNome(nome);
				/*aluno1.setIdade(Integer.valueOf(idade));
				aluno1.setDataNascimento(dataNascimento);
				aluno1.setRegistroGeral(registroGeral);
				aluno1.setNumeroCpf(cpf);
				aluno1.setNomeMae(nomeMae);
				aluno1.setNomePai(nomePai);
				aluno1.setDataMatricula(dataMatricula);
				aluno1.setSerieMatriculado(serieAluno);
				aluno1.setNomeEscola(nomeEscola);*/
				
				for(int pos = 1; pos <= 1; pos++) {
					
					String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina "+pos+"?");
					String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina "+pos+"?");
					
					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));
					
					aluno1.getDisciplina().add(disciplina);
				}
				
				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
				
				if(escolha == 0) {
					
					int continuarRemover = 0;
					int posicao = 1;
					while(continuarRemover == 0) {
						String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4?");
						aluno1.getDisciplina().remove((Integer.valueOf(disciplinaRemover).intValue())-posicao);
						posicao++;
						continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
					}
				}
				
				alunos.add(aluno1);
			}
			
			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			
			for (Aluno aluno : alunos) {
				
				if(aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);
				} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.REPROVADO)) {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
				
			}
			
			System.out.println("-----------------Lista dos aprovados-----------------");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Nome: " +aluno.getNome());
				System.out.println("Média: "+aluno.getMediaNota());
			}
			
			System.out.println("-----------------Lista da recuperação-----------------");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println("Nome: " +aluno.getNome());
				System.out.println("Média: "+aluno.getMediaNota());
			}
			
			System.out.println("-----------------Lista dos reprovados-----------------");
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("Nome: " +aluno.getNome());
				System.out.println("Média: "+aluno.getMediaNota());
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Senha ou login inválido(s)!");
		}

	}

}
