
package clientecalculadora;


import Calculadora.Calculadora;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;

public class ClienteCalculadora {
    
    public static void main(String[] args) throws IOException, InterruptedException{
        String HOST = "localhost";
        int PORT = 9090;
        
        if (args.length == 2) {
            
            HOST = args[0];
            PORT = Integer.parseInt(args[1]);
        }
        
        TSocket transporte = new TSocket(HOST, PORT);
        TBinaryProtocol protocolo = new TBinaryProtocol(transporte);
        Calculadora.Client cliente = new Calculadora.Client(protocolo);
        
        try{
            transporte.open();
            Scanner leer = new Scanner(System.in);
            int opcion = 0;
            try{
                while(opcion != 5){
                int numeroA, numeroB;
                String resultado;
                
                System.out.println("------------------------------------------");
                System.out.println("Seleccione la operación que desea realizar");
                System.out.println("1.- Adición");
                System.out.println("2.- Substracción");
                System.out.println("1.- Multiplicación");
                System.out.println("2.- División");
                System.out.println("5.- Salir");
                System.out.println("------------------------------------------");
             
                opcion = leer.nextInt();
             
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese su primer numero:");
                        numeroA = leer.nextInt();
                        System.out.println("Ingrese su segundo numero:");
                        numeroB = leer.nextInt();
                        resultado = cliente.sumar(numeroA, numeroB);
                        System.out.println("Resultado: "+resultado);
                        break;
                    case 2:
                        System.out.println("Ingrese su primer numero:");
                        numeroA = leer.nextInt();
                        System.out.println("Ingrese su segundo numero:");
                        numeroB = leer.nextInt();
                        resultado = cliente.restar(numeroA, numeroB);
                        System.out.println("Resultado: "+resultado);
                        break;
                    case 3:
                        System.out.println("Ingrese su primer numero:");
                        numeroA = leer.nextInt();
                        System.out.println("Ingrese su segundo numero:");
                        numeroB = leer.nextInt();
                        resultado = cliente.multiplicar(numeroA, numeroB);
                        System.out.println("Resultado: "+resultado);
                        break;
                    case 4:
                        System.out.println("Ingrese su primer numero:");
                        numeroA = leer.nextInt();
                        System.out.println("Ingrese su segundo numero:");
                        numeroB = leer.nextInt();
                        resultado = cliente.dividir(numeroA, numeroB);
                        System.out.println("Resultado: "+resultado);
                        break;
                    case 5:
                        System.out.println("Hasta luego");
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5");   
                    }
                }
            }catch(InputMismatchException e){
            System.out.println("Debes insertar un numero");
            leer.next();
            }    
        }catch(TException e){
            System.out.println(e.getMessage());
        }
    }
    
}

