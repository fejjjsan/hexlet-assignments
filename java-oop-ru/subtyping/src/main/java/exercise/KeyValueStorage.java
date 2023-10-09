package exercise;

import java.util.Map;

interface KeyValueStorage {
    void set(String key, String value);
    void unset(String key);
    void setMap(Map<String, String> map);
    String get(String key, String defaultValue);
    Map<String, String> toMap();
}
