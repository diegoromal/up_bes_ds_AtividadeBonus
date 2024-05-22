import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GerenciadorObras {
    
    private static final String ARQUIVO = "obras.txt";

    public static void salvarObra(Obra obra) throws IOException {

        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(obra.toString() + "\n");
        }
    }

    public static ArrayList<Obra> listarObras() throws IOException, Exception {

        ArrayList<Obra> listaObras = new ArrayList<>();

        try (FileReader fr = new FileReader(ARQUIVO);
            BufferedReader br = new BufferedReader(fr)) {

                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] dados = linha.split(", ");
                    Obra obra = new Obra(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]));
                    listaObras.add(obra);
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        if (listaObras.isEmpty()) {
            throw new Exception("\nNão há obras cadastrados");
        }

        return listaObras;
    }

    public static Obra buscarObra(String titulo) throws Exception {

        ArrayList<Obra> listaObras = listarObras();

        for (Obra tempObra : listaObras) {
            if (tempObra.getTitulo() == titulo) {
                return tempObra;
            }
        }

        throw new Exception("\nObra com o título: " + titulo + " não localizada");
    }

    public static void apagarObra(String titulo) throws Exception{

        ArrayList<Obra> listaObras = listarObras();       
    
        boolean encontrou = false;
        for (Obra temp : listaObras) {

            if(temp.getTitulo() == titulo) {
                listaObras.remove(temp);
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            throw new Exception("\nObra com o título: " + titulo + " não localizado!");
        }
        try (FileWriter fw = new FileWriter(ARQUIVO);
        BufferedWriter bw = new BufferedWriter(fw)) {

            for (Obra o : listaObras) {

                bw.write(o + "\n");
            }
        }
    }

}
