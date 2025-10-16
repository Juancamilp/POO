public class ejercicios {
    public static void main(String[] args) {
        int x = 15;
        int y = 10;
        int z = 12;
        int p = 0;

        if (x > y && z < 20) {
            p = 50;
            System.out.println("La condición se cumple, p = " + p);
        } else {
            System.out.println("La condición NO se cumple.");
        }
    }

    //
    {
        int distancia = 25;
        int tiempo = 0;

        if (distancia > 20 && distancia < 35) {
            tiempo = 10;
            System.out.println("La condición se cumple, tiempo = " + tiempo);
        } else {
            System.out.println("La condición NO se cumple.");
        }

        //
    
    int numero = -7;
    int totalPositivos = 0;
    int totalNegativos = 0;

    if(numero>0){
    
        totalPositivos = totalPositivos + numero;
    }
    else{

    
        totalNegativos = totalNegativos + numero;
    }

    System.out.println("Total de positivos: "+totalPositivos);System.out.println("Total de negativos: "+totalNegativos);}
}