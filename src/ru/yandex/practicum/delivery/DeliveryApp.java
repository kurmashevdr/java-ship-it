package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<FragileParcel> allTrackableParcel = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(100);
    private static final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(100);
    private static final ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(100);

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
                case "4":
                    reportStatus();
                    break;
                case "5":
                    showParcelBox();
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
        System.out.println("4 — Отследить посылку");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже
    public static void showParcelType() {
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящуюся");
    }

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:");
        showParcelType();
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
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAdress, sendDay);
                allParcels.add(standardParcel);
                standardParcelBox.addParcel(standardParcel);
                break;
            case "2":
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAdress, sendDay);
                allParcels.add(fragileParcel);
                allTrackableParcel.add(fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                break;
            case "3":
                System.out.print("Укажите срок годности посылки: ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAdress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Введен некорректный тип посылки.");
        }
    }

    public static void showParcelBox() {
        System.out.print("Выберите тип посылок в коробке: ");
        showParcelType();
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                standardParcelBox.getAllParcels();
                break;
            case "2":
                fragileParcelBox.getAllParcels();
                break;
            case "3":
                perishableParcelBox.getAllParcels();
                break;
            default:
                System.out.println("Введен некорректный тип посылки.");
        }
    }

    public static void reportStatus() {
        System.out.println("Доступные посылки для отслеживания:");
        System.out.println("-".repeat(5));
        for (int i = 0; i < allTrackableParcel.size(); i++) {
            FragileParcel parcel = allTrackableParcel.get(i);
            System.out.println((i + 1) + ". " + parcel.getDescription());
        }
        System.out.print("Введите номер посылки для которой нужно обновить местоположение: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice <= 0 || choice >= allParcels.size()) {
            System.out.println("Введен некорректный номер посылки");
        } else {
            System.out.print("Укажите новое местоположение посылки: ");
            String newLocation = scanner.nextLine();
            FragileParcel parcel = allTrackableParcel.get(choice - 1);
            parcel.reportStatus(newLocation);
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

