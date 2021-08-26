package TrabajoPracticoObligatorio1;
import utiles.TecladoIn;
public class testVivero {
    static void seleccionArbol(Arbol[] arboles, int z){
        //Este modulo muestra por pantalla una lista de los arboles agregados
        //Ademas permite seleccionar alguno que el usuario desee si quiere cambiarle valores
        int x;
        System.out.println("Seleccione un arbol si quiere cambiarle valores o ver sus detalles");
        do{
        for(int i = 1; i < z;i++){
            System.out.println(i + " " + arboles[i].getNombre());
        }
        System.out.println("0- Regresar");
        x = TecladoIn.readLineInt();
        operacionArbol(x, arboles);
    }while(x != 0);
        }
    static void operacionArbol(int x, Arbol[] arboles){
        //En base a un arbol seleccionado en el modulo anterior, permite
        //cambiarle las caracteristicas del mismo
        int menu;
        if (x != 0){
        do{
        System.out.println("1- Cambiar altura");
        System.out.println("2- Cambiar profundidad de las raices");
        System.out.println("3- Cambiar fruto");
        System.out.println("4- Cambiar temperatura minima");
        System.out.println("5- Mostrar detalles");
        System.out.println("0- Regresar");
        menu = TecladoIn.readLineInt();
        switch(menu){
            case 1: System.out.println("Ingrese la altura (en metros)");
                    int alt = TecladoIn.readLineInt();
                    arboles[x].setAltura(alt);break;
            case 2: System.out.println("Ingrese la profundidad (en metros)");
                    int prof = TecladoIn.readLineInt();
                    arboles[x].setProfR(prof);break;
            case 3: System.out.println("'true' si tiene, 'false' si no tiene");
                    boolean esFr;
                    boolean resp;
                    resp = TecladoIn.readLineBoolean(); 
                    if(resp == true){
                         esFr = true;
                         arboles[x].setFrutos(esFr);
                     }else{
                         esFr = false;
                         arboles[x].setFrutos(esFr);
                     }
                     break;
            case 4: System.out.println("Ingrese la temperatura minima");
                    int tempMin = TecladoIn.readLineInt();
                    arboles[x].setTempMin(tempMin);
            case 5: System.out.println(arboles[x].toString());break;
            default: break;
        }
    }while(menu != 0);
        }
        }
    static void arbolesAltos(Arbol [] arboles, int z){
        //Este modulo permite mostrar todos los arboles con una
        //altura mayor a 10 metros, recorriendo y obteniendo
        //las alturas de los arboles en el arreglo
        for(int i = 1; i < z; i++){
            int l = arboles[i].getAltura();
            if(l >= 10){
                System.out.println(arboles[i].getNombre());
            }
        }
    System.out.println();
    }
    static void arbolesFrios(Arbol[] arboles, int z){
        //Este modulo cuenta la cantidad de arboles dentro del arreglo
        //que soportan temperaturas inferiores a 0°
        int cont = 0;
        for (int i = 1; i < z;i++){
            int f = arboles[i].getTempMin();
            if(f < 0)
               cont++;
                }
        System.out.println("La cantidad de arboles que soportan temperaturas bajo cero son " + cont);
    }
    static void mostrarFrutales(Arbol[] arboles, int z){
        //Este modulo muestra todos los arboles del arreglo
        //que tengan "true" en si tienen frutos
        for(int i = 1; i < z; i++){
            boolean x = arboles[i].getFrutos();
            if(x == true){
                System.out.println(arboles[i].getNombre());
            }
        }
    System.out.println();
    }
    static int agregarArbol(Arbol[] arboles, int n){
       //Este modulo permite que el usuario añada arboles y muestra
       //por pantalla al final cuantos arboles puede añadir
       //(retorna el valor de arboles que hay en el sistema)
        int alt, prof, tempMin;
        boolean frut, tieneF;
        String respuesta = "", arb;
        do{
            int i = 1;
            System.out.println("Ingrese un arbol");
            arb = TecladoIn.readLine();
            while(i < n){
                String nomb = arboles[i].getNombre();
                if (nomb.equalsIgnoreCase(arb)){
                    System.out.println("Este arbol ya se encuentra en el sistema, ingrese otro");
                    arb = TecladoIn.readLine();
                    while(nomb.equalsIgnoreCase(arb)){
                        System.out.println("Ingrese un arbol distinto");
                        arb = TecladoIn.readLine();
                    }
                }
            i++;
            }
           arboles[n] = new Arbol(arb);
           System.out.println("Ingrese la altura");
            alt = TecladoIn.readLineInt();
            while(alt < 0){
                System.out.println("ingrese un valor POSITIVO");
                alt = TecladoIn.readLineInt();
            }
            arboles[n].setAltura(alt);
            System.out.println("Ingrese la profundidad de sus raices");
            prof = TecladoIn.readLineInt();
            while(prof < 0){
                System.out.println("Ingrese un valor POSITIVO");
                prof = TecladoIn.readLineInt();
            }
            arboles[n].setProfR(prof);
            System.out.println("Tiene algun fruto?('true' si tiene, 'false' si no tiene)");
            tieneF = TecladoIn.readLineBoolean();
            if(tieneF == true){
                frut = true;
                arboles[n].setFrutos(frut);
            }else{
                frut = false;
                arboles[n].setFrutos(frut);
            }
            System.out.println("Ingrese la temperatura minima en C°");
            tempMin = TecladoIn.readLineInt();
            arboles[n].setTempMin(tempMin);
            n++;
            System.out.println("Desea añadir otro arbol?");
            respuesta = TecladoIn.readLine();
        }while(respuesta.equalsIgnoreCase("si"));
    System.out.println("Todavia pueden ingresarse " + ((arboles.length-1) - (n - 2)));
    return n;
    }
    public static void main (String [] args){
        //La idea de este algoritmo es que un usuario pueda tener
        //un registro de arboles en el mismo
        int menu;
        boolean tieneF;
        int n = 1;
        int alt, prof,tempMin;
        boolean frut;
        Arbol[] arboles = new Arbol[100];
        String respuesta = "";
        do{
            int i = 1;
            System.out.println("Ingrese un arbol");
            String arb = TecladoIn.readLine();
            arboles[n] = new Arbol(arb);
            while(i < n){
                String nomb = arboles[i].getNombre();
                if(nomb.equals(arb)){
                    System.out.println("Este arbol ya se encuentra en el sistema, ingrese otro ");
                    int z = 1;
                    i = z;
                    arb = TecladoIn.readLine();
                    while(arb.equals(nomb)){
                        System.out.println("Ingrese un nombre distinto");
                        arb = TecladoIn.readLine();
                    }
                    arboles[n] = new Arbol(arb);
                }
            i++;
            }
            System.out.println("Ingrese la altura");
            alt = TecladoIn.readLineInt();
            while(alt < 0){
                System.out.println("ingrese un valor POSITIVO");
                alt = TecladoIn.readLineInt();
            }
            arboles[n].setAltura(alt);
            System.out.println("Ingrese la profundidad de sus raices");
            prof = TecladoIn.readLineInt();
            while(prof < 0){
                System.out.println("Ingrese un valor POSITIVO");
                prof = TecladoIn.readLineInt();
            }
            arboles[n].setProfR(prof);
            System.out.println("Tiene algun fruto?('true' si tiene, 'false' si no tiene)");
            tieneF = TecladoIn.readLineBoolean();
            if(tieneF == true){
                frut = true;
                arboles[n].setFrutos(frut);
            }else{
                frut = false;
                arboles[n].setFrutos(frut);
            }
            System.out.println("Ingrese la temperatura minima en C°");
            tempMin = TecladoIn.readLineInt();
            arboles[n].setTempMin(tempMin);
            n++;
            System.out.println("Desea añadir otro arbol?");
            respuesta = TecladoIn.readLine();
            
        }while(respuesta.equalsIgnoreCase("si"));
        int z = n;
        do{
       System.out.println("Ingrese una opcion");
       System.out.println("1- Añadir mas arboles");
       System.out.println("2- Lista de arboles");
       System.out.println("3- Mostrar los arboles con mas de 10 metros de altura");
       System.out.println("4- Total de arboles que soportan temperaturas inferiores a 0°");
       System.out.println("5- Mostrar arboles con frutos");
       System.out.println("0- Salir");
       menu = TecladoIn.readLineInt();
       switch(menu){
           case 1: z = agregarArbol(arboles, n); break;
           case 2: seleccionArbol(arboles, z); break;
           case 3: arbolesAltos(arboles, z); break;
           case 4: arbolesFrios(arboles, z); break;
           case 5: mostrarFrutales(arboles, z); break;
           default: break;
       }
    
    }while(menu != 0);
   
    }
}




