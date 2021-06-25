import java.util.*;

public class Grafo {
    int nVertex; //numero de vertices
    List<Integer>[] adjacencyList; //lista de adjacencyListacencia

    public Grafo(int nVertex) {
        this.nVertex = nVertex;
        adjacencyList = new LinkedList[nVertex]; //criar as listas de vertices (array de lista)
    }

    public void addEdge(int n1, int n2) {
        //adiciona vertice n2 a lista de vertices adjacencyListacentes de n1
        if (adjacencyList[n1] == null)
            adjacencyList[n1] = new LinkedList<Integer>();
        adjacencyList[n1].add(n2);
    }

    //obtem o grau de saida de um vertice
    public int getDegreeOfOutput(int v) {
        return adjacencyList[v].size();
    }

    //verifica se existe vizinho a partir de um vertice
    public boolean haveNeighbor(int v1, int v2) {
        if (adjacencyList[v1].contains(v2))
            return true;
        return false;
    }

    //busca em largura
    public void breadthFirstSearch(int p){
        Queue<Integer> queue = new LinkedList<>() ;
        boolean visited[] = new boolean[nVertex];

        for(int i=1; i<nVertex; i++)
            visited[i] = false;

        System.out.println("Vertice visitado "+p);
        visited[p] = true;//marca o vertice como visitado
        
        while (true){
            if(adjacencyList[p] != null){
                for(Integer iterator : adjacencyList[p]){
                    if(!visited[iterator]){
                        System.out.println("Visitando vertice: "+iterator);
                        visited[iterator] = true;//marca o vertice como visitado
                        queue.add(iterator);
                    }
                }
            }
            if(!queue.isEmpty() ){
                p = queue.peek();//obtem primeiro elemento da fila
                queue.remove();//remove da fila o primeiro elemento da fila
            }else
                break;
        }
    }

    //busca em profundidade
    public void depthFirstSearch (int p){
        Stack<Integer> pilha = new Stack<>();
        boolean visited[] = new boolean[nVertex];

        //marca todos como não visitados
        for(int i=0; i<nVertex; i++)
            visited[i] = false;

        while (true) {
            if (!visited[p]) {
                System.out.println("Visitando visitado: " + p);
                visited[p] = true;
                pilha.push(p);
            }
            if (adjacencyList[p] != null) {
                boolean found = false;
                Integer iteratorAssistent = null;
                //busca por um vizinho que ainda nao foi visitado
                for (Integer iterator : adjacencyList[p]) {
                    iteratorAssistent = iterator;
                    if (!visited[iterator]) {
                        found = true;
                        break;
                    }
                }
                //nao ta ENTRANDO NO IF
                if (found)
                    p = iteratorAssistent;
                else {
                    pilha.pop();
                    if (pilha.isEmpty())
                        break;
                    p = pilha.peek();
                }
            }else{
                pilha.pop();
                if (pilha.isEmpty())
                    break;
                p = pilha.peek();
            }
        }
    }
}