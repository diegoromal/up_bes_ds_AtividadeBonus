import java.io.IOException;
import java.util.ArrayList;

public class Sistema{

    private static void exibirMenu() {

        System.out.println("\nMuseu XPTO");
        System.out.println("[1] - Cadastrar obra");
        System.out.println("[2] - Listar todas as obras");
        System.out.println("[3] - Buscar obra");
        System.out.println("[4] - Apagar as obras");
        System.out.println("[0] - Sair");
        System.out.print("Sua opção: ");

    }
    
    private static void verificarOpcao(int opcao) {

        switch (opcao) {
            case 1:
                adicionarObra();
                break;

            case 2:
                listarObras();
                break;
            
            case 3:
                buscarObra();
                break;

            case 4:
                apagarObra();
                break;

            case 0: 
                System.out.println("\nO Programa foi finalizado...");
                break;
        
            default:
                System.out.println("\nOpção inválida Digite novamente: ");
                break;
        }

    }

    private static void adicionarObra() {

        System.out.println("\nAdicionar Obra:");
        
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        System.out.print("Informe o artista: ");
        String artista = Console.lerString();

        System.out.print("Informe o tipo da obra: ");
        String tipoObra = Console.lerString();

        System.out.print("Informe o local da obra: ");
        String local = Console.lerString();

        System.out.print("Informe o ano da obra: ");
        int ano = Console.lerInt();

        Obra obra = new Obra(titulo, artista, tipoObra, local, ano);

        try {
            GerenciadorObras.salvarObra(obra);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void listarObras() {

        System.out.println("\nObras cadastradas:");

        try {
            for (Obra tempObra : GerenciadorObras.listarObras()) {
                System.out.println(tempObra);
            }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarObra() {

        System.out.println("\nBuscar Obra");
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        try {
            Obra obra = GerenciadorObras.buscarObra(titulo);
            System.out.println("\nObra encontrada: " + obra);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
    private static void apagarObra() {

        System.out.println("\nApagar Obra");
        System.out.print("Informe o título da obra que deseja apagar: ");
        String titulo= Console.lerString();

        try {

            GerenciadorObras.apagarObra(titulo);
            System.out.println("\nObra excluída com sucesso!");
        
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }

    public static void executar() {

        int op;
        do {
            
            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);

        } while(op != 0);

    }
}
