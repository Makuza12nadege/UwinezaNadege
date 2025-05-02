import java.util.Date;
public class AgriculturalLand extends Land {
    public AgriculturalLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    @Override
    public boolean validateOwnership() {
        return ownerName != null && !ownerName.trim().isEmpty();
    }

    @Override
    public boolean checkZoningCompliance() {
        return location.toLowerCase().contains("farming");
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 5000 * 0.01;
    }

    @Override
    public void generateLandReport() {
        System.out.println("\n=== Agricultural Land Report ===");
        System.out.println("Land ID: " + landId);
        System.out.println("Owner: " + ownerName);
        System.out.println("Location: " + location);
        System.out.println("Size (acres): " + sizeInAcres);
        System.out.println("Status: " + landUseStatus);
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Zoning OK: " + checkZoningCompliance());
        System.out.println("Ownership OK: " + validateOwnership());
    }
}
