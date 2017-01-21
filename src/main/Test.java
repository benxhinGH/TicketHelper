package main;


import java.util.Map;

import log.Log;
import model.StationToStation;




public class Test {
	
	/*
	 * �洢վ�����Ƶ����ŵļ���
	 */
	public static Map<String,String> stationToCode;
	/*
	 * ����վ���ƣ�������
	 */
	public static String fromStationName="���";
	/*
	 * Ŀ��վ���ƣ�������
	 */
	public static String toStationName="�Ϻ�";
	
	
	
	
	public static void main(String[] arg){
		
		String fromStationCode;
		String toStationCode;
		
		MyHttpsGet httpsGet=new MyHttpsGet();
		
		AnalyzeData analyzeData=new AnalyzeData();
		
		String stcData=httpsGet.get(URLib.STATIONTOCODE);
		
		stationToCode=analyzeData.analyzeStationCode(stcData);
		
		fromStationCode=stationToCode.get(fromStationName);
		toStationCode=stationToCode.get(toStationName);
		if(fromStationCode==null||toStationCode==null){
			System.out.println("���޴�վ");
			System.exit(0);
			
		}
		
		//httpsGet.get(URLib.getLogURL("2017-01-22", "SJP", "XAY", "ADULT"));
		
		String data=httpsGet.get(URLib.getQueryURL("2017-01-22", fromStationCode, toStationCode, "ADULT"));
		
		//Log.d("Test", "��������"+data);
		
		
		if(!data.equals("")){
			
			StationToStation sts=new StationToStation(fromStationName,toStationName);
		
		    analyzeData.analyzeSTSData(data, sts);
		
		    sts.print();
		}else{
			System.out.println("��ѯʧ��");
		}
		
		
	}

}
