package br.com.softplan.testesoftplan.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.softplan.testesoftplan.modelo.CalculadoraPontuacaoBoliche;

public class CalculadoraTest {

	@Test
	public void deveCalcularAPontuacaoTotal() {
		
		int[] jogadas = new int[] {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
		
		CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
		
		Assert.assertEquals(133, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
	}
	
	@Test
	public void deveRetornarBonusStrike() {
		int[] jogadas = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0};
		
		CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
		
		Assert.assertEquals(20, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
	}
	
	@Test
	public void deveRetornarBonusSpare() {
		int[] jogadas = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0,0};
		
		CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
		
		Assert.assertEquals(17, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
	}
	
	@Test
	public void deveRetornarSemBonus() {
		int[] jogadas = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 7, 2, 3, 0,0};
		
		CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
		
		Assert.assertEquals(14, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
	}
	
	@Test
	public void deveRetornarSomenteStrikes() {
		int[] jogadas = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		
		CalculadoraPontuacaoBoliche calculadoraPontuacaoBoliche = new CalculadoraPontuacaoBoliche();
		
		Assert.assertEquals(300, calculadoraPontuacaoBoliche.pontuacaoTotal(jogadas));
	}
	
}
