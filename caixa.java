package Javalibary4;

import java.util.Scanner;
import java.util.ArrayList;

public class caixa {
    public static void main(String[] args) throws InterruptedException {
        String cpf = "12345678900",password = "01020304";
        int balance = 1000;
        
        ArrayList<String> bankStatement = new ArrayList<String>();
        Scanner read;
        
        read = new Scanner(System.in);
        
        
        String userCpf,userPassword;
        int operations = 1,deposit =0,withdraw = 0,transfer = 0;
        
        System.out.println("Bem vindo ao Banco");
        System.out.println("Para começarmos insira seu CPF :");
        userCpf = read.nextLine();
        userCpf = userCpf.replace(".","");
        userCpf = userCpf.replace("-","");
        
        if (!userCpf.equals(cpf)) {
            System.out.println("CPF inválido!");
        }
        else {
            System.out.println("=======================");
            for(int tries=0;tries <3;tries++) {
                System.out.println("Informe sua senha");
                userPassword = read.nextLine();
                
                if(userPassword.equals(password)) {
                    break;
                }
                
                else if(tries  == 2) {
                    System.out.println("Conta bloqueada");
                    System.exit(1);
                }
                System.out.println("Você tem mais "+ tries+1 + " tentativas");
            }
            
            while(operations != 0) {
                System.out.println("=== Menu de Operações ===");
                System.out.println("1 - Saldo");
                System.out.println("2 - Depósito");
                System.out.println("3 - Saque");
                System.out.println("4 - Transferências");
                System.out.println("5 - Consultar Extrato");
                System.out.println("0 - Sair");
                System.out.println("Escolha uma das operações básicas");
                
                operations = read.nextInt();
                
                if(operations > 5 || operations < 0) {
                    System.out.println("Por favor escolha uma opções acima!");
                }
                else {
                    switch(operations) {
                        case 1:
                            System.out.println("=== Página de Saldo === ");
                            System.out.println("Seu saldo é de : "+ balance);
                            System.out.println("Voltando para o Menu ...");
                            Thread.sleep(2000);
                            break;
                        case 2:
                            System.out.println("=== Página de Depósito === ");
                            System.out.println("Qual o valo que deseja depositar: ");
                            deposit = read.nextInt();
                            if(deposit< 0) {
                                System.out.println("Valor inválido");
                                System.out.println("Voltando para o Menu ...");
                                Thread.sleep(2000);
                                break;
                            }
                            else {
                                System.out.println("Valor depositado!!!");
                                balance = balance + deposit;
                                System.out.println("Voltando para o Menu ...");
                                bankStatement.add("Valor depositado de :"+deposit);
                                Thread.sleep(2000);
                                break;
                            }
                        case 3:
                            System.out.println("Qual valor deseja sacar: ");
                            withdraw = read.nextInt();
                            if(withdraw < 0 || withdraw > balance) {
                                System.out.println("Saque inválido");
                                Thread.sleep(2000);
                                break;
                            }
                            else {
                                System.out.println("Valor sacado com sucesso!");
                                balance = balance - withdraw;
                                bankStatement.add("Valor sacado de :"+withdraw);
                                Thread.sleep(2000);
                                break;
                            }
                        case 4:
                            System.out.println("Area de tranferência");
                            System.out.println("Digite o valor que deseja tranferir");
                            transfer = read.nextInt();
                            
                            if(transfer > balance || transfer < 0) {
                                System.out.println("Valor inválido");
                                break;
                            }
                            else {
                                int accountNumber,accountLength;
                                String account;
                                
                                int accountTypeNumber,accountTypeLength;
                                String accountType;
                                
                                int officeNumber,officeLength;
                                String office;
                                
                                int officeTypeNumber,officeTypeLength;
                                String officeType;
                                
                                System.out.println("Digite o número da conta sem espaço: ");
                                accountNumber = read.nextInt();
                                account = Integer.toString(accountNumber);
                                accountLength = account.length();
                                
                                System.out.println("Digite o digito da sua agência: ");
                                accountTypeNumber = read.nextInt();
                                accountType = Integer.toString(accountTypeNumber);
                                accountTypeLength = accountType.length();
                                
                                System.out.println("Coloque o número da agência : ");
                                officeNumber = read.nextInt();
                                office = Integer.toString(officeNumber);
                                officeLength= office.length();
                                
                                System.out.println("Coloque o digito do número da agência: ");
                                officeTypeNumber = read.nextInt();
                                officeType = Integer.toString(officeTypeNumber);
                                officeTypeLength = officeType.length();
                                
                                if( (accountLength < 0 || accountLength >  12) || (accountTypeLength < 0 || accountTypeLength > 2) || (officeLength < 0 || officeLength > 5) || (officeTypeLength < 0 || officeTypeLength > 2)) {
                                    System.out.println("Operação inválida");
                                    break;
                                }
                                else {
                                    System.out.println("Operação completada com sucesso");
                                    balance = balance - transfer;
                                    bankStatement.add("Valor transferido de :"+transfer);
                                    break;
                                }
                            }
                        case 5: 
                            System.out.println(" ===== Area de extrato ==== ");
                            for(int i =0;i < bankStatement.size();i++) {
                                System.out.println(bankStatement.get(i));
                            }
                            System.out.println("Voltando para o menu ... ");
                            Thread.sleep(2000);
                            break;
                    }
                }
            }
        }
    }
    
}
