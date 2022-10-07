#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

void main(void) {
    char saludoPadre[]="Buenos días padre.\0";
    char buffer[30];

    int fd[2];
    pipe(fd);

    pid_t pid;

    pid = fork();

    switch(pid){
        case -1:
            printf("Error al crear el hijo.\n");
            exit(-1);
            break;
        case 0:
            close(fd[0]);
            printf("Soy el hijo y escribo en el pipe.\n");
            write(fd[1], saludoPadre, strlen(saludoPadre));
            wait(NULL);
            break;
        default:
            close(fd[1]);
            printf("Soy el padre y leo el pipe.\n");
            read(fd[0], buffer, sizeof(buffer));
            printf("El mensaje es: %s.\n", buffer);
            break;
    }
}