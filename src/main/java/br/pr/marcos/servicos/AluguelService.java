package br.pr.marcos.servicos;

import java.util.Calendar;

import javax.management.RuntimeErrorException;

import br.pr.marcos.entidades.Filme;
import br.pr.marcos.entidades.NotaAluguel;

public class AluguelService {
	
	public NotaAluguel alugar(Filme filme) {
		if (filme.getEstoque() == 0) 
			throw new RuntimeException();
		NotaAluguel nota = new NotaAluguel();
		nota.setPreco(filme.getAluguel());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		nota.setDataEntrega(cal.getTime());
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}
}
