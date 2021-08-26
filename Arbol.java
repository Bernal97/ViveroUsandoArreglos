package TrabajoPracticoObligatorio1;

public class Arbol {
    private String nombre;
    private int altura;
    private int profRaices;
    private boolean frutos;
    private int tempMinima;
    
    //constructores
    public Arbol (String nombreAr){
        nombre = nombreAr;
    }
    public Arbol(String nom, int alt, int pRaices, boolean fr, int tMin){
        nombre = nom;
        altura = alt;
        profRaices = pRaices;
        frutos = fr;
        tempMinima = tMin;
    }

    //Modificadores

    public void setAltura(int alt){
        altura = alt;
    }
    
    public void setProfR (int pRaices){
        profRaices = pRaices;
    }
    
    public void setFrutos (boolean fr){
        frutos = fr;
    }
    
    public void setTempMin(int tMin){
        tempMinima = tMin;
    }
    
    
    //Obvservadores
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getAltura(){
        return this.altura;
    }

    public int getProfR(){
        return this.profRaices;
    }

    public boolean getFrutos(){
        return this.frutos;
    }

    public int getTempMin(){
        return this.tempMinima;
    }
    
    
    public String toString(){
      return ("El " + nombre + " tiene una altura de " + altura + " metros"
              + " y una profundidad de " + profRaices + " metros" + ". Presenta algun fruto: "
              + frutos + " Tiene una temperatura minima de " + tempMinima + "C°");
   
    }
     
    public boolean equals (Arbol a){
        return nombre.equalsIgnoreCase(a.nombre) && altura == a.altura
                && frutos == a.frutos && tempMinima == a.tempMinima
                && profRaices == a.profRaices;
    }

}
