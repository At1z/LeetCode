class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mapaRzymskichCyfr = new HashMap<>();
        mapaRzymskichCyfr.put('I', 1);
        mapaRzymskichCyfr.put('V', 5);
        mapaRzymskichCyfr.put('X', 10);
        mapaRzymskichCyfr.put('L', 50);
        mapaRzymskichCyfr.put('C', 100);
        mapaRzymskichCyfr.put('D', 500);
        mapaRzymskichCyfr.put('M', 1000);
        
        int liczbaznakow = s.length();
        char[] len = new char[liczbaznakow];
        
        for(int i = 0; i < liczbaznakow; i++ ){
            len[i] = s.charAt(i);
        }
        int suma = 0;
        boolean checker = true;
        for (int i = 0; i < liczbaznakow; i++) {
            for (int j = i+1; j < liczbaznakow; j++) {
                if(mapaRzymskichCyfr.get(len[j])>mapaRzymskichCyfr.get(len[i])){
                    suma += (mapaRzymskichCyfr.get(len[j])-mapaRzymskichCyfr.get(len[i]));
                    i++;
                    checker = false;
                }
            }
            if (checker == true){
            suma += mapaRzymskichCyfr.get(len[i]);
            }
            checker = true;
        }
    return suma;
    }
}