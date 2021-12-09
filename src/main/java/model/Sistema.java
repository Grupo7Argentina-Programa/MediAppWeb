package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.UserDAO;
import persistence.common.DAOFactory;

public class Sistema {

	static Scanner entrada = new Scanner(System.in);
	static TreeSet<Atraccion> listaAtracciones = new TreeSet<Atraccion>();
	static TreeSet<Usuario> listaUsuarios = new TreeSet<Usuario>();
	static TreeSet<Promocion> listaPromociones = new TreeSet<Promocion>();
	static Usuario user;

	public static void main(String[] args) {

		leerAtracciones();
		leerPromociones();
		leerUsuarios();

		try {
			Scanner entrada = new Scanner(System.in);
			int opcion = 1;
			while (opcion != 0) {
				while (user == null) {
					System.out.println("Bienvenido a MediApp");
					System.out.println("---------------------------");
					System.out.println("\n 1) CREAR USUARIO \n 2) INGRESAR \n 0) SALIR");
					System.out.println("---------------------------");
					opcion = entrada.nextInt();
					if (opcion == 1) {
						crearUsuarioNuevo();
					}
					if (opcion == 2) {
						System.out.print("Por favor, ingresá tu usuario \n");
						String usuario = entrada.next();
						System.out.println("---------------------------");
						new Sistema().cambiarUsuario(usuario);
					}
					if (opcion == 0) {
						break;
					}
				}
				while (user != null) {
					System.out.println("Te damos la bienvenida, " + user.getNombre());
					System.out.println("Tu saldo es de " + user.getPresupuesto() + " monedas de oro");
					System.out.println("Te quedan " + user.getTiempoDisponible() + " horas dispnibles");
					System.out.println(
							"\n 1) CAMBIAR USUARIO \n "
							+ "2) VER MIS SUGERENCIAS \n "
							+ "3) VER MI ITINERARIO \n "
							+ "4) CERRAR SESIÓN \n "
							+ "0) SALIR");
					System.out.println("---------------------------");
					opcion = entrada.nextInt();
					System.out.println("---------------------------");
					if (opcion == 1) {
						System.out.println("\n Por favor, ingresá tu usuario");
						String nuevoUsuario = entrada.next();
						System.out.println("---------------------------");
						new Sistema().cambiarUsuario(nuevoUsuario);
					}
					if (opcion == 2) {
						new Sistema().sugerirItinerario(user);
					}
					if (opcion == 3) {
						System.out.println(
								user.getItinerario().toString().replace("[", "").replace("]", "\n").replace(",", ""));
					}
					if (opcion == 4) {
						System.out.println("Hasta pronto, " + user.getNombre());
						user = null;
					}
					if (opcion == 0) {
						System.out.println("Hasta pronto, " + (user != null ? user.getNombre() : ""));
						break;
					}
				}
			}
			entrada.close();
			System.out.println("---------------------------");
			System.out.println("Gracias por usar MediApp");
		} catch (InputMismatchException e) {
			System.err.println("El valor ingresado no es válido");
		}
	}

	public void cambiarUsuario(String nuevoUsuario) {
		UserDAO userDAO = DAOFactory.getUserDAO();

		Sistema.user = userDAO.findByUsername(nuevoUsuario);
		if (Sistema.user == null) {
			System.err.println("Nombre de usuario no encontrado");
		}
	}

	private static TreeSet<Atraccion> leerAtracciones() {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		listaAtracciones = new TreeSet<Atraccion>(atraccionDAO.findAll());

		return listaAtracciones;

	}

	private static TreeSet<Usuario> leerUsuarios() {
		UserDAO userDAO = DAOFactory.getUserDAO();
		listaUsuarios = new TreeSet<Usuario>(userDAO.findAll());

		return listaUsuarios;
	}

	private static TreeSet<Promocion> leerPromociones() {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		listaPromociones = new TreeSet<Promocion>(promocionDAO.findAll());

		return listaPromociones;
	}

	public ArrayList<Mostrable> sugerirAtraccion(Usuario usuario) throws

	IOException {

		leerAtracciones();
		ArrayList<Mostrable> sugerencias = new ArrayList<Mostrable>();

		for (Mostrable elemento : listaAtracciones.descendingSet()) {

			boolean tipoDeAtraccionFavorita = usuario.getAtraccionFavorita() == elemento.getTipo();
			boolean puedePagarlo = usuario.getPresupuesto() >= elemento.getCosto();
			boolean tieneTiempo = usuario.getTiempoDisponible() >= elemento.getTiempoNecesario();
			boolean estaEnItinerario = usuario.getItinerario().getAtraccionesAceptadas().contains(elemento);

			if (tipoDeAtraccionFavorita && puedePagarlo && tieneTiempo && !estaEnItinerario) {
				sugerencias.add(elemento);
			}
		}

		for (Mostrable elemento : listaAtracciones.descendingSet()) {

			boolean puedePagarlo = usuario.getPresupuesto() >= elemento.getCosto();
			boolean tieneTiempo = usuario.getTiempoDisponible() >= elemento.getTiempoNecesario();
			boolean estaEnItinerario = usuario.getItinerario().getAtraccionesAceptadas().contains(elemento);
			boolean tipoDeAtraccionFavorita = usuario.getAtraccionFavorita() == elemento.getTipo();

			if (puedePagarlo && tieneTiempo && !tipoDeAtraccionFavorita && !estaEnItinerario) {
				sugerencias.add(elemento);
			}
		}

		return sugerencias;
	}

	public ArrayList<Mostrable> sugerirPromocion(Usuario usuario) throws IOException {

		TreeSet<Promocion> lista = leerPromociones();
		lista.descendingSet();
		ArrayList<Mostrable> sugerencias = new ArrayList<Mostrable>();

		for (Promocion promo : listaPromociones.descendingSet()) {

			boolean tipoDeAtraccionFavorita = usuario.getAtraccionFavorita() == promo.getTipo();
			boolean puedePagarlo = usuario.getPresupuesto() >= promo.getCosto();
			boolean tieneTiempo = usuario.getTiempoDisponible() >= promo.getTiempoNecesario();
			boolean tieneAtraccionYaComprada = usuario.getItinerario().getAtraccionesAceptadas().contains(
					promo.atraccion1) || usuario.getItinerario().getAtraccionesAceptadas().contains(promo.atraccion2)
					|| usuario.getItinerario().getAtraccionesAceptadas().contains(promo.atraccion3)
					|| usuario.getItinerario().getAtraccionesAceptadas().contains(promo.atraccion4);

			if (tipoDeAtraccionFavorita && puedePagarlo && tieneTiempo && !tieneAtraccionYaComprada) {
				sugerencias.add(promo);

			}
		}

		for (Promocion promo : listaPromociones.descendingSet()) {

			boolean puedePagarlo = usuario.getPresupuesto() >= promo.getCosto();
			boolean tieneTiempo = usuario.getTiempoDisponible() >= promo.getTiempoNecesario();
			boolean EstaEnSugerencias = sugerencias.contains(promo);
			boolean tieneAtraccionYaComprada = usuario.getItinerario().getAtraccionesAceptadas().contains(
					promo.atraccion1) || usuario.getItinerario().getAtraccionesAceptadas().contains(promo.atraccion2)
					|| usuario.getItinerario().getAtraccionesAceptadas().contains(promo.atraccion3)
					|| usuario.getItinerario().getAtraccionesAceptadas().contains(promo.atraccion4);

			if (puedePagarlo && tieneTiempo && !EstaEnSugerencias && !tieneAtraccionYaComprada) {
				sugerencias.add(promo);

			}
		}
		return sugerencias;
	}

	private void mostrarPreferencia(Usuario usuario) {

		ArrayList<Mostrable> listaDisponibles = new ArrayList<Mostrable>();

		listaDisponibles.addAll(listaPromociones.descendingSet());
		listaDisponibles.addAll(listaAtracciones.descendingSet());

		for (Mostrable objeto : listaDisponibles) {
			boolean tipoDeAtraccionFavorita = usuario.getAtraccionFavorita() == objeto.getTipo();
			boolean puedePagarlo = usuario.getPresupuesto() >= objeto.getCosto();
			boolean tieneTiempo = usuario.getTiempoDisponible() >= objeto.getTiempoNecesario();
			boolean yaFueComprada = objeto.estaEnItinerario(usuario.getItinerario());
			boolean hayCupo = objeto.getCupo() > 0;

			if (tipoDeAtraccionFavorita && puedePagarlo && tieneTiempo && !yaFueComprada && hayCupo) {
				System.out.println(objeto);
				System.out.println("Ingrese opción: 1) ACEPTA   2) SIGUIENTE   0) SALIR");
				int opcion = entrada.nextInt();
				if (opcion == 1) {
					objeto.aceptoMostrable(usuario);
					System.out.println("COMPRASTE " + objeto.getNombre());
				}
				if (opcion == 0) {
					break;
				}
			}
		}
	}

	private void mostrarSinPreferencia(Usuario usuario) {

		ArrayList<Mostrable> listaDisponibles = new ArrayList<Mostrable>();

		listaDisponibles.addAll(listaPromociones.descendingSet());
		listaDisponibles.addAll(listaAtracciones.descendingSet());

		for (Mostrable objeto : listaDisponibles) {
			boolean tipoDeAtraccionFavorita = usuario.getAtraccionFavorita() == objeto.getTipo();
			boolean puedePagarlo = usuario.getPresupuesto() >= objeto.getCosto();
			boolean tieneTiempo = usuario.getTiempoDisponible() >= objeto.getTiempoNecesario();
			boolean yaFueComprada = objeto.estaEnItinerario(usuario.getItinerario());
			boolean hayCupo = objeto.getCupo() > 0;

			if (!tipoDeAtraccionFavorita && puedePagarlo && tieneTiempo && !yaFueComprada && hayCupo) {
				System.out.println(objeto);
				System.out.println("Ingrese opción: 1) ACEPTA   2) SIGUIENTE   0) SALIR");
				int opcion = entrada.nextInt();
				if (opcion == 1) {
					objeto.aceptoMostrable(usuario);
					System.out.println("COMPRADA");
				}
				if (opcion == 0) {
					break;
				}
			}
		}
	}

	public void sugerirItinerario(Usuario usuario) {
		System.out.println(user.getNombre().toUpperCase() + ", TENEMOS ESTAS OFERTAS PARA VOS \n");
		this.mostrarPreferencia(usuario);

		if (usuario.getPresupuesto() > 0) {
			System.out.println("\n TAMBIEN TE PODRIA INTERESAR \n");
			this.mostrarSinPreferencia(usuario);
		}
		System.out.println("--------------------");
		System.out.println("\n Se terminaron las ofertas \n");
		System.out.println("--------------------");
		System.out.println("Su itinerario es el siguiente \n");
		System.out.println(usuario.getItinerario().toString().replace("[", "").replace("]", "\n").replace(",", ""));
	}

	private static void crearUsuarioNuevo() {
		UserDAO userDAO = DAOFactory.getUserDAO();

		String auxiliar[] = new String[4];
		try {
			System.out.println("Ingrese su nombre:");
			auxiliar[0] = entrada.next();
			while (auxiliar[0] == "") {
				System.err.println("Nombre de usuario inválido. Ingréselo nuevamente.");
				auxiliar[0] = entrada.next();
			}

			while (userDAO.findByUsername(auxiliar[0]) != null) {
				System.err.println("Usuario ya existente. Ingrese otro nombre.");
				auxiliar[0] = entrada.next();
			}

			System.out.println("\n Ingrese dinero disponible para gastar:");
			auxiliar[1] = entrada.next();
			while (Integer.valueOf(auxiliar[1]) <= 0) {
				System.err.println("El valor no es válido. Ingréselo nuevamente");
				auxiliar[1] = entrada.next();
			}

			System.out.println("\n Ingrese tiempo disponible (en horas):");
			auxiliar[2] = entrada.next();
			while (Integer.valueOf(auxiliar[2]) <= 0) {
				System.err.println("El valor no es válido. Ingréselo nuevamente");
				auxiliar[2] = entrada.next();
			}

			System.out.println("\n Ingrese tipo de atracción favorita:");
			System.out.println(Arrays.asList(TipoDeAtraccion.values()));
			auxiliar[3] = entrada.next();
			boolean existeTipo = false;
			while (!existeTipo) {
				for (TipoDeAtraccion tipo : TipoDeAtraccion.values()) {
					if (auxiliar[3].equalsIgnoreCase(tipo.name())) {
						existeTipo = true;
						break;
					}
				}
				if (!existeTipo) {
					System.err.println("El tipo de atracción no existe. Ingréselo nuevamente.");
					auxiliar[3] = entrada.next();
				}
			}

			String nombre = auxiliar[0];
			Integer dinero = Integer.parseInt(auxiliar[1]);
			Double tiempo = Double.parseDouble(auxiliar[2]);
			TipoDeAtraccion tipoDeAtraccion = TipoDeAtraccion.valueOf(auxiliar[3].toUpperCase());
			Usuario nuevoUsuario;

			nuevoUsuario = new Usuario(-1, nombre, dinero, tiempo, tipoDeAtraccion, false);

			userDAO.insert(nuevoUsuario);
			Sistema.user = nuevoUsuario;

		} catch (NumberFormatException e1) {
			System.err.println("El valor ingresado no es un número");
		}

	}

	public Usuario getUsuario() {
		return user;
	}

}