/**
 * Laboratorul 1, Programare Avansata
 * @author Dobre Roxana-Elena
 * grupa 2A2
 */
public class Main {
    /**
     * cu ajutorul functiei "ex4" se vor rezolva cerintele exercitiului 4
     * numarul se va inmulti cu 4
     * se vor adauga numarul binar 10101 si cel hexazecimal FF
     * rezultatul se va inmulti cu 6
     * @return numarul ales aleatoriu dupa modificarile cerute la ex4
     */
    static int ex4(int n) {
        n=((n*3) + 0xFF + 0b10101 ) *6;
        return n;
    }

    /**
     * cu ajutorul functiei "ex5" se vor rezolva cerintele exercitiului 5
     * cat timp numarul n nu este format dintr-o singura cifra,se va calcula suma cifrelor sale
     * pentru a asigura faptul ca suma va fi formata dintr-o singura cifra
     * n primeste valoarea sumei cifrelor sale. Se va verifica din nou daca n este sau nu o singura cifra.
     * @return suma cifrelor numarului n, suma fiind formata dintr-o singura cifra
     */
    static int ex5(int n) {
        int sum;
        while(n>9)
        {
            sum=0;
            while(n!=0)
            {
                sum+=n%10;
                n/=10;
            }
            n=sum;
        }
        return n;
    }

    /**
     * Functia 'main' ce contine:
     * rezolvarea exercitiilor date la Laboratorul1
     * fiecare rezolvare este comentata pentru a se cunoaste ce exercitiu rezolva
     * Se va afisa 'Hello Word', se va initializa un numar radome
     * Se vor apela functiile 'ex4' si 'ex5'
     * Se va afisa textul dat la ex6 si un element din sirul de caractere 'languages'
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");                                                                        ///ex1
        String languages [] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"} ;   ///ex2
        int n = (int) (Math.random() * 1_000_000);                                                                 ///ex3
        int sum=0;                                                                                            ///ex4
        n=ex4(n);                                                                                                  ///ex4
        sum=ex5(n);                                                                                                ///ex5
        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);                           ///ex6

    }
}