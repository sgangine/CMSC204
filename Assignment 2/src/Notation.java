import java.util.ArrayList;
import java.util.Arrays;
/**
 * Utility class for converting between infix and postfix
 * @author saigangineni
 *
 */
public class Notation {
	
	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param postfixExpr the postfix expression in a String format
	 * @return the evaluation as a double
	 * @throws InvalidNotationFormatException throws if postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression (String postfixExpr) throws InvalidNotationFormatException {
		NotationStack<Double> eval = new NotationStack<Double>(postfixExpr.length());
		char[] expr = postfixExpr.toCharArray();
		for (int i = 0; i < expr.length; i++) {
			if (Character.isDigit(expr[i])) {
				double d = expr[i]-'0';
				try {
					eval.push(d);
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}else {
				if(eval.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				Double pop1=0.0, pop2=0.0, result=0.0;
				try {
					pop2 = eval.pop();
					pop1 = eval.pop();
				}catch(StackUnderflowException e) {
					e.printStackTrace();
				}
				switch(expr[i]) {
				case '+' : result = pop1 + pop2;
				break;
				case '-' : result = pop1 - pop2;
				break;
				case '*' : result = pop1 * pop2;
				break;
				case '/' : result = pop1 / pop2;
				break;
				}
				try {
					eval.push(result);
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}
		}
		if (eval.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		Double output=0.0;
		try {
			output = eval.pop();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	/**
	 * Convert the Postfix expression to the Infix expression
	 * @param postfix the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException thrown if postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		NotationStack<String> eval = new NotationStack<String>(postfix.length());
		char[] expr = postfix.toCharArray();
		for (int i = 0; i < expr.length; i++) {
			if (Character.isDigit(expr[i])) {
				try {
					eval.push(String.valueOf(expr[i]));
				}catch(StackOverflowException e) {
					e.printStackTrace();
				}
			}else {
				if (eval.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				String pop1="", pop2="", result="";
				try {
					pop2 = eval.pop();
					pop1 = eval.pop();
					result += "(" + pop1 + String.valueOf(expr[i]) + pop2 + ")";
					eval.push(result);
				}catch(StackUnderflowException e) {
					e.printStackTrace();
				}catch(StackOverflowException e) {
					e.printStackTrace();
				}
			}
		}
		if (eval.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return eval.toString();
	}
	
	/**
	 * Private helper method for determining precedence of operators
	 * @param c the operator
	 * @return an integer between 1-3 depending on the operator
	 */
	private static int prec(char c) {
		if (c=='(' || c==')') {
			return 3;
		}else if (c=='*' || c=='/') {
			return 2;
		}else {
			return 1;
		}
	}
	
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException throws if infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		NotationQueue<String> postfix = new NotationQueue<String>(infix.length());
		NotationStack<String> eval = new NotationStack<String>(infix.length());
		char[] expr = infix.toCharArray();
		for (int i = 0; i < expr.length; i++) {
			if (Character.isDigit(expr[i])) {
				try {
					postfix.enqueue(String.valueOf(expr[i]));
				}catch(QueueOverflowException e) {
					e.printStackTrace();
				}
			}else if (expr[i] == '(') {
				try {
					eval.push(String.valueOf(expr[i]));
				}catch(StackOverflowException e) {
					e.printStackTrace();
				}
			}else if (expr[i]=='+'||expr[i]=='-'||expr[i]=='*'||expr[i]=='/') {
				try {
					while(!eval.isEmpty() && eval.top().charAt(0)!='(' && prec(expr[i]) <= prec(eval.top().charAt(0))){
						String pop1 = eval.pop();
						postfix.enqueue(pop1);
					}
					eval.push(String.valueOf(expr[i]));
				}catch (StackUnderflowException e) {
					e.printStackTrace();
				}catch (QueueOverflowException e) {
					e.printStackTrace();
				}catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}else if (expr[i]==')') { 
				try {
					while(!eval.isEmpty() && eval.top().charAt(0)!='(') {
						String pop1 = eval.pop();
						postfix.enqueue(pop1);
					}
					if(eval.size()==0){
						throw new InvalidNotationFormatException();
					}else {
						eval.pop();
					}
				}catch (StackUnderflowException e) {
					e.printStackTrace();
				}catch (QueueOverflowException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			while(!eval.isEmpty()) {
				String pop1 = eval.pop();
				postfix.enqueue(pop1);
			}
		}catch (StackUnderflowException e) {
			e.printStackTrace();
		}catch (QueueOverflowException e) {
			e.printStackTrace();
		}
		return postfix.toString();
	}
	
}
