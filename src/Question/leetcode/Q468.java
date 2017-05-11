package Question.leetcode;

/**
 * Created by gump on 2017/5/10.
 */
public class Q468 {

    public static void main(String argc[]){
        Q468 q = new Q468();
        System.out.println(q.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
    }

    public String validIPAddress(String IP) {
        String result;

        if(IP.contains(":")){
            result = "IPv6";
        }else {
            result = "IPv4";
        }

        if(result.equals("IPv4")){
            String input[] = IP.split("\\.");

            if(input.length!=4 || IP.endsWith(".")) return "Neither";
            for (String s : input) {
                if (s.isEmpty() ||(s.length()>1 && s.startsWith("0"))
                        || (s.charAt(0)<'0' || s.charAt(0)>'9')){
                    return "Neither";
                }

                try {
                    int temp =Integer.parseInt(s);
                    if(temp>255) return "Neither";
                }catch (NumberFormatException e){
                    return "Neither";
                }
            }
        }else{
            String input[] = IP.split(":");
            if(input.length!=8 || IP.endsWith(":")) return "Neither";

            for (String s :input) {
                if(s.isEmpty() || s.length()>4
                        || (s.length()<4 && !s.startsWith("0"))
                        || ((s.charAt(0)<'0' || s.charAt(0)>'9') && (s.charAt(0)<'a' || s.charAt(0)>'f') && (s.charAt(0)<'A' || s.charAt(0)>'F'))
                        || s.toLowerCase().compareTo("ffff")>0){
                    return "Neither";
                }
            }
        }

        return result;
    }
}
