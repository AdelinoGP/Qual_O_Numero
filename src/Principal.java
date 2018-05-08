
public class Principal {

	public static void main(String[] args) {
		Jogo jogo = new Jogo(10);
		
		TelaJogo tela = new TelaJogo(jogo);
		tela.setVisible(true);
	}

}
