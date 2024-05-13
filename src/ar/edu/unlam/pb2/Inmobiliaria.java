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
	private HashSet<Departamento> departamentos;
	private HashSet<Ph> phs;
	private HashSet<Terreno> terrenos;
	private Cliente clientes[];
	private final Integer cantidadMaximaDeClientes = 100;

	public Inmobiliaria(String nombre, String direccion, String eMail, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.casas = new HashSet<Casa>();
		this.departamentos = new HashSet<Departamento>();
		this.phs = new HashSet<Ph>();
		this.terrenos = new HashSet<Terreno>();
		this.clientes = new Cliente[cantidadMaximaDeClientes];

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
		if (departamentos.add(nuevoDept)) {
			System.out.println("SE AGREGO DEPARTAMENTO: " + nuevoDept.toString());
			return true;
		}else {
			System.out.println("NO SE PUDO AGREGAR DEPARTAMENTO: " + nuevoDept.toString());
			return false;
		}
	}

	public Boolean agregarPh(Ph nuevoPh) {
		if (phs.add(nuevoPh)) {
			System.out.println("SE AGREGO PH: " + nuevoPh.toString());
			return true;
		}else {
			System.out.println("NO SE PUDO AGREGAR PH: " + nuevoPh.toString());
			return false;
		}
	}

	public Boolean agregarTerreno(Terreno nuevoTerreno) {
		if (terrenos.add(nuevoTerreno)) {
			System.out.println("SE AGREGO TERRENO: " + nuevoTerreno.toString());
			return true;
		}else {
			System.out.println("NO SE PUDO AGREGAR TERRENO: " + nuevoTerreno.toString());
			return false;

		}
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
			Departamento departamento = crearDepartamento(null);
			return agregarDepartamento(departamento);
		case PH:
			Ph ph = crearPh(null);
			return agregarPh(ph);
		case TERRENO:
			Terreno terreno = crearTerreno(null);
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

		String idCasa = id == null ? ("C" + casas.size()) : id;

		Casa casa = new Casa(nombreCalle, numero, ciudad, precio, true, tipo, propietario, idCasa);
		return casa;
	}

	public Departamento crearDepartamento(String id) {
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

		String idDept = id == null ? ("D" + departamentos.size()) : id;

		Departamento departamento = new Departamento(nombreCalle, numero, numDept, ciudad, precio, true, tipo,
				propietario, idDept);
		return departamento;
	}

	public Ph crearPh(String id) {
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
		String idPh = id == null ? ("P" + phs.size()) : id;

		Ph ph = new Ph(nombreCalle, numero, numPh, ciudad, precio, true, tipo, propietario, idPh);
		return ph;
	}

	public Terreno crearTerreno(String id) {
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
		String idTerreno = id == null ? ("T" + terrenos.size()) : id;

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
			for (Departamento dept : departamentos) {
				String id = dept.getId();

				if (idPropiedad.equals(id)) {
					System.out.println(dept.toString());

					Departamento deptEditado = crearDepartamento(id);
					departamentos.remove(dept);

					return departamentos.add(deptEditado);
				}
			}

		case 'P':
			for (Ph ph : phs) {
				String id = ph.getId();

				if (idPropiedad.equals(id)) {
					System.out.println(ph.toString());
					Ph phEditado = crearPh(id);
					return phs.add(phEditado);
				}
			}

		case 'T':
			for (Terreno terrenito : terrenos) {
				String id = terrenito.getId();

				if (idPropiedad.equals(id)) {
					System.out.println(terrenito.toString());
					Terreno terrenoEditado = crearTerreno(id);
					return terrenos.add(terrenoEditado);

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
		ArrayList<Departamento> deptsOrdenados = getDepartamentosOrdenadosPorPrecio();
		ArrayList<Ph> phsOrdenados = getPhsOrdenadosPorPrecio();
		ArrayList<Terreno> terrenosOrdenadas = getTerrenosOrdenadosPorPrecio();


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
			}else {
				break;
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

	public ArrayList<Departamento> getDepartamentosOrdenadosPorPrecio() {
		ArrayList<Departamento> deptsOrdenados = new ArrayList<Departamento>(departamentos);

		Collections.sort(deptsOrdenados, (a, b) -> {
			Double precioA = ((Departamento) a).getPrecio();
			Double precioB = ((Departamento) b).getPrecio();
			return precioA.compareTo(precioB);
		});

		return deptsOrdenados;
	}

	public ArrayList<Ph> getPhsOrdenadosPorPrecio() {
		ArrayList<Ph> phsOrdenados = new ArrayList<Ph>(phs);

		Collections.sort(phsOrdenados, (a, b) -> {
			Double precioA = ((Ph) a).getPrecio();
			Double precioB = ((Ph) b).getPrecio();
			return precioA.compareTo(precioB);
		});
		return phsOrdenados;
	}

	public ArrayList<Terreno> getTerrenosOrdenadosPorPrecio() {
		ArrayList<Terreno> terrenosOrdenados = new ArrayList<Terreno>(terrenos);

		Collections.sort(terrenosOrdenados, (a, b) -> {
			Double precioA = ((Terreno) a).getPrecio();
			Double precioB = ((Terreno) b).getPrecio();
			return precioA.compareTo(precioB);
		});


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

	public ArrayList<Departamento> mostrarDepartamentosPorPrecio(Double precioMin, Double precioMax) {
		ArrayList<Departamento> deptEntrePrecio = new ArrayList<Departamento>();
		Integer cantidadAgregada = 0;

		for (Departamento dept : departamentos) {
			if (dept.getPrecio() >= precioMin && dept.getPrecio() <= precioMax) {
				deptEntrePrecio.add(dept);
				cantidadAgregada++;
			}
		}

		System.out.println("\nDEPARTAMENTOS DENTRO DEL RANGO DE PRECIO: " + cantidadAgregada);

		for (Departamento dept : departamentos) {
			String descripcionPropiedad = dept.toString();
			System.out.println(descripcionPropiedad);
		}
		return cantidadAgregada > 0 ? deptEntrePrecio : null;
	}

	public ArrayList<Ph> mostrarPhsPorPrecio(Double precioMin, Double precioMax) {
		ArrayList<Ph> phsEntrePrecio = new ArrayList<Ph>();
		Integer cantidadAgregada = 0;

		for (Ph ph : phs) {
			if(ph.getPrecio() >= precioMin && ph.getPrecio() <= precioMax) {
				phsEntrePrecio.add(ph);
				cantidadAgregada++;
			}
		}

		System.out.println("\nPHS DENTRO DEL RANGO DE PRECIO: " + cantidadAgregada);

		for (Ph ph : phs) {
			String descripcionPropiedad = ph.toString();
			System.out.println(descripcionPropiedad);
		}
		return cantidadAgregada > 0 ? phsEntrePrecio : null;

	}

	public ArrayList<Terreno> mostrarTerrenosPorPrecio(Double precioMin, Double precioMax) {
		ArrayList<Terreno> terrenosEntrePrecio = new ArrayList<Terreno>();
		Integer cantidadAgregada = 0;

		for (Terreno terrenito : terrenos) {
			if(terrenito.getPrecio() >= precioMin && terrenito.getPrecio() <= precioMax) {
				terrenosEntrePrecio.add(terrenito);
				cantidadAgregada++;
			}
		}

		System.out.println("\nTERRENOS DENTRO DEL RANGO DE PRECIO: " + cantidadAgregada);

		for (Terreno terrenito : terrenos) {
			String descripcionPropiedad = terrenito.toString();
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

	public ArrayList<Departamento> getDepartamentosOrdenadosPorUbicacion() {
		ArrayList<Departamento> departamentosEnUbicacion = new ArrayList<Departamento>(departamentos);

		Collections.sort(departamentosEnUbicacion, (a, b) -> {
			String ubicacionA = ((Departamento) a).getCiudad();
			String ubicacionB = ((Departamento) b).getCiudad();
			return ubicacionA.compareTo(ubicacionB);
		});

		return departamentosEnUbicacion;
	}

	public ArrayList<Ph> getPhsOrdenadosPorUbicacion() {
		ArrayList<Ph> phsEnUbicacion = new ArrayList<Ph>(phs);

		Collections.sort(phsEnUbicacion, (a, b) -> {
			String ubicacionA = ((Ph) a).getCiudad();
			String ubicacionB = ((Ph) b).getCiudad();
			return ubicacionA.compareTo(ubicacionB);
		});

		return phsEnUbicacion;
	}

	public ArrayList<Terreno> getTerrenosOrdenadosPorUbicacion() {
		ArrayList<Terreno> terrenosEnUbicacion = new ArrayList<Terreno>(terrenos);

		Collections.sort(terrenosEnUbicacion, (a, b) -> {
			String ubicacionA = ((Terreno) a).getCiudad();
			String ubicacionB = ((Terreno) b).getCiudad();
			return ubicacionA.compareTo(ubicacionB);
		});

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
		ArrayList<Departamento> deptsOrdenados = getDepartamentosOrdenadosPorUbicacion();
		ArrayList<Ph> phsOrdenados = getPhsOrdenadosPorUbicacion();
		ArrayList<Terreno> terrenosOrdenadas = getTerrenosOrdenadosPorUbicacion();

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
			for (Departamento dept : departamentos) {
				String id = dept.getId();				
				if (propiedadAVender.equals(id)) {
					dept.setPropietario(propietarioCompraNuevo);
					System.out.println("SE COMPLETO VENTA DE " + dept.toString());
				}
			}

		case 'P':
			for (Ph ph : phs) {
				String id = ph.getId();
				if (propiedadAVender.equals(id)) {
					ph.setPropietario(propietarioCompraNuevo);
					System.out.println("SE COMPLETO VENTA DE " + ph.toString());
				}
			}

		case 'T':
			for (Terreno terrenito : terrenos) {
				String id = terrenito.getId();
				if (propiedadAVender.equals(id)) {
					terrenito.setPropietario(propietarioCompraNuevo);
					System.out.println("SE COMPLETO VENTA DE " + terrenito.toString());
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
			for (Departamento dept : departamentos) {

				if (propiedadAAlquilar.equals(dept.getId())) {
					dept.setInquilino(inquilino);
					System.out.println("\nSE COMPLETO ALQUILER DEL DEPARTAMENTO: \n" + dept.toString()
					+ "\nINQUILINO: " + inquilino.toString() + "\n FECHA INICIO: " + fechaInicio
					+ "\n FECHA FIN: " + fechaFin);
				}
			}

		case 'P':
			for (Ph ph : phs) {

				if (propiedadAAlquilar.equals(ph.getId())) {
					ph.setInquilino(inquilino);
					System.out.println("\nSE COMPLETO ALQUILER DEL PH:  \n" + ph.toString() + "\nINQUILINO: "
							+ inquilino.toString() + "\n FECHA INICIO: " + fechaInicio + "\n FECHA FIN: "
							+ fechaFin);
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

		for (Departamento dept : departamentos) {
			sum += dept.getPrecio();
			cantDepts++; 
		}
		Double promedio = sum / cantDepts;
		return promedio;
	}

}
