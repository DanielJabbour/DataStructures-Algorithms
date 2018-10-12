#include <stdlib.h>
#include <stdio.h>
#define qSize 50
#define stackSize 50

typedef struct node {
    int vertex;
    struct node* next;
} node;

typedef struct graph {
    int vertexCount;
    int *visited;
    node **list;
} graph;

typedef struct queue {
    int items[qSize];
    int front;
    int back;
} queue;

typedef struct stack {
    int items[stackSize];
    int front;
    int back;
} stack;

graph* createGraph(int vertexCount);
node* createNode(int v);
queue* createQueue();
stack* createStack();
void addEdge(graph* graph, int sourceNode, int destinationNode);
void printGraph(graph* graph);
void DFS(graph* graph, int startVertex);
void BFS(graph* graph, int startVertex);
int cycleBuster(graph* graph, int startVertex);
int cycler(graph* graph);
void enqueue(queue* queue, int val);
int dequeue(queue* queue);
int qIsEmpty(queue* queue);
void push(stack* stack, int val);
int pop(stack* stack);
int top(stack* stack);
int stackIsEmpty(stack* stack);

int main(){

    graph* new_graph = createGraph(4);

    //Cyclic loop
    // addEdge(new_graph, 0, 1);
    // addEdge(new_graph, 0, 2);
    // addEdge(new_graph, 1, 3);
    // addEdge(new_graph, 2, 4);
    // addEdge(new_graph, 4, 0);

    addEdge(new_graph, 0, 1);
    addEdge(new_graph, 1, 2);
    addEdge(new_graph, 2, 3);
    addEdge(new_graph, 1, 3);
    //addEdge(new_graph, 3, 1);

    
    printf("Cycle BUSTER: %d\n", cycler(new_graph));

    return 0;
}

int cycleBuster(graph* graph, int startVertex){

    graph->visited[startVertex] = 1; //Current vertex being processed, let it be gray
    node* travNode = graph->list[startVertex];
    printf("Visited: %d\n", startVertex);

    //Now go through all adjacent verticies
    while(travNode!=NULL){
        int connectedVertex = travNode->vertex;

        if(graph->visited[connectedVertex] == 1)
            return 1;

        if(graph->visited[connectedVertex] == 0 && cycleBuster(graph, connectedVertex) == 1)
            return 1;

        travNode = travNode->next;
    }

    graph->visited[startVertex] = 2;
    return 0;
}

int cycler(graph* graph){
    //Let visited = 0 be white, visited = 1 be gray, and visited = 2 be black

    for(int i=0;i<graph->vertexCount;i++){
        if(graph->visited[i] == 0){
            if(cycleBuster(graph, i) == 1)
                return 1;
        }
    }

    return 0;
}


graph* createGraph(int vertexCount){

    graph* new_graph = (graph*)malloc(sizeof(graph));

    new_graph->vertexCount = vertexCount;
    new_graph->list = malloc(vertexCount * sizeof(node));
    new_graph->visited = malloc(vertexCount * sizeof(int));

    for(int i=0;i<vertexCount;i++){
        new_graph->list[i] = NULL;
        new_graph->visited[i] = 0;
    }

    return new_graph;
}

node* createNode(int v){

    node* new_node = (node*)malloc(sizeof(node));

    new_node->vertex = v;
    new_node->next = NULL;

    return new_node;
}

void addEdge(graph* graph, int sourceNode, int destinationNode){

    node* node_edge = createNode(destinationNode);
    node_edge->next = graph->list[sourceNode];
    graph->list[sourceNode] = node_edge;

}

void DFS(graph* graph, int startVertex){

    node* travNode = graph->list[startVertex];

    graph->visited[startVertex] = 1;
    printf("Visited %d \n", startVertex);

    while(travNode!=NULL){
        int connectedVertex = travNode->vertex;

        if(graph->visited[connectedVertex] == 0)
            DFS(graph, connectedVertex);

        travNode = travNode->next;
    }
    
}

void BFS(graph* graph, int startVertex){

    int read;
    queue* bfs_queue = createQueue();

    graph->visited[startVertex] = 1;
    enqueue(bfs_queue,startVertex);

    node* travNode = graph->list[startVertex];

    while(!qIsEmpty(bfs_queue)){
        read = dequeue(bfs_queue);
        printf("Visited %d\n",read);
        node* travNode = graph->list[read];

        while(travNode!=NULL){

            if(graph->visited[travNode->vertex] == 0){
                graph->visited[travNode->vertex] = 1;
                enqueue(bfs_queue, travNode->vertex);
            }

            travNode = travNode->next;
        }
    }
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
            printf("Reset queue\n");
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

stack* createStack(){
    
    stack* new_stack = malloc(sizeof(stack));
    new_stack->front = -1;
    new_stack->back = -1;

    return new_stack;
}

void push(stack* stack, int val){
    if(stack->back == stackSize-1)
        printf("Stack is full!\n");
    else{
        if(stack->front == -1)
            stack->front = 0;
        stack->back++;
        stack->items[stack->back] = val;
    }
}

int pop(stack* stack){

    int popItem;

    if(stackIsEmpty(stack) == 1){
        printf("Stack is emptry!\n");
        popItem = -1;
    }
    else {
        popItem = stack->items[stack->back];
        stack->back--;

        if(stack->back < stack->front){
            printf("Reset Stack\n");
            stack->front = -1;
            stack->back = -1;
        }
    }

    return popItem;
}

int top(stack* stack){
    int topItem;

    if(stackIsEmpty(stack) == 1){
        printf("Stack is emptry!\n");
        topItem = -1;
    }
    else
        topItem = stack->items[stack->back];
    
    return topItem;
}

int stackIsEmpty(stack* stack){
    if(stack->back == -1)
        return 1;
    else
        return 0;
}