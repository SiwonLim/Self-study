package Algorithm.Java;

public class prac_202402 {
    public static void main(String[] args) throws Exception{
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s) {
        s = replaceAll(s).toLowerCase();
        int i = 0, j = s.length()-1;
        while(i < j){
            if(i >= j){
                return true;
            }else if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public static String replaceAll(String str){
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }
}
