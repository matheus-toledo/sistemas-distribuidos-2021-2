package Exercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Exercicio1.entidades.Funcionario;

public class Connection extends Thread {
    private Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String nome = dataInputStream.readUTF();

            String cargo = dataInputStream.readUTF();

            double salario = dataInputStream.readDouble();

            Funcionario funcionario = new Funcionario(nome, cargo, salario);

            funcionario.reajustaSalario();

            dataOutputStream.writeUTF(funcionario.getNome());
            dataOutputStream.writeUTF(funcionario.getCargo());
            dataOutputStream.writeDouble(funcionario.getSalario());

            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
