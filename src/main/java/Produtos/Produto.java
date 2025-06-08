package Produtos;

public class Produto 
{
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto (int codigo, String nome, double preco, int quantidade) throws IllegalArgumentException
    {
        if (codigo <= 0 || codigo > 999)
        {
        throw new IllegalArgumentException ("Código inválido.");
        }
        if (nome == null || nome.trim().isEmpty() || !nome.matches(".*[a-zA-Z].*"))
        {
            throw new IllegalArgumentException ("Nome inválido.");
        }
        if (preco < 0)
        {
            throw new IllegalArgumentException ("Preço inválido.");
        }
        if (quantidade < 0)
        {
            throw new IllegalArgumentException ("Quantidade inválida.");
        } 
         this.codigo = codigo;
         this.nome = nome;
         this.preco = preco;
         this.quantidade = quantidade;        
    }
    
    //Gets
            
      public int getCodigo()
    {
         return this.codigo;
    }
  
    public String getNome()
    {
        return this.nome;
    }
    
    public double getPreco()
    {
        return this.preco;
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    // Sets
    
    public void setCodigo(int c)
    {   
        if (c <= 0 || c > 999) 
        {
            throw new IllegalArgumentException("Código inválido.");
        }
         this.codigo = c;
    }
    
    public void setNome(String n)
    {
        if (n == null || n.trim().isEmpty() || !nome.matches(".*[a-zA-Z].*"))
        {
            throw new IllegalArgumentException ("Nome inválido.");
        }
         this.nome = n;
    }
    
    public void setPreco(double p)
    {
        if (p < 0)
        {
            throw new IllegalArgumentException ("Preço inválido.");
        }
         this.preco = p;
    }
    
    public void setQuantidade(int q)
    {
        if (q < 0)
        {
            throw new IllegalArgumentException ("Quantidade inválida.");
        } 
         this.quantidade = q;
    }
    
    public void exibirInfo()
    {
        System.out.println("\n------------------\n");
        System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("QtnoEstoque: " + this.quantidade);
        System.out.println("\n------------------\n");
    }
   
    public void vender(int qtdVendida) 
    {
        if (qtdVendida < 1) 
        {   
            throw new IllegalArgumentException("Quantidade de venda deve ser maior que zero.");
        }
        if (qtdVendida > quantidade) 
        {
        throw new IllegalArgumentException("Estoque insuficiente para a venda.");
        }

        quantidade -= qtdVendida;
        System.out.println("Venda realizada com sucesso. Restam " + quantidade + " unidades no estoque.");
    }
    
    public void reabastecer(int ReabEstoque)
    {
        if (ReabEstoque < 1) 
        {   
            throw new IllegalArgumentException("Quantidade da reposição deve ser maior que zero.");
        }
        
        quantidade += ReabEstoque;
        System.out.println("Reabastecimento realizado corretamente. Restam " + quantidade + " unidades no estoque.");
    }
    
    public void aplicarDesconto (double percentual)
    {
        if (percentual < 1 || percentual > 90) 
        {
            throw new IllegalArgumentException("Percentual de desconto deve estar entre 1% e 90%.");
        }

        double desconto = preco * (percentual / 100.0);
        preco -= desconto;
        System.out.printf("Desconto de %.2f%% aplicado com sucesso. Novo preço: R$ %.2f%n", percentual, this.preco);
    }
        
}
