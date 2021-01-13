public class StringManipulator {
    public String trimAndConcat(String string, String string2){
        String result = string.trim() + string2.trim();
        return result;
    }
    public Integer getIndexOrNull(String str1, char char1){
        Integer value = str1.indexOf(char1);
        return value;
    }
    public Integer getIndexOrNull(String str1, String str2){
        Integer value = str1.indexOf(str2);
        return value;
    }
    public String concatSubstring(String sub, int int1, int int2, String sub2){
        String result = sub.substring(int1, int2) + sub2;
        return result;
    }
}