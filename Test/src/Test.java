
public class Test {
public static void main(String[] args) {
	/*String s="comapany";
	System.out.println(s.hashCode());
	s="virtusa";
	System.out.println(s.hashCode());
	System.out.println(s);*/
	
	
	
	StringBuffer s=new StringBuffer("comapany");
	System.out.println(s.hashCode());
	s.append("vijender");
	System.out.println(s.hashCode());
	System.out.println(s);
}
}
