package br.edu.ifpb.educad.config.datasource;

import br.edu.ifpb.educad.entity.*;
import br.edu.ifpb.educad.repository.*;
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

    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public void run(String... args) throws Exception {

//        User user1 = new User("joao_silva", "123abc", "joao@gmail.com", "87991178225");
//        User user2 = new User("marina_araujo", "321ljkh", "marina@gmail.com", "77991175525");
//        userRepository.saveAll(Arrays.asList(user1, user2));
//
//        Address address1 = new Address("Rua dos Alfeneiros", "Casa", "40028922", "Remígio", "Paraíba", "40028922");
//        Address address2 = new Address("Rua das Pitangas", "Apto", "91051209", "Juazeiro", "Pernambuco", "40506090");
//        addressRepository.saveAll(Arrays.asList(address1, address2));

        Course course1 = new Course("Administração", null, null, null);
        Course course2 = new Course("Agroecologia", null, null, null);
        Course course3 = new Course("Engenharia de Computação", null, null, null);
        HashSet<Course> coursesIfpb = new HashSet<>(Arrays.asList(course1, course2, course3));

        Address address3 = new Address("R. Tranquilino Coelho Lemos", "Prédio", "91051209", "Campina Grande", "Paraíba", "40506090");
        Institution ifpb = new Institution("IFPB", address3, coursesIfpb, null, null);

        Address address4 = new Address("Rua Gonçalo de Carvalho", "Casa", "123456987", "Porto Alegre", "Rio Grande do Sul", "123753951");
        Institution ufcg = new Institution("UFCG", address4, null, null, null);

        Address address5 = new Address("Rua das Pedras", "Apto", "369852147", "Búzios", "Rio de Janeiro", "789951741");
        Institution uninassau = new Institution("UNINASSAU", address5, null, null, null);

        Address address6 = new Address("Av. Mal. Floriano Peixoto", "Prédio", "147852365", "Campina Grande", "Paríba", "123456965");
        Institution fip = new Institution("FIP", address6, null, null, null);

        institutionRepository.saveAll(Arrays.asList(ifpb, ufcg, uninassau, fip));

//        Map<String, Discipline> disciplineMap = new HashMap<>();
//        Discipline discipline1 = new Discipline(1L,
//                "Cálculo 1",
//                "2",
//                "123456789",
//                null,
//                LocalDate.of(2022, 9, 28),
//                LocalDate.of(2022, 9, 28));
//        disciplineRepository.save(discipline1);
//        disciplineMap.put("disciplina1", discipline1);
//
//        Teacher teacher1 = new Teacher(1L,
//                "João Silva",
//                LocalDate.of(2022, 9, 28),
//                "12862305432",
//                user1,
//                address1,
//                LocalDate.of(2022, 9, 28),
//                LocalDate.of(2022, 9, 28),
//                disciplineMap);
//        teacherRepository.save(teacher1);
    }
}
