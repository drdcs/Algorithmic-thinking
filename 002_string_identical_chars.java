
public class Main
{
    static boolean permutations(String str1, String str2) {
        
        if (str1.length() != str2.length()){
            return false;
        } 
        
        int[] letters = new int[128];
        char[] s_array = str1.toCharArray();
        for(char c: s_array) {
            letters[c]++;
        }
        for (int i=0; i< str2.length(); i++){
            int c = (int) str2.charAt(i);
            letters[c]--;
            if(letters[c] < 0){
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
       String str1 = "apps";
       String str2 = "paps";
       boolean boo = permutations(str1, str2);
       System.out.println(boo);
    
    }
    
}
