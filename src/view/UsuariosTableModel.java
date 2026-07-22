
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.AblUsuarios;

public class UsuariosTableModel extends AbstractTableModel {
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
        AblUsuarios usuario = (AblUsuarios) lista.get(rowIndex);
        if(columnIndex==0)
            return usuario.getMpvIdUsuarios();
        if(columnIndex==1)
            return usuario.getMpvNome();
        if(columnIndex==2)
            return usuario.getMpvCpf();
        else
            return "";
    }
}
