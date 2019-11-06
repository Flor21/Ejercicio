import java.util.Scanner;
import java.util.ArrayList;

public class ValidarString {

    public static void main(String[] args) {

        ArrayList<Object>  arrNumero = new ArrayList<Object>();
        ArrayList<Object>  arrResultComparacion = new ArrayList<Object>();
        Boolean unicoNro = false;
        Boolean errorAssci = true;

        int unicoValor;
        int nroAssci;
        int min = 1;
        Object primerNro;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el string a validar: ");
        String stringIngresado = leer.nextLine();
        int cantidad = stringIngresado.length();
        String s[] = new String[cantidad];
        int cant[] = new int[cantidad];

        for (int i=0; i<s.length;i++){
            s[i]= String.valueOf(stringIngresado.charAt(i));
            int veri = s[i].charAt(0);
            nroAssci = (int) veri;

            if(nroAssci<97 | nroAssci>122) {
                errorAssci = false;
            }
        }

        if (cantidad >=1 && cantidad <= 10000 && errorAssci) {

            for (int i=0; i<s.length; i++ ) {
                String caracter = s[i];

                for (int j=0; j<s.length; j++ ) {

                    if (caracter.equals(s[j])) {
                        if(s[j]!="") {
                            cant[i] = cant[i] + 1;
                            if (cant[i] > min) {
                                s[j] = "";
                            }
                        }                
                    }                
                }
                if (cant[i] != 0) {
                    arrNumero.add(cant[i]);
                }
            }

            primerNro = arrNumero.get(0);

            for (int i=0; i<arrNumero.size(); i++) {
                if (primerNro!=arrNumero.get(i)) {
                    arrResultComparacion.add(arrNumero.get(i));
                }
            }

            int cambio = (Integer) primerNro;
            int tamaño = (Integer) (arrResultComparacion.size());

            if ( tamaño!=0) {
                unicoValor = (Integer) (arrResultComparacion.get(0));
                unicoNro = true;
            }
            
            int diferencia = cambio-tamaño;

            if (((diferencia == 0) && (tamaño == 1)) | (tamaño == 0) | (tamaño == 1 && unicoNro) | (tamaño < 1 && diferencia !=1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }    
        } else {
            System.out.println("El string no cumple con el requisito");
        }
    }
}
