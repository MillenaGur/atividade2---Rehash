package listas;

import java.util.Random;

public class HashRe {
    // A tabela deve ser um array de 'No' (referências para as listas ligadas)
    No[] tabela = new No[100];
    int totalcolissao = 0;
    

    // Classe interna para representar um nó da lista
    class No {
        int chave;
        int dado; // Valor armazenado no nó
        No proximo; // Referência para o próximo nó

        // Construtor do nó
        No(int chave) {
            this.chave = chave;
            this.dado = 0;
            this.proximo = null;
        }
    }

    // Método para inserir um elemento na tabela hash encadeada
    public void insereElemento(int chave) {
        int hash = funcaohash(chave);
        No novoNo = new No(chave);

        int tentativa = 0;

        // se a posição estiver vazia o nó é adicionado
        if (tabela[hash] == null) {
            tabela[hash] = novoNo;
        } else {
         // Se já houver colissão faz um hash do hash ate achar uma possisao nula

        while (tabela[hash] != null) {
            tentativa += 1;
            // r(i) = (i + 1) % tabela
            hash = (funcaohash(chave) + tentativa) % tabela.length;

            //se estiver cheio.
            if (tentativa >= (90)) { //para se chegar em 90% do tamanho da tabela
                System.out.println("tabela no limite");
                return;
            }
    }
        // Insere o novo nó 
        novoNo.dado = tentativa;
        totalcolissao += tentativa;
        tabela[hash] = novoNo;
    }
    }

    public int funcaohash(int chave) { //função hash
        return chave % 100;
    }



    // Método para exibir os elementos da lista (para teste)
   public void exibeLista() {

    No[] tres = new No[3];
    int disponivel =0;


    System.out.print("Lista: ");
    
    // percorre toda tabela
    for (int i = 0; i < tabela.length; i++) {
        
        // verificar se possue valor na possisao x da tabela
        if (tabela[i] != null) {
            No atual = tabela[i];
            
            
            if (tres[0].dado < atual.dado){ //guardar os 3 valores do encadeamento numa lista
                    tres[0] = atual;
                    
                }

                else if( tres[1].dado < atual.dado){
                    tres[1] = atual;
                    
                }
                else if(tres[2].dado < atual.dado){
                    tres[2] = atual;
                    
                }

        }else{
            disponivel += 1;
        }

    }
 
    System.out.println("disponivel: " + disponivel);
    System.out.println("total colissão:"+ totalcolissao);
    System.out.println("tres ultimos " + tres[0] + " " + tres[1] + " " + tres[2]);
}
    

    public static void main(String[] args) {
    HashRe hash2 = new HashRe(); 


    Random random = new Random(1090); 

    for (int i = 0; i < 100; i++) { //adicionar os 1000 elementos

        int numeroInt = random.nextInt(10000); 
        hash2.insereElemento(numeroInt); 
    }

    // Exibindo os elementos da lista/tabela
    hash2.exibeLista();
}
}