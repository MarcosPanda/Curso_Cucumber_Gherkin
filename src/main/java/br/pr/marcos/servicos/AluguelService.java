package br.pr.marcos.servicos;

import java.util.Calendar;

import javax.management.RuntimeErrorException;

import br.pr.marcos.entidades.Filme;
import br.pr.marcos.entidades.NotaAluguel;
import br.pr.marcos.utils.DateUtils;

public class AluguelService {
	
	public NotaAluguel alugar(Filme filme) {
		if (filme.getEstoque() == 0) 
			throw new RuntimeException("Filme sem estoque");
		
		NotaAluguel nota = new NotaAluguel();
		nota.setPreco(filme.getAluguel());
		nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}
}
