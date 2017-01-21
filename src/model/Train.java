package model;

/**
 * 车次对象
 * @author Administrator
 *
 */

public class Train {

	private String trainCode;
	
	//private String startStationName;
	//private String startStationCode;
	
	//private String endStationName;
	//private String endStationCode;
	
	private String fromStationName;
	//private String fromStationCode;
	
	private String toStationName;
	//private String toStationCode;
	
	private String startTime;
	private String arriveTime;
	
	/*
	 * 无座票数
	 */
	private String wzNum;
	/*
	 * 硬座票数
	 */
	private String yzNum;
	/*
	 * 软座票数
	 */
	private String rzNum;
	/*
	 * 硬卧票数
	 */
	private String ywNum;
	/*
	 * 软卧票数
	 */
	private String rwNum;
	
	public Train(String trainCode,String fromStationName,String toStationName,String startTime,String arriveTime,
			String rwNum,String ywNum,String rzNum,String yzNum,String wzNum){
		this.trainCode=trainCode;
		this.fromStationName=fromStationName;
		this.toStationName=toStationName;
		this.startTime=startTime;
		this.arriveTime=arriveTime;
		this.wzNum=wzNum;
		this.yzNum=yzNum;
		this.rzNum=rzNum;
		this.ywNum=ywNum;
		this.rwNum=rwNum;
	}
	public String getTrainCode(){
		return trainCode;
	}
	public String getFromStationName(){
		return fromStationName;
	}
	public String getToStationName(){
		return toStationName;
	}
	public String getStartTime(){
		return startTime;
	}
	public String getArriveTime(){
		return arriveTime;
	}
	public String getWzNum(){
		return wzNum;
	}
	public String getYzNum(){
		return yzNum;
	}
	public String getRzNum(){
		return rzNum;
	}
	public String getYwNum(){
		return ywNum;
	}
	public String getRwNum(){
		return rwNum;
	}
	
	
}
