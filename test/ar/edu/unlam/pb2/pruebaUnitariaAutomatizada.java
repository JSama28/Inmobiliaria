package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class pruebaUnitariaAutomatizada {

	Inmobiliaria inmob = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");

	Propietario propietario1 = new Propietario("Javier", "Perze", 23456123, "javi@email.com", "44581957");
	Propietario propietario2 = new Propietario("Nicolas", "Alba", 34125341, "nico@email.com", "11355125");

	@Before
	public void setup() {
		inmob = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");
	}

	/*	Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
	Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");
	Casa casita3 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C3");

	Casa casita4 = new Casa("gaona", 254, "temos", 13.5, true, TipoDeOperacion.ALQUILER, propietario1, "C4");
	Casa casita5 = new Casa("rivadavia", 24, "remos", 10.5, true, TipoDeOperacion.VENTA, propietario1, "C5");

	Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "P1");
	Ph ph2 = new Ph("cerrito", 475, "5", "moros", 3.5, true, TipoDeOperacion.ALQUILER, propietario1, "P2");

	Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1,"D1");
	Departamento dept2 = new Departamento("ciri", 54, "9b", "pozos", 11.5, true, TipoDeOperacion.VENTA, propietario1,"D2");

	Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietario1, "T1");
	Terreno terrenitos2 = new Terreno("monroe", 824, "atres", 15.4, 4.9, true, TipoDeOperacion.ALQUILER, propietario1, "T2");
	 */	
	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {	
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		assertTrue(inmob.agregarCasa(casita1));
	}

	@Test
	public void queSePuedaDarDeAltaDosCasaEnLaInmobiliaria() {	
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");

		assertTrue(inmob.agregarCasa(casita1));
		assertTrue(inmob.agregarCasa(casita2));
	}

	@Test 
	public void queNoSePuedaDarDeAltaDosCasasConUnaMismaDireccion() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita3 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C3");
		assertTrue(inmob.agregarCasa(casita1));
		assertFalse(inmob.agregarCasa(casita3));
	}


	@Test
	public void	queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		assertTrue(inmob.agregarDepartamento(dept1));
	}

	@Test
	public void	queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Departamento dept2 = new Departamento("ciri", 54, "9b", "pozos", 11.5, true, TipoDeOperacion.VENTA, propietario1, "D2");
		assertTrue(inmob.agregarDepartamento(dept1));
		assertTrue(inmob.agregarDepartamento(dept2));

	}

	@Test
	public void	queNoSePuedanDarDeAltaDosDepartamentoConUnaMismaDireccion() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Departamento dept2 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D2");
		assertTrue(inmob.agregarDepartamento(dept1));
		assertFalse(inmob.agregarDepartamento(dept2));
	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 10.0, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 20.0, true, TipoDeOperacion.VENTA, propietario1, "C1");

		inmob.agregarCasa(casita1);
		inmob.agregarCasa(casita2);

		assertTrue(inmob.valorPromedioCasas().equals(15.0));
		assertFalse(inmob.valorPromedioCasas().equals(12.0));
	}

	@Test
	public void	queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Departamento dept2 = new Departamento("ciri", 54, "9b", "pozos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "D2");

		inmob.agregarDepartamento(dept1);
		inmob.agregarDepartamento(dept2);

		assertTrue(inmob.valorPromedioDepartamentos().equals(7.0));
		assertFalse(inmob.valorPromedioDepartamentos().equals(12.0));

	}
	@Test
	public void	queLaBusquedaPorRangoDePrecioDeMeArrojeUnArrayNoNuloSiAplicanResultados() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 10.0, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 6.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "P1");
		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietario1, "T1");

		inmob.agregarCasa(casita1);
		inmob.agregarDepartamento(dept1);
		inmob.agregarPh(ph1);
		inmob.agregarTerreno(terrenitos1);

		assertNotNull(inmob.mostrarCasasPorPrecio(6.0, 15.0));
		assertNotNull(inmob.mostrarDepartamentosPorPrecio(1.0, 9.0));
		assertNotNull(inmob.mostrarPhsPorPrecio(3.0, 8.0));
		assertNotNull(inmob.mostrarTerrenosPorPrecio(6.0, 11.0));
	}

	@Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNuloSiNoAplicanResultados() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 10.0, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 6.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "P1");
		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietario1, "T1");

		inmob.agregarCasa(casita1);
		inmob.agregarDepartamento(dept1);
		inmob.agregarPh(ph1);
		inmob.agregarTerreno(terrenitos1);

		assertNull(inmob.mostrarCasasPorPrecio(30.0, 45.0));
		assertNull(inmob.mostrarDepartamentosPorPrecio(20.0, 35.0));
		assertNull(inmob.mostrarPhsPorPrecio(10.0, 25.0));
		assertNull(inmob.mostrarTerrenosPorPrecio(13.0, 23.0));

	}	

	@Test
	public void queSePuedaTraerCasasPorPrecioOrdenado() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 15.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");

		inmob.agregarCasa(casita1);
		inmob.agregarCasa(casita2);
		Double price =  inmob.getCasasOrdenadasPorPrecio().get(0).getPrecio();
		assertTrue(12.5 == price);
		assertFalse(15.5 == price);
	}

	@Test
	public void queSePuedaTraerCasasPorUbicacionOrdenado() {
		Casa casita1 = new Casa("ardoino", 123, "tramos", 15.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");

		inmob.agregarCasa(casita1);
		inmob.agregarCasa(casita2);

		String ubic = inmob.getCasasOrdenadasPorUbicacion().get(0).getCiudad();
		assertTrue("temos" == ubic);

	}

	@Test
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaLista() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 12.5, true, TipoDeOperacion.VENTA, propietario1, "C1");
		Casa casita3 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "C3");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.VENTA, propietario1, "P1");
		Ph ph2 = new Ph("cerrito", 475, "5", "moros", 3.5, true, TipoDeOperacion.VENTA, propietario1, "P2");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1,"D1");
		Departamento dept2 = new Departamento("ciri", 54, "9b", "pozos", 11.5, true, TipoDeOperacion.VENTA, propietario1,"D2");
		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.VENTA, propietario1, "T1");
		Terreno terrenitos2 = new Terreno("monroe", 824, "atres", 15.4, 4.9, true, TipoDeOperacion.VENTA, propietario1, "T2");

		inmob.agregarCasa(casita1);
		inmob.agregarCasa(casita2);
		inmob.agregarCasa(casita3);
		inmob.agregarPh(ph1);
		inmob.agregarPh(ph2);
		inmob.agregarDepartamento(dept1);
		inmob.agregarDepartamento(dept2);
		inmob.agregarTerreno(terrenitos1);
		inmob.agregarTerreno(terrenitos2);
		
		assertTrue(inmob.getListadoCasasEnVenta().size() > 0);
		assertTrue(inmob.getListadoDepartamentosEnVenta().size() > 0);
		assertTrue(inmob.getListadoPhsEnVenta().size() > 0);
		assertTrue(inmob.getListadoTerrenosEnVenta().size() > 0);		
	}
	
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaListaNuloSiNoAplicanResultados() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "P1");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.ALQUILER, propietario1,"D1");
		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietario1, "T1");

		inmob.agregarCasa(casita1);
		inmob.agregarPh(ph1);
		inmob.agregarDepartamento(dept1);
		inmob.agregarTerreno(terrenitos1);
		
		assertNull(inmob.getListadoCasasEnVenta());
		assertNull(inmob.getListadoDepartamentosEnVenta());
		assertNull(inmob.getListadoPhsEnVenta());
		assertNull(inmob.getListadoTerrenosEnVenta());	
	}
}
