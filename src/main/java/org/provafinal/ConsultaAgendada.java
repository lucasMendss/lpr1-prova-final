package org.provafinal;

/**
 *
 * @author Felipe Barretto
 * @author Lucas Rafael
 */
public class ConsultaAgendada {

    private Data data;
    private Hora hora;
    private String nomePaciente;
    private static int quantidade;
    private String nomeMedico;

    public ConsultaAgendada(){

    }

    public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String nomePaciente, String nomeMedico){

    }

    public ConsultaAgendada(Data d, Hora h, String nomePaciente, String nomeMedico){

    }

    public void setData(int d, int m, int a){

    }

    public void setData() {

    }

    public void setHora(int s, int m, int h){

    }

    public void setHora() {

    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setNomePaciente() {

    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public void setNomeMedico() {

    }

    public int getAmostra(){
        return 0;
    }

    public String getData(){
        return null;
    }

    public String getHora(){
        return null;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }
}
