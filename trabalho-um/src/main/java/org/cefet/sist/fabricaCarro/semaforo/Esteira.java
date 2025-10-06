package org.cefet.sist.fabricaCarro.semaforo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Esteira {
    private final Queue<Chassi> fila = new LinkedList<>();
    private final int capacidade;

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore slotsLivres;
    private final Semaphore itens;

    public Esteira(int capacidade) {
        this.capacidade = capacidade;
        this.slotsLivres = new Semaphore(capacidade);
        this.itens = new Semaphore(0);
    }

    public void adicionarChassi(Chassi chassi, String produtor) throws InterruptedException {
        slotsLivres.acquire();  // espera espaço livre
        mutex.acquire();        // exclusão mútua
        fila.add(chassi);
        System.out.println(produtor + " produziu Chassi-" + chassi.getId());
        mutex.release();
        itens.release();        // sinaliza que há item disponível
    }

    public Chassi removerChassi(String consumidor) throws InterruptedException {
        System.out.println("thread consumidora pegando acquire de itens (wait(empty)).");
        itens.acquire();        // espera ter item
        System.out.println("thread entrou dentro do acquire apos produção.");
        mutex.acquire();        // exclusão mútua
        Chassi chassi = fila.poll();
        System.out.println(consumidor + " instalou motor no Chassi-" + chassi.getId());
        mutex.release();
        slotsLivres.release();  // libera espaço
        return chassi;
    }
}