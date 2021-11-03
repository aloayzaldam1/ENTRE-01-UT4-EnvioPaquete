
/**
 *  Un objeto de esta clase representa un envío de varios paquetes,
 *  máximo tres
 *  
 * 
 * @author - Asier Loayza  
 *  
 */
public class Envio
{
    private final double PRECIO_KILO = 2.2;  // precio coste envío Kg. en euros
    private Paquete paquete1;
    private Paquete paquete2;
    private Paquete paquete3;

    /**
     * Constructor  
     * Inicializa los paquetes a null (inicialmente
     * el envío no tiene paquetes)
     */
    public Envio()    {
        this.paquete1 = null;
        this.paquete2 = null;
        this.paquete3 = null;

    }

    /**
     * accesor para el paquete1
     */
    public Paquete getPaquete1() {
        return paquete1;

    }

    /**
     * accesor para el paquete2
     */
    public Paquete getPaquete2() {
        return paquete2;

    }

    /**
     * accesor para el paquete3
     */
    public Paquete getPaquete3() {
        return paquete3;

    }

    /**
     * Devuelve el nº de paquetes en el envío
     * (dependerá de cuántos paquetes estén a null)
     */
    public int getNumeroPaquetes() {
        int paquetes = 0;
        if (paquete1 != null)   {
            paquetes++;
        }
        if (paquete2 != null)   {
            paquetes++;
        }
        if (paquete3 != null)   {
            paquetes++;
        }
        
        return paquetes;
    }

    /**
     * Devuelve true si el envío está completo, false en otro caso
     * (tiene exactamente 3 paquetes)
     */
    public boolean envioCompleto() {
        return getNumeroPaquetes()==3;

    }

    /**
     * Se añade un nuevo paquete al envío
     * Si el envío está completo se muestra
     * el mensaje "No se admiten más paquetes en el envío"
     * Si no está completo se añade el paquete al envío teniendo en cuenta
     * si se añade como primero, segundo o tercero (no han de quedar huecos)
     */
    public void addPaquete(Paquete paquete) {
        
        if(envioCompleto() == true)  {
            System.out.println("No se admiten mas paquetes en el envio");
        }
        
        else if(getNumeroPaquetes() == 2)  {
            this.paquete3 = paquete;
        }
        
        else if(getNumeroPaquetes() == 1)  {
            this.paquete2 = paquete;
        }
        
        else if(getNumeroPaquetes() == 0)  {
            this.paquete1 = paquete;
        }
    }
    /**
     * Calcula y devuelve el coste total del envío
     * 
     * Para calcular el coste:
     *      - se obtiene el peso facturable de cada paquete 
     *      - se suman los pesos facturables de todos los paquetes del envío
     *      - se calcula el coste en euros según el precio del Kg 
     *      (cada Kg. no completo se cobra entero, 5.8 Kg. se cobran como 6, 5.3 Kg. se cobran como 6)
     *     
     *  
     */
    public double calcularCosteTotalEnvio() {
        double pFacturable = 0;
        double coste = 0;
        if(getNumeroPaquetes() == 1)    {
            pFacturable = paquete1.calcularPesoFacturable();
        }
        
        else if (getNumeroPaquetes() == 2)  {
            pFacturable = paquete1.calcularPesoFacturable() + paquete2.calcularPesoFacturable();
        }
        
        else if (getNumeroPaquetes() == 3)  {
            pFacturable = paquete1.calcularPesoFacturable() + paquete2.calcularPesoFacturable() + paquete3.calcularPesoFacturable();
        }
        coste = Math.ceil(pFacturable) * PRECIO_KILO;
        return coste;

    }

    /**
     * Representación textual del envío
     * con el formato exacto indicado
     * (leer enunciado)
     */
    public String toString() {
        int anchura = 20;
        String varPaquete1 = "";
        String varPaquete2 = "";
        String varPaquete3 = "";
        String formato = "";
        
        String coste = String.format("\n\n%" + anchura + "s%10.2f€", "Coste total envio: ", calcularCosteTotalEnvio());
        
        if(getNumeroPaquetes() == 1)    {
            varPaquete1 = paquete1.toString();
            formato = "Nº de paquetes: " + getNumeroPaquetes() + varPaquete1 + coste; 
        }
        
        else if (getNumeroPaquetes() == 2)  {
            varPaquete1 = paquete1.toString();
            varPaquete2 = paquete2.toString();
            formato = "Nº de paquetes: " + getNumeroPaquetes() + varPaquete1 + varPaquete2 + coste;  
        }
        
        else if (getNumeroPaquetes() == 3)  {
            varPaquete1 = paquete1.toString();
            varPaquete2 = paquete2.toString();
            varPaquete3 = paquete3.toString();
            formato = "Nº de paquetes: " + getNumeroPaquetes() + varPaquete1 + varPaquete2 + varPaquete3 + coste;  
        }
        
        return formato;
    }

    /**
     * Muestra en pantalla el objeto actual
     * Este método se incluye como método de prueba
     * de la clase Envio
     */
    public void print() {
        System.out.println(this.toString());
    }

}
