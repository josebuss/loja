package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class SemDesconto extends Desconto {

    public SemDesconto() {
        super(null);
    }

    @Override
    public boolean deveApicar(Orcamento orcamento) {
        return true;
    }

    @Override
    protected BigDecimal efeturarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO.setScale(2);
    }

}
