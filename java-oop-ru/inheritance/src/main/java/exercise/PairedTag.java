package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String tagBody;
    List<Tag> tags;
    public PairedTag(String tagName,
                     Map<String, String> attributes,
                     String tagBody,
                     List<Tag> tags) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.tags = tags;
    }

    public String getTagsAsString() {
        StringBuilder result = new StringBuilder();
        for (Tag tag : tags) {
            result.append(tag.toString());
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return "<" + super.tagName + super.attributesAsString() + ">"
                + tagBody
                + getTagsAsString()
                + "</" + super.tagName + ">";
    }
}
// END
