import java.util.List;

public class CombatMission extends Mission {
    private List<Resource> allocatedResources;

    public CombatMission(String missionId, String missionName, java.util.Date missionStartDate, java.util.Date missionEndDate, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, assignedPersonnel);

        if (assignedPersonnel.size() < 3) {
            throw new IllegalArgumentException("CombatMission must have at least 3 personnel assigned.");
        }
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning defense, attack, and strategy tasks...");
    }

    @Override
    public void allocateResources(List<Resource> resources) {
        boolean hasAmmunition = resources.stream()
                .anyMatch(r -> r.getResourceName().equalsIgnoreCase("Ammunition") && r.getQuantity() > 0);

        if (!hasAmmunition) {
            throw new IllegalStateException("No ammunition available for CombatMission.");
        }

        System.out.println("Allocating ammunition, vehicles, and weaponry...");
        allocatedResources = resources;
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Monitoring combat operations...");
        this.status = "IN_PROGRESS";  // Update accordingly
    }

    @Override
    public void generateMissionReport() {
        System.out.println("=== Combat Mission Report ===");
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
