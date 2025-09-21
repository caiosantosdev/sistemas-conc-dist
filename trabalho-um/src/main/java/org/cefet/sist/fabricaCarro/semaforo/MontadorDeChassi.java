package org.cefet.sist.fabricaCarro.semaforo;

class MontadorDeChassi extends Thread {
    private final Esteira esteira;
    private static int contador = 0;

    public MontadorDeChassi(Esteira esteira, String nome) {
        super(nome);
        this.esteira = esteira;
    }

    @Override
    public void run() {
        System.out.println("Iniciando execução Montador de Chassi");
        try {
            while (true) {
                Chassi chassi = new Chassi(++contador);
                esteira.adicionarChassi(chassi, getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}