package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;

public class GeraPedidoHandler {

    private List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void execute(GeraPedido dados) {
        Pedido pedido = new Pedido();
        pedido.setCliente(dados.getCliente());
        pedido.setData(LocalDateTime.now());
        pedido.setOrcamento(new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens()));

        acoes.forEach(a -> a.executarAcao(pedido));
    }
}
