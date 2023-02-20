package modelo;

public class ProductoMenu implements Producto {
	private String nombre;
	private int precioBase;
	
	public ProductoMenu(String elNombre, int elPrecioBase) {
		this.nombre=elNombre;
		this.precioBase=elPrecioBase;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return precioBase;
	}

	@Override
	public String generarTextoFactura() {
		return null;
	}

	
	
}
