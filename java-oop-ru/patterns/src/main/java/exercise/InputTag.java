package exercise;

// BEGIN
class InputTag implements TagInterface {
    String type;
    String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }
    @Override
    public String render() {
        return String.format("<input type=\"%s\" value=\"%s\">", type, value);
    }

}

// END
