#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int vertex;
    struct node* next;
} node;

typedef struct graph {
    int vertexCount;
    int *visited;
    node **list;
} graph;

graph* createGraph(int vertexCount);
node* createNode(int vertex);
void addEdge(graph* graph, int sourceNode, int destinationNode);
void DFS(graph* graph, int startVertex);
int** sourceToNode(graph* graph, int startVertex, int endVertex, int* pathArr, int pathArrCount, int** returnArr, int returnArrCount);

int main() {

    graph* new_graph = createGraph(4);

    addEdge(new_graph, 0, 1);
    addEdge(new_graph, 0, 2);
    addEdge(new_graph, 1, 3);
    addEdge(new_graph, 2, 3);

    int** new_arr = (int**)malloc(2*sizeof(int*));
    for(int i=0;i<2;i++)
        new_arr[i] = (int*)malloc(2*sizeof(int));

    int* path_arr = (int*)malloc(2*sizeof(int));

    return 0;
}


graph* createGraph(int vertexCount){

    graph* new_graph = (graph*)malloc(sizeof(graph));

    new_graph->visited = malloc(vertexCount*sizeof(int));
    new_graph->list = malloc(vertexCount*sizeof(node));
    new_graph->vertexCount = vertexCount;

    for(int i=0;i<vertexCount;i++){
        new_graph->list[i] = NULL;
        new_graph->visited[i] = 0;
    }

    return new_graph;
}

node* createNode(int vertex){

    node* new_node = (node*)malloc(sizeof(node));

    new_node->vertex = vertex;
    new_node->next = NULL;

    return new_node;
}

void addEdge(graph* graph, int sourceNode, int destinationNode){

    node* new_edge = createNode(destinationNode);
    new_edge->next = graph->list[sourceNode];
    graph->list[sourceNode] = new_edge;
}

void DFS(graph* graph, int startVertex){

    node* travNode = graph->list[startVertex];
    graph->visited[startVertex] = 1;
    printf("Visited: %d\n", startVertex);

    while(travNode!=NULL){
        int connectedVertex = travNode->vertex;

        if(graph->visited[connectedVertex] == 0)
            DFS(graph, connectedVertex);
        
        travNode = travNode->next;
    }

}

