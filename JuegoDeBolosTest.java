import static org.junit.Assert.*;
import org.junit.Test;


public class JuegoDeBolosTest{
	public JuegoDeBolos juego = new JuegoDeBolos();	
	
	private void tiros(int pinos, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++)
		{
			juego.lanzar(pinos);
		}
	}
	
	@Test
	public void elPuntajeDeberiaSerCeroSiTodosLosLanzamientosVanAlCanal() throws Exception{		
		tiros(0,20);
		assertEquals(0,juego.score());
	}
	
	@Test
	public void elPuntajeDeberiaSer20SiTodosLosLanzamientosDerribanUno() throws Exception{

		tiros(1,20);
		assertEquals(20,juego.score());
	}
		
	
	@Test
	public void siLosdosPrimerosLanzamientosSon4y6LaJugadaEsUnSpare(){
	juego.lanzar(4);
	juego.lanzar(6);		
	tiros(0,18);
	assertTrue(juego.esSpare(0));
	}
	
	@Test
	public void siLosdosPrimerosTirosDerriban4y3PalitroquesLaJugadaNoEsUnSpare(){
	juego.lanzar(4);
	juego.lanzar(3);		
	tiros(0,18);
	assertFalse(juego.esSpare(0));
	}
	
	@Test
	public void siElPrimerTiroDerriban10PalitroquesEsUnStrike() 
	{		
		juego.lanzar(10);			
		tiros(0,19);
		assertTrue(juego.esStrike(0));
	}
	
	@Test
	public void siElPrimerTiroNoDerriban10PalitroquesNoEsUnStrike() 
	{		
		juego.lanzar(2);			
		tiros(0,19);
		assertFalse(juego.esStrike(0));
	}
	
	@Test
	public void siEnLaPrimeraJugadaDeriban5PalitroquesYLosDemasTirosVanAlCanalElScoreFinalEs5()
	{
		juego.lanzar(5);	
		tiros(0,19);
		assertEquals(5,juego.score());
	}
}