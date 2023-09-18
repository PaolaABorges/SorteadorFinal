package sorteador.projeto.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class S_sorteio {


    public static int[] sortear(int quantidade, int inicio, int fim) {

        Random geradordenumeros = new Random();
        int[] numerosSorteados = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            numerosSorteados[i] = geradordenumeros.nextInt((fim - inicio) + 1) + inicio;
        }

        return numerosSorteados;

    }

    public static int[] sortearSemRepetir(int quantidade, int inicio, int fim) {
        if (quantidade > fim) {
            throw new IllegalArgumentException("A quantidade de números a serem sorteados não pode ser maior que o limite.");
        }

        Set<Integer> numerosSorteados = new HashSet<>();
        Random random = new Random();

        while (numerosSorteados.size() < quantidade) {
            int numeroSorteado = random.nextInt((fim - inicio) + 1) + inicio;
            numerosSorteados.add(numeroSorteado);
        }


        int[] vetorNumeros = new int[quantidade];
        int index = 0;
        for (int numero : numerosSorteados) {
            vetorNumeros[index++] = numero;
        }

        return vetorNumeros;
    }

    public static int[] Ordenar(int[] numerosOrdenados) {
        return Arrays.stream(numerosOrdenados).sorted().toArray();
    }
}