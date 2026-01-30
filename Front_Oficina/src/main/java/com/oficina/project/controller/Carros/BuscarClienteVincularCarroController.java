package com.oficina.project.controller.Carros;
import com.oficina.project.service.ClienteService;
import com.oficina.project.model.entities.Clientes;
import com.oficina.project.service.CarroService;
import com.oficina.project.view.TelaPrincipal.CarrosView.TelaVincularClienteCarros;
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
public class BuscarClienteVincularCarroController {

    private final TelaVincularClienteCarros view;
    private final CarroService service;

    public BuscarClienteVincularCarroController(TelaVincularClienteCarros view) {
        this.view = view;
        this.service = new CarroService();
        iniciarController();
        System.out.println("CONTROLLER DE VINCULAR CLIENTE INICIADO");
    }

    private void iniciarController() {
        //Metodo que pega oque for digitado\/
        view.getCampoPesquisarVincularCliente().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                //\/ pega oque foi digitado no campo de pesquisa e envia para o service
                String DTO = view.getCampoPesquisarVincularCliente().getText().trim();
                System.out.println("Buscando: " + DTO);//teste de iniciamento
                //\/Lista armazena os dados recebidos do banco de dados
                List<Clientes> resultados = service.BuscarClienteVincular(DTO);
                //\/chama o metodo tabela e atualiza os dados na tabela do front
                atualizarTabela(resultados);
            }
        });
    }

    private void atualizarTabela(List<Clientes> lista) {
        //\/ obtem o modelo da tabela para construção
        DefaultTableModel modelo = (DefaultTableModel) view.getTabelaVincularClientes().getModel();
        modelo.setRowCount(0);//limpa a tabela

        //\/percorre todos os dados e inseri na tabela
        for (Clientes cli : lista) {
            modelo.addRow(new Object[]{
                cli.getId(),
                cli.getNome(),
            });
        }
    }

    private String valorCelula(JTable tabela, int linha, int coluna) {
        Object valor = tabela.getValueAt(linha, coluna);
        return valor != null ? valor.toString() : "";
    }

    public void ClienteSelecionado(int linha) {
        JTable tabela = view.getTabelaVincularClientes();

        String id = valorCelula(tabela, linha, 0);
        String nome = valorCelula(tabela, linha, 1);
        
    }

}
