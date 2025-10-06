package org.cefet.sist.fabricaCarro.semaforo;

public class PrincipalFabrica {
    public static void main(String[] args) {
        Esteira esteira = new Esteira(5);
        new InstaladorDeMotor(esteira, "Instalador-A").start();
        new InstaladorDeMotor(esteira, "Instalador-B").start();
        new InstaladorDeMotor(esteira, "Instalador-C").start();

        new MontadorDeChassi(esteira, "Montador-1").start();
        new MontadorDeChassi(esteira, "Montador-2").start();

    }
}