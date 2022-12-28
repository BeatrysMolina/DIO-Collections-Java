package ExercicioPropostoMap;

import java.util.Arrays;
import java.util.List;
// import java.util.function.Predicate;
import java.util.stream.Collectors;
// import java.util.stream.Stream;

public class StreamApi1 {

    public static void main (String[] args) {

        List<String> numerosAleatorios = 
            Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.print("\nImprima todos os elementos dessa lista de String: ");
        numerosAleatorios.forEach(System.out::println);

        System.out.print("\nPegue os 5 primeiros números e coloque dentro de um Set:  ");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        // Set<String> collectSet = numerosAleatorios.stream()
        //             .limit(5)
        //             .collect(Collectors.toSet());
        
        System.out.print("\nTransforme essa lista de String em uma lista de números inteiros:  ");
        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
                .map(t -> Integer.parseInt(t))
                .collect(Collectors.toList());
        System.out.println(numerosAleatorios1);

        System.out.print("\nPegue os números pares e maiores que 2 e coloque em uma lista:  ");
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .filter(i -> (i % 2 == 0 && i > 2))
            .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);

        System.out.print("\nMostre a média dos números:  ");
        numerosAleatorios.stream()
            .mapToInt(Integer::parseInt)
            .average()
            .ifPresent(System.out::println);

        System.out.print("\nRemova os números ímpares:  ");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(t -> Integer.parseInt(t))
                .collect(Collectors.toList());
        numerosAleatoriosInteger.removeIf(integer -> (integer % 2 != 0));
        System.out.println(numerosAleatoriosInteger);
    }
}