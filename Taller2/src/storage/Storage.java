package storage;

import java.util.List;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Producto;
import modelo.ProductoMenu;

public class Storage {
	
	public static List<Ingrediente> ingredientes;
	public static List<Combo> combos;
	public static List<ProductoMenu> productosMenu;
	public static List<Producto> productos;
	public static List<Producto> pedido;
	
	public static List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public static List<Combo> getCombos() {
		return combos;
	}

	public static List<ProductoMenu> getProductosMenu() {
		return productosMenu;
	}

	public static List<Producto> getProductos() {
		return productos;
	}
	public static List<Producto> getPedido(){
		return pedido;
	}

	public static void setProductos(List<Producto> productos) {
		Storage.productos = productos;
	}

	public static void setIngredientes(List<Ingrediente> ingredientes) {
		Storage.ingredientes = ingredientes;
	}

	public static void setCombos(List<Combo> combos) {
		Storage.combos = combos;
	}

	public static void setProductosMenu(List<ProductoMenu> productosMenu) {
		Storage.productosMenu = productosMenu;
	}
	public static void setPedido(List<Producto> productosLista) {
		Storage.pedido=productosLista;
	}
}
