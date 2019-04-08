package sample.Modelos;

import java.util.ArrayList;

public class Semilla {
    public static ArrayList<String> list;

    public static void Iniciar() {
        list = new ArrayList<String>();
    }

    public static void Agregar(String item) {
        list.add(item);
    }

    public static boolean siExiste(String item) {
        boolean f = false;
        if (!esVacio()) {
            Object[] all = list.toArray();
            int l = all.length;
            for (int i = 0; i < l; i++) {
                if (all[i].toString().equals(item)) {
                    f = true;
                    break;
                }
            }

        }
        return f;
    }

    public static boolean esVacio() {
        Object[] all = list.toArray();
        if (all.length == 0) {
            return true;
        }
        return false;
    }
}
