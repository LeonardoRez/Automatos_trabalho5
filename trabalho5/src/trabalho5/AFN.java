package trabalho5;

import java.util.ArrayList;

public class AFN {

    public ArrayList<Integer> funcaoTransicao(int q, char s) {
        ArrayList<Integer> retorno = new ArrayList<>();
        switch (q) {
            case 0:
                retorno.add(0);
                if (s == 'a') {
                    retorno.add(1);
                }
                break;
            case 1:
                retorno.add(2);
                break;
            case 2:
                retorno.add(3);
        }
        return retorno;
    }

    public boolean ft_extendida(String w) {
        ArrayList<Integer> q0 = new ArrayList<>();
        q0.add(0);
        ArrayList<Integer> i = ft_extendida(q0, w);
        if (i == null) {
            return false;
        }
        for (int q : i) {
            if (q == 3) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> ft_extendida(ArrayList<Integer> q, String w) {
        ArrayList<Integer> retorno = new ArrayList<>();
        if (w.length() == 0) {
            return retorno;
        }
        if (w.length() == 1) {
            for (int a : q) {
                retorno.addAll(funcaoTransicao(a, w.charAt(0)));
            }
            return retorno;
        }
        //separando o resto
        String resto = w.substring(0, w.length() - 1);
        char fim = w.charAt(w.length() - 1);

        ArrayList<Integer> temp = ft_extendida(q, resto);
        if (temp != null) {
            for (int a : temp) {
                retorno.addAll(funcaoTransicao(a, fim));
            }
        }
        return retorno;

    }

    public static void main(String[] args) {
        AFN a = new AFN();
        if (a.ft_extendida("bbbbababbbbababbbbababbbbaba")) {
            System.out.println("PASSOU");
        } else {
            System.out.println("DEU RUIM");
        }
    }
}
