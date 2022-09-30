package br.edu.ifpb.educad.config.datasource;

import br.edu.ifpb.educad.entity.*;
import br.edu.ifpb.educad.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

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

        this.seedInstitution();
        this.seedTeacher();

    }

    private void seedTeacher() {

        User userJoao = new User("joao_silva", "123abc", "joao@gmail.com", "87991178225");
        userRepository.save(userJoao);

        Address ruaNascimento = new Address("Rua Nascimento", "Casa", "78945612", "Rio de Janeiro", "Rio de Janeiro", "123456987");

        Map<String, Discipline> disciplinesJoao = new HashMap<>();

        Discipline calculo1Joao = new Discipline(
                "Cálculo 1",
                "2",
                "123456789",
                null);

        Discipline algebraJoao = new Discipline(
                "Álgebra Linear",
                "4",
                "123678445",
                null);

        Discipline calculo2Joao = new Discipline(
                "Cálculo 2",
                "3",
                "98456123",
                null);

        disciplinesJoao.put("Cálculo 1", calculo1Joao);
        disciplinesJoao.put("Álgebra", algebraJoao);
        disciplinesJoao.put("Cálculo 2", calculo2Joao);

        Teacher teacherJoao = new Teacher(
                "João Silva",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                userJoao,
                ruaNascimento,
                disciplinesJoao);

        teacherRepository.save(teacherJoao);

        User userRenata = new User("renata_costa", "321asdf", "renata_costa@gmail.com", "87999978225");
        userRepository.save(userRenata);

        Address ruaAurora = new Address("Rua da Aurora", "Casa", "9995554", "Recife", "Pernambuco", "456989999");

        Map<String, Discipline> disciplinesRenata = new HashMap<>();

        Discipline algoritmoRenata = new Discipline(
                "Algoritmos e Lógica de Programação",
                "1",
                "999999999",
                null);

        Discipline atalRenata = new Discipline(
                "Análise e Técnias de Algoritmos",
                "7",
                "32122112",
                null);

        disciplinesRenata.put("Algoritmos", algoritmoRenata);
        disciplinesRenata.put("ATAL", atalRenata);

        Teacher teacherRenata = new Teacher(
                "Renata Costa",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                userRenata,
                ruaAurora,
                disciplinesRenata);

        teacherRepository.save(teacherRenata);

        User userPedro = new User("pedro_goncalves", "asdfqwerasdf", "pedro_goncalves@gmail.com", "87991148790");
        userRepository.save(userPedro);

        Address ruaPeixoto = new Address("Rua Peixoto", "Apto", "78788754", "Rio de Janeiro", "Amazônio", "1116699");

        Map<String, Discipline> disciplinePedro = new HashMap<>();

        Discipline empreendedorismoPedro = new Discipline(
                "Empreendedorismo",
                "10",
                "33557744",
                null);

        Discipline diversidadePedro = new Discipline(
                "Educação em Diversidade",
                "4",
                "32548721",
                null);

        Discipline direitosPedro = new Discipline(
                "Direito dos Manos",
                "6",
                "789844444",
                null);

        disciplinePedro.put("Empreededorismo", empreendedorismoPedro);
        disciplinePedro.put("Diversidade", diversidadePedro);
        disciplinePedro.put("Direitos dos Manos", direitosPedro);

        Teacher teacherPedro = new Teacher(
                "Pedro Gonçalves",
                LocalDate.of(1990, 1, 1),
                "12862305432",
                userPedro,
                ruaPeixoto,
                disciplinePedro);

        teacherRepository.save(teacherPedro);
    }

    private void seedInstitution() {
        Course administracaoIfpb = new Course("Administração", null);
        Course agroecologiaIfpb = new Course("Agroecologia", null);
        Course computacaoIfpb = new Course("Engenharia de Computação", null);
        HashSet<Course> coursesIfpb = new HashSet<>(Arrays.asList(administracaoIfpb, agroecologiaIfpb, computacaoIfpb));

        Address ruaTranquilino = new Address("R. Tranquilino Coelho Lemos", "Prédio", "91051209", "Campina Grande", "Paraíba", "40506090");
        Institution ifpb = new Institution("IFPB", ruaTranquilino, coursesIfpb);

        Course odontologia = new Course("Odontologia", null);
        Course nutricao = new Course("Nutrição", null);
        Course cienciaUfcg = new Course("Ciência da Computação", null);
        HashSet<Course> coursesUfcg = new HashSet<>(Arrays.asList(odontologia, nutricao, cienciaUfcg));

        Address ruaGoncalo = new Address("Rua Gonçalo de Carvalho", "Casa", "123456987", "Porto Alegre", "Rio Grande do Sul", "123753951");
        Institution ufcg = new Institution("UFCG", ruaGoncalo, coursesUfcg);

        Course fisicaUninassau = new Course("Física", null);
        Course letrasUninassau = new Course("Letras", null);
        Course farmaciaUninassau = new Course("Farmácia", null);
        HashSet<Course> coursesUninassau = new HashSet<>(Arrays.asList(fisicaUninassau, letrasUninassau, farmaciaUninassau));

        Address ruaPedras = new Address("Rua das Pedras", "Apto", "369852147", "Búzios", "Rio de Janeiro", "789951741");
        Institution uninassau = new Institution("UNINASSAU", ruaPedras, coursesUninassau);

        Course contabeisUepb = new Course("Ciências Contábeis", null);
        Course civilUepb = new Course("Engenharia Civil", null);
        Course enfermagemUepb = new Course("Enfermagem", null);
        HashSet<Course> coursesUepb = new HashSet<>(Arrays.asList(contabeisUepb, civilUepb, enfermagemUepb));

        Address avenidaPeixoto = new Address("Av. Mal. Floriano Peixoto", "Prédio", "147852365", "Campina Grande", "Paríba", "123456965");
        Institution uepb = new Institution("UEPB", avenidaPeixoto, coursesUepb);

        institutionRepository.saveAll(Arrays.asList(ifpb, ufcg, uninassau, uepb));
    }
}
