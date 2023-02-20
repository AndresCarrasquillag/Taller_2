package consola;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Pedido;
import modelo.Producto;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;
import modelo.Restaurante;
import storage.Storage;

public class Aplicacion {
	public static void main(String[] args) throws IOException {
		
		try {
			Restaurante restaurante = new Restaurante();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ejecutarAplicacion();
		
	}
	
	
	public static void mostrarMenu() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Iniciar Nuevo Pedido");
		System.out.println("2. Agregar elemento al pedido");
		System.out.println("3. Cerrar pedido y guardar factura");
		System.out.println("4. Consultar información de un pedido por ID");
	}
	
	public static void ejecutarAplicacion() throws IOException {
		ejecutarMostrarMenu();
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1) { 
					ejecutarIniciarPedido();
					ejecutarAgregarAlPedido();
				}
				else if (opcion_seleccionada == 2)
				{
					ejecutarAgregarAlPedido();
				}
				else if (opcion_seleccionada == 3)
				{
					ejecutarCerrarYGuardar();
					System.out.println("Pedido guardado y factura generada con éxito");
				}
				else if (opcion_seleccionada == 14)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	public static void ejecutarAgregarAlPedido() {
		String pre = null;
		Ingrediente ingElegido=null;
		Producto productoElegido=null;
		String nombre = null;
		List<Producto> productos = Storage.productos;
		List<Ingrediente> ingredientes = Storage.getIngredientes();
		int agregar = 0;
		int numPedido=Integer.parseInt(input("Por favor escriba número del elemento que quiere agregar"));
		if (numPedido == 1)
			 nombre = "corral";
		else if (numPedido == 2)
		{
			nombre = "corral queso";
		}
		else if (numPedido == 3)
		{
			nombre = "corral pollo";
		}
		else if (numPedido == 4)
		{
			nombre = "corralita";
		}
		else if (numPedido == 5)
		{
			nombre = "todoterreno";
		}
		else if (numPedido == 6)
		{
			nombre = "1/2 libra";
		}
		else if (numPedido == 7)
		{
			nombre = "especial";
		}
		else if (numPedido == 8)
		{
			nombre = "casera";
		}
		else if (numPedido == 9)
		{
			nombre = "mexicana";
		}
		else if (numPedido == 10)
		{
			nombre = "criolla";
		}
		else if (numPedido == 11)
		{
			nombre = "costeña";
		}
		else if (numPedido == 12)
		{
			nombre = "hawaiana";
		}
		else if (numPedido == 13)
		{
			nombre = "wrap de pollo";
		}
		else if (numPedido == 14)
		{
			nombre = "wrap de lomo";
		}
		else if (numPedido == 15)
		{
			nombre = "ensalada mexicana";
		}
		else if (numPedido == 16)
		{
			nombre = "papas medianas";
		}
		else if (numPedido == 17)
		{
			nombre = "papas grandes";
		}
		else if (numPedido == 18)
		{
			nombre = "papas en casco medianas";
		}
		else if (numPedido == 19)
		{
			nombre = "papas en casco grandes";
		}
		else if (numPedido == 20)
		{
			nombre = "agua cristal sin gas";
		}
		else if (numPedido == 21)
		{
			nombre = "agua cristar con gas";
		}
		else if (numPedido == 22)
		{
			nombre = "gaseosa";
		}
		else if (numPedido == 23)
		{
			nombre = "corral";
		}
		else if (numPedido == 24)
		{
			nombre = "combo corral";
		}
		else if (numPedido == 25)
		{
			nombre = "combo corral queso";
		}
		else if (numPedido == 26)
		{
			nombre = "combo todoterreno";
		}
		for (Producto prod:productos) {
			String nombreProdu=prod.getNombre();
			if (nombre.equals(nombreProdu)&&nombre!=null) {
				agregar = Integer.parseInt(input("¿Quiere agregar o retirar un ingrediente específico?\n"
						+ "1 para si, 0 para no"));
				productoElegido = prod;
				}
			}
		if (agregar==1) 
		{
			int contar=1;
			for (Ingrediente ing:ingredientes) {
				String nombreing = ing.getNombre();
				System.out.println(contar+". "+nombreing);
				contar++;
			}
			int num=Integer.parseInt(input("Inserte número de ingrediente a quitar/agregar"));
			if (num == 1)
				 nombre = "lechuga";
			else if (num == 2)
			{
				nombre = "tomate";
			}
			else if (num == 3)
			{
				nombre = "cebolla";
			}
			else if (num == 4)
			{
				nombre = "queso mozzarella";
			}
			else if (num == 5)
			{
				nombre = "huevo";
			}
			else if (num == 6)
			{
				nombre = "queso americano";
			}
			else if (num == 7)
			{
				nombre = "tocineta express";
			}
			else if (num == 8)
			{
				nombre = "papa callejera";
			}
			else if (num == 9)
			{
				nombre = "pepinillos";
			}
			else if (num == 10)
			{
				nombre = "cebolla grille";
			}
			else if (num == 11)
			{
				nombre = "suero costeño";
			}
			else if (num == 12)
			{
				nombre = "frijol refrito";
			}
			else if (num == 13)
			{
				nombre = "queso fundido";
			}
			else if (num == 14)
			{
				nombre = "tocineta picada";
			}
			else if (num == 15)
			{
				nombre = "piña";
			}
			for (Ingrediente ingre:ingredientes) {
				String nombreIng=ingre.getNombre();
				if (nombre.equals(nombreIng)) {
					ingElegido = ingre;
				}	
			}
			int a = Integer.parseInt(input("Lo quiere agregar o quitar?\n"
					+ "1 agregar, 0 para quitar"));
			if (a==1)
				pre = "con";
			else if (a==0) {
				pre = "sin";
			}
			ProductoAjustado prodMod = new ProductoAjustado(productoElegido, ingElegido, pre);
			Storage.pedido.add(prodMod);
			
		}
		else {
			Storage.pedido.add(productoElegido);
		}
		System.out.println("Producto agregado correctamente");
		}

	
	public static void ejecutarCerrarYGuardar() throws IOException {
		Pedido.guardarFactura();
		
	}
	public static void ejecutarIniciarPedido() {
		System.out.println("Iniciando Pedido... ");
		String nombreCliente = input("Por favor ingrese su nombre");
		String direccionCliente = input("Por favor ingrese su direccion");
		Restaurante.iniciarPedido(nombreCliente, direccionCliente);
	}
	public static void ejecutarMostrarMenu() {
		int contador=1;
		System.out.println("Aquí está el menú de productos: ");
		List<ProductoMenu> productos = Storage.getProductosMenu();
		List<Combo> combos = Storage.getCombos();
		for (ProductoMenu producto: productos) {
			String prod = producto.getNombre();
			int precio = producto.getPrecio();
			System.out.println(contador+". "+prod.toUpperCase()+" ----> PRECIO: "+precio);
			contador++;
			}
		for (Combo combo: combos) {
			String nombre = combo.getNombre();
			int precio = combo.getPrecio();
			System.out.println(contador+". "+nombre.toUpperCase()+" ----> PRECIO: "+precio);
			contador++;
		}
		
	}
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}
