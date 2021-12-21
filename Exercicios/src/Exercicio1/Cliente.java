package Exercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String cargo;
            String nome;
            double salario;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Escreva o nome do funcionário");
            nome = scanner.next();

            System.out.println("Escreva o cargo do funcionário");
            cargo = scanner.next();

            System.out.println("Escreva o salário do funcionário");
            salario = scanner.nextDouble();

            dataOutputStream.writeUTF(nome);
            dataOutputStream.writeUTF(cargo);
            dataOutputStream.writeDouble(salario);

            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readDouble());

            socket.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();

        }
    }

}
