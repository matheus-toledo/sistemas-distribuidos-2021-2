package Exercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Exercicio2.entidades.Pessoa;

public class Connection extends Thread{
    private Socket socket;

    public Connection(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String nome = dataInputStream.readUTF();

            String sexo = dataInputStream.readUTF();

            int idade = dataInputStream.readInt();

            Pessoa pessoa = new Pessoa(nome, sexo, idade);


            dataOutputStream.writeUTF(pessoa.getNome());
            dataOutputStream.writeUTF(pessoa.getSexo());
            dataOutputStream.writeInt(pessoa.getIdade());
            dataOutputStream.writeBoolean(Pessoa.isPessoaPossuiMaioridade(pessoa));

            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
