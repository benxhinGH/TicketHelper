package main;


import java.util.Map;

import log.Log;
import model.StationToStation;




public class Test {
	
	/*
	 * 存储站点名称到代号的集合
	 */
	public static Map<String,String> stationToCode;
	/*
	 * 出发站名称，测试用
	 */
	public static String fromStationName="天津";
	/*
	 * 目标站名称，测试用
	 */
	public static String toStationName="上海";
	
	
	
	
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
			System.out.println("查无此站");
			System.exit(0);
			
		}
		
		//httpsGet.get(URLib.getLogURL("2017-01-22", "SJP", "XAY", "ADULT"));
		
		String data=httpsGet.get(URLib.getQueryURL("2017-01-22", fromStationCode, toStationCode, "ADULT"));
		
		//Log.d("Test", "返回数据"+data);
		
		
		if(!data.equals("")){
			
			StationToStation sts=new StationToStation(fromStationName,toStationName);
		
		    analyzeData.analyzeSTSData(data, sts);
		
		    sts.print();
		}else{
			System.out.println("查询失败");
		}
		
		
	}

}
