public class ReservaHotel {
    private String nomeCliente;
    private int numeroDiarias;
    private double valorDiaria;

    public ReservaHotel(String nomeCliente, int numeroDiarias, double valorDiaria){
        if(nomeCliente == null){
            throw new IllegalArgumentException("Nome Inválido");
        }
        if(numeroDiarias <=0){
            throw new IllegalArgumentException("Número de diárias Inválido");
        }
        if(valorDiaria <=0){
            throw new IllegalArgumentException("Valor da diária Inválido");
        }

        this.nomeCliente = nomeCliente;
        this.numeroDiarias = numeroDiarias;
        this.valorDiaria = valorDiaria;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public int getNumeroDiarias() {
        return numeroDiarias;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }


    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;

    }

    public void setNumeroDiarias(int numeroDiarias){
        this.numeroDiarias = numeroDiarias;
    }

    public void setValorDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }
}
