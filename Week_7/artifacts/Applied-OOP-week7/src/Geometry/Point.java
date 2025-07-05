public class Point {
    private double[] coordinates; // only (x,y)

    public Point() {
        this(new double[] {0,0}); // calling the other constructor
    }

    public Point(double[] coordinates) {
        setCoordinates(coordinates);
    }

    public Point (Point point) {
        this(point.getCoordinates());
    }

    public double[] getCoordinates() {
        // creating a copy of the array so as to encapsulate the data
        double[] copyCoordinates = new double[coordinates.length];

        for (int i = 0; i < coordinates.length; i++) {
            copyCoordinates[i] = coordinates[i];
        }

        return copyCoordinates;
    }

    public void setCoordinates(double[] coordinates) {

        if(coordinates != null && coordinates.length == 2) {

            this.coordinates = new double[coordinates.length];

            for(int i = 0; i < coordinates.length; i++) {
                // possible to do other validations -> example: unsigned, in our range, etc.
                this.coordinates[i] = coordinates[i];
            }

        } else {
            this.coordinates = new double[2];

        }
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        // overrides the toString function -> in object
        return String.format("(%.2f, %.2f)", coordinates[0], coordinates[1]);
    }
}
