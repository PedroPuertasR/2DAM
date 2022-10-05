#include <stdio.h>
#include <unistd.h>
void main(){
    printf("Ejemplo de uso de excel:\n");
    printf("Listado del directorio actual.");
    execl("/bin/ls", "ls", "-l", (char*)NULL);
    printf("\n Esta instrucción no se llega a ejecutar.")
}