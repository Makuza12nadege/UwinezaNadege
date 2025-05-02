import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // ====== Input Mission Details ======
            System.out.println("Enter Mission ID:");
            String missionId = scanner.nextLine();

            System.out.println("Enter Mission Name:");
            String missionName = scanner.nextLine();

            System.out.println("Enter Mission Start Date (yyyy-mm-dd):");
            String startDateStr = scanner.nextLine();
            System.out.println("Enter Mission End Date (yyyy-mm-dd):");
            String endDateStr = scanner.nextLine();

            // Convert to Date
            Date startDate = new GregorianCalendar(
                    Integer.parseInt(startDateStr.substring(0, 4)),
                    Integer.parseInt(startDateStr.substring(5, 7)) - 1,
                    Integer.parseInt(startDateStr.substring(8, 10))
            ).getTime();
            Date endDate = new GregorianCalendar(
                    Integer.parseInt(endDateStr.substring(0, 4)),
                    Integer.parseInt(endDateStr.substring(5, 7)) - 1,
                    Integer.parseInt(endDateStr.substring(8, 10))
            ).getTime();

            // ====== Input Personnel Details ======
            List<Personnel> personnelList = new ArrayList<>();
            System.out.println("How many personnel are you assigning?");
            int personnelCount = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < personnelCount; i++) {
                System.out.println("Enter Personnel ID:");
                String pid = scanner.nextLine();
                System.out.println("Enter Personnel Name:");
                String pname = scanner.nextLine();
                System.out.println("Enter Personnel Role (e.g., Medic, Soldier, Logistics Officer):");
                String prole = scanner.nextLine();

                personnelList.add(new Personnel(pid, pname, prole));
            }

            // ====== Input Resource Details ======
            List<Resource> resourceList = new ArrayList<>();
            System.out.println("How many resources are available?");
            int resourceCount = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < resourceCount; i++) {
                System.out.println("Enter Resource ID:");
                String rid = scanner.nextLine();
                System.out.println("Enter Resource Name:");
                String rname = scanner.nextLine();
                System.out.println("Enter Resource Quantity:");
                int rquantity = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Resource Type (e.g., Equipment, Medical Supplies, Weaponry):");
                String rtype = scanner.nextLine();

                resourceList.add(new Resource(rid, rname, rquantity, rtype));
            }

            // ====== Choose Mission Type ======
            System.out.println("Choose Mission Type:");
            System.out.println("1. ReconMission");
            System.out.println("2. RescueMission");
            System.out.println("3. CombatMission");
            System.out.println("4. HumanitarianMission");
            int missionChoice = Integer.parseInt(scanner.nextLine());

            Mission mission = null;

            switch (missionChoice) {
                case 1:
                    mission = new ReconMission(missionId, missionName, startDate, endDate, personnelList);
                    break;
                case 2:
                    mission = new RescueMission(missionId, missionName, startDate, endDate, personnelList);
                    break;
                case 3:
                    mission = new CombatMission(missionId, missionName, startDate, endDate, personnelList);
                    break;
                case 4:
                    mission = new HumanitarianMission(missionId, missionName, startDate, endDate, personnelList);
                    break;
                default:
                    System.out.println("Invalid choice. Exiting...");
                    return;
            }

            // ====== Perform Mission Operations ======
            mission.assignTask();
            mission.allocateResources(resourceList);
            mission.trackMissionProgress();
            mission.generateMissionReport();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}