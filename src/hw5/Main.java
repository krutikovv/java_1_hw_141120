package hw5;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Шляпкин Олег Денисович",
                "Бездельник", "slyapkin@e.com", "88000003535",
                12130, 35);
        employee[1] = new Employee("Бедокуров Илья Саныч",
                "Тунеядец", "bedokurov@e.com", "88000003536",
                12131, 36);
        employee[2] = new Employee("Горшков Сергей Петрович",
                "Прокрастинатор", "gorshkov@e.com", "88000003537",
                12132, 37);
        employee[3] = new Employee("Тазиков Борис Николаевич",
                "Царь", "tazikov@e.com", "88000003538",
                12133, 38);
        employee[4] = new Employee("Пакетиков Денис Людвигович",
                "Повар", "paketikov@e.com", "88000003539",
                12134, 39);
        for (int i = 0; i < 5; i++) {
            employee[i].info();
        }
    }
}
