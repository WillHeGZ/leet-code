package xyz.gzzh.leetcode.application;

//最长公共前缀
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        /*
         *   flower
         *   flow
         *   flight
         * */
        if (strs == null || strs.length == 0) {
            return "";
        }

        String result = "";
        int arrayLength = strs.length;
        int stringOneLength = strs[0].length();

        try {
            for (int i = 0; i < stringOneLength; i++) {
                char c = strs[0].charAt(i);

                Boolean allTrue = true;
                for (int j = 1; j < arrayLength; j++) {
                    if (c != strs[j].charAt(i)) {
                        allTrue = false;
                    }
                }

                if (allTrue) {
                    result = strs[0].substring(0, i + 1);
                } else {
                    return result;
                }
            }
        } catch (StringIndexOutOfBoundsException e1) {
            return result;
        } catch (Exception e) {
            return "";
        }

        return result;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flowht"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String commonPrefix = longestCommonPrefix.longestCommonPrefix(strings);

        String commonPrefix2 = longestCommonPrefix.longestCommonPrefix2(strings);

        System.out.println(commonPrefix);
        System.out.println(commonPrefix2);
    }
}
