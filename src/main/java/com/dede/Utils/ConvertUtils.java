package com.dede.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>
 * <ul>
 * <li><strong>描述:</strong> 转换工具类</li>
 * <li><strong>类名:</strong> ConvertUtils</li>
 * </ul>
 * </p>
 *
 * @author snowfog shao
 * @date 18-5-3 下午11:43
 */
public class ConvertUtils {
	private static final Logger log = LoggerFactory.getLogger(ConvertUtils.class);

	/**
	 * string转int --无默认值
	 *
	 * @param string 待转string
	 * @return int
	 * @author snowfog shao
	 */
	public static int cInt(String string) {
		return cInt(string, 0);
	}

	/**
	 * string 转int --可指定默认值
	 *
	 * @param string       待转string
	 * @param defaultValue 默认值
	 * @return int
	 * @author snowfog shao
	 */
	public static int cInt(String string, int defaultValue) {
		int value;
		try {
			value = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			log.error("string convert to int failure!!!", e);
			value = defaultValue;
		}
		return value;
	}

	/**
	 * 对象转String
	 *
	 * @param obj 待转对象
	 * @return 返回string 字符串
	 * @author snowfog shao
	 */
	public static String cString(Object obj) {
		return cString(obj, null);
	}

	/**
	 * 对象转String
	 *
	 * @param obj          待转对象
	 * @param defaultValue 默认值
	 * @return 返回string字符串
	 * @author snowfog shao
	 */
	public static String cString(Object obj, String defaultValue) {
		String value = defaultValue;
		try {
			if (obj != null) {
				value = String.valueOf(obj);
			}
		} catch (Exception e) {
			log.error("class cannot convert to String!!!", e);
		}
		return value;
	}
}
