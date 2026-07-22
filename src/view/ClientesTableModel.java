    
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.AblCliente;

public class ClientesTableModel extends AbstractTableModel {
    private List lista;

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AblCliente cliente = (AblCliente) lista.get(rowIndex);
        if(columnIndex==0)
            return cliente.getId_cliente();
        if(columnIndex==1)
            return cliente.getNome();
        if(columnIndex==2)
            return cliente.getCpf();
        if(columnIndex==3)
            return cliente.getEmail();
        if(columnIndex==4)
            return cliente.getTelefone();
        else
            return "";
    }
}
