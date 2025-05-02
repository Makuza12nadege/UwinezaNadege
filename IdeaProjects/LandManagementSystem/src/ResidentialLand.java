import java.util.Date;
public class ResidentialLand extends Land {
    private int units;

    public ResidentialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, int units) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.units = units;
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return (units / sizeInAcres) <= 2;
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 8000 * 0.015;
    }

    @Override
    public void generateLandReport() {
        System.out.println("\n=== Residential Land Report ===");
        System.out.println("Land ID: " + landId);
        System.out.println("Owner: " + ownerName);
        System.out.println("Units: " + units);
        System.out.println("Location: " + location);
        System.out.println("Size (acres): " + sizeInAcres);
        System.out.println("Status: " + landUseStatus);
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Zoning OK: " + checkZoningCompliance());
        System.out.println("Ownership OK: " + validateOwnership());
    }
}
