import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class TelaJogo extends JFrame implements ActionListener {
	private Jogo jogo;
	private JButton btOK;
	private JButton btNovo;
	private JTextField tfEntrada;
	private JTextField tfTentativas;
	private JLabel lbMensagem;
	private Font font1;
	private Font font2;
	private Font font3;

	public TelaJogo(Jogo jogo) {
		jogo.inicia();
		this.jogo = jogo;

		this.setSize(310, 200);
		this.setTitle("JOGO: Qual o Número?");
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		btOK = new JButton("OK");
		btOK.setSize(60, 30);
		btOK.setLocation(112, 10);
		btOK.addActionListener(this);
		this.add(btOK);

		btNovo = new JButton("Novo");
		btNovo.setSize(70, 30);
		btNovo.setLocation(75, 125);
		btNovo.addActionListener(this);
		this.add(btNovo);

		font1 = new Font("Courier new", Font.BOLD, 20);
		tfEntrada = new JTextField();
		tfEntrada.setSize(60, 30);
		tfEntrada.setLocation(50, 10);
		tfEntrada.setFont(font1);
		this.add(tfEntrada);

		font2 = new Font("Comic Sans MS", Font.BOLD, 20);
		lbMensagem = new JLabel();
		lbMensagem.setSize(200, 30);
		lbMensagem.setLocation(10, 75);
		lbMensagem.setFont(font2);
		lbMensagem.setHorizontalAlignment(JTextField.CENTER);
		this.add(lbMensagem);

		font3 = new Font("Courier new", Font.BOLD, 50);
		tfTentativas = new JTextField("0");
		tfTentativas.setSize(70, 80);
		tfTentativas.setLocation(220, 50);
		tfTentativas.setFont(font3);
		tfTentativas.setBackground(new Color(0, 0, 0));
		tfTentativas.setForeground(new Color(0, 255, 0));
		tfTentativas.setEditable(false);
		tfTentativas.setHorizontalAlignment(JTextField.CENTER);
		this.add(tfTentativas);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btNovo) {
			lbMensagem.setText("Escolha um número!");
			tfTentativas.setText("0");
			tfEntrada.setText("");
			jogo.inicia();
		}
		if (evento.getSource() == btOK) {
			int temp = jogo.executaJogada(Integer.parseInt(tfEntrada.getText()));
			if (temp == 0)
				lbMensagem.setText("Acertou!!");
			if (temp == -1)
				lbMensagem.setText("Palpite baixo");
			if (temp == 1)
				lbMensagem.setText("Palpite alto");
			tfEntrada.setText("");
			tfTentativas.setText(Integer.toString(jogo.getTentativas()));
		}
	}
}
