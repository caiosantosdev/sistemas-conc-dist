package org.cefet.sist.sistemaBancario.semControle;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        // Nesse exemplo, adicionei thread.sleep(10) dentro do metodo sacar em ContaBancaria.
        // Dessa forma, as threads saem de execução e voltam depois de um tempo simulando uma condição...
        // de corrida de forma revezada.

        //sincronizando o banco
        Banco banco = new Banco();

        Cliente joel = new Cliente(1);
        Cliente maeDoJoel = new Cliente(1);
        Cliente esposaDoJoel = new Cliente (1);
        Cliente tiaJoel = new Cliente(1);


        // definição e instanciação das operações
        OperacaoSaque op1 = new OperacaoSaque(banco, joel.getId(), 50.0);
        OperacaoSaque op2 = new OperacaoSaque(banco, joel.getId(), 50.0);
        OperacaoSaque op3 = new OperacaoSaque(banco, joel.getId(), 50.0);
        OperacaoSaque op4 = new OperacaoSaque(banco, joel.getId(), 50.0);

        // definição e instanciação das threads
        Thread t1 = new Thread(op1, "Cliente-Joel");
        Thread t2 = new Thread(op2, "Cliente-mae-Joel");
        Thread t3 = new Thread(op3, "Cliente-esposa-Joel");
        Thread t4 = new Thread(op4, "Cliente-tia-Joel");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // esperar que as threads morram
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("------------------------------------------");
        System.out.println("Simulação finalizada.");
        System.out.println("Saldo final da Conta 1: " + banco.getContasBancarias().get(joel.getId() - 1).getSaldo());
    }
}
