import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
    

    public List<Conteudo> extraiConteudos(String json){

        var parser = new JasonParser(); //var é um tipo igual de como foi instanciado = {JasonParser parser = new  JasonParser()
            List<Map<String, String>> listaDeAtributos = parser.parse(json);
    
            List<Conteudo> conteudos = new ArrayList<>();
    
            //popular a lista de conteudos
            for (Map<String, String> Atributos : listaDeAtributos) {
                
                String titulo = Atributos.get("title");
                String urlImagem = Atributos.get("image").replaceAll("(@+)(.*)", "$1.png");
                var conteudo = new Conteudo(titulo, urlImagem);
    
                conteudos.add(conteudo);
            }
            return conteudos;

    }

   
}
