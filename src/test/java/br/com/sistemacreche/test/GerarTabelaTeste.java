package br.com.sistemacreche.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.sistemacreche.Bean.UsuarioBean;
import br.com.sistemacreche.dao.AlunoDAO;
import br.com.sistemacreche.dao.ColoracaoDAO;
import br.com.sistemacreche.dao.ContratoDAO;
import br.com.sistemacreche.dao.DisposicaoDAO;
import br.com.sistemacreche.dao.EmpresaDAO;
import br.com.sistemacreche.dao.FuncionarioDAO;
import br.com.sistemacreche.dao.MunicipioDAO;
import br.com.sistemacreche.dao.Nivel_EscolarDAO;
import br.com.sistemacreche.dao.PessoaDAO;
import br.com.sistemacreche.dao.RefeicaoDAO;
import br.com.sistemacreche.dao.TexturaDAO;
import br.com.sistemacreche.dao.TurnoDAO;
import br.com.sistemacreche.dao.UFDAO;
import br.com.sistemacreche.dao.UsuarioDAO;
import br.com.sistemacreche.domain.Aluno;
import br.com.sistemacreche.domain.Coloracao;
import br.com.sistemacreche.domain.Contrato;
import br.com.sistemacreche.domain.Disposicao;
import br.com.sistemacreche.domain.Empresa;
import br.com.sistemacreche.domain.Funcionario;
import br.com.sistemacreche.domain.Municipio;
import br.com.sistemacreche.domain.Nivel_Escolar;
import br.com.sistemacreche.domain.Pessoa;
import br.com.sistemacreche.domain.Refeicao;
import br.com.sistemacreche.domain.Textura;
import br.com.sistemacreche.domain.UF;
import br.com.sistemacreche.domain.Usuario;
import br.com.sistemacreche.util.HibernateUtil;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Marcelino
 */
public class GerarTabelaTeste {

    public GerarTabelaTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Ignore
    public void gerarTabelas() {
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();

    }

    @Test

    public void salvar() throws ParseException {

//        Usuario u = new Usuario();
//        Usuario u2 = new Usuario();
//        Usuario u3 = new Usuario();
//        
//        UsuarioDAO dao = new UsuarioDAO();
//        
//        u.setLogin("dcmarcelino");
//        u.setSenha("140561");
//        u.setCategoria("U");
//        u.setCod_Categoria('A');
//        
//        u2.setLogin("dcmarcelino");
//        u2.setSenha("140561");
//        u2.setCategoria("U");
//        u2.setCod_Categoria('U');
//        
//        u3.setLogin("dcmarcelino");
//        u3.setSenha("140561");
//        u3.setCategoria("U");
//        u3.setCod_Categoria('A');
//        
//        dao.salvar(u);
//        dao.salvar(u2);
//        dao.salvar(u3);
//        ---------------------------------------------     
//        TexturaDAO dao = new TexturaDAO();
//        
////        List<Textura> texturas;
////        
////        texturas = dao.listar();
////        System.out.println(texturas);
////        
//        Textura t = new Textura();
//        Textura t2 = new Textura();
//        Textura t3 = new Textura();
//        Textura t4 = new Textura();
//        Textura t5 = new Textura();
//        Textura t6 = new Textura();
//        Textura t7 = new Textura();
//        
//        t.setTex_Descricao("Bolinhas duras");
//        t.setTex_Observacao("O intestino está preso, falta fibra e água.");
//        
//        t2.setTex_Descricao("Alongado e irregular, uma união de bolinhas");
//        t2.setTex_Observacao("Pode ser o início de uma constipação, beber mais líquido.");
//        
//        t3.setTex_Descricao("Comprido e com rachaduras externas");
//        t3.setTex_Observacao("Praticamente saudável");
//        
//        t4.setTex_Descricao("Liso em formato de salsicha");
//        t4.setTex_Observacao("Ótimo! tudo está perfeito no interior de sua barriga");
//        
//        t5.setTex_Descricao("Mole e irregular");
//        t5.setTex_Observacao("Não são ruins, mas note se permanecerá assim nas próximas ocasiões.");
//        
//        t6.setTex_Descricao("Mole com partes líquidas");
//        t6.setTex_Observacao("Se são grudentas, há muita gordura na alimentação. Pode ser o início de uma diarréia.");
//        
//        t7.setTex_Descricao("Totalmente líquido");
//        t7.setTex_Observacao("Atenção! a digestão está bagunçada. Tome bastante líquido para evitar uma desidratação e fique de olho!");
//        
//        dao.salvar(t);
//        dao.salvar(t2);
//        dao.salvar(t3);
//        dao.salvar(t4);
//        dao.salvar(t5);
//        dao.salvar(t6);
//        dao.salvar(t7);
//        
//        ---------------------------------------------             
//        Contrato contrato = new Contrato();
//        Empresa e = new Empresa();
//        EmpresaDAO edao = new EmpresaDAO();
//        
//        Aluno a = new Aluno();
//        AlunoDAO adao = new AlunoDAO();
//        
//        Nivel_Escolar n = new Nivel_Escolar();
//        Nivel_EscolarDAO ndao = new Nivel_EscolarDAO();
//        
//        n = ndao.buscarPorId(3L);
//        e = edao.buscarPorId(1L);
//        a = adao.buscarPorMat(4L);
//  
//        ContratoDAO dao = new ContratoDAO();
//        
//        contrato.setData_Inicio(new Date());
//        contrato.setData_Fim(new Date(12122018));
//        contrato.setEmpresa(e);
//        contrato.setAluno(a);
//        contrato.setMensalidade(new BigDecimal(1150.80));
//        contrato.setDt_Vencimento(new Date(05));
//        contrato.setNivel(n);
//        
//        dao.salvar(contrato);
//        ---------------------------------------------          
//        Nivel_Escolar nivel = new Nivel_Escolar();
//        Nivel_Escolar nivel2 = new Nivel_Escolar();
//        Nivel_Escolar nivel3 = new Nivel_Escolar();
//        Nivel_Escolar nivel4 = new Nivel_Escolar();
//        Nivel_EscolarDAO dao = new Nivel_EscolarDAO();
//        
//        nivel.setDescricao_NE("Pré-Escola");
//        nivel2.setDescricao_NE("Jardim I");
//        nivel3.setDescricao_NE("Jardim II");
//        nivel4.setDescricao_NE("Jardim III");
//        
//        dao.salvar(nivel);
//        dao.salvar(nivel2);
//        dao.salvar(nivel3);
//        dao.salvar(nivel4);
//        ---------------------------------------------         
//        Empresa e = new Empresa();
//        Empresa e2 = new Empresa();
//        
//        Municipio m = new Municipio();
//        MunicipioDAO mdao = new MunicipioDAO();
//        EmpresaDAO edao = new EmpresaDAO();
//        
//        m = mdao.buscarPorId(2L);
//        
//        e.setBairro("Barra da Tijuca");
//        e.setCep("22775-003");
//        e.setCnpj("34.165.027/0001-89");
//        e.setComplemento("Sala 404");
//        e.setMunicipio(m);
//        e.setUf(m.getUf());
//        e.setNumero("3000");
//        e.setRazao_Social("Sala das Crianças");
//        e.setRua("Av. das Américas");
//        
//        e2.setBairro("Recreio dos Bandeirantes");
//        e2.setCep("22777-052");
//        e2.setCnpj("41.196.049/0001-02");
//        e2.setComplemento("Sala 12506");
//        e2.setMunicipio(m);
//        e2.setUf(m.getUf());
//        e2.setNumero("3000");
//        e2.setRazao_Social("Creche Criança Feliz");
//        e2.setRua("Av. das Américas");
//        
//        edao.salvar(e2);
//        edao.salvar(e);
//        ---------------------------------------------    
//        Refeicao r = new Refeicao();
//        Refeicao r2 = new Refeicao();
//        Refeicao r3 = new Refeicao();
//        
//        RefeicaoDAO dao = new RefeicaoDAO();
//        
//        r.setRef_Descricao("Mamadeira");
//        r2.setRef_Descricao("Almoço");
//        r3.setRef_Descricao("lanche");
//        
//        dao.salvar(r);
//        dao.salvar(r2);
//        dao.salvar(r3);
//        
//        ---------------------------------------------        
//        Coloracao c = new Coloracao();
//        Coloracao c2 = new Coloracao();
//        Coloracao c3 = new Coloracao();
//        Coloracao c4 = new Coloracao();
//        Coloracao c5 = new Coloracao();
//        
//        ColoracaoDAO dao = new ColoracaoDAO();
//        
//        c.setCol_Descricao("Esverdeada");
//        c2.setCol_Descricao("Escura");
//        c3.setCol_Descricao("Avermelhada");
//        c4.setCol_Descricao("Amarelada");
//        c5.setCol_Descricao("Clara");
//        
//        dao.salvar(c);
//        dao.salvar(c2);
//        dao.salvar(c3);
//        dao.salvar(c4);
//        dao.salvar(c5);
//        ---------------------------------------------
//        Pessoa p = new Pessoa();
//        Pessoa p2 = new Pessoa();
//
//        Municipio m = new Municipio();
//        MunicipioDAO dao1 = new MunicipioDAO();
//        m = dao1.buscarPorId(1L);
//
//        p.setNome("Daniela Marcelino");
//        p.setBairro("Tomas Coelho");
//        p.setCep("21381-230");
//        p.setComplemento("CASA");
//        p.setCpf("12312022230");
//        p.setSituacao(true);
//        p.setNumero("45");
//        p.setRg("123435823");
//        p.setRua("Rua Souza Pitanga");
//        p2.setTelefone1("21982027812");
//        p2.setTelefone2("98210001411");
//        p.setDt_Nasc(new Date("14/09/1990"));
//        p.setMunicipio(m);
//
//        p2.setMunicipio(m);
//        p2.setNome("Roberta Barbarino");
//        p2.setBairro("Del Castilho");
//        p2.setCep("22222-230");
//        p2.setComplemento("Apto 8552");
//        p2.setCpf("00100025260");
//        p2.setDt_Nasc(new Date("14/09/1990"));
//        p2.setSituacao(true);
//        p2.setNumero("2500");
//        p2.setRg("568533321");
//        p2.setRua("Rua do norte Shopping");
//        p2.setTelefone1("21982027812");
//        p2.setTelefone2("98210001411");
//
//        Funcionario f = new Funcionario();
//        Funcionario f2 = new Funcionario();
//
//        f.setFuncao("Professora");
//        f2.setFuncao("Enfermeira");
//        f.setPessoa(p);
//        f2.setPessoa(p2);
//
//        FuncionarioDAO fun = new FuncionarioDAO();
//
//        fun.salvar(f2);
//        fun.salvar(f);
//        ---------------------------------------------
//        
//        Pessoa p2 = new Pessoa();
//         MunicipioDAO dao2 = new MunicipioDAO();
//         
//        p2.setNome("Diego");
//        p2.setBairro("Maria da Graça");
//        p2.setCep("21050-582");
//        p2.setComplemento("Apto 702");
//        p2.setCpf("551.555.209-20");
//        p2.setDt_Nasc(new Date("14/09/1990"));
//        p2.setNumero("140");
//        p2.setRg("21.028330-4");
//        p2.setRua("Rua Conde de Azambuja");
//        p2.setTelefone1("982027812");
//        p2.setTelefone2("982027812");
//        p2.setMunicipio(dao2.buscarPorId(1L));
//        p2.setSituacao(true);
//        
//                
//        Aluno a = new Aluno();
//        
//        a.setNome_Mae("Cristiane");
//        a.setCpf_Mae("999.000.404-56");
//        a.setNome_pai("Dalmir");
//        a.setCpf_Pai("111.222.201-15");
//        TurnoDAO tdao = new TurnoDAO();
//        
//        a.setTurno(tdao.buscarPorId(1L));
//        
//        a.setPessoa(p2);
//        
//             
//        
//        AlunoDAO dao = new AlunoDAO();
//        
//         dao.salvar(a);

//Usuario u = new Usuario();
//UsuarioBean dao = new UsuarioBean();
//
//u.setCategoria("Administrador");
//u.setCod_Categoria('A');
//u.setLogin("dcmarcelino2");
//u.setSenha("123456");
//dao.setUsuario(u);
//dao.salvar();
//        UF uf = new UF();
//        UF uf2 = new UF();
//        UF uf3 = new UF();
//        UF uf4 = new UF();
//        UF uf5 = new UF();
//
//        uf.setUF_Descricao("RJ");
//        uf2.setUF_Descricao("PR");
//        uf3.setUF_Descricao("SP");
//        uf4.setUF_Descricao("MG");
//        uf5.setUF_Descricao("PB");
//
//        UFDAO dao = new UFDAO();
//        dao.salvar(uf);
//        dao.salvar(uf2);
//        dao.salvar(uf3);
//        dao.salvar(uf4);
//        dao.salvar(uf5);
//        Municipio municipio = new Municipio();
//        Municipio municipio2 = new Municipio();
//        Municipio municipio3 = new Municipio();
//        Municipio municipio4 = new Municipio();
//        Municipio municipio5 = new Municipio();
//
//        UFDAO dao = new UFDAO();
//        UF uf = dao.buscarPorId(3L);
//        UF uf2 = dao.buscarPorId(4L);
//
//        municipio.setMun_Descricao("Rio de Janeiro");
//        municipio.setUf(uf);
//
//        municipio2.setMun_Descricao("São Gonçalo");
//        municipio2.setUf(uf);
//
//        municipio3.setMun_Descricao("Niteroi");
//        municipio3.setUf(uf);
//
//        municipio4.setMun_Descricao("Manhuaçu");
//        municipio4.setUf(uf2);
//
//        municipio5.setMun_Descricao("Orizânia");
//        municipio5.setUf(uf2);
//
//        MunicipioDAO dao2 = new MunicipioDAO();
//
//        dao2.salvar(municipio);
//        dao2.salvar(municipio2);
//        dao2.salvar(municipio3);
//        dao2.salvar(municipio4);
//        dao2.salvar(municipio5);
//    String cnpj = "07923215000123";
//    try {
//        MaskFormatter mask = new MaskFormatter("###.###.###/####-##");
//        mask.setValueContainsLiteralCharacters(false);
//        System.out.println("CNPJ : " + mask.valueToString(cnpj));
//    } catch (ParseException ex) {
//        
//    }
    }

    @Test
    @Ignore
    public void listar() {

//        TexturaDAO dao = new TexturaDAO();
//        List<Textura> texturas = dao.listar();
//
//        for (Textura t : texturas) {
//            System.out.println(t);
//        }
        ContratoDAO dao = new ContratoDAO();
        List<Contrato> contratos = dao.listar();

        for (Contrato c : contratos) {
            System.out.println(c);
        }

//        Nivel_EscolarDAO dao = new Nivel_EscolarDAO();
//        List<Nivel_Escolar> niveis = dao.listar();
//
//        for (Nivel_Escolar n : niveis) {
//            System.out.println(n);
//        }        
//        
//        
//        -------------------------------------------------------
//        RefeicaoDAO dao = new RefeicaoDAO();
//        List<Refeicao> refeicoes = dao.listar();
//
//        for (Refeicao c : refeicoes) {
//            System.out.println(c);
//        }
//        -------------------------------------------------------
//     ColoracaoDAO dao = new ColoracaoDAO();
//        List<Coloracao> coloracoes = dao.listar();
//
//        for (Coloracao c : coloracoes) {
//            System.out.println(c);
//        }
////        -------------------------------------------------------
//        AlunoDAO dao = new AlunoDAO();
//        List<Aluno> alunos = dao.listar();
//
//        for (Aluno a : alunos) {
//            System.out.println(a);
//        }
//                
//        -------------------------------------------------------
//        UFDAO dao = new UFDAO();
//        List<UF> ufs = dao.listar();
//        for (UF uf : ufs) {
//            System.out.println(uf);
//        }
//        -------------------------------------------------------
//        MunicipioDAO dao = new MunicipioDAO();
//        List<Municipio> ufs = dao.listar();
//        for (Municipio mun : ufs) {
//            System.out.println(mun);
//        }
//        -------------------------------------------------------
//        FuncionarioDAO dao = new FuncionarioDAO();
//        
//        List<Funcionario> funcs = dao.listar();
//        for (Funcionario funcionario : funcs) {
//            System.out.println(funcionario);
//        }
    }

    @Test
    @Ignore
    public void buscarPorId() {

        //        --------------------------------------------
        ContratoDAO dao = new ContratoDAO();
        Contrato e = dao.buscarPorId(1L);
        System.out.println(e);

//        --------------------------------------------
//        
//        RefeicaoDAO dao = new RefeicaoDAO();
//        Refeicao r = dao.buscarPorId(1L);
//        System.out.println(r);
//        --------------------------------------------
//        AlunoDAO dao = new AlunoDAO();
//        Aluno a = dao.buscarPorMat(5L);
//        System.out.println(a);
//        UFDAO dao = new UFDAO();
//        UF uf = dao.buscarPorId(3L);
//        System.out.println(uf);
//        --------------------------------------------
//        MunicipioDAO dao = new MunicipioDAO();
//        Municipio municipio = dao.buscarPorId(3L);
//        System.out.println(municipio);
//        --------------------------------------------
//        FuncionarioDAO dao = new FuncionarioDAO();
//        Funcionario f = dao.buscarPorMat(1L);
//        System.out.println(f);
    }

    @Test
    @Ignore
    public void excluir() {

//        AlunoDAO dao = new AlunoDAO();
//        Aluno a = dao.buscarPorMat(1L);
//        dao.excluir(a);
//        --------------------------------------------        
//        UFDAO dao = new UFDAO();
//        UF uf = dao.buscarPorId(5L);
//        dao.excluir(uf);
//        dao.excluir(1L);
//        --------------------------------------------
//        MunicipioDAO dao = new MunicipioDAO();
//        Municipio municipio = dao.buscarPorId(3L);
//        dao.excluir(municipio);
//        dao.excluir(5L);
//        --------------------------------------------        
//        FuncionarioDAO dao = new FuncionarioDAO();
//        Funcionario f = dao.buscarPorMat(3L);
//        dao.excluir(f);
//        dao.excluir(2L);
//        --------------------------------------------  
//        ColoracaoDAO dao = new ColoracaoDAO();
//        Coloracao c = dao.buscarPorId(1L);
//        dao.excluir(c);
//        dao.excluir(5L);
//        --------------------------------------------  
//        
//        RefeicaoDAO dao = new RefeicaoDAO();
//        Refeicao r = dao.buscarPorId(1L);
//        dao.excluir(r);
//        dao.excluir(4L);
//        --------------------------------------------  
//        DisposicaoDAO dao = new DisposicaoDAO();
//        Disposicao d = dao.buscarPorId(5L);
//        dao.excluir(d);
//        dao.excluir(4L);     
//        --------------------------------------------  
        TexturaDAO dao = new TexturaDAO();
        Textura e = dao.buscarPorId(6L);
        dao.excluir(e);
        dao.excluir(7L);
        dao.excluir(8L);
        dao.excluir(9L);
        dao.excluir(10L);

    }

    @Test
    @Ignore
    public void excluirPorId() {

//        AlunoDAO dao = new AlunoDAO();
//        dao.excluir(3L);
//        UFDAO dao = new UFDAO();
//        dao.excluir(3L);
//        MunicipioDAO dao = new MunicipioDAO();
//        dao.excluir(5L);
//        ColoracaoDAO dao = new ColoracaoDAO();
//        dao.excluir(5L);
    }

    @Test
    @Ignore
    public void editar() {

        ContratoDAO dao = new ContratoDAO();
        PessoaDAO pdao = new PessoaDAO();
        AlunoDAO adao = new AlunoDAO();

        Contrato c = new Contrato();

        Aluno a = new Aluno();

        Pessoa p = new Pessoa();

        c = dao.buscarPorId(3L);
        a = c.getAluno();
        p = a.getPessoa();

        p.setNome("Diego Costa Marcelino");
        a.setNome_Mae("Joveli Perola Negra");

        pdao.editar(p);
        adao.editar(a);

        c.setAluno(a);

        dao.editar(c);

        System.out.println(c);

//     ---------------------------------------------        
//       DisposicaoDAO dao = new DisposicaoDAO();
//       Disposicao d = new Disposicao();
//        
//        d = dao.buscarPorId(6L);
//        d.setDis_Disposicao("Cansado");
//        
//        
//        dao.editar(d);
//     ---------------------------------------------
//        Aluno a = new Aluno();
//        AlunoDAO dao = new AlunoDAO();
//
//        a = dao.buscarPorMat(4L);
//
//        Pessoa p = new Pessoa();
//        p = a.getPessoa();
//        p.setNome("Fatima Maria");
//
//        a.setNome_Mae("Jessica Silva");
//        a.setPessoa(p);
//        dao.editar(a);
//        UF uf = new UF();
//        UFDAO dao = new UFDAO();
//        
//     ---------------------------------------------     
//       uf = dao.buscarPorId(3L);
//       uf.setUF_Descricao("RJ");
//       dao.editar(uf);
//     ---------------------------------------------
//        FuncionarioDAO dao = new FuncionarioDAO();
//        Municipio m = new Municipio();
//        MunicipioDAO mdao = new MunicipioDAO();
//        
//        m = mdao.buscarPorId(1L);
//  
//        Funcionario f = new Funcionario();
//        Pessoa p = new Pessoa();
//        f = dao.buscarPorMat(1L);
//        p = f.getPessoa();
//        p.setUf(m.getUf());
//        p.setMunicipio(m);
//        p.setNome("Janete Salvina Costa");
//        p.setBairro("Carioca");
//        f.setPessoa(p);
//        dao.editar(f);
//        
//     ---------------------------------------------
//        m = dao.buscarPorId(2L);
//        m.setMun_Descricao("Niteroi");
//
//        m2 = dao.buscarPorId(4L);
//        m2.setMun_Descricao("Rio de Janeiro");
//        m2.setUf(uf);
//        dao.editar(f);
//     ---------------------------------------------
    }
}
