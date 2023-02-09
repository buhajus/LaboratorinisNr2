import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        double atsakymas;
        String veiksmas;
        double sk0 = 0;
        double sk1 = 0;
        double sk2 = 0;
        boolean testi = true;

        System.out.println("MULTI SKAIČIUOTUVAS 2023 v2.0");
        while (testi = true) {

            System.out.println("Pasirinkite norimą veiksmą: * / + - # &");// begin veiksmo pasirinkimas
            Scanner input = new Scanner(System.in);// pirmo skaičiaus įvedimas
            Scanner input2 = new Scanner(System.in);
            Scanner input3 = new Scanner(System.in);
            veiksmas = input2.nextLine();

            if (!(veiksmas.equals("*") || veiksmas.equals("/") || veiksmas.equals("+") || veiksmas.equals("-") || veiksmas.equals("&") || veiksmas.equals("#"))) {
                System.out.println("Tokio veiskmo dar neišmokau. Rinkis dar sykį :");
                while (!(veiksmas.equals("*") || veiksmas.equals("/") || veiksmas.equals("+") || veiksmas.equals("-") || veiksmas.equals("&") || veiksmas.equals("#"))) {
                    veiksmas = input2.nextLine();
                }

            }// end veiksmo pasirinkimas

            switch (veiksmas) {//begin veiksmo naudojimas
                case "*":
                    System.out.println("tres or dous?");
                    switch (input3.nextLine()) {
                        case "tres":
                            dauginti(sk0, sk1, sk2);
                            break;
                        case "dous":
                            dauginti(sk0, sk1);
                            break;
                        default:
                            System.out.println("quatro... bye bye");
                            break;
                    }
                    break;
                case "/":
                    dalinti();
                    break;
                case "+":
                    System.out.println("Įveskite pirmą skaičių");
                    sk0 = input.nextDouble();
                    System.out.println("Įveskite antrą skaičių");//antro skaičiaus pasirinkimas
                    sk1 = input.nextDouble();
                    atsakymas = sudeti(sk0, sk1);
                    System.out.println("Atsakymas:\t" + sk0 + veiksmas + sk1 + " = " + atsakymas);
                    break;
                case "-":
                    atimti();
                    break;
                case "&":
                    System.out.println("Įveskite pirmą skaičių:");
                    sk0 = input.nextDouble();
                    System.out.println("Įveskite antrą skaičių:");
                    sk1 = input.nextDouble();
                    for (int i = 101; i < 200; i++) {
                        atsakymas = skaiciuotiFormule(sk0, sk1, i);
                        if (atsakymas < 100) {
                            System.out.println("Atsakymas:\t(" + sk1 + " + " + sk0 + ") * " + sk1 + " (" + sk1 + " - " + sk0 + ") / " + sk0 + " * " + i + " = " + atsakymas + " < 100");
                        } else if (atsakymas == 100) {
                            System.out.println("Atsakymas:\t(" + sk1 + " + " + sk0 + ") * " + sk1 + " (" + sk1 + " - " + sk0 + ") / " + sk0 + " * " + i + " = " + atsakymas + "== 100");
                        } else
                            System.out.println("Atsakymas:\t(" + sk1 + " + " + sk0 + ") * " + sk1 + " (" + sk1 + " - " + sk0 + ") / " + sk0 + " * " + i + " = " + atsakymas + " > 100");
                    }
                    break;
                case "#":
                    krengelis(sk0, sk1);
                    break;

            }//end veiksmo naudojimas

            System.out.println("Patiko? Dar kartą? Rašykt TAIP, jei pakaks - NE");
            String ats = input2.nextLine();

            if (ats.toLowerCase().equals("taip")) {//tikrinimas tęsti ar ne
                testi = true;
            } else {
                testi = false;
                System.out.println("bye bye");
                System.exit(0);
            }
        }
    }

    /**
     * Funkcija skirta atimti du skaičius
     *
     * @return grąžina rezultatą
     */
    static double atimti() {//funkcija grąžinanti reikšmę be parametrų
        double sk0;
        double sk1;
        double atsakymas;

        Scanner input = new Scanner(System.in);
        System.out.println("Įveskite pirmą skaičių:");
        sk0 = input.nextDouble();
        System.out.println("Įveskite antrą skaičių:");
        sk1 = input.nextDouble();
        atsakymas = sk0 - sk1;
        System.out.println("Atsakymas:\t" + sk0 + " - " + sk1 + " = " + atsakymas);
        return atsakymas;
    }

    /**
     * Funkcija sudeda su skaičius
     *
     * @param sk0 skaičius Nr.1
     * @param sk1 skaičius Nr.2
     * @return skaičių suma
     */
    static double sudeti(double sk0, double sk1) {
        return sk0 + sk1;
    }

    /**
     * funkcija dalina du skaičius. Jeigu antras skaičius == 0, meta pranešimą: "Dalyba iš 0 negalima" ir prašo įvesti skaičių,
     * tol kol jis bus didenis už 0. Suklydus 3 kartus, programa klausia: Pavargai?, nes įvesta per daug kartų 0. Jeigu
     * parašoma "taip" - programa uždaroma.
     */
    static void dalinti() {

        double sk0;
        double sk1;
        double atsakymas;
        int count = 0;

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("Įveskite pirmą skaičių:");
        sk0 = input.nextDouble();
        System.out.println("Įveskite antrą skaičių:");
        sk1 = input.nextDouble();
        if (sk1 == 0) {
            System.out.println("Dalyba iš 0 negalima");
            System.out.println("Įveskite skaičių");
            sk1 = input.nextDouble();
            while (sk1 == 0) {
                System.out.println("Įveskite skaičių");
                sk1 = input.nextDouble();
                count++;
                if (count < 2 && sk1 == 0) {
                    System.out.println("Pavargai?");
                    String ats = input2.nextLine();

                    if (ats.toLowerCase().equals("taip")) {
                        System.out.println("bye bye");
                        System.exit(0);
                    }
                }

            }
        }
        atsakymas = sk0 / sk1;
        System.out.println("Atsakymas:\t" + sk0 + " / " + sk1 + " = " + atsakymas);

    }

    /**
     * Funkcija daugina du skaičius
     *
     * @param sk0 skaičius Nr.1
     * @param sk1 skaičius Nr.2
     */
    static void dauginti(double sk0, double sk1) {
        double atsakymas;

        Scanner input = new Scanner(System.in);
        System.out.println("Įveskite pirmą skaičių:");
        sk0 = input.nextDouble();
        System.out.println("Įveskite antrą skaičių:");
        sk1 = input.nextDouble();
        System.out.println();
        atsakymas = sk0 * sk1;
        System.out.println("Atsakymas:\t" + sk0 + " * " + sk1 + " = " + atsakymas);

    }

    /**
     * Funkcija daugina tris skaičius.
     *
     * @param sk0 skaičius Nr.1
     * @param sk1 skaičius Nr.2
     * @param sk2 skaičius Nr.3
     */

    static void dauginti(double sk0, double sk1, double sk2) {
        double atsakymas;

        Scanner input = new Scanner(System.in);
        System.out.println("Įveskite pirmą skaičių:");
        sk0 = input.nextDouble();
        System.out.println("Įveskite antrą skaičių:");
        sk1 = input.nextDouble();
        System.out.println("Įveskite trečią skaičių:");
        sk2 = input.nextDouble();
        System.out.println();
        atsakymas = sk0 * sk1 * sk2;
        System.out.println("Atsakymas:\t" + sk0 + " * " + sk1 + " * " + sk2 + " = " + atsakymas);

    }

    /**
     * Funkcija apskaičiuoja slieko jautrumą kutenimui
     *
     * @param sk0 skaičius Nr.1
     * @param sk1 skaičius Nr.2
     */
    static void krengelis(double sk0, double sk1) {
        double atsakymas;

        Scanner input = new Scanner(System.in);
        System.out.println("Įveskite pirmą skaičių:");
        sk0 = input.nextDouble();
        System.out.println("Įveskite antrą skaičių:");
        sk1 = input.nextDouble();

        for (int i = 13; i <= 25; i++) {
            atsakymas = sk0 * sk1 + (sk1 - sk0) / sk0 * i;
            if (atsakymas < 6) {
                System.out.println("Atsakymas:\t" + sk0 + " * " + sk1 + " + (" + sk1 + " - " + sk0 + ") " + "/ " + sk0 + " * " + i + " = " + atsakymas + " < 6");
            } else if (atsakymas == 6) {
                System.out.println("Atsakymas:\t" + sk0 + " * " + sk1 + " + (" + sk1 + " - " + sk0 + ") " + "/ " + sk0 + " * " + i + " = " + atsakymas + " == 6");
            } else
                System.out.println("Atsakymas:\t" + sk0 + " * " + sk1 + " + (" + sk1 + " - " + sk0 + ") " + "/ " + sk0 + " * " + i + " = " + atsakymas + " > 6");
        }

    }

    /**
     * Funkcija skaičiuoja veiksmus pagal forumlę : (sk1 + sk0) * sk1 + (sk1 - sk0) / sk0 * i
     *
     * @param sk0 skaičius Nr.1
     * @param sk1 skaičius Nr.1
     * @return atsakymas
     */
    static double skaiciuotiFormule(double sk0, double sk1, int i) {

        double atsakymas;
        atsakymas = (sk1 + sk0) * sk1 + (sk1 - sk0) / sk0 * i;
        return atsakymas;


    }
}


