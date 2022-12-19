#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main(){
    pid_t id_actual, id_padre, pid;

    pid = fork();
    id_actual = getpid();
    id_padre = getppid();

    if(pid == -1){
        printf("Hubo un problema al crear al hijo.");
        exit(-1);
    }
    
    if(pid == 0){
        printf("Soy el proceso hijo.\n");
        printf("Mi PID es %d y el de mi padre %d\n", id_actual, id_padre);
    }else{
        id_actual = wait(NULL);
        printf("Yo soy el padre de la criatura:\n");
        printf("Mi PID es %d, el de mi padre (abuelo de la criatura) es %d.\n", getpid(), id_padre);
        printf("Mi hijo si es de verdad hijo mio deberia tener el PID %d", pid);
    }
    exit(0);
}