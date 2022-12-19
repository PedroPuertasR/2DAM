#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void main(void) {

    int fd[2];
    char buffer[30];
    pid_t pid;
    pipe (fd);
    pid = fork();

    switch(pid) {
        case -1:
            printf("Fallo al crear al hijo.\n");
            exit(-1);
            break;
        case 0:
            printf("Soy el hijo y escribo en el pipe.\n");
            write(fd[1], "Hola papa", 10);
            break;
        default:
            wait(NULL);
            printf("Soy el padre y leo en el pipe\n");
            read(fd[0], buffer, 10);
            printf("Mensaje recibido: %s.\n", buffer);
            break;
    }
}