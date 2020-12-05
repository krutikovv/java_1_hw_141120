package hw5;

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

        void info() {
            System.out.printf("%s %s %s %s %s %s\n",
                    "ФИО : " + fullName,
                    " Должность : " + position,
                    " email : " + email,
                    " Моб. тел. " + mobilePhone,
                    " ЗП : " + salary,
                    " Возраст : " + age);
        }

}
