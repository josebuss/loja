package br.com.alura.loja;

import java.math.BigDecimal;

import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.imposto.CalduladoraDeImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.imposto.ISS;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesImpostos {

    public static void main(String[] args) {
        CalduladoraDeImpostos calduladoraDeImpostos = new CalduladoraDeImpostos();
        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();

        Orcamento orcamento = new Orcamento();
        orcamento.setValor(BigDecimal.valueOf(100d));
        orcamento.setQuantidadeItens(1);

        BigDecimal output;

        //Strategy
        output = calduladoraDeImpostos.calcular(orcamento, new ICMS());
        System.out.println("Valor ICMS: " + output);
        output = calduladoraDeImpostos.calcular(orcamento, new ISS());
        System.out.println("Valor ISS: " + output);


        //Chain of Responsibility + Template Method
        output = calculadoraDeDescontos.calcular(orcamento);
        System.out.println("Valor sem Desconto: " + output);

        orcamento.setValor(BigDecimal.valueOf(600d));
        output = calculadoraDeDescontos.calcular(orcamento);
        System.out.println("Valor com Desconto por Valor: " + output);

        orcamento.setValor(BigDecimal.valueOf(100d));
        orcamento.setQuantidadeItens(6);
        output = calculadoraDeDescontos.calcular(orcamento);
        System.out.println("Valor com Desconto por Quantidade: " + output);


        //State
        orcamento.setValor(BigDecimal.valueOf(100d));
        orcamento.aplicarDescontoExtra();
        System.out.println("Valor com Desconto Extra Em Analise: " + orcamento.getValor());

        orcamento.aprovar();
        orcamento.aplicarDescontoExtra();
        System.out.println("Valor com Desconto Extra Aprovado: " + orcamento.getValor());
    }

}
