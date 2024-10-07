import java.util.Scanner;

class Main {
    public static void main(String[] args) {
class Quadratic {
    double a, b, c;  
    double r1, r2, d; 

    Quadratic() {
        Scanner input = new Scanner(System.in); 
        System.out.println("This program calculates the roots of a quadratic equation of the form ax^2 + bx + c = 0.");

        do {
            System.out.print("Enter the value of a (not 0): "); 
            a = input.nextDouble(); 
	    if(a==0) System.out.print("Not a quadratic equation" )  ; 
        } while (a == 0);
        
        System.out.print("Enter the value of b: "); 
        b = input.nextDouble();  
        
        System.out.print("Enter the value of c: "); 
        c = input.nextDouble(); 

        d = b*b-4*a*c; 

        if(d==0) {
            r1 = -b/(2*a); 
            System.out.println("Roots are real and equal: " + r1); 
        }else if(d > 0){ 
            r1 = (-b+Math.sqrt(d))/(2*a); 
            r2 = (-b-Math.sqrt(d))/(2 * a);
            System.out.println("Root1 is " + r1 + ", Root2 is " + r2); 
        } else {
            System.out.println("The roots are imaginary."); 
        }
    }
}
        Quadratic q = new Quadratic(); 
	System.out.println("KHALID RABBANI" )  ; 
	System.out.print("1BM23CS150") ; 
    }
}