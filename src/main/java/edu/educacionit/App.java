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


@Configuration
// @ComponentScan({"edu.educacionit"})
class AppConfig {
    
    @Bean(name="servicioSaludo")
    public ISaludo obtenerSaludo() {
        /*
        if (System.getProperty("amort")==null) {
            throw new RuntimeException("Vino null");
        }
        */
        return new Saludo();
    }
}

interface ISaludo {
    void saludar();
}

class Saludo implements ISaludo {
    public void saludar() {
        System.out.println("Bienvenido al sistema de amortizacion");
    }
}

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        ISaludo saludo =
                appContext.getBean("servicioSaludo", Saludo.class);
        
        saludo.saludar();
        
        System.out.println(System.getProperty("tipoAmortizacion"));
    }
}
