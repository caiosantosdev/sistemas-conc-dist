package org.cefet.sist.fabricaCarro.monitor;

import java.util.LinkedList;
import java.util.Queue;

public class Esteira {
    private final Queue<Chassi> fila = new LinkedList<>();
    private final int capacidade;

    public Esteira(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionarChassi(Chassi chassi, String produtor) throws InterruptedException {
        System.out.println(produtor + " entrou em adicionar Chassi");
        while (fila.size() == capacidade) {
            wait(); // espera liberar espaço (acorda com notifyAll do consumidor que consumiu do buffer)
        }
        fila.add(chassi);
        System.out.println(produtor + " produziu Chassi-" + chassi.getId());
        notifyAll(); // acorda consumidores. (presos no wait de buffer vazio).
    }

    public synchronized Chassi removerChassi(String consumidor) throws InterruptedException {
        while (fila.isEmpty()) {
            wait(); // espera até ter um chassi (é acordado com um notifyAll do produtor)
        }
        Chassi chassi = fila.poll();
        System.out.println(consumidor + " instalou motor no Chassi-" + chassi.getId());
        notifyAll(); // acorda produtores (esperando no wait de se estiver cheio).
        return chassi;
    }
}
