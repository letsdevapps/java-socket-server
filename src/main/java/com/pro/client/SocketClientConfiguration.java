package com.pro.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClientConfiguration {

	private Socket clientSocket;

	public SocketClientConfiguration(Socket accept) {
		try {
			clientSocket = accept;
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			// Lê a mensagem JSON
			String line = in.readLine();
			JSONObject json = new JSONObject(line);
			System.out.println("Recebido: " + json.getString("text"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Socket getClientSocket() {
		return clientSocket;
	}
}