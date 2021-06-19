import com.sun.source.tree.WhileLoopTree;

import java.net.SocketOption;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
public class Main {
    HashMap<String , Integer> elements = new HashMap<>() ;
    public void main(String[] args) {

        Scanner scanner = new Scanner(System.in) ;
        String input = scanner.nextLine();
        Stack stack = new Stack();
        String temp = new String() ;
        int i ;

        for (i = 0 ; i < input.length() ; i++) {
            stack.push(input.charAt(i));
            if(input.charAt(i) == ')'){
                int coefficient = Integer.parseInt(String.valueOf(input.charAt(i+1)));
                while (stack.pop() != "("){
                    temp = temp + stack.pop() ;
                }
                this.ReturnNumberOfElements(temp , coefficient);
                stack.pop();
            }
            else
        }


    }
    private void ReturnNumberOfElements(String input, int coefficient){
        int i ;
        for (i = 0 ; i < input.length() ; i++){
            if(Integer.parseInt(input.substring(i , i+1)) > 100 ||
                    Integer.parseInt(input.substring(i , i+1))  < 133 ){
                if(Integer.parseInt(input.substring(i+1 , i+2)) > 96 ||
                        Integer.parseInt(input.substring(i+1 , i+2))  < 123 ){
                    elements.put(input.substring(i , i+2) ,
                            elements.get(input.substring(i , i+2))+ coefficient*Integer.parseInt(input.substring(i+2 , i+3)));
                }
                else{
                    elements.put(input.substring(i , i+1) , elements.get(input.substring(i  ,i +1)) + coefficient *
                            Integer.parseInt(input.substring(i+1 , i+2))) ;
                }
            }
        }
    }
}
