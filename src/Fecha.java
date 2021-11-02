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

    public boolean bisiesto(){
        
        boolean isBisiesto = getAño() % 4 == 0 ? true : false;

        return isBisiesto;
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
