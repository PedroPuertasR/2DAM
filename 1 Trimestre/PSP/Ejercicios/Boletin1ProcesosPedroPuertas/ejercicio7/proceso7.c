#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main(){
    pid_t hijo, padre, pid;
    int a;
    a = 6;

    pid = fork();
    hijo = getpid();
    padre = getppid();

    if(pid == -1){
        printf("Error al crear el hijo.\n");
        exit(-1);
    }

    if(pid == 0){
        printf("Soy el hijo e incremento la variable en 5.\n");
        a += 5;
        printf("Valor: %d. PID: %d.\n", a, hijo);
    }else{
        wait(NULL);
        printf("Soy el padre y le resto 5 a la variable.\n");
        a -= 5;
        printf("Valor: %d. PID: %d.\n", a, padre);
    }
}