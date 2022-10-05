#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main(){
    pid_t id_actual, id_padre, pid;

    pid = fork();
    id_actual = getpid();
    id_padre = getppid();

    if(pid == -1){
        printf("Hubo un problema al crear al hijo.\n");
        exit(-1);
    }
    if(pid == 0){
        printf("Soy el proceso hijo\n");
        printf("Mi PID es %d, y el del padre %d\n", id_actual, id_padre);
    }else{
        printf("Yo soy el padre de la criatura.\n");
        printf("Mi PID es %d, el de mi padre (abuelo de la criatura) es %d\n", id_actual, id_padre);
        printf("Mi hijo si es de verdad hijo mío debería tener el PID %d\n", pid);
    }
    exit(0);
}