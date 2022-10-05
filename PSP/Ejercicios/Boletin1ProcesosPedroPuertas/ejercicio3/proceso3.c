#include <unistd.h>
#include <stdio.h>

void main(){
    pid_t id_actual, id_padre;
    id_actual = getpid();
    id_padre = getppid();

    printf("El pid actual es: %d", id_actual);
    printf("\nEl pid del padre es: %d", id_padre);
}