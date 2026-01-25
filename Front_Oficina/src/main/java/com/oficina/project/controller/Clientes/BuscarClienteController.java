package com.oficina.project.controller.Clientes;
import com.oficina.project.service.ClienteService;
import com.oficina.project.model.entities.Clientes;
import com.oficina.project.view.TelaPrincipal.ClienteViews.CadastrarClienteView;
import com.oficina.project.view.TelaPrincipal.TelaPrincipal;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Venicio
 */
public class BuscarClienteController {

    private final TelaPrincipal view;
    private final ClienteService service;

    public BuscarClienteController(TelaPrincipal view) {
        this.view = view;
        this.service = new ClienteService();
        iniciarController();
        System.out.println("CONTROLLER DE BUSCA CLIENTE INICIADO");
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
                List<Clientes> resultados = service.BuscarCliente(DTO);
                //\/chama o metodo tabela e atualiza os dados na tabela do front
                atualizarTabela(resultados);
            }
        });
    }

    private void atualizarTabela(List<Clientes> lista) {
        //\/ obtem o modelo da tabela para construção
        DefaultTableModel modelo = (DefaultTableModel) view.getTabelaUsuarios().getModel();
        modelo.setRowCount(0);//limpa a tabela

        //\/percorre todos os dados e inseri na tabela
        for (Clientes cli : lista) {
            modelo.addRow(new Object[]{
                cli.getId(),
                cli.getNome(),
                cli.getEmail(),
                cli.getCpf(),
                cli.getTelefone(),
                cli.getEndereco(),
                cli.getData_cadastro(),
                cli.getData_atualizacao()
            });
        }
    }

    private String valorCelula(JTable tabela, int linha, int coluna) {
        Object valor = tabela.getValueAt(linha, coluna);
        return valor != null ? valor.toString() : "";
    }

    public void ClienteSelecionado(int linha) {
        JTable tabela = view.getTabelaUsuarios();

        String id = valorCelula(tabela, linha, 0);
        String nome = valorCelula(tabela, linha, 1);
        String email = valorCelula(tabela, linha, 2);
        String cpf = valorCelula(tabela, linha, 3);
        String telefone = valorCelula(tabela, linha, 4);
        String Endereco = valorCelula(tabela, linha, 5);
        String data = valorCelula(tabela, linha, 6);
        String dataAtualizacao = valorCelula(tabela, linha, 7);
       

        view.InfoUsuario(id, nome, email, cpf, telefone, Endereco, data, dataAtualizacao);
    }

}
