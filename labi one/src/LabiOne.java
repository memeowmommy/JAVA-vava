import java.util.Objects;
import java.util.Scanner;


public class LabiOne {
    Scanner in = new Scanner(System.in);

    String TaskOne() {
        System.out.print("\n1. Сиракузская последовательность\nВведите число n: ");
        int n = in.nextInt();
        int i = 0;
        while (n != 1) {
            ++i;
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        }
        return "Количество шагов: " + i;
    }

    String TaskTwo() {
        System.out.print("\n2. Сумма ряда\nВведите n чисел : ");
        int n = in.nextInt();
        int Sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                Sum += in.nextInt();
            } else {
                Sum -= in.nextInt();
            }
        }
        return "Знакочередующуюся сумма ряда: " + Sum;
    }

    String TaskThree() {
        System.out.print("\n3. Ищем клад \nКоординаты клада по оси x и по оси y:\n");
        int x = in.nextInt();
        int y = in.nextInt();
        int current_X = 0;
        int current_Y = 0;
        String destination = "";
        int count = 0;
        while (true) {
            if (in.hasNextInt()) { //hasNextInt() возвращает true, если с потока ввода можно считать целое число
                int current_Value = in.nextInt();
                if (x == current_X & y == current_Y) {
                    continue;
                } else {
                    switch (destination) {
                        case "север":
                            current_Y += current_Value;
                            break;
                        case "юг":
                            current_Y -= current_Value;
                            break;
                        case "запад":
                            current_X -= current_Value;
                            break;
                        case "восток":
                            current_X += current_Value;
                            break;
                        default:
                            throw new RuntimeException("Ошибка!");
                    }
                    ++count;
                }
            } else {
                destination = in.nextLine();
                if (Objects.equals(destination, "стоп!")) {
                    break;
                }
            }
        }
        return "Минимальное количество указаний карты: " + count;
    }

    String TaskFour() {
        System.out.print("\n4. Логистический максимин\nВведите количество дорог: ");
        int road_Num = in.nextInt();
        int roadID = -1;
        int max_Tunnel_Height = 0;
        for (int i = 0; i < road_Num; i++) {
            System.out.print("Введите количество туннелей: ");
            int tunnel_Count = in.nextInt();
            int min_Tunnel_Height = Integer.MAX_VALUE;
            for (int j = 0; j < tunnel_Count; j++) {
                System.out.print("Введите высоту туннелей: ");
                int current_Height = in.nextInt();
                min_Tunnel_Height = Integer.min(current_Height, min_Tunnel_Height);
            }
            if (min_Tunnel_Height > max_Tunnel_Height) {
                max_Tunnel_Height = min_Tunnel_Height;
                roadID = i + 1;
            }
        }
        return "Максимальная высота грузовика " + max_Tunnel_Height + " на дороге №" + roadID;
    }

    String TaskFive () {
        System.out.print("\n5. Дважды четное число\nВведите трехзначное число: ");
        int number = in.nextInt();
        if (number < 1000 & number > 99) {
            int a = number / 100;
            int b = (number / 10) % 10;
            int c = number % 10;
            boolean fl = (a * b * c % 2 == (a + b + c) % 2) && (a * b * c % 2 == 0);
            return fl ? "Число дважды четное" : "Число не дважды четное";
        }
        return "Не трехзначное число!";
    }
}
