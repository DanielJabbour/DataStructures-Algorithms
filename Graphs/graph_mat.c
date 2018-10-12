#include <stdio.h>
#include <stdlib.h>
#define MAX 100;

struct graph{
    int vertexCount;
    int** adj;
} graph;

struct graph* createGraph(int nodes);
void printGraph(struct graph* graph);
void addEdge(struct graph* graph, int source, int destination);

int main() {

    struct graph* adj_matr = createGraph(5);
    // addEdge(adj_matr, 3, 2);
    // addEdge(adj_matr, 3, 1);
    // addEdge(adj_matr, 3, 0);

    printGraph(adj_matr);

    return 0;
}

void addEdge(struct graph* graph, int source, int destination){

    //Undirected
    graph->adj[source][destination] = 1;
    graph->adj[destination][source] = 1;

}

struct graph *createGraph(int nodes) {

    struct graph * tmp = &graph;
    int r = nodes, c = nodes, i, j, count;

    //arr[r][c]
    graph.adj = (int **)malloc(r * sizeof(int *));

    for (i=0; i<r; i++){
        *(graph.adj + i) = (int *)malloc(c * sizeof(int));
         //arr[i] = (int *)malloc(c * sizeof(int));
    }

    //count = 0;
    // for (i = 0; i <  r; i++)//3
    //     for (j = 0; j < c; j++)//4
    //         graph.adj[i][j] = ++count;  // OR *(*(arr+i)+j) = ++count

    return tmp;

}

void printGraph(struct graph* graph){

    struct graph * tmp = graph;
    
    for (int i=0;i<tmp->vertexCount;i++){
        printf("\n");
        for (int j=0;j<tmp->vertexCount;j++){
            printf("%d", tmp->adj[i][j]);
        }
    }
}