package application;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BinFile {

    private final File arquivo = new File("./Veiculos.bin");

    public String lerArquivoBin() throws IOException {

        try {

            byte[] bytes = new byte[(int)arquivo.length()];
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("./Veiculos.bin")));
            dataInputStream.readFully(bytes);
            dataInputStream.close();
            return new String(bytes);

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escreverArquivoBin(String veiculo) throws IOException {

        Path path = Paths.get("./Veiculos.bin");

        try {
            StringBuilder conteudo = new StringBuilder(lerArquivoBin());
            conteudo.append(veiculo);
            Files.writeString(path, conteudo);
        }
        catch (FileNotFoundException exception){
            throw new FileNotFoundException("Arquivo não encontrado!");
        }
        catch (IOException e) {
            throw new IOException("Erro: " + e);
        }

    }

}
