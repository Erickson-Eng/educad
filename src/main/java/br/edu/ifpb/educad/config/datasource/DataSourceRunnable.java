package br.edu.ifpb.educad.config.datasource;

import br.edu.ifpb.educad.entity.Address;
import br.edu.ifpb.educad.entity.User;
import br.edu.ifpb.educad.repository.AddressRepository;
import br.edu.ifpb.educad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class DataSourceRunnable implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("joao_silva", "123abc", "joao@gmail.com", "87991178225");
        User user2 = new User("marina_araujo", "321ljkh", "marina@gmail.com", "77991175525");
        userRepository.saveAll(Arrays.asList(user1, user2));

        Address address1 = new Address("Rua dos Alfeneiros", "Casa", "40028922", "Remígio", "Paraíba", "40028922");
        Address address2 = new Address("Rua das Pitangas", "Apto", "91051209", "Juazeiro", "Pernambuco", "40506090");
        addressRepository.saveAll(Arrays.asList(address1, address2));
    }
}
