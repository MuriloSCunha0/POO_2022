import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestRelation {

    public static void main(String[] args) {
        Relation erre = new Relation();
        Scanner scan = new Scanner(System.in);

        // Adiciona os elementos do domínio
        label:

        while(true){
            String line = scan.nextLine();
            System.out.println("$"+line);
            String[] ui = line.split(" ");
            
            switch (ui[0]) {
                case "end":
                    break label;
                case "createRelation":
                    Set<Integer> domain = new HashSet<>();
                    for (int i = 1; i < ui.length; i++) {
                        domain.add(Integer.parseInt(ui[i]));
                    }
                    erre = new Relation(domain);
                    break;
                case "addPair": {
                    int a = Integer.parseInt(ui[1]);
                    int b = Integer.parseInt(ui[2]);
                    try {
                        erre.addPair(a, b);
                    } catch (InvalidPairException e) {
                        System.out.println(e);
                    }
                    break;
                }
                case "hasPair": {
                    int a = Integer.parseInt(ui[1]);
                    int b = Integer.parseInt(ui[2]);
                    System.out.println(erre.hasPair(a, b));
                    break;
                }
                case "isReflexive":
                    System.out.println(erre.isReflexive());
                    break;
                case "checkReflexive":
                    erre.checkReflexive();
                    break;
                case "isSymmetric":
                    System.out.println(erre.isSymmetric());
                    break;
                case "checkSymmetric":
                    erre.checkSymmetric();
                    break;
                case "isTransitive":
                    System.out.println(erre.isTransitive());
                    break;
                case "checkTransitive":
                    erre.checkTransitive();
                    break;
                case "show":
                    System.out.println(erre);
                    break;
                default:
                    System.out.println("fail: comando invalido");
            }
        }
        scan.close();
    }
}
