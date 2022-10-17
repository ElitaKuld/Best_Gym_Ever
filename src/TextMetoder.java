public class TextMetoder {

    public String getPersonalNumberOutOfString(String text){
        return text.substring(0, text.indexOf(",")).trim();
    }

    public String getNameOutOfString(String text) {
        return text.substring(text.lastIndexOf(",") + 1).trim();
    }
}