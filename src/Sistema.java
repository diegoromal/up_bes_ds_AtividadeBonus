import java.io.IOException;

public class Sistema{

    private static void exibirMenu() {

        System.out.println("\nMuseu XPTO");
        System.out.println("[1] - Cadastrar obras");
        System.out.println("[2] - Buscar obra");
        System.out.println("[3] - Listar todas as obras");
        System.out.println("[4] - Apagar as obras");
        System.out.println("[0] - Sair");
        System.out.print("Sua opção: ");

    }
    
    private static void verificarOpcao(int opcao) {

        switch (opcao) {
            case 1:
                salvarObra();
                break;

            case 2:
                buscarObra();
                break;
            
            case 3:
                listarObras();
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

    private static void salvarObra() {

        System.out.println("\nAdicionar Obra:");
        
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        System.out.print("Informe o Artista: ");
        String artista = Console.lerString();

        System.out.print("Informe o Tipo da obra: ");
        String tipoObra = Console.lerString();

        System.out.println("Informe o local da obra");
        String local = Console.lerString();

        System.out.println("Informe o ano da obra");
        int ano = Console.lerInt();

        Obra obra = new Obra(titulo, artista, tipoObra, local, ano);

        try {
            GerenciadorObras.salvarObra(obra);
        } catch (IOException e) {
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
    
    private static void listarObras() {

        System.out.println("\nObras Cadastrados:");

        try {

            for (Obra tempObra : GerenciadorObras.listarObras())
            {
                System.out.println(tempObra);
            }
        
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
