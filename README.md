# Calculadora Cliente-Servidor con Apache Thrift

## Instrucciones para ejecutar el proyecto

## 1. Servidor
1.1 Entra a tu consola de comandos. 
1.2 Dirigete a la carpeta en donde clonaste el proyecto, posteriormente a la carpeta Servidor
1.3 Escribe en tu consola de comandos lo siguiente:
    ```
    Thrift -r --gen py ./calc.thrift
    ```
1.4 Escribe en tu consola de comandos lo siguiente para iniciar el servidor:
    ```
    python ./calcServer.py
    ```

## 2. Cliente
2.1 Entra a tu consola de comandos.
2.2 Dirigete a la carpeta en donde clonaste el protecto, posteriormente a la carpeta Clienta
2.3 Escribe en tu consola de comandos lo siguiente:
    ```
    Thrift -r --gen java ./calc.thrift
    ```
2.4 Escribe en tu consola de comandos lo siguiente para compilar el cliente:
    ```
    javac CalcClient.java
    ```
2.5 Escribe en tu consola de comandos lo siguiente para iniciar el cliente:
    ```
    java CalcClient.java
    ```
