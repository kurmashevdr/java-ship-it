package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addParcel();
                    break;
                case "2":
                    sendParcels();
                    break;
                case "3":
                    calculateCosts();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящуюся");
        String choice = scanner.nextLine();
        System.out.print("Введите описание посылки: ");
        String description = scanner.nextLine();
        System.out.print("Укажите вес посылки: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите адрес назначения: ");
        String deliveryAdress = scanner.nextLine();
        System.out.print("Укажите дату отправки: ");
        int sendDay = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case "1":
                allParcels.add(new StandardParcel(description, weight, deliveryAdress, sendDay));
                break;
            case "2":
                allParcels.add(new FragileParcel(description, weight, deliveryAdress, sendDay));
                break;
            case "3":
                System.out.print("Укажите срок годности посылки:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                allParcels.add(new PerishableParcel(description, weight, deliveryAdress, sendDay, timeToLive));
                break;
                default:
                    System.out.println("Введен некорректный тип посылки.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая сумма всех доставок: " + totalCost);
    }

}

