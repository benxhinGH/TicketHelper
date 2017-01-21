package model;

import java.util.ArrayList;
import java.util.List;
/**
 * վ��վ����
 * @author Administrator
 *
 */

public class StationToStation {

	/*
	 * ����վ����
	 */
	private String fromStationName;
	/*
	 * Ŀ��վ����
	 */
	private String toStationName;
	/*
	 * վ��վ�����б���List�洢
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
	 * ��ӳ���
	 * @param train
	 */
	public void addTrain(Train train){
		trainList.add(train);
	}
	/**
	 * ��ӡվ��վ������Ϣ
	 */
	public void print(){
		System.out.println(fromStationName+"----->"+toStationName);
		System.out.println("����"+"	 "+"����ʱ��"+"	"+"����ʱ��"+"	"+"����"+"	"+"Ӳ��"+"	"+"����"+"	"+"Ӳ��"+"	"+"����");
		for(Train t:trainList){
			System.out.println(t.getTrainCode()+"	"+t.getStartTime()+"	"+t.getArriveTime()+"	"+t.getRwNum()
			+"	"+t.getYwNum()+"	"+t.getRzNum()+"	"+t.getYzNum()+"	"+t.getWzNum());
		}
	}
}
