#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main(){
    pid_t hijo_pid, pid, pid2, id_actual;

    pid = fork();

    if(pid == -1){
        printf("Hubo un error al crear el hijo.\n");
        exit(-1);
    }
    if(pid == 0){
        pid2 = fork();
        switch(pid2){
            case -1:
                printf("No se ha podido crear el proceso nieto en el hijo.\n");
                exit(-1);
                break;
            case 0:
                printf("Soy el proceso nieto %d, mi padre es %d\n", getpid(), getppid());
                break;
            default:
                hijo_pid = wait(NULL);
                printf("Soy el proceso hijo %d, mi padre es %d\n", getpid(), getppid());
                printf("Mi hijo %d terminó.\n", hijo_pid);
        }
    }else{
        id_actual = wait(NULL);
        printf("Yo soy el abuelo de las dos criaturas anteriores.\n");
        printf("Mi PID es %d, el de mi padre (Sistema operativo) es %d.\n", getpid(), getppid());
        printf("Mi hijo si de verdad es hijo mio deberia tener el PID %d\n",  pid);
        printf("A mi nieto no lo puedo conocer, solo reconozco a mi generación inmediata.\n");
        printf("Para conocer a mi nieto debería implementar algún sistema de comunicación entre procesos.\n");
    }
    exit(0);
}