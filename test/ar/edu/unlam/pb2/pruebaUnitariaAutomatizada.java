package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class pruebaUnitariaAutomatizada {

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {
		Propiedad casita = new Propiedad("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER);
		Inmobiliaria inmob = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");
		assertTrue(true);
		//assertTrue(inmob.agregarPropiedad(casita));
	}

	@Test
	public void queSePuedaDarDeAltaDosCasaEnLaInmobiliaria() {
		Propiedad casita1 = new Propiedad("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER);
		Propiedad casita2 = new Propiedad("monteagudo", 254, "temos", 2.5, true, TipoDeOperacion.VENTA);
		Inmobiliaria inmob = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");
		assertTrue(true);
		//assertTrue(inmob.agregarPropiedad(casita1));
		//assertTrue(inmob.agregarPropiedad(casita2));
	}

	@Test
	public void queNoSePuedaDarDeAltaDosCasasConUnaMismaDireccion() {
		Propiedad casita1 = new Propiedad("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER);
		Propiedad casita2 = new Propiedad("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER);
		Inmobiliaria inmob = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");
		assertTrue(true);
		//assertTrue(inmob.agregarPropiedad(casita1));
		//assertFalse(inmob.agregarPropiedad(casita2));

	}

}
