package org.cefet.sist.sistemaBancario.monitor;

import java.util.concurrent.Semaphore;

public class ContaBancaria {
    public static int proximoId = 1;
    private Double saldo;

    private int id;

    public ContaBancaria(Double saldo){
        this.id = proximoId;
        proximoId++;

        this.saldo = saldo;
    }

    public synchronized Boolean sacar(Double valorSaque) throws Exception{
        double novoSaldo = saldo - valorSaque;
        if(novoSaldo >= 0){
            Thread.sleep(10);
            saldo = saldo - valorSaque;
            System.out.println("Thread: " + Thread.currentThread().getName() + " conseguiu sacar " + valorSaque + "reais." +
                    "\nSaldo atual na conta: " + this.saldo + "reais.");
            return true;
        } else {
            throw new Exception("ID: " + this.id + " Saldo insuficiente.");
        }
    }

    public int getId() {
        return id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
