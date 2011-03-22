package core;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class Records {
	
	/**
	 * �� ResultSet �еļ�¼ת���� Record ���б�
	 * 
	 * @param rs	�����¼�� ResultSet ����
	 * @return	List<Record> ���ͱ�ʾ�ļ�¼�б�
	 * @throws Exception	�� ResultSet �Ĳ������ܲ��� SQLException
	 */
	public static List<Record> toRecordList(ResultSet rs) throws Exception {
		
		List<Record> recordList = new ArrayList<Record>();
		
		if (rs == null) {
			return recordList;
		}
		
		// �õ� ResutlSet �����Ԫ���ݶ���
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		// �õ���¼���������Ե�����
		String[] columnNames = new String[columnCount];
		for (int i = 0; i < columnCount; i++) {
			columnNames[i] = metaData.getColumnName(i);
		}
		
		// �� ResultSet �����е�ÿ����¼ת���� Record ���󣬲���ӵ� List ������
		while (rs.next()) {
			Record record = new Record();
			for (int i = 0; i < columnCount; i++) {
				record.set(columnNames[i], rs.getObject(columnNames[i]));
			}
			recordList.add(record);
		}
		
		return recordList;
	}

	/**
	 * �� ResultSet �еļ�¼ת���� Record ������
	 * 
	 * @param rs	�����¼�� ResultSet ����
	 * @return	�����¼���ݵ� Record ����
	 * @throws Exception	�� ResultSet �Ĳ������ܲ��� SQLException
	 */
	public static Record[] toRecords(ResultSet rs) throws Exception {
		
		// ���� toRecordList �õ� ResultSet ת���� List 
		List<Record> recordList = toRecordList(rs);
		Record[] records = new Record[recordList.size()];
		
		// ʹ�÷���ֵ��֤ת����ȷ������Ϊ������ Record ���鳤��С�� List ����ʱ�����������´��� Record ���飩
		records = recordList.toArray(records);
		return records;
	}
	
	/**
	 * �� ResultSet �еļ�¼ת���� MapRecord ���б�
	 * 
	 * @param rs	�����¼�� ResultSet ����
	 * @return	List<MapRecord> ���ͱ�ʾ�ļ�¼�б�
	 * @throws Exception	�� ResultSet �Ĳ������ܲ��� SQLException
	 */
	public static List<MapRecord> toMapRecordList(ResultSet rs) throws Exception {
		
		List<MapRecord> recordList = new ArrayList<MapRecord>();
		
		if (rs == null) {
			return recordList;
		}
		
		// �õ� ResutlSet �����Ԫ���ݶ���
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		// �õ���¼���������Ե�����
		String[] columnNames = new String[columnCount];
		for (int i = 0; i < columnCount; i++) {
			columnNames[i] = metaData.getColumnName(i);
		}
		
		// �� ResultSet �����е�ÿ����¼ת���� Record ���󣬲���ӵ� List ������
		while (rs.next()) {
			MapRecord record = new MapRecord();
			for (int i = 0; i < columnCount; i++) {
				record.set(columnNames[i], rs.getObject(columnNames[i]));
			}
			recordList.add(record);
		}
		
		return recordList;
	}

	/**
	 * �� ResultSet �еļ�¼ת���� MapRecord ������
	 * 
	 * @param rs	�����¼�� ResultSet ����
	 * @return	�����¼���ݵ� MapRecord ����
	 * @throws Exception	�� ResultSet �Ĳ������ܲ��� SQLException
	 */
	public static MapRecord[] toMapRecords(ResultSet rs) throws Exception {
		
		// ���� toRecordList �õ� ResultSet ת���� List 
		List<MapRecord> recordList = toMapRecordList(rs);
		MapRecord[] records = new MapRecord[recordList.size()];
		
		// ʹ�÷���ֵ��֤ת����ȷ������Ϊ������ Record ���鳤��С�� List ����ʱ�����������´��� Record ���飩
		records = recordList.toArray(records);
		return records;
	}
	
	public static void main(String[] args) {
		List<Record> recordList = new ArrayList<Record>();
		Record record = new Record();
		record.set("a", 1);
		record.set("b", "123");
		Record record2 = new Record();
		record2.set("a", 3);
		record2.set("b", "44343");
		recordList.add(record);
		recordList.add(record2);
		
	}
}
