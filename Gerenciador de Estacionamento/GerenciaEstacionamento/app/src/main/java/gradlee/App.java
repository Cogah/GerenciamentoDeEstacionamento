package gradlee;

public class App {

    
    
    public static void main(String[] args) throws Exception{
        Gerenciador gerencia = new Gerenciador();
        GeolocationServiceNominatim geolocationService = new GeolocationServiceNominatim();
        
        String endereco = "Avenida Alcindo Cacela 1523, Umarizal, Brazil";// Endereço do estacionamento
        System.out.println("Coordenadas do estacionamento: ");
        geolocationService.obterCoordenadas(endereco);
        

        
        gerencia.lerArquivoCSV();
        gerencia.listagem();

        do {
            gerencia.menu();
        }while(gerencia.op != 6);


    }
}