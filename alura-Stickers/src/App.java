import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        

        // fazer uma conexão http e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient(); 
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); 
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
     


        // extrair só os dados que interessam (tilulo,poster,classificação)
        var parser = new JasonParser(); //var é um tipo igual de como foi instanciado = {JasonParser parser = new  JasonParser()
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        

        // exebir e manipular os dados 

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[37;1m \u001b[44;1m" + filme.get("title") + "\u001b[m");
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            double numeroDouble = Double.parseDouble(filme.get("imDbRating")); 
            int numeroInt = (int) numeroDouble;
            for(int i = 0; i < numeroInt ; i++){
                System.out.print("\u2B50");
            }
            System.out.println();
        }    

    }

    
}
