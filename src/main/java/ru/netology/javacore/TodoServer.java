package ru.netology.javacore;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TodoServer {

    public static final String add = "ADD";
    public static final String remove = "REMOVE";

    private int port = 8989;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream())

                ) {
                    System.out.printf("Новое подключение, Port: %d%n", socket.getPort());
                    String json = in.readLine();
                    Gson gson = new Gson();
                    Manager Manager = gson.fromJson(json, Manager.class);
                    switch (Manager.getType()) {
                        case add:
                            todos.addTask(Manager.getTask());
                            break;
                        case remove:
                            todos.removeTask(Manager.getTask());
                            break;
                    }
                    out.println(todos.getAllTasks());
                    System.out.println(Manager);
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
