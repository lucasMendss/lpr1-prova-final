package org.provafinal;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Felipe Barretto
 * @author Lucas Rafael
 */
public class Data {

    private final Scanner scanner = new Scanner(System.in);
    private int dia;
    private int mes;
    private int ano;

    // metodo auxiliar para obter o número de dias em um determinado mês
    private int diasDoMes(int m, int a){
        return switch (m) {
            case 2 -> (this.ehBissexto(a)) ? 29 : 28; // caso fevereiro
            case 4, 6, 9, 11 -> 30; // caso mês com 30 dias
            default -> 31; // caso mês com 31 dias
        };
    }

    // metodo auxiliar para verificar se um ano é bissexto
    private boolean ehBissexto(int a){
        return (a % 400 == 0) || ((a % 4 == 0) && (a % 100 != 0));
    }

    // metodo auxiliar para verificar se uma data completa é válida
    private boolean ehDataValida(int d, int m, int a){
        if(m < 1 || m > 12 || a < 1) return false;
        return d >= 1 && d <= diasDoMes(m, a);
    }

    // lê um mês válido para o dia informado. valida que o mês escolhido realmente comporte o dia
    private int lerMesParaDia(int d){
        int m;
        while(true){
            m = this.lerEntrada("mês", 12);
            // usa ano fictício 1 para verificar o tamanho fixo do mês; fevereiro com 29
            // será tratado depois ao pedir o ano.
            int diasNoMes = diasDoMes(m, 1);
            if(diasNoMes >= d || (d == 29 && m == 2)){
                return m;
            }
            System.out.println("O mês selecionado não comporta o dia " + d + ". Tente outro mês.");
        }
    }

    private int lerEntrada(String texto, int valorLimite){
        int entrada;

        while(true){
            System.out.printf("Digite o nº do %s: %n", texto);

            try{
                entrada = scanner.nextInt();
                if(entrada >= 1 && entrada <= valorLimite){
                    return entrada;
                }
            }
            catch(InputMismatchException e){
                scanner.nextLine();
            }

            System.out.println("Valor inválido.");
        }
    }

    public Data(){
        dia = this.lerEntrada("dia", 31);

        // lê mês garantindo que o mês realmente comporte o dia informado
        mes = this.lerMesParaDia(dia);

        // lê ano. Se for 29/2, exige bissexto.
        int anoLimite = Integer.MAX_VALUE;
        while(true){
            ano = this.lerEntrada("ano", anoLimite);
            if(dia == 29 && mes == 2 && !ehBissexto(ano)){
                System.out.println("O ano deve ser bissexto para 29 de fevereiro. Digite novamente.");
                continue;
            }
            if(!ehDataValida(dia, mes, ano)){
                System.out.println("Combinação de dia/mês/ano inválida. Digite novamente.");
                continue;
            }
            break;
        }
    }

    public Data(int d, int m, int a) throws Exception{
        // valida a combinação completa antes de atribuir: permite verificar 29/2 com o ano
        if(!ehDataValida(d, m, a)){
            throw new Exception("Data inválida: " + d + "/" + m + "/" + a);
        }
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    public void setDia(){
        dia = this.lerEntrada("dia", 31);
    }

    public void setMes(){
        // lê um mês que comporte o dia já definido
        mes = this.lerMesParaDia(dia);
    }

    public void setAno(){
        // se for fevereiro 29, o ano deve ser bissexto
        int anoLimite = Integer.MAX_VALUE;
        boolean exigeBissexto = (dia == 29 && mes == 2);

        do{
            ano = this.lerEntrada("ano", anoLimite);
            if(exigeBissexto && !ehBissexto(ano)){
                System.out.println("O ano deve ser bissexto para 29 de fevereiro. Digite novamente.");
            }
        } while(exigeBissexto && !ehBissexto(ano));
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }

    public String mostra1(){
        return String.format("%02d/%02d/%02d", dia, mes, ano);
    }

    public String mostra2(){
        StringBuilder m = new StringBuilder();

        switch (mes) {
            case 1:
                m.append("janeiro");
                break;
            case 2:
                m.append("fevereiro");
                break;
            case 3:
                m.append("março");
                break;
            case 4:
                m.append("abril");
                break;
            case 5:
                m.append("maio");
                break;
            case 6:
                m.append("junho");
                break;
            case 7:
                m.append("julho");
                break;
            case 8:
                m.append("agosto");
                break;
            case 9:
                m.append("setembro");
                break;
            case 10:
                m.append("outubro");
                break;
            case 11:
                m.append("novembro");
                break;
            case 12:
                m.append("dezembro");
                break;
            default:
                m.append("mês inválido");
                break;
        }
        return String.format("%02d de %s, %d", dia, m, ano);
    }

    public boolean bissexto(){
        return ehBissexto(ano);
    }

    public int diasTranscorridos(){
        int diasTranscorridos = dia;
        int[] diasEmCadaMes = {31, this.ehBissexto(ano) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int ii = 0; ii < mes - 1; ii++){
            diasTranscorridos += diasEmCadaMes[ii];
        }
        return diasTranscorridos;
    }

    public void apresentaDataAtual(){
        Date dataAtual = new Date(ano - 1900, mes-1, dia);

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df.format(dataAtual));
    }
}
