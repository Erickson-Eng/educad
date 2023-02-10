package br.edu.ifpb.educad.config.datasource;

import br.edu.ifpb.educad.entity.*;
import br.edu.ifpb.educad.entity.Class;
import br.edu.ifpb.educad.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.*;

@Configuration
@Profile("test")
public class DataSourceRunnable implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ClassRepository classRepository;

    private Class class1;
    private Class class2;
    private Class class3;

    @Override
    public void run(String... args) throws Exception {

        this.seedClass();
        this.seedInstitution();
        this.seedTeacher();
        this.seedStudent();

    }

    private void seedClass() {
        this.class1 = new Class(
                "Turma 1",
                "2023.1",
                null,
                null,
                new HashSet<>(),
                LocalDate.now(),
                LocalDate.now()
        );

        this.class2 = new Class(
                "Turma 2",
                "2023.1",
                null,
                null,
                new HashSet<>(),
                LocalDate.now(),
                LocalDate.now()
        );

        this.class3 = new Class(
                "Turma 3",
                "2023.1",
                null,
                null,
                new HashSet<>(),
                LocalDate.now(),
                LocalDate.now()
        );
    }

    private void seedStudent() {
        User user1 = new User(
                "maria_alves",
                new BCryptPasswordEncoder().encode("senha123"),
                "maria_alves@gmail.com",
                "87911118225"
        );

        userRepository.save(user1);

        Address address1 = new Address(
                "Avenida Dutra",
                "Apto",
                "456",
                "Recife",
                "Pernambuco",
                "45888999",
                LocalDate.now(),
                LocalDate.now()
        );

        Student student1 = new Student(
                "Maria Alves",
                LocalDate.of(1990, 1, 1),
                "12863305432",
                user1,
                address1,
                "123456789",
                "Administração",
                "8",
                LocalDate.now()
        );

        studentRepository.save(student1);

        User user2 = new User(
                "carlos_peixoto",
                new BCryptPasswordEncoder().encode("qwerty123"),
                "carlos_peixoto@gmail.com",
                "87912228225"
        );

        userRepository.save(user2);

        Address address2 = new Address(
                "Rua dos Coqueiros",
                "Apto",
                "65",
                "João Pessoa",
                "Paraíba",
                "45866999",
                LocalDate.now(),
                LocalDate.now()
        );

        Student student2 = new Student(
                "Carlos Peixoto",
                LocalDate.of(1990, 1, 1),
                "92863305222",
                user2,
                address2,
                "9955111454",
                "Engenharia Civil",
                "5",
                LocalDate.now()
        );

        studentRepository.save(student2);
    }

    private void seedTeacher() {

        User user1 = new User(
                "joao_silva",
                new BCryptPasswordEncoder().encode("123abc"),
                "joao_silva@gmail.com",
                "87991178225"
        );

        userRepository.save(user1);

        Address address1 = new Address(
                "Rua Nascimento",
                "Casa",
                "78945612",
                "Rio de Janeiro",
                "Rio de Janeiro",
                "123456987",
                LocalDate.now(),
                LocalDate.now()
        );

        Subject subject1 = new Subject("Cálculo 1", "2", "123456789");

        Subject subject2 = new Subject("Álgebra Linear", "4", "123678445");

        Subject subject3 = new Subject("Cálculo 2", "3", "98456123");

        subjectRepository.saveAll(Arrays.asList(subject1, subject2, subject3));

        Teacher teacher1 = new Teacher(
                "João Silva",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                user1,
                address1
        );

        teacherRepository.save(teacher1);

        this.class1.setTeacher(teacher1);
        this.class1.setSubject(subject1);

        classRepository.save(this.class1);

        User user2 = new User(
                "renata_costa",
                new BCryptPasswordEncoder().encode("senha321"),
                "renata_costa@gmail.com",
                "87999978225"
        );

        userRepository.save(user2);

        Address address2 = new Address(
                "Rua da Aurora",
                "Casa",
                "9995554",
                "Recife",
                "Pernambuco",
                "456989999",
                LocalDate.now(),
                LocalDate.now()
        );

        Subject subject4 = new Subject("Algoritmos e Lógica de Programação", "1", "999999999");

        Subject subject5 = new Subject("Análise e Técnicas de Algoritmos", "7", "32122112");

        subjectRepository.saveAll(Arrays.asList(subject4, subject5));

        Teacher teacher2 = new Teacher(
                "Renata Costa",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                user2,
                address2
        );

        teacherRepository.save(teacher2);

        this.class2.setTeacher(teacher2);
        this.class2.setSubject(subject4);

        classRepository.save(this.class2);

        User user3 = new User(
                "pedro_goncalves",
                new BCryptPasswordEncoder().encode("qwerty321"),
                "pedro_goncalves@gmail.com",
                "87991148790"
        );

        userRepository.save(user3);

        Address address3 = new Address(
                "Rua Peixoto",
                "Apto",
                "78788754",
                "Rio de Janeiro",
                "Amazônio",
                "1116699",
                LocalDate.now(),
                LocalDate.now()
        );

        Subject subject6 = new Subject("Empreendedorismo", "10", "33557744");

        Subject subject7 = new Subject("Educação em Diversidade", "4", "32548721");

        Subject subject8 = new Subject("Direitos Humanos", "6", "789844444");

        subjectRepository.saveAll(Arrays.asList(subject6, subject7, subject8));

        Teacher teacher3 = new Teacher(
                "Pedro Gonçalves",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                user3,
                address3
        );

        teacherRepository.save(teacher3);

        this.class3.setTeacher(teacher3);
        this.class3.setSubject(subject6);

        classRepository.save(this.class3);
    }

    private void seedInstitution() {
        Course course1 = new Course("Administração", null, LocalDate.now(), LocalDate.now());
        Course course2 = new Course("Agroecologia", null, LocalDate.now(), LocalDate.now());
        Course course3 = new Course("Engenharia de Computação", null, LocalDate.now(), LocalDate.now());

        HashSet<Course> courses1 = new HashSet<>(Arrays.asList(course1, course2, course3));

        Address address1 = new Address(
                "R. Tranquilino Coelho Lemos",
                "Prédio",
                "91051209",
                "Campina Grande",
                "Paraíba",
                "40506090",
                LocalDate.now(),
                LocalDate.now()
        );

        Institution IFPB = new Institution("IFPB", address1, courses1);

        Course course4 = new Course("Odontologia", null, LocalDate.now(), LocalDate.now());
        Course course5 = new Course("Nutrição", null, LocalDate.now(), LocalDate.now());
        Course course6 = new Course("Ciência da Computação", null, LocalDate.now(), LocalDate.now());

        HashSet<Course> courses2 = new HashSet<>(Arrays.asList(course4, course5, course6));

        Address address2 = new Address(
                "Rua Gonçalo de Carvalho",
                "Casa",
                "123456987",
                "Porto Alegre",
                "Rio Grande do Sul",
                "123753951",
                LocalDate.now(),
                LocalDate.now()
        );

        Institution UFCG = new Institution("UFCG", address2, courses2);

        Course course7 = new Course("Física", null, LocalDate.now(), LocalDate.now());
        Course course8 = new Course("Letras", null, LocalDate.now(), LocalDate.now());
        Course course9 = new Course("Farmácia", null, LocalDate.now(), LocalDate.now());

        HashSet<Course> courses3 = new HashSet<>(Arrays.asList(course7, course8, course9));

        Address address3 = new Address(
                "Rua das Pedras",
                "Apto",
                "369852147",
                "Búzios",
                "Rio de Janeiro",
                "789951741",
                LocalDate.now(),
                LocalDate.now()
        );

        Institution UNINASSAU = new Institution("UNINASSAU", address3, courses3);

        Course course10 = new Course("Ciências Contábeis", null, LocalDate.now(), LocalDate.now());
        Course course11 = new Course("Engenharia Civil", null, LocalDate.now(), LocalDate.now());
        Course course12 = new Course("Enfermagem", null, LocalDate.now(), LocalDate.now());

        HashSet<Course> courses4 = new HashSet<>(Arrays.asList(course10, course11, course12));

        Address address4 = new Address(
                "Av. Mal. Floriano Peixoto",
                "Prédio",
                "147852365",
                "Campina Grande",
                "Paríba",
                "123456965",
                LocalDate.now(),
                LocalDate.now()
        );

        Institution UEPB = new Institution("UEPB", address4, courses4);

        institutionRepository.saveAll(Arrays.asList(IFPB, UFCG, UNINASSAU, UEPB));
    }
}
