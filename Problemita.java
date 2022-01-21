import java.util.ArrayList;
import java.util.Scanner;

abstract class FiguraInicial2D{
	double NumerodeLados;
	String nombre;
	abstract String nombre();
}
class Triangulo extends FiguraInicial2D{
	double altura;
	double base;
	String CalcularArea() {
		String text = "";
		double area = 0;
		area = (base*altura)/2;
		text +="El area es: "+area+" \n";
		return text;
	}
	double CalcularAreaValor() {
		double area = 0;
		area = (base*altura)/2;
		return area;
	}
	String CalcularPrecio(double precio) {
		String text = "";
		double preciofinal = 0;
		double area = (base*altura)/2;
		preciofinal = (int) area*precio;
		text += "El precio final que debera pagar por el terreno sera de "+preciofinal+" \n";
		return text; 
	}
	String ObtenerDatosFigura() {
		String text = "";
		text += "Los datos de tu triangulo son los siguientes: "+" \n";
		text+= "Su dimension de altura es: "+ altura+" \n";
		text+= "Su dimension de la base es: "+ base+" \n";
		return text;
	}
	String nombre() {
		String nombreFigura = "";
		nombre = "Triangulo";
		nombreFigura = nombre;
		return nombreFigura;
	}
}
class cuadrado extends FiguraInicial2D{
	double ladoCuadrado;
	String CalcularArea() {
		String text = "";
		double area = 0;
		area = ladoCuadrado*ladoCuadrado;
		text +="El area es: "+area+" \n";
		return text;
	}
	double CalcularAreaValor() {
		double area = 0;
		area = ladoCuadrado*ladoCuadrado;
		return area;
	}
	String CalcularPrecio(double precio) {
		String text = "";
		double preciofinal = 0;
		double area = ladoCuadrado*ladoCuadrado;
		preciofinal = (int) area*precio;
		text += "El precio final que debera pagar por el terreno sera de "+preciofinal+ " Dolares "+" \n";
		return text; 
	}
	String ObtenerDatosFigura() {
		String text = "";
		text += "Los datos de tu triangulo son los siguientes: "+" \n";
		text+= "Su dimension del lado es: "+ ladoCuadrado+" \n";
		return text;
	}
	String nombre() {
		String nombreFigura = "";
		nombre = "cuadrado";
		nombreFigura = nombre;
		return nombreFigura;
	}
	
}
class circulo extends FiguraInicial2D{
	double pi = 3.14;
	double radio;
	String CalcularArea() {
		String text = "";
		double area = 0;
		area = pi*(radio*radio);
		text +="El area es: "+area+" \n";
		return text;
	}
	double CalcularAreaValor() {
		double area = 0;
		area = pi*(radio*radio);
		return area;
	}
	String CalcularPrecio(double precio) {
		String text = "";
		double preciofinal = 0;
		double area = pi*(radio*radio);
		preciofinal = (int) area*precio;
		text += "El precio final que debera pagar por el terreno sera de "+preciofinal+" \n";
		return text; 
	}
	String ObtenerDatosFigura() {
		String text = "";
		text += "Los datos de tu triangulo son los siguientes: "+" \n";
		text+= "Su dimension del radio es: "+ radio+" \n";
		text+= "Su dimension del diametro es: "+radio*2+" \n";
		return text;
	}
	String nombre() {
		String nombreFigura = "";
		nombre = "Circulo";
		nombreFigura = nombre;
		return nombreFigura;
	}
}

public class Problemita {

	public static void main(String[] args) {
		System.out.println("Compra de terrenos");
		Scanner leer = new Scanner(System.in);
		ArrayList<FiguraInicial2D> ListaFiguras = new ArrayList<FiguraInicial2D>();
		double precioTriangulo = 5.5;
		double precioCuadrado = 7.5;
		double precioCirculo = 6.5;//precio por metro figura 1 
		menu();
		System.out.println("Ingrese el numero que corresponde a la figura del terreno: ");
		int dato = leer.nextInt();
		while(dato !=3) {
			if(dato==0) {
				System.out.println("Ingrese la altura del terreno triangular: ");
				double alt = leer.nextDouble();
				System.out.println("Ingrese la base del terreno triangular: ");
				double base= leer.nextDouble();
				Triangulo t = new Triangulo();
				t.altura = alt;
				t.base = base;
				t.nombre();
				t.NumerodeLados=3;
				ListaFiguras.add(t);
			}else if(dato==1) {
				System.out.println("Ingrese el lado del terreno cuadrado: ");
				double lado = leer.nextDouble();
				cuadrado c = new cuadrado();
				c.ladoCuadrado=lado;
				c.nombre();
				c.NumerodeLados=4;
				ListaFiguras.add(c);
			}else if(dato==2) {
				System.out.println("Ingrese el radio del terreno circular: ");
				double radio = leer.nextDouble();
				circulo cr = new circulo();
				cr.radio = radio;
				cr.NumerodeLados=0;
				cr.nombre();
				ListaFiguras.add(cr);
			}
			menu();
			System.out.println("Ingrese el numero que corresponde a la figura del terreno: ");
			dato = leer.nextInt();
		}
		for(int i = 0;i<ListaFiguras.size();i++) {
			FiguraInicial2D fi = ListaFiguras.get(i);
			if(fi instanceof Triangulo) {
				Triangulo t = (Triangulo) fi;
				System.out.println("Para el terrero de la figura geometrica "+t.nombre);
				System.out.println(t.CalcularPrecio(precioTriangulo));
				System.out.println(t.ObtenerDatosFigura());
			}else if(fi instanceof cuadrado) {
				cuadrado c = (cuadrado) fi;
				System.out.println("Para el terrero de la figura geometrica "+c.nombre);
				System.out.println(c.CalcularPrecio(precioCuadrado));
				System.out.println(c.ObtenerDatosFigura());
			}else if(fi instanceof circulo) {
				circulo cr = (circulo) fi;
				System.out.println("Para el terrero de la figura geometrica "+cr.nombre);
				System.out.println(cr.CalcularPrecio(precioCirculo));
				System.out.println(cr.ObtenerDatosFigura());
			}
		}
	}
	public static void menu() {
		System.out.println("De que forma le gustaria que fuera su terreno");
		System.out.println("Triangulo[0]");
		System.out.println("Cuadrado[1]");
		System.out.println("Ciruculo[2]");
		System.out.println("Salir[3]");
	}
}
