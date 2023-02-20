package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import storage.Storage;

public class Pedido {
	
	private static int numeroPedidos;
	private static int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	public static List<Producto> itemsPedido;
	
	public Pedido(String nombreCliente, String direccionCliente, List<Producto> items) {
		this.nombreCliente=nombreCliente;
		this.direccionCliente=direccionCliente;
		this.itemsPedido = items;
	}
	public static void updateId() {
		idPedido++;
	}
	public static void updateNumeroPedidos() {
		numeroPedidos++;
	}
	public static List<Producto> darListaPedido(){
		return itemsPedido;
	}
	public static int getIdPedido() {
		return idPedido;
	}
	public void setId(int elId) {
		idPedido=elId;
	}
	public static void agregarProducto(Producto nuevoItem) {
		itemsPedido.add(nuevoItem);
		Storage.pedido.add(nuevoItem);
	}
	
	private static int getPrecioNetoPedido() {
		int precioTotal=0;
		List<Producto> producs = Storage.getPedido();
		for (Producto produc:producs) {
			int precio = produc.getPrecio();
			precioTotal+=precio;
		}
		int precioNeto = (int) (precioTotal*0.81);
		return precioNeto;
	}
	
	private static int getPrecioTotalPedido() {
		int precioTotal=0;
		List<Producto> producs = Storage.getPedido();
		for (Producto produc:producs) {
			int precio = produc.getPrecio();
			precioTotal+=precio;
		}
		return precioTotal;
	}
	
	private static int getIVAPedido() {
		int precioTotal=0;
		List<Producto> producs = Storage.getPedido();
		for (Producto produc:producs) {
			int precio = produc.getPrecio();
			precioTotal+=precio;
		}
		int precioIVA= (int) (precioTotal*0.19);
		return precioIVA;
	}
	
	private static String generarTextoFactura() {
		String texto = "";
		int id = getIdPedido();
		texto=texto+"FACTURA ID PEDIDO: "+id+"\n";
		List<Producto> producs = Storage.getPedido();
		for (Producto produc:producs) {
			int precio = produc.getPrecio();
			String nombre = produc.getNombre();
			texto=texto+nombre.toUpperCase()+"---------------- "+precio+"\n";
		}
		int IVA = getIVAPedido();
		int precioTotal = getPrecioTotalPedido();
		int precioNeto = getPrecioNetoPedido();
		texto=texto+"IVA: "+IVA+"\n"+"PRECIO NETO: "+precioNeto+"\n"+"PRECIO TOTAL: "+precioTotal+"\n";
		return texto;
	}
	public static void guardarFactura() throws IOException {
		FileWriter archivo1 = null;
		PrintWriter escritor = null;
		
		try {
			archivo1 = new FileWriter("data/factura"+getIdPedido()+".txt");
			escritor = new PrintWriter(archivo1);
			escritor.println(generarTextoFactura());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		archivo1.close();
	}
}
