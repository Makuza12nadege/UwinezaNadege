import java.util.List;

public class ReconMission extends Mission {
    private List<Resource> allocatedResources;

    public ReconMission(String missionId, String missionName, java.util.Date missionStartDate, java.util.Date missionEndDate, List<Personnel> assignedPersonnel) {
        super(missionId, missionName, missionStartDate, missionEndDate, assignedPersonnel);

        if (assignedPersonnel.size() < 2) {
            throw new IllegalArgumentException("ReconMission must have at least 2 personnel assigned.");
        }
    }

    @Override
    public void assignTask() {
        System.out.println("Assigning reconnaissance tasks to personnel...");
        for (Personnel p : assignedPersonnel) {
            System.out.println(p.getPersonnelName() + " assigned to surveillance and intelligence gathering.");
        }
    }

    @Override
    public void allocateResources(List<Resource> resources) {
        boolean droneAvailable = resources.stream()
                .anyMatch(r -> r.getResourceName().equalsIgnoreCase("Drone") && r.getQuantity() > 0);

        if (!droneAvailable) {
            throw new IllegalStateException("No drones available for ReconMission.");
        }

        System.out.println("Allocating reconnaissance equipment...");
        allocatedResources = resources;
    }

    @Override
    public void trackMissionProgress() {
        System.out.println("Tracking reconnaissance progress...");
        this.status = "IN_PROGRESS";  // Later, you can update it to COMPLETED
    }

    @Override
    public void generateMissionReport() {
        System.out.println("=== Mission Report ===");
        System.out.println("Mission: " + missionName);
        System.out.println("Status: " + status);
        System.out.println("Personnel Involved:");
        for (Personnel p : assignedPersonnel) {
            System.out.println("- " + p.getPersonnelName() + " (" + p.getPersonnelRole() + ")");
        }
        System.out.println("Resources Allocated:");
        for (Resource r : allocatedResources) {
            System.out.println("- " + r.getResourceName() + " (Qty: " + r.getQuantity() + ")");
        }
    }
}
