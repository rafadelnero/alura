package br.com.alura.notafiscal;

import java.util.List;

public class GeradorDeNotaFiscal {

    private final List<AcaoAposGerarNota> acoesAposGerarNota;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoesAposGerarNota) {
        this.acoesAposGerarNota = acoesAposGerarNota;
    }

    public NotaFiscal gera(Fatura fatura) {
        double valor = fatura.getValorMensal();

        NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobreO(valor));
        
        for (AcaoAposGerarNota acaoAposGerarNota : acoesAposGerarNota) {
        	acaoAposGerarNota.executa(nf);
		}

        return nf;
    }

    private double impostoSimplesSobreO(double valor) {
        return valor * 0.06;
    }
}
