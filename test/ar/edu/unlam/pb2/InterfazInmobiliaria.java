package ar.edu.unlam.pb2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class InterfazInmobiliaria {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Integer opcionSeleccionada = 0;
		Inmobiliaria inmobiliariaActual = new Inmobiliaria("Laria", "Monteagudo 321", "laria@inmobiliaria.com", "45250968");
		
		do {
			System.out.println("\nMenu de opciones");
			System.out.println("1.   Agregar nuevas propiedades ");
			System.out.println("2.   Modificar propiedades ");
			System.out.println("3.   Agregar clientes ");
			System.out.println("4.   Obtener listado de propiedades ordenado por precio ");
			System.out.println("5.   Obtener listado de propiedades ordenado por ubicacion ");
			System.out.println("6.   Buscar propiedades por rango de precio ");
			System.out.println("7.   Buscar propiedades por ubicacion ");
			System.out.println("8.   Realizar la venta de una propiedad ");
			System.out.println("9.   Realizar el alquiler de una propiedad ");
			System.out.println("10.   Salir");
			
			System.out.println("\nIngrese la opcion deseada: ");
			opcionSeleccionada = teclado.nextInt();

			switch(OpcionDeMenu.values()[opcionSeleccionada -1]) {
			case AGREGAR_PROPIEDAD:
				inmobiliariaActual.agregarPropiedad();
				break;
				
			case MODIFICAR_PROPIEDAD:
				Boolean propiedadEncontrada = false;
				
				while(propiedadEncontrada == false) {
					System.out.println("Ingrese id de la propiedad a modificar: ");
					String idPropiedad = teclado.next();
					
					propiedadEncontrada = inmobiliariaActual.editarPropiedad(idPropiedad);
					
					
					if(propiedadEncontrada == false) {
						System.out.println("NO SE ENCONTRO PROPIEDAD\n");
					} else {
						System.out.println("SE EDITO PROPIEDAD.\n");
					}
				}	
				break;
				
			case AGREGAR_CLIENTE:
				Cliente cliente = inmobiliariaActual.crearCliente();
				inmobiliariaActual.agregarCliente(cliente);
				
				System.out.println("CLIENTE AGREGADO EXITOSAMENTE.");
				break;
				
			case OBTENER_LISTADO_POR_PRECIO:
				inmobiliariaActual.obtenerListadoPorPrecio();
				break;
				
			case OBTENER_LISTADO_POR_UBICACION:
				inmobiliariaActual.obtenerListadoPorUbicacion();
				break;
				
			case BUSCAR_PROPIEDADES_POR_PRECIO:
				System.out.println("\nIngrese precio minimo: ");
				Double precioMin = teclado.nextDouble();
				
				System.out.println("\nIngrese precio maximo: ");
				Double precioMax = teclado.nextDouble();
				
				inmobiliariaActual.buscarPropiedadesPorPrecio(precioMin, precioMax);
				break;
				
			case BUSCAR_PROPIEDADES_POR_UBICACION:
				System.out.println("\nIngresar ubicacion deseada: ");
				String ubicacion = teclado.next();
				
				inmobiliariaActual.buscarPropiedadesPorUbicacion(ubicacion);
				break;
				
			case REALIZAR_VENTA:
				System.out.println("\nIngresar codigo de propiedad a vender: ");
				String propiedad = teclado.next();
				
				System.out.println("\nIngresar nombre propietario nuevo: ");
				String nombre = teclado.next();
				
				System.out.println("\nIngresar apellido propietario nuevo: ");
				String apellido = teclado.next();
				
				System.out.println("\nIngresar dni propietario nuevo: ");
				Integer dni = teclado.nextInt();
				
				System.out.println("\nIngresar email propietario nuevo: ");
				String email = teclado.next();
				
				System.out.println("\nIngresar telefono propietario nuevo: ");
				String telefono = teclado.next();
				
				Propietario propietarioNuevo = new Propietario(nombre, apellido, dni, email, telefono);
				inmobiliariaActual.realizarVenta(propiedad, propietarioNuevo);
				break;
				
			case REALIZAR_ALQUILER:

				System.out.println("\nIngresar codigo de propiedad a alquilar: ");
				String propiedadAlquilada = teclado.next();
				
				System.out.println("\nIngresar nombre inquilino nuevo: ");
				String nombreInq = teclado.next();
				
				System.out.println("\nIngresar apellido inquilino nuevo: ");
				String apellidoInq = teclado.next();
				
				System.out.println("\nIngresar dni inquilino nuevo: ");
				Integer dniInq = teclado.nextInt();
				
				System.out.println("\nIngresar email inquilino nuevo: ");
				String emailInq = teclado.next();
				
				System.out.println("\nIngresar telefono inquilino nuevo: ");
				String telefonoInq = teclado.next();
				
				System.out.println("\nIngresar fecha inicio: dd-MM-yyyy ");
				String fechaInicio = teclado.next();
				
				System.out.println("\nIngresar fecha fin: dd-MM-yyyy ");
				String fechaFin = teclado.next();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate fInicio = LocalDate.parse(fechaInicio, formatter);
				LocalDate fFin = LocalDate.parse(fechaFin, formatter);
				Inquilino inquilino = new Inquilino(nombreInq, apellidoInq, dniInq, emailInq, telefonoInq, null);
				inmobiliariaActual.realizarAlquiler(propiedadAlquilada,inquilino, fechaInicio, fechaFin);
				break;
				
			case SALIR:
				System.out.println("Adios.");
				break;
			}
			
		} while(opcionSeleccionada!=10);
		
		teclado.close();
	} 
	
	
	
}