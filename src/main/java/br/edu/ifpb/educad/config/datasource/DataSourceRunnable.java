package br.edu.ifpb.educad.config.datasource;

import br.edu.ifpb.educad.entity.Address;
import br.edu.ifpb.educad.entity.Discipline;
import br.edu.ifpb.educad.entity.Teacher;
import br.edu.ifpb.educad.entity.User;
import br.edu.ifpb.educad.repository.AddressRepository;
import br.edu.ifpb.educad.repository.DisciplineRepository;
import br.edu.ifpb.educad.repository.TeacherRepository;
import br.edu.ifpb.educad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.*;

@Configuration
@Profile("test")
public class DataSourceRunnable implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("joao_silva", "123abc", "joao@gmail.com", "87991178225");
        User user2 = new User("marina_araujo", "321ljkh", "marina@gmail.com", "77991175525");
        userRepository.saveAll(Arrays.asList(user1, user2));

        Address address1 = new Address("Rua dos Alfeneiros", "Casa", "40028922", "Remígio", "Paraíba", "40028922");
        Address address2 = new Address("Rua das Pitangas", "Apto", "91051209", "Juazeiro", "Pernambuco", "40506090");
        addressRepository.saveAll(Arrays.asList(address1, address2));

        Map<String, Discipline> disciplineMap = new HashMap<>();
        Discipline discipline1 = new Discipline(1L,
                "Cálculo 1",
                "2",
                "123456789",
                null,
                LocalDate.of(2022, 9, 28),
                LocalDate.of(2022, 9, 28));
        disciplineRepository.save(discipline1);
        disciplineMap.put("disciplina1", discipline1);

        Teacher teacher1 = new Teacher(1L,
                "João Silva",
                LocalDate.of(2022, 9, 28),
                "12862305432",
                user1,
                address1,
                LocalDate.of(2022, 9, 28),
                LocalDate.of(2022, 9, 28),
                disciplineMap);
        teacherRepository.save(teacher1);
    }
}
