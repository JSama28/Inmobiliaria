package ar.edu.unlam.pb2;

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
				Propiedad prop = inmobiliariaActual.crearPropiedad();
				inmobiliariaActual.agregarPropiedad(prop);
				
				System.out.println("SE AGREGO PROPIEDAD.");
				break;
				
			case MODIFICAR_PROPIEDAD:
				Boolean propiedadEncontrada = false;
				
				while(propiedadEncontrada == false) {
					System.out.println("Ingrese calle de propiedad a modificar: ");
					String calle = teclado.next();
					System.out.println("Ingrese numero de propiedad a modificar: ");
					Integer numeroAModif = teclado.nextInt();
					
					propiedadEncontrada = inmobiliariaActual.editarPropiedad(calle, numeroAModif);
					
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
				break;
			case REALIZAR_ALQUILER:
				break;
			case SALIR:
				System.out.println("Adios.");
				break;
			}
			
		} while(opcionSeleccionada!=10);
		
		teclado.close();
	} 
	
	
	
}