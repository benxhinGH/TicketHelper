package log;

/**
 * 打印日志类
 * @author Administrator
 *
 */

public class Log {

	/**
	 * 打印日志方法
	 * @param tag	打印该日志的类名
	 * @param str	日志内容	
	 */
	public static void d(String tag,String str){
		System.out.println(tag+":"+str);
	}
}
