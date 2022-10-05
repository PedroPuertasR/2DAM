#include <stdio.h>
#include <stdlib.h>

void main(){
    printf("Ejemplo de uso system():\n");
    printf("Listado del directorio actual y envio a un fichero:");
    printf("%d", system("ls > ficherosalida.txt"));
    printf("\nAbrimos el fichero...");
    printf("%d", system("nano ficherosalida.txt"));
    printf("\nEste comando es erroneo: %d", system("msword"));
    printf("\nFin del programa");
}