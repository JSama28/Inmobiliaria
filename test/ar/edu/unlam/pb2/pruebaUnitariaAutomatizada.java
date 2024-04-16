package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class pruebaUnitariaAutomatizada {

	Inmobiliaria inmob = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");
	
	Propietario propietario1 = new Propietario("Javier", "Perze", 23456123, "javi@email.com", "44581957");
	Propietario propietario2 = new Propietario("Nicolas", "Alba", 34125341, "nico@email.com", "11355125");
	
	Casa casita1 = new Casa("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietario1, "C0");
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
	
	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {	
		
		assertTrue(inmob.agregarCasa(casita1));
	}

	@Test
	public void queSePuedaDarDeAltaDosCasaEnLaInmobiliaria() {
	
		assertTrue(inmob.agregarCasa(casita1));
		assertTrue(inmob.agregarCasa(casita2));
	}

	@Test 
	public void queNoSePuedaDarDeAltaDosCasasConUnaMismaDireccion() {
	
		assertTrue(inmob.agregarCasa(casita1));
		assertTrue(inmob.agregarCasa(casita3));

	}


	@Test
	public void	queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		assertTrue(inmob.agregarDepartamento(dept1));
	}
	
	@Test
	public void	queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		assertTrue(inmob.agregarDepartamento(dept1));
		assertTrue(inmob.agregarDepartamento(dept2));

	}
	
	@Test
	public void	queNoSePuedanDarDeAltaDosDepartamentoConUnaMismaDireccion() /*(Calle, número, piso, departamento y localidad)*/ {
		
	}
	
	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		
	}
	@Test
	public void	queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		
	}
	@Test
	public void	queLaBusquedaPorRangoDePrecioDeMeArrojeUnArrayNoNuloSiAplicanResultados() {
		
	}
	@Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNuloSiNoAplicanResultados() {
		
	}














	
}
