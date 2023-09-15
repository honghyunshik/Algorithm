import java.util.*;

class Solution {
    
    TrieNode front = new TrieNode();
    TrieNode back = new TrieNode();
    
    public int[] solution(String[] words, String[] queries) {
        
        int[] answer = new int[queries.length];
        for(String word:words){
            insert(word,front);
            insert(new StringBuilder(word).reverse().toString(),back);
        }
        
        
        
        for(int idx=0;idx<queries.length;idx++){
            if(queries[idx].charAt(0)=='?') answer[idx] = getNum(back,new StringBuilder(queries[idx]).reverse().toString(),0);
            else answer[idx] = getNum(front,queries[idx],0);
        }
        
        
        return answer;
    }
    
    int getNum(TrieNode node, String word, int idx){
        
        if(node==null) return 0;
        
        if(word.charAt(idx)=='?') return node.cntMap.getOrDefault(word.length(),0);
        
        return getNum(node.child.get(word.charAt(idx)),word,idx+1);
        
    }
    
    //트라이 자료구조 만들기
    void insert(String word, TrieNode root){
        
        TrieNode node = root;
        
        for(int i=0;i<word.length();i++){
            
            node.cntMap.put(word.length(),node.cntMap.getOrDefault(word.length(),0)+1);
            if(node.child.get(word.charAt(i))==null) node.child.put(word.charAt(i),new TrieNode());
            node = node.child.get(word.charAt(i));
        }
        node.isLast = true;
    }
}

class TrieNode{
    
    HashMap<Character,TrieNode> child = new HashMap<>();
    HashMap<Integer,Integer> cntMap = new HashMap<>();
    boolean isLast;
}