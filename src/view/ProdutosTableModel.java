
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.AblProduto;

public class ProdutosTableModel extends AbstractTableModel {
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
        AblProduto produto = (AblProduto) lista.get(rowIndex);
        if(columnIndex==0)
            return produto.getId_produto ();
        if(columnIndex==1)
            return produto.getDescricao();
        if(columnIndex==2)
            return produto.getTipo();
        if(columnIndex==3)
            return produto.getUnidade();
        if(columnIndex==4)
            return produto.getPreco();
        else    
            return "";
    }
}
