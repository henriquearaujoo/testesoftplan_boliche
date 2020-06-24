package br.com.softplan.testesoftplan.modelo;

public class CalculadoraPontuacaoBoliche {
	
	public int pontuacaoTotal(int[] jogadas) {
		int total = 0;
		int jogadaAtual = 1;
		
		while (jogadaAtual < (jogadas.length - 1)) {
			if (temStrike(jogadas, jogadaAtual)) {
				total += calculaBonusStrike(jogadas, jogadaAtual);
				jogadaAtual-=1;
			}else if (temSpare(jogadas, jogadaAtual)) {				
				total += calculaBonusSpare(jogadas, jogadaAtual);
			}
			else {
				total += jogadas[jogadaAtual - 1];
				total += jogadas[jogadaAtual];
			}
			
			jogadaAtual+=2;
		}
		
		return total;
	}
	
	private int calculaBonusSpare(int[] jogadas, int jogadaAtual) {
		int total = 0;
		int terceira = 0;
		jogadaAtual--;
		
		int atual = jogadas[jogadaAtual];
		
		jogadaAtual++;
		
		if (!podeIrParaProxima(jogadas, jogadaAtual))
			return atual;
		
		int proxima = jogadas[jogadaAtual];
		
		jogadaAtual++;
		
		if (podeIrParaProxima(jogadas, jogadaAtual))
			terceira = jogadas[jogadaAtual];
		
		total = atual + proxima + terceira;
		
		return total;
	}
	
	private int calculaBonusStrike(int[] jogadas, int jogadaAtual) {
		int total = 0;
		jogadaAtual--;
		
		int atual = jogadas[jogadaAtual];
		
		jogadaAtual++;
		
		if (!podeIrParaProxima(jogadas, jogadaAtual))
			return atual;
		
		int segunda = jogadas[jogadaAtual];
		
		jogadaAtual++;
		
		if (!podeIrParaProxima(jogadas, jogadaAtual))
			return atual + segunda;
		
		int terceira = jogadas[jogadaAtual];
		
		total = atual + segunda + terceira;
		
		return total;
	}
	
	private boolean temSpare(int[] jogadas, int jogadaAtual) {
		if (jogadas[jogadaAtual - 1] + jogadas[jogadaAtual] == 10)
			return true;
		
		return false;
	}
	
	private boolean temStrike(int[] jogadas, int jogadaAtual) {
		if (jogadas[jogadaAtual - 1] == 10 || jogadas[jogadaAtual] == 10)
			return true;
		
		return false;
	}
	
	private boolean podeIrParaProxima(int[] jogadas, int jogadaAtual) {
		if (jogadaAtual <= (jogadas.length - 1))
			return true;
		
		return false;
	}
}
