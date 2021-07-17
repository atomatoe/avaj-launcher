public class AirIdGenerator {
        private int ids;
        private static AirIdGenerator instance;
        private AirIdGenerator() { ids = 0; }

        public static AirIdGenerator getInstance() {
            if(instance == null) {
                instance = new AirIdGenerator();
            }
            return instance;
        }
        public int generateId() { ids++; return ids; }
        public int getIds() {
            return ids;
        }
}
