package Exercicio2;

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
            String sexo;
            String nome;
            int idade;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Escreva o nome da pessoa");
            nome = scanner.next();

            System.out.println("Escreva o sexo da pessoa");
            sexo = scanner.next();

            System.out.println("Escreva a idade da pessoa");
            idade = scanner.nextInt();

            dataOutputStream.writeUTF(nome);
            dataOutputStream.writeUTF(sexo);
            dataOutputStream.writeInt(idade);

            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readInt());
            if(dataInputStream.readBoolean()){
                System.out.println("É maior de idade");
            } else {
                System.out.println("Não é maior de idade");
            }

            socket.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();

        }
    }
}
