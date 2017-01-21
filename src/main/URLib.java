package main;

/*
 * ����洢url��ַ�ַ�����ͳһ��������ʹ��
 */

public class URLib {

	/*
	 * ��ȡվ����������ĸ���ŵ�url���������ݷ�json����Ҫ���ݾ������ݸ�ʽ����
	 */
	public static final String STATIONTOCODE="https://kyfw.12306.cn/otn/resources/js/framework/station_name.js?station_version=1.8994";
	/**
	 * ��������վ��վ��ѯ��url�ַ���
	 * 
	 * @param data  �˳�����
	 * @param from  ������
	 * @param to    Ŀ�ĵ�
	 * @param adult ����Ʊ���� 
	 * @return		���ɵĲ�ѯurl�ַ���
	 */
	public static final String getQueryURL(String data,String from,String to,String adult){
		return "https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date="+data
				+ "&leftTicketDTO.from_station="+from+"&leftTicketDTO.to_station="+to+"&purpose_codes="+adult;
	}
	/**
     *����log������ַ�������ѯǰ��Ҫ�ȷ���log���󣬿����Ƿ�������¼��־֮�������log�����ַ������ѯ�����ַ���ֻ����һ�����ʣ�
     *������getQueryURL������ͬ��
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
