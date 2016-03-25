package Ynzc.Util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * 
 * Covert an Object into a JSON String value.
 * 
 * @author llaiayumi
 * 
 */
public class JSONSupportor
{
	private final static Log log = LogFactory.getLog(JSONSupportor.class);

	private boolean excape = true;

	public void setExcape(boolean excape)
	{
		this.excape = excape;
	}

	/**
	 * parse the Object into JSON String value
	 * 
	 * @param entity
	 *            ----- the entity to parse
	 * @return ----- the JSON value
	 */
	
	public String parseJSON(Object entity) throws Exception
	{
		if (entity == null)
			return "{}";
		StringBuilder sb = new StringBuilder();
		parse(entity, sb);
		if (log.isDebugEnabled())
			log.debug("parse class \"" + entity.getClass().getName() + "\" into the JSON " + sb.toString());
		return sb.toString();
	}

	/**
	 * parse Object, and chose parse function by its class type.
	 * 
	 * @param entity
	 *            ----- the entity to parse
	 * @param sb
	 *            ----- the JSON content buffer
	 */
	private void parse(Object entity, final StringBuilder sb)
	{
		if (entity == null)
		{
			sb.append("null");
			return;
		}
		if (entity instanceof String)
		{
			sb.append('\'');
			if (excape)
				sb.append(parseString(entity.toString()));
			else
				sb.append(entity.toString());
			sb.append('\'');
			return;
		}
		if (entity instanceof Date)
		{
			sb.append(((Date) entity).getTime());
			return;
		}
		if (entity instanceof Number || entity instanceof Boolean)
		{
			sb.append(entity.toString());
			return;
		}

		if (entity instanceof Collection<?>)
		{
			parseCollection((Collection<?>) entity, sb);
			return;
		}
		if (entity instanceof Map<?, ?>)
		{
			parseMap((Map<?, ?>) entity, sb);
			return;
		}
		if (entity instanceof Object[])
		{
			parseArray((Object[]) entity, sb);
			return;
		} else
		{
			parseEntity(entity, sb);
		}
	}

	/**
	 * parse List Object.
	 * 
	 * @param entity
	 *            ----- the entity to parse
	 * @param sb
	 *            ----- the JSON content buffer
	 */
	private void parseCollection(Collection<?> list, final StringBuilder sb)
	{
		if (list == null)
		{
			sb.append("null");
			return;
		}
		if (list.size() < 1)
		{
			sb.append("[]");
			return;
		}
		sb.append("[");
		for (Object o : list)
		{
			parse(o, sb);
			sb.append(",");
		}
		sb.setCharAt(sb.length() - 1, ']');
	}

	/**
	 * parse Map Object.
	 * 
	 * @param entity
	 *            ----- the entity to parse
	 * @param sb
	 *            ----- the JSON content buffer
	 */
	private void parseMap(Map<?, ?> map, final StringBuilder sb)
	{
		if (map == null)
		{
			sb.append("null");
			return;
		}
		if (map.isEmpty())
		{
			sb.append("{}");
			return;
		}
		sb.append("{");
		Set<?> keySet = map.keySet();

		for (Object key : keySet)
		{
			sb.append(key.toString().toLowerCase());
			sb.append(':');
			Object value = map.get(key);
			parse(value, sb);
			sb.append(',');
		}
		sb.setCharAt(sb.length() - 1, '}');
	}

	/**
	 * parse Array Object.
	 * 
	 * @param entity
	 *            ----- the entity to parse
	 * @param sb
	 *            ----- the JSON content buffer
	 */
	private void parseArray(Object[] array, final StringBuilder sb)
	{
		if (array == null)
		{
			sb.append("null");
			return;
		}
		if (array.length < 1)
		{
			sb.append("[]");
			return;
		}
		sb.append('[');
		int len = array.length;
		for (int i = 0; i < len; i++)
		{
			Object o = array[i];
			parse(o, sb);
			sb.append(',');
		}
		sb.setCharAt(sb.length() - 1, ']');
	}

	/**
	 * parse Java Been Object.
	 * 
	 * @param entity
	 *            ----- the entity to parse
	 * @param sb
	 *            ----- the JSON content buffer
	 * 
	 * @see Introspector#getBeanInfo(Class);
	 * @see BeanInfo#getPropertyDescriptors();
	 * @see PropertyDescriptor#getReadMethod();
	 * 
	 */
	private void parseEntity(Object entity, final StringBuilder sb)
	{
		if (entity == null)
			return;
		sb.append('{');

		Class<?> clazz = entity.getClass();
		BeanInfo bean = null;
		try
		{
			bean = Introspector.getBeanInfo(clazz);
		} catch (IntrospectionException e)
		{
			// ignore
			if (log.isDebugEnabled())
				log.debug("Introspector.getBeanInfo(" + clazz.getName() + ")", e);
			//throw new TranslateJSONException(e);
			
		}
		PropertyDescriptor[] properties = bean.getPropertyDescriptors();
		for (PropertyDescriptor p : properties)
		{
			String propertyName = p.getName();
			if ("class".equalsIgnoreCase(propertyName))
			{
				continue;
			}
			sb.append(p.getName());
			sb.append(':');
			Object value = null;
			try
			{
				value = p.getReadMethod().invoke(entity);
			} catch (IllegalArgumentException e)
			{
				if (log.isDebugEnabled())
					log.debug("p.getReadMethod().invoke(" + clazz.getName() + ")", e);
				//throw new TranslateJSONException(e);
			} catch (IllegalAccessException e)
			{
				if (log.isDebugEnabled())
					log.debug("p.getReadMethod().invoke(" + clazz.getName() + ")", e);
				//throw new TranslateJSONException(e);
			} catch (InvocationTargetException e)
			{
				if (log.isDebugEnabled())
					log.debug("p.getReadMethod().invoke(" + clazz.getName() + ")", e);
				//throw new TranslateJSONException(e);
			}
			parse(value, sb);
			sb.append(',');
		}
		sb.setCharAt(sb.length() - 1, '}');
	}

	/**
	 * parse List Object.
	 * 
	 * @param str
	 *            ----- the entity to parse
	 * @return ----- the value of translate String
	 */
	private String parseString(String str)
	{
		return str.replaceAll("\\r", "\\\\\\r").replaceAll("\\n", "\\\\\\n").replaceAll("'", "\\\\'");
	}
}
