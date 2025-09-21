package org.cefet.sist.fabricaCarro.semaforo;

class InstaladorDeMotor extends Thread {
    private final Esteira esteira;

    public InstaladorDeMotor(Esteira esteira, String nome) {
        super(nome);
        this.esteira = esteira;
    }

    @Override
    public void run() {
        System.out.println("Iniciando execução Instalador de motor");
        try {
            while (true) {
                esteira.removerChassi(getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}