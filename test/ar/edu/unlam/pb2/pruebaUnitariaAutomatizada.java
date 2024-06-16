package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Exceptions.SinResultadosException;
import Exceptions.UmbralMinimoNoAlcanzadoException;

public class pruebaUnitariaAutomatizada {

	Inmobiliaria inmob = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");
	Propietario propietario1 = new Propietario("Javier", "Perze", 23456123, "javi@email.com", "44581957");
	Propietario propietario2 = new Propietario("Nicolas", "Alba", 34125341, "nico@email.com", "11355125");

	@Before
	public void setup() {
		inmob = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");
		propietario1 = new Propietario("Javier", "Perze", 23456123, "javi@email.com", "44581957");
		propietario2 = new Propietario("Nicolas", "Alba", 34125341, "nico@email.com", "11355125");
	}
	
//A
	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {	
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		
		assertTrue(inmob.agregarPropiedad(casita1));
	}
//B
	@Test
	public void queSePuedaDarDeAltaDosCasaEnLaInmobiliaria() {	
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");

		assertTrue(inmob.agregarPropiedad(casita1));
		assertTrue(inmob.agregarPropiedad(casita2));
	}

	@Test 
	public void queNoSePuedaDarDeAltaDosCasasConUnaMismaDireccion() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita3 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C3");
		
		assertTrue(inmob.agregarPropiedad(casita1));
		assertFalse(inmob.agregarPropiedad(casita3));
	}

//C
	@Test
	public void	queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		
		assertTrue(inmob.agregarPropiedad(dept1));
	}
//D
	@Test
	public void	queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Departamento dept2 = new Departamento("ciri", 54, "9b", "pozos", 11.5, true, TipoDeOperacion.VENTA, propietario1, "D2");
		
		assertTrue(inmob.agregarPropiedad(dept1));
		assertTrue(inmob.agregarPropiedad(dept2));
	}

	@Test
	public void	queNoSePuedanDarDeAltaDosDepartamentoConUnaMismaDireccion() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Departamento dept2 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D2");
		
		assertTrue(inmob.agregarPropiedad(dept1));
		assertFalse(inmob.agregarPropiedad(dept2));
	}
//E
	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 10.0, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 20.0, true, TipoDeOperacion.VENTA, propietario1, "C1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(casita2);

		assertTrue(inmob.valorPromedioCasas().equals(15.0));
		assertFalse(inmob.valorPromedioCasas().equals(12.0));
	}
//F
	@Test
	public void	queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Departamento dept2 = new Departamento("ciri", 54, "9b", "pozos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "D2");

		inmob.agregarPropiedad(dept1);
		inmob.agregarPropiedad(dept2);

		assertTrue(inmob.valorPromedioDepartamentos().equals(7.0));
		assertFalse(inmob.valorPromedioDepartamentos().equals(12.0));
	}
	
	@Test
	public void	queLaBusquedaPorRangoDePrecioDeMeArrojeUnaListaNoNuloSiAplicanResultados() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 10.0, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 6.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "P1");
		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietario1, "T1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(dept1);
		inmob.agregarPropiedad(ph1);
		inmob.agregarPropiedad(terrenitos1);

		assertNotNull(inmob.buscarPropiedadesPorPrecio(5.0, 15.0, null));
	}

	@Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnaListaNuloSiNoAplicanResultados() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 10.0, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 6.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "P1");
		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietario1, "T1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(dept1);
		inmob.agregarPropiedad(ph1);
		inmob.agregarPropiedad(terrenitos1);

		assertNull(inmob.buscarPropiedadesPorPrecio(30.0, 45.0, null));
	}	

	@Test
	public void queSePuedaTraerCasasPorPrecioOrdenado() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 15.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(casita2);
		Double price =  inmob.getCasasOrdenadasPorPrecio().get(0).getPrecio();
		
		assertTrue(12.5 == price);
		assertFalse(15.5 == price);
	}

	@Test
	public void queSePuedaTraerCasasPorUbicacionOrdenado() {
		Casa casita1 = new Casa("ardoino", 123, "tramos", 15.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(casita2);

		String ubic = inmob.getCasasOrdenadasPorUbicacion().get(0).getCiudad();
		assertTrue("tramos" == ubic);
	}

//	@Test
//	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() {
//		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "C0");
//		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");
//		Casa casita3 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "C2");
//		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "P1");
//		Ph ph2 = new Ph("cerrito", 475, "5", "moros", 3.5, true, TipoDeOperacion.VENTA, propietario1, "P2");
//		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1,"D1");
//		Departamento dept2 = new Departamento("ciri", 54, "9b", "pozos", 11.5, true, TipoDeOperacion.VENTA, propietario1,"D2");
//		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.VENTA, propietario1, "T1");
//		Terreno terrenitos2 = new Terreno("monroe", 824, "atres", 15.4, 4.9, true, TipoDeOperacion.VENTA, propietario1, "T2");
//
//		inmob.agregarPropiedad(casita1);
//		inmob.agregarPropiedad(casita2);
//		inmob.agregarPropiedad(casita3);
//		inmob.agregarPropiedad(ph1);
//		inmob.agregarPropiedad(ph2);
//		inmob.agregarPropiedad(dept1);
//		inmob.agregarPropiedad(dept2);
//		inmob.agregarPropiedad(terrenitos1);
//		inmob.agregarPropiedad(terrenitos2);
//		
//		assertTrue(inmob.getListadoPropiedadesEnVenta().size() > 0);
//	}
	
	@Test
	public void queSePuedaRealizarUnaPermuta() {
		
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.PERMUTA, propietario1, "C1");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.PERMUTA, propietario1, "P1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(ph1);
		propietario1.agregarPropiedad(ph1);
		propietario2.agregarPropiedad(casita1);
		
		assertTrue(inmob.realizarPermuta(propietario2, casita1, propietario1, ph1));
	}
//G	
	@Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria() {
		Cliente cliente1 = new Cliente ("Tom", "Taura", 35624523, "TomT@email.com", "45628294");
		
		assertTrue(inmob.agregarCliente(cliente1));
	}
//H	
	@Test
	public void queNoSePuedanAgregarDosClientesConUnMismoDni() {
		Cliente cliente1 = new Cliente ("Tom", "Taura", 35624523, "TomT@email.com", "45628294");
		Cliente cliente2 = new Cliente ("Pau", "Lito", 35624523, "TomT@email.com", "45628294");

		assertTrue(inmob.agregarCliente(cliente1));
		assertFalse(inmob.agregarCliente(cliente2));

	}
//I
	@Test
	public void queSePuedaRealizarLaVentaDeUnaPropiedad() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "C0");

		inmob.agregarPropiedad(casita1);
		
		assertTrue(inmob.realizarVenta(casita1.getId(), propietario2));
	}
//J	
	@Test
	public void queSePuedaRealizarElAlquilerDeUnaPropiedad() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Inquilino inquilino1 = new Inquilino ("Tom", "Taura", 35624523, "TomT@email.com", "45628294", null);
	
		inmob.agregarPropiedad(casita1);
		
		assertTrue(inmob.realizarAlquiler(casita1.getId(), inquilino1, "23/07/2024", "23/07/2025"));
	}
//K	
	@Test
	public void queSePuedaRealizarLaPermutaDeDosPropiedades() {

		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.PERMUTA, propietario1, "C1");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.PERMUTA, propietario1, "P1");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.PERMUTA, propietario1,"D1");
		Terreno terrenito1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.PERMUTA, propietario2, "T1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(ph1);
		propietario1.agregarPropiedad(ph1);
		propietario2.agregarPropiedad(casita1);
		
		assertTrue(inmob.realizarPermuta(propietario2, casita1, propietario1, ph1));
		assertTrue(inmob.realizarPermuta(propietario2, dept1, propietario1, terrenito1));
	}
//L	
	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 7.5, true, TipoDeOperacion.VENTA, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");
		Casa casita3 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "C2");
		Casa casita4 = new Casa("monteagudo", 254, "temos", 14.5, true, TipoDeOperacion.VENTA, propietario1, "C3");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(casita2);
		inmob.agregarPropiedad(casita3);
		inmob.agregarPropiedad(casita4);
		
		ArrayList<Propiedad> casasOrdenadas = inmob.buscarPropiedadesPorPrecio(4.1, 14.2, TipoDePropiedad.CASA);
		assertTrue(casasOrdenadas.get(0).getPrecio().equals(5.5));
		assertTrue(casasOrdenadas.get(casasOrdenadas.size() -1).getPrecio().equals(12.5));
	}
//M
	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() {
		Casa casita1 = new Casa("florida", 223, "ramos", 7.5, true, TipoDeOperacion.VENTA, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "ramos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");
		Casa casita3 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "C2");
		Casa casita4 = new Casa("suipacha", 254, "ramos", 14.5, true, TipoDeOperacion.VENTA, propietario1, "C3");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(casita2);
		inmob.agregarPropiedad(casita3);
		inmob.agregarPropiedad(casita4);
		
		ArrayList<Propiedad> casasOrdenadas = inmob.buscarPropiedadesPorUbicacion("ramos", TipoDePropiedad.CASA);
		assertEquals(casasOrdenadas.get(0).getCalle(), "ardoino");
		assertTrue(casasOrdenadas.get(casasOrdenadas.size() -1).getCalle().equals("suipacha"));
	}
//N
	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio(){
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1,"D1");
		Departamento dept2 = new Departamento("ciri", 54, "9b", "pozos", 11.5, true, TipoDeOperacion.VENTA, propietario2,"D2");
		Departamento dept3 = new Departamento("ardoino", 123, null, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario2, "D3");
		Departamento dept4 = new Departamento("monteagudo", 254, "6a", "temos", 14.5, true, TipoDeOperacion.VENTA, propietario1, "D4");

		inmob.agregarPropiedad(dept1);
		inmob.agregarPropiedad(dept2);
		inmob.agregarPropiedad(dept3);
		inmob.agregarPropiedad(dept4);
		
		ArrayList<Propiedad> deptsOrdenados = inmob.buscarPropiedadesPorPrecio(4.1, 14.2, TipoDePropiedad.DEPARTAMENTO);
		assertTrue(deptsOrdenados.get(0).getPrecio().equals(5.5));
		assertTrue(deptsOrdenados.get(deptsOrdenados.size() -1).getPrecio().equals(11.5));
	}
//O
	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion(){
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1,"D1");
		Departamento dept2 = new Departamento("ciri", 54, "9b", "lasos", 11.5, true, TipoDeOperacion.VENTA, propietario2,"D2");
		Departamento dept3 = new Departamento("ardoino", 123, null, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario2, "D3");
		Departamento dept4 = new Departamento("monteagudo", 254, "6a", "lasos", 14.5, true, TipoDeOperacion.VENTA, propietario1, "D4");

		inmob.agregarPropiedad(dept1);
		inmob.agregarPropiedad(dept2);
		inmob.agregarPropiedad(dept3);
		inmob.agregarPropiedad(dept4);
		
		ArrayList<Propiedad> deptsOrdenados = inmob.buscarPropiedadesPorUbicacion("lasos", TipoDePropiedad.DEPARTAMENTO);
		assertEquals(deptsOrdenados.get(0).getCalle(), "ciri");
		assertTrue(deptsOrdenados.get(deptsOrdenados.size() -1).getCalle().equals("taura"));
	}
//P
	@Test
	public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException(){
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C1");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "P1");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.ALQUILER, propietario1,"D1");
		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietario1, "T1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(ph1);
		inmob.agregarPropiedad(dept1);
		inmob.agregarPropiedad(terrenitos1);
		
		try {
			inmob.getListadoPropiedadesEnVenta();
			fail("No se produjo exception");
		} catch (SinResultadosException exception) {
			//se produjo exception esperada
		}
	}
//Q
/*	@Test
	public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException(){
	
	}
*/
}
