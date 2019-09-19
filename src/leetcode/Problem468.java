package leetcode;

public class Problem468 {

    public static void main(String[] args) {
        new Problem468().validIPAddress("2001:0db8:85a3::8A2E:0370:7334");
    }

    //Runtime: 1 ms, faster than 98.92% of Java online submissions for Validate IP Address.
    //Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Validate IP Address.
    public String validIPAddress(String IP) {
        String[] split = IP.split("\\.");
        if (split.length == 4) {
            for (int i = 0; i < 4; i++) {
                if (split[i].length() > 3 || split[i].length() == 0)
                    return "Neither";
                for (char c : split[i].toCharArray()) {
                    if (c < '0' || c > '9')
                        return "Neither";
                }
                if (split[i].startsWith("0") && split[i].length() > 1)
                    return "Neither";
                int value = Integer.valueOf(split[i]);
                if (value > 255)
                    return "Neither";
            }
            if (IP.startsWith(".") || IP.endsWith("."))
                return "Neither";
            return "IPv4";
        }
        split = IP.split(":");
        if (split.length == 8) {
            for (int i = 0; i < 8; i++) {
                if (split[i].length() == 0 || split[i].length() > 4)
                    return "Neither";
                for (char c : split[i].toCharArray()) {
                    if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')))
                        return "Neither";
                }
            }
            if (IP.startsWith(":") || IP.endsWith(":"))
                return "Neither";
            return "IPv6";
        }
        return "Neither";
    }
}
