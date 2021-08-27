package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class DescontoParaOrcamentoComValorMaiorQueQuinhentos extends Desconto {

    public DescontoParaOrcamentoComValorMaiorQueQuinhentos(Desconto desconto) {
        super(desconto);
    }

    @Override
    public boolean deveApicar(Orcamento orcamento) {
        return orcamento.getValor().compareTo(BigDecimal.valueOf(500)) > 0;
    }

    @Override
    protected BigDecimal efeturarCalculo(Orcamento orcamento) {
        return orcamento.getValor().multiply(BigDecimal.valueOf(0.05d)).setScale(2);
    }

}
