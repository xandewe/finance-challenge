import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private String name;
    private String typeAccount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    private Double revenue;
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        int opc = 0;

        main.setName("Alexandre Alves");
        main.setTypeAccount("Corrente");
        main.setRevenue(2400d);

        System.out.println(main.initialClient());

        while(opc != 4){
            System.out.println(main.initialMenu());
            System.out.println("Operações");
            opc = scan.nextInt();
            System.out.println();

            main.choiceOption(opc);
        }
    }

    public String initialClient() {
        return String.format("**********************************************\n" + "Nome: %s\n" + "Tipo conta: %s\nSaldo Inicial: %.2f\n" + "**********************************************", name, typeAccount, revenue);
    }

    public String initialMenu() {
        return "\n1- Consultar saldos\n2- Receber valor\n3- Transferir valor\n4- Sair\n";
    }

    public void choiceOption(int opc) {
        switch (opc) {
            case 1 -> {
                this.queryBalance();
            }
            case 2 -> {
                this.receivesValue();
            }
            case 3 -> {
                this.transferValue();
            }
            case 4 -> {
                System.out.println("Sair");
            }
            default -> {
                System.out.println("opção inválida");
            }
        }
    }

    private void queryBalance() {
        System.out.printf("O saldo é R$%.2f\n", this.revenue);
    }

    private void receivesValue() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o valor a receber:");
        int value = scan.nextInt();

        this.revenue += value;
        System.out.printf("Saldo atualizado R$%.2f\n", revenue);
    }

    private void transferValue() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o valor que deseja trasferir:");
        int value = scan.nextInt();

        if (value < revenue) {
            this.revenue -= value;
            System.out.printf("Saldo atualizado R$%.2f\n", revenue);
        } else {
            System.out.println("Não há saldo suficiente para fazer essa transferência.");
        }
    }
}