import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Land Management System ===");
        System.out.println("Choose land type to register:");
        System.out.println("1. Agricultural Land");
        System.out.println("2. Residential Land");
        System.out.println("3. Commercial Land");
        System.out.println("4. Industrial Land");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Enter Land ID: ");
        String landId = scanner.nextLine();

        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Enter Location (include zone keyword): ");
        String location = scanner.nextLine();

        System.out.print("Enter Size in Acres: ");
        double sizeInAcres = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Land Use Status (Vacant/In Use/Under Development): ");
        String landUseStatus = scanner.nextLine();

        Land land = null;
        switch (choice) {
            case 1:
                if (sizeInAcres < 1) {
                    System.out.println("Agricultural land must be at least 1 acre.");
                    return;
                }
                land = new AgriculturalLand(landId, ownerName, location, sizeInAcres, new Date(), landUseStatus);
                break;

            case 2:
                System.out.print("Enter number of residential units: ");
                int units = scanner.nextInt();
                scanner.nextLine();
                land = new ResidentialLand(landId, ownerName, location, sizeInAcres, new Date(), landUseStatus, units);
                break;

            case 3:
                land = new CommercialLand(landId, ownerName, location, sizeInAcres, new Date(), landUseStatus);
                break;

            case 4:
                System.out.print("Environmental Clearance Granted? (true/false): ");
                boolean hasClearance = scanner.nextBoolean();
                land = new IndustrialLand(landId, ownerName, location, sizeInAcres, new Date(), landUseStatus, hasClearance);
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("\n--- Land Registration Summary ---");
        land.generateLandReport();
        scanner.close();
    }
}
