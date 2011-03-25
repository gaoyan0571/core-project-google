package core;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import vo.InfoVO;

/**
 * �̳��� java.util.Hashtable ���࣬��ɶ����ת���Ϳ��ٴ�ȡ�Ĺ���
 * 
 * @author л���
 */
@SuppressWarnings("serial")
public class Record extends Hashtable<String, Object> {

	/**
	 * Ĭ�Ϲ��췽�������ø��๹�췽����ɳ�ʼ��
	 */
	public Record() {
		super();
	}

	/**
	 * ָ����ʼ�����Ĺ��췽�������ø��๹�췽����ɳ�ʼ������ʼ��������ݲ���ֵ��չΪ2����ֵ
	 * 
	 * @param initialCapacity	Record �ĳ�ʼ����
	 */
	public Record(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * ָ������Դ Map ����Ĺ��췽�������ø��๹�췽����ɳ�ʼ�������������ݸ��Ƶ���������
	 * 
	 * @param record	��Ҫ���Ƶ��¶����е�Դ����
	 */
	public Record(Map<String, Object> record) {
		super(record);
	}

	/**
	 * �� Record ������һ�� key-value �Ķ�
	 * 
	 * @param key	Ԫ����
	 * @param value	Ԫ��ֵ
	 */
	public void set(String key, Object value) {

		// HashTable �� value ֵ����Ϊ null
		if (value == null) {
			super.put(key, new Object());
		} else {
			super.put(key, value);
		}
	}

	/**
	 * ����Ԫ�����Ʋ���Ԫ��ֵ��������
	 * 
	 * @param key	Ԫ����
	 * @return Object	���͵�Ԫ��ֵ
	 * @throws NullPointerException	������Ĳ��� key Ϊ��ʱ���׳� NullPointerException
	 */
	public Object get(String key) throws NullPointerException {

		if (key == null) {
			throw new NullPointerException();
		}

		return super.get(key);
	}

	/**
	 * ����Ԫ�������Ҷ���ֵ������ Integer ���ͷ���
	 * 
	 * @param key	Ԫ����
	 * @return Integer	���͵�Ԫ��ֵ
	 * @throws NullPointerException	������Ĳ��� key Ϊ��ʱ���׳� NullPointerException
	 */
	public Integer getInt(String key) {

		if (key == null) {
			throw new NullPointerException();
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
	 * @param key	Ԫ����
	 * @return String	���͵�Ԫ��ֵ
	 * @throws NullPointerException	������Ĳ��� key Ϊ��ʱ���׳� NullPointerException
	 */
	public String getString(String key) {

		if (key == null) {
			throw new NullPointerException();
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
	 * @param key	Ԫ����
	 * @return Long	���͵�Ԫ��ֵ
	 * @throws NullPointerException	������Ĳ��� key Ϊ��ʱ���׳� NullPointerException
	 */
	public Long getLong(String key) {

		if (key == null) {
			throw new NullPointerException();
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
	 * @param key	Ԫ����
	 * @return Double	���͵�Ԫ��ֵ
	 * @throws NullPointerException	������Ĳ��� key Ϊ��ʱ���׳� NullPointerException
	 */
	public Double getDouble(String key) {

		if (key == null) {
			throw new NullPointerException();
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
	 * @param key	Ԫ����
	 * @return Float	���͵�Ԫ��ֵ
	 * @throws NullPointerException	������Ĳ��� key Ϊ��ʱ���׳� NullPointerException
	 */
	public Float getFloat(String key) {

		if (key == null) {
			throw new NullPointerException();
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
	 * @param key	Ԫ����
	 * @return Character	���͵�Ԫ��ֵ
	 * @throws NullPointerException	������Ĳ��� key Ϊ��ʱ���׳� NullPointerException
	 */
	public Character getChar(String key) {

		if (key == null) {
			throw new NullPointerException();
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
	 * @param key	Ԫ����
	 * @return Boolean	���͵�Ԫ��ֵ
	 * @throws NullPointerException	������Ĳ��� key Ϊ��ʱ���׳� NullPointerException
	 */
	public Boolean getBoolean(String key) {

		if (key == null) {
			throw new NullPointerException();
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
	@Override
	public String toString() {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Record = ").append("{");

		// ʹ�� keySet �� Iterator �����б���
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
					.append("; ").append(null == get(key) ? "null" : get(key).getClass()).append("]");
		}

		stringBuffer.append(", Count = ").append(keySet().size()).append("}");

		return stringBuffer.toString();
	}

	/**
	 * �� PO ��ʾ�Ķ���ת���� Record ����
	 * 
	 * @param o	����ת����Դ����
	 * @return	ת����� Record ����
	 * @throws Exception	Field ����Ĵ�ȡ��Ϊ false ʱ�������������� IllegalAccessException
	 */
	public static Record toRecord(Object o) throws Exception {

		Field[] fields = o.getClass().getDeclaredFields();
		Record record = new Record(fields.length);
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
	 * @param record	����ת����Դ����
	 * @param vo	����ת����Ŀ�����
	 * @return	����ת����� VO ����
	 * @throws Exception	Field ����Ĵ�ȡ��Ϊ false ʱ�������������� IllegalAccessException
	 */
	public static Object toVo(Record record, Object vo) throws Exception {

		if (vo == null) {
			throw new NullPointerException();
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
		Record record = new Record();
		record.set("id", 1233L);
		record.set("content", "������ʲô");
		record.set("add_time", "123");
		record.set("intNumber", 1);
		System.out.println(record.get("intNumber").getClass());
		System.out.println(record.get("id"));
		InfoVO vo = new InfoVO();
		vo = (InfoVO) Record.toVo(record, vo);
		System.out.println("vo = " + vo);

		InfoVO infoVo = new InfoVO();
		infoVo.setId(123L);
		infoVo.setContent("����");
		record = Record.toRecord(infoVo);
		System.out.println(record.toString());
	}

}
