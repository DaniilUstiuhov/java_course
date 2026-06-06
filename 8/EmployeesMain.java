public class EmployeesMain {
    public static void main(String[] args) {
        SalariedEmployee liisi = new SalariedEmployee("Liisi", "1985-03-15", 1001L, "2010-06-01", 48000.0);
        HourlyEmployee priit = new HourlyEmployee("Priit", "1992-11-20", 1002L, "2015-03-10", 25.0);

        System.out.println(liisi);
        System.out.println("Age: " + liisi.getAge());
        System.out.println("Weekly pay: " + liisi.collectPay());
        liisi.retire();
        System.out.println("After retire, weekly pay: " + liisi.collectPay());

        System.out.println();

        System.out.println(priit);
        System.out.println("Age: " + priit.getAge());
        System.out.println("Weekly pay: " + priit.collectPay());
        System.out.println("Double pay rate: " + priit.getDoublePay());

        liisi.terminate("2026-06-01");
        System.out.println("\nLiisi terminated on: " + liisi.getEndDate());
    }
}
