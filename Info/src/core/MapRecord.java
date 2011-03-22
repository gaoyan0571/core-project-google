package core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import vo.InfoVO;

/**
 * 
 * 
 * @author л���
 */
@SuppressWarnings("serial")
public class MapRecord extends HashMap<String, Object> {

	/**
	 * Ĭ�Ϲ��췽�������ø��๹�췽����ɳ�ʼ��
	 */
	public MapRecord() {
		super();
	}

	/**
	 * ָ����ʼ�����Ĺ��췽�������ø��๹�췽����ɳ�ʼ������ʼ��������ݲ���ֵ��չΪ2����ֵ
	 * 
	 * @param initialCapacity
	 *            Record �ĳ�ʼ����
	 */
	public MapRecord(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * ָ������Դ Map ����Ĺ��췽�������ø��๹�췽����ɳ�ʼ�������������ݸ��Ƶ���������
	 * 
	 * @param record
	 *            ��Ҫ���Ƶ��¶����е�Դ����
	 */
	public MapRecord(Map<String, Object> record) {
		super(record);
	}

	/**
	 * �� Record ������һ�� key-value �Ķ�
	 * 
	 * @param key
	 *            Ԫ����
	 * @param value
	 *            Ԫ��ֵ
	 */
	public void set(String key, Object value) {

		super.put(key, value);
	}

	/**
	 * ����Ԫ�����Ʋ���Ԫ��ֵ��������
	 * 
	 * @param key
	 *            Ԫ����
	 * @return Object ���͵�Ԫ��ֵ
	 */
	public Object get(String key) {

		if (key == null) {
			return null;
		}

		return super.get(key);
	}

	/**
	 * ����Ԫ�������Ҷ���ֵ������ Integer ���ͷ���
	 * 
	 * @param key
	 *            Ԫ����
	 * @return Integer ���͵�Ԫ��ֵ
	 */
	public Integer getInt(String key) {

		if (key == null) {
			return 0;
		}

		Object o = get(key);
		if (o instanceof Integer) {
			return (Integer) o;
		} else {
			throw new ClassCastException(key + " ������Ϊ " + o.getClass()
					+ ", Ҫ����� java.lang.Integer��");
		}
	}

	/**
	 * ����Ԫ�������Ҷ���ֵ������ String ���ͷ���
	 * 
	 * @param key
	 *            Ԫ����
	 * @return String ���͵�Ԫ��ֵ
	 */
	public String getString(String key) {

		if (key == null) {
			return "";
		}

		Object o = get(key);
		if (o instanceof String) {
			return (String) o;
		} else {
			throw new ClassCastException(key + " ������Ϊ " + o.getClass()
					+ ", Ҫ����� java.lang.String��");
		}
	}

	/**
	 * ����Ԫ�������Ҷ���ֵ������ Long ���ͷ���
	 * 
	 * @param key
	 *            Ԫ����
	 * @return Long ���͵�Ԫ��ֵ
	 */
	public Long getLong(String key) {

		if (key == null) {
			return 0L;
		}

		Object o = get(key);
		if (o instanceof Long) {
			return (Long) o;
		} else {
			throw new ClassCastException(key + " ������Ϊ " + o.getClass()
					+ ", Ҫ����� java.lang.Long��");
		}
	}

	/**
	 * ����Ԫ�������Ҷ���ֵ������ Double ���ͷ���
	 * 
	 * @param key
	 *            Ԫ����
	 * @return Double ���͵�Ԫ��ֵ
	 */
	public Double getDouble(String key) {

		if (key == null) {
			return 0.0;
		}

		Object o = get(key);
		if (o instanceof Double) {
			return (Double) o;
		} else {
			throw new ClassCastException(key + " ������Ϊ " + o.getClass()
					+ ", Ҫ����� java.lang.Double��");
		}
	}

	/**
	 * ����Ԫ�������Ҷ���ֵ������ Float ���ͷ���
	 * 
	 * @param key
	 *            Ԫ����
	 * @return Float ���͵�Ԫ��ֵ
	 */
	public Float getFloat(String key) {

		if (key == null) {
			return 0.0f;
		}

		Object o = get(key);
		if (o instanceof Float) {
			return (Float) o;
		} else {
			throw new ClassCastException(key + " ������Ϊ " + o.getClass()
					+ ", Ҫ����� java.lang.Float��");
		}
	}

	/**
	 * ����Ԫ�������Ҷ���ֵ������ Character ���ͷ���
	 * 
	 * @param key
	 *            Ԫ����
	 * @return Character ���͵�Ԫ��ֵ
	 */
	public Character getChar(String key) {

		if (key == null) {
			return '0';
		}

		Object o = get(key);
		if (o instanceof Character) {
			return (Character) o;
		} else {
			throw new ClassCastException(key + " ������Ϊ " + o.getClass()
					+ ", Ҫ����� java.lang.Character��");
		}
	}

	/**
	 * ����Ԫ�������Ҷ���ֵ������ Boolean ���ͷ���
	 * 
	 * @param key
	 *            Ԫ����
	 * @return Boolean ���͵�Ԫ��ֵ
	 */
	public Boolean getBoolean(String key) {

		if (key == null) {
			return false;
		}

		Object o = get(key);
		if (o instanceof Boolean) {
			return (Boolean) o;
		} else {
			throw new ClassCastException(key + " ������Ϊ " + o.getClass()
					+ ", Ҫ����� java.lang.Boolean��");
		}
	}

	/**
	 * ���� Record �����е�Ԫ�ظ���
	 * 
	 * @return Ԫ�ظ���
	 */
	public int getSize() {
		return keySet().size();
	}

	/**
	 * ���ַ�����ʽ���� Record �����Ԫ����Ϣ
	 * 
	 * @return ����Ԫ�ص� ���ơ�ֵ������ ���ɵ��ַ���
	 */
	public String getInfoAsString() {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Record = ").append("{");

		Iterator<String> it = keySet().iterator();
		String key;
		boolean isFirstKey = true;
		while (it.hasNext()) {
			key = it.next();
			if (!isFirstKey) {
				stringBuffer.append(", ");
			} else {
				isFirstKey = false;
			}
			stringBuffer.append("[").append(key).append("=").append(get(key))
					.append("; ").append(get(key).getClass()).append("]");
		}

		stringBuffer.append(", Count = ").append(keySet().size()).append("}");

		return stringBuffer.toString();
	}

	/**
	 * �� PO ��ʾ�Ķ���ת���� Record ����
	 * 
	 * @param o
	 *            ����ת����Դ����
	 * @return ת����� Record ����
	 * @throws Exception
	 *             Field ����Ĵ�ȡ��Ϊ false ʱ�������������� IllegalAccessException
	 */
	public static MapRecord toRecord(Object o) throws Exception {

		Field[] fields = o.getClass().getDeclaredFields();
		MapRecord record = new MapRecord(fields.length);
		for (int i = 0; i < fields.length; i++) {

			// ���ɴ�ȡ������Ϊ true
			fields[i].setAccessible(true);
			record.set(fields[i].getName(), fields[i].get(o));
		}

		return record;
	}

	/**
	 * �� Record ��ʾ�Ķ���ת���� VO ����
	 * 
	 * @param record
	 *            ����ת����Դ����
	 * @param vo
	 *            ����ת����Ŀ�����
	 * @return ����ת����� VO ����
	 * @throws Exception
	 *             Field ����Ĵ�ȡ��Ϊ false ʱ�������������� IllegalAccessException
	 */
	public static Object toVo(MapRecord record, Object vo) throws Exception {


		// ������ݽ����� VO û�г�ʼ����������г�ʼ��
		if (vo == null) {
			vo = vo.getClass().newInstance();
		}
		
		Object fieldValue;
		Field[] fields = vo.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			fieldValue = record.get(fields[i].getName());
			if (fieldValue != null) {
				fields[i].set(vo, fieldValue);
			}
		}

		return vo;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MapRecord record = new MapRecord();
		record.set("id", 1233L);
		record.set("content", "������ʲô");
		record.set("add_time", "123");
		record.set("intNumber", 1);
		System.out.println(record.get("intNumber").getClass());
		System.out.println(record.get("id"));
		InfoVO vo = new InfoVO();
		vo = (InfoVO) MapRecord.toVo(record, vo);
		System.out.println("vo = " + vo);

		InfoVO infoVo = new InfoVO();
		infoVo.setId(123L);
		infoVo.setContent("����");
		record = MapRecord.toRecord(infoVo);
		// System.out.println(record.getInfoAsString());
	}

}
