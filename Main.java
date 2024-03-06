import java.util.*;
public class Main {
    static int criba_tam;
    static boolean criba[];
    static final int p=1000000007;
    static long[] a=new long[10000];
    static List<Integer> primos=new ArrayList<Integer>();
    static void criba(int may_term)
    {
        criba_tam=may_term;
        criba=new boolean[criba_tam];
        Arrays.fill(criba,true);
        criba[0]=criba[1]=false;
        for(long i=2;i<criba_tam;i++)
        {
            if(criba[(int)i])
            {
                for(long j=i*i;j<criba_tam;j+=i)
                {
                    criba[(int)j]=false;
                }
                primos.add((int)i);
            }
        }
    }
    static boolean esPrimo(long num)
    {
        if(num<criba_tam)
            return criba[(int)num];
        for(int i=0;i<primos.size();i++)
        {
            if(num%primos.get(i)==0)
                return false;
        }
        return true;
    }
    static boolean primalidad(long num)
    {
        for(int i=2;2*(i*i)<num;i++)
        {
            if(num%i==0)
                return false;
        }
        
        if(num==1 || num==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public static void main (String args[]){
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext())
        {
            a[0]=0;
            a[1]=1;
            for(int i=2;i<=1000;i++)
            {
                a[i]=(a[i-1]+a[i-2])%p;
            }
            int n=leer.nextInt();
            criba(10000000);
            if(primalidad(a[n]))// con la prueba de primalidad
            {
                System.out.println(" Es primo");
            }
            else{
                System.out.println(" No es primo");
            }
            if(esPrimo(a[n]))// con la criba
            {
                System.out.println(" Es primo");
            }
            else{
                System.out.println(" No es primo");
            }
        }
            
    }
}