package org.example;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Car implements Comparable<Car> {
        private final String brand;
        public int getMaxSpeed;
        private String color;
        private final double engineVolume;
        private final int maxSpeed;

        public Car(String brand, String color, double engineVolume, int maxSpeed) {
            this.brand = brand;
            this.color = color;
            this.engineVolume = engineVolume;
            this.maxSpeed = maxSpeed;
        }

        public String getBrand() {
            return brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getEngineVolume() {
            return engineVolume;
        }

        public int getMaxSpeed() {
            return maxSpeed;
        }

        @Override
        public int compareTo(Car o) {
            return Double.compare(this.engineVolume, o.engineVolume);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", color='" + color + '\'' +
                    ", engineVolume=" + engineVolume +
                    ", maxSpeed=" + maxSpeed +
                    '}';
        }
    }

    public static void main(String[] args) {
        //створити 3-5 машин з різними брендами, кольорами, обʼємами двигуна та максимальними швидкостями.
        System.out.println("Create the cars");
        Car car1 = new Car("Audi", "Black", 2.0, 240);
        Car car2 = new Car("BMW", "White", 2.5, 220);
        Car car3 = new Car("Mercedes-Benz", "Red", 3.0, 250);
        Car car4 = new Car("Honda", "Blue", 1.5, 180);
        Car car5 = new Car("Toyota", "Green", 1.6, 200);

        System.out.println("And add them to the list");
        //Додати машини у список (колекцію/контейнер)
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        // за допомогою Iterator пройтися по списку та вивести машини на екран;
        printCarsUsingIterator(cars);

        System.out.println("\nChange cars color and print");
        // а допомогою ListIterator пройтися з кінця списку до початку, паралельно змінюючи колір машини на синій, та вивести машини на екран;
        ListIterator<Car> listIterator = cars.listIterator(cars.size());
        do {
            Car car = listIterator.previous();
            car.setColor("Blue");
            System.out.println(car);
        } while (listIterator.hasPrevious());

//за допомогою Comparator відсортувати список машин в порядку зростання обʼєму двигуна
        System.out.println("\nSort cars by max engine volume");
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return Double.compare(car2.getEngineVolume(), car1.getEngineVolume());
            }
        });

        // та вивести цей список на екран;
        printCarsUsingIterator(cars);

        //за допомогою Comparator відсортувати список машин в порядку спадання максимальної швидкості

        System.out.println("\nSort cars by min engine volume");
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return Double.compare(car1.getEngineVolume(), car2.getEngineVolume());
            }
        });

        // та вивести цей список на екран;
        printCarsUsingIterator(cars);

/*за допомогою Comparator відсортувати список машин в порядку зростання
сумарної кількості букв в назві бренду і кольорі та вивести цей список
на екран (приклад: Toyota White = 6 + 5 = 11 букв).*/

        System.out.println("\nSort cars by car brand length");
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return Integer.compare(car2.getBrand().length() + car2.getColor().length(),
                        car1.getBrand().length() + car1.getColor().length());
            }
        });
        printCarsUsingIterator(cars);
    }
    //Створенння методу, у якому за допомогою Iterator можна пройтися по списку та вивести машини на екран;
    private static void printCarsUsingIterator(List<Car> cars) {
        System.out.println("There is a result: ");
        Iterator<Car> iterator = cars.iterator();
        do {
            System.out.println(iterator.next());
        } while (iterator.hasNext());

    }
}