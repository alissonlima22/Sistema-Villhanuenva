/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.AblVenda;


/**
 *
 * @author Alisson
 */
public class VendaTableModel extends AbstractTableModel {
    private List lista;

    public List getLista() { return lista; }
    public void setLista(List lista) { this.lista = lista; }

    @Override
    public int getRowCount() { return lista.size(); }

    @Override
    public int getColumnCount() { return 5; }

    @Override
    public String getColumnName(int col) {
        String[] nomes = {"Num Pedido", "Data", "Cliente", "Vendedor", "Total"};
        return nomes[col];
    }
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AblVenda venda = (AblVenda) lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return venda.getIdPedido();
            case 1: return venda.getData();
            case 2: return venda.getIdCliente();
            case 3: return venda.getIdVendedor();
            case 4: return venda.getTotal();
            default: return "";
        }
    }
}
