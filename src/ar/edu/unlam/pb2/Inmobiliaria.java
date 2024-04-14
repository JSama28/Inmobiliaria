package ar.edu.unlam.pb2;
import java.util.Scanner;


public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private String telefono;
	private Casa casas[];
	private Departamento departamentos[];
	private Ph phs[];
	private Terreno terrenos[];
	private Propiedad propiedades[];
	private Cliente clientes[];
	private final Integer cantidadMaximaDePropiedades = 100;
	private final Integer cantidadMaximaDeClientes = 100;


	public Inmobiliaria(String nombre, String direccion, String eMail, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.casas = new Casa[cantidadMaximaDePropiedades];
		this.departamentos = new Departamento[cantidadMaximaDePropiedades];
		this.phs = new Ph[cantidadMaximaDePropiedades];
		this.terrenos = new Terreno[cantidadMaximaDePropiedades];
		this.propiedades = new Propiedad[cantidadMaximaDePropiedades];
		this.clientes = new Cliente[cantidadMaximaDeClientes];

		this.propiedades[0] = new Propiedad("ardoino", 123, "ramos", 5.5, true, TipoDeOperacion.ALQUILER);
		this.propiedades[1] = new Propiedad("monteagudo", 254, "temos", 2.5, true, TipoDeOperacion.VENTA);
		this.propiedades[2] = new Propiedad("escalada", 3254, "pozos", 1.5, true, TipoDeOperacion.VENTA);
		this.propiedades[3] = new Propiedad("suipacha", 1554, "atres", 7.5, true, TipoDeOperacion.ALQUILER);
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
		for(int i=0; i<cantidadMaximaDePropiedades; i++) {
			if(casas[i]==null) {
				casas[i] = nuevaCasa;
				System.out.println("SE AGREGO CASA." + nuevaCasa.toString());
				return true;
			}
		}
		return false;
	}
	
	public Boolean agregarDepartamento(Departamento nuevoDept) {
		for(int i=0; i<cantidadMaximaDePropiedades; i++) {
			if(departamentos[i]==null) {
				departamentos[i] = nuevoDept;
				System.out.println("SE AGREGO DEPARTAMENTO." + nuevoDept.toString());
				return true;
			}
		}
		return false;
	}

	public Boolean agregarPh(Ph nuevoPh) {
		for(int i=0; i<cantidadMaximaDePropiedades; i++) {
			if(phs[i]==null) {
				phs[i] = nuevoPh;
				System.out.println("SE AGREGO PH." + nuevoPh.toString());
				return true;
			}
		}
		return false;
	}
	
	public Boolean agregarTerreno(Terreno nuevoTerreno) {
		for(int i=0; i<cantidadMaximaDePropiedades; i++) {
			if(terrenos[i]==null) {
				terrenos[i] = nuevoTerreno;
				System.out.println("SE AGREGO TERRENO." + nuevoTerreno.toString());
				return true;
			}
		}
		return false;
	}
	
	public Boolean agregarCliente(Cliente nuevoCliente){
		for(int i=0; i<cantidadMaximaDeClientes; i++) {
			if(clientes[i]==null) {
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
		
		switch(TipoDePropiedad.values()[opcionSeleccionada -1]) {
		case CASA:
			Casa casa = crearCasa();
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
		}

		return false;
	} 

	public Casa crearCasa() {
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

		String idCasa = "C" + getCantidadDeElementos(casas);
		
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

		Departamento departamento = new Departamento(nombreCalle, numero, numDept, ciudad, precio, true, tipo, propietario, idDept);
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

		Terreno terreno = new Terreno(nombreCalle, numero,ciudad, mtsCuadrados, precio, true, tipo, propietario, idTerreno);
		return terreno;
	}
	
		
	public TipoDeOperacion seleccionarTipoDeOperacion() {
		Scanner teclado = new Scanner(System.in);

		Boolean tipoValido = false;
		TipoDeOperacion tipo = TipoDeOperacion.VENTA;

		while(tipoValido == false) {
			System.out.println("Ingrese tipo operacion: alquiler/venta/permuta");
			String tipoOperacion = teclado.next();

			if(tipoOperacion.equals("venta")) {
				tipo = TipoDeOperacion.VENTA;
				tipoValido = true;
			} else if(tipoOperacion.equals("alquiler")) {
				tipo = TipoDeOperacion.ALQUILER;
				tipoValido = true;
			} else if(tipoOperacion.equals("permuta")) {
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
	
		Propietario propietario = new Propietario(nombre, apellido, dni, null, null);
		return propietario;
	}
	
	
	public Boolean editarPropiedad(String idPropiedad) {		
		
		switch(idPropiedad.charAt(0)) {
		case 'C':
			for(int i=0; i<cantidadMaximaDePropiedades; i++) {
				if(casas[i]!=null) {
					Casa casa = casas[i];

					if(idPropiedad.equals(casa.getIdCasa())) {
						System.out.println(casas[i].toString());
						casas[i] = crearCasa();
						return true;
					}
				}
			}
			
		case 'D':
			for(int i=0; i<cantidadMaximaDePropiedades; i++) {
				if(departamentos[i]!=null) {
					Departamento departamento = departamentos[i];

					if(idPropiedad.equals(departamento.getIdDep())) {
						System.out.println(departamentos[i].toString());
						departamentos[i] = crearDepartamento();
						return true;
					}
				}
			}
			
		case 'P':
			for(int i=0; i<cantidadMaximaDePropiedades; i++) {
				if(phs[i]!=null) {
					Ph ph = phs[i];

					if(idPropiedad.equals(ph.getIdPh())) {
						System.out.println(phs[i].toString());
						phs[i] = crearPh();
						return true;
					}
				}
			}
		case 'T':
			for(int i=0; i<cantidadMaximaDePropiedades; i++) {
				if(terrenos[i]!=null) {
					Terreno terreno = terrenos[i];

					if(idPropiedad.equals(terreno.getIdTerreno())) {
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
		
		Boolean noHayMasPropiedades = false;
		Integer i = 0;

		Propiedad[] propiedadesOrdenadas = getPropiedadesOrdenadasPorPrecio();

		while(noHayMasPropiedades == false && i<cantidadMaximaDePropiedades) {
			System.out.println(propiedadesOrdenadas[i].toString());
			i++;
			if(propiedadesOrdenadas[i] == null) {
				noHayMasPropiedades = true;
			}
		}

		System.out.println("\nNO HAY MAS PROPIEDADES A MOSTRAR.");	
	}

	public Integer getCantidadDeElementos(Object[] array) {
		Integer cantidad = 0;

		for(int i = 0; i<array.length; i++) {
			if(array[i] != null) {
				cantidad++;
			} else {
				break;
			}
		}

		return cantidad;
	}

	public Propiedad[] getPropiedadesOrdenadasPorPrecio() {
		Propiedad[] propOrdenadas = propiedades;
		int cantidadTotal = getCantidadDeElementos(propiedades);
		
		Propiedad propAuxiliar;  
		
		for(int i=0; i < cantidadTotal; i++){  
			for(int j=1; j < (cantidadTotal-i); j++){  
				if(propOrdenadas[j-1].getPrecio() > propOrdenadas[j].getPrecio()){  
					//intercambiar elementos
					propAuxiliar = propOrdenadas[j-1];  
					propOrdenadas[j-1] = propOrdenadas[j];  
					propOrdenadas[j] = propAuxiliar;  
				}  
			}  
		}  

		return propOrdenadas;
	}

	public Propiedad[] getPropiedadesOrdenadasPorUbicacion() {
		Propiedad[] propOrdenadas = propiedades;
		int cantidadTotal = getCantidadDeElementos(propiedades);
		
		Propiedad propAuxiliar;  
		
		for(int i=0; i < cantidadTotal; i++){  
			for(int j=1; j < (cantidadTotal-i); j++){  
				if(propOrdenadas[j-1].getCiudad().compareTo(propOrdenadas[j].getCiudad()) > 0){  
					//intercambiar elementos
					propAuxiliar = propOrdenadas[j-1];  
					propOrdenadas[j-1] = propOrdenadas[j];  
					propOrdenadas[j] = propAuxiliar;  
				}  
			}  
		}  

		return propOrdenadas;
	}
	
	public void obtenerListadoPorUbicacion() {
		System.out.println("\nPROPIEDADES:\n");	
		
		Boolean noHayMasPropiedades = false;
		Integer i = 0;

		Propiedad[] propiedadesOrdenadas = getPropiedadesOrdenadasPorUbicacion();

		while(noHayMasPropiedades == false && i<cantidadMaximaDePropiedades) {
			System.out.println(propiedadesOrdenadas[i].toString());
			i++;
			if(propiedadesOrdenadas[i] == null) {
				noHayMasPropiedades = true;
			}
		}

		System.out.println("\nNO HAY MAS PROPIEDADES A MOSTRAR.");	
	}

	public void buscarPropiedadesPorPrecio(Double precioMin, Double precioMax) {
		Propiedad[] propEntrePrecio = new Propiedad[cantidadMaximaDePropiedades];
		Integer cantidadAgregada = 0;
		int cantidadTotal = getCantidadDeElementos(propiedades);
		
		for(int i = 0; i < cantidadTotal; i++) {
			System.out.println(propiedades[i].getPrecio());
			
			if(propiedades[i].getPrecio() >= precioMin && propiedades[i].getPrecio() <= precioMax) {
				propEntrePrecio[cantidadAgregada] = propiedades[i];
				cantidadAgregada++;
			}
		}
		
		System.out.println("\nPROPIEDADES DENTRO DEL RANGO DE PRECIO: " + cantidadAgregada);
		
		for(int j = 0; j < cantidadAgregada; j++) {
			String descripcionPropiedad = propEntrePrecio[j].toString();
			System.out.println(descripcionPropiedad);
		}
	}
	
	public void buscarPropiedadesPorUbicacion(String ubicacionBuscada) {
		Propiedad[] propEnUbicacion = new Propiedad[cantidadMaximaDePropiedades];
		Integer cantidadAgregada = 0;
		int cantidadTotal = getCantidadDeElementos(propiedades);
		
		for(int i = 0; i < cantidadTotal; i++) {
			System.out.println(propiedades[i].getPrecio());
			
			if(propiedades[i].getCiudad().equals(ubicacionBuscada)) {
				propEnUbicacion[cantidadAgregada] = propiedades[i];
				cantidadAgregada++;
			}
		}
		
		System.out.println("\nPROPIEDADES DENTRO DE LA UBICACION DESEADA: " + cantidadAgregada);
		
		for(int j = 0; j < cantidadAgregada; j++) {
			String descripcionPropiedad = propEnUbicacion[j].toString();
			System.out.println(descripcionPropiedad);
		}
	}


}
