package exercise;

import java.util.Map;

// BEGIN
class Tag {
    protected String tagName;
    protected Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String attributesAsString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry: attributes.entrySet()) {
            result.append(" ");
            result.append(entry.getKey());
            result.append("=\"");
            result.append(entry.getValue());
            result.append("\"");
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagName='" + tagName + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
// END
