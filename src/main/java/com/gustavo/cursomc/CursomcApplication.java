package com.gustavo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.domain.Cidade;
import com.gustavo.cursomc.domain.Cliente;
import com.gustavo.cursomc.domain.Endereco;
import com.gustavo.cursomc.domain.Estado;
import com.gustavo.cursomc.domain.Produto;
import com.gustavo.cursomc.domain.enums.TipoCliente;
import com.gustavo.cursomc.repositories.CategoriaRepository;
import com.gustavo.cursomc.repositories.CidadeRepository;
import com.gustavo.cursomc.repositories.ClienteRepository;
import com.gustavo.cursomc.repositories.EnderecoRepository;
import com.gustavo.cursomc.repositories.EstadoRepository;
import com.gustavo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	@Autowired
	public CategoriaRepository categoriaRepository;
	@Autowired
	public ProdutoRepository produtoRepository;
	@Autowired
	public EstadoRepository estadoRepository;
	@Autowired
	public CidadeRepository cidadeRepository;
	@Autowired
	public ClienteRepository clienteRepository;
	@Autowired
	public EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String  ...args) throws Exception {
		Categoria cat1 = new Categoria (null, "Escritório");
		Categoria cat2 = new Categoria (null, "Informatica");
		
		Produto prod1 = new Produto (null, "Computador", 4000.00);
		Produto prod2 = new Produto (null, "Impressora", 300.00);
		Produto prod3 = new Produto (null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade cid1 = new Cidade (null, "Belo Horizonte", est1);
		Cidade cid2 = new Cidade (null, "Ouro Preto", est1);
		Cidade cid3 = new Cidade (null, "São Paulo", est2);
		Cidade cid4 = new Cidade (null, "Cubatão", est2);
		Cidade cid5 = new Cidade (null, "Osasco", est2);
		Cidade cid6 = new Cidade (null, "Ribeirão Preto", est2);
		Cidade cid7 = new Cidade (null, "Uberlândia", est1);
		Cidade cid8 = new Cidade (null, "Juíz de Fora", est1);
		Cidade cid9 = new Cidade (null, "Bauru", est2);
		Cidade cid10 = new Cidade (null, "Piracicaba", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2, cid7, cid8));
		est1.getCidades().addAll(Arrays.asList(cid3, cid4, cid5, cid6, cid9, cid10));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4, cid5, cid6, cid7, cid8, cid9, cid10));
		
		Cliente cli1 = new Cliente (null, "Maria Silva", "maria@gmail.com", "3637383940", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente (null, "José Pereira", "jose@gmail.com", "6667686970", TipoCliente.PESSOAFISICA);
		Cliente cli3 = new Cliente (null, "Pedro Costa", "pedro@gmail.com", "7677787980", TipoCliente.PESSOAFISICA);
		Cliente cli4 = new Cliente (null, "Lucio Montanhe", "lucio@gmail.com", "9697989990", TipoCliente.PESSOAJURIDICA);
		Cliente cli5 = new Cliente (null, "Adriana Castro", "adriana@gmail.com", "0607080910", TipoCliente.PESSOAJURIDICA);
		Cliente cli6 = new Cliente (null, "Vanessa Sousa", "vanessa@gmail.com", "1617181920", TipoCliente.PESSOAJURIDICA);

		cli1.getTelefones().addAll(Arrays.asList("2627282930", "4647484950"));
		cli2.getTelefones().addAll(Arrays.asList("7677787980", "5657585960"));
		cli3.getTelefones().addAll(Arrays.asList("8687888990", "6667686970"));
		cli4.getTelefones().addAll(Arrays.asList("9697989900", "7677787980"));
		cli5.getTelefones().addAll(Arrays.asList("0607080911", "8687888990"));
		cli6.getTelefones().addAll(Arrays.asList("1617181920", "9697989910"));
		
		Endereco end1 = new Endereco (null, "Rua das Flores", "16", "Quadra das Margaridas", "Palmeiras", "60000001", cli1, cid1);
		Endereco end2 = new Endereco (null, "Rua das Plantas", "27", "Quadra das Árvores", "Orquídeas", "60000002", cli2, cid2);
		Endereco end3 = new Endereco (null, "Rua das Garças", "38", "Quadra das Pedras", "Gatos", "60000003", cli3, cid3);
		Endereco end4 = new Endereco (null, "Rua das Pedras", "49", "Quadra dos Cachorros", "Brita", "60000004", cli4, cid4);
		Endereco end5 = new Endereco (null, "Rua das Camaleõas", "50", "Quadra das Pratas", "Camelo", "60000005", cli5, cid5);
		Endereco end6 = new Endereco (null, "Rua das Leoas", "61", "Quadra das Citrinas", "Leopardo", "60000006", cli6, cid6);
		Endereco end7 = new Endereco (null, "Rua das Mentas", "72", "Quadra das Tilápias", "Carvalho", "60000007", cli1, cid7);
		Endereco end8 = new Endereco (null, "Rua das Sardinhas", "83", "Quadra das Mangueiras", "Pirarucu", "60000008", cli3, cid8);
		Endereco end9 = new Endereco (null, "Rua das Americanas", "94", "Quadra das Atlânticas", "Alemanha", "60000009", cli5, cid9);
		Endereco end10 = new Endereco (null, "Rua das Pacíficas", "05", "Quadra das Belgas", "Índico", "60000010", cli6, cid10);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end7));
		cli1.getEnderecos().addAll(Arrays.asList(end2));
		cli1.getEnderecos().addAll(Arrays.asList(end3, end8));
		cli1.getEnderecos().addAll(Arrays.asList(end4));
		cli1.getEnderecos().addAll(Arrays.asList(end5, end9));
		cli1.getEnderecos().addAll(Arrays.asList(end6, end10));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5, end6, end7, end8, end9, end10));
		
	}
}
