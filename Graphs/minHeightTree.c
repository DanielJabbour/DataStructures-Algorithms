#include <stdio.h>
#include <stdlib.h>

#define qSize 50

typedef struct node {
    int vertex;
    struct node* next;
} node;

typedef struct graph {
    int vertexCount;
    int *visited;
    int *degree;
    node **list;
} graph;

typedef struct queue {
    int items[qSize];
    int front;
    int back;
} queue;

node* createNode(int v);
graph* createGraph(int vertexCount);
queue* createQueue();
void addEdge(graph* graph, int* edges);
void enqueue(queue* queue, int val);
int dequeue(queue* queue);
int qIsEmpty(queue* queue);
void printGraph(graph* graph);
int* BFS(graph* graph);

int* findMinHeightTrees(int n, int** edges, int edgesRowSize, int edgesColSize, int* returnSize) {
    
    graph* new_graph = createGraph(n);
    
    for(int i=0;i<edgesRowSize;i++){
        addEdge(new_graph,edges[i]);
    }
    
    //BFS(new_graph);
    
    int* returnArr = BFS(new_graph);
    if(returnArr[1] == NULL)
        *returnSize = 1;
    else
        *returnSize = 2;
    return returnArr;
}
 
int* BFS(graph* graph){
    
    int* returnArr = (int*)malloc(2*sizeof(int));
    queue* leaves_queue = createQueue();
    
    int count = 0;
    //Push all leaves to queue
    for(int i=0;i<graph->vertexCount;i++){
        if(graph->degree[i] == 1){
            enqueue(leaves_queue, i);
            count++;
        }
    }
            
    //Remove leaves from tree till 2 verticies left
    while(graph->vertexCount > 2){
        for(int i=0;i<count;i++){
            int leaf = dequeue(leaves_queue);
            graph->vertexCount--;
            
            //Go through all it's children and decrease their degree
            node* travNode = graph->list[leaf];
            
            while(travNode!=NULL){
                int connectedVertex = travNode->vertex;
                graph->degree[connectedVertex]--;
                
                if(graph->degree[connectedVertex] == 1)
                    enqueue(leaves_queue, connectedVertex);
                
                travNode = travNode->next;
            }
            
            free(graph->list[leaf]);
            free(travNode);
        }

    }//end
    
    int j = 0;
    while(!qIsEmpty(leaves_queue)){
        returnArr[j] = dequeue(leaves_queue);
        j++;
    }
    
    return returnArr;
}

//Utility
graph* createGraph(int vertexCount){
    
    graph* new_graph = malloc(sizeof(graph));
    
    new_graph->vertexCount = vertexCount;
    new_graph->list = malloc(vertexCount*sizeof(node));
    new_graph->visited = malloc(vertexCount * sizeof(int));
    new_graph->degree = malloc(vertexCount * sizeof(int));
    
    for(int i=0;i<vertexCount;i++){
        new_graph->list[i] = NULL;
        new_graph->visited[i] = 0;
        new_graph->degree[i] = 0;
    }
    
    return new_graph;
}

node* createNode(int vertex){
    
    node* new_node = (node*)malloc(sizeof(node));
    new_node->vertex = vertex;
    new_node->next = NULL;
    
    return new_node;
}

void addEdge(graph* graph, int* edges){
    
    //Undirected
    int source = edges[0];
    int destination = edges[1];
    
    node* new_node1 = createNode(destination);
    new_node1->next = graph->list[source];
    graph->list[source] = new_node1;
    
    node* new_node2 = createNode(source);
    new_node2->next = graph->list[destination];
    graph->list[destination] = new_node2;
    
    graph->degree[source]++;
    graph->degree[destination]++;
}


void printGraph(graph* graph){
    for(int i=0; i<graph->vertexCount; i++){
        node* travNode = graph->list[i];
        printf("%d->", i);
        while(travNode!=NULL){   
            printf("%d->",travNode->vertex);
            travNode = travNode->next;
        }
        printf("\n");

    }
}

queue* createQueue() {

    queue* new_queue = malloc(sizeof(queue));
    new_queue->front = -1;
    new_queue->back = -1;

    return new_queue;
}

void enqueue(queue* queue, int val){
    if(queue->back == qSize-1)
        printf("Queue is full!\n");
    else {
        if(queue->front == -1)
            queue->front = 0;
        queue->back++;
        queue->items[queue->back] = val;
    }
}

int dequeue(queue* queue){

    int qItem;

    if (qIsEmpty(queue)){
        printf("Queue is empty!\n");
        qItem = -1;
    }

    else {
        qItem = queue->items[queue->front];
        queue->front++;

        if(queue->front > queue->back) {
            //printf("Reset queue\n");
            queue->front = -1;
            queue->back = -1;
        }
    }

    return qItem;
}

int qIsEmpty(queue* queue){
    if(queue->back==-1)
        return 1;
    else
        return 0;
}
