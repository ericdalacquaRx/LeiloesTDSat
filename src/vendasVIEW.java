
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class vendasVIEW extends javax.swing.JFrame {

    private javax.swing.JTable listaVendas;
    private javax.swing.JButton btnVoltar;

    /**
     * Creates new form vendasVIEW
     */
    public vendasVIEW() {
        initComponents();
        listarProdutosVendidos();
    }

    private void initComponents() {
        setTitle("Produtos Vendidos");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        javax.swing.JLabel titulo = new javax.swing.JLabel("Produtos Vendidos", javax.swing.SwingConstants.CENTER);
        titulo.setFont(new java.awt.Font("Lucida Fax", 0, 18));
        titulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 15, 0));

        listaVendas = new javax.swing.JTable(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Nome", "Valor", "Status"}
        ));
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(listaVendas);

        btnVoltar = new javax.swing.JButton("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.JPanel painelInferior = new javax.swing.JPanel();
        painelInferior.add(btnVoltar);

        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));
        getContentPane().add(titulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(scroll, java.awt.BorderLayout.CENTER);
        getContentPane().add(painelInferior, java.awt.BorderLayout.SOUTH);
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void listarProdutosVendidos(){
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();
            
            DefaultTableModel model = (DefaultTableModel) listaVendas.getModel();
            model.setNumRows(0);
            
            ArrayList<ProdutosDTO> vendidos = produtosdao.listarProdutosVendidos();
            
            for(int i = 0; i < vendidos.size(); i++){
                model.addRow(new Object[]{
                    vendidos.get(i).getId(),
                    vendidos.get(i).getNome(),
                    vendidos.get(i).getValor(),
                    vendidos.get(i).getStatus()
                });
            }
        } catch (Exception e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendasVIEW().setVisible(true);
            }
        });
    }
}