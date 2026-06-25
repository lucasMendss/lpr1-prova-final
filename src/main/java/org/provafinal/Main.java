package org.provafinal;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.ByteArrayOutputStream;

/*
IFSP CBT 2026 - ADS 371 - LPR1 Java - Trabalho Prático 04
Professor Wellington Tuler Moraes

Dupla:
Aluno: Felipe Barretto
Aluno: Lucas Rafael
*/
public class Main{

    public static void main(String[] args) throws Exception {
        // Buffer para guardar cópia
        ByteArrayOutputStream copia = new ByteArrayOutputStream();
        PrintStream original = System.out;

        // Cria PrintStream que escreve em DOIS lugares
        System.setOut(new PrintStream(System.out) {
            public void write(byte[] buf, int off, int len) {
                original.write(buf, off, len);  // escreve no terminal
                copia.write(buf, off, len);     // escreve na cópia
            }
        });

        ConsultaAgendada p1 = new ConsultaAgendada(15, 30, 0, 20, 8, 2026, "João Paulo", "Maria Borges");
        p1.exibirInfoConsulta();

        ConsultaAgendada p2 = new ConsultaAgendada();
        p2.exibirInfoConsulta();

        p1.setData();
        p1.setHora();
        p1.setNomePaciente();
        p1.setNomeMedico();
        p1.exibirInfoConsulta();
        System.out.println("\nTotal de consultas agendadas: " + ConsultaAgendada.getQuantidade());

        // Salva cópia no arquivo
        Files.write(Paths.get("output.txt"), copia.toByteArray());
    }
}