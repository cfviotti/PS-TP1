package br.unb.cic.ps.calendario;

import br.unb.cic.ps.tratamento.Tratamento;
import br.unb.cic.ps.tratamento.TratamentoImpl;

public class CalendarioImpl implements Calendario {

	private Tratamento moduloTratamento = new TratamentoImpl();

	@Override
	public boolean calendarTest() {
		return true;
	}

	public Tratamento getModuloTratamento() {
		return moduloTratamento;
	}

	public void setModuloTratamento(Tratamento moduloTratamento) {
		this.moduloTratamento = moduloTratamento;
	}
	
}
