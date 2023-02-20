package modelo;

public class Combo implements Producto {
	private static String nombreCombo;
	private double descuento;
	private ProductoMenu item1;
	private ProductoMenu item2;
	private ProductoMenu item3;

	
	public Combo(String nombre, double descuento, ProductoMenu item11, ProductoMenu item22, ProductoMenu item33) {
		
		Combo.nombreCombo=nombre;
		this.descuento=descuento;
		this.item1=item11;
		this.item2=item22;
		this.item3=item33;
		
	}
	
	public int getPrecio() {
		double multiplicador = 1-descuento;
		int precioItem1=(int)(item1.getPrecio()*multiplicador);
		int precioItem2=(int)(item2.getPrecio()*multiplicador);
		int precioItem3=(int)(item3.getPrecio()*multiplicador);
		return precioItem1+precioItem2+precioItem3;
	}

	public String getNombre() {
		return nombreCombo;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
