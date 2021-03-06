import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class Fecha {
    
    private int dia;
    private int mes;
    private int año;

    private final int ENERO = 1;
    private final int FEBRERO = 2;
    private final int MARZO = 3;
    private final int ABRIL = 4;
    private final int MAYO = 5;
    private final int JUNIO = 6;
    private final int JULIO = 7;
    private final int AGOSTO = 8;
    private final int SEPTIEMBRE = 9;
    private final int OCTUBRE = 10;
    private final int NOVIEMBRE = 11;
    private final int DICIEMBRE = 12;

    Scanner teclado = new Scanner(System.in);

    public Fecha(){

        dia = 1;
        mes = 1;
        año = 1900;

    }

    public Fecha(int diaN, int mesN, int añoN){

        dia = diaN;
        mes = mesN;
        año = añoN;

        if(!valida()){
            if(!diaValido())
            {
                dia = 1;
            }
            if(!mesValido()){
                mes = 1;
            }
            if(!añoValido()){
                año = 1900;
            }
        }
    }

    public void leer(){

        System.out.println("Ingrese el día del año: ");
        setDia(teclado.nextInt());

        System.out.println("Ingrese el mes del año: ");
        setMes(teclado.nextInt());

        System.out.println("Inserte el año:");
        setAño(teclado.nextInt());

    }

    // cada año tiene 365 días, si es bisiesto tiene 366 días, tenemos que tomar en cuenta
    //que no todos los meses tiene dias iguales
    
    public int diasTranscurridos(){

        int añosTranscurridos, diasTranscurridos;

        diasTranscurridos = 0;

        añosTranscurridos = (getAño() - 1) - 1900;

        for(int i = 0; i <= añosTranscurridos; i++){

            if(isAñoBisiesto(i)){
                diasTranscurridos = diasTranscurridos + 366;
            }
            else diasTranscurridos = diasTranscurridos + 365;
        }

        for(int i = 0; i < (getMes()-1); i++){
            diasTranscurridos = diasTranscurridos + diasMes(i);
        }

        for(int i = 0; i < getDia(); i++){
            diasTranscurridos++;
        }

        return diasTranscurridos;
    }
    
    public boolean bisiesto(){
        
        boolean isBisiesto = getAño() % 4 == 0 ? true : false;

        return isBisiesto;
    } 

    public void larga(){
        String mesString;
        int mes;
        mes = getMes();

        switch(mes){
            case 1: mesString = "ENERO"; break;

            case 2: mesString = "FEBRERO"; break;

            case 3: mesString = "MARZO"; break;

            case 4: mesString = "ABRIL"; break;

            case 5: mesString = "MAYO"; break;

            case 6: mesString = "JUNIO"; break;

            case 7: mesString = "JULIO"; break;

            case 8: mesString = "AGOSTO"; break;

            case 9: mesString = "SEPTIEMBRE"; break;

            case 10: mesString = "OCTUBRE"; break;

            case 11: mesString = "NOVIEMBRE"; break;

            case 12: mesString = "DICIEMBRE"; break;

            default: mesString = "No valido"; break;
        }

        System.out.println(getDia() + " de " + mesString + " de " + getAño());
    }

    public boolean isAñoBisiesto(int año){

        return año % 4 == 0 ? true : false;

    }
    //Hola mundo

    public int diasMes(int mesDelAño){

        //Meses con 31 días Enero, marzo, mayo, julio, agosto, octubre y diciembre
        // Meses con 30 días Abril, junio, septiembre y noviembre
        if(mesDelAño == ENERO || mesDelAño == MARZO || mesDelAño == MAYO
            || mesDelAño == JULIO || mesDelAño == AGOSTO || mesDelAño == OCTUBRE || 
            mesDelAño == DICIEMBRE){
            return 31;
        }
        else if (mesDelAño == ABRIL || mesDelAño == JUNIO || mesDelAño == SEPTIEMBRE
        || mesDelAño == NOVIEMBRE){
            return 30;
        }
        else if(bisiesto()){
            return 29;
        }
        else return 28;
    }

    public boolean valida(){
        
        if(diaValido() && mesValido() && añoValido()){
            return true;
        }
        else{
            return false;
        }

    }

    public void corta(){
        System.out.println(getDia() + "-" +getMes() + "-" + getAño());
    }

    public boolean añoValido(){

        if(getAño() >= 1900 && getAño() <= 2050){
            return true;
        }
        else return false;

    }

    public boolean mesValido(){
        if(getMes() >= 1 && getMes() <= 12)
        {
            return true;
        } 
        else {
            return false;
        }
    }

    public boolean diaValido(){
        //Dia tiene que ser mayor o igual a 1 y menor o igual a 
        // la cantidad de Días que tiene el mes
        if(getDia() >= 1 && getDia() <= diasMes(getMes())){
            return true;
        }
        else return false;
    }

    /*
    Mutadores de los dias, meses y años
    */
    public void setDia(int diaNuevo){
        dia = diaNuevo;
    }

    public void setMes(int mesNuevo){
        mes = mesNuevo;
    }

    public void setAño(int añoNuevo){
        año = añoNuevo;
    }

    /*
    Accesores de los dias, meses y años
    */

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAño(){
        return año;
    }
}
