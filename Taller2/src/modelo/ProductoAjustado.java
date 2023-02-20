package modelo;

public class ProductoAjustado implements Producto {
	
	private String nombre;
	private int precio;
	
	public ProductoAjustado(Producto menuBase, Ingrediente ingMod, String prefijo) {
		String nombreBase=menuBase.getNombre();
		int precioBase=menuBase.getPrecio();
		int precioIng=ingMod.darPrecio();
		String nombreIngrediente=ingMod.getNombre();
		if (prefijo.equals("con"))
			this.precio=precioBase+precioIng;
		else {
			this.precio=precioBase;
		}
		this.precio=precioBase;
		this.nombre=nombreBase+" "+prefijo+" "+nombreIngrediente;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public String generarTextoFactura() {
		return null;

	}
	
}
