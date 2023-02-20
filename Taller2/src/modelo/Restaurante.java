package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import storage.Storage;

public class Restaurante {
	public Restaurante() throws IOException {
		
		String archivoIngredientes ="data/ingredientes.txt";
		String archivoCombos ="data/combos.txt";
		String archivoMenu ="data/menu.txt";
		cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
	}
	
	public static void iniciarPedido(String nombre, String direccionCliente) {
		Pedido.updateId();
		Pedido.updateNumeroPedidos();
		List<Producto> produs = new ArrayList<>();
		Pedido nuevoPedido = new Pedido(nombre, direccionCliente, produs);
	}
	
	public void cerrarYGuardarPedido() {
		
	}
	
	//public Pedido getPedidoEnCurso() {
		//return Pedido nuevoPedido;
	//} 
	public List<Ingrediente> getIngredientes(){
		List<Ingrediente> ingredientes = Storage.getIngredientes();
		return ingredientes;
	}
	public void cargarInformacionRestaurante(String archivoIngredientes, String archivoMenu, String archivoCombos) throws IOException {
		Storage informacion = new Storage();
		List<Producto> pedido = new ArrayList<>();
		Storage.setPedido(pedido);
		List<Producto> prods = new ArrayList<>();
		Storage.setProductos(prods);
		List<Ingrediente> ingre = cargarIngredientes(archivoIngredientes);
		Storage.setIngredientes(ingre);
		List<ProductoMenu> prodMenu = cargarMenu(archivoMenu);
		Storage.setProductosMenu(prodMenu);
		List<Combo> combos = cargarCombos(archivoCombos);
		Storage.setCombos(combos);
	}
	private List<Ingrediente> cargarIngredientes(String archivoIngredientes) throws IOException {
		List<Ingrediente> ingredientes= new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = br.readLine();
		while (linea!=null) {
			String[] partes = linea.split(";");
			String nombreIng = partes[0];
			int precio = Integer.parseInt(partes[1]);
			Ingrediente elIngrediente= new Ingrediente(nombreIng, precio);
			linea=br.readLine();
			ingredientes.add(elIngrediente);
		}
		br.close();
		return ingredientes;
		
	}
	
	private List<ProductoMenu> cargarMenu(String archivoMenu) throws IOException {
		List<ProductoMenu> prodMenu= new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea = br.readLine();
		while (linea!=null) {
			String[] partes = linea.split(";");
			String nombreProd = partes[0];
			int precio = Integer.parseInt(partes[1]);
			ProductoMenu elProducto= new ProductoMenu(nombreProd, precio);
			linea=br.readLine();
			prodMenu.add(elProducto);
			Storage.productos.add(elProducto);
		}
		br.close();
		return prodMenu;
		
	}
	private List<Combo> cargarCombos(String archivoCombos) throws IOException {
		List<Combo> combos= new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea = br.readLine();
		ProductoMenu item1=null;
		ProductoMenu item2=null;
		ProductoMenu item3=null;
		while (linea!=null) {
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			double descuento = Double.parseDouble(partes[1].replace("%",""));
			descuento = descuento/100;
			List<ProductoMenu> produs = Storage.getProductosMenu();
			for (ProductoMenu prod:produs) {
				String nombre = prod.getNombre();
				if (nombre.equals(partes[2]))
					item1=prod;
				else if (nombre.equals(partes[3])) 
				{
					item2=prod;
				}
				else if (nombre.equals(partes[4])) 
				{
					item3=prod;
				}
			}
			Combo elCombo= new Combo(nombreCombo, descuento, item1, item2, item3);
			linea=br.readLine();
			combos.add(elCombo);
			Storage.productos.add(elCombo);
		}
		br.close();
		return combos;
		
	}
	
}
