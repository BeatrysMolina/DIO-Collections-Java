import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Dadas as seguintes informações sobre meus livro favoritos e seus autores, crie um dicionário e ordene exibindo nome
 * do autor e do livro:
 * 
 *      Autor = Hawking, Stephen - Livro = Uma Breve História do Tempo. 256 páginas
 *      Autor = Duhigg, Charles - Livro = O Poder do Hábito. 408 páginas
 *      Autor = Harari, Yuval Noah - Livro = 21 Lições Para o Século 21. 432 páginas
 */

public class ExemploOrdenacaoMap {
    
    public static void main(String[] args) {

        System.out.println("\n--\tOrdem aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro ("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro ("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro ("21 Lições Para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\n--\tOrdem inserção\t--");
        Map<String, Livro> meuslivros1 = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livro ("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro ("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro ("21 Lições Para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : meuslivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\n--\tOrdem alfabética (autor)\t--");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meuslivros1);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\n--\tOrdem alfabética (nome do livro)\t--");
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }
}

class Livro {

    private String nome;
    private Integer paginas;
    
    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome=" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}