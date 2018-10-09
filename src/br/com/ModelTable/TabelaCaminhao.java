package br.com.ModelTable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.entidade.Caminhao;

@SuppressWarnings("serial")
public class TabelaCaminhao extends AbstractTableModel{
	private static final int COL_ID = 0;
	private static final int COL_TIPOCAM = 1;
	private static final int COL_CARGA = 2;
	private static final int COL_ESTADO = 3;
	
	
	List<Caminhao> linhas;
	private String[] colunas = new String[]{"I D ", "TIPO CAMINHÃO","TIPO DE CARGA","ESTADO"};
	
	public TabelaCaminhao(List<Caminhao> caminhao) {
		this.linhas = new ArrayList<>(caminhao);
	}
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Caminhao cm = linhas.get(rowIndex);
		if (columnIndex == COL_ID) {
			return cm.getIdCaminhao();
		} else if (columnIndex == COL_TIPOCAM) {
			return cm.getTipoCaminhao();
		} else if (columnIndex == COL_CARGA) {
			return cm.getTipoCarga();
		} else if (columnIndex == COL_ESTADO) {
			return cm.getEstado();
		}
		return "";
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}
}
