import java.util.Scanner;

public class Gerencia {

    Scanner sc = new Scanner(System.in);
    Veiculos veiculos[] = new Veiculos[50];
    int qntVeiculo = 0;
    float tarifa;

    public void cadastro(String placa, String modelo, int horarioEntrada){

        veiculos[qntVeiculo].placa = placa;
        veiculos[qntVeiculo].modelo = modelo;
        veiculos[qntVeiculo].horarioEntrada = horarioEntrada;
        qntVeiculo +=1;
    }
        public void  listagem(){
            
        }
}
