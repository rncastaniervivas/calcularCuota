package edu.educacionit;

public class SistemaAmericano implements Amortizable {
    private float monto;
    private int cuotas;
    private float tasa;
    private int cuotasRestantes;

    public SistemaAmericano(float monto, int cuotas, float tasa) {
        this.monto = monto;
        this.cuotas = cuotas;
        this.tasa = tasa;
        this.cuotasRestantes = cuotas;
    }
    
    public int getCantidadVeces() {
        return cuotas;
    }
    
    @Override
    public float amortizar() {
        float montoRestante = monto;
        float montoCapital = montoRestante / (float)cuotas;
        float montoInteres = montoCapital * tasa / (float)12;
        
        this.cuotasRestantes--;
        
        if (cuotasRestantes == 0) {
            return montoCapital + montoInteres;
        }
        
        return montoInteres;
    }
}
