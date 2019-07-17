package edu.educacionit;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean(name="calculadorSistemaAleman")
    public CalculadorCuota calcSistemaAleman() {
        return new CalculadorCuota(new SistemaAleman(1000,10,0.35f));
    }
    @Bean(name="calculadorSistemaAmericano")
    public CalculadorCuota calcSistemaAmericano() {
        return new CalculadorCuota(new SistemaAmericano(1000,10,0.35f));
    }
}
