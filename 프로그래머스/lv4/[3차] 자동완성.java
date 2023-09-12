import java.util.*;

class Solution {
    
    TrieNode root = new TrieNode(null);
    
    public int solution(String[] words) {
        
        int answer = 0;
        for(String word:words){
            insert(word);
        }
        
        for(String word:words){
            answer += len(word);
        } 
        
        return answer;
    }
    
    //언제부터 자동완성이 되지?
    //idx = word.length()-1 이면 무조건 됨
    //그게 아니라면 자신이 유일할 때 
    int len(String word){
        
        TrieNode node = root; 
        int min = word.length();
        //끝까지 뒤로 이동
        for(int i=0;i<word.length();i++){
            node = node.child.get(word.charAt(i));
        }
        
        //이게 마지막이 아니라면?
        if(!node.child.isEmpty()) return word.length();
        node = node.back;
        
        for(int i=word.length()-1;i>0;i--){
            
            boolean flag = false;
            for(char c='a';c<='z';c++){
                //유일한지
                if(c!=word.charAt(i)&&node.child.get(c)!=null) return min;
                if(node.isLast) return min;
            }
            node = node.back;
            min--;
        }
        
        return min;
    }
    //Trie 자료구조 생성
    void insert(String word){

        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            node.child.put(word.charAt(i),node.child.getOrDefault(word.charAt(i),new TrieNode(node)));
            node = node.child.get(word.charAt(i));
        }
        node.isLast = true;
    }
    
}

class TrieNode{
    
    HashMap<Character,TrieNode> child = new HashMap<>();
    boolean isLast;
    TrieNode back;
    
    TrieNode(TrieNode back){
        this.back = back;
    }
    
}
