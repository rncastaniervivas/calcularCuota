package edu.educacionit;

class CalculadorCuota {
    private Amortizable amortizable;

    public CalculadorCuota(Amortizable amortizable) {
        this.amortizable = amortizable;
    }
    
    public void mostrarCuotas() {
        System.out.println("----------------------------");
        System.out.println("      C U O T A S ");
        System.out.println("----------------------------");
        for (int x=1; x <= amortizable.getCantidadVeces(); x++) {
            float valorCuota = amortizable.amortizar();
            System.out.print("Cuota: " + x + " --------- ");
            System.out.println(valorCuota);
        }
        System.out.println("----------------------------");
        System.out.println("     F I N   P L A N  ");
        System.out.println("----------------------------");
    }
}
