
/**
 *  Representa una dimensión
 *  
 *  @author - Asier Loayza
 */
public class Dimension  
{
    private double alto;
    private double ancho;
    private double largo;

    /**
     * constructor  
     */
    public Dimension(double alto, double ancho, double largo)    {
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;

    }   

    /**
     * accesor para  el alto
     */
    public double getAlto()    {
        return alto;
    }

    /**
     * accesor para  el ancho
     */
    public double getAncho()    {
        return ancho;
    }

    /**
     * accesor para  el largo
     */
    public double getLargo()    {
        return largo;
    }

    /**
     * Devuelve una copia exacta al objeto actual
     */
    public Dimension obtenerCopia() {
        return new Dimension(this.alto, this.ancho, this.largo);

    }

    /**
     * Repesentación textual de la dimensión
     * (leer enunciado)
     */
    public String toString() {
        int anchura = 20;
        String varAlto = String.format("\n%" + anchura + "s%10.2f", "Alto: ", alto);
        String varAncho = String.format("\n%" + anchura + "s%10.2f", "Ancho: ", ancho);        
        String varLargo = String.format("\n%" + anchura + "s%10.2f", "Largo: ", largo); 
        
        String formato = varAlto + varAncho + varLargo;
        
        return formato;
    }

    /**
     * Muestra en pantalla el objeto actual
     * Este método se incluye como método de prueba
     * de la clase Dimension
     */
    public void print() {
        System.out.println(this.toString());
    }

    
}
