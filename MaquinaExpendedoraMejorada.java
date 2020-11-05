public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    
    private int numeroBilletesVendidos;
    
    private int numeroBilletes;
    
    private  int ValorPremio = 0;
    
    

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, boolean maquinaConPremio,int numeroMaximoBilletes) {
        precioBillete = precioDelBillete;
        numeroBilletesVendidos = 0;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "leon";
        estacionDestino = "asturias";
        numeroBilletes = numeroMaximoBilletes;
        numeroBilletesVendidos = 0;
        if (maquinaConPremio == true) {
            ValorPremio = 1;
            System.out.println("Se ha creado una maquina con premio");
        }
        else {
            System.out.println("Se ha creado una maquina sin premio");
        }
        System.out.println("La maquina tiene un maximo de " + numeroMaximoBilletes + " billete/s");
        
    }
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }
    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
      int numeroMaximoBilletes = numeroBilletes;  
      if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
      }
       
        
      else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
      }
      if (numeroBilletesVendidos >= numeroMaximoBilletes){
            cantidadIntroducida = 0;
            System.out.println("La maquina ha vendido el maximo de billetes");
      }
      else{
      }
    }    
    public int getNumeroBilletesVendidos() {
        return numeroBilletesVendidos;
    }
    public void imprimeNumeroBilletesVendidos() {
        System.out.println("Se han imprimido " + (numeroBilletesVendidos) + " billetes");
    }
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        
       int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
       if (numeroBilletesVendidos >= numeroBilletes) {
           System.out.println("La maquina ha vendido todos sus billetes");
           
           }
       else if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         
    
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            numeroBilletesVendidos = numeroBilletesVendidos + 1;
            if (ValorPremio == 1){
                System.out.println("tiene un descuento de 3 € para compras en el comercio que elijas");
            }
       }
       
        
        
              
    }
    public int vaciarDineroDeLaMaquina() {
        int valorADevolver = 0;
        if (balanceClienteActual == 0) {
            valorADevolver = totalDineroAcumulado;
            int totalDineroAcumulado = 0;
        }
        if (balanceClienteActual > 0){
            valorADevolver = -1;
            System.out.println("Hay un usuario activo");
        }
        return valorADevolver;
    }
      /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver= balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
