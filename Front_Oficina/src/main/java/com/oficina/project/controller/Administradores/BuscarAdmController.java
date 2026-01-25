package com.oficina.project.controller.Administradores;

import com.oficina.project.view.TelaPrincipal.AdmViews.CadastrarAdmView;
import com.oficina.project.model.entities.Administradores;
import com.oficina.project.service.AdministradoresService;

import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JTable;

public class BuscarAdmController {

    private final CadastrarAdmView view;
    private final AdministradoresService service;

    public BuscarAdmController(CadastrarAdmView view) {
        this.view = view;
        this.service = new AdministradoresService();
        iniciarController();
        System.out.println("CONTROLLER DE BUSCA INICIADO");
    }

    private void iniciarController() {
        //Metodo que pega oque for digitado\/
        view.getCampoPesquisar().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                //\/ pega oque foi digitado no campo de pesquisa e envia para o service
                String DTO = view.getCampoPesquisar().getText().trim();
                System.out.println("Buscando: " + DTO);//teste de iniciamento
                //\/Lista armazena os dados recebidos do banco de dados
                List<Administradores> resultados = service.BuscarAdministradores(DTO);
                //\/chama o metodo tabela e atualiza os dados na tabela do front
                atualizarTabela(resultados);
            }
        });
    }

    private void atualizarTabela(List<Administradores> lista) {
        //\/ obtem o modelo da tabela para construção
        DefaultTableModel modelo = (DefaultTableModel) view.getTabelaUsuarios().getModel();
        modelo.setRowCount(0);//limpa a tabela

        //\/percorre todos os dados e inseri na tabela
        for (Administradores adm : lista) {
            modelo.addRow(new Object[]{
                adm.getId(),
                adm.getNome(),
                adm.getEmail(),
                adm.getSenha(),
                adm.getTelefone(),
                adm.getCargo(),
                adm.getData_criacao(),
                adm.getData_atualizacao()
            });
        }
    }

    private String valorCelula(JTable tabela, int linha, int coluna) {
        Object valor = tabela.getValueAt(linha, coluna);
        return valor != null ? valor.toString() : "";
    }

    public void usuarioSelecionado(int linha) {
        JTable tabela = view.getTabelaUsuarios();

        String id = valorCelula(tabela, linha, 0);
        String nome = valorCelula(tabela, linha, 1);
        String email = valorCelula(tabela, linha, 2);
        String senha = valorCelula(tabela, linha, 3);
        String telefone = valorCelula(tabela, linha, 4);
        String cargo = valorCelula(tabela, linha, 5);
        String data = valorCelula(tabela, linha, 6);
        String dataAtualizacao = valorCelula(tabela, linha, 7);

        view.InfoADM(id, nome, email, senha, telefone, cargo, data, dataAtualizacao);
    }

}
