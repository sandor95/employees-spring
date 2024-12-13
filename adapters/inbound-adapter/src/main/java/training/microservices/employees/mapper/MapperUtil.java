package training.microservices.employees.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperUtil {

    public static String normalize(String input) {
        String trimmed = StringUtils.trim(input);
        String normalSpaced = trimmed != null ? trimmed.replaceAll("\\s+", " ") : null;
        return StringUtils.stripAccents(normalSpaced);
    }
}
