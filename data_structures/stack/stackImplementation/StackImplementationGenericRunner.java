package stackImplementation;

public class StackImplementationGenericRunner {
    public static void main(String[] args) {
        StackImplementationGeneric<Integer> stack1 = new StackImplementationGeneric<>();
        stack1.push(4);
        stack1.push(8);
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        System.out.println(stack1.peek());

        System.out.println(reverseString("Hello World!"));

        if (checkBracketBalance("{[{}])"))
        {
            System.out.println("balanced");
        }
        else
        {
            System.out.println("not balanced");
        }
    }

    public static String reverseString(String string) {
        char arr[] = string.toCharArray();
        StackImplementationGeneric<Character> characters = new StackImplementationGeneric<>();
        for (char character : arr) { //inserting each char into stack
            characters.push(character);
        }
        for (int i = 0; i < arr.length; i++) { //retrieving each char in reverse order
            arr[i] = characters.pop(); //since stacks are first in last out, popping after pushing reverses the string
        }
        return new String(arr); //creating string of char arr
    }

    public static boolean checkBracketBalance(String string)
    {
        char arr[] = string.toCharArray();
        StackImplementationGeneric<Character> characters = new StackImplementationGeneric<>();
        for (char bracket :
                arr) {
            if (bracket == '{' || bracket == '(' || bracket == '[')
            {
                characters.push(bracket); //inserting the opening brackets in the stack
            }
            else
            {
                char openingBracket = characters.pop();
                if (bracket == '}' && openingBracket == '{') //retreiving the closing bracket and matching it with the sequence
                {
                    continue;
                }
                else if (bracket == ')' && openingBracket == '(')
                {
                    continue;
                }
                else if (bracket == ']' && openingBracket == '[')
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }
        if (characters.length == 0) //checking if it is empty at end or not
        {
            return true;
        }
        else
        {
            return false;
        }

    }


}
