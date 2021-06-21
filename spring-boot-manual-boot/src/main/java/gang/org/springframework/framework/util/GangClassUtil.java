package gang.org.springframework.framework.util;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/21 12:45
 */
public abstract class GangClassUtil {

    private static final char PACKAGE_SEPARATOR = '.';

    public static String getShortName(String className)
    {
        int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
        int nameEndIndex = className.length();
        String shortName = className.substring(lastDotIndex+1, nameEndIndex);
        return shortName;
    }
}
