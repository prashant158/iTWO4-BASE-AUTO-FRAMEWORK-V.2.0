package iTWO_Utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class JsonObjectMapper {
    public static Map<String, Object> getConfigMap(String environmentName) {
        if (environmentName!=null || environmentName!="") {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> environmentsMaps = mapper.readValue(new File(
                        "src//test//resources//iTWO_ConfigData//Config.json"), new TypeReference<Map<String, Object>>() {
                });
                for(String key: environmentsMaps.keySet()) {
                    if (key.equalsIgnoreCase(environmentName)) {
                        return (Map<String, Object>) environmentsMaps.get(key);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(getConfigMap("QA"));

    }
}
