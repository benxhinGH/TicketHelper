package main;

/*
 * 此类存储url地址字符串，统一管理，便于使用
 */

public class URLib {

	/*
	 * 获取站点名称与字母代号的url，返回数据非json，需要根据具体数据格式解析
	 */
	public static final String STATIONTOCODE="https://kyfw.12306.cn/otn/resources/js/framework/station_name.js?station_version=1.8994";
	/**
	 * 用于生成站到站查询的url字符串
	 * 
	 * @param data  乘车日期
	 * @param from  出发地
	 * @param to    目的地
	 * @param adult 成人票代码 
	 * @return		生成的查询url字符串
	 */
	public static final String getQueryURL(String data,String from,String to,String adult){
		return "https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date="+data
				+ "&leftTicketDTO.from_station="+from+"&leftTicketDTO.to_station="+to+"&purpose_codes="+adult;
	}
	/**
     *生成log请求的字符串，查询前需要先发送log请求，可能是服务器记录日志之类的需求，log请求字符串与查询请求字符串只差了一个单词，
     *参数与getQueryURL方法相同。
	 * @param data
	 * @param from
	 * @param to
	 * @param adult
	 * @return
	 */
//	public static final String getLogURL(String data,String from,String to,String adult){
//		return "https://kyfw.12306.cn/otn/leftTicket/log?leftTicketDTO.train_date="+data
//				+ "&leftTicketDTO.from_station="+from+"&leftTicketDTO.to_station="+to+"&purpose_codes="+adult;
//	}
}
