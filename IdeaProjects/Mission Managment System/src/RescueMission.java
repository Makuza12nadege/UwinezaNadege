import java.util.List;

public class RescueMission extends Mission {
    private List<Resource> allocatedResources;

    public RescueMission(String missionId, String missionName, java.util.Date missionStartDate, java.util.Date missionEndDate, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, assignedPersonnel);

        boolean hasMedic = assignedPersonnel.stream()
                .anyMatch(p -> p.getPersonnelRole().equalsIgnoreCase("Medic"));

        if (!hasMedic) {
            throw new IllegalArgumentException("RescueMission must have at least one Medic assigned.");
        }
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning rescue, medical, and logistics tasks...");
    }

    @Override
    public void allocateResources(List<Resource> resources) {
        boolean hasMedicalSupplies = resources.stream()
                .anyMatch(r -> r.getResourceName().equalsIgnoreCase("Medical Kit") && r.getQuantity() > 0);

        if (!hasMedicalSupplies) {
            throw new IllegalStateException("No medical supplies available for RescueMission.");
        }

        System.out.println("Allocating medical kits, ambulances, and rescue equipment...");
        allocatedResources = resources;
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking rescue operations...");
        this.status = "IN_PROGRESS";  // Update as needed
    }

    @Override
    public void generateMissionReport() {
        System.out.println("=== Rescue Mission Report ===");
        System.out.println("Mission: " + missionName);
        System.out.println("Status: " + status);
        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p.getPersonnelName() + " (" + p.getPersonnelRole() + ")");
        }
        for (Resource r : allocatedResources) {
            System.out.println("- " + r.getResourceName() + " (Qty: " + r.getQuantity() + ")");
        }
    }
}
