package ru.netology.javacore;

import org.junit.jupiter.api.*;

public class TodosTests {

    private static long startTime;
    private long startTimeNewTest;

    @BeforeAll
    public static void startTests() {
        System.out.println("BeforeAll:");
        System.out.println("Начало Тестов");
        startTime = System.nanoTime();
        System.out.println();
    }

    @AfterAll
    public static void completeTests() {
        System.out.println("AfterAll:");
        long outputData = System.nanoTime() - startTime;
        System.out.println("Тест завершен: " + outputData / 5_000_000 + " миллисекунд(а)ы");
        System.out.println();
    }

    @BeforeEach
    public void startNewTest() {
        System.out.println("BeforeEach:");
        System.out.println("Запуск нового Теста");
        startTimeNewTest = System.nanoTime();
        System.out.println();
    }

    @AfterEach
    public void endTest() {
        System.out.println("AfterEach:");
        long outputData = System.nanoTime() - startTimeNewTest;
        System.out.println("Тест весь пройден: " + outputData / 5_000_000 + " миллисекунд(а)ы");
        System.out.println();
    }

    @Test
    public void removeTest() {
        System.out.println("Тест №1");
        Todos todos = new Todos();
        todos.addTask("Проверка add & remove");
        todos.removeTask("Проверка add & remove");
        boolean task = todos.getAllTasks().contains("Проверка add & remove");
        Assertions.assertFalse(task);
        System.out.println();
    }

    @Test
    public void addTrueTest() {
        System.out.println("Тест №2");
        Todos todos = new Todos();
        todos.addTask("Проверка на true");
        boolean task = todos.getAllTasks().contains("Проверка на true");
        Assertions.assertTrue(task);
        System.out.println();
    }

    @Test
    public void addFalseTest() {
        System.out.println("Тест №3");
        Todos todos = new Todos();
        todos.addTask("Проверка на false");
        boolean task = todos.getAllTasks().contains("Проверка на false != true)");
        Assertions.assertFalse(task);
        System.out.println();
    }
}
