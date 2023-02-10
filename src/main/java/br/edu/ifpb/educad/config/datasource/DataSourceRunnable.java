package br.edu.ifpb.educad.config.datasource;

import br.edu.ifpb.educad.entity.*;
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

    @Override
    public void run(String... args) throws Exception {

        this.seedInstitution();
        this.seedTeacher();
        this.seedStudent();

    }

    private void seedStudent() {
        User userMaria = new User("maria_alves", new BCryptPasswordEncoder().encode("789poi"), "maria_alves@gmail.com", "87911118225");
        userRepository.save(userMaria);

        Address avenidaDutra = new Address("Avenida Dutra", "Apto", "456", "Recife", "Pernambuco", "458889999", LocalDate.now(), LocalDate.now());

        Student studentMaria = new Student("Maria Alves",
                LocalDate.of(1990, 1, 1),
                "12863305432",
                userMaria,
                avenidaDutra,
                "123456789",
                "Administração",
                "8",
                LocalDate.now());

        studentRepository.save(studentMaria);

        User userCarlos = new User("carlos_peixoto", new BCryptPasswordEncoder().encode("asdf456"), "carlos_peixoto@gmail.com", "87912228225");
        userRepository.save(userCarlos);

        Address ruaCoqueiros = new Address("Rua dos Coqueiros", "Apto", "65", "João Pessoa", "Praíba", "458669999", LocalDate.now(), LocalDate.now());

        Student studentCarlos = new Student("Carlos Peixoto",
                LocalDate.of(1990, 1, 1),
                "92863305222",
                userCarlos,
                ruaCoqueiros,
                "9955111454",
                "Engenharia Civil",
                "5",
                LocalDate.now());

        studentRepository.save(studentCarlos);
    }

    private void seedTeacher() {

        User userJoao = new User("joao_silva", new BCryptPasswordEncoder().encode("123abc"), "joao@gmail.com", "87991178225");
        userRepository.save(userJoao);

        Address ruaNascimento = new Address("Rua Nascimento", "Casa", "78945612", "Rio de Janeiro", "Rio de Janeiro", "123456987", LocalDate.now(), LocalDate.now());

        Map<String, Subject> subjectsJoao = new HashMap<>();

        Subject calculo1Joao = new Subject(
                "Cálculo 1",
                "2",
                "123456789");

        Subject algebraJoao = new Subject(
                "Álgebra Linear",
                "4",
                "123678445");

        Subject calculo2Joao = new Subject(
                "Cálculo 2",
                "3",
                "98456123");

        subjectsJoao.put("Cálculo 1", calculo1Joao);
        subjectsJoao.put("Álgebra", algebraJoao);
        subjectsJoao.put("Cálculo 2", calculo2Joao);

        Teacher teacherJoao = new Teacher(
                "João Silva",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                userJoao,
                ruaNascimento);

        teacherRepository.save(teacherJoao);

        User userRenata = new User("renata_costa", new BCryptPasswordEncoder().encode("321asdf"), "renata_costa@gmail.com", "87999978225");
        userRepository.save(userRenata);

        Address ruaAurora = new Address("Rua da Aurora", "Casa", "9995554", "Recife", "Pernambuco", "456989999", LocalDate.now(), LocalDate.now());

        Map<String, Subject> subjectsRenata = new HashMap<>();

        Subject algoritmoRenata = new Subject(
                "Algoritmos e Lógica de Programação",
                "1",
                "999999999");

        Subject atalRenata = new Subject(
                "Análise e Técnias de Algoritmos",
                "7",
                "32122112");

        subjectsRenata.put("Algoritmos", algoritmoRenata);
        subjectsRenata.put("ATAL", atalRenata);

        Teacher teacherRenata = new Teacher(
                "Renata Costa",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                userRenata,
                ruaAurora);

        teacherRepository.save(teacherRenata);

        User userPedro = new User("pedro_goncalves", new BCryptPasswordEncoder().encode("asdfqwerasdf"), "pedro_goncalves@gmail.com", "87991148790");
        userRepository.save(userPedro);

        Address ruaPeixoto = new Address("Rua Peixoto", "Apto", "78788754", "Rio de Janeiro", "Amazônio", "1116699", LocalDate.now(), LocalDate.now());

        Map<String, Subject> disciplinePedro = new HashMap<>();

        Subject empreendedorismoPedro = new Subject(
                "Empreendedorismo",
                "10",
                "33557744");

        Subject diversidadePedro = new Subject(
                "Educação em Diversidade",
                "4",
                "32548721");

        Subject direitosPedro = new Subject(
                "Direito dos Manos",
                "6",
                "789844444");

        disciplinePedro.put("Empreededorismo", empreendedorismoPedro);
        disciplinePedro.put("Diversidade", diversidadePedro);
        disciplinePedro.put("Direitos dos Manos", direitosPedro);

        Teacher teacherPedro = new Teacher(
                "Pedro Gonçalves",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                userPedro,
                ruaPeixoto);

        teacherRepository.save(teacherPedro);
    }

    private void seedInstitution() {
        Course administracaoIfpb = new Course("Administração", null, LocalDate.now(), LocalDate.now());
        Course agroecologiaIfpb = new Course("Agroecologia", null, LocalDate.now(), LocalDate.now());
        Course computacaoIfpb = new Course("Engenharia de Computação", null, LocalDate.now(), LocalDate.now());
        HashSet<Course> coursesIfpb = new HashSet<>(Arrays.asList(administracaoIfpb, agroecologiaIfpb, computacaoIfpb));

        Address ruaTranquilino = new Address("R. Tranquilino Coelho Lemos", "Prédio", "91051209", "Campina Grande", "Paraíba", "40506090", LocalDate.now(), LocalDate.now());
        Institution ifpb = new Institution("IFPB", ruaTranquilino, coursesIfpb);

        Course odontologia = new Course("Odontologia", null, LocalDate.now(), LocalDate.now());
        Course nutricao = new Course("Nutrição", null, LocalDate.now(), LocalDate.now());
        Course cienciaUfcg = new Course("Ciência da Computação", null, LocalDate.now(), LocalDate.now());
        HashSet<Course> coursesUfcg = new HashSet<>(Arrays.asList(odontologia, nutricao, cienciaUfcg));

        Address ruaGoncalo = new Address("Rua Gonçalo de Carvalho", "Casa", "123456987", "Porto Alegre", "Rio Grande do Sul", "123753951", LocalDate.now(), LocalDate.now());
        Institution ufcg = new Institution("UFCG", ruaGoncalo, coursesUfcg);

        Course fisicaUninassau = new Course("Física", null, LocalDate.now(), LocalDate.now());
        Course letrasUninassau = new Course("Letras", null, LocalDate.now(), LocalDate.now());
        Course farmaciaUninassau = new Course("Farmácia", null, LocalDate.now(), LocalDate.now());
        HashSet<Course> coursesUninassau = new HashSet<>(Arrays.asList(fisicaUninassau, letrasUninassau, farmaciaUninassau));

        Address ruaPedras = new Address("Rua das Pedras", "Apto", "369852147", "Búzios", "Rio de Janeiro", "789951741", LocalDate.now(), LocalDate.now());
        Institution uninassau = new Institution("UNINASSAU", ruaPedras, coursesUninassau);

        Course contabeisUepb = new Course("Ciências Contábeis", null, LocalDate.now(), LocalDate.now());
        Course civilUepb = new Course("Engenharia Civil", null, LocalDate.now(), LocalDate.now());
        Course enfermagemUepb = new Course("Enfermagem", null, LocalDate.now(), LocalDate.now());
        HashSet<Course> coursesUepb = new HashSet<>(Arrays.asList(contabeisUepb, civilUepb, enfermagemUepb));

        Address avenidaPeixoto = new Address("Av. Mal. Floriano Peixoto", "Prédio", "147852365", "Campina Grande", "Paríba", "123456965", LocalDate.now(), LocalDate.now());
        Institution uepb = new Institution("UEPB", avenidaPeixoto, coursesUepb);

        institutionRepository.saveAll(Arrays.asList(ifpb, ufcg, uninassau, uepb));
    }
}
