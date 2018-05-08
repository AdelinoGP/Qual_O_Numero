import java.util.Date;
import java.util.Random;

public class Jogo {
	private Random rng;
	private int numRng;
	private int numMaximo;
	private int tentativas;
	
	
	public Jogo(int numMaximo) {
		this.numMaximo = numMaximo;
		rng = new Random(new Date().getTime());
		tentativas = 0;
	}


	public int getTentativas() {
		return tentativas;
	}
	
	public void inicia() {
		tentativas = 0;
		numRng = rng.nextInt(numMaximo);
	}
	
	public int executaJogada (int palpite) {
		tentativas++;
		if(palpite == numRng)
			return 0;		//Correto
		if (palpite > numRng)
			return 1;		//Alto
		else 
			return -1;		//Baixo
	}
	
}
