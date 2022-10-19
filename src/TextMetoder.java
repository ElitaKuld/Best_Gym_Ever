public class TextMetoder {

    public static String getPersonalNumberOutOfString(String text) {
        return text.substring(0, text.indexOf(",")).trim();
    }

    public static String getNameOutOfString(String text) {
        return text.substring(text.lastIndexOf(",") + 1).trim();
    }

    public static String createFileNameFromCustomerName(String customerName) {
        return customerName.substring(0, customerName.indexOf(" ")).toLowerCase() + "_" +
                customerName.substring(customerName.indexOf(" ") + 1).toLowerCase() + "_training_sessions.txt";
    }
}