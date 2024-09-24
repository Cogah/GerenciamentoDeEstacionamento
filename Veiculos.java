import java.util.Scanner;
public class Veiculos {
    Scanner sc = new Scanner(System.in);
    String placa;
    String modelo;
    int horarioEntrada;
    int horarioSaida;
    private float tarifa = 5;
    
    
    public Veiculos(String placa, String modelo, int horarioEntrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.horarioEntrada = horarioEntrada;
    }  
    Veiculos(){}  

    public void Cadastrar(){
        System.out.println("Insira a placa: ");
        this.placa = sc.nextLine();
        System.out.println("Insira o modelo: ");
        this.modelo = sc.nextLine();
        System.out.println("Insira o horário de entrada: ");
        this.horarioEntrada = sc.nextInt();
    }

    public void CalcularTarifa(){
        //Preço inicial fixo de 5 conto
        if(horarioSaida > horarioEntrada){
            tarifa += 10*(horarioSaida - horarioEntrada);
        }else if(horarioEntrada > horarioSaida){
            tarifa += 10*((horarioSaida+24) - horarioEntrada);
        }else{
            tarifa = 220;//valor de uma diária
        }
        
        System.out.println(tarifa);
    }
    public void Saida(){
        System.out.println("Digite o horário de saída: ");
        horarioSaida = sc.nextInt();
        this.CalcularTarifa();
        System.out.println("Tarifa a pagar: "+this.tarifa);
    }

}