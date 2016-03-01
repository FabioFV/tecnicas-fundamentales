import java.util.Scanner;

public class Lab0 {

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite la cantidad de numeros: ");
        int cantNum = in.nextInt();

        System.out.println("\nIntroduzca los numeros: ");
        float nums[] = new float[cantNum];

        for (int i = 0; i < cantNum; i++) {
            nums[i] = in.nextFloat();
        }

        System.out.println("\nMedia Aritmetica: " + mediaArimetica(nums));
        System.out.println("Desviacion Estandar: " + desviacionEstandar(nums));
    }

    public static float mediaArimetica(float nums[])
    {
        float suma = 0;

        for (int i = 0; i < nums.length; i++)
        {
            suma += nums[i];
        }

        return suma / nums.length;
    }

    public static float desviacionEstandar(float nums[])
    {
        float media = mediaArimetica(nums);
        float sumatoria = 0;
        float desviacion;

        for (int i = 0; i < nums.length; i++) {
            sumatoria += Math.pow(nums[i] - media, 2);
        }

        desviacion = (float) Math.sqrt(sumatoria / nums.length);

        return desviacion;
        
    }

}
