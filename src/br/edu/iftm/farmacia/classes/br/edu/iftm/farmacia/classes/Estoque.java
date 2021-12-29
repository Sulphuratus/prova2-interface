
package br.edu.iftm.farmacia.classes;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;


public class Estoque {

    static DecimalFormat df = new DecimalFormat("##.###");
   
    public Estoque (Medicamento med, int cod){
    }

    public int cadastrarProduto(Produto p[], int cod) {
        return 0;
    }
       

    public static void alterarProduto(Produto p[],int cod){

    }// fim alterarDadosDeUmProduto

    public static void mostrarEstoque(Produto p[], int cod){
        String msg = "";
        
        for (int cont = 0; cont < cod; cont++){
            msg = msg + "\n-------------------------------------------------";
            msg = msg + "\nCodigo: " + p[cont].getCodigoNumerico();
            msg = msg + "\nDescrição: " + p[cont].getNome();
            msg = msg + "\nPreço de tabela: " + p[cont].getPreco();
            msg = msg + "\nPrazo para o vencimento: " + p[cont].calcularVencimento() +" dias";
            msg = msg + "\nPreço de Venda: " + df.format(p[cont].precoAtual);
            JOptionPane.showMessageDialog(null, msg);
        }

    }

    public static int mostrarMenorValidade(Produto p[], int cod){
        //float maiorPreco;
        int indice, menorValidade, cont;
        //String msg = "";
        menorValidade = p[0].calcularVencimento();
        indice = 0;

        for (cont = 1; cont < cod; cont ++){
            if (p[cont].calcularVencimento() < menorValidade){
            menorValidade = p[cont].calcularVencimento();
            indice = cont;
            }
        }

        return indice;

    }//fim mostraMenorValidade
    
}