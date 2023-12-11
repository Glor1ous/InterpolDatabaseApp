package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class InterpolDatabaseApp {
    public static void main(String[] args) {
        InterpolDatabase interpolDatabase = new InterpolDatabase();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в базу данных Интерпола!");

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Добавить преступника");
            System.out.println("2 - Поиск преступника");
            System.out.println("3 - Удалить преступника");
            System.out.println("4 - Просмотреть базу данных");
            System.out.println("5 - Выйти из программы");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищаем буфер после ввода числа

            switch (choice) {
                case 1:
                    Criminal criminal = createCriminal(scanner);
                    interpolDatabase.addCriminal(criminal);
                    System.out.println("\nПреступник успешно добавлен.");
                    break;
                case 2:
                    searchCriminal(interpolDatabase, scanner);
                    break;
                case 3:
                    deleteCriminal(interpolDatabase, scanner);
                    break;
                case 4:
                    viewInterpolDatabase(interpolDatabase);
                    break;
                case 5:
                    System.out.println("До свидания!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, введите правильное число.");
            }
        }
    }

    private static Criminal createCriminal(Scanner scanner) {
        System.out.println("\n=== Добавление нового преступника ===");
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();

        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();

        System.out.println("Введите кличку: ");
        String nickname = scanner.nextLine();

        int height = 0;
        boolean validHeight = false;
        while (!validHeight) {
            System.out.println("Введите рост: ");
            try {
                height = Integer.parseInt(scanner.nextLine());
                validHeight = true;
            } catch (NumberFormatException e) {
                System.out.println("Рост должен быть целым числом.");
            }
        }

        System.out.println("Введите цвет волос: ");
        String hairColor = scanner.nextLine();

        System.out.println("Введите особые приметы: ");
        String distinctiveFeatures = scanner.nextLine();

        System.out.println("Введите гражданство: ");
        String citizenship = scanner.nextLine();

        System.out.println("Введите место и дату рождения: ");
        String birthInfo = scanner.nextLine();

        System.out.println("Введите преступную профессию: ");
        String criminalProfession = scanner.nextLine();

        System.out.println("Введите последнее дело: ");
        String lastCrime = scanner.nextLine();

        return new Criminal(lastName, firstName, nickname, height, hairColor, distinctiveFeatures, citizenship, birthInfo, criminalProfession, lastCrime);
    }

    private static void searchCriminal(InterpolDatabase interpolDatabase, Scanner scanner) {
        System.out.println("\n=== Поиск преступника ===");
        System.out.println("Выберите параметр для поиска:");
        System.out.println("1 - По фамилии");
        System.out.println("2 - По имени");
        System.out.println("3 - По кличке");
        System.out.println("4 - По гражданству");
        System.out.println("5 - По преступной профессии");
        int searchOption = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите значение для поиска: ");
        String searchValue = scanner.nextLine();

        ArrayList<Criminal> foundCriminals = interpolDatabase.searchCriminals(searchOption, searchValue);

        if (!foundCriminals.isEmpty()) {
            System.out.println("\nНайденные преступники:");
            for (Criminal criminal : foundCriminals) {
                System.out.println(criminal.toString());
            }
        } else {
            System.out.println("Преступники по заданным критериям не найдены.");
        }
    }

    private static void deleteCriminal(InterpolDatabase interpolDatabase, Scanner scanner) {
        System.out.println("\n=== Удаление преступника ===");
        System.out.println("Введите фамилию преступника, которого вы хотите удалить: ");
        String lastNameToDelete = scanner.nextLine();

        if (interpolDatabase.deleteCriminal(lastNameToDelete)) {
            System.out.println("Преступник удален.");
        } else {
            System.out.println("Преступник с указанной фамилией не найден.");
        }
    }

    private static void viewInterpolDatabase(InterpolDatabase interpolDatabase) {
        System.out.println(interpolDatabase.toString());
    }
}