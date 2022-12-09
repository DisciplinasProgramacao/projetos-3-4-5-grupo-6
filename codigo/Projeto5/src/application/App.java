package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entities.*;

public class App {

    static Random aleat = new Random();
    public static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static Frota frota = new Frota();
    public static BinFile binFile = new BinFile();
    public static ArrayList<AbstractVehicle> listaVeiculos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private static void criarVeiculosAleatorios(){

        if(listaVeiculos.size() != 0){

            listaVeiculos = new ArrayList<>();

        }

        String[] nomesCarros = {"Onix", "Corsa", "Golf", "Uno", "HB20", "Toro", "Camaro", "Tracker", "3008", "Equinox"};
        String[] nomesCaminhoes = {"Mercedes L-1113", "Scania L111", "Chevrolet C6500", "Mercedes L-1620", "Volvo Titan L935", "Volvo Titan L935", "FNM D-11.000", "VOLVO N10", "Ford F-14000", "VW 24.250"};
        String[] nomesVans = {"Mercedes-Benz 413", "Ford Transit", "Renault Master", "Fiat Ducato Minibus", "Mercedes-Benz Sprinter 313", "Fiat Ducato Combinato", "Citroen Jumper", "Peugeot Boxer", "CNAuto Topic", "Volkswagen Kombi"};
        String[] nomesFurgoes = {"Fiorino 1.4 EVO Flex", "Fiorino Hard Working 1.4", "Partner 1.6", "Mecedes 415", "Ducato Cargo Turbo", "Master Furgão L1H1", "Kangoo Z.E. Maxi", "Transit Longo", "Transit Longo", "Citroen Jumpy Cargo"};

        int capacidadeTanque;
        double valorDeVenda;
        double quilometragem = 0.0;

        AbstractVehicle veiculo = null;

        for(int i=0; i<10; i++){

            int tipo = aleat.nextInt(4);

            String tipoVeiculo = "";

            switch(tipo){
                case 0 -> tipoVeiculo = "Carro";
                case 1 -> tipoVeiculo = "Caminhao";
                case 2 -> tipoVeiculo = "Van";
                case 3 -> tipoVeiculo = "Furgao";
            }

            String nome = "";
            int posicao;

            String placa = gerarPlacaAleatoria();

            switch (tipoVeiculo) {
                case "Carro" -> {
                    posicao = aleat.nextInt(nomesCarros.length);
                    nome = nomesCarros[posicao];
                    capacidadeTanque = aleat.nextInt(101);
                    valorDeVenda = aleat.nextDouble((100000.0 - 1000.0) + 1000.0);

                    veiculo = new Carro(nome, placa, capacidadeTanque, valorDeVenda, quilometragem);
                }
                case "Caminhao" -> {
                    posicao = aleat.nextInt(nomesCaminhoes.length);
                    nome = nomesCaminhoes[posicao];
                    capacidadeTanque = aleat.nextInt(1081);
                    valorDeVenda = aleat.nextDouble((5000000.0 - 1000000.0) + 1000000.0);
                    veiculo = new Caminhao(nome, placa, capacidadeTanque, valorDeVenda, quilometragem);
                }
                case "Van" -> {
                    posicao = aleat.nextInt(nomesVans.length);
                    nome = nomesVans[posicao];
                    capacidadeTanque = aleat.nextInt(151);
                    valorDeVenda = aleat.nextDouble((1000000.0 - 50000.0) + 50000.0);
                    veiculo = new Van(nome, placa, capacidadeTanque, valorDeVenda, quilometragem);
                }
                case "Furgao" -> {
                    posicao = aleat.nextInt(nomesFurgoes.length);
                    nome = nomesFurgoes[posicao];
                    capacidadeTanque = aleat.nextInt(141);
                    valorDeVenda = aleat.nextDouble((100000.0 - 1000.0) + 1000.0);
                    veiculo = new Furgao(nome, placa, capacidadeTanque, valorDeVenda, quilometragem);
                }

            }

            listaVeiculos.add(veiculo);
        }

        System.out.println(listaVeiculos);

    }

    private static void criarVeiculo(String tipo, String modelo, String placa, int tamanhoTanque, double valorVenda, double quilometragem){

        try{

            AbstractVehicle veiculo = null;

            switch (tipo) {
                case "Carro" -> veiculo = new Carro(modelo, placa, tamanhoTanque, valorVenda, quilometragem);

                case "Caminhao" -> veiculo = new Caminhao(modelo, placa, tamanhoTanque, valorVenda, quilometragem);

                case "Van" -> veiculo = new Van(modelo, placa, tamanhoTanque, valorVenda, quilometragem);

                case "Furgao" -> veiculo = new Furgao(modelo, placa, tamanhoTanque, valorVenda, quilometragem);

                default -> System.out.println("\nNao existe esse tipo de veiculo!\n");
            }

            listaVeiculos.add(veiculo);

        }
        catch(Exception e){
            System.out.println("Impossivel criar este veiculo!");
        }

    }

    private static String gerarPlacaAleatoria(){

        StringBuilder placa = new StringBuilder();

        char[] alfabeto = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        for(int i=0; i<3; i++){

            int posicao = aleat.nextInt(alfabeto.length);
            char letra = alfabeto[posicao];

            placa.append(letra);
        }

        int numero = aleat.nextInt(10);

        placa.append(numero);

        int posicao = aleat.nextInt(alfabeto.length);
        char letra = alfabeto[posicao];

        placa.append(letra);

        for(int i=0; i<2; i++){

            numero = aleat.nextInt(10);

            placa.append(numero);

        }

        return placa.toString();

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

                    }

                    catch(Exception e){
                        System.out.println(e.toString());
                    }

                    break;

                case 4:
                    mostrarFrotaVeiculos();
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

                    String placa = gerarPlacaAleatoria();
                    System.out.print("Gerando placa aleatoria: " + placa);

                    System.out.print("\nDigite a capacidade do tanque: ");
                    int capacidade = sc.nextInt();

                    System.out.print("Digite o valor de venda do carro: ");
                    double valorVenda = sc.nextDouble();

                    System.out.print("Digite a quilometragem do carro: ");
                    double quilometragem = sc.nextDouble();

                    criarVeiculo(tipo, modelo, placa, capacidade, valorVenda, quilometragem);

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
