package application;

import entities.AbstractVehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TxtFile {

    private final File arquivo = new File("./Veiculos.txt");

    public ArrayList<String> lerArquivoTxt() throws FileNotFoundException {

        try {

            BufferedReader arquivoTxt = new BufferedReader(new FileReader(arquivo));

            ArrayList<String> linhasArquivoTxt = new ArrayList<>();
            String linha;

            while ((linha = arquivoTxt.readLine()) != null)

                linhasArquivoTxt.add(linha);

            return linhasArquivoTxt;
        }

        catch (FileNotFoundException exception){
            throw new FileNotFoundException("Arquivo não encontrado!");
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escreverArquivoTxt(String veiculo) throws IOException {

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./Veiculos.txt", true)));
        out.println(veiculo);
        out.close();

    }

}
