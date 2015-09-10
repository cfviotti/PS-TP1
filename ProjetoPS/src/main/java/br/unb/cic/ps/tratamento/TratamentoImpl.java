package br.unb.cic.ps.tratamento;

import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;

public class TratamentoImpl implements Tratamento {

	private Leitura moduloLeitura = new LeituraImpl();

	@Override
	public boolean tratamentoTest() {
		return true;
	}

	public Leitura getModuloLeitura() {
		return moduloLeitura;
	}

	public void setModuloLeitura(Leitura moduloLeitura) {
		this.moduloLeitura = moduloLeitura;
	}
	
}
