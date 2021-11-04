import java.util.Random;
/**
 *  Un objeto de esta clase guarda los datos de un
 *  paquete
 * 
 * @author - Asier Loayza
 *  
 */
public class Paquete 
{
    private Random generador;
    private Dimension dimension;
    private double peso;

    /**
     * Constructor 1 sin parámetros
     * Crea el paquete con 40 , 30, 50 de
     * alto, ancho, largo (en cm) y peso 8 Kg
     */
    public Paquete()    {
        dimension = new Dimension(40,30,50);
        peso = 8;

    }

    /**
     * Constructor 2 
     *  Crea el paquete con el alto, ancho, largo (en cm) indicados
     *  y peso un valor aleatorio entre 2 y 8 Kg inclusive
     *  Se crea aquí el generador
     */
    public Paquete(double alto, double ancho, double largo)    {
        dimension = new Dimension(alto, ancho, largo);
        generador = new Random();
        peso = generador.nextInt(7) + 2;
        

    }

    /**
     * Constructor 3 
     * Crea el paquete a la dimension y peso indicados
     * 
     */
    public Paquete(Dimension dimension, double peso)    {
        this.dimension = dimension;
        this.peso = peso;
        
    }

    /**
     * accesor para la dimensión
     */
    public Dimension getDimension() {
        return this.dimension;

    }

    /**
     * accesor para el peso
     */
    public double getPeso() {
        return this.peso;

    }

    /**
     * calcula y devuelve el volumen del paquete (en cm3)
     * El volumen = alto x ancho x largo
     */
    public double calcularVolumen() {
       
       return dimension.getAlto() * dimension.getAncho() * dimension.getLargo();

    }

    /**
     * calcula y devuelve el peso volumétrico del paquete (en Kg)
     * Peso volumétrico = volumen del paquete / 5000
     */
    public double calcularPesoVolumetrico() {
       return calcularVolumen() / 5000;

    }

    /**
     *  Devuelve el peso facturable de un paquete
     *  Siempre es el valor mayor entre su peso real y su peso volumétrico
     *      
     */
    public double calcularPesoFacturable() {
        double facturable = 0;
        if(peso > calcularPesoVolumetrico())
            facturable = peso;
        else    {
            peso = facturable;
        }
        
        return facturable;

    }


    /**
     * Devuelve una copia exacta al objeto actual
     * Se obtienen copias también de los objetos que contenga
     */
    public Paquete obtenerCopia() {
       
       return new Paquete(this.dimension, this.peso);

    }

    /**
     * Representación textual del paquete
     *  (leer enunciado)
     */
    public String toString() {
        int anchura = 20;
        
        String varPeso = String.format("\n%" + anchura + "s%10.2f(Kg)", "Peso Real: ", peso);
        String varVolumen = String.format("\n%" + anchura + "s%10.2f(cm3)", "Volumen: ", calcularVolumen());
        String varVolumetrico = String.format("\n%" + anchura + "s%10.2f(Kg)", "Peso volumétrico: ", calcularPesoVolumetrico());
        
        String formato = "\nDescripcion del paquete " + dimension.toString() + varPeso + varVolumen + varVolumetrico + "\n"; 
        return formato;

    }
    
    /**
     * Muestra en pantalla el objeto actual
     * Este método se incluye como método de prueba
     * de la clase Paquete
     */
    public void print() {
        System.out.println(this.toString());
    }
}
