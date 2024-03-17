package com.mycompany.app;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
 
    @Test
    public void shouldbe100() throws Exception {
        Cliente c = new Cliente("123", "Victor", "PF");
        VeiculoImpl v = new CarroPequeno("123", "uno", 1.0);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m");
        Aluguel a = new Aluguel(c, v, LocalDateTime.parse("17/03/2024 15:00", formatter), "Av monteiro");
        
        a.setLocalEntrega("av monteiro");
        a.setDataEntrega(LocalDateTime.parse("18/03/2024 15:00", formatter));
        
        double preco = a.calcularPreco();
        
        assertEquals(100, preco, 0.1);
    }
    
    @Test
    public void shouldbe300() throws Exception {
        Cliente c = new Cliente("123", "Victor", "PF");
        VeiculoImpl v = new CarroMedio("123", "uno", 1.0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m");
        Aluguel a = new Aluguel(c, v, LocalDateTime.parse("17/03/2024 15:00", formatter), "Av monteiro");

        a.setLocalEntrega("av monteiro");
        a.setDataEntrega(LocalDateTime.parse("19/03/2024 14:00", formatter));

        double preco = a.calcularPreco();

        assertEquals(300, preco, 0.1);
    }
    
    @Test
    public void shouldbe400() throws Exception {
        Cliente c = new Cliente("123", "Victor", "PF");
        VeiculoImpl v = new SUV("123", "uno", 1.0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m");
        Aluguel a = new Aluguel(c, v, LocalDateTime.parse("17/03/2024 15:00", formatter), "Av monteiro");

        a.setLocalEntrega("av monteiro");
        a.setDataEntrega(LocalDateTime.parse("18/03/2024 15:45", formatter));

        double preco = a.calcularPreco();

        assertEquals(400, preco, 0.1);
    }
        
    @Test
    public void shouldbe570() throws Exception {
            Cliente c = new Cliente("123", "Victor", "PF");
            VeiculoImpl v = new CarroPequeno("123", "uno", 1.0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m");
            Aluguel a = new Aluguel(c, v, LocalDateTime.parse("17/03/2024 15:00", formatter), "Av monteiro");

            a.setLocalEntrega("av monteiro");
            a.setDataEntrega(LocalDateTime.parse("23/03/2024 15:00", formatter));

            double preco = a.calcularPreco();

            assertEquals(570, preco, 0.1);
    }
        
    @Test
    public void shouldbe540() throws Exception {
            Cliente c = new Cliente("123", "Victor", "PJ");
            VeiculoImpl v = new CarroPequeno("123", "uno", 1.0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:m");
            Aluguel a = new Aluguel(c, v, LocalDateTime.parse("17/03/2024 15:00", formatter), "Av monteiro");

            a.setLocalEntrega("av monteiro");
            a.setDataEntrega(LocalDateTime.parse("23/03/2024 15:00", formatter));

            double preco = a.calcularPreco();

            assertEquals(540, preco, 0.1);
    }    
}
