package org.cefet.sist.sistemaBancario.monitor;

import java.util.Arrays;
import java.util.List;

public class Banco {
    private List<ContaBancaria> contasBancarias = Arrays.asList(
            new ContaBancaria(100.0), //id = 1
            new ContaBancaria(200.0), //id = 2
            new ContaBancaria(100000.0) //id = 3
    );

    public Boolean sacar(int id, Double quantia) throws Exception{
        ContaBancaria conta = contasBancarias.get(id - 1);
        if(conta != null){
            return conta.sacar(quantia);
        } else {
            return false;
        }
    }

    public List<ContaBancaria> getContasBancarias() {
        return contasBancarias;
    }
}
