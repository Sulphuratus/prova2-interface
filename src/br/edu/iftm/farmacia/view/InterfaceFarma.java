package br.edu.iftm.farmacia.view;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import br.edu.iftm.farmacia.classes.*;

public class InterfaceFarma {

	private JFrame janela;
	private JTextField campoNomeMedicamento;
	private JTextField campoPrecoTabelaMed;
	private JTextField campoDiaVencimentoMed;
	private JTextField campoMesVencimentoMed;
	private JTextField campoAnoVencimentoMed;
	private Produto[] produto;
	private int cod, indice, index;
	private Medicamento registra;
	private Higiene registro;
	private JTextField campoCodigoProduto;
	private JTextField campoAlteraCodigoProduto;
	private JTextField campoAlteraNomeProduto;
	private JTextField campoAlteraDiaVencimento;
	private JTextField campoAlteraMesVencimento;
	private JTextField campoAlteraAnoVencimento;
	private JTextField campoAlteraPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		InterfaceFarma window = new InterfaceFarma();
		window.janela.setVisible(true);

	}

	/**
	 * Create the application.
	 */
	public InterfaceFarma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		produto = new Produto[20];
		registra = new Medicamento();
		janela = new JFrame();
		janela.setBounds(100, 100, 420, 507);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);
		
		JPanel abaCadastrar = new JPanel();
		JPanel abaEstoque = new JPanel();
		JPanel abaVencimento = new JPanel();
		JPanel abaAlterar = new JPanel();
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 380, 450);
		janela.getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("Cadastrar", abaCadastrar);
		abaCadastrar.setLayout(null);
		
		tabbedPane.addTab("Consulta", abaEstoque);
		abaEstoque.setLayout(null);
		
		tabbedPane.addTab("Vencimento", abaVencimento);
		abaVencimento.setLayout(null);

		tabbedPane.addTab("Alterar", abaAlterar);
		abaAlterar.setLayout(null);
		
		JLabel codigoAlteraProdutoLabel = new JLabel("Código do Produto:");
		codigoAlteraProdutoLabel.setBounds(37, 28, 176, 41);
		abaAlterar.add(codigoAlteraProdutoLabel);
		
		campoAlteraCodigoProduto = new JTextField();
		campoAlteraCodigoProduto.setBounds(206, 35, 85, 28);
		abaAlterar.add(campoAlteraCodigoProduto);
		campoAlteraCodigoProduto.setColumns(10);
		
		JLabel nomeAlteraProdutoLabel = new JLabel("Nova descrição:");
		nomeAlteraProdutoLabel.setBounds(37, 180, 152, 28);
		abaAlterar.add(nomeAlteraProdutoLabel);
		
		campoAlteraNomeProduto = new JTextField();
		campoAlteraNomeProduto.setBounds(161, 178, 189, 33);
		abaAlterar.add(campoAlteraNomeProduto);
		campoAlteraNomeProduto.setColumns(10);

		JLabel ProdutoAlterarLabel = new JLabel("Produto a alterar:");
		ProdutoAlterarLabel.setBounds(37, 117, 159, 28);
		abaAlterar.add(ProdutoAlterarLabel);
		
		JLabel mostraProdutoAlterarLabel = new JLabel("");
		mostraProdutoAlterarLabel.setBounds(181, 114, 182, 41);
		abaAlterar.add(mostraProdutoAlterarLabel);
		
		JButton botaoConfirmaProduto = new JButton("Confirmar");
		botaoConfirmaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(campoAlteraCodigoProduto.getText());
				mostraProdutoAlterarLabel.setText(produto[numero-1].getNome());
				indice = numero;
			}
		});
		botaoConfirmaProduto.setBounds(206, 81, 117, 25);
		abaAlterar.add(botaoConfirmaProduto);
		
		JLabel alteraDiaVencimentoLabel = new JLabel("Novo dia de vencimento:");
		alteraDiaVencimentoLabel.setBounds(37, 220, 197, 28);
		abaAlterar.add(alteraDiaVencimentoLabel);
		
		campoAlteraDiaVencimento = new JTextField();
		campoAlteraDiaVencimento.setBounds(236, 222, 114, 25);
		abaAlterar.add(campoAlteraDiaVencimento);
		campoAlteraDiaVencimento.setColumns(10);
		
		JLabel alteraMesVencimentoLabel = new JLabel("Novo mês de vencimento:");
		alteraMesVencimentoLabel.setBounds(37, 262, 189, 28);
		abaAlterar.add(alteraMesVencimentoLabel);
		
		campoAlteraMesVencimento = new JTextField();
		campoAlteraMesVencimento.setBounds(236, 263, 114, 25);
		abaAlterar.add(campoAlteraMesVencimento);
		campoAlteraMesVencimento.setColumns(10);
		
		JLabel alteraAnoVencimentoLabel = new JLabel("Novo ano de vencimento:");
		alteraAnoVencimentoLabel.setBounds(37, 304, 187, 28);
		abaAlterar.add(alteraAnoVencimentoLabel);
		
		campoAlteraAnoVencimento = new JTextField();
		campoAlteraAnoVencimento.setBounds(236, 303, 114, 25);
		abaAlterar.add(campoAlteraAnoVencimento);
		campoAlteraAnoVencimento.setColumns(10);

		JLabel alteraPrecoTabelaLabel = new JLabel("Novo preço de tabela:");
		alteraPrecoTabelaLabel.setBounds(37, 344, 189, 28);
		abaAlterar.add(alteraPrecoTabelaLabel);
		
		campoAlteraPreco = new JTextField();
		campoAlteraPreco.setBounds(236, 343, 114, 25);
		abaAlterar.add(campoAlteraPreco);
		campoAlteraPreco.setColumns(10);
		
		JButton botaoAlteraProduto = new JButton("Alterar");
		botaoAlteraProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produto[indice-1].setNome(campoAlteraNomeProduto.getText());
				produto[indice-1].setDiaVencimento(Integer.parseInt(campoAlteraDiaVencimento.getText()));
				produto[indice-1].setMesVencimento(Integer.parseInt(campoAlteraMesVencimento.getText()));
				produto[indice-1].setAnoVencimento(Integer.parseInt(campoAlteraAnoVencimento.getText()));
				produto[indice-1].setPreco(Double.parseDouble(campoAlteraPreco.getText()));
				
				campoAlteraCodigoProduto.setText("");
				campoAlteraNomeProduto.setText("");
				campoAlteraDiaVencimento.setText("");
				campoAlteraMesVencimento.setText("");
				campoAlteraAnoVencimento.setText("");
				campoAlteraPreco.setText("");
			}
		});
		botaoAlteraProduto.setBounds(138, 386, 117, 25);
		abaAlterar.add(botaoAlteraProduto);
		
		JLabel prodMenorVencimentoLabel = new JLabel("Produto de menor prazo de vencimento");
		prodMenorVencimentoLabel.setBounds(50, 24, 313, 32);
		abaVencimento.add(prodMenorVencimentoLabel);
		
		JLabel nomeMenorPrazoLabel = new JLabel("Descrição:");
		nomeMenorPrazoLabel.setBounds(12, 118, 124, 32);
		abaVencimento.add(nomeMenorPrazoLabel);
		
		JLabel nomeMenorVencimentoLabel = new JLabel("");
		nomeMenorVencimentoLabel.setBounds(113, 110, 250, 40);
		abaVencimento.add(nomeMenorVencimentoLabel);
		
		JLabel prazoMenorVencimentoLabel = new JLabel("Prazo para vencimento:");
		prazoMenorVencimentoLabel.setBounds(12, 188, 168, 32);
		abaVencimento.add(prazoMenorVencimentoLabel);
		
		JLabel mostraMenorVencimentoLabel = new JLabel("");
		mostraMenorVencimentoLabel.setBounds(204, 188, 159, 32);
		abaVencimento.add(mostraMenorVencimentoLabel);
		
		JLabel precoAtualizaMenorVencLabel = new JLabel("Preço atualizado:");
		precoAtualizaMenorVencLabel.setBounds(12, 232, 179, 32);
		abaVencimento.add(precoAtualizaMenorVencLabel);
		
		JLabel mostraPrecoAtualVencimento = new JLabel("");
		mostraPrecoAtualVencimento.setBounds(195, 232, 168, 32);
		abaVencimento.add(mostraPrecoAtualVencimento);
		
		JButton botaoVerificaMenorValidade = new JButton("Verificar");
		botaoVerificaMenorValidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			index = Estoque.mostrarMenorValidade(produto, cod);
			nomeMenorVencimentoLabel.setText(""+produto[index].getNome());
			mostraMenorVencimentoLabel.setText(""+produto[index].calcularVencimento());
			mostraPrecoAtualVencimento.setText("R$ "+produto[index].calcularPreco());

			}
		});
		botaoVerificaMenorValidade.setBounds(74, 66, 241, 32);
		abaVencimento.add(botaoVerificaMenorValidade);
		
		JLabel labelDescricaoMed = new JLabel("Descrição:");
		labelDescricaoMed.setBounds(12, 22, 129, 30);
		abaCadastrar.add(labelDescricaoMed);
		
		campoNomeMedicamento = new JTextField();
		campoNomeMedicamento.setBounds(107, 28, 256, 48);
		abaCadastrar.add(campoNomeMedicamento);
		campoNomeMedicamento.setColumns(10);
		
		JLabel labelPrecoTabelaMed = new JLabel("Preço de Tabela:");
		labelPrecoTabelaMed.setBounds(12, 88, 155, 30);
		abaCadastrar.add(labelPrecoTabelaMed);
		
		campoPrecoTabelaMed = new JTextField();
		campoPrecoTabelaMed.setBounds(258, 94, 105, 24);
		abaCadastrar.add(campoPrecoTabelaMed);
		campoPrecoTabelaMed.setColumns(10);
		
		JLabel labelDiaVencimentoMed = new JLabel("Dia de Vencimento:");
		labelDiaVencimentoMed.setBounds(12, 142, 144, 24);
		abaCadastrar.add(labelDiaVencimentoMed);
		
		campoDiaVencimentoMed = new JTextField();
		campoDiaVencimentoMed.setBounds(258, 145, 105, 24);
		abaCadastrar.add(campoDiaVencimentoMed);
		campoDiaVencimentoMed.setColumns(10);
		
		JLabel labelMesVencimentoMed = new JLabel("Mes de Vencimento:");
		labelMesVencimentoMed.setBounds(12, 186, 144, 30);
		abaCadastrar.add(labelMesVencimentoMed);
		
		campoMesVencimentoMed = new JTextField();
		campoMesVencimentoMed.setBounds(258, 190, 105, 24);
		abaCadastrar.add(campoMesVencimentoMed);
		campoMesVencimentoMed.setColumns(10);
		
		JLabel labelAnoVencimentoMed = new JLabel("Ano de Vencimento:");
		labelAnoVencimentoMed.setBounds(12, 237, 155, 24);
		abaCadastrar.add(labelAnoVencimentoMed);
		
		campoAnoVencimentoMed = new JTextField();
		campoAnoVencimentoMed.setBounds(258, 237, 105, 24);
		abaCadastrar.add(campoAnoVencimentoMed);
		campoAnoVencimentoMed.setColumns(10);
		
		JButton botaoCadastroMed = new JButton("Cadastrar Medicamento");
		botaoCadastroMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				registra = new Medicamento();
				registra.setNome(campoNomeMedicamento.getText());
				registra.setPreco(Double.parseDouble(campoPrecoTabelaMed.getText()));
				registra.setDiaVencimento(Integer.parseInt(campoDiaVencimentoMed.getText()));
				registra.setMesVencimento(Integer.parseInt(campoMesVencimentoMed.getText()));
				registra.setAnoVencimento(Integer.parseInt(campoAnoVencimentoMed.getText()));
				registra.setCodigoNumerico(cod+1);
				produto[cod] = registra;
				cod++;

				campoNomeMedicamento.setText("");
				campoPrecoTabelaMed.setText("");
				campoPrecoTabelaMed.setText("");
				campoDiaVencimentoMed.setText("");
				campoMesVencimentoMed.setText("");
				campoAnoVencimentoMed.setText("");

			}


		});
		botaoCadastroMed.setBounds(66, 295, 235, 30);
		abaCadastrar.add(botaoCadastroMed);
		
		JButton botaoCadastrarHig = new JButton("Cadastrar Produto de Higiene");
		botaoCadastrarHig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro = new Higiene();
				registro.setNome(campoNomeMedicamento.getText());
				registro.setPreco(Double.parseDouble(campoPrecoTabelaMed.getText()));
				registro.setDiaVencimento(Integer.parseInt(campoDiaVencimentoMed.getText()));
				registro.setMesVencimento(Integer.parseInt(campoMesVencimentoMed.getText()));
				registro.setAnoVencimento(Integer.parseInt(campoAnoVencimentoMed.getText()));
				registro.setCodigoNumerico(cod+1);
				produto[cod] = registro;
				cod++;

				campoNomeMedicamento.setText("");
				campoPrecoTabelaMed.setText("");
				campoPrecoTabelaMed.setText("");
				campoDiaVencimentoMed.setText("");
				campoMesVencimentoMed.setText("");
				campoAnoVencimentoMed.setText("");
			}
		});
		botaoCadastrarHig.setBounds(47, 340, 275, 30);
		abaCadastrar.add(botaoCadastrarHig);
		
		JLabel codigoMedicamentoLabel = new JLabel("Código do Produto:");
		codigoMedicamentoLabel.setBounds(12, 26, 150, 40);
		abaEstoque.add(codigoMedicamentoLabel);
		
		campoCodigoProduto = new JTextField();
		campoCodigoProduto.setBounds(235, 37, 77, 29);
		abaEstoque.add(campoCodigoProduto);
		campoCodigoProduto.setColumns(10);
		
		JLabel periodoVencimentoLabel = new JLabel("Prazo para Vencimento:");
		periodoVencimentoLabel.setBounds(12, 252, 170, 40);
		abaEstoque.add(periodoVencimentoLabel);
		
		JLabel precoAtualLabel = new JLabel("Preço atual:");
		precoAtualLabel.setBounds(12, 315, 170, 29);
		abaEstoque.add(precoAtualLabel);

		JLabel prazoLabel = new JLabel("");
		prazoLabel.setBounds(198, 260, 114, 21);
		abaEstoque.add(prazoLabel);
		
		JLabel precoLabel = new JLabel("");
		precoLabel.setBounds(190, 315, 122, 29);
		abaEstoque.add(precoLabel);

		JLabel mostraProdutoLabel = new JLabel("Produto:");
		mostraProdutoLabel.setBounds(12, 168, 99, 40);
		abaEstoque.add(mostraProdutoLabel);
		
		JLabel produtoLabel = new JLabel("");
		produtoLabel.setBounds(96, 168, 267, 40);
		abaEstoque.add(produtoLabel);
		
		JButton botaoCalcularPrazoPreco = new JButton("Calcular");
		botaoCalcularPrazoPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(campoCodigoProduto.getText());

				produtoLabel.setText(""+produto[numero-1].getNome());
				prazoLabel.setText(""+produto[numero-1].calcularVencimento()+" dias.");
				precoLabel.setText("R$ "+produto[numero-1].calcularPreco());
				campoCodigoProduto.setText("");
			}
		});
		botaoCalcularPrazoPreco.setBounds(77, 113, 235, 29);
		abaEstoque.add(botaoCalcularPrazoPreco);
		
		
		
	}
}
