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
	private HashSet<Propiedad> propiedades;
	private Cliente clientes[];
	private final Integer cantidadMaximaDeClientes = 100;

	public Inmobiliaria(String nombre, String direccion, String eMail, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.propiedades = new HashSet<Propiedad>();
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

	public Boolean agregarPropiedad(Propiedad propiedad) {
		if (propiedades.add(propiedad)) {
			System.out.println("SE AGREGO PROPIEDAD: " + propiedad.toString());
			return true;
		} else {
			System.out.println("NO SE PUDO AGREGAR PROPIEDAD: " + propiedad.toString());
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
			return agregarPropiedad(casa);
		case DEPARTAMENTO:
			Departamento departamento = crearDepartamento(null);
			return agregarPropiedad(departamento);
		case PH:
			Ph ph = crearPh(null);
			return agregarPropiedad(ph);
		case TERRENO:
			Terreno terreno = crearTerreno(null);
			return agregarPropiedad(terreno);
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

		String idCasa = id == null ? ("C" + propiedades.size()) : id;

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

		String idDept = id == null ? ("D" + propiedades.size()) : id;

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
		String idPh = id == null ? ("P" + propiedades.size()) : id;

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
		String idTerreno = id == null ? ("T" + propiedades.size()) : id;

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

		for(Propiedad prop : propiedades) {
			String id = prop.getId();
			
			if (idPropiedad.equals(id)) {
				System.out.println(prop.toString());
				propiedades.remove(prop);
				
				switch (idPropiedad.charAt(0)) {
				case 'C':
					Casa casaEditada = crearCasa(id);
					return propiedades.add(casaEditada);
		
				case 'D':
					Departamento deptEditado = crearDepartamento(id);
					return propiedades.add(deptEditado);
		
				case 'P':
					Ph phEditado = crearPh(id);
					return propiedades.add(phEditado);
		
				case 'T':
					Terreno terrenoEditado = crearTerreno(id);
					return propiedades.add(terrenoEditado);
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

		ArrayList<Propiedad> propiedadesOrdenadas = getPropiedadesOrdenadasPorPrecio();

		System.out.println("\nPROPIEDADES:");
		for (Propiedad prop : propiedadesOrdenadas) {
			System.out.println(prop.toString());
		}
		
		System.out.println("\nNO HAY MAS PROPIEDADES A MOSTRAR.");
	}

	public ArrayList<Propiedad> getPropiedadesOrdenadasPorPrecio() {
		ArrayList<Propiedad> propiedadesOrdenados = new ArrayList<Propiedad>(propiedades);

		Collections.sort(propiedadesOrdenados, (a, b) -> {
			Double precioA = ((Propiedad) a).getPrecio();
			Double precioB = ((Propiedad) b).getPrecio();
			return precioA.compareTo(precioB);
		});

		return propiedadesOrdenados;
	}
	
	public ArrayList<Propiedad> getCasasOrdenadasPorPrecio() {
		ArrayList<Propiedad> propiedadesOrdenadas = new ArrayList<Propiedad>();

		for(Propiedad prop : propiedades) {
			if(prop.getId().charAt(0) == 'C') {
				propiedadesOrdenadas.add(prop);
			}
		}
		
		Collections.sort(propiedadesOrdenadas, (a, b) -> {
			Double precioA = ((Propiedad) a).getPrecio();
			Double precioB = ((Propiedad) b).getPrecio();
			return precioA.compareTo(precioB);
		});

		return propiedadesOrdenadas;
	}

	public ArrayList<Propiedad> buscarPropiedadesPorPrecio(Double precioMin, Double precioMax) {
		ArrayList<Propiedad> propEntrePrecio = new ArrayList<Propiedad>(); 

		for (Propiedad prop: propiedades) {
			if (prop.getPrecio() >= precioMin && prop.getPrecio() <= precioMax) {
				propEntrePrecio.add(prop);
			}
		}

		System.out.println("\nPROPIEDADES DENTRO DEL RANGO DE PRECIO: " + propEntrePrecio.size());

		for (Propiedad prop : propEntrePrecio) {
			String descripcionPropiedad = prop.toString();
			System.out.println(descripcionPropiedad);
		}
		
		return propEntrePrecio.size() > 0 ? propEntrePrecio : null;
	}

	public ArrayList<Propiedad> getPropiedadesOrdenadasPorUbicacion() {
		ArrayList<Propiedad> propEnUbicacion = new ArrayList<Propiedad>(propiedades);
	
		Collections.sort(propEnUbicacion, (a, b) -> {
			String ubicacionA = ((Propiedad) a).getCiudad();
			String ubicacionB = ((Propiedad) b).getCiudad();
			return ubicacionA.compareTo(ubicacionB);
			
		});
		
		System.out.println("\nPROPIEDADES DENTRO DEL RANGO DE UBICACION: " + propEnUbicacion.size());
		return propEnUbicacion.size() > 0 ? propEnUbicacion : null;
	}

	public ArrayList<Propiedad> getCasasOrdenadasPorUbicacion() {
		ArrayList<Propiedad> propEnUbicacion = new ArrayList<Propiedad>();
	
		for(Propiedad prop : propiedades) {
			if(prop.getId().charAt(0) == 'C') {
				propEnUbicacion.add(prop);
			}
		}
		
		Collections.sort(propEnUbicacion, (a, b) -> {
			String ubicacionA = ((Propiedad) a).getCiudad();
			String ubicacionB = ((Propiedad) b).getCiudad();
			return ubicacionA.compareTo(ubicacionB);
			
		});
		
		System.out.println("\nCASAS DENTRO DEL RANGO DE UBICACION: " + propEnUbicacion.size());
		return propEnUbicacion.size() > 0 ? propEnUbicacion : null;
	}
	
	public void buscarPropiedadesPorUbicacion(String ubicacion) {
		System.out.println("\nPROPIEDADES EN UBICACION:");

		for (Propiedad prop : propiedades) {
			if (prop.getCiudad().contains(ubicacion)) {
				System.out.println(prop.toString());
			}
		}

		System.out.println("NO HAY MAS CASAS A MOSTRAR.");
	}

	public void obtenerListadoPorUbicacion() {
		System.out.println("\nPROPIEDADES EN UBICACION:\n");

		ArrayList<Propiedad> propOrdenadas = getPropiedadesOrdenadasPorUbicacion();
		
		System.out.println("\nPROPIEDADES:");
		for (Propiedad prop : propOrdenadas) {
			System.out.println(prop.toString());
		}

		System.out.println("\nNO HAY MAS PROPIEDADES A MOSTRAR.");
	}

	public void realizarVenta(String propiedadAVender, Propietario propietarioCompraNuevo) {
		for(Propiedad prop : propiedades) {
			String id = prop.getId();
			if (propiedadAVender.equals(id)) {
				prop.setPropietario(propietarioCompraNuevo);
				System.out.println("SE COMPLETO VENTA DE " + prop.toString());
			}
		}
	}

	public void realizarAlquiler(String propiedadAAlquilar, Inquilino inquilino, String fechaInicio, String fechaFin) {
		for(Propiedad prop : propiedades) {
			String id = prop.getId();
			
			if (propiedadAAlquilar.equals(id)) {
				switch (id.charAt(0)) {
				case 'C':
					Casa casa = (Casa) prop;
					casa.setInquilino(inquilino);
		
				case 'D':
					Departamento dept = (Departamento) prop;
					dept.setInquilino(inquilino);
		
				case 'P':
					Ph ph = (Ph) prop;
					ph.setInquilino(inquilino);
				}
				
				System.out.println("\nSE COMPLETO ALQUILER DE LA PROPIEDAD: \n" + prop.toString() + "\nINQUILINO: "
						+ inquilino.toString() + "\n FECHA INICIO: " + fechaInicio + "\n FECHA FIN: "
						+ fechaFin);
			}
		}
	}

	public Double valorPromedioCasas() {
		Double sum = 0.0;
		Integer cantCasas = 0;

		for (Propiedad prop : propiedades) {
			Boolean esCasa = prop.getId().charAt(0) == 'C';
			
			if(esCasa) {
				sum += prop.getPrecio();
				cantCasas++;
			}
		}
		Double promedio = sum / cantCasas;
		return promedio;
	}

	public Double valorPromedioDepartamentos() {
		Double sum = 0.0;
		Integer cantDepartamentos = 0;

		for (Propiedad prop : propiedades) {
			Boolean esDepartamento = prop.getId().charAt(0) == 'D';
			
			if(esDepartamento) {
				sum += prop.getPrecio();
				cantDepartamentos++;
			}
		}
		Double promedio = sum / cantDepartamentos;
		return promedio;
	}

	public ArrayList<Propiedad> getListadoPropiedadesEnVenta() {
		System.out.println("\nPROPIEDADES EN VENTA:\n");

		ArrayList<Propiedad> propEnVenta= new ArrayList<Propiedad>(propiedades);

		for(Propiedad prop : propiedades) {
			if(prop.getTipo().equals(TipoDeOperacion.VENTA)){
				propEnVenta.add(prop);
				System.out.println(prop.toString());
			}
		}
		System.out.println("NO HAY MAS PROPIEDADES A MOSTRAR.");
		return (propEnVenta.size() == 0) ? null : propEnVenta;
	}

	public ArrayList<Propiedad> getListadoPropiedadesEnAlquiler() {
		System.out.println("\nPROPIEDADES EN ALQUILER:\n");

		ArrayList<Propiedad> propEnAlquiler = new ArrayList<Propiedad>(propiedades);

		for(Propiedad prop : propiedades) {
			if(prop.getTipo().equals(TipoDeOperacion.ALQUILER)){
				propEnAlquiler.add(prop);
				System.out.println(prop.toString());
			}
		}
		System.out.println("NO HAY MAS PROPIEDADES A MOSTRAR.");
		return (propEnAlquiler.size() == 0) ? null : propEnAlquiler;
	}
}
