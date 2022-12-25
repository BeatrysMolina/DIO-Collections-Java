import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Dada um alista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
 */

public class ExemploSet {

    
    public static void main(String[] args){

        System.out.println("\nCrie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        /** Não é possível trabalhar com posição dentro do SET:
        * System.out.println("\nExiba a posição da nota 5.0: "); [Não tem método indexOf() para realizar esta solicitação].
        * System.out.println("\nAdicione na lista a nota 8.0 na posição 4: "); 
        * System.out.println("\nSubstitua a nota 5.0 pela nota 6.0: ");
        * System.out.println("\nExiba a terceira nota adicionada: ");
        * System.out.println("\nRemova a nota da posição 0: ");
        */

        System.out.println("\nConfira se a nota 5.0 está no conjunto: " + notas.contains(5d));

        System.out.println("\nExiba a menor nota: " + Collections.min(notas));

        System.out.println("\nExiba a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("\nExiba a soma dos valores: " + soma); // Soma da menor devido SET não considerar valores duplicados.

        System.out.println("\nExiba a média das notas: " + (soma/notas.size()));

        System.out.println("\nRemova a nota 0.0: ");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("\nRemova as notas menores que 7 e exiba a lista: ");        
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("\nExiba todas as notas na ordem em que foram informados: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("\nExiba todas as notas no ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("\nApague todo o conjunto");
        notas.clear();

        System.out.println("\nConfira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("\nConfira se o conjunto2 está vazio: " + notas2.isEmpty());
        System.out.println("\nConfira se o conjunto3 está vazio: " + notas3.isEmpty());


    }
}