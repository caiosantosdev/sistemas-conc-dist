package org.cefet.sist.sistemaBancario.monitor;

public class OperacaoSaque implements Runnable{
    private Banco banco;
    private int idConta;
    private Double valor;

    public OperacaoSaque(Banco banco, int idConta, Double valor){
        this.banco = banco;
        this.idConta = idConta;
        this.valor = valor;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + ": Cliente da conta " + idConta + " tentando sacar " + valor);
        try{
            Boolean sucesso = banco.sacar(idConta, valor);
            if(sucesso){
                System.out.println(">>> SUCESSO! Thread " + Thread.currentThread().getName() + ": Saque de " + valor + " na conta " + idConta + " realizado.");
            }

        }catch (Exception e){
            System.err.println(">>> FALHA! Thread " + Thread.currentThread().getName() + ": " + e.getMessage());
        }
    }
}
