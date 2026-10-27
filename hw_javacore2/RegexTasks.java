package hw_javacore2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTasks {
    public static boolean containsOrderUIID(String str) {
        return str.matches(".*orderUUID.*");
    }

    public static String returnOrderUUID(String str) {
        // parentheses define capturing a group so we can extract it
        Pattern pattern = Pattern.compile("orderUUID=([a-z0-9\\-]+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1); // extracts what matched inside the parenthesis
        }
        return "";
    }

    public static String returnUserEmail(String str) {
        // parentheses define capturing a group so we can extract it
        Pattern pattern = Pattern.compile("([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1); // extracts what matched inside the parenthesis
        }
        return "";
    }

    public static String returnNumberOfOrders(String str) {
        // parentheses define capturing a group so we can extract it
        Pattern pattern = Pattern.compile("orders successfully processed: \\[(\\d+)]");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1); // extracts what matched inside the parenthesis
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(containsOrderUIID("app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3"));
        System.out.println(returnOrderUUID("app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3"));
        System.out.println(returnUserEmail("test 2667843 (test_email@griddynamics.com) test 67483 some string"));
        System.out.println(returnNumberOfOrders("app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: [Integration_test_Contract], total number of orders successfully processed: [2]"));
    }
}
