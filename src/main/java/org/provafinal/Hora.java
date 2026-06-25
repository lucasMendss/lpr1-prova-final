package org.provafinal;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Felipe Barretto
 * @author Lucas Rafael 
 */
public class Hora {
    private int hora;
    private int min; 
    private int seg;
    
    private final String regexHora = "^(2[0-3]|[01]?[0-9])$";
    private final String regexMinSeg = "^[0-5]?[0-9]";

    private int lerEntrada(String texto, String regex){
        Scanner scanner = new Scanner(System.in);
        boolean inputInvalido;
        int entrada = 0;

        do{
            inputInvalido = false;
            System.out.printf("Digite o valor %s: %n", texto);

            try{
                entrada = scanner.nextInt();
            }
            catch(InputMismatchException e){
                inputInvalido = true;
                scanner.nextLine();
            }

            if((!String.valueOf(entrada).matches(regex)) || inputInvalido){
                System.out.println("Valor inválido.");
            }
        } while ((!String.valueOf(entrada).matches(regex)) || inputInvalido);
        return entrada;
    }
    
    public Hora(){
        hora = lerEntrada("das horas", regexHora);
        min = lerEntrada("dos minutos", regexMinSeg);
        seg = lerEntrada("dos segundos", regexMinSeg);
    }
    
    public Hora(int h, int m, int s) throws Exception {
        this.setHor(h);
        this.setMin(m);
        this.setSeg(s);
    }
    
    public void setHor(int hora) throws Exception {
        if(hora < 0 || hora > 23) {
            throw new Exception("Valor de horas inválido.");
        }
        this.hora = hora;
    }

    public void setMin(int min) throws Exception {
        if(min < 0 || min > 59) {
            throw new Exception("Valor de minutos inválido.");
        }
        this.min = min;
    }
    
    public void setSeg(int seg) throws Exception {
        if(seg < 0 || seg > 59) {
            throw new Exception("Valor de segundos inválido.");
        }
        this.seg = seg;
    }
    
    public void setHor() {
        hora = lerEntrada("das horas", regexHora);
    }

    public void setMin() {
        min = lerEntrada("dos minutos", regexMinSeg);
    }
    
    public void setSeg() {
        seg = lerEntrada("dos segundos", regexMinSeg);
    }
    
    public int getHor() {
        return hora;
    }
    
    public int getMin() {
        return min;
    }

    public int getSeg() {
        return seg;
    }
    
    public String getHora1(){
        return String.format("%02d:%02d:%02d", hora, min, seg);               
    }
    
    public String getHora2()
    {
        int horaConvertida = 12;
        String sigla;

        if(hora == 12) {
            sigla = "PM";
        }
        else if(hora == 0){
            sigla = "AM";
        }
        else{
            sigla = (hora > 0 && hora < 12) ? "AM" : "PM";
            horaConvertida =  hora > 12 ? hora - 12 : hora;   
        }
        return String.format("Horário AM/PM: %02d:%02d:%02d (%s)", horaConvertida, min, seg, sigla);
    }
    
    public int getSegundos(){
        return (hora * 3600) + (min * 60) + seg;
    }
}
