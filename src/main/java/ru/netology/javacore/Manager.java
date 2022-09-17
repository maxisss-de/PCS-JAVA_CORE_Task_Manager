package ru.netology.javacore;

public class Manager {

    private String type;
    private String task;

    public Manager(String type, String task) {
        this.type = type;
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "type='" + type + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
