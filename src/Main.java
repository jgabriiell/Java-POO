import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract data: ");
        System.out.print("Number: ");
        int number = scanner.nextInt();

        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.next(), formatter);

        System.out.print("Value of contract: ");
        double totalValue = scanner.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.println("Enter the number of installments: ");
        int numberOfInstallments = scanner.nextInt();

        ContractService service = new ContractService(new PaypalService());

        service.processContract(contract, numberOfInstallments);

        System.out.print("Installments: ");
        for (Installment installment: contract.getInstallments()) {
            System.out.println(installment);
        }

        scanner.close();
    }
}
