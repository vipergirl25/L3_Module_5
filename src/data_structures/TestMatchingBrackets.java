package data_structures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character>brackets = new Stack<Character>();
		for (int i = 0; i < b.length(); i++) {
			brackets.add(b.charAt(i));
		}
		if(brackets.size()%2==0) {
			for (int i = 0; i < brackets.size(); i=0) {
				if(brackets.size()==0) {
					break;
				}
				if(brackets.get(i) == '{') {;
					for (int j = 0; j < brackets.size(); j++) {
						if(brackets.get(j) == '}') {
							brackets.remove(i);
							j-=1;
							brackets.remove(j);
						}
					}
				}else {
					break;
				}
			}
			if(brackets.size()!=0) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
		
	
	}

}