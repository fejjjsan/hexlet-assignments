package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    private String message;

    public NegativeRadiusException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
// END
