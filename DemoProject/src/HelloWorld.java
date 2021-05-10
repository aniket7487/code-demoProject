class Parent{
	Parent(int i,int j){
		System.out.println("success");
	}
}
class Child extends Parent{
	Child(int i,int j) {
//		System.out.println("child x"+ ++x);
		System.out.println("very success");
	}
}
public class HelloWorld {

	public static void main(String args []) {
		/*int i=10;
		int j=i++ + --i + i-- + ++i;
		
		System.out.println(i++);
		System.out.println(--j);*/
//		Parent p=new Child();
		Child c=new Child(10,20);
//		p.incrementX();
//		c.incrementX();
		
	}
}
