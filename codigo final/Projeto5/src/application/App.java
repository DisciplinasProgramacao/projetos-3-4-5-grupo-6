package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.*;

public class App {

    public static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static Frota frota = new Frota();
    public static BinFile binFile = new BinFile();
    public static ArrayList<AbstractVehicle> listaVeiculos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static FactoryVehicle fabricaVeiculo = new FactoryVehicle();
    static DecimalFormat df = new DecimalFormat("#,###.00");

    private static void criarVeiculosAleatorios(){

        if(listaVeiculos.size() != 0){

            listaVeiculos = new ArrayList<>();

        }

        for(int i=0; i<10; i++){

            AbstractVehicle veiculo = fabricaVeiculo.criarVeiculoAleatorio();

            listaVeiculos.add(veiculo);
        }

        listaVeiculos.forEach(System.out::println);

    }

    private static void adcionarVeiculosAFrota(){

        try {

            if(listaVeiculos.size() != 0){
                listaVeiculos.forEach(frota::adicionarVeiculo);
            }
            else{System.out.println("Lista de veiculos vazia");}
        }
        catch(Exception e){
            System.out.println("Impossivel adcionar veiculos na frota!\nDetalhe: " + e);
        }

    }

    private static void criarRotasEAdcionar(AbstractVehicle veiculoDaFrota, double distancia, String data){

        try {

            Rota rota = new Rota(distancia, LocalDate.parse(data, fmt1));

            listaVeiculos.forEach(veiculo -> {
                if(veiculo.equals(veiculoDaFrota)){
                    veiculo.adicionaRota(rota);
                }
            });
        }

        catch(NullPointerException e){
            System.out.println(e.toString());
        }

        catch(Exception e){
            System.out.println("Impossivel adcionar rotas ao veiculo!\nDetalhe: " + e);
        }

    }

    private static void adcionarVeiculosNoBinFile(){

        listaVeiculos.forEach(veiculo -> {
            try {
                binFile.escreverArquivoBin(veiculo.toString());
            }

            catch (IOException e) {
                System.out.println("Impossivel adcionar veiculos ao arquivo!\nDetalhe: " + e);
            }
        });

    }

    private static void	mostrarFrotaVeiculos(){

        try {

            List<AbstractVehicle> listaFrota = frota.getVehicles();

            listaFrota.forEach(System.out::println);

        }
        catch(Exception e){
            System.out.println("Impossivel mostrar veiculos da frota!\nDetalhe: " + e);
        }
    }

    private static void lerEPrintarArquivoBinFile(){

        try {


            String conteudoArquivo = binFile.lerArquivoBin();
            System.out.println(conteudoArquivo);

        }
        catch(FileNotFoundException e){
            System.out.println("Erro ao tentar encontrar arquivo!\nDetalhe: " + e);
        }

        catch(Exception e){
            System.out.println("Impossivel ler o arquivo e printar no console!\nDetalhe: " + e);
        }
    }

    private static String verQuilometragemMediaDosVeiculosDaFrota(){

        return df.format(frota.quilometragemMediaDasRotas());

    }

    public static void main(String[] args){

        int opcao;

        System.out.println("""
                ----------Controle de frota------------
                
                           OPCOES DO MENU
                
                1 - Criar 10 veiculos aleatorios
                2 - Adcionar lista de veiculos na frota
                3 - Criar rota para veiculo da frota
                4 - Mostrar lista de veiculos da frota
                5 - Salvar veiculos no arquivo binario
                6 - Ler a arquivo binario
                7 - Criar veiculo
                0 - Sair
                """);
        System.out.print("Opcao: ");
        opcao = sc.nextInt();

        while(opcao != 0){

            switch(opcao){

                case 1:
                    criarVeiculosAleatorios();
                    break;

                case 2:
                    adcionarVeiculosAFrota();
                    mostrarFrotaVeiculos();
                    System.out.println("\nVeiculos adcionados com sucesso!\n\n");
                    break;

                case 3:

                    try{

                        Scanner sc = new Scanner(System.in);

                        System.out.print("Digite a placa do veiculo que deseja adcionar a rota: ");
                        String placa = sc.nextLine();

                        AbstractVehicle veiculoDaFrota;

                        try {

                            veiculoDaFrota = frota.consultaVeiculo(placa);

                            if (veiculoDaFrota == null) {
                                throw new NullPointerException("Veiculo nao pertence a frota!");
                            }
                            else{System.out.println("Veiculo encontrado!");}

                        }
                        catch(NullPointerException e){
                            throw new NullPointerException(e.toString());
                        }

                        System.out.print("Distancia da rota: ");
                        double distancia = sc.nextDouble();

                        sc = new Scanner(System.in);

                        System.out.print("Digite a data no modelo dd/MM/yyyy: ");
                        String data = sc.nextLine();;

                        criarRotasEAdcionar(veiculoDaFrota, distancia, data);

                        System.out.println("Rota criada com sucesso!");

                    }

                    catch(Exception e){
                        System.out.println(e.toString());
                    }

                    break;

                case 4:
                    mostrarFrotaVeiculos();
                    System.out.println("\nA quilometragem media dos veiculos da frota: " + verQuilometragemMediaDosVeiculosDaFrota() + " Km rodados");
                    break;

                case 5:
                    adcionarVeiculosNoBinFile();
                    break;

                case 6:
                    lerEPrintarArquivoBinFile();
                    break;

                case 7:

                    sc = new Scanner(System.in);
                    System.out.print("Digite o tipo do veiculo: ");
                    String tipo = sc.nextLine();

                    System.out.print("Digite o modelo/nome do carro: ");
                    String modelo = sc.nextLine();

                    String placa = fabricaVeiculo.gerarPlacaAleatoria();
                    System.out.print("Gerando placa aleatoria: " + placa);

                    System.out.print("\nDigite a capacidade do tanque: ");
                    int capacidade = sc.nextInt();

                    System.out.print("Digite o valor de venda do carro: ");
                    double valorVenda = sc.nextDouble();

                    System.out.print("Digite a quilometragem do carro: ");
                    double quilometragem = sc.nextDouble();

                    AbstractVehicle veiculo = fabricaVeiculo.criarVeiculo(tipo, modelo, placa, capacidade, valorVenda, quilometragem);

                    listaVeiculos.add(veiculo);

                    break;

                default:
                    System.out.println("\nDigite uma opcao valida!\n");
                    break;

            }

            System.out.println("""
                ----------Controle de frota------------
                
                           OPCOES DO MENU
                
                1 - Criar 10 veiculos aleatorios
                2 - Adcionar lista de veiculos na frota
                3 - Criar rota para veiculo da frota
                4 - Mostrar lista de veiculos da frota
                5 - Salvar veiculos no arquivo binario
                6 - Ler a arquivo binario
                7 - Criar veiculo
                0 - Sair
                """);
            System.out.print("Opcao: ");
            opcao = sc.nextInt();

        }

    }

}
