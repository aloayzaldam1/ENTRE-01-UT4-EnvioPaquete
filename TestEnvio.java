
/**
 *  
 * 
 * @author  - Asier Loayza
 * @version  
 */
public class TestEnvio
{
     

    /**
     * Metodo main()
     */
    public static void main(String[] args)  {
        Paquete paquete1 = new Paquete();
        Paquete paquete2 = new Paquete(40,60,40);
        Envio envio = new Envio();
        envio.addPaquete(paquete1);
        envio.addPaquete(paquete2);
        envio.print();
        System.out.println("-------------------------------------");
        Paquete paquete3 = new Paquete(new Dimension(50,50,70),13);
        envio.addPaquete(paquete3);
        envio.print();
        System.out.println("-------------------------------------");
        paquete2.obtenerCopia();
        envio.addPaquete(paquete2);
    }
}
