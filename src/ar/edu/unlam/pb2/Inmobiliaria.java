package ar.edu.unlam.pb2;


import java.util.Scanner;


public class Inmobiliaria {

	private String nombre;
	private String direccion;
	private String eMail;
	private String telefono;
	private Propiedad propiedades[];
	private Cliente clientes[];
	private final Integer cantidadMaximaDePropiedades = 100;
	private final Integer cantidadMaximaDeClientes = 100;


	public Inmobiliaria(String nombre, String direccion, String eMail, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
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
	
	public Boolean agregarPropiedad(Propiedad nuevaPropiedad){
		for(int i=0; i<cantidadMaximaDePropiedades; i++) {
			if(propiedades[i]==null) {
				propiedades[i] = nuevaPropiedad;
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

	public Propiedad crearPropiedad() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese nombre de calle: ");
		String nombreCalle = teclado.next();

		System.out.println("Ingrese numero: ");
		Integer numero = teclado.nextInt();

		System.out.println("Ingrese ciudad: ");
		String ciudad = teclado.next();

		System.out.println("Ingrese precio: ");
		Double precio = teclado.nextDouble();	

		Boolean tipoValido = false;
		TipoDeOperacion tipo = TipoDeOperacion.VENTA;

		while(tipoValido == false) {
			System.out.println("Ingrese tipo operacion: alquiler/venta");
			String tipoOperacion = teclado.next();


			if(tipoOperacion.equals("venta")) {
				tipo = TipoDeOperacion.VENTA;
				tipoValido = true;
			} else if(tipoOperacion.equals("alquiler")) {
				tipo = TipoDeOperacion.ALQUILER;
				tipoValido = true;
			} else {
				System.out.println("Tipo invalido");
			}
		}

		Propiedad prop = new Propiedad(nombreCalle, numero, ciudad, precio, true, tipo);

		return prop;
	}

	public Boolean editarPropiedad(String calle, Integer numero) {		
		for(int i=0; i<cantidadMaximaDePropiedades; i++) {
			if(propiedades[i]!=null) {
				Propiedad prop = propiedades[i];

				if(calle.equals(prop.getCalle()) && numero.equals(prop.getNumero())) {
					propiedades[i] = crearPropiedad();
					return true;
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

	public Integer getCantidadDePropiedades() {
		Integer cantidad = 0;

		for(int i = 0; i<cantidadMaximaDePropiedades; i++) {
			if(propiedades[i] != null) {
				cantidad++;
			} else {
				break;
			}
		}

		return cantidad;
	}

	public Propiedad[] getPropiedadesOrdenadasPorPrecio() {
		Propiedad[] propOrdenadas = propiedades;
		int cantidadTotal = getCantidadDePropiedades();
		
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
		int cantidadTotal = getCantidadDePropiedades();
		
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

		for(int i = 0; i < getCantidadDePropiedades(); i++) {
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

		for(int i = 0; i < getCantidadDePropiedades(); i++) {
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
