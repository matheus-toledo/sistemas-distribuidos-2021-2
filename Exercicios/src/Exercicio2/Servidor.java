package Exercicio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private static final int SERVER_PORT = 8080;
    private Socket cliente;
    private Connection connection;

    public Servidor() {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

            System.out.println("Servidor ouvindo a porta: " + SERVER_PORT);

            while (true) {
                cliente = serverSocket.accept();
                connection = new Connection(cliente);
                connection.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
    }

}
