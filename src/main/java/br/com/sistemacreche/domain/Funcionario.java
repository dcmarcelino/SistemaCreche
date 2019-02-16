package br.com.sistemacreche.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Dmarcelino
 */
@Entity
@Table(name = "Funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),
    @NamedQuery(name = "Funcionario.buscarPorMat", query = "SELECT funcionario FROM Funcionario funcionario WHERE funcionario.Matricula_Func = :Matricula_Func")})
public class Funcionario implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Matricula_Func", nullable = false)
    private long Matricula_Func;

    @Column(name = "Funcao", length = 45, nullable = false)
    private String Funcao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Pessoa_id_Pessoa", referencedColumnName = "id_Pessoa", nullable = false)
    private Pessoa pessoa;

    public Funcionario() {
        pessoa = new Pessoa(); //instancia o atributo pessoa para nao aparecer null na view
    }

    public long getMatricula_Func() {
        return Matricula_Func;
    }

    public void setMatricula_Func(long Matricula_Func) {
        this.Matricula_Func = Matricula_Func;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao.toUpperCase();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "Matricula_Func=" + Matricula_Func + ", Funcao=" + Funcao + ", pessoa=" + pessoa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.Matricula_Func ^ (this.Matricula_Func >>> 32));
        hash = 71 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.Matricula_Func != other.Matricula_Func) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

}
