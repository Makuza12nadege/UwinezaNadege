import java.util.List;

public class HumanitarianMission extends Mission {
    private List<Resource> allocatedResources;

    public HumanitarianMission(String missionId, String missionName, java.util.Date missionStartDate, java.util.Date missionEndDate, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, assignedPersonnel);

        boolean hasLogisticsOrMedic = assignedPersonnel.stream()
                .anyMatch(p -> p.getPersonnelRole().equalsIgnoreCase("Logistics Officer") ||
                        p.getPersonnelRole().equalsIgnoreCase("Medic"));
        if (!hasLogisticsOrMedic) {
            throw new IllegalArgumentException("HumanitarianMission must have at least Logistics or Medic personnel.");
        }
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning logistics, distribution, and medical aid tasks...");
    }

    @Override
    public void allocateResources(List<Resource> resources) {
        boolean hasFood = resources.stream()
                .anyMatch(r -> r.getResourceName().equalsIgnoreCase("Food Supply") && r.getQuantity() > 0);

        boolean hasMedical = resources.stream()
                .anyMatch(r -> r.getResourceName().equalsIgnoreCase("Medical Kit") && r.getQuantity() > 0);

        if (!hasFood || !hasMedical) {
            throw new IllegalStateException("Essential resources missing for HumanitarianMission.");
        }

        System.out.println("Allocating food supplies and medical kits...");
        allocatedResources = resources;
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Monitoring humanitarian aid distributions...");
        this.status = "IN_PROGRESS";  // Update to COMPLETED as needed
    }

    @Override
    public void generateMissionReport() {
        System.out.println("=== Humanitarian Mission Report ===");
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
