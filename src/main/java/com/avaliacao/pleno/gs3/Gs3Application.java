package com.avaliacao.pleno.gs3;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avaliacao.pleno.gs3.entity.ClienteEntity;
import com.avaliacao.pleno.gs3.entity.EnderecoEntity;
import com.avaliacao.pleno.gs3.entity.TelefoneEntity;
import com.avaliacao.pleno.gs3.entity.UsuarioEntity;
import com.avaliacao.pleno.gs3.enums.TipoTelefoneEnum;
import com.avaliacao.pleno.gs3.repository.ClienteRepository;
import com.avaliacao.pleno.gs3.repository.UsuarioRepository;


@SpringBootApplication
public class Gs3Application implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private ClienteRepository cltRepository;

	public static void main(String[] args) {
		SpringApplication.run(Gs3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Carga Inicial pra incluir perfil ADMIN(1) e COMUM(2)
		//Carga Inicial pra incluir usuario ADMIN e COMUM
		
		Set<Integer> perfilAdmin = new HashSet<Integer>();
		perfilAdmin.add(1);
		
		UsuarioEntity user = new UsuarioEntity("admin","123456",perfilAdmin);
		
		Set<Integer> perfilComum = new HashSet<Integer>();
		perfilComum.add(2);
		
		UsuarioEntity user2 = new UsuarioEntity("comum", "123456",perfilComum);
		
		userRepository.saveAll(Arrays.asList(user,user2));
		
		//Carga Inicial Clientes
		
		TelefoneEntity telefone = new TelefoneEntity(TipoTelefoneEnum.CELULAR.getCod(), 992643323, 61);
		EnderecoEntity endereco = new EnderecoEntity(71805114, "logradouro", "riachofundo", "Brasilia", "DF", "teste");
		Set<String> emails = new HashSet<String>();
		emails.add("douglas.ferreiramm@hotmail.com");
		
		ClienteEntity cliente1 = new ClienteEntity( "Douglas Ferreira", 
				"03075331155", 
				endereco, Arrays.asList(telefone), 
				emails);
		
		TelefoneEntity telefone2 = new TelefoneEntity(TipoTelefoneEnum.CELULAR.getCod(), 984098373, 61);
		EnderecoEntity endereco2 = new EnderecoEntity(72010110, "logradouro", "pampulha", "Belo Horizonte", "MG", "teste");
		Set<String> emails2 = new HashSet<String>();
		emails2.add("laissa.vitoria@hotmail.com");
		
		ClienteEntity cliente2 = new ClienteEntity( "Laissa Vitoria", 
				"09077598405", 
				endereco2, Arrays.asList(telefone2), 
				emails2);
		
		TelefoneEntity telefone3 = new TelefoneEntity(TipoTelefoneEnum.CELULAR.getCod(), 992642145, 61);
		EnderecoEntity endereco3 = new EnderecoEntity(72010110, "logradouro", "novo gama", "Goias", "GO", "teste");
		Set<String> emails3 = new HashSet<String>();
		emails3.add("larissaa.ferreira@hotmail.com");
		
		ClienteEntity cliente3 = new ClienteEntity( "Larissa Ferreira", 
				"78965412302", 
				endereco3, Arrays.asList(telefone3), 
				emails3);
		
		TelefoneEntity telefone4 = new TelefoneEntity(TipoTelefoneEnum.CELULAR.getCod(), 987653521, 62);
		EnderecoEntity endereco4 = new EnderecoEntity(72010173, "logradouro", "belo horizonte", "BH", "MG", "teste2");
		Set<String> emails4 = new HashSet<String>();
		emails4.add("jose.enrico@hotmail.com");
		
		ClienteEntity cliente4 = new ClienteEntity( "Jose Enrico", 
				"09077598745", 
				endereco4, Arrays.asList(telefone4), 
				emails4);
		
		TelefoneEntity telefone5 = new TelefoneEntity(TipoTelefoneEnum.CELULAR.getCod(), 992642145, 61);
		EnderecoEntity endereco5 = new EnderecoEntity(72010121, "logradouro", "brasilia", "Brasilia", "DF", "teste3");
		Set<String> emails5 = new HashSet<String>();
		emails5.add("jose.soares@hotmail.com");
		
		ClienteEntity cliente5 = new ClienteEntity( "Jose Soares", 
				"74185296365", 
				endereco5, Arrays.asList(telefone5), 
				emails5);
		
		
		cltRepository.saveAll(Arrays.asList(cliente1,cliente2,cliente3,cliente4,cliente5));
	}

}
