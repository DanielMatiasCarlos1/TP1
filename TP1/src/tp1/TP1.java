package tp1;

import java.util.Scanner;

public class TP1 {

	public static void main(String[] args) {
		
		int opcao;
		int contaPosicao = 0;
		int contaProduto = 0;
		
		//String para cadastro de clientes
		String[][] cliente = new String[50][3];
		
		//String para cadastro de produtos
		String[][] produto = new String[50][4];
		int[] produtoEstoque = new int[50];
		
		Scanner ler = new Scanner(System.in);
		
		bem_vindo();
		menu();
		opcao = ler.nextInt();
		
		while(opcao !=7) {           //Abre o menu enquanto nao for escolhida a opcao de sair do programa
			escolha_menu(opcao, cliente, produto, contaPosicao, contaProduto, produtoEstoque);
			menu();
			opcao = ler.nextInt();
		}	
		System.out.println("Programa encerrado");
		
	}

	public static void bem_vindo() {
		
		System.out.println("~~~~~~~~~~Bem vindo ao menu de cadastramento!~~~~~~~~~~");
	}
	
	public static void menu() { //Void para printar o menu na tela
		
		
		System.out.println("");
		System.out.println("     1- Cadastro de novo cliente");
		System.out.println("     2- Busca por cliente");
		System.out.println("     3- Cadastro de novo produto");
		System.out.println("     4- Busca por produto");
		System.out.println("     5- Cadastro de venda");
		System.out.println("     6- Mostrar produtos em estoque");
		System.out.println("     7- Sair");
		System.out.println("");
		System.out.println("     Escolha a opção desejada:");
		
	}
	
	public static void escolha_menu(int opcao, String cliente[][], String produto[][], int contaPosicao, int contaProduto, int produtoEstoque[]) {   //Void no qual se escolhe a opcao do menu
		
		
		
		Scanner ler = new Scanner(System.in);
		
		
			while(opcao < 1 || opcao > 7) {
				System.out.println("Essa opção não é válida, digite novamente");
				opcao = ler.nextInt();
			}
			switch (opcao) {
				case 1:
					System.out.println("Cadastro de cliente:");
					menu1(cliente, contaPosicao);
					break;
				case 2:
					System.out.println("Busca por cliente:");
					menu2(cliente, contaPosicao);
					break;
				case 3:
					System.out.println("Cadastro de produto:");
					menu3(produto, contaProduto, produtoEstoque);
					break;
				case 4:
					System.out.println("Busca por produto:");
					menu4(produto, produtoEstoque);
					break;
				case 5:
					System.out.println("Cadastro de vendas:");
					menu5(cliente, produto, produtoEstoque);
					break;
				case 6:
					System.out.println("Produtos em estoque:");
					menu6(produto);
					break;
			}
			
			
	}

	public static int menu1(String cliente[][], int contaPosicao) {
		
		int qtd;
		int i;
		String limpa;
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de clientes a serem cadastrados:");
		qtd = ler.nextInt();
		System.out.println(contaPosicao);
		if(contaPosicao > 0) {
			for(i=contaPosicao; i<contaPosicao+qtd; i++) {
				System.out.println("Digite os dados do cliente:");
				System.out.println("Nome:");
				if(i == 0) {
					limpa = ler.nextLine();
				}
				cliente[i][0] = ler.nextLine();
				System.out.println("");
				System.out.println("Endereço:");
				
				cliente[i][1] = ler.nextLine();
				System.out.println("");
				System.out.println("Telefone:");
			
				cliente[i][2] = ler.nextLine();
				
				System.out.println(contaPosicao);
			}
		}else {
			for(i=0; i<contaPosicao+qtd; i++) {
				System.out.println("Digite os dados do cliente:");
				System.out.println("Nome:");
				if(i == 0) {
					limpa = ler.nextLine();
				}
				cliente[i][0] = ler.nextLine();
				System.out.println("");
				System.out.println("Endereço:");
			
				cliente[i][1] = ler.nextLine();
				System.out.println("");
				System.out.println("Telefone:");
		
				cliente[i][2] = ler.nextLine();
			
				
			}
		}
		
		contaPosicao = contaPosicao + qtd;
		
		return contaPosicao;
		
	}
	
	public static void menu2(String cliente[][], int contaPosicao) {
		
		int escolheDado;
		char mudaDado;
		String nome;
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o nome do cliente para a busca:");
		nome = ler.nextLine();
		
		
		for(int j=0; j<50; j++) {
				if(nome.equalsIgnoreCase(cliente[j][0])) {
					System.out.println("Dados do cliente: ");
					System.out.println("");
					System.out.println("Nome: " + cliente[j][0]);
					System.out.println("Endereço: " + cliente[j][1]);
					System.out.println("Telefone: " + cliente[j][2]);
					System.out.println("");
					System.out.println("Deseja alterar os dados? Caso sim, digite 'S', caso nao, digite 'N'");
					mudaDado = ler.next().charAt(0);
					
					if(mudaDado == 'S') {
						System.out.println("Qual dado deseja alterar?");
						System.out.println("");
						System.out.println("1- Nome");
						System.out.println("2- Endereço");
						System.out.println("3- Telefone");
						System.out.println("");
						escolheDado = ler.nextInt();
						
						if(escolheDado == 1) {
							System.out.println("Digite o novo nome");
							cliente[j][0] = ler.nextLine();	
						}else if(escolheDado == 2) {
							System.out.println("Digite o novo endereço");
							cliente[j][1] = ler.nextLine();
						}else if(escolheDado == 3) {
							System.out.println("Digite o novo telefone");
							cliente[j][2] = ler.nextLine();
						}
						
					}else {
						break;
					}
				}else {
					System.out.println("Cliente não encontrado");
				}
		}
	}
		
	public static void menu3(String produto[][], int contaProduto, int produtoEstoque[]) {
		
		int qtdProdutos;
		
		int k;
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de produtos a serem cadastrados:");
		qtdProdutos = ler.nextInt();
		
		contaProduto = contaProduto + qtdProdutos;
		
		for(k=0; k<contaProduto; k++) {
			System.out.println("Digite os dados do produto:");
			System.out.println("Nome:");
			produto[k][0] = ler.nextLine();
			System.out.println("Descrição:");
			produto[k][1] = ler.nextLine();
			System.out.println("Valor de compra:");
			produto[k][2] = ler.nextLine();
			System.out.println("Porcentagem de lucro:");
			produto[k][3] = ler.nextLine();
			System.out.println("Quantidade em estoque:");
			produtoEstoque[k] = ler.nextInt();
		}
		
		k = contaProduto;
	}
	
	public static void menu4(String produto[][], int produtoEstoque[]) {
		int escolheDadoProduto;
		char mudaDado;
		String nomeProduto;
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o nome do cliente para a busca:");
		nomeProduto = ler.nextLine();
		
		
		for(int b=0; b<50; b++) {
				if(nomeProduto.equalsIgnoreCase(produto[b][0])) {
					System.out.println("Dados do cliente: ");
					System.out.println("");
					System.out.println("Nome: " + produto[b][0]);
					System.out.println("Descrição: " + produto[b][1]);
					System.out.println("Valor: " + produto[b][2]);
					System.out.println("Porcentagem de lucro: " + produto[b][3]);
					System.out.println("Estoque: " + produtoEstoque[b]);
					System.out.println("");
					System.out.println("Deseja alterar os dados? Caso sim, digite 'S', caso nao, digite 'N'");
					mudaDado = ler.next().charAt(0);
					
					if(mudaDado == 'S') {
						System.out.println("Qual dado deseja alterar?");
						System.out.println("");
						System.out.println("1- Nome");
						System.out.println("2- Descrição");
						System.out.println("3- Valor");
						System.out.println("4- Porcentagem de lucro");
						System.out.println("5- Estoque");
						System.out.println("");
						escolheDadoProduto = ler.nextInt();
						
						if(escolheDadoProduto == 1) {
							System.out.println("Digite o novo nome");
							produto[b][0] = ler.nextLine();	
						}else if(escolheDadoProduto == 2) {
							System.out.println("Digite a nova descrição");
							produto[b][1] = ler.nextLine();
						}else if(escolheDadoProduto == 3) {
							System.out.println("Digite o novo valor");
							produto[b][2] = ler.nextLine();
						}else if(escolheDadoProduto == 4){
							System.out.println("Digite a nova porcentagem de lucro");
							produto[b][3] = ler.nextLine();
						}else if(escolheDadoProduto == 5){
							System.out.println("Digite o novo estoque");
							produtoEstoque[b] = ler.nextInt();
						}
						
					}else {
						break;
					}
				}else {
					System.out.println("Produto não encontrado");
				}
		}
	}
	
	public static void menu5(String cliente[][], String produto[][], int produtoEstoque[]) {
		
		String escolhaCliente, escolhaProduto;
		int m, n, qtdVenda, converte;
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Lista de clientes cadastrados:");
		
		for(m=0; m<50; m++) {
			System.out.println(cliente[m][0]);
		}
		
		System.out.println("Escolha um cliente:");
		escolhaCliente = ler.nextLine();
		
		for(m=0; m<50; m++) {
			if(escolhaCliente.equalsIgnoreCase(cliente[m][0])) {
				System.out.println("Lista de produtos cadastrados:");
				for(n=0; n<50; n++) {
					System.out.println(produto[n][0]);
				}
				
				System.out.println("Escolha um produto:");
				escolhaProduto = ler.nextLine();
				System.out.println("Qual foi a quantidade vendida para o cliente " + cliente[m][0] + "?");
				qtdVenda = ler.nextInt();
				produtoEstoque[n] = produtoEstoque[n] - qtdVenda; 
				
				
			}else {
				System.out.println("Esse cliente nao foi cadastrado, retornando ao menu principal");
				break;
			}
		}
		
	}
	
	public static void menu6(String produto[][]) {
		
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Produtos cadastrados:");
		System.out.println("");
		
		for(int l=0; l<50; l++) {
			System.out.println("Nome: " + produto[l][0] + ", Quantidade em estoque: " + produto[l][4]);
		}
	}


}
