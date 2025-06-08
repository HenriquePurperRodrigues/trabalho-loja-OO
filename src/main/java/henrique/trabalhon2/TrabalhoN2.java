package henrique.trabalhon2;

// Nome: Henrique Purper Rodrigues

import Produtos.*;
import java.util.Scanner;

public class TrabalhoN2 
{
  
    public static void main(String[] args) 
    {
        Scanner entrada = new Scanner (System.in);
        int cont = 0;
        
        char acesso;
        
        Produto[] p = new Produto [10];
        
        do {
        System.out.println("\nIncluir produtos -> I");
        System.out.println("Mostrar produtos -> M");
        System.out.println("Quantidade em estoque -> Q");
        System.out.println("Vendas -> V");
        System.out.println("Reabastecimento -> R");
        System.out.println("Aplicação de desconto -> D");
        System.out.println("Fim -> F");
        System.out.print("Digite aqui: ");
        acesso = Character.toUpperCase(entrada.nextLine().charAt(0));
        
        switch (acesso)
        {
            case 'I':
                if (cont >= p.length)
                {
                    System.out.println("Limite atingido!!");
                    break;
                }
                
                try 
                {      
                System.out.print("\nDigite o código: ");
                 int cod = entrada.nextInt();
                 entrada.nextLine();
                
                 
                int codigoExiste = 0;
                for (int i = 0; i < cont; i++) 
                {
                  if (p[i].getCodigo() == cod) 
                  {
                    codigoExiste = 1;
                    break;
                  }
                }

                if (codigoExiste == 1) 
                {
                    System.out.println("Já existe um produto com esse código.");
                    break;
                }
                 
                System.out.print("Digite o nome: ");
                 String nom = entrada.nextLine();
                System.out.print("Digite o preço: ");
                double preco = entrada.nextDouble();
                System.out.print("Digite a quantidade: ");
                int quant = entrada.nextInt();
                entrada.nextLine();
                
                    Produto novoProduto = new Produto(cod, nom, preco, quant);
                    p[cont] = novoProduto;
                    cont++;
                    System.out.println("Produto adicionado com sucesso");
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println("Erro ao criar produto: " + e.getMessage());
                }
                break;
            case 'M':
                if (cont == 0) 
                {
                    System.out.println("Nenhum produto cadastrado ainda.");
                } 
                else 
                {
                    System.out.println("Lista de produtos:");
                    for (int i = 0; i < cont; i++) 
                    {
                        p[i].exibirInfo();
                    }
                }
                break;
            case 'Q':
                System.out.print("Digite o código do produto: ");
                String entradaCod = entrada.nextLine();
                
                int codigo;

                try 
                {
                    codigo = Integer.parseInt(entradaCod);
                    
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Código inválido. Deve ser um número inteiro.");
                    break;
                }
                
                if (codigo < 1 || codigo > 999)
                {
                    System.out.println("Código inválido. Deve estar nas especificações corretas.");
                    
                }
                
                int encontrarProd = 0;

                for (int i = 0; i < cont; i++) 
                {
                    if (p[i].getCodigo() == codigo) 
                    {    
                        System.out.println("Quantidade em estoque do produto \"" + p[i].getNome() + "\": " + p[i].getQuantidade());
                        encontrarProd = 1;
                        break;
                    }
                }

               if (encontrarProd == 0) 
               {
                   System.out.println("Produto com código " + codigo + " não encontrado.");
               }
                break;
            case 'V':  
                System.out.print("Digite o código do produto: "); //Reutilizando a lógica de verificação usada anteriormente
                entradaCod = entrada.nextLine();
               
                try 
                {
                  codigo = Integer.parseInt(entradaCod);
                  
                  if (codigo < 1 || codigo > 999)
                  {
                    System.out.println("Código inválido. Deve estar nas especificações corretas.");
                    break;
                  }
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Código inválido. Deve ser um número inteiro.");
                    break;
                }
                
                Produto produtoEncontrado = null;
                for (int i = 0; i < cont; i++) 
                {
                    if (p[i].getCodigo() == codigo) 
                    {
                        produtoEncontrado = p[i];
                        break;
                    }
                }
                
                if (produtoEncontrado == null) 
                {
                    System.out.println("Produto com código " + codigo + " não encontrado.");
                    break;
                }
                
                 System.out.print("Digite a quantidade a ser vendida: ");
                 String entradaQtd = entrada.nextLine();

                 try 
                 {
                    int qtdVendida = Integer.parseInt(entradaQtd);

                    produtoEncontrado.vender(qtdVendida);
                 } 
                 catch (NumberFormatException e) 
                 {
                    System.out.println("Quantidade inválida. Deve ser um número inteiro.");
                 } 
                 break;
            case 'R':
                //Lógica quase idêntica ao caso anterior, basicamente fazendo o processo inverso
                 System.out.print("Digite o código do produto: "); 
                 String entradaCodR = entrada.nextLine();
               
                 int codigoR;
                
                 try 
                 {
                    codigoR = Integer.parseInt(entradaCodR);
                  
                    if (codigoR < 1 || codigoR > 999)
                    {
                        System.out.println("Código inválido. Deve estar nas especificações corretas.");
                        break;
                    }
                  } 
                  catch (NumberFormatException e) 
                  {
                       System.out.println("Código inválido. Deve ser um número inteiro.");
                       break;
                  }
                
                Produto produtoExiste = null;
                for (int i = 0; i < cont; i++) 
                {
                    if (p[i].getCodigo() == codigoR) 
                    {
                        produtoExiste = p[i];
                        break;
                    }
                }
                
                if (produtoExiste == null) 
                {
                    System.out.println("Produto com código " + codigoR + " não encontrado.");
                    break;
                }
               
                System.out.print("Digite a quantidade a ser reabastecida: ");
                String entradaR = entrada.nextLine();

                 try 
                 {
                    int qtdReabastecida = Integer.parseInt(entradaR);

                    produtoExiste.reabastecer(qtdReabastecida);
                 } 
                 catch (NumberFormatException e) 
                 {
                    System.out.println("Quantidade inválida. Deve ser um número inteiro.");
                 } 
                 break;
            case 'D':
                 System.out.print("Digite o código do produto: "); 
                 entradaCod = entrada.nextLine();
              
                 try 
                 {
                    codigo = Integer.parseInt(entradaCod);
                  
                    if (codigo < 1 || codigo > 999)
                    {
                        System.out.println("Código inválido. Deve estar nas especificações corretas.");
                        break;
                    }
                  } 
                  catch (NumberFormatException e) 
                  {
                       System.out.println("Código inválido. Deve ser um número inteiro.");
                       break;
                  }
                
                 produtoExiste = null;
                 for (int i = 0; i < cont; i++) 
                 {
                    if (p[i].getCodigo() == codigo) 
                    {
                        produtoExiste = p[i];
                        break;
                    }
                 }
                
                 if (produtoExiste == null) 
                 {
                    System.out.println("Produto com código " + codigo + " não encontrado.");
                    break;
                 }
                 
                 System.out.print("Digite o percentual que deseja aplicar: ");
                 String entradaD = entrada.nextLine();

                 try 
                 {
                    double descontEstoque = Double.parseDouble(entradaD);
                    produtoExiste.aplicarDesconto(descontEstoque);
                 } 
                 catch (NumberFormatException e) 
                 {
                    System.out.println("Valor inválido. Deve ser um número decimal ou inteiro.");
                 }
         }
        } while (acesso != 'F');   
    }   
}
        
