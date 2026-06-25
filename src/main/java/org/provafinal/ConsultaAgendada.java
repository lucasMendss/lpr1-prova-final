package org.provafinal;

import java.util.Scanner;

/**
 *
 * @author Felipe Barretto
 * @author Lucas Rafael
 */
public class ConsultaAgendada {

    private final Scanner scanner = new Scanner(System.in);
    private final String regexNome = "^[A-Za-zÀ-ÿ ]{3,}$";
    private Data data;
    private Hora hora;
    private String nomePaciente;
    private String nomeMedico;
    private static int quantidade;

    private String lerEValidarNome(String entidade){
        while(true) {
            StringBuilder nome = new StringBuilder();

            System.out.printf("Digite o nome do %s: ", entidade);
            nome.append(scanner.nextLine());

            if(nome.toString().matches(regexNome)) {
                return nome.toString().toUpperCase();
            }
            System.out.println("Nome inválido.");
        }
    }

    public ConsultaAgendada(){
        System.out.println("Agendando nova consulta ==========");
        data = new Data();
        hora = new Hora();
        nomePaciente = lerEValidarNome("paciente");
        nomeMedico = lerEValidarNome("médico");
        quantidade++;
    }

    public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String nomePaciente, String nomeMedico) throws Exception {
        data = new Data(d, m, a);
        hora = new Hora(h, mi, s);
        this.setNomePaciente(nomePaciente);
        this.setNomeMedico(nomeMedico);
        quantidade++;
    }

    public ConsultaAgendada(Data d, Hora h, String nomePaciente, String nomeMedico) throws Exception {
        data = d;
        hora = h;
        this.setNomePaciente(nomePaciente);
        this.setNomeMedico(nomeMedico);
        quantidade++;
    }

    public void setData(int d, int m, int a) throws Exception {
        data.setDia(d);
        data.setMes(m);
        data.setAno(a);
    }

    public void setData() {
        data.setDia();
        data.setMes();
        data.setAno();
    }

    public void setHora(int s, int m, int h) throws Exception {
        hora.setHor(h);
        hora.setMin(m);
        hora.setSeg(s);
    }

    public void setHora() {
        hora.setHor();
        hora.setMin();
        hora.setSeg();
    }

    public void setNomePaciente(String nomePaciente) throws Exception {
        if(!nomePaciente.matches(regexNome)){
            throw new Exception("Nome inválido.");
        }
        this.nomePaciente = nomePaciente.toUpperCase();
    }

    public void setNomePaciente() {
        nomePaciente = lerEValidarNome("paciente");
    }

    public void setNomeMedico(String nomeMedico) throws Exception {
        if(!nomeMedico.matches(regexNome)){
            throw new Exception("Nome inválido.");
        }
        this.nomeMedico = nomeMedico.toUpperCase();
    }

    public void setNomeMedico() {
        nomeMedico = lerEValidarNome("médico");
    }

    public static int getQuantidade(){
        return quantidade;
    }

    public String getData(){
        return data.mostra1();
    }

    public String getHora(){
        return hora.getHora1();
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void exibirInfoConsulta(){
        System.out.println("===== DADOS DA CONSULTA =====");
        System.out.println("Data: " + getData());
        System.out.println("Hora: " + getHora());
        System.out.println("Paciente: " + getNomePaciente());
        System.out.println("Medico: " + getNomeMedico());
        System.out.println("=============================");
    }
}
