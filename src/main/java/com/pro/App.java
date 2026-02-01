package com.pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONObject;

public class App {
	public static void main(String[] args) {
		System.out.println("----- Java Socket Server | Main -----");

		try {
			// Cria o servidor na porta 5000
			ServerSocket serverSocket = new ServerSocket(5000);
			System.out.println("Servidor aguardando conexões...");

			// Loop para continuar aceitando conexões
			while (true) {
				// Recepção de clientes, auto-bloqueante por natureza, por isso fica fora da thread
				Socket clientSocket = serverSocket.accept();
				System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

				new Thread(() -> {
					try (
							// Leitura e escrita de dados
							BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
							PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);) {

						// Lê a mensagem do cliente
						String line = in.readLine();
						if (line == null)
							return;

						JSONObject json = new JSONObject(line);
						System.out.println("Recebido: " + json.optString("text"));

						// Envia a resposta para o cliente
						out.println("Mensagem recebida com sucesso!");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							// Fecha a conexão com o cliente, mas o servidor continua aguardando
							clientSocket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
