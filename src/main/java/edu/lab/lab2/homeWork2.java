package edu.lab.lab2;

import java.util.Scanner;
import java.util.Random;

public class homeWork2 {
    private static final int MAX_SIZE = 20;
    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 100;

    private int[][] matrix;
    private int width;
    private int height;

    public static void main(String[] args) {
        homeWork2 homeWork = new homeWork2();
        homeWork.run();
    }

    public void run() {
        readMatrixSize();
        createMatrix();
        printMatrix();
        findMinMax();
        calculateAverage();
    }

    private void readMatrixSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ширину матриці (не більше " + MAX_SIZE + "): ");
        width = scanner.nextInt();

        System.out.print("Введіть висоту матриці (не більше " + MAX_SIZE + "): ");
        height = scanner.nextInt();
    }

    private void createMatrix() {
        matrix = new int[height][width];
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Виберіть спосіб створення матриці:");
        System.out.println("1. Ввести елементи з клавіатури");
        System.out.println("2. Заповнити рандомними числами");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print("Введіть елемент [" + i + "][" + j + "]: ");
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                break;
            case 2:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        matrix[i][j] = random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
                    }
                }
                break;
            default:
                System.out.println("Некоректний вибір. Завершення програми.");
                System.exit(0);
        }
    }

    private void printMatrix() {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    private void findMinMax() {
        int min = matrix[0][0];
        int max = matrix[0][0];

        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
                if (element > max) {
                    max = element;
                }
            }
        }

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
    }

    private void calculateAverage() {
        int sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }

        double average = (double) sum / count;
        System.out.println("Середнє арифметичне: " + average);
    }
}
