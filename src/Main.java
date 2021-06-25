public class Main {

    public static void main(String[] args) {

        Grafo grafo = new Grafo(16);

        grafo.addEdge(8, 4);
        grafo.addEdge(8, 12);
        grafo.addEdge(4, 2);
        grafo.addEdge(4, 6);
        grafo.addEdge(12, 10);
        grafo.addEdge(12, 14);
        grafo.addEdge(2, 1);
        grafo.addEdge(2, 3);
        grafo.addEdge(6, 5);
        grafo.addEdge(10, 11);
        grafo.addEdge(14, 13);
        grafo.addEdge(14, 15);

        System.out.println("----------------- Busca em profundidade -----------------");
        grafo.depthFirstSearch(8);

        System.out.println("----------------- Busca em largura -----------------");
        grafo.breadthFirstSearch(8);

    }
}