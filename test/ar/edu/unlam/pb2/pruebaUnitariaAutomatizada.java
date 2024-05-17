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
	
	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {	
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		assertTrue(inmob.agregarPropiedad(casita1));
	}

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


	@Test
	public void	queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietario1, "D1");
		assertTrue(inmob.agregarPropiedad(dept1));
	}

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

	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 10.0, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Casa casita2 = new Casa("monteagudo", 254, "temos", 20.0, true, TipoDeOperacion.VENTA, propietario1, "C1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(casita2);

		assertTrue(inmob.valorPromedioCasas().equals(15.0));
		assertFalse(inmob.valorPromedioCasas().equals(12.0));
	}

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

		assertNotNull(inmob.buscarPropiedadesPorPrecio(5.0, 15.0));
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

		assertNull(inmob.buscarPropiedadesPorPrecio(30.0, 45.0));
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

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(casita2);
		inmob.agregarPropiedad(casita3);
		inmob.agregarPropiedad(ph1);
		inmob.agregarPropiedad(ph2);
		inmob.agregarPropiedad(dept1);
		inmob.agregarPropiedad(dept2);
		inmob.agregarPropiedad(terrenitos1);
		inmob.agregarPropiedad(terrenitos2);
		
		assertTrue(inmob.getListadoPropiedadesEnVenta().size() > 0);
	}
	
	public void queLaBusquedaDePropiedadesPorVentaMeArrojeUnaListaNuloSiNoAplicanResultados() {
		Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
		Ph  ph1 = new Ph("lagos", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "P1");
		Departamento dept1 = new Departamento("taura", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.ALQUILER, propietario1,"D1");
		Terreno terrenitos1 = new Terreno("larrea", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietario1, "T1");

		inmob.agregarPropiedad(casita1);
		inmob.agregarPropiedad(ph1);
		inmob.agregarPropiedad(dept1);
		inmob.agregarPropiedad(terrenitos1);
		
		assertNull(inmob.getListadoPropiedadesEnVenta());
	}
}
