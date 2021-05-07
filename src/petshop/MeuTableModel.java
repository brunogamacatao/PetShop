package petshop;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author bruno
 */
public class MeuTableModel <T> extends AbstractTableModel {
    private List<T> dados;
    private Class<T> classeDaEntidade;
    private List<String> colunas;
    
    public MeuTableModel(List<T> dados, Class<T> classeDaEntidade) {
        this.dados = dados;
        this.classeDaEntidade = classeDaEntidade;
        this.colunas = new ArrayList<>();
        
        for (Field f : classeDaEntidade.getDeclaredFields()) {
            colunas.add(f.getName());
        }
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        T objeto = dados.get(linha);
        Field f = classeDaEntidade.getDeclaredFields()[coluna];
        f.setAccessible(true);
        
        try {
            return f.get(objeto);
        } catch (Exception ex) {
            Logger.getLogger(MeuTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return colunas.get(i);
    }
}
