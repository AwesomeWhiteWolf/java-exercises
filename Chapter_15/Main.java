import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Flower")
public class Flower {

    private List<Plant> plants;

    public Flower() {
        plants = new ArrayList<>();
    }

    @XmlElement(name = "Plant")
    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "plants=" + plants +
                '}';
    }

    public static class Plant {

        private String name;
        private SoilType soil;
        private String origin;
        private VisualParameters visualParameters;
        private GrowingTips growingTips;
        private MultiplyingType multiplying;

        public Plant() {
        }

        public Plant(String name, SoilType soil, String origin, VisualParameters visualParameters, GrowingTips growingTips, MultiplyingType multiplying) {
            this.name = name;
            this.soil = soil;
            this.origin = origin;
            this.visualParameters = visualParameters;
            this.growingTips = growingTips;
            this.multiplying = multiplying;
        }

        @XmlElement(name = "Name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlElement(name = "Soil")
        public SoilType getSoil() {
            return soil;
        }

        public void setSoil(SoilType soil) {
            this.soil = soil;
        }

        @XmlElement(name = "Origin")
        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        @XmlElement(name = "VisualParameters")
        public VisualParameters getVisualParameters() {
            return visualParameters;
        }

        public void setVisualParameters(VisualParameters visualParameters) {
            this.visualParameters = visualParameters;
        }

        @XmlElement(name = "GrowingTips")
        public GrowingTips getGrowingTips() {
            return growingTips;
        }

        public void setGrowingTips(GrowingTips growingTips) {
            this.growingTips = growingTips;
        }

        @XmlElement(name = "Multiplying")
        public MultiplyingType getMultiplying() {
            return multiplying;
        }

        public void setMultiplying(MultiplyingType multiplying) {
            this.multiplying = multiplying;
        }

        @Override
        public String toString() {
            return "Plant{" +
                    "name='" + name + '\'' +
                    ", soil=" + soil +
                    ", origin='" + origin + '\'' +
                    ", visualParameters=" + visualParameters +
                    ", growingTips=" + growingTips +
                    ", multiplying=" + multiplying +
                    '}';
        }

        public static class VisualParameters {

            private String stemColor;
            private String leavesColor;
            private String size;

            public VisualParameters() {
            }

            public VisualParameters(String stemColor, String lea
vesColor, String size) {
                this.stemColor = stemColor;
                this.leavesColor = leavesColor;
                this.size = size;
            }

            @XmlElement(name = "StemColor")
            public String getStemColor() {
                return stemColor;
            }

            public void setStemColor(String stemColor) {
                this.stemColor = stemColor;
            }

            @XmlElement(name = "LeavesColor")
            public String getLeavesColor() {
                return leavesColor;
            }

            public void setLeavesColor(String leavesColor) {
                this.leavesColor = leavesColor;
            }

            @XmlElement(name = "Size")
            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }
        }
    }
}