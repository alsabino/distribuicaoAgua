package com.andre.sistemadedistribuicao.dao;

import com.andre.sistemadedistribuicao.model.Chamado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Andre Luis Sabino
 * @version 1.0
 * @since 12/04/2017
 */
public class ChamadoDAO {

    private DataSource datasource;

    public ChamadoDAO(DataSource dataSource) {
        this.datasource = dataSource;
    }

    public ArrayList<Chamado> listarChamados() {
        try {
            String SQL = "SELECT * FROM chamado ";
            PreparedStatement ps = datasource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<Chamado> lista = new ArrayList<Chamado>();

            while (rs.next()) {
                Chamado cham = new Chamado();
                cham.setId(rs.getInt("id"));
                cham.setCliente(rs.getString("cliente"));
                cham.setEmail(rs.getString("email"));
                cham.setEndereco(rs.getString("endereco"));
                cham.setTelefone(rs.getString("telefone"));
                cham.setServico(rs.getString("servico"));
                cham.setDataAbertura(rs.getDate("data_abertura"));
                cham.isEncaminhado(rs.getInt("encaminhado"));
                cham.isEncerrado(rs.getByte("encerrado"));
                cham.setDataEncerramento(rs.getDate("data_encerramento"));
                cham.setTempototal(rs.getTime("tempo_total"));
                lista.add(cham);
            }
            ps.close();
            return lista;

        } catch (SQLException ex) {
            System.err.println("Erro ao recuperar os dados".concat(ex.getMessage()));
        } catch (Exception ex) {
            System.err.println("Erro do sistema contate o suporte técnico!");
        }
        return null;
    }
}
