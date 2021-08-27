package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Desconto {

    protected Desconto proximo;

    public Desconto(Desconto desconto) {
        this.proximo = desconto;
    }

    public abstract boolean deveApicar(Orcamento orcamento);

    protected abstract BigDecimal efeturarCalculo(Orcamento orcamento);

    public BigDecimal calcular(Orcamento orcamento) {
        if (deveApicar(orcamento)) {
            return efeturarCalculo(orcamento);
        }
        return proximo.calcular(orcamento);
    }

}
