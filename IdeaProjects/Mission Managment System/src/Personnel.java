public class Personnel {
        private final String personnelId;
        private final String personnelName;
        private final String personnelRole;
        private Mission assignedMission;

        public Personnel(String personnelId, String personnelName, String personnelRole) {
            this.personnelId = personnelId;
            this.personnelName = personnelName;
            this.personnelRole = personnelRole;
        }

        public String getPersonnelId() {
            return personnelId;
        }

        public String getPersonnelName() {
            return personnelName;
        }

        public String getPersonnelRole() {
            return personnelRole;
        }

        public Mission getAssignedMission() {
            return assignedMission;
        }

        public void assignMission(Mission mission) {
            this.assignedMission = mission;
        }
}
