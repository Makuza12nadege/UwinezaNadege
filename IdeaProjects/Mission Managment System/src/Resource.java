public class Resource {
        private final String resourceId;
        private final String resourceName;
        private int quantity;
        private final String resourceType;

        public Resource(String resourceId, String resourceName, int quantity, String resourceType) {
            this.resourceId = resourceId;
            this.resourceName = resourceName;
            this.quantity = quantity;
            this.resourceType = resourceType;
        }

        public String getResourceId() {
            return resourceId;
        }

        public String getResourceName() {
            return resourceName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getResourceType() {
            return resourceType;
        }
}

