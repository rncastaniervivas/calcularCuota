package edu.educacionit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        CalculadorCuota calculadorCuota = null;
        
        String tipoAmortizacion = System.getProperty("tipoAmortizacion");        
        RuntimeException error = new RuntimeException("No se encuentra tipo amortizacion");
        
        if (tipoAmortizacion==null) { throw error; }
        
        if (tipoAmortizacion.equals("americano")) {
            calculadorCuota = appContext.getBean("calculadorSistemaAmericano", CalculadorCuota.class);
        }
        
        if (tipoAmortizacion.equals("aleman")) {
            calculadorCuota = appContext.getBean("calculadorSistemaAleman", CalculadorCuota.class);
        }
        
        if (calculadorCuota==null) { throw error; }
        
        calculadorCuota.mostrarCuotas();
    }
}
