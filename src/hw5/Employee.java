package hw5;

import java.lang.Object;

public class Employee {
        private String fullName;
        private String position;
        private String email;
        private String mobilePhone;
        private int salary;
        private int age;

        public Employee (String fullName,
                         String position,
                         String email,
                         String mobilePhone,
                         int salary,
                         int age){
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.mobilePhone = mobilePhone;
            this.salary = salary;
            this.age = age;
        }

        void infoHeader() {
            System.out.printf("%-40s %-30s %-20s %-20s %-15s %-15s\n",
                    "ФИО",
                    "Должность",
                    "email",
                    "Моб. телефон",
                    "Зарплата",
                    "Возраст");
        }
        void info() {
            for (int i = 0; i < 140; i++) {
                System.out.print("-");
            }
            System.out.println();
            System.out.printf("%-40s %-30s %-20s %-20s %-15s %-15s\n",
                    fullName,
                    position,
                    email,
                    mobilePhone,
                    salary,
                    age);
        }

        public int getAge() {
            return age;
        }
}
