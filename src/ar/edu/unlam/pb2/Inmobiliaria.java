package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private String telefono;
	private HashSet<Casa> casas;
//	private HashSet<Departamento> departamentos;
//	private HashSet<Ph> phs;
//	private HashSet<Terreno> terrenos;
	private Departamento departamentos[];
	private Ph phs[];
	private Terreno terrenos[];
	private Cliente clientes[];
	private final Integer cantidadMaximaDePropiedades = 100;
	private final Integer cantidadMaximaDeClientes = 100;

	public Inmobiliaria(String nombre, String direccion, String eMail, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.casas = new HashSet<Casa>();
		this.departamentos = new Departamento[cantidadMaximaDePropiedades];
		this.phs = new Ph[cantidadMaximaDePropiedades];
		this.terrenos = new Terreno[cantidadMaximaDePropiedades];
		this.clientes = new Cliente[cantidadMaximaDeClientes];

//		Propietario propietarioJavi = new Propietario("Javier", "Perez", 2421, "javi@email.com", "44581957");
//		Propietario propietarioNic = new Propietario("Nic", "Arez", 5875, "nic@email.com", "44569723");
//		this.phs[0] = new Ph("ardoino", 123, "1", "ramos", 5.5, true, TipoDeOperacion.ALQUILER, propietarioJavi, "P1");
//		this.phs[1] = new Ph("ardoino", 475, "5", "moros", 3.5, true, TipoDeOperacion.ALQUILER, propietarioNic, "P2");
//		this.casas[0] = new Casa("monteagudo", 254, "temos", 3.5, true, TipoDeOperacion.VENTA, propietarioJavi, "C1");
//		this.casas[1] = new Casa("monteagudo", 24, "remos", 10.5, true, TipoDeOperacion.VENTA, propietarioNic, "C2");
//		this.departamentos[0] = new Departamento("escalada", 3454, "1", "lasos", 1.5, true, TipoDeOperacion.VENTA, propietarioJavi,
//				"D1");
//		this.departamentos[1] = new Departamento("escalada", 54, "9b", "pozos", 11.5, true, TipoDeOperacion.VENTA, propietarioNic,
//				"D2");
//		this.terrenos[0] = new Terreno("suipacha", 1554, "zares", 5.4, 7.5, true, TipoDeOperacion.ALQUILER, propietarioJavi, "T1");
//		this.terrenos[1] = new Terreno("suipacha", 824, "atres", 15.4, 4.9, true, TipoDeOperacion.ALQUILER, propietarioNic, "T2");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean agregarCasa(Casa nuevaCasa) {
		if (casas.add(nuevaCasa)) {
			System.out.println("SE AGREGO CASA: " + nuevaCasa.toString());
			return true;
		} else {
			System.out.println("NO SE PUDO AGREGAR CASA: " + nuevaCasa.toString());
			return false;
		}
	}

	public Boolean agregarDepartamento(Departamento nuevoDept) {
		for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
			if (departamentos[i] == null) {
				departamentos[i] = nuevoDept;
				System.out.println("SE AGREGO DEPARTAMENTO: " + nuevoDept.toString());
				return true;
			}

			Boolean mismaCalle = departamentos[i].getCalle().equals(nuevoDept.getCalle());
			Boolean mismoNumCalle = departamentos[i].getNumero().equals(nuevoDept.getNumero());
			Boolean mismaCiudad = departamentos[i].getCiudad().equals(nuevoDept.getCiudad());
			if (mismaCalle && mismoNumCalle && mismaCiudad) {
				return false;
			}
		}
		return false;
	}

	public Boolean agregarPh(Ph nuevoPh) {
		for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
			if (phs[i] == null) {
				phs[i] = nuevoPh;
				System.out.println("SE AGREGO PH: " + nuevoPh.toString());
				return true;
			}

			Boolean mismaCalle = phs[i].getCalle().equals(nuevoPh.getCalle());
			Boolean mismoNumCalle = phs[i].getNumero().equals(nuevoPh.getNumero());
			Boolean mismaCiudad = phs[i].getCiudad().equals(nuevoPh.getCiudad());
			if (mismaCalle && mismoNumCalle && mismaCiudad) {
				return false;
			}
		}
		return false;
	}

	public Boolean agregarTerreno(Terreno nuevoTerreno) {
		for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
			if (terrenos[i] == null) {
				terrenos[i] = nuevoTerreno;
				System.out.println("SE AGREGO TERRENO: " + nuevoTerreno.toString());
				return true;
			}

		}
		return false;
	}

	public Boolean agregarCliente(Cliente nuevoCliente) {
		for (int i = 0; i < cantidadMaximaDeClientes; i++) {
			if (clientes[i] == null) {
				clientes[i] = nuevoCliente;
				return true;
			}
		}
		return false;
	}

	public Boolean agregarPropiedad() {
		Scanner teclado = new Scanner(System.in);
		Integer opcionSeleccionada = 0;

		System.out.println("\nTipo de propiedades: ");
		System.out.println("1. Casa");
		System.out.println("2. Departamento");
		System.out.println("3. Ph");
		System.out.println("4. Terreno");
		System.out.println("5. Salir al menu principal");
		System.out.println("\nIngrese propiedad a agregar:");
		opcionSeleccionada = teclado.nextInt();

		switch (TipoDePropiedad.values()[opcionSeleccionada - 1]) {
		case CASA:
			Casa casa = crearCasa(null);
			return agregarCasa(casa);
		case DEPARTAMENTO:
			Departamento departamento = crearDepartamento();
			return agregarDepartamento(departamento);
		case PH:
			Ph ph = crearPh();
			return agregarPh(ph);
		case TERRENO:
			Terreno terreno = crearTerreno();
			return agregarTerreno(terreno);
		default:
			return false;
		}
	}

	public Casa crearCasa(String id) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese nombre de calle: ");
		String nombreCalle = teclado.next();

		System.out.println("Ingrese numero: ");
		Integer numero = teclado.nextInt();

		System.out.println("Ingrese ciudad: ");
		String ciudad = teclado.next();

		System.out.println("Ingrese precio: ");
		Double precio = teclado.nextDouble();

		TipoDeOperacion tipo = seleccionarTipoDeOperacion();
		Propietario propietario = seleccionarPropietario();

		// Inquilino inquilino = seleccionarInquilino();

		String idCasa = id == null ? ("C" + casas.size()) : id;

		Casa casa = new Casa(nombreCalle, numero, ciudad, precio, true, tipo, propietario, idCasa);
		return casa;
	}

	public Departamento crearDepartamento() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese nombre de calle: ");
		String nombreCalle = teclado.next();

		System.out.println("Ingrese numero: ");
		Integer numero = teclado.nextInt();

		System.out.println("Ingrese departamento: ");
		String numDept = teclado.next();

		System.out.println("Ingrese ciudad: ");
		String ciudad = teclado.next();

		System.out.println("Ingrese precio: ");
		Double precio = teclado.nextDouble();

		TipoDeOperacion tipo = seleccionarTipoDeOperacion();
		Propietario propietario = seleccionarPropietario();
		String idDept = "D" + getCantidadDeElementos(departamentos);

		Departamento departamento = new Departamento(nombreCalle, numero, numDept, ciudad, precio, true, tipo,
				propietario, idDept);
		return departamento;
	}

	public Ph crearPh() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese nombre de calle: ");
		String nombreCalle = teclado.next();

		System.out.println("Ingrese numero: ");
		Integer numero = teclado.nextInt();

		System.out.println("Ingrese ph: ");
		String numPh = teclado.next();

		System.out.println("Ingrese ciudad: ");
		String ciudad = teclado.next();

		System.out.println("Ingrese precio: ");
		Double precio = teclado.nextDouble();

		TipoDeOperacion tipo = seleccionarTipoDeOperacion();
		Propietario propietario = seleccionarPropietario();
		String idPh = "P" + getCantidadDeElementos(phs);

		Ph ph = new Ph(nombreCalle, numero, numPh, ciudad, precio, true, tipo, propietario, idPh);
		return ph;
	}

	public Terreno crearTerreno() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese nombre de calle: ");
		String nombreCalle = teclado.next();

		System.out.println("Ingrese numero: ");
		Integer numero = teclado.nextInt();

		System.out.println("Ingrese ciudad: ");
		String ciudad = teclado.next();

		System.out.println("Ingrese mts cuadrados: ");
		Double mtsCuadrados = teclado.nextDouble();

		System.out.println("Ingrese precio: ");
		Double precio = teclado.nextDouble();

		TipoDeOperacion tipo = seleccionarTipoDeOperacion();
		Propietario propietario = seleccionarPropietario();
		String idTerreno = "T" + getCantidadDeElementos(terrenos);

		Terreno terreno = new Terreno(nombreCalle, numero, ciudad, mtsCuadrados, precio, true, tipo, propietario,
				idTerreno);
		return terreno;
	}

	public TipoDeOperacion seleccionarTipoDeOperacion() {
		Scanner teclado = new Scanner(System.in);

		Boolean tipoValido = false;
		TipoDeOperacion tipo = TipoDeOperacion.VENTA;

		while (tipoValido == false) {
			System.out.println("Ingrese tipo operacion: alquiler/venta/permuta");
			String tipoOperacion = teclado.next();

			if (tipoOperacion.equals("venta")) {
				tipo = TipoDeOperacion.VENTA;
				tipoValido = true;
			} else if (tipoOperacion.equals("alquiler")) {
				tipo = TipoDeOperacion.ALQUILER;
				tipoValido = true;
			} else if (tipoOperacion.equals("permuta")) {
				tipo = TipoDeOperacion.PERMUTA;
				tipoValido = true;
			} else {
				System.out.println("TIPO INVALIDO.");
			}
		}
		return tipo;
	}

	public Propietario seleccionarPropietario() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Nombre del propietario: ");
		String nombre = teclado.next();

		System.out.println("Apellido del propietario: ");
		String apellido = teclado.next();

		System.out.println("Dni del propietario: ");
		Integer dni = teclado.nextInt();

		System.out.println("Email del propietario: ");
		String email = teclado.next();

		System.out.println("Telefono del propietario: ");
		String telefono = teclado.next();
		Propietario propietario = new Propietario(nombre, apellido, dni, email, telefono);
		return propietario;
	}

	public Inquilino seleccionarInquilino() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Nombre del inquilino: ");
		String nombre = teclado.next();

		System.out.println("Apellido del inquilino: ");
		String apellido = teclado.next();

		System.out.println("Dni del inquilino: ");
		Integer dni = teclado.nextInt();

		System.out.println("Email del inquilino: ");
		String email = teclado.next();

		System.out.println("Telefono del inquilino: ");
		String telefono = teclado.next();

		Inquilino inquilino = new Inquilino(nombre, apellido, dni, email, telefono, null);
		return inquilino;
	}

	public Boolean editarPropiedad(String idPropiedad) {

		switch (idPropiedad.charAt(0)) {
		case 'C':

			for (Casa casita : casas) {
				String id = casita.getId();

				if (idPropiedad.equals(id)) {
					System.out.println(casita.toString());
					
					Casa casaEditada = crearCasa(id);
					casas.remove(casita);
					
					return casas.add(casaEditada);
				}
			}

		case 'D':
			for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
				if (departamentos[i] != null) {
					Departamento departamento = departamentos[i];

					if (idPropiedad.equals(departamento.getId())) {
						System.out.println(departamentos[i].toString());
						departamentos[i] = crearDepartamento();
						return true;
					}
				}
			}

		case 'P':
			for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
				if (phs[i] != null) {
					Ph ph = phs[i];

					if (idPropiedad.equals(ph.getId())) {
						System.out.println(phs[i].toString());
						phs[i] = crearPh();
						return true;
					}
				}
			}
		case 'T':
			for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
				if (terrenos[i] != null) {
					Terreno terreno = terrenos[i];

					if (idPropiedad.equals(terreno.getId())) {
						System.out.println(terrenos[i].toString());
						terrenos[i] = crearTerreno();
						return true;
					}
				}
			}
		}
		return false;
	}

	public Cliente crearCliente() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese nombre de cliente: ");
		String nombre = teclado.next();

		System.out.println("Ingrese apellido de cliente: ");
		String apellido = teclado.next();

		System.out.println("Ingrese dni de cliente: ");
		Integer dni = teclado.nextInt();

		System.out.println("Ingrese domicilio de cliente: ");
		String domicilio = teclado.next();

		System.out.println("Ingrese telefono de cliente: ");
		String telefono = teclado.next();

		Cliente cliente = new Cliente(nombre, apellido, dni, domicilio, telefono);

		return cliente;
	}

	public void obtenerListadoPorPrecio() {
		System.out.println("\nPROPIEDADES:\n");

		ArrayList<Casa> casasOrdenadas = getCasasOrdenadasPorPrecio();
		Departamento[] deptsOrdenados = getDepartamentosOrdenadosPorPrecio();
		Ph[] phsOrdenados = getPhsOrdenadosPorPrecio();
		Terreno[] terrenosOrdenadas = getTerrenosOrdenadosPorPrecio();

		System.out.println("\nCASAS:");
		for (Casa casita : casasOrdenadas) {
			if (casita != null) {
				System.out.println(casita.toString());
			} else {
				break;
			}
		}

		System.out.println("\nDEPARTAMENTOS:");
		for (Departamento depts : deptsOrdenados) {
			if (depts != null) {
				System.out.println(depts.toString());

			}
		}

		System.out.println("\nPHS: ");
		for (Ph phs : phsOrdenados) {
			if (phs != null) {
				System.out.println(phs.toString());
			}
		}

		System.out.println("\nTERRENOS: ");
		for (Terreno terrenos : terrenosOrdenadas) {
			if (terrenos != null) {
				System.out.println(terrenos.toString());
			}
		}

		System.out.println("\nNO HAY MAS PROPIEDADES A MOSTRAR.");
	}

	public Integer getCantidadDeElementos(Object[] array) {
		Integer cantidad = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				cantidad++;
			} else {
				break;
			}
		}
		return cantidad;
	}

	public ArrayList<Casa> getCasasOrdenadasPorPrecio() {
		ArrayList<Casa> casasOrdenadas = new ArrayList<Casa>(casas);

		Collections.sort(casasOrdenadas, (a, b) -> {
			Double precioA = ((Casa) a).getPrecio();
			Double precioB = ((Casa) b).getPrecio();
			return precioA.compareTo(precioB);
		});

		return casasOrdenadas;
	}

	public Departamento[] getDepartamentosOrdenadosPorPrecio() {
		Departamento[] deptsOrdenados = departamentos;
		int cantidadTotal = getCantidadDeElementos(departamentos);

		Departamento propAuxiliar;

		for (int i = 0; i < cantidadTotal; i++) {
			for (int j = 1; j < (cantidadTotal - i); j++) {
				if (deptsOrdenados[j - 1].getPrecio() > deptsOrdenados[j].getPrecio()) {
					// intercambiar elementos
					propAuxiliar = deptsOrdenados[j - 1];
					deptsOrdenados[j - 1] = deptsOrdenados[j];
					deptsOrdenados[j] = propAuxiliar;
				}
			}
		}
		return deptsOrdenados;
	}

	public Ph[] getPhsOrdenadosPorPrecio() {
		Ph[] phsOrdenados = phs;
		int cantidadTotal = getCantidadDeElementos(phs);

		Ph propAuxiliar;

		for (int i = 0; i < cantidadTotal; i++) {
			for (int j = 1; j < (cantidadTotal - i); j++) {
				if (phsOrdenados[j - 1].getPrecio() > phsOrdenados[j].getPrecio()) {
					// intercambiar elementos
					propAuxiliar = phsOrdenados[j - 1];
					phsOrdenados[j - 1] = phsOrdenados[j];
					phsOrdenados[j] = propAuxiliar;
				}
			}
		}
		return phsOrdenados;
	}

	public Terreno[] getTerrenosOrdenadosPorPrecio() {
		Terreno[] terrenosOrdenados = terrenos;
		int cantidadTotal = getCantidadDeElementos(terrenos);

		Terreno propAuxiliar;

		for (int i = 0; i < cantidadTotal; i++) {
			for (int j = 1; j < (cantidadTotal - i); j++) {
				if (terrenosOrdenados[j - 1].getPrecio() > terrenosOrdenados[j].getPrecio()) {
					// intercambiar elementos
					propAuxiliar = terrenosOrdenados[j - 1];
					terrenosOrdenados[j - 1] = terrenosOrdenados[j];
					terrenosOrdenados[j] = propAuxiliar;
				}
			}
		}
		return terrenosOrdenados;
	}

	public void buscarPropiedadesPorPrecio(Double precioMin, Double precioMax) {
		mostrarCasasPorPrecio(precioMin, precioMax);
		mostrarDepartamentosPorPrecio(precioMin, precioMax);
		mostrarPhsPorPrecio(precioMin, precioMax);
		mostrarTerrenosPorPrecio(precioMin, precioMax);
	}

	public ArrayList<Casa> mostrarCasasPorPrecio(Double precioMin, Double precioMax) {
		ArrayList<Casa> casasEntrePrecio = new ArrayList<Casa>(); 
		Integer cantidadAgregada = 0;

		for (Casa casita: casas) {
			if (casita.getPrecio() >= precioMin && casita.getPrecio() <= precioMax) {
				casasEntrePrecio.add(casita);
				cantidadAgregada++;
			}
		}

		System.out.println("\nCASAS DENTRO DEL RANGO DE PRECIO: " + cantidadAgregada);

		for (Casa casita: casas) {
			String descripcionPropiedad = casita.toString();
			System.out.println(descripcionPropiedad);
		}
		return cantidadAgregada > 0 ? casasEntrePrecio : null;
	}

	public Departamento[] mostrarDepartamentosPorPrecio(Double precioMin, Double precioMax) {
		Departamento[] deptEntrePrecio = new Departamento[cantidadMaximaDePropiedades];
		Integer cantidadAgregada = 0;
		int cantidadTotal = getCantidadDeElementos(departamentos);

		for (int i = 0; i < cantidadTotal; i++) {
			if (departamentos[i].getPrecio() >= precioMin && departamentos[i].getPrecio() <= precioMax) {
				deptEntrePrecio[cantidadAgregada] = departamentos[i];
				cantidadAgregada++;
			}
		}

		System.out.println("\nDEPARTAMENTOS DENTRO DEL RANGO DE PRECIO: " + cantidadAgregada);

		for (int j = 0; j < cantidadAgregada; j++) {
			String descripcionPropiedad = deptEntrePrecio[j].toString();
			System.out.println(descripcionPropiedad);
		}
		return cantidadAgregada > 0 ? deptEntrePrecio : null;
	}

	public Ph[] mostrarPhsPorPrecio(Double precioMin, Double precioMax) {
		Ph[] phsEntrePrecio = new Ph[cantidadMaximaDePropiedades];
		Integer cantidadAgregada = 0;
		int cantidadTotal = getCantidadDeElementos(phs);

		for (int i = 0; i < cantidadTotal; i++) {
			if (phs[i].getPrecio() >= precioMin && phs[i].getPrecio() <= precioMax) {
				phsEntrePrecio[cantidadAgregada] = phs[i];
				cantidadAgregada++;
			}
		}

		System.out.println("\nPHS DENTRO DEL RANGO DE PRECIO: " + cantidadAgregada);

		for (int j = 0; j < cantidadAgregada; j++) {
			String descripcionPropiedad = phsEntrePrecio[j].toString();
			System.out.println(descripcionPropiedad);
		}
		return cantidadAgregada > 0 ? phsEntrePrecio : null;

	}

	public Terreno[] mostrarTerrenosPorPrecio(Double precioMin, Double precioMax) {
		Terreno[] terrenosEntrePrecio = new Terreno[cantidadMaximaDePropiedades];
		Integer cantidadAgregada = 0;
		int cantidadTotal = getCantidadDeElementos(terrenos);

		for (int i = 0; i < cantidadTotal; i++) {
			if (terrenos[i].getPrecio() >= precioMin && terrenos[i].getPrecio() <= precioMax) {
				terrenosEntrePrecio[cantidadAgregada] = terrenos[i];
				cantidadAgregada++;
			}
		}

		System.out.println("\nTERRENOS DENTRO DEL RANGO DE PRECIO: " + cantidadAgregada);

		for (int j = 0; j < cantidadAgregada; j++) {
			String descripcionPropiedad = terrenosEntrePrecio[j].toString();
			System.out.println(descripcionPropiedad);
		}
		return cantidadAgregada > 0 ? terrenosEntrePrecio : null;

	}
	
	public ArrayList<Casa> getCasasOrdenadasPorUbicacion() {
		ArrayList<Casa> casasEnUbicacion = new ArrayList<Casa>(casas);
		
		Collections.sort(casasEnUbicacion, (a, b) -> {
			String ubicacionA = ((Casa) a).getCiudad();
			String ubicacionB = ((Casa) b).getCiudad();
			return ubicacionA.compareTo(ubicacionB);
		});

		return casasEnUbicacion;
	}

	public Departamento[] getDepartamentosOrdenadosPorUbicacion() {
		Departamento[] departamentosEnUbicacion = departamentos;
		int cantidadTotal = getCantidadDeElementos(departamentos);

		Departamento propAuxiliar;

		for (int i = 0; i < cantidadTotal; i++) {
			for (int j = 1; j < (cantidadTotal - i); j++) {
				if (departamentosEnUbicacion[j - 1].getCiudad()
						.compareTo(departamentosEnUbicacion[j].getCiudad()) > 0) {
					// intercambiar elementos
					propAuxiliar = departamentosEnUbicacion[j - 1];
					departamentosEnUbicacion[j - 1] = departamentosEnUbicacion[j];
					departamentosEnUbicacion[j] = propAuxiliar;
				}
			}
		}
		return departamentosEnUbicacion;
	}

	public Ph[] getPhsOrdenadosPorUbicacion() {
		Ph[] phsEnUbicacion = phs;
		int cantidadTotal = getCantidadDeElementos(phs);

		Ph propAuxiliar;

		for (int i = 0; i < cantidadTotal; i++) {
			for (int j = 1; j < (cantidadTotal - i); j++) {
				if (phsEnUbicacion[j - 1].getCiudad().compareTo(phsEnUbicacion[j].getCiudad()) > 0) {
					// intercambiar elementos
					propAuxiliar = phsEnUbicacion[j - 1];
					phsEnUbicacion[j - 1] = phsEnUbicacion[j];
					phsEnUbicacion[j] = propAuxiliar;
				}
			}
		}
		return phsEnUbicacion;
	}

	public Terreno[] getTerrenosOrdenadosPorUbicacion() {
		Terreno[] terrenosEnUbicacion = terrenos;
		int cantidadTotal = getCantidadDeElementos(terrenos);

		Terreno propAuxiliar;

		for (int i = 0; i < cantidadTotal; i++) {
			for (int j = 1; j < (cantidadTotal - i); j++) {
				if (terrenosEnUbicacion[j - 1].getCiudad().compareTo(terrenosEnUbicacion[j].getCiudad()) > 0) {
					// intercambiar elementos
					propAuxiliar = terrenosEnUbicacion[j - 1];
					terrenosEnUbicacion[j - 1] = terrenosEnUbicacion[j];
					terrenosEnUbicacion[j] = propAuxiliar;
				}
			}
		}
		return terrenosEnUbicacion;
	}

	public void buscarPropiedadesPorUbicacion(String ubicacion) {
		obtenerListadoDeCasasPorUbicacion(ubicacion);
		obtenerListadoDeDepartamentosPorUbicacion(ubicacion);
		obtenerListadoDePhsPorUbicacion(ubicacion);
		obtenerListadoDeTerrenosPorUbicacion(ubicacion);
	}

	public void obtenerListadoDeCasasPorUbicacion(String ciudad) {
		System.out.println("\nCASAS EN UBICACION:");

		for (Casa casita : casas) {
			if (casita == null) {
				break;
			} else if (casita.getCiudad().contains(ciudad)) {
				casita.toString();
			}
		}

		System.out.println("NO HAY MAS CASAS A MOSTRAR.");
	}

	public void obtenerListadoDeDepartamentosPorUbicacion(String ciudad) {
		System.out.println("\nDEPARTAMENTOS EN UBICACION:");

		for (Departamento dept : departamentos) {
			if (dept == null) {
				break;
			} else if (dept.getCiudad().contains(ciudad)) {
				dept.toString();
			}
		}

		System.out.println("NO HAY MAS DEPARTAMENTOS A MOSTRAR.");
	}

	public void obtenerListadoDePhsPorUbicacion(String ciudad) {
		System.out.println("\nPHS EN UBICACION:");

		for (Ph ph : phs) {
			if (ph == null) {
				break;
			} else if (ph.getCiudad().contains(ciudad)) {
				System.out.println(ph.toString());
			}
		}

		System.out.println("NO HAY MAS PHS A MOSTRAR.");
	}

	public void obtenerListadoDeTerrenosPorUbicacion(String ciudad) {
		System.out.println("\nTERRENOS EN UBICACION:");

		for (Terreno terrenito : terrenos) {
			if (terrenito == null) {
				break;
			} else if (terrenito.getCiudad().contains(ciudad)) {
				System.out.println(terrenito.toString());
			}
		}

		System.out.println("NO HAY MAS TERRENOS A MOSTRAR.");
	}

	public void obtenerListadoPorUbicacion() {
		System.out.println("\nPROPIEDADES EN UBICACION:\n");

		ArrayList<Casa> casasOrdenadas = getCasasOrdenadasPorUbicacion();
		Departamento[] deptsOrdenados = getDepartamentosOrdenadosPorUbicacion();
		Ph[] phsOrdenados = getPhsOrdenadosPorUbicacion();
		Terreno[] terrenosOrdenadas = getTerrenosOrdenadosPorUbicacion();

		System.out.println("\nCASAS:");
		for (Casa casita : casasOrdenadas) {
			if (casita != null) {
				System.out.println(casita.toString());
			} else {
				break;
			}
		}

		System.out.println("\nDEPARTAMENTOS:");
		for (Departamento depts : deptsOrdenados) {
			if (depts != null) {
				System.out.println(depts.toString());

			}
		}

		System.out.println("\nPHS: ");
		for (Ph phs : phsOrdenados) {
			if (phs != null) {
				System.out.println(phs.toString());
			}
		}

		System.out.println("\nTERRENOS: ");
		for (Terreno terrenos : terrenosOrdenadas) {
			if (terrenos != null) {
				System.out.println(terrenos.toString());
			}
		}

		System.out.println("\nNO HAY MAS PROPIEDADES A MOSTRAR.");
	}

	public void realizarVenta(String propiedadAVender, Propietario propietarioCompraNuevo) {

		switch (propiedadAVender.charAt(0)) {
		case 'C':
			for(Casa casita : casas) {
				String id = casita.getId();
				if (propiedadAVender.equals(id)) {
					casita.setPropietario(propietarioCompraNuevo);
					System.out.println("SE COMPLETO VENTA DE " + casita.toString());
				}
			}

		case 'D':
			for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
				if (departamentos[i] != null) {
					Departamento departamento = departamentos[i];

					if (propiedadAVender.equals(departamento.getId())) {
						departamento.setPropietario(propietarioCompraNuevo);
						System.out.println("SE COMPLETO VENTA DE " + departamento.toString());
					}
				}
			}

		case 'P':
			for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
				if (phs[i] != null) {
					Ph ph = phs[i];

					if (propiedadAVender.equals(ph.getId())) {
						ph.setPropietario(propietarioCompraNuevo);
						System.out.println("SE COMPLETO VENTA DE " + ph.toString());
					}
				}
			}
		case 'T':
			for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
				if (terrenos[i] != null) {
					Terreno terreno = terrenos[i];

					if (propiedadAVender.equals(terreno.getId())) {
						terreno.setPropietario(propietarioCompraNuevo);
						System.out.println("SE COMPLETO VENTA DE " + terreno.toString());
					}
				}
			}
		}
	}

	public void realizarAlquiler(String propiedadAAlquilar, Inquilino inquilino, String fechaInicio, String fechaFin) {

		switch (propiedadAAlquilar.charAt(0)) {
		case 'C':
			
			for(Casa casita : casas) {
				String id = casita.getId();
				if (propiedadAAlquilar.equals(id)) {
					casita.setInquilino(inquilino);
					System.out.println("\nSE COMPLETO ALQUILER DE LA CASA: \n" + casita.toString() + "\nINQUILINO: "
							+ inquilino.toString() + "\n FECHA INICIO: " + fechaInicio + "\n FECHA FIN: "
							+ fechaFin);
				}
			}


		case 'D':
			for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
				if (departamentos[i] != null) {
					Departamento departamento = departamentos[i];

					if (propiedadAAlquilar.equals(departamento.getId())) {
						departamento.setInquilino(inquilino);
						System.out.println("\nSE COMPLETO ALQUILER DEL DEPARTAMENTO: \n" + departamento.toString()
								+ "\nINQUILINO: " + inquilino.toString() + "\n FECHA INICIO: " + fechaInicio
								+ "\n FECHA FIN: " + fechaFin);
					}
				}
			}

		case 'P':
			for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
				if (phs[i] != null) {
					Ph ph = phs[i];

					if (propiedadAAlquilar.equals(ph.getId())) {
						ph.setInquilino(inquilino);
						System.out.println("\nSE COMPLETO ALQUILER DEL PH:  \n" + ph.toString() + "\nINQUILINO: "
								+ inquilino.toString() + "\n FECHA INICIO: " + fechaInicio + "\n FECHA FIN: "
								+ fechaFin);
					}
				}
			}
		}
	}

	public Double valorPromedioCasas() {
		Double sum = 0.0;
		Integer cantCasas = 0;
		
		for (Casa casita : casas) {
				sum += casita.getPrecio();
				cantCasas++;
				
		}
		Double promedio = sum / cantCasas;
		return promedio;
	}

	public Double valorPromedioDepartamentos() {
		Double sum = 0.0;
		Integer cantDepts = 0;

		for (int i = 0; i < cantidadMaximaDePropiedades; i++) {
			if (departamentos[i] != null) {
				sum += departamentos[i].getPrecio();
				cantDepts++;
			} else {
				break;
			}
		}
		Double promedio = sum / cantDepts;
		return promedio;
	}

}
