package com.pro.server;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerConfiguration {

	private ServerSocket serverSocket;

	public SocketServerConfiguration() {
		try {
			serverSocket = new ServerSocket(5000);
			System.out.println("Servidor aguardando conexões...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}
}
