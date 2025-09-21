package org.cefet.sist.fabricaCarro.monitor;

public class PrincipalFabrica {
    public static void main(String[] args) {
        Esteira esteira = new Esteira(5);

        new MontadorDeChassi(esteira, "Montador-1").start();
        new MontadorDeChassi(esteira, "Montador-2").start();

        new InstaladorDeMotor(esteira, "Instalador-A").start();
        new InstaladorDeMotor(esteira, "Instalador-B").start();
    }
}