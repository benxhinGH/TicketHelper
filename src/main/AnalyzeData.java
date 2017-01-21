package main;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import model.StationToStation;
import model.Train;



/*
 * ���ݽ����࣬���е����ݽ�������������ڴ�����
 */
public class AnalyzeData {

	public AnalyzeData(){
		
	}
	/*
	 * ����վ����������ĸ����
	 */
	public Map<String,String> analyzeStationCode(String data){
		
		/*
		 * �洢վ����������ĸ���Ŷ�Ӧ��ϵ��map���ϣ��ü�����ÿ�γ���ʼ����ʱ��������һ�Σ�һ�����ɣ������޸�
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
	 * ����վ��վ�Ĳ�ѯ���ݣ�json,������
	 * @param data 12306���ص�����
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
	 * ����վ��վ���ݣ���������Ϣ����sts������
	 * @param data  json����
	 * @param sts   վ��վ����
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
