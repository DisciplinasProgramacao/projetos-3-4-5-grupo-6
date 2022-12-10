package entities;

import java.util.Random;

public class FactoryVehicle {

    static Random aleat = new Random();

    public AbstractVehicle criarVeiculo(String tipo, String modelo, String placa, int tamanhoTanque, double valorVenda, double quilometragem){

        try{

            AbstractVehicle veiculo = null;

            switch (tipo) {
                case "Carro" -> veiculo = new Carro(modelo, placa, tamanhoTanque, valorVenda, quilometragem);

                case "Caminhao" -> veiculo = new Caminhao(modelo, placa, tamanhoTanque, valorVenda, quilometragem);

                case "Van" -> veiculo = new Van(modelo, placa, tamanhoTanque, valorVenda, quilometragem);

                case "Furgao" -> veiculo = new Furgao(modelo, placa, tamanhoTanque, valorVenda, quilometragem);

                default -> System.out.println("\nNao existe esse tipo de veiculo!\n");
            }

            return veiculo;

        }
        catch(Exception e){
            System.out.println("Impossivel criar este veiculo!");
        }

        return null;
    }

    public AbstractVehicle criarVeiculoAleatorio() {

        String[] nomesCarros = {"Onix", "Corsa", "Golf", "Uno", "HB20", "Toro", "Camaro", "Tracker", "3008", "Equinox"};
        String[] nomesCaminhoes = {"Mercedes L-1113", "Scania L111", "Chevrolet C6500", "Mercedes L-1620", "Volvo Titan L935", "Volvo Titan L935", "FNM D-11.000", "VOLVO N10", "Ford F-14000", "VW 24.250"};
        String[] nomesVans = {"Mercedes-Benz 413", "Ford Transit", "Renault Master", "Fiat Ducato Minibus", "Mercedes-Benz Sprinter 313", "Fiat Ducato Combinato", "Citroen Jumper", "Peugeot Boxer", "CNAuto Topic", "Volkswagen Kombi"};
        String[] nomesFurgoes = {"Fiorino 1.4 EVO Flex", "Fiorino Hard Working 1.4", "Partner 1.6", "Mecedes 415", "Ducato Cargo Turbo", "Master Furgão L1H1", "Kangoo Z.E. Maxi", "Transit Longo", "Transit Longo", "Citroen Jumpy Cargo"};

        int capacidadeTanque;
        double valorDeVenda;
        double quilometragem = aleat.nextDouble(50000);

        AbstractVehicle veiculo = null;

        int tipo = aleat.nextInt(4);

        String tipoVeiculo = "";

        switch (tipo) {
            case 0 -> tipoVeiculo = "Carro";
            case 1 -> tipoVeiculo = "Caminhao";
            case 2 -> tipoVeiculo = "Van";
            case 3 -> tipoVeiculo = "Furgao";
        }

        String nome;
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

        return veiculo;

    }

    public String gerarPlacaAleatoria(){

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
}
