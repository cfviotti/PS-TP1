package test.leitura;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import localidade.LocalidadeLeitura;
import localidade.LocalidadeLeituraImpl;
import palestra.PalestraLeitura;
import palestra.PalestraLeituraImpl;
import palestrante.PalestranteLeitura;
import palestrante.PalestranteLeituraImpl;

public class LeituraTest {

	private PalestraLeitura palestraLeitura;
	private PalestranteLeitura palestranteLeitura;
	private LocalidadeLeitura localidadeLeitura;
	
	@Before
	public void initialize() {
		palestraLeitura = new PalestraLeituraImpl();
		palestranteLeitura = new PalestranteLeituraImpl();
		localidadeLeitura = new LocalidadeLeituraImpl();
	}
	
	@Test
	public void testLerArquivoPalestras() {
		assertFalse(palestraLeitura.lerArquivoPalestras("Palestras.txt").isEmpty());
	}
	
	@Test
	public void testLerArquivoPalestrantes() {
		assertFalse(palestranteLeitura.lerArquivoPalestrantes("Palestrantes.txt").isEmpty());
	}
	
	@Test
	public void testLerArquivoLocalidades() {
		assertFalse(localidadeLeitura.lerArquivoLocalidades("Localidades.txt").isEmpty());
	}
}
