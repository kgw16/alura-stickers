import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        

        // fazer uma conexão http e buscar os top 250 filmes

        // String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        
        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        var http =  new ClienteHttp();
        String json = http.buscaDados(url);


        
        

        

        // exebir e manipular os dados
        
        
        List<Conteudo> conteudos = extrator.extraiConteudos(json); 

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0 ; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);
            

            InputStream inputStream = new URL(conteudo.getURLImagem()).openStream();
            String nomeArquivo ="saida/" + conteudo.getTitulo().replace(":", "-") + ".png"; 

            geradora.cria(inputStream, nomeArquivo);

            // desafio de imprimir o titulo mudando a cor do terminal
            //System.out.println("\u001b[37;1m \u001b[44;1m" + filme.get("title") + "\u001b[m");

            System.out.println(conteudo.getTitulo());
            System.out.println();
            

            // desafio de imprimir estrelas igual ao numero do rating

            // double numeroDouble = Double.parseDouble(filme.get("imDbRating")); 
            // int numeroInt = (int) numeroDouble;
            // for(int i = 0; i < numeroInt ; i++){
            //     System.out.print("\u2B50");
            // }
            // System.out.println();
        }    

    }

    
}
