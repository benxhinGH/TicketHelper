package model;

import java.util.ArrayList;
import java.util.List;
/**
 * 站到站对象
 * @author Administrator
 *
 */

public class StationToStation {

	/*
	 * 出发站名称
	 */
	private String fromStationName;
	/*
	 * 目标站名称
	 */
	private String toStationName;
	/*
	 * 站到站车次列表，用List存储
	 */
	private List<Train> trainList;
	
	
	
	public StationToStation(String fromStationName,String toStationName){
		this.fromStationName=fromStationName;
		this.toStationName=toStationName;
		trainList=new ArrayList<Train>();
	}
	public String getFromStationName(){
		return fromStationName;
	}
	public String getToStationName(){
		return toStationName;
	}
	/**
	 * 添加车次
	 * @param train
	 */
	public void addTrain(Train train){
		trainList.add(train);
	}
	/**
	 * 打印站到站车次信息
	 */
	public void print(){
		System.out.println(fromStationName+"----->"+toStationName);
		System.out.println("车号"+"	 "+"出发时间"+"	"+"到达时间"+"	"+"软卧"+"	"+"硬卧"+"	"+"软座"+"	"+"硬座"+"	"+"无座");
		for(Train t:trainList){
			System.out.println(t.getTrainCode()+"	"+t.getStartTime()+"	"+t.getArriveTime()+"	"+t.getRwNum()
			+"	"+t.getYwNum()+"	"+t.getRzNum()+"	"+t.getYzNum()+"	"+t.getWzNum());
		}
	}
}
