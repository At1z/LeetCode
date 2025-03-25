class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Set<Integer> seen = new HashSet<>();
        int[] ransomFreq = new int[26];
        int[] magazineFreq = new int[26];
        int curRansomIndex = 0;
        int curMagazineIndex = 0;
        while(curRansomIndex < ransomNote.length() && curMagazineIndex < magazine.length()){
            ransomFreq[ransomNote.charAt(curRansomIndex) -'a'] += 1;
            magazineFreq[magazine.charAt(curMagazineIndex) -'a' ] += 1;
            curRansomIndex += 1;
            curMagazineIndex += 1;
        }
        while(curRansomIndex < ransomNote.length()){
            ransomFreq[ransomNote.charAt(curRansomIndex) -'a'] += 1;
            curRansomIndex += 1;            
        }
        while(curMagazineIndex < magazine.length()){
            magazineFreq[magazine.charAt(curMagazineIndex) -'a' ] += 1;
            curMagazineIndex += 1;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            int curLetter = ransomNote.charAt(i) -'a';
            if(seen.contains(curLetter)){
                continue;
            }
            seen.add(curLetter);
            if(ransomFreq[curLetter] > magazineFreq[curLetter] ){
                return false;
            }
        }
        return true;
    }
}