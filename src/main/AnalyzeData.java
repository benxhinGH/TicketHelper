package main;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import model.StationToStation;
import model.Train;



/*
 * 数据解析类，所有的数据解析方法都添加在此类中
 */
public class AnalyzeData {

	public AnalyzeData(){
		
	}
	/*
	 * 解析站点名称与字母代号
	 */
	public Map<String,String> analyzeStationCode(String data){
		
		/*
		 * 存储站点名称与字母代号对应关系的map集合，该集合在每次程序开始运行时都会生成一次，一旦生成，不可修改
		 */
		final Map<String,String> map=new HashMap<String,String>();
		
		String[] first=data.split("@");
		for(int i=1;i<first.length;++i){
			String[] second=first[i].split("\\|");
			
			map.put(second[1], second[2]);
			
		}
		return map;
	}
	/**
	 * 解析站到站的查询数据，json,测试用
	 * @param data 12306返回的数据
	 */
	public void analyzeSTSData(String data){
		JSONObject jso=new JSONObject(data);
		JSONArray jsa=jso.getJSONArray("data");
		
		for(int i=0;i<jsa.length();++i){
			JSONObject object=jsa.getJSONObject(i).getJSONObject("queryLeftNewDTO");
			String from=object.getString("from_station_name");
			String to=object.getString("to_station_name");
			String code=object.getString("station_train_code");
			
			System.out.println("from:"+from+"  to:"+to+"  code:"+code);
		}
	}
	/**
	 * 解析站到站数据，将车次信息存入sts对象中
	 * @param data  json数据
	 * @param sts   站到站对象
	 */
	public void analyzeSTSData(String data,StationToStation sts){
		JSONObject jso=new JSONObject(data);
		JSONArray jsa=jso.getJSONArray("data");
		
		for(int i=0;i<jsa.length();++i){
			JSONObject object=jsa.getJSONObject(i).getJSONObject("queryLeftNewDTO");
			String trainCode=object.getString("station_train_code");
			String fromStationName=object.getString("from_station_name");
			String toStationName=object.getString("to_station_name");
			String startTime=object.getString("start_time");
			String arriveTime=object.getString("arrive_time");
			String rwNum=object.getString("rw_num");
			String ywNum=object.getString("yw_num");
			String rzNum=object.getString("rz_num");
			String yzNum=object.getString("yz_num");
			String wzNum=object.getString("wz_num");
			sts.addTrain(new Train(trainCode,fromStationName,toStationName,startTime,arriveTime,rwNum,
					ywNum,rzNum,yzNum,wzNum));
		}
	}
}
