package edu.educacionit;

class SistemaAleman implements Amortizable {

    private float monto;
    private int cuotas;
    private float tasa;

    public SistemaAleman(float monto, int cuotas, float tasa) {
        this.monto = monto;
        this.cuotas = cuotas;
        this.tasa = tasa;
    }

    public int getCantidadVeces() {
        return cuotas;
    }
    
    @Override
    public float amortizar() {
        float montoRestante = monto;
        float montoCapital = montoRestante / (float)cuotas;
        float montoInteres = montoCapital * tasa / (float)12;
        
        this.monto -= montoCapital;
        
        return montoCapital + montoInteres;
    }
}