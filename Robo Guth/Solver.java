import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collection;

class Robo {
    String palavra;
    
    
    public Robo(String palavra) {
        this.palavra = palavra;
    }
    
    public Collection<String> palavrasValidas(){
        return geraPalavras(this.palavra);
    }
    
    public int palavraCompleta(String palavra){
        for (int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) == '?'){
                return i;
            }
        }
        
        return -1;
    }
    
    private ArrayList<String> geraPalavras(String palavra){
        int r = this.palavraCompleta(palavra);
        ArrayList<String> palavras = new ArrayList<>();
        if(r == -1){
            palavras.add(palavra);
            return palavras;
        }else{
            char[] chars = palavra.toCharArray();
            if((r == 0) || 
            (r > 0 && palavra.charAt(r-1) != 'a') && (r == palavra.length()-1 || 
            (r < palavra.length()-1 && palavra.charAt(r + 1) != 'a'))){
                chars[r] = 'a';
                String p = String.valueOf(chars);
                palavras.addAll(this.geraPalavras(p));
            }
            chars[r] = 'b';
            String p = String.valueOf(chars);
            palavras.addAll(this.geraPalavras(p));
            return palavras;
        }
    }

}

class Solver {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String sp = scr.next();
        Robo rob = new Robo(sp);
        for(String palavra : rob.palavrasValidas()){
            System.out.println(palavra);
        }

    }   
}